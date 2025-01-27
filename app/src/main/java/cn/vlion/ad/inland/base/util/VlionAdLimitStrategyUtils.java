package cn.vlion.ad.inland.base.util;

import android.content.Context;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionAdLimitStrategyBean;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionAdLimitStrategySP;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class VlionAdLimitStrategyUtils {
    private static volatile VlionAdLimitStrategyUtils instance;
    private ConcurrentHashMap<String, VlionAdLimitStrategyBean> arrayMapSP = new ConcurrentHashMap<>();
    private String sprefreshdate = "";

    public interface AdLimitStrategyListener {
        void initCompleted();
    }

    public static synchronized VlionAdLimitStrategyUtils getInstance() {
        VlionAdLimitStrategyUtils vlionAdLimitStrategyUtils;
        synchronized (VlionAdLimitStrategyUtils.class) {
            try {
                if (instance == null) {
                    synchronized (VlionAdLimitStrategyUtils.class) {
                        try {
                            if (instance == null) {
                                instance = new VlionAdLimitStrategyUtils();
                            }
                        } finally {
                        }
                    }
                }
                vlionAdLimitStrategyUtils = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vlionAdLimitStrategyUtils;
    }

    private void initData(Context context) {
        if (context != null) {
            try {
                Map<String, ?> initSpgetAll = VlionAdLimitStrategySP.getInstance().initSpgetAll(context);
                Set<String> keySet = initSpgetAll.keySet();
                this.arrayMapSP = new ConcurrentHashMap<>();
                if (VlionAdLimitStrategySP.getInstance().getADLimitStrategysIdRreshdate()) {
                    for (String str : keySet) {
                        Object obj = initSpgetAll.get(str);
                        String obj2 = obj != null ? obj.toString() : "";
                        if ("refreshdate".equals(str)) {
                            this.sprefreshdate = obj2;
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils - 缓存日期 =" + str + "   value = " + obj2);
                        } else if (!TextUtils.isEmpty(obj2)) {
                            String decrypt = VlionAESUtils.decrypt(obj2, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils  -SharedPreferences 缓存数据 key =" + str + "   value = " + decrypt);
                            try {
                                if (!TextUtils.isEmpty(decrypt)) {
                                    VlionAdLimitStrategyBean vlionAdLimitStrategyBean = (VlionAdLimitStrategyBean) new Gson().fromJson(decrypt, VlionAdLimitStrategyBean.class);
                                    LogVlion.e("频控策略 : VlionAdLimitStrategyUtils  - 缓存的广告位ID. =" + vlionAdLimitStrategyBean.getShowId());
                                    this.arrayMapSP.put(str, vlionAdLimitStrategyBean);
                                }
                            } catch (JsonSyntaxException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public VlionAdLimitStrategyBean getStrategyBean(String str) {
        if (this.arrayMapSP == null || str == null) {
            return new VlionAdLimitStrategyBean();
        }
        String dateFormatDay = VlionDateUtils.dateFormatDay();
        StringBuilder a10 = l1.a("频控策略 : VlionAdLimitStrategyUtils - 获取策略 --缓存日期=");
        a10.append(this.sprefreshdate);
        a10.append(" 当前日期 = ");
        a10.append(dateFormatDay);
        LogVlion.e(a10.toString());
        if (!this.sprefreshdate.isEmpty() && !TextUtils.equals(dateFormatDay, this.sprefreshdate)) {
            this.arrayMapSP.clear();
            VlionAdLimitStrategySP.getInstance().clearSP();
            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils - 缓存日期 =" + this.sprefreshdate + " 当前日期 = " + dateFormatDay + " 数据过期，已清理 -");
        }
        ConcurrentHashMap<String, VlionAdLimitStrategyBean> concurrentHashMap = this.arrayMapSP;
        if (concurrentHashMap != null && concurrentHashMap.get(str) != null) {
            return this.arrayMapSP.get(str);
        }
        VlionAdLimitStrategyBean vlionAdLimitStrategyBean = new VlionAdLimitStrategyBean();
        vlionAdLimitStrategyBean.setShowId(str);
        this.arrayMapSP.put(str, vlionAdLimitStrategyBean);
        return this.arrayMapSP.get(str);
    }

    public void regroupAdStrategysIdList(Context context) {
        try {
            ConcurrentHashMap<String, VlionAdLimitStrategyBean> concurrentHashMap = this.arrayMapSP;
            if (concurrentHashMap != null && concurrentHashMap.size() >= 1) {
                String dateFormatDay = VlionDateUtils.dateFormatDay();
                if (this.sprefreshdate.isEmpty() || TextUtils.equals(dateFormatDay, this.sprefreshdate)) {
                    return;
                }
                this.arrayMapSP.clear();
                VlionAdLimitStrategySP.getInstance().clearSP();
                LogVlion.e("频控策略 : VlionAdLimitStrategyUtils  regroupAdStrategysIdList- 缓存日期 =" + this.sprefreshdate + " 当前日期 = " + dateFormatDay + " 数据过期，已清理 -");
                return;
            }
            initData(context);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setLimitStrategyBean(String str, String str2) {
        try {
            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -获取广告位缓存 ==" + str + "  AdSrcName =" + str2);
            VlionAdLimitStrategyBean strategyBean = getStrategyBean(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("频控策略 : VlionAdLimitStrategyUtils - 取出缓存广告数据 ==");
            sb2.append(strategyBean.getShowId());
            LogVlion.e(sb2.toString());
            if (strategyBean.getAdLimitStrategyBean() != null) {
                LogVlion.e("频控策略 : VlionAdLimitStrategyUtils  取出缓存 数据 LimitStrategyBean size ==" + strategyBean.getAdLimitStrategyBean().size());
                if (strategyBean.getAdLimitStrategyBean().size() != 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    LogVlion.e("频控策略 : VlionAdLimitStrategyUtils- 缓存频次增加 Lasttime ==" + currentTimeMillis);
                    Iterator<VlionAdLimitStrategyBean.AdLimitStrategyBean> it = strategyBean.getAdLimitStrategyBean().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        VlionAdLimitStrategyBean.AdLimitStrategyBean next = it.next();
                        if (TextUtils.isEmpty(str2)) {
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -缓存  ");
                            next.setCount(next.getCount() + 1);
                            next.setLasttime(currentTimeMillis);
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -缓存 频次增加 Count ==" + next.getCount() + "  AdSrcName ==" + next.getAdSrcName());
                        } else if (next.getAdSrcName().equals(str2)) {
                            next.setCount(next.getCount() + 1);
                            next.setLasttime(currentTimeMillis);
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -缓存 WaterFall ");
                            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -缓存 频次增加 Count ==" + next.getCount() + "  AdSrcName ==" + next.getAdSrcName());
                            break;
                        }
                    }
                } else {
                    LogVlion.e("频控策略 : VlionAdLimitStrategyUtils - 服务器没有设置频控策略 ==");
                    return;
                }
            }
            this.arrayMapSP.put(str, strategyBean);
            String json = new Gson().toJson(strategyBean);
            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -更新本地SP 文件  ==" + json);
            String encrypt = VlionAESUtils.encrypt(json, HttpRequestUtil.KEY, HttpRequestUtil.IV);
            this.sprefreshdate = VlionDateUtils.dateFormatDay();
            LogVlion.e("频控策略 : VlionAdLimitStrategyUtils -更新本地缓存日期 ==" + this.sprefreshdate);
            VlionAdLimitStrategySP.getInstance().setADStrategysData(str, encrypt);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
