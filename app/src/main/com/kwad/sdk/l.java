package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l {
    private long acf;
    private volatile boolean aof;
    private volatile boolean aog;
    private volatile boolean aoh;
    private volatile Boolean aoi;
    private String aoj;
    private int aok;
    private boolean aol;

    @Nullable
    private KsLoadManager aom;
    private long aon;
    private long aoo;
    private f aop;
    private f aoq;
    private f aor;
    private f aos;
    private volatile boolean aot;
    private boolean aou;
    private boolean aov;
    private String aow;

    /* renamed from: com.kwad.sdk.l$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.f.a
        public final void accept(Object obj) {
        }
    }

    /* renamed from: com.kwad.sdk.l$10 */
    public class AnonymousClass10 extends com.kwad.sdk.f.b<JSONObject, Boolean> {
        public AnonymousClass10() {
        }

        private static Boolean f(JSONObject jSONObject) {
            return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
            return f(jSONObject);
        }
    }

    /* renamed from: com.kwad.sdk.l$2 */
    public class AnonymousClass2 implements i.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.library.solder.lib.i.a
        public final void b(String str, File file) {
            com.kwad.sdk.core.download.a.a(str, file, true);
        }

        @Override // com.kwad.library.solder.lib.i.a
        public final void d(String str, Throwable th2) {
            if (th2 instanceof Exception) {
                com.kwad.sdk.core.network.idc.a.Fz().g(str, th2);
            }
        }

        @Override // com.kwad.library.solder.lib.i.a
        public final int getCorePoolSize() {
            return com.kwad.sdk.core.config.d.Dl();
        }

        @Override // com.kwad.library.solder.lib.i.a
        public final int getMaxRetryCount() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avL);
        }

        @Override // com.kwad.library.solder.lib.i.a
        public final boolean yp() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avK);
        }
    }

    /* renamed from: com.kwad.sdk.l$3 */
    public class AnonymousClass3 implements b.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.commercial.b.a
        public final boolean AU() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.auC);
        }

        @Override // com.kwad.sdk.commercial.b.a
        public final boolean AV() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auB);
        }

        @Override // com.kwad.sdk.commercial.b.a
        public final JSONObject AW() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auN);
        }

        @Override // com.kwad.sdk.commercial.b.a
        public final String AX() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awV);
        }

        @Override // com.kwad.sdk.commercial.b.a
        public final void j(String str, String str2, boolean z10) {
            com.kwad.components.core.o.a.ri().e(str, str2, false);
        }
    }

    /* renamed from: com.kwad.sdk.l$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ e aoz;

        public AnonymousClass4(e eVar) {
            eVar = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                KsInitCallback ksInitCallback = KsInitCallback.this;
                e eVar = eVar;
                ksInitCallback.onFail(eVar.code, eVar.msg);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (l.At().aoo > 0) {
                    m.ag(SystemClock.elapsedRealtime() - l.At().aoo);
                }
                KsInitCallback.this.onSuccess();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ e aoz;

        public AnonymousClass6(e eVar) {
            eVar = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                KsInitCallback ksInitCallback = KsInitCallback.this;
                e eVar = eVar;
                ksInitCallback.onFail(eVar.code, eVar.msg);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$7 */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                KsInitCallback.this.onSuccess();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$8 */
    public class AnonymousClass8 implements g.b {
        final /* synthetic */ com.kwad.sdk.f.a aoA;

        public AnonymousClass8(com.kwad.sdk.f.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.core.request.g.a
        public final void d(@NonNull SdkConfigData sdkConfigData) {
            com.kwad.sdk.core.d.c.i("KSAdSDK", "onConfigRefresh()");
            try {
                l.this.e(sdkConfigData);
                com.kwad.sdk.f.a aVar = aVar;
                if (aVar != null) {
                    aVar.accept(null);
                }
            } catch (Throwable th2) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.components.core.request.g.a
        public final void rw() {
            com.kwad.sdk.core.d.c.i("KSAdSDK", "onCacheLoaded()");
            l.this.AF();
        }

        @Override // com.kwad.components.core.request.g.b
        public final void rx() {
            try {
                com.kwad.sdk.f.a aVar = aVar;
                if (aVar != null) {
                    aVar.accept(null);
                }
            } catch (Throwable th2) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.l$9 */
    public class AnonymousClass9 implements com.kwad.sdk.collector.h {
        public AnonymousClass9() {
        }

        @Override // com.kwad.sdk.collector.h
        public final void c(@NonNull JSONArray jSONArray) {
            com.kwad.components.core.o.a.ri().c(jSONArray);
        }
    }

    public static class a {
        private static final l aoB = new l((byte) 0);
    }

    public /* synthetic */ l(byte b10) {
        this();
    }

    private static void AA() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AB() {
        try {
            com.kwad.components.core.d.a.aj(ServiceProvider.getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AC() {
        try {
            com.kwad.sdk.components.d.init(getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AD() {
        try {
            com.kwad.components.core.n.b.b.init(getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AE() {
        ad.ah(ServiceProvider.getContext(), this.aow);
        this.aow = null;
    }

    public void AF() {
        try {
            Map<String, String> parseJSON2MapString = y.parseJSON2MapString(com.kwad.sdk.core.config.c.awy.getValue());
            for (String str : parseJSON2MapString.keySet()) {
                GlobalThreadPools.q(str, Integer.parseInt((String) requireNonNull(parseJSON2MapString.get(str))));
            }
            GlobalThreadPools.Hh();
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void AG() {
        try {
            com.kwad.sdk.core.d.c.init(ServiceProvider.MB().enableDebug);
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AH() {
        try {
            com.kwad.sdk.n.f.PU().init();
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AI() {
        try {
            com.kwad.sdk.core.c.b.Fi().init(ServiceProvider.getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AJ() {
        try {
            com.kwad.sdk.core.webview.b.a.IL().init(getContext());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private void AK() {
        try {
            com.kwad.sdk.core.network.idc.a.Fz().init(getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AL() {
        try {
            com.kwad.sdk.core.download.a.bm(ServiceProvider.getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AM() {
        try {
            com.kwad.sdk.core.diskcache.a.bl(getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AN() {
        try {
            com.kwad.components.core.s.m.si().init();
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AO() {
        com.kwad.components.core.p.b.rC();
        com.kwad.components.core.p.b.f(com.kwad.sdk.core.config.d.Di(), com.kwad.sdk.core.config.d.Dj());
    }

    private void AP() {
        try {
            ba.init(getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void AQ() {
        try {
            com.kwad.sdk.app.b.BJ().init();
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private void AR() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.l.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void d(String str, Throwable th2) {
                    if (th2 instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.Fz().g(str, th2);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.d.Dl();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avL);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final boolean yp() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avK);
                }
            });
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    public static l At() {
        return a.aoB;
    }

    private synchronized boolean Av() {
        return n.aM(getContext());
    }

    private void Aw() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.acf = elapsedRealtime;
        com.kwad.sdk.service.b.init();
        j.zv();
        AG();
        AH();
        boolean Au = Au();
        Log.d("KSAdSDK", "initSDKModule enableInitStartMode: " + Au);
        if (this.aop == null) {
            this.aop = f.X(this.aon);
        }
        if (!Au) {
            this.aop.report();
        }
        Ay();
        AK();
        AL();
        AR();
        AE();
        if (!Au) {
            e((com.kwad.sdk.f.a) null);
        }
        AA();
        AC();
        AD();
        AI();
        AP();
        AN();
        com.kwad.sdk.n.l.HF();
        Az();
        com.kwad.sdk.core.g.a.HF();
        if (!Au) {
            com.kwad.sdk.a.a.c.Bg().Bi();
            com.kwad.components.core.o.a.ri().rj();
        }
        if (com.kwad.framework.a.a.nr.booleanValue()) {
            try {
                com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
            } catch (Exception unused) {
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.d.c.d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        com.kwad.sdk.core.d.c.i("KSAdSDK", "SDK_VERSION_NAME: 3.3.69 TK_VERSION_CODE: 6.1.2 BRIDGE_VERSION: 1.3");
        if (this.aoq == null) {
            this.aoq = f.Y(elapsedRealtime2);
        }
        if (!Au) {
            this.aoq.report();
        }
        if (At().aoo > 0) {
            m.af(SystemClock.elapsedRealtime() - At().aoo);
        }
        a(ServiceProvider.MB());
        this.aof = true;
    }

    private void Ax() {
        try {
            com.kwad.sdk.commercial.b.a(new b.a() { // from class: com.kwad.sdk.l.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean AU() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.auC);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean AV() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auB);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final JSONObject AW() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auN);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final String AX() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awV);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final void j(String str, String str2, boolean z10) {
                    com.kwad.components.core.o.a.ri().e(str, str2, false);
                }
            }, this.aol);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void Ay() {
        try {
            com.kwad.sdk.components.c.init(ServiceProvider.getContext());
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    private static void Az() {
        try {
            com.kwad.components.core.proxy.launchdialog.d.rg().init(ServiceProvider.getContext());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static boolean aI(Context context) {
        String processName = av.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    public static Object c(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z10 = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.Fz().Y(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.b.g((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.MA() == null) {
                return null;
            }
            if (av.isInMainProcess(ServiceProvider.MA()) && com.kwad.framework.a.a.agO.booleanValue()) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        } catch (Throwable th2) {
            try {
                ServiceProvider.reportSdkCaughtException(th2);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public static String cf(String str) {
        return com.kwad.sdk.core.a.d.an(str);
    }

    public static String cg(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.EG().delete();
    }

    private void e(com.kwad.sdk.f.a aVar) {
        try {
            com.kwad.components.core.request.g.a(new g.b() { // from class: com.kwad.sdk.l.8
                final /* synthetic */ com.kwad.sdk.f.a aoA;

                public AnonymousClass8(com.kwad.sdk.f.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.components.core.request.g.a
                public final void d(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        l.this.e(sdkConfigData);
                        com.kwad.sdk.f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th2) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th2);
                    }
                }

                @Override // com.kwad.components.core.request.g.a
                public final void rw() {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onCacheLoaded()");
                    l.this.AF();
                }

                @Override // com.kwad.components.core.request.g.b
                public final void rx() {
                    try {
                        com.kwad.sdk.f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th2) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th2);
                    }
                }
            });
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    public static String getAppId() {
        return ServiceProvider.MB().appId;
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.GF();
    }

    public static String getAppName() {
        return ServiceProvider.MB().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.GH().toJson();
    }

    public static String getDid() {
        return ba.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.GK().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.MB();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.MB().enableDebug;
    }

    public static void k(Throwable th2) {
        ServiceProvider.reportSdkCaughtException(th2);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.b.h(cls).newInstance();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    private static <T> T requireNonNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z10, @RawRes int i10) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z10, @ColorInt int i10) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setThemeMode(int i10) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public final boolean AS() {
        return !Au() ? this.aof : this.aof && this.aog;
    }

    public final long AT() {
        return this.acf;
    }

    public final synchronized boolean Au() {
        try {
        } catch (Throwable th2) {
            Log.e("KSAdSDK", th2.getMessage());
            th2.printStackTrace();
        }
        if (Av()) {
            Log.d("KSAdSDK", "enableInitStartMode return false hadLastTimeInitError");
            return false;
        }
        if (this.aoi == null) {
            this.aoi = Boolean.valueOf(com.kwad.sdk.core.config.d.Au());
        }
        if (!this.aoi.booleanValue()) {
            Log.d("KSAdSDK", "enableInitStartMode return false mConfigEnableInitStart");
            return false;
        }
        if (this.aoh) {
            Log.d("KSAdSDK", "enableInitStartMode return true mApiHadStartMethod");
            return true;
        }
        this.aoh = IKsAdSDK.class.getDeclaredMethod("start", null) != null;
        Log.d("KSAdSDK", "enableInitStartMode return mApiHadStartMethod: " + this.aoh);
        return this.aoh;
    }

    @NonNull
    public final KsLoadManager getAdManager() {
        if (this.aom == null) {
            this.aom = new com.kwad.components.core.b();
        }
        return this.aom;
    }

    public final String getApiVersion() {
        return this.aoj;
    }

    public final int getApiVersionCode() {
        return this.aok;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } finally {
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.aof);
                if (this.aof) {
                    ServiceProvider.c(sdkConfig);
                    return;
                }
                ServiceProvider.c(sdkConfig);
                ServiceProvider.bT(context);
                if (aI(context)) {
                    Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                    ServiceProvider.Mz();
                    j.zv();
                    AG();
                    this.aof = true;
                } else {
                    try {
                        n.Ba();
                        Aw();
                        n.aL(context);
                    } catch (Throwable th2) {
                        Log.e("KSAdSDK", "initSDKModule error", th2);
                        String stackTraceString = Log.getStackTraceString(th2);
                        n.a(th2, stackTraceString);
                        a(sdkConfig, new e(10002, stackTraceString));
                        return;
                    }
                }
                return;
            }
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        a(sdkConfig, e.anL);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g10 = com.kwad.sdk.service.b.g(cls);
            if (g10 == null) {
                if (obj instanceof BaseProxyActivity) {
                    g10 = com.kwad.components.core.proxy.d.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g10 = com.kwad.components.core.proxy.e.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + zB() + "--mIsSdkInit:" + zE() + "--componentClass" + cls));
            }
            return (T) g10.newInstance();
        } catch (Exception e10) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e10);
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return null;
        }
    }

    public final void setAdxEnable(boolean z10) {
        this.aov = z10;
    }

    public final void setApiVersion(String str) {
        this.aoj = str;
    }

    public final void setApiVersionCode(int i10) {
        this.aok = i10;
    }

    public final void setAppTag(String str) {
        if (this.aof) {
            ad.ah(ServiceProvider.getContext(), this.aow);
        } else {
            this.aow = str;
        }
    }

    public final void setInitStartTime(long j10) {
        this.aoo = j10;
    }

    public final void setIsExternal(boolean z10) {
        this.aol = z10;
    }

    public final void setLaunchTime(long j10) {
        this.aon = j10;
    }

    public final void setPersonalRecommend(boolean z10) {
        this.aot = z10;
    }

    public final void setProgrammaticRecommend(boolean z10) {
        this.aou = z10;
    }

    public final synchronized void start() {
        boolean z10;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Log.d("KSAdSDK", "KSAdSDK start call");
            if (this.aor == null) {
                this.aor = f.Z(this.aon);
            }
            this.aor.report();
            SdkConfig MB = ServiceProvider.MB();
            if (Au()) {
                z10 = false;
            } else {
                b(MB);
                z10 = true;
            }
            if (!this.aof) {
                b(MB, e.anM);
                z10 = true;
            }
            if (this.aog) {
                b(MB);
                z10 = true;
            }
            if (!z10) {
                e(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.l.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.f.a
                    public final void accept(Object obj) {
                    }
                });
                com.kwad.sdk.a.a.c.Bg().Bi();
                com.kwad.components.core.o.a.ri().rj();
                f fVar = this.aop;
                if (fVar != null) {
                    fVar.report();
                }
                f fVar2 = this.aoq;
                if (fVar2 != null) {
                    fVar2.report();
                }
                this.aog = true;
                b(MB);
            }
            if (this.aos == null) {
                this.aos = f.aa(SystemClock.elapsedRealtime() - elapsedRealtime);
            }
            this.aor.report();
        } catch (Throwable th2) {
            n.l(th2);
        }
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.EI().bo(getContext());
    }

    public final boolean zB() {
        return this.aol;
    }

    public final boolean zC() {
        return this.aot;
    }

    public final boolean zD() {
        return this.aou;
    }

    public final boolean zE() {
        return this.aof;
    }

    private l() {
        this.aof = false;
        this.aog = false;
        this.aoh = false;
        this.aoi = null;
        this.aoj = "";
        this.aot = true;
        this.aou = true;
        this.aov = false;
    }

    private static void b(SdkConfig sdkConfig, e eVar) {
        KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartFail error: " + eVar.msg);
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.6
                final /* synthetic */ e aoz;

                public AnonymousClass6(e eVar2) {
                    eVar = eVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsInitCallback ksInitCallback2 = KsInitCallback.this;
                        e eVar2 = eVar;
                        ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(SdkConfig sdkConfig, e eVar) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.l.4
                        final /* synthetic */ e aoz;

                        public AnonymousClass4(e eVar2) {
                            eVar = eVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsInitCallback ksInitCallback2 = KsInitCallback.this;
                                e eVar2 = eVar;
                                ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e(SdkConfigData sdkConfigData) {
        try {
            AB();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.e("KSAdSDK", Log.getStackTraceString(th2));
        }
        Ax();
        AJ();
        com.kwad.sdk.core.config.d.zz();
        if ((com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auA) && av.isInMainProcess(ServiceProvider.MA())) || com.kwad.framework.a.a.ns.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.MA());
        }
        if (com.kwad.sdk.core.config.d.DS()) {
            com.kwad.sdk.b.a.init(com.kwad.sdk.n.m.Qa());
        }
        AO();
        be.init(getContext());
        com.kwad.components.core.a.a.nh().at();
        com.kwad.sdk.utils.g.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.l.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.o.a.ri().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.Fz().a(com.kwad.sdk.core.config.d.DT(), com.kwad.sdk.core.config.d.DU());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bq.a(com.kwad.sdk.core.config.d.DV(), com.kwad.sdk.core.config.d.DW(), ServiceProvider.getContext());
        AQ();
        AM();
        com.kwad.components.core.h.a.pt().am(getContext());
        com.kwad.sdk.crash.online.monitor.a.cO(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awo));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.m.e.cO(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awv));
        com.kwad.sdk.core.threads.c.cO(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awx));
        com.kwad.sdk.i.a.Lf();
        com.kwad.sdk.n.m.x(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.f.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.l.10
            public AnonymousClass10() {
            }

            private static Boolean f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return f(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.dG(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awP));
        try {
            com.kwad.components.core.webview.tachikoma.g.tE().init();
        } catch (Throwable th3) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th3);
        }
    }

    private static void a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bt.b(new Runnable() { // from class: com.kwad.sdk.l.5
                        public AnonymousClass5() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (l.At().aoo > 0) {
                                    m.ag(SystemClock.elapsedRealtime() - l.At().aoo);
                                }
                                KsInitCallback.this.onSuccess();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(SdkConfig sdkConfig) {
        KsInitCallback ksInitCallback;
        try {
            Log.d("KSAdSDK", "KSAdSDK notifyStartSuccess");
            if (sdkConfig == null || (ksInitCallback = sdkConfig.ksStartCallback) == null) {
                return;
            }
            bt.b(new Runnable() { // from class: com.kwad.sdk.l.7
                public AnonymousClass7() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsInitCallback.this.onSuccess();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }

    public static void e(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.g(map);
    }
}
