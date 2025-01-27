package cn.vlion.ad.inland.base.util.init;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.text.TextUtils;
import android.util.Log;
import cn.vlion.ad.inland.base.b6;
import cn.vlion.ad.inland.base.d0;
import cn.vlion.ad.inland.base.d5;
import cn.vlion.ad.inland.base.h7;
import cn.vlion.ad.inland.base.j5;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.l4;
import cn.vlion.ad.inland.base.n5;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.o0;
import cn.vlion.ad.inland.base.p;
import cn.vlion.ad.inland.base.p0;
import cn.vlion.ad.inland.base.u4;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionConfigSharedPreferences;
import cn.vlion.ad.inland.base.util.sp.VlionSharedPreferences;
import cn.vlion.ad.inland.base.w;
import com.tencent.mm.opensdk.constants.Build;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class VlionSDkManager {
    private static volatile VlionSDkManager instance;
    private int age;
    private String appId;
    private String appKey;
    private ConsumeLevel consumeLevel;
    private boolean isEnableLog;
    private boolean isSdkDebug;
    private String platformList;
    private String sdkVersionName;
    private VlionPrivateController vlionPrivateController;
    private String wxSdkVersionName;
    private Application application = null;
    private String userId = "";
    private boolean enablePersonalizedAdState = true;
    private int wxSdkInt = -1;
    private boolean isRegisterNetworkCallback = false;

    private VlionSDkManager() {
    }

    public static synchronized VlionSDkManager getInstance() {
        VlionSDkManager vlionSDkManager;
        synchronized (VlionSDkManager.class) {
            try {
                if (instance == null) {
                    synchronized (VlionSDkManager.class) {
                        try {
                            if (instance == null) {
                                instance = new VlionSDkManager();
                            }
                        } finally {
                        }
                    }
                }
                vlionSDkManager = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vlionSDkManager;
    }

    private void initDeviceInfo(Application application) {
        VlionPrivateController vlionPrivateController = this.vlionPrivateController;
        if (vlionPrivateController == null || application == null || !vlionPrivateController.isCanUseGaid()) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new d5(application));
    }

    @SuppressLint({"MissingPermission"})
    private synchronized void initNetWork(Application application) {
        if (application != null) {
            if (!this.isRegisterNetworkCallback) {
                try {
                    n5 n5Var = new n5(application);
                    NetworkRequest build = new NetworkRequest.Builder().build();
                    ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        connectivityManager.registerNetworkCallback(build, n5Var);
                        LogVlion.e("VlionSDkManager registerNetworkCallback:");
                        this.isRegisterNetworkCallback = true;
                    }
                } catch (Throwable th2) {
                    p.a(th2, "VlionSDkManager registerNetworkCallback Exception:", th2);
                }
            }
        }
    }

    private void initSp() {
        try {
            VlionConfigSharedPreferences.getInstance().initSP(this.application);
            VlionSharedPreferences.getInstance().initSP(this.application);
            String uuid = VlionSharedPreferences.getInstance().getUuid();
            if (TextUtils.isEmpty(uuid)) {
                uuid = UUID.randomUUID().toString();
                VlionSharedPreferences.getInstance().setUuid(uuid);
            }
            if (j5.f2992f == null) {
                synchronized (j5.class) {
                    try {
                        if (j5.f2992f == null) {
                            j5.f2992f = new j5();
                        }
                    } finally {
                    }
                }
            }
            j5.f2992f.a(this.application);
            VlionServiceConfigParse.getInstance().setUuid(uuid);
            VlionServiceConfigParse.getInstance().setAppStart(true);
        } catch (Throwable th2) {
            getInstance().upLoadCatchException(th2);
        }
    }

    public void VlionCustomSDkAddReceiver(boolean z10) {
        if (l4.f3066f == null) {
            synchronized (l4.class) {
                try {
                    if (l4.f3066f == null) {
                        l4.f3066f = new l4();
                    }
                } finally {
                }
            }
        }
        l4 l4Var = l4.f3066f;
        Application application = getApplication();
        synchronized (l4Var) {
            if (application != null) {
                try {
                    LogVlion.e("VlionCustomSDk initVLionAddReceiver() isAdd =" + z10);
                    if (z10) {
                        VlionServiceConfig.DataBean.ListenSwitchBean listenSwitchBean = new VlionServiceConfig.DataBean.ListenSwitchBean();
                        VlionServiceConfig.DataBean.AutoAttributionBean autoAttribution = VlionServiceConfigParse.getInstance().getAutoAttribution();
                        if (autoAttribution != null && autoAttribution.getListenSwitch() != null) {
                            listenSwitchBean = autoAttribution.getListenSwitch();
                        }
                        if (l4Var.f3068b != null) {
                            if (l4Var.f3069c != listenSwitchBean.getInstalled() || l4Var.f3070d != listenSwitchBean.getUpdated() || l4Var.f3071e != listenSwitchBean.getRemoved()) {
                                application.unregisterReceiver(l4Var.f3068b);
                                LogVlion.e("VlionCustomSDk  关闭 = AddReceiver  =" + z10);
                                l4Var.f3068b = null;
                            }
                        }
                        l4Var.a(application, listenSwitchBean);
                    } else {
                        d0 d0Var = l4Var.f3068b;
                        if (d0Var != null) {
                            application.unregisterReceiver(d0Var);
                            LogVlion.e("VlionCustomSDk  关闭 = AddReceiver  =" + z10);
                            l4Var.f3068b = null;
                            l4Var.f3069c = -1;
                            l4Var.f3070d = -1;
                            l4Var.f3071e = -1;
                        }
                    }
                } catch (Throwable th2) {
                    LogVlion.e("VlionCustomSDk initVLionAddReceiver Throwable=" + th2.getMessage());
                    getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public void createWXAPI(String str) {
        h7.a(getInstance().getApplication().getApplicationContext(), str);
    }

    public int getAge() {
        return this.age;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public Application getApplication() {
        return this.application;
    }

    public ConsumeLevel getConsumeLevel() {
        return this.consumeLevel;
    }

    public String getPlatformList() {
        return this.platformList;
    }

    public VlionPrivateController getPrivateController() {
        return this.vlionPrivateController;
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getWxSdkInt() {
        try {
            if (this.wxSdkInt < 0 && h7.f2860c) {
                this.wxSdkInt = Build.class.getField("SDK_INT").getInt(null);
                LogVlion.e("WXApiUtil field Build getWxSdkInt " + this.wxSdkInt + ",wxSdkVersionName " + this.wxSdkVersionName);
            }
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("WXApiUtil field Build e ");
            a10.append(th2.getMessage());
            LogVlion.e(a10.toString());
        }
        if (this.wxSdkInt < 0) {
            this.wxSdkInt = 0;
        }
        return this.wxSdkInt;
    }

    public String getWxSdkVersionName() {
        try {
            if (this.wxSdkVersionName == null && h7.f2860c) {
                String str = null;
                String str2 = (String) Build.class.getField("SDK_VERSION_NAME").get(null);
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        Matcher matcher = Pattern.compile("\\d+\\.\\d+\\.\\d+").matcher(str2);
                        if (matcher.find()) {
                            str = matcher.group();
                        }
                    }
                } catch (Throwable th2) {
                    LogVlion.e("extractVersionWithRegex throwable " + th2.getMessage());
                }
                this.wxSdkVersionName = str;
                LogVlion.e("WXApiUtil field Build getWxSdkInt... " + this.wxSdkInt + ",wxSdkVersionName " + this.wxSdkVersionName);
            }
        } catch (Throwable th3) {
            StringBuilder a10 = l1.a("WXApiUtil field Build e ");
            a10.append(th3.getMessage());
            LogVlion.e(a10.toString());
        }
        if (this.wxSdkVersionName == null) {
            this.wxSdkVersionName = "";
        }
        return this.wxSdkVersionName;
    }

    public void init(Application application, boolean z10, VlionPrivateController vlionPrivateController, String str, String str2) {
        try {
            this.isSdkDebug = VlionAppInfo.getInstance().isApkInDebug(application);
            this.platformList = str;
            if (application == null) {
                Log.e("VlionSDkManager", "LogVlion VlionSDkManager application=null");
                return;
            }
            if (l4.f3066f == null) {
                synchronized (l4.class) {
                    try {
                        if (l4.f3066f == null) {
                            l4.f3066f = new l4();
                        }
                    } finally {
                    }
                }
            }
            l4.f3066f.a(application);
            this.application = application;
            this.isEnableLog = z10;
            this.vlionPrivateController = vlionPrivateController;
            this.sdkVersionName = str2;
            w wVar = w.f3475c;
            wVar.f3477b = application.getApplicationContext();
            wVar.f3476a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(wVar);
            LogVlion.setSdkOpenLog(z10);
            u4 a10 = u4.a();
            synchronized (a10) {
                if (a10.f3397a == null) {
                    a10.f3397a = new b6(application);
                }
            }
            o0 a11 = o0.a();
            synchronized (a11) {
                if (a11.f3240a == null) {
                    a11.f3240a = new p0(application);
                }
            }
            initDeviceInfo(application);
            initNetWork(application);
            LogVlion.e("VlionSDkManager sdkVersionName:" + str2);
            initSp();
            VlionDeviceInfo.getInstance().getUserAgent(application);
        } catch (Throwable th2) {
            getInstance().upLoadCatchException(th2);
        }
    }

    public void initAppInfo(String str, String str2) {
        this.appId = str;
        this.appKey = str2;
    }

    public boolean isEnableLog() {
        return this.isEnableLog;
    }

    public boolean isEnablePersonalizedAdState() {
        return this.enablePersonalizedAdState;
    }

    public boolean isSdkDebug() {
        return this.isSdkDebug;
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        try {
            Application application = this.application;
            if (application == null || activityLifecycleCallbacks == null) {
                return;
            }
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } catch (Throwable th2) {
            getInstance().upLoadCatchException(th2);
        }
    }

    public void setAge(int i10) {
        this.age = i10;
    }

    public void setConsumeLevel(ConsumeLevel consumeLevel) {
        this.consumeLevel = consumeLevel;
    }

    public void setPersonalizedAdState(boolean z10) {
        this.enablePersonalizedAdState = z10;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWxSdkInt(int i10) {
        this.wxSdkInt = i10;
    }

    public void setWxSdkVersionName(String str) {
        String str2;
        try {
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("extractVersionWithRegex throwable ");
            a10.append(th2.getMessage());
            LogVlion.e(a10.toString());
        }
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("\\d+\\.\\d+\\.\\d+").matcher(str);
            if (matcher.find()) {
                str2 = matcher.group();
                this.wxSdkVersionName = str2;
            }
        }
        str2 = null;
        this.wxSdkVersionName = str2;
    }

    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        try {
            Application application = this.application;
            if (application == null || activityLifecycleCallbacks == null) {
                return;
            }
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } catch (Throwable th2) {
            getInstance().upLoadCatchException(th2);
        }
    }

    public void upLoadCatchException(Throwable th2) {
        w wVar = w.f3475c;
        wVar.getClass();
        if (th2 == null) {
            return;
        }
        try {
            String a10 = w.a(th2);
            LogVlion.e("CatchException : Vlion Catch : " + a10);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            HttpRequestUtil.sdkException(wVar.f3477b, "Vlion Exception:" + a10);
        } catch (Throwable unused) {
        }
    }
}
