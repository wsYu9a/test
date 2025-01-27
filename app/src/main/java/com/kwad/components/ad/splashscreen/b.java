package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.ad.splashscreen.b$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(com.kwad.components.core.n.kwai.b.this);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;
        final /* synthetic */ SceneImpl el;

        AnonymousClass2(KsLoadManager.SplashScreenAdListener splashScreenAdListener, SceneImpl sceneImpl) {
            splashScreenAdListener = splashScreenAdListener;
            covert = sceneImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0155b.a(C0155b.this, true);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
            KsLoadManager.SplashScreenAdListener splashScreenAdListener = splashScreenAdListener;
            com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agp;
            splashScreenAdListener.onError(fVar.errorCode, fVar.msg);
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.agp;
            com.kwad.components.splash.monitor.a.a("", false, fVar2.errorCode, fVar2.msg, covert.getPosId());
            com.kwad.components.core.m.a.pb().aB(4);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$3 */
    static class AnonymousClass3 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;
        final /* synthetic */ Runnable Bn;
        final /* synthetic */ a Bo;
        final /* synthetic */ SceneImpl el;
        final /* synthetic */ long gh;

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            AnonymousClass1(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                splashScreenAdListener.onError(i2, str);
                if (i2 == com.kwad.sdk.core.network.f.agq.errorCode) {
                    com.kwad.components.core.m.a.pb().aB(0);
                } else {
                    com.kwad.components.core.m.a.pb().aB(3);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ AdResultData iv;

            AnonymousClass2(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$3 */
        final class RunnableC01533 implements Runnable {
            final /* synthetic */ KsSplashScreenAd Bq;

            RunnableC01533(KsSplashScreenAd ksSplashScreenAd) {
                ksSplashScreenAdControl = ksSplashScreenAd;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$4 */
        final class AnonymousClass4 implements Runnable {
            final /* synthetic */ KsSplashScreenAd Bq;

            AnonymousClass4(KsSplashScreenAd ksSplashScreenAd) {
                ksSplashScreenAdControl = ksSplashScreenAd;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        }

        AnonymousClass3(Runnable runnable, a aVar, SceneImpl sceneImpl, KsLoadManager.SplashScreenAdListener splashScreenAdListener, long j2) {
            runnable = runnable;
            aVar = aVar;
            covert = sceneImpl;
            splashScreenAdListener = splashScreenAdListener;
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
        public final void a(int i2, String str, boolean z) {
            if (C0155b.this.Bt) {
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            } else {
                b.mHandler.removeCallbacks(runnable);
                if (!aVar.Bs) {
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.a("", z, i2, str, covert.getPosId());
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    AnonymousClass1(int i22, String str2) {
                        i2 = i22;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        splashScreenAdListener.onError(i2, str);
                        if (i2 == com.kwad.sdk.core.network.f.agq.errorCode) {
                            com.kwad.components.core.m.a.pb().aB(0);
                        } else {
                            com.kwad.components.core.m.a.pb().aB(3);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
        public final void a(@NonNull AdResultData adResultData, boolean z) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                final /* synthetic */ AdResultData iv;

                AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            });
            if (adResultData2.getAdTemplateList().size() <= 0) {
                if (C0155b.this.Bt) {
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                    return;
                }
                b.mHandler.removeCallbacks(runnable);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.a("", z, com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData2.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData2.testErrorMsg, covert.getPosId());
                aVar.Bs = true;
                a(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData2.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData2.testErrorMsg, z);
                com.kwad.components.core.m.a.pb().aB(3);
                return;
            }
            AdTemplate adTemplate = adResultData2.getAdTemplateList().get(0);
            adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime;
            adTemplate.notNetworkRequest = z;
            com.kwad.sdk.core.response.a.d.cb(adTemplate);
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.T(adTemplate);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "dataReady").report();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData2);
            boolean f2 = SplashPreloadManager.rV().f(adResultData2);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f2);
            if (!f2) {
                SplashPreloadManager.rV();
                if (!SplashPreloadManager.g(adResultData2)) {
                    if (C0155b.this.Bt) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.c(adTemplate, 5, elapsedRealtime);
                    aVar.Bs = true;
                    a(com.kwad.sdk.core.network.f.ago.errorCode, "请求成功，但缓存未命中", z);
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                    com.kwad.components.core.m.a.pb().aB(3);
                    return;
                }
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                int b2 = SplashPreloadManager.rV().b(adResultData2, true);
                if (!C0155b.this.Bt) {
                    b.mHandler.removeCallbacks(runnable);
                    if (b2 > 0) {
                        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.4
                            final /* synthetic */ KsSplashScreenAd Bq;

                            AnonymousClass4(KsSplashScreenAd ksSplashScreenAdControl2) {
                                ksSplashScreenAdControl = ksSplashScreenAdControl2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.b.printStackTrace(th);
                                }
                            }
                        });
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.b(adTemplate, 3, elapsedRealtime);
                        com.kwad.components.core.m.a.pb().aB(2);
                        return;
                    }
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.c(adTemplate, 4, elapsedRealtime);
                    aVar.Bs = true;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agq;
                    a(fVar.errorCode, fVar.msg, z);
                    return;
                }
            } else if (!C0155b.this.Bt) {
                b.mHandler.removeCallbacks(runnable);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.3
                    final /* synthetic */ KsSplashScreenAd Bq;

                    RunnableC01533(KsSplashScreenAd ksSplashScreenAdControl2) {
                        ksSplashScreenAdControl = ksSplashScreenAdControl2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                            splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTrace(th);
                        }
                    }
                });
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.b(adTemplate, 2, elapsedRealtime);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                com.kwad.components.core.m.a.pb().aB(1);
                return;
            }
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.c(adTemplate, 7, elapsedRealtime);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$4 */
    static class AnonymousClass4 extends com.kwad.components.core.n.c {
        final /* synthetic */ long Br;

        AnonymousClass4(long j2) {
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            if (adResultData.getAdTemplateList().size() > 0) {
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.rV().b(adResultData, false));
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                com.kwad.components.core.m.a.pb().aC(adResultData.getAdTemplateList().size());
            }
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.b(i2, str, SceneImpl.this.getPosId());
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
        }
    }

    static class a {
        private volatile boolean Bs;

        private a() {
            this.Bs = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b */
    static class C0155b {
        private volatile boolean Bt;

        private C0155b() {
            this.Bt = false;
        }

        /* synthetic */ C0155b(byte b2) {
            this();
        }

        static /* synthetic */ boolean a(C0155b c0155b, boolean z) {
            c0155b.Bt = true;
            return true;
        }
    }

    public static void a(com.kwad.components.core.n.kwai.b bVar) {
        SceneImpl sceneImpl = bVar.Ow;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.m.a.pb().pe();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.C(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.ac();
            KsAdLoadManager.a(new a.C0180a().e(bVar).aH(false).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.4
                final /* synthetic */ long Br;

                AnonymousClass4(long elapsedRealtime2) {
                    elapsedRealtime = elapsedRealtime2;
                }

                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
                public final void a(@NonNull AdResultData adResultData) {
                    if (adResultData.getAdTemplateList().size() > 0) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.rV().b(adResultData, false));
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                        com.kwad.components.core.m.a.pb().aC(adResultData.getAdTemplateList().size());
                    }
                }

                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
                public final void onError(int i2, String str) {
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.b(i2, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                }
            }).pj());
        }
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        a aVar = new a((byte) 0);
        aVar.Bs = false;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(covert);
        C0155b c0155b = new C0155b((byte) 0);
        com.kwad.components.core.m.a.pb().pd();
        Handler handler = mHandler;
        handler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.a(com.kwad.components.core.n.kwai.b.this);
            }
        }, 15000L);
        AnonymousClass2 anonymousClass2 = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.2
            final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;
            final /* synthetic */ SceneImpl el;

            AnonymousClass2(KsLoadManager.SplashScreenAdListener splashScreenAdListener2, SceneImpl covert2) {
                splashScreenAdListener = splashScreenAdListener2;
                covert = covert2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C0155b.a(C0155b.this, true);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agp;
                splashScreenAdListener2.onError(fVar.errorCode, fVar.msg);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.agp;
                com.kwad.components.splash.monitor.a.a("", false, fVar2.errorCode, fVar2.msg, covert.getPosId());
                com.kwad.components.core.m.a.pb().aB(4);
            }
        };
        int a3 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BP);
        if (a3 < 0) {
            a3 = 5000;
        }
        handler.postDelayed(anonymousClass2, a3);
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.B(covert2.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(bVar).aG(true).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.3
            final /* synthetic */ KsLoadManager.SplashScreenAdListener Bm;
            final /* synthetic */ Runnable Bn;
            final /* synthetic */ a Bo;
            final /* synthetic */ SceneImpl el;
            final /* synthetic */ long gh;

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                AnonymousClass1(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    splashScreenAdListener.onError(i2, str);
                    if (i2 == com.kwad.sdk.core.network.f.agq.errorCode) {
                        com.kwad.components.core.m.a.pb().aB(0);
                    } else {
                        com.kwad.components.core.m.a.pb().aB(3);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ AdResultData iv;

                AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$3 */
            final class RunnableC01533 implements Runnable {
                final /* synthetic */ KsSplashScreenAd Bq;

                RunnableC01533(KsSplashScreenAd ksSplashScreenAdControl2) {
                    ksSplashScreenAdControl = ksSplashScreenAdControl2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$4 */
            final class AnonymousClass4 implements Runnable {
                final /* synthetic */ KsSplashScreenAd Bq;

                AnonymousClass4(KsSplashScreenAd ksSplashScreenAdControl2) {
                    ksSplashScreenAdControl = ksSplashScreenAdControl2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
            }

            AnonymousClass3(Runnable anonymousClass22, a aVar2, SceneImpl covert2, KsLoadManager.SplashScreenAdListener splashScreenAdListener2, long elapsedRealtime2) {
                runnable = anonymousClass22;
                aVar = aVar2;
                covert = covert2;
                splashScreenAdListener = splashScreenAdListener2;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(int i22, String str2, boolean z) {
                if (C0155b.this.Bt) {
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i22), str2));
                } else {
                    b.mHandler.removeCallbacks(runnable);
                    if (!aVar.Bs) {
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.a("", z, i22, str2, covert.getPosId());
                    }
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                        final /* synthetic */ int ck;
                        final /* synthetic */ String cl;

                        AnonymousClass1(int i222, String str22) {
                            i2 = i222;
                            str = str22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                            splashScreenAdListener.onError(i2, str);
                            if (i2 == com.kwad.sdk.core.network.f.agq.errorCode) {
                                com.kwad.components.core.m.a.pb().aB(0);
                            } else {
                                com.kwad.components.core.m.a.pb().aB(3);
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData2, boolean z) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    final /* synthetic */ AdResultData iv;

                    AnonymousClass2(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                if (adResultData22.getAdTemplateList().size() <= 0) {
                    if (C0155b.this.Bt) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.a("", z, com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData22.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData22.testErrorMsg, covert.getPosId());
                    aVar.Bs = true;
                    a(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData22.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData22.testErrorMsg, z);
                    com.kwad.components.core.m.a.pb().aB(3);
                    return;
                }
                AdTemplate adTemplate = adResultData22.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                adTemplate.notNetworkRequest = z;
                com.kwad.sdk.core.response.a.d.cb(adTemplate);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.T(adTemplate);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "dataReady").report();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                KsSplashScreenAd ksSplashScreenAdControl2 = new KsSplashScreenAdControl(covert, adResultData22);
                boolean f2 = SplashPreloadManager.rV().f(adResultData22);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f2);
                if (!f2) {
                    SplashPreloadManager.rV();
                    if (!SplashPreloadManager.g(adResultData22)) {
                        if (C0155b.this.Bt) {
                            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        b.mHandler.removeCallbacks(runnable);
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 5, elapsedRealtime2);
                        aVar.Bs = true;
                        a(com.kwad.sdk.core.network.f.ago.errorCode, "请求成功，但缓存未命中", z);
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                        com.kwad.components.core.m.a.pb().aB(3);
                        return;
                    }
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int b2 = SplashPreloadManager.rV().b(adResultData22, true);
                    if (!C0155b.this.Bt) {
                        b.mHandler.removeCallbacks(runnable);
                        if (b2 > 0) {
                            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                final /* synthetic */ KsSplashScreenAd Bq;

                                AnonymousClass4(KsSplashScreenAd ksSplashScreenAdControl22) {
                                    ksSplashScreenAdControl = ksSplashScreenAdControl22;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.printStackTrace(th);
                                    }
                                }
                            });
                            com.kwad.components.splash.monitor.a.rY();
                            com.kwad.components.splash.monitor.a.b(adTemplate, 3, elapsedRealtime2);
                            com.kwad.components.core.m.a.pb().aB(2);
                            return;
                        }
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 4, elapsedRealtime2);
                        aVar.Bs = true;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.agq;
                        a(fVar.errorCode, fVar.msg, z);
                        return;
                    }
                } else if (!C0155b.this.Bt) {
                    b.mHandler.removeCallbacks(runnable);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.3
                        final /* synthetic */ KsSplashScreenAd Bq;

                        RunnableC01533(KsSplashScreenAd ksSplashScreenAdControl22) {
                            ksSplashScreenAdControl = ksSplashScreenAdControl22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                                splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.b.printStackTrace(th);
                            }
                        }
                    });
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.b(adTemplate, 2, elapsedRealtime2);
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                    com.kwad.components.core.m.a.pb().aB(1);
                    return;
                }
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.c(adTemplate, 7, elapsedRealtime2);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            }
        }).pj());
    }
}
