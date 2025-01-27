package cn.vlion.ad.inland.base.util;

import android.content.Context;
import android.text.TextUtils;
import c7.g;
import cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionAdStrategySharedPreferences;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VlionAdStrategyUtils {
    public static final long TIME_INTERVAL = 10000;
    private static volatile VlionAdStrategyUtils instance;
    private ConcurrentHashMap<String, VlionAdClickStrategyBean> arrayMapSP;
    private String sprefreshdate = "";
    private long mLastClickTime = 0;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f3400a;

        public a(Context context) {
            this.f3400a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f3400a != null) {
                    Map<String, ?> initSpgetAll = VlionAdStrategySharedPreferences.getInstance().initSpgetAll(this.f3400a);
                    Set<String> keySet = initSpgetAll.keySet();
                    VlionAdStrategyUtils.this.arrayMapSP = new ConcurrentHashMap();
                    if (VlionAdStrategySharedPreferences.getInstance().getADStrategysIdRreshdate()) {
                        for (String str : keySet) {
                            Object obj = initSpgetAll.get(str);
                            String obj2 = obj != null ? obj.toString() : "";
                            if ("refreshdate".equals(str)) {
                                VlionAdStrategyUtils.this.sprefreshdate = obj2;
                                LogVlion.e("端策略 : VlionAdStrategyUtils  SharedPreferences  key =" + str + "   value = " + obj2);
                            } else if (!TextUtils.isEmpty(obj2)) {
                                String decrypt = VlionAESUtils.decrypt(obj2, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                                LogVlion.e("端策略 : VlionAdStrategyUtils  SharedPreferences  key =" + str + "   value = " + decrypt);
                                try {
                                    if (!TextUtils.isEmpty(decrypt)) {
                                        JSONObject jSONObject = new JSONObject(decrypt);
                                        VlionAdClickStrategyBean vlionAdClickStrategyBean = new VlionAdClickStrategyBean();
                                        vlionAdClickStrategyBean.setCount(jSONObject.getInt(g.f1744b));
                                        vlionAdClickStrategyBean.setClickLasttime(jSONObject.getLong("clickLasttime"));
                                        vlionAdClickStrategyBean.setAdx_tagid(jSONObject.getString("adx_tagid"));
                                        VlionAdStrategyUtils.this.arrayMapSP.put(str, vlionAdClickStrategyBean);
                                    }
                                } catch (JSONException e10) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static synchronized VlionAdStrategyUtils getInstance() {
        VlionAdStrategyUtils vlionAdStrategyUtils;
        synchronized (VlionAdStrategyUtils.class) {
            try {
                if (instance == null) {
                    synchronized (VlionAdStrategyUtils.class) {
                        try {
                            if (instance == null) {
                                instance = new VlionAdStrategyUtils();
                            }
                        } finally {
                        }
                    }
                }
                vlionAdStrategyUtils = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vlionAdStrategyUtils;
    }

    private void initData(Context context) {
        try {
            VlionTimer.getInstance().startTimer(0L, new a(context));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionAdClickStrategyBean getStrategyBean(String str) {
        ConcurrentHashMap<String, VlionAdClickStrategyBean> concurrentHashMap;
        return (str == null || (concurrentHashMap = this.arrayMapSP) == null || concurrentHashMap.get(str) == null) ? new VlionAdClickStrategyBean() : this.arrayMapSP.get(str);
    }

    public void regroupAdStrategysIdList(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime < 10000) {
                LogVlion.e("端策略 : 10000 期间不能重复调用  当前调用间隔为 " + (currentTimeMillis - this.mLastClickTime) + " 毫秒");
                return;
            }
            if (this.arrayMapSP == null) {
                initData(context);
                return;
            }
            String dateFormatDay = VlionDateUtils.dateFormatDay();
            if (this.sprefreshdate.isEmpty() || TextUtils.equals(dateFormatDay, this.sprefreshdate)) {
                return;
            }
            this.arrayMapSP.clear();
            VlionAdStrategySharedPreferences.getInstance().clearSP();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setStrategyBean(String str) {
        try {
            if (this.arrayMapSP != null && str != null) {
                VlionAdClickStrategyBean strategyBean = getStrategyBean(str);
                strategyBean.setCount(strategyBean.getCount() + 1);
                strategyBean.setClickLasttime(System.currentTimeMillis() / 1000);
                strategyBean.setAdx_tagid(str);
                this.arrayMapSP.put(str, strategyBean);
                String json = new Gson().toJson(strategyBean);
                LogVlion.e("端策略 : VlionAdStrategyUtils 更新 strategyBeanStr==" + json);
                VlionAdStrategySharedPreferences.getInstance().setADStrategysData(str, VlionAESUtils.encrypt(json, HttpRequestUtil.KEY, HttpRequestUtil.IV));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
