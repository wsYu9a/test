package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.media3.common.C;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: hf */
    private static final Handler f11898hf = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.ad.splashscreen.b$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.a(ImpInfo.this);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
        final /* synthetic */ SceneImpl bV;

        public AnonymousClass2(KsLoadManager.SplashScreenAdListener splashScreenAdListener, SceneImpl sceneImpl) {
            splashScreenAdListener = splashScreenAdListener;
            covert = sceneImpl;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            C0404b.a(C0404b.this, true);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
            KsLoadManager.SplashScreenAdListener splashScreenAdListener = splashScreenAdListener;
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azC;
            splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azC;
            com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
            com.kwad.components.core.o.a.ri().aE(4);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass4(KsLoadManager.SplashScreenAdListener splashScreenAdListener, AdTemplate adTemplate) {
            splashScreenAdListener = splashScreenAdListener;
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                com.kwad.components.ad.splashscreen.monitor.a.lk().aa(adTemplate);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$5 */
    public class AnonymousClass5 extends com.kwad.components.core.request.d {
        final /* synthetic */ long DC;

        public AnonymousClass5(long j10) {
            elapsedRealtime = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            try {
                if (adResultData.getAdTemplateList().size() > 0) {
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.kQ().b(adResultData, false));
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                    com.kwad.components.core.o.a.ri().aF(adResultData.getAdTemplateList().size());
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.b(i10, str, SceneImpl.this.getPosId());
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
        }
    }

    public static class a {
        private volatile boolean DD;

        private a() {
            this.DD = false;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b */
    public static class C0404b {
        private volatile boolean DE;

        private C0404b() {
            this.DE = false;
        }

        public static /* synthetic */ boolean a(C0404b c0404b, boolean z10) {
            c0404b.DE = true;
            return true;
        }

        public /* synthetic */ C0404b(byte b10) {
            this();
        }
    }

    public static boolean a(C0404b c0404b, AdTemplate adTemplate, long j10, long j11, Runnable runnable) {
        if (!c0404b.DE) {
            f11898hf.removeCallbacks(runnable);
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j10, j11);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
        return true;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.p(covert.getPosId());
        boolean a10 = m.si().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        a aVar = new a((byte) 0);
        aVar.DD = false;
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        ImpInfo impInfo = new ImpInfo(covert);
        C0404b c0404b = new C0404b((byte) 0);
        com.kwad.components.core.o.a.ri().rk();
        Handler handler = f11898hf;
        handler.postDelayed(new bd() { // from class: com.kwad.components.ad.splashscreen.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        AnonymousClass2 anonymousClass2 = new bd() { // from class: com.kwad.components.ad.splashscreen.b.2
            final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
            final /* synthetic */ SceneImpl bV;

            public AnonymousClass2(KsLoadManager.SplashScreenAdListener splashScreenAdListener2, SceneImpl covert2) {
                splashScreenAdListener = splashScreenAdListener2;
                covert = covert2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                C0404b.a(C0404b.this, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azC;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.lm();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azC;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.ri().aE(4);
            }
        };
        int a11 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Ep);
        if (a11 < 0) {
            a11 = 5000;
        }
        handler.postDelayed(anonymousClass2, a11);
        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert2.getPosId(), elapsedRealtime3);
        KsAdLoadManager.M().a(new a.C0445a().e(impInfo).aJ(true).aK(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
            final /* synthetic */ Runnable Dx;
            final /* synthetic */ a Dy;
            final /* synthetic */ long Dz;
            final /* synthetic */ SceneImpl bV;
            final /* synthetic */ long hM;

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i10, String str) {
                    i10 = i10;
                    str = str;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    splashScreenAdListener.onError(i10, str);
                    if (i10 == com.kwad.sdk.core.network.e.azD.errorCode) {
                        com.kwad.components.core.o.a.ri().aE(0);
                    } else {
                        com.kwad.components.core.o.a.ri().aE(3);
                    }
                }
            }

            /* renamed from: com.kwad.components.ad.splashscreen.b$3$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ AdResultData jX;

                public AnonymousClass2(AdResultData adResultData) {
                    adResultData = adResultData;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        com.kwad.components.ad.splashscreen.monitor.a.lk().o(covert.getPosId());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }

            public AnonymousClass3(Runnable anonymousClass22, a aVar2, SceneImpl covert2, KsLoadManager.SplashScreenAdListener splashScreenAdListener2, long elapsedRealtime22, long elapsedRealtime32) {
                bdVar = anonymousClass22;
                aVar = aVar2;
                covert = covert2;
                splashScreenAdListener = splashScreenAdListener2;
                elapsedRealtime2 = elapsedRealtime22;
                elapsedRealtime3 = elapsedRealtime32;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(int i10, String str, boolean z10) {
                if (C0404b.this.DE) {
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    return;
                }
                b.f11898hf.removeCallbacks(bdVar);
                if (!aVar.DD && i10 != com.kwad.sdk.core.network.e.azA.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z10, i10, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z10, i10, str, covert.getPosId());
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public AnonymousClass1(int i102, String str2) {
                        i10 = i102;
                        str = str2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        splashScreenAdListener.onError(i10, str);
                        if (i10 == com.kwad.sdk.core.network.e.azD.errorCode) {
                            com.kwad.components.core.o.a.ri().aE(0);
                        } else {
                            com.kwad.components.core.o.a.ri().aE(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                boolean z11;
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    final /* synthetic */ AdResultData jX;

                    public AnonymousClass2(AdResultData adResultData2) {
                        adResultData = adResultData2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.lk().o(covert.getPosId());
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        }
                    }
                });
                try {
                    if (b.a(adResultData2, aVar, this, z10, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData2.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.notNetworkRequest = z10;
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    ?? ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData2);
                    if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Et)) {
                        try {
                            SplashPreloadManager.kQ();
                            if (SplashPreloadManager.g(adResultData2)) {
                                if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                if (SplashPreloadManager.kQ().f(adResultData2)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.o.a.ri().aE(1);
                                    return;
                                }
                                if (SplashPreloadManager.kQ().b(adResultData2, true) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.components.core.o.a.ri().aE(2);
                                    return;
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z11 = z10;
                            ServiceProvider.reportSdkCaughtException(th);
                            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azF;
                            a(eVar.errorCode, eVar.msg, z11);
                        }
                    }
                    SplashPreloadManager.kQ();
                    if (!SplashPreloadManager.g(adResultData2)) {
                        SplashPreloadManager.kQ();
                        if (!SplashPreloadManager.h(adResultData2)) {
                            if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.lm();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.o.a.ri().aE(5);
                            return;
                        }
                    }
                    boolean f10 = SplashPreloadManager.kQ().f(adResultData2);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f10);
                    if (f10) {
                        if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.ri().aE(1);
                        return;
                    }
                    SplashPreloadManager.kQ();
                    try {
                        if (!SplashPreloadManager.g(adResultData2)) {
                            if (!C0404b.this.DE) {
                                b.f11898hf.removeCallbacks(bdVar);
                                com.kwad.components.ad.splashscreen.monitor.b.lm();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                                aVar.DD = true;
                                a(com.kwad.sdk.core.network.e.azB.errorCode, "请求成功，但缓存未命中", z10);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                com.kwad.components.core.o.a.ri().aE(3);
                                return;
                            }
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int b10 = SplashPreloadManager.kQ().b(adResultData2, true);
                        if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                            return;
                        }
                        if (b10 > 0) {
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.lm();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.components.core.o.a.ri().aE(2);
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                        aVar.DD = true;
                        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azD;
                        a(eVar2.errorCode, eVar2.msg, z10);
                    } catch (Throwable th3) {
                        th = th3;
                        z11 = ksSplashScreenAdControl;
                        ServiceProvider.reportSdkCaughtException(th);
                        com.kwad.sdk.core.network.e eVar3 = com.kwad.sdk.core.network.e.azF;
                        a(eVar3.errorCode, eVar3.msg, z11);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z11 = z10;
                }
            }
        }).rA());
    }

    public static void a(KsLoadManager.SplashScreenAdListener splashScreenAdListener, KsSplashScreenAd ksSplashScreenAd, AdTemplate adTemplate) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.b.4
            final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass4(KsLoadManager.SplashScreenAdListener splashScreenAdListener2, AdTemplate adTemplate2) {
                splashScreenAdListener = splashScreenAdListener2;
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.lk().aa(adTemplate);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }

    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z10, long j10) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.c(z10, com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg, j10);
        aVar.DD = true;
        dVar.a(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg, z10);
        com.kwad.components.core.o.a.ri().aE(3);
        return true;
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$3 */
    public class AnonymousClass3 extends com.kwad.components.core.request.d {
        final /* synthetic */ KsLoadManager.SplashScreenAdListener Dw;
        final /* synthetic */ Runnable Dx;
        final /* synthetic */ a Dy;
        final /* synthetic */ long Dz;
        final /* synthetic */ SceneImpl bV;
        final /* synthetic */ long hM;

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public AnonymousClass1(int i102, String str2) {
                i10 = i102;
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                splashScreenAdListener.onError(i10, str);
                if (i10 == com.kwad.sdk.core.network.e.azD.errorCode) {
                    com.kwad.components.core.o.a.ri().aE(0);
                } else {
                    com.kwad.components.core.o.a.ri().aE(3);
                }
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.b$3$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ AdResultData jX;

            public AnonymousClass2(AdResultData adResultData2) {
                adResultData = adResultData2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                    com.kwad.components.ad.splashscreen.monitor.a.lk().o(covert.getPosId());
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        public AnonymousClass3(Runnable anonymousClass22, a aVar2, SceneImpl covert2, KsLoadManager.SplashScreenAdListener splashScreenAdListener2, long elapsedRealtime22, long elapsedRealtime32) {
            bdVar = anonymousClass22;
            aVar = aVar2;
            covert = covert2;
            splashScreenAdListener = splashScreenAdListener2;
            elapsedRealtime2 = elapsedRealtime22;
            elapsedRealtime3 = elapsedRealtime32;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(int i102, String str2, boolean z10) {
            if (C0404b.this.DE) {
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i102), str2));
                return;
            }
            b.f11898hf.removeCallbacks(bdVar);
            if (!aVar.DD && i102 != com.kwad.sdk.core.network.e.azA.errorCode) {
                com.kwad.components.ad.splashscreen.monitor.b.lm();
                com.kwad.components.ad.splashscreen.monitor.b.b(z10, i102, str2, covert.getPosId());
                com.kwad.components.ad.splashscreen.monitor.b.lm();
                com.kwad.components.ad.splashscreen.monitor.b.c(z10, i102, str2, covert.getPosId());
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i1022, String str22) {
                    i10 = i1022;
                    str = str22;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    splashScreenAdListener.onError(i10, str);
                    if (i10 == com.kwad.sdk.core.network.e.azD.errorCode) {
                        com.kwad.components.core.o.a.ri().aE(0);
                    } else {
                        com.kwad.components.core.o.a.ri().aE(3);
                    }
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData2, boolean z10) {
            boolean z11;
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                final /* synthetic */ AdResultData jX;

                public AnonymousClass2(AdResultData adResultData22) {
                    adResultData = adResultData22;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        com.kwad.components.ad.splashscreen.monitor.a.lk().o(covert.getPosId());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            });
            try {
                if (b.a(adResultData22, aVar, this, z10, covert.posId)) {
                    return;
                }
                AdTemplate adTemplate = adResultData22.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                adTemplate.notNetworkRequest = z10;
                com.kwad.components.ad.splashscreen.monitor.b.lm();
                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                com.kwad.sdk.commercial.d.d.a(covert, 1);
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                ?? ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData22);
                if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Et)) {
                    try {
                        SplashPreloadManager.kQ();
                        if (SplashPreloadManager.g(adResultData22)) {
                            if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            if (SplashPreloadManager.kQ().f(adResultData22)) {
                                com.kwad.components.ad.splashscreen.monitor.b.lm();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                com.kwad.components.core.o.a.ri().aE(1);
                                return;
                            }
                            if (SplashPreloadManager.kQ().b(adResultData22, true) > 0) {
                                com.kwad.components.ad.splashscreen.monitor.b.lm();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.components.core.o.a.ri().aE(2);
                                return;
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.lm();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z11 = z10;
                        ServiceProvider.reportSdkCaughtException(th);
                        com.kwad.sdk.core.network.e eVar3 = com.kwad.sdk.core.network.e.azF;
                        a(eVar3.errorCode, eVar3.msg, z11);
                    }
                }
                SplashPreloadManager.kQ();
                if (!SplashPreloadManager.g(adResultData22)) {
                    SplashPreloadManager.kQ();
                    if (!SplashPreloadManager.h(adResultData22)) {
                        if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                        com.kwad.components.core.o.a.ri().aE(5);
                        return;
                    }
                }
                boolean f10 = SplashPreloadManager.kQ().f(adResultData22);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f10);
                if (f10) {
                    if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                        return;
                    }
                    b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                    com.kwad.components.core.o.a.ri().aE(1);
                    return;
                }
                SplashPreloadManager.kQ();
                try {
                    if (!SplashPreloadManager.g(adResultData22)) {
                        if (!C0404b.this.DE) {
                            b.f11898hf.removeCallbacks(bdVar);
                            com.kwad.components.ad.splashscreen.monitor.b.lm();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            aVar.DD = true;
                            a(com.kwad.sdk.core.network.e.azB.errorCode, "请求成功，但缓存未命中", z10);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.o.a.ri().aE(3);
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int b10 = SplashPreloadManager.kQ().b(adResultData22, true);
                    if (b.a(C0404b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, bdVar)) {
                        return;
                    }
                    if (b10 > 0) {
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.components.core.o.a.ri().aE(2);
                        return;
                    }
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                    aVar.DD = true;
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azD;
                    a(eVar2.errorCode, eVar2.msg, z10);
                } catch (Throwable th3) {
                    th = th3;
                    z11 = ksSplashScreenAdControl;
                    ServiceProvider.reportSdkCaughtException(th);
                    com.kwad.sdk.core.network.e eVar32 = com.kwad.sdk.core.network.e.azF;
                    a(eVar32.errorCode, eVar32.msg, z11);
                }
            } catch (Throwable th4) {
                th = th4;
                z11 = z10;
            }
        }
    }

    public static void a(ImpInfo impInfo) {
        SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.ri().rl();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new a.C0445a().e(impInfo2).aK(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                final /* synthetic */ long DC;

                public AnonymousClass5(long elapsedRealtime2) {
                    elapsedRealtime = elapsedRealtime2;
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void b(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.kQ().b(adResultData, false));
                            com.kwad.components.ad.splashscreen.monitor.b.lm();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.o.a.ri().aF(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void onError(int i10, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i10, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                }
            }).rA());
        }
    }
}
