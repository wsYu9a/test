package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.n.f;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.collector.h;
import com.kwad.sdk.core.download.a;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.l;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.y;
import com.kwai.sodler.kwai.a;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: classes2.dex */
public class KsAdSDKImpl implements IKsAdSDK {
    private static final String TAG = "KSAdSDK";
    private boolean adxEnable;
    private boolean isExternal;

    @Nullable
    private KsLoadManager mAdRequestManager;
    private int mApiVersionCode;
    private String mApiVersionName;
    private String mAppTag;
    private long mInitTime;
    private volatile boolean mIsSdkInit;
    private long mLaunchTime;
    private volatile boolean personalRecommend;
    private boolean programmaticRecommend;

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$1 */
    final class AnonymousClass1 implements KSLoggerReporter.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
        public final void f(String str, String str2, boolean z) {
            com.kwad.components.core.m.a.pb().e(str, str2, false);
        }

        @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
        public final boolean sn() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.abZ);
        }

        @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
        public final JSONObject so() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ack);
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$2 */
    static class AnonymousClass2 extends aw {
        final /* synthetic */ com.kwad.sdk.a Ys;

        AnonymousClass2(com.kwad.sdk.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            KsInitCallback ksInitCallback = KsInitCallback.this;
            com.kwad.sdk.a aVar = aVar;
            ksInitCallback.onFail(aVar.code, aVar.msg);
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$3 */
    static class AnonymousClass3 extends aw {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            KsInitCallback.this.onSuccess();
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$4 */
    final class AnonymousClass4 implements f.a {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.n.f.a
        public final void a(@NonNull SdkConfigData sdkConfigData) {
            com.kwad.sdk.core.d.b.i(KsAdSDKImpl.TAG, "onConfigRefresh()");
            try {
                KsAdSDKImpl.this.initOnConfigRefresh(sdkConfigData);
            } catch (Throwable th) {
                com.kwad.components.core.c.a.b(th);
            }
        }

        @Override // com.kwad.components.core.n.f.a
        public final void nP() {
            com.kwad.sdk.core.d.b.z(KsAdSDKImpl.TAG, "onCacheLoaded()");
            if (((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)) != null) {
                ServiceProvider.getContext();
            }
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$5 */
    final class AnonymousClass5 implements h {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.collector.h
        public final void c(@NonNull JSONArray jSONArray) {
            com.kwad.components.core.m.a.pb().c(jSONArray);
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$6 */
    final class AnonymousClass6 extends com.kwad.sdk.e.b<JSONObject, Boolean> {
        AnonymousClass6() {
        }

        private static Boolean e(JSONObject jSONObject) {
            return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
        }

        @Override // com.kwad.sdk.e.b
        public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
            return e(jSONObject);
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$7 */
    final class AnonymousClass7 implements com.kwad.sdk.core.d.kwai.a {
        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.d.kwai.a
        public final void m(String str, String str2) {
            l lVar = new l();
            lVar.air = str;
            KSLoggerReporter.a(lVar, str2);
        }
    }

    /* renamed from: com.kwad.sdk.KsAdSDKImpl$8 */
    final class AnonymousClass8 implements a.InterfaceC0247a {
        AnonymousClass8() {
        }

        @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
        public final void a(com.kwai.sodler.lib.a.f fVar, File file) {
            try {
                com.kwad.sdk.core.download.a.a(fVar.getDownloadUrl(), file, (a.b) null, -1, true);
            } catch (Throwable th) {
                if (th instanceof Exception) {
                    com.kwad.sdk.core.network.idc.a.wm().d(fVar.getDownloadUrl(), th);
                }
                throw new PluginError.UpdateError(th.getMessage(), -4);
            }
        }

        @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
        public final int getMaxRetryCount() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adi);
        }

        @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
        public final boolean sp() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adh);
        }
    }

    static class a {
        private static final KsAdSDKImpl Yt = new KsAdSDKImpl();
    }

    private KsAdSDKImpl() {
        this.mIsSdkInit = false;
        this.mApiVersionName = "";
        this.personalRecommend = true;
        this.programmaticRecommend = true;
        this.adxEnable = false;
    }

    /* synthetic */ KsAdSDKImpl(AnonymousClass1 anonymousClass1) {
        this();
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.Yt;
    }

    private void initApkClean() {
        try {
            com.kwad.sdk.core.diskcache.a.aJ(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initAppTag() {
        y.Z(ServiceProvider.getContext(), this.mAppTag);
        this.mAppTag = null;
    }

    private void initCommercialLogger() {
        try {
            KSLoggerReporter.a(new KSLoggerReporter.a() { // from class: com.kwad.sdk.KsAdSDKImpl.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final void f(String str, String str2, boolean z) {
                    com.kwad.components.core.m.a.pb().e(str, str2, false);
                }

                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final boolean sn() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.abZ);
                }

                @Override // com.kwad.sdk.core.report.KSLoggerReporter.a
                public final JSONObject so() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ack);
                }
            });
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initComponents() {
        try {
            com.kwad.sdk.components.b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initComponentsManager() {
        try {
            com.kwad.sdk.components.c.init(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initConfigRequestManager() {
        try {
            com.kwad.components.core.n.f.a(ServiceProvider.getContext(), new f.a() { // from class: com.kwad.sdk.KsAdSDKImpl.4
                AnonymousClass4() {
                }

                @Override // com.kwad.components.core.n.f.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.b.i(KsAdSDKImpl.TAG, "onConfigRefresh()");
                    try {
                        KsAdSDKImpl.this.initOnConfigRefresh(sdkConfigData);
                    } catch (Throwable th) {
                        com.kwad.components.core.c.a.b(th);
                    }
                }

                @Override // com.kwad.components.core.n.f.a
                public final void nP() {
                    com.kwad.sdk.core.d.b.z(KsAdSDKImpl.TAG, "onCacheLoaded()");
                    if (((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)) != null) {
                        ServiceProvider.getContext();
                    }
                }
            });
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initDownload() {
        try {
            com.kwad.sdk.core.download.a.aK(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initExceptionModule() {
        try {
            com.kwad.components.core.c.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initHybrid() {
        try {
            com.kwad.sdk.core.webview.a.a.za().init(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initIDC() {
        try {
            com.kwad.sdk.core.network.idc.a.wm().init(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initInstalledReceiver() {
        try {
            com.kwad.sdk.a.b.tA().checkInit();
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initKSPlugin() {
        try {
            com.kwad.sdk.j.e.FK().init();
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initLifecycleHolder() {
        try {
            com.kwad.sdk.core.b.b.vS().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initLottie() {
    }

    private void initOAID() {
        try {
            com.kwad.sdk.core.e.a.initAsync(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initOfflineComponents() {
        try {
            com.kwad.components.core.offline.init.b.init(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    public void initOnConfigRefresh(SdkConfigData sdkConfigData) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        initHybrid();
        com.kwad.sdk.core.config.d.sv();
        if (com.kwad.sdk.core.config.d.uc() || com.kwad.b.kwai.a.bI.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.getContext());
        }
        if (com.kwad.sdk.core.config.d.uL()) {
            com.kwad.sdk.b.a.init(k.FP());
        }
        initSpeedLimitConfig();
        ax.init(getContext());
        com.kwad.components.core.kwai.a.lT().fc();
        com.kwad.sdk.utils.f.a(getContext(), 30000L, new h() { // from class: com.kwad.sdk.KsAdSDKImpl.5
            AnonymousClass5() {
            }

            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.m.a.pb().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.wm().a(com.kwad.sdk.core.config.d.uM());
        bf.a(com.kwad.sdk.core.config.d.uN(), com.kwad.sdk.core.config.d.uO(), ServiceProvider.getContext());
        initInstalledReceiver();
        initApkClean();
        com.kwad.components.core.f.a.nA().aa(getContext());
        com.kwad.sdk.crash.online.monitor.a.cL(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adH));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.ranger.e.cL(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adL));
        com.kwad.sdk.core.threads.c.cL(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adM));
        com.kwad.sdk.g.b.Bd();
        k.x(getContext(), ((Boolean) com.kwad.sdk.core.config.d.uu().getAppConfigData(Boolean.FALSE, new com.kwad.sdk.e.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.KsAdSDKImpl.6
            AnonymousClass6() {
            }

            private static Boolean e(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.e.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return e(jSONObject);
            }
        })).booleanValue());
    }

    private void initPackCheck() {
        try {
            com.kwad.components.core.r.k.pP().init();
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initPrivateData() {
        try {
            au.init(getContext());
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initSDKModule() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mInitTime = elapsedRealtime;
        com.kwad.sdk.service.a.init();
        e.sr();
        initSdkLog();
        initKSPlugin();
        initCommercialLogger();
        f.F(this.mLaunchTime);
        initComponents();
        initOAID();
        initIDC();
        initDownload();
        initSOLoader();
        initAppTag();
        initConfigRequestManager();
        initExceptionModule();
        initComponentsManager();
        initOfflineComponents();
        initLifecycleHolder();
        initLottie();
        initPrivateData();
        initPackCheck();
        com.kwad.sdk.kwai.kwai.c.sZ().tb();
        com.kwad.components.core.m.a.pb().pc();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.d.b.d(TAG, "KSAdSDK init time:" + elapsedRealtime2);
        f.G(elapsedRealtime2);
        notifyInitSuccess(ServiceProvider.CB());
        com.kwad.sdk.g.a.report();
        this.mIsSdkInit = true;
    }

    private void initSOLoader() {
        try {
            com.kwai.sodler.kwai.a.a(new a.InterfaceC0247a() { // from class: com.kwad.sdk.KsAdSDKImpl.8
                AnonymousClass8() {
                }

                @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
                public final void a(com.kwai.sodler.lib.a.f fVar, File file) {
                    try {
                        com.kwad.sdk.core.download.a.a(fVar.getDownloadUrl(), file, (a.b) null, -1, true);
                    } catch (Throwable th) {
                        if (th instanceof Exception) {
                            com.kwad.sdk.core.network.idc.a.wm().d(fVar.getDownloadUrl(), th);
                        }
                        throw new PluginError.UpdateError(th.getMessage(), -4);
                    }
                }

                @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adi);
                }

                @Override // com.kwai.sodler.kwai.a.InterfaceC0247a
                public final boolean sp() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.adh);
                }
            });
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initSdkLog() {
        try {
            com.kwad.sdk.core.d.b.a(ServiceProvider.CB().enableDebug, new com.kwad.sdk.core.d.kwai.a() { // from class: com.kwad.sdk.KsAdSDKImpl.7
                AnonymousClass7() {
                }

                @Override // com.kwad.sdk.core.d.kwai.a
                public final void m(String str, String str2) {
                    l lVar = new l();
                    lVar.air = str;
                    KSLoggerReporter.a(lVar, str2);
                }
            });
        } catch (Throwable th) {
            g.f(th);
        }
    }

    private void initSpeedLimitConfig() {
        com.kwad.components.core.o.b.pm();
        com.kwad.components.core.o.b.e(com.kwad.sdk.core.config.d.uf(), com.kwad.sdk.core.config.d.ug());
    }

    private boolean isRemoteService(Context context) {
        String processName = ap.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    public static void notifyInitFail(SdkConfig sdkConfig, com.kwad.sdk.a aVar) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bi.postOnUiThread(new aw() { // from class: com.kwad.sdk.KsAdSDKImpl.2
                        final /* synthetic */ com.kwad.sdk.a Ys;

                        AnonymousClass2(com.kwad.sdk.a aVar2) {
                            aVar = aVar2;
                        }

                        @Override // com.kwad.sdk.utils.aw
                        public final void doTask() {
                            KsInitCallback ksInitCallback2 = KsInitCallback.this;
                            com.kwad.sdk.a aVar2 = aVar;
                            ksInitCallback2.onFail(aVar2.code, aVar2.msg);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void notifyInitSuccess(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bi.postOnUiThread(new aw() { // from class: com.kwad.sdk.KsAdSDKImpl.3
                        AnonymousClass3() {
                        }

                        @Override // com.kwad.sdk.utils.aw
                        public final void doTask() {
                            KsInitCallback.this.onSuccess();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.kwai.d.d(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        if ("autoRT".equals(str)) {
            return -1;
        }
        if ("getAutoRevertTime".equals(str)) {
            return 10000;
        }
        boolean z = false;
        if ("TRANSFORM_API_HOST".equals(str)) {
            return com.kwad.sdk.core.network.idc.a.wm().E(objArr[0].toString(), "api");
        }
        if ("reportDynamicUpdate".equals(str)) {
            KSLoggerReporter.q((JSONObject) objArr[0]);
            return Boolean.TRUE;
        }
        if (!"enableDynamic".equals(str)) {
            return null;
        }
        if (ap.isInMainProcess(ServiceProvider.getContext()) && com.kwad.b.kwai.a.Yf.booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        com.kwad.sdk.core.diskcache.a.a.vs().delete();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        if (this.mAdRequestManager == null) {
            this.mAdRequestManager = new com.kwad.components.core.b();
        }
        return this.mAdRequestManager;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return this.mApiVersionName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        return ServiceProvider.CB().appId;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.xo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        return ServiceProvider.CB().appName;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        return ServiceProvider.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.xq().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        return au.getDeviceId();
    }

    public boolean getIsExternal() {
        return this.isExternal;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.xt().toJson();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        return com.kwad.sdk.core.kwai.d.getResponseData(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        return com.kwad.sdk.core.kwai.d.bV(str);
    }

    public long getSDKInitTime() {
        return this.mInitTime;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        return "3.3.40";
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        return 3034000;
    }

    public boolean hasInitFinish() {
        return this.mIsSdkInit;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } finally {
                return;
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                Log.d(TAG, "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.mIsSdkInit);
                if (this.mIsSdkInit) {
                    ServiceProvider.a(sdkConfig);
                    return;
                }
                ServiceProvider.a(sdkConfig);
                ServiceProvider.bt(context);
                if (isRemoteService(context)) {
                    Log.d(TAG, "intKSRemoteProcess appId=" + sdkConfig.appId);
                    ServiceProvider.Cz();
                    e.sr();
                    initSdkLog();
                    this.mIsSdkInit = true;
                } else {
                    try {
                        g.sR();
                        initSDKModule();
                    } catch (Throwable th) {
                        String stackTraceString = Log.getStackTraceString(th);
                        g.a(th, stackTraceString);
                        Log.e(TAG, "init error", th);
                        notifyInitFail(sdkConfig, new com.kwad.sdk.a(10002, stackTraceString));
                        return;
                    }
                }
                return;
            }
        }
        Log.e(TAG, "KSAdSDK SDKInit:init error,please check appID and config item");
        notifyInitFail(sdkConfig, com.kwad.sdk.a.Yj);
    }

    public boolean isAdxEnable() {
        return this.adxEnable;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        return ServiceProvider.CB().enableDebug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public boolean isProgrammaticRecommend() {
        return this.programmaticRecommend;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g2 = com.kwad.sdk.service.a.g(cls);
            if (g2 == null) {
                if (obj instanceof BaseProxyActivity) {
                    g2 = com.kwad.components.core.l.b.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g2 = com.kwad.components.core.l.c.class;
                }
                com.kwad.components.core.c.a.b(new RuntimeException("--getIsExternal:" + getIsExternal() + "--mIsSdkInit:" + hasInitFinish() + "--componentClass" + cls));
            }
            return (T) g2.newInstance();
        } catch (Exception e2) {
            com.kwad.components.core.c.a.b(e2);
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.a.h(cls).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            if (com.kwad.b.kwai.a.bI.booleanValue()) {
                th.printStackTrace();
            }
            com.kwad.components.core.c.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i2, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.kwai.d.a(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z) {
        this.adxEnable = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        this.mApiVersionName = str;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i2) {
        this.mApiVersionCode = i2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        if (this.mIsSdkInit) {
            y.Z(ServiceProvider.getContext(), this.mAppTag);
        } else {
            this.mAppTag = str;
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        this.isExternal = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j2) {
        this.mLaunchTime = j2;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, @RawRes int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        this.personalRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        this.programmaticRecommend = z;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i2) {
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        com.kwad.sdk.core.download.c.vu().aM(getContext());
    }
}
