package cn.vlion.ad.inland.base.util;

import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class StrategysIdUtils {
    public static final long TIME_INTERVAL = 5000;
    private static volatile StrategysIdUtils instance = null;
    private static final String keylogDate = "logDate";
    private static final String keypackageName = "packageName";
    private List<String> mlocalInstallList = Collections.synchronizedList(new ArrayList());
    private final List<String> StrategysIdList = Collections.synchronizedList(new ArrayList());
    private List<VlionServiceConfig.DataBean.ActiveStrategyBean> unActivatedStrategysIdList = Collections.synchronizedList(new ArrayList());
    private List<VlionServiceConfig.DataBean.ActiveStrategyBean> ActivatedStrategysIdList = Collections.synchronizedList(new ArrayList());
    private List<VlionServiceConfig.DataBean.ActiveStrategyBean> UnInstallStrategysIdList = Collections.synchronizedList(new ArrayList());
    private String spLogAppActivated = "";
    private long mLastClickTime = 0;

    private List<String> checkLocalisAppInstalled(List<VlionServiceConfig.DataBean.ActiveStrategyBean> list) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(VlionAppInfo.getInstance().getPackageName(VlionSDkManager.getInstance().getApplication()));
            if (list != null) {
                for (VlionServiceConfig.DataBean.ActiveStrategyBean activeStrategyBean : list) {
                    if (!arrayList.contains(activeStrategyBean.getPackageName()) && VlionDeviceInfo.getInstance().isAppInstalled(VlionSDkManager.getInstance().getApplication(), activeStrategyBean.getPackageName())) {
                        arrayList.add(activeStrategyBean.getPackageName());
                        LogVlion.e("拉活策略 :  主动判断  已安装包名  ==" + activeStrategyBean.getPackageName());
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return arrayList;
    }

    public static synchronized StrategysIdUtils getInstance() {
        StrategysIdUtils strategysIdUtils;
        synchronized (StrategysIdUtils.class) {
            try {
                if (instance == null) {
                    synchronized (StrategysIdUtils.class) {
                        try {
                            if (instance == null) {
                                instance = new StrategysIdUtils();
                            }
                        } finally {
                        }
                    }
                }
                strategysIdUtils = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strategysIdUtils;
    }

    public void InitVlionSDKConfig(List<String> list, List<VlionServiceConfig.DataBean.ActiveStrategyBean> list2) {
        StringBuilder sb2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime < 5000) {
                LogVlion.e("拉活策略 : 5000 期间不能重复调用  当前调用间隔为 " + (currentTimeMillis - this.mLastClickTime) + " 毫秒");
                return;
            }
            this.mLastClickTime = currentTimeMillis;
            if (list == null || list.size() <= 1) {
                list = checkLocalisAppInstalled(list2);
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            this.unActivatedStrategysIdList.clear();
            this.ActivatedStrategysIdList.clear();
            this.UnInstallStrategysIdList.clear();
            this.mlocalInstallList = list;
            LogVlion.e("拉活策略 :  serviceActiveStrategyList  size ==" + list2.size());
            for (VlionServiceConfig.DataBean.ActiveStrategyBean activeStrategyBean : list2) {
                if (list.contains(activeStrategyBean.getPackageName())) {
                    if (activeStrategyBean.getIsInstall() == 1 && activeStrategyBean.getIsActive() == 0) {
                        this.unActivatedStrategysIdList.add(activeStrategyBean);
                        LogVlion.e("拉活策略 :  unActivatedStrategysIdList  已安装 未拉活 ==" + activeStrategyBean.getPackageName() + " ID:" + activeStrategyBean.getId());
                    }
                    if (activeStrategyBean.getIsInstall() == 1 && activeStrategyBean.getIsActive() == 1) {
                        this.ActivatedStrategysIdList.add(activeStrategyBean);
                        sb2 = new StringBuilder();
                        sb2.append("拉活策略 :  ActivatedStrategysIdList  已安装 已拉活 ==");
                        sb2.append(activeStrategyBean.getPackageName());
                        sb2.append(" ID:");
                        sb2.append(activeStrategyBean.getId());
                        LogVlion.e(sb2.toString());
                    }
                } else if (activeStrategyBean.getIsInstall() == 0 && activeStrategyBean.getIsActive() == 0) {
                    this.UnInstallStrategysIdList.add(activeStrategyBean);
                    sb2 = new StringBuilder();
                    sb2.append("拉活策略 :  ActivatedStrategysIdList  未安装 未拉活 ==");
                    sb2.append(activeStrategyBean.getPackageName());
                    sb2.append(" ID:");
                    sb2.append(activeStrategyBean.getId());
                    LogVlion.e(sb2.toString());
                }
            }
            regroupStrategysIdList("");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public synchronized List<String> getStrategysIdList() {
        return this.StrategysIdList;
    }

    public ArrayList<String> jsonArrayToArrayList(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (VlionDateUtils.dateFormatDay().equals(jSONObject.getString(keylogDate))) {
                    arrayList.add(jSONObject.getString("packageName"));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008b A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0001, B:5:0x001a, B:8:0x0022, B:10:0x002b, B:13:0x006c, B:15:0x008b, B:17:0x0098, B:19:0x009e, B:21:0x00a4, B:25:0x00ac, B:26:0x00cf, B:27:0x0110, B:29:0x0116, B:32:0x011e, B:43:0x014d, B:44:0x0153, B:46:0x0159, B:49:0x0161, B:52:0x016f, B:55:0x017b, B:35:0x01ab, B:38:0x01b7, B:64:0x01e7, B:65:0x01ed, B:67:0x01f3, B:70:0x0205, B:75:0x020f, B:77:0x0249, B:80:0x027d, B:81:0x00ca, B:82:0x0035, B:84:0x005a, B:86:0x0060, B:87:0x02a2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0116 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0001, B:5:0x001a, B:8:0x0022, B:10:0x002b, B:13:0x006c, B:15:0x008b, B:17:0x0098, B:19:0x009e, B:21:0x00a4, B:25:0x00ac, B:26:0x00cf, B:27:0x0110, B:29:0x0116, B:32:0x011e, B:43:0x014d, B:44:0x0153, B:46:0x0159, B:49:0x0161, B:52:0x016f, B:55:0x017b, B:35:0x01ab, B:38:0x01b7, B:64:0x01e7, B:65:0x01ed, B:67:0x01f3, B:70:0x0205, B:75:0x020f, B:77:0x0249, B:80:0x027d, B:81:0x00ca, B:82:0x0035, B:84:0x005a, B:86:0x0060, B:87:0x02a2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f3 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0001, B:5:0x001a, B:8:0x0022, B:10:0x002b, B:13:0x006c, B:15:0x008b, B:17:0x0098, B:19:0x009e, B:21:0x00a4, B:25:0x00ac, B:26:0x00cf, B:27:0x0110, B:29:0x0116, B:32:0x011e, B:43:0x014d, B:44:0x0153, B:46:0x0159, B:49:0x0161, B:52:0x016f, B:55:0x017b, B:35:0x01ab, B:38:0x01b7, B:64:0x01e7, B:65:0x01ed, B:67:0x01f3, B:70:0x0205, B:75:0x020f, B:77:0x0249, B:80:0x027d, B:81:0x00ca, B:82:0x0035, B:84:0x005a, B:86:0x0060, B:87:0x02a2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0249 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0001, B:5:0x001a, B:8:0x0022, B:10:0x002b, B:13:0x006c, B:15:0x008b, B:17:0x0098, B:19:0x009e, B:21:0x00a4, B:25:0x00ac, B:26:0x00cf, B:27:0x0110, B:29:0x0116, B:32:0x011e, B:43:0x014d, B:44:0x0153, B:46:0x0159, B:49:0x0161, B:52:0x016f, B:55:0x017b, B:35:0x01ab, B:38:0x01b7, B:64:0x01e7, B:65:0x01ed, B:67:0x01f3, B:70:0x0205, B:75:0x020f, B:77:0x0249, B:80:0x027d, B:81:0x00ca, B:82:0x0035, B:84:0x005a, B:86:0x0060, B:87:0x02a2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027d A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0001, B:5:0x001a, B:8:0x0022, B:10:0x002b, B:13:0x006c, B:15:0x008b, B:17:0x0098, B:19:0x009e, B:21:0x00a4, B:25:0x00ac, B:26:0x00cf, B:27:0x0110, B:29:0x0116, B:32:0x011e, B:43:0x014d, B:44:0x0153, B:46:0x0159, B:49:0x0161, B:52:0x016f, B:55:0x017b, B:35:0x01ab, B:38:0x01b7, B:64:0x01e7, B:65:0x01ed, B:67:0x01f3, B:70:0x0205, B:75:0x020f, B:77:0x0249, B:80:0x027d, B:81:0x00ca, B:82:0x0035, B:84:0x005a, B:86:0x0060, B:87:0x02a2), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void regroupStrategysIdList(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.StrategysIdUtils.regroupStrategysIdList(java.lang.String):void");
    }
}
