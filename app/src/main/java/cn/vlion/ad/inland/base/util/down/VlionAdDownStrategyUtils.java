package cn.vlion.ad.inland.base.util.down;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.m0;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class VlionAdDownStrategyUtils {
    public static final long TIME_INTERVAL = 10000;
    private static volatile VlionAdDownStrategyUtils instance;
    private ConcurrentHashMap<String, Long> arrayMapSP;
    private String sprefreshdate = "";
    private final int singleClkLimit = 1;
    private long mLastClickTime = 0;

    public interface AdDownStrategyListener {
        void initCompleted();
    }

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f3406a;

        /* renamed from: b */
        public final /* synthetic */ AdDownStrategyListener f3407b;

        public a(Context context, AdDownStrategyListener adDownStrategyListener) {
            this.f3406a = context;
            this.f3407b = adDownStrategyListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00ed A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0042 A[Catch: all -> 0x0026, TryCatch #1 {all -> 0x0026, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x002a, B:9:0x0042, B:10:0x0046, B:12:0x004c, B:44:0x0060, B:16:0x008a, B:40:0x00c5, B:21:0x00e7, B:24:0x00ed, B:32:0x00de, B:52:0x001e, B:36:0x0094, B:29:0x00d0, B:49:0x000f), top: B:1:0x0000, inners: #0, #2, #3 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 301
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils.a.run():void");
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f3409a;

        /* renamed from: b */
        public final /* synthetic */ VlionServiceConfig.AutoBean f3410b;

        /* renamed from: c */
        public final /* synthetic */ boolean f3411c;

        public b(long j10, VlionServiceConfig.AutoBean autoBean, boolean z10) {
            this.f3409a = j10;
            this.f3410b = autoBean;
            this.f3411c = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VlionAdDownStrategyUtils vlionAdDownStrategyUtils;
            try {
                LogVlion.e("Down 策略 :  定时任务开始执行  已延迟 " + this.f3409a + " 毫秒  包名： " + this.f3410b.getBundle());
                VlionServiceConfig.AutoBean autoBean = this.f3410b;
                if (autoBean == null || autoBean.getExp() == null || this.f3410b.getExp().getScenes() == null || this.f3410b.getExp().getScenes().size() <= 0) {
                    return;
                }
                Iterator<VlionServiceConfig.ScenesBean> it = this.f3410b.getExp().getScenes().iterator();
                while (it.hasNext()) {
                    VlionServiceConfig.ScenesBean next = it.next();
                    if (this.f3411c) {
                        if (next.getId() == 1) {
                            vlionAdDownStrategyUtils = VlionAdDownStrategyUtils.this;
                            vlionAdDownStrategyUtils.submitTrakersSync(this.f3410b, next);
                        }
                    } else if (next.getId() == 0 || next.getId() == 2) {
                        vlionAdDownStrategyUtils = VlionAdDownStrategyUtils.this;
                        vlionAdDownStrategyUtils.submitTrakersSync(this.f3410b, next);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static synchronized VlionAdDownStrategyUtils getInstance() {
        VlionAdDownStrategyUtils vlionAdDownStrategyUtils;
        synchronized (VlionAdDownStrategyUtils.class) {
            try {
                if (instance == null) {
                    synchronized (VlionAdDownStrategyUtils.class) {
                        try {
                            if (instance == null) {
                                instance = new VlionAdDownStrategyUtils();
                            }
                        } finally {
                        }
                    }
                }
                vlionAdDownStrategyUtils = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vlionAdDownStrategyUtils;
    }

    private void initData(Context context, AdDownStrategyListener adDownStrategyListener) {
        try {
            VlionTimer.getInstance().startTimer(0L, new a(context, adDownStrategyListener));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void submitTrakersSync(VlionServiceConfig.AutoBean autoBean, VlionServiceConfig.ScenesBean scenesBean) {
        VlionServiceConfig.AutoBean autoBean2;
        VlionServiceConfig.ScenesBean scenesBean2;
        try {
            int needRta = scenesBean.getNeedRta();
            LogVlion.e("Down 策略 :  ------------getBundle ===== " + autoBean.getBundle() + " ----------id= " + scenesBean.getId());
            int i10 = (autoBean.getExp() == null || autoBean.getExp().getType() == null || !autoBean.getExp().getType().equals("duizhao")) ? 0 : 1;
            int rtaCacheTime = VlionServiceConfigParse.getInstance().getAutoAttribution().getRtaCacheTime();
            long longValue = getStrategyBeanCount(autoBean.getBundle() + "_v_install_time").longValue();
            long j10 = (long) rtaCacheTime;
            if (longValue + j10 > VlionDateUtils.dateFormatMinute() && scenesBean.getFilterinstalled() == 1) {
                LogVlion.e("Down 策略 :  ---" + autoBean.getBundle() + "----缓存时间内 已经上报安装打点   不再重复上报  ===rtaCacheTime== " + rtaCacheTime + " ----------installtime = " + longValue + "---current time ==" + VlionDateUtils.dateFormatMinute());
                return;
            }
            if (getStrategyBeanCount(autoBean.getBundle() + autoBean.getPid() + scenesBean.getId() + "_v_rta_time").longValue() + j10 > VlionDateUtils.dateFormatMinute()) {
                if (getStrategyBeanCount(autoBean.getBundle() + autoBean.getPid() + scenesBean.getId() + "_v_rta").longValue() == 0) {
                    return;
                }
                autoBean2 = autoBean;
                scenesBean2 = scenesBean;
                needRta = 0;
            } else {
                autoBean2 = autoBean;
                scenesBean2 = scenesBean;
            }
            HttpRequestUtil.submitTrakersSync(autoBean2, scenesBean2, needRta, i10);
            if (scenesBean.getId() == 1) {
                setDownStrategyBean(autoBean.getBundle() + "_v_install_time", VlionDateUtils.dateFormatMinute());
                LogVlion.e("Down 策略 :  ------" + autoBean.getBundle() + " 已记录安装时间===VlionDateUtils.dateFormatMinute()== " + VlionDateUtils.dateFormatMinute());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public Long getStrategyBeanCount(String str) {
        try {
            if (this.arrayMapSP != null && str != null) {
                String dateFormatDay = VlionDateUtils.dateFormatDay();
                if (!this.sprefreshdate.isEmpty() && !TextUtils.equals(dateFormatDay, this.sprefreshdate)) {
                    this.arrayMapSP.clear();
                    m0 b10 = m0.b();
                    b10.getClass();
                    try {
                        SharedPreferences sharedPreferences = b10.f3088a;
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.clear();
                            edit.apply();
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    LogVlion.e("Down 策略 : VlionAdDownStrategyUtils - 缓存日期 =" + this.sprefreshdate + " 当前日期 = " + dateFormatDay + " 数据过期，已清理 -");
                }
                ConcurrentHashMap<String, Long> concurrentHashMap = this.arrayMapSP;
                if (concurrentHashMap != null && concurrentHashMap.get(str) != null) {
                    return this.arrayMapSP.get(str);
                }
                this.arrayMapSP.put(str, 0L);
                return this.arrayMapSP.get(str);
            }
            return 0L;
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
            return 0L;
        }
    }

    public void regroupAdDownStrategysIdList(Context context, AdDownStrategyListener adDownStrategyListener) {
        long currentTimeMillis;
        try {
            currentTimeMillis = System.currentTimeMillis();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (currentTimeMillis - this.mLastClickTime < 10000) {
            LogVlion.e("Down 策略 : 10000 期间不能重复调用  当前调用间隔为 " + (currentTimeMillis - this.mLastClickTime) + " 毫秒");
            return;
        }
        this.mLastClickTime = currentTimeMillis;
        if (this.arrayMapSP == null) {
            initData(context, adDownStrategyListener);
            return;
        }
        LogVlion.e("Down 策略 : VlionAdDownStrategyUtils  arrayMapSP.size() == " + this.arrayMapSP.size());
        String dateFormatDay = VlionDateUtils.dateFormatDay();
        if (!this.sprefreshdate.isEmpty() && !TextUtils.equals(dateFormatDay, this.sprefreshdate)) {
            this.arrayMapSP.clear();
            m0 b10 = m0.b();
            b10.getClass();
            try {
                SharedPreferences sharedPreferences = b10.f3088a;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.clear();
                    edit.apply();
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
            LogVlion.e("Down 策略 : VlionAdDownStrategyUtils  regroupAdStrategysIdList- 缓存日期 =" + this.sprefreshdate + " 当前日期 = " + dateFormatDay + " 数据过期，已清理 -");
        }
        if (adDownStrategyListener != null) {
            adDownStrategyListener.initCompleted();
        }
    }

    public void setDownStrategyBean(String str, long j10) {
        try {
            ConcurrentHashMap<String, Long> concurrentHashMap = this.arrayMapSP;
            if (concurrentHashMap != null && str != null) {
                concurrentHashMap.put(str, Long.valueOf(j10));
                LogVlion.e("Down 策略 : VlionAdDownStrategyUtils -更新本地SP 文件  ==" + str);
                String encrypt = VlionAESUtils.encrypt(str, HttpRequestUtil.KEY, HttpRequestUtil.IV);
                this.sprefreshdate = VlionDateUtils.dateFormatDay();
                LogVlion.e("Down 策略 : VlionAdDownStrategyUtils -更新本地缓存日期 ==" + this.sprefreshdate + " 名称：" + str + " AES名称：" + encrypt + " value ：" + j10);
                m0.b().a(encrypt, j10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void startEventUpload() {
        try {
            if (VlionServiceConfigParse.getInstance().getAutoAttribution() == null || VlionServiceConfigParse.getInstance().getAutos() == null) {
                return;
            }
            int adjacentIntervalsMin = VlionServiceConfigParse.getInstance().getAutoAttribution().getAdjacentIntervalsMin();
            int adjacentIntervalsMax = VlionServiceConfigParse.getInstance().getAutoAttribution().getAdjacentIntervalsMax() - adjacentIntervalsMin;
            Random random = new Random();
            LogVlion.e("Down 策略 : ------数量------" + VlionServiceConfigParse.getInstance().getAutos().size());
            int i10 = 0;
            for (VlionServiceConfig.AutoBean autoBean : VlionServiceConfigParse.getInstance().getAutos()) {
                if (autoBean != null) {
                    LogVlion.e("Down 策略 : ------包名------" + autoBean.getBundle());
                    i10 = i10 + random.nextInt(adjacentIntervalsMax) + adjacentIntervalsMin;
                    startTimerMillisecond((long) i10, false, autoBean);
                } else {
                    LogVlion.e("Down 策略 :   ：autoBean  == nullllll  ");
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void startTimerMillisecond(long j10, boolean z10, VlionServiceConfig.AutoBean autoBean) {
        try {
            LogVlion.e("Down 策略 : ------ 定时任务开始执行  延迟------" + j10 + " 毫秒  Bundle= " + autoBean.getBundle());
            VlionTimer.getInstance().startTimerMillisecond(j10, new b(j10, autoBean, z10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void startEventUpload(String str) {
        try {
            if (VlionServiceConfigParse.getInstance().getAutoAttribution() == null || VlionServiceConfigParse.getInstance().getAutos() == null) {
                return;
            }
            for (VlionServiceConfig.AutoBean autoBean : VlionServiceConfigParse.getInstance().getAutos()) {
                if (autoBean != null && str.equals(autoBean.getBundle())) {
                    startTimerMillisecond(0L, true, autoBean);
                    LogVlion.e("Down 策略 :   包名： " + autoBean.getBundle() + " 监听到应用安装 不需要补点击 直接执行任务");
                    return;
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
