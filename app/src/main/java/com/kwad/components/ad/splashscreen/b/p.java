package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: classes2.dex */
public final class p extends e implements com.kwad.sdk.core.g.c {
    private SkipView Dn;
    private ImageView gT;
    private AdInfo mAdInfo;
    private volatile boolean Dl = false;
    private boolean Dm = false;
    private boolean Ci = false;
    private boolean Cl = false;
    private h.a gV = new h.a() { // from class: com.kwad.components.ad.splashscreen.b.p.1

        /* renamed from: com.kwad.components.ad.splashscreen.b.p$1$1 */
        final class RunnableC01601 implements Runnable {
            RunnableC01601() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                p pVar = p.this;
                com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
                if (aVar != null) {
                    aVar.setAudioEnabled(pVar.Dl, false);
                }
                com.kwad.components.ad.splashscreen.h hVar = p.this.Cg;
                if (hVar != null) {
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
                    boolean z = p.this.Dl;
                    AdInfo.AdSplashInfo adSplashInfo = cb.adSplashInfo;
                    String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    } else {
                        KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
                    }
                    p.this.gT.setSelected(false);
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            p.this.Dl = false;
            if (p.this.gT != null) {
                p.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.1.1
                    RunnableC01601() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar = p.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
                        if (aVar != null) {
                            aVar.setAudioEnabled(pVar.Dl, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = p.this.Cg;
                        if (hVar != null) {
                            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
                            boolean z = p.this.Dl;
                            AdInfo.AdSplashInfo adSplashInfo = cb.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
                            }
                            p.this.gT.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.i Do = new com.kwad.components.core.video.i() { // from class: com.kwad.components.ad.splashscreen.b.p.2
        private boolean Dr = false;
        private String Ds = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BQ);

        /* renamed from: com.kwad.components.ad.splashscreen.b.p$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ int Dt;
            final /* synthetic */ long Du;
            final /* synthetic */ String Dv;

            AnonymousClass1(int i2, long j2, String str) {
                min = i2;
                j3 = j2;
                str = str;
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SetTextI18n"})
            public final void run() {
                int i2 = (int) (((min * 1000) - j3) / 1000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                p.this.Dn.ag(str + i2);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (this.Dr) {
                return;
            }
            p.this.Cg.kw();
            this.Dr = true;
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            if (p.this.Cl) {
                return;
            }
            p.this.Cg.f(0, "onVideoPlayError");
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            p.this.Cg.ab(((int) j3) / 1000);
            int min = Math.min(p.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j2) / 1000);
            String str = this.Ds;
            p pVar = p.this;
            if (p.a(pVar, pVar.mAdInfo)) {
                p.this.Dn.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.2.1
                    final /* synthetic */ int Dt;
                    final /* synthetic */ long Du;
                    final /* synthetic */ String Dv;

                    AnonymousClass1(int min2, long j32, String str2) {
                        min = min2;
                        j3 = j32;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i2 = (int) (((min * 1000) - j3) / 1000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        p.this.Dn.ag(str + i2);
                    }
                });
            }
            float f2 = j32 / 1000.0f;
            if (min2 > 0) {
                double d2 = f2;
                Double.isNaN(d2);
                if (d2 + 0.5d <= min2 - 1 || this.Dr) {
                    return;
                }
                p pVar2 = p.this;
                if (p.a(pVar2, pVar2.mAdInfo)) {
                    p.this.Cg.kw();
                    this.Dr = true;
                }
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            p pVar = p.this;
            com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
            if (aVar != null) {
                aVar.setAudioEnabled(pVar.Dl, false);
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            if (p.this.Dm) {
                return;
            }
            p.this.Cg.kv();
            com.kwad.components.ad.splashscreen.d.a aVar = p.this.Cg.BG;
            if (aVar != null) {
                aVar.aj(true);
                p pVar = p.this;
                pVar.Cg.BG.setAudioEnabled(pVar.Dl, true);
            }
            p.b(p.this, true);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPrepared() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPreparing() {
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.b.p$1 */
    final class AnonymousClass1 implements h.a {

        /* renamed from: com.kwad.components.ad.splashscreen.b.p$1$1 */
        final class RunnableC01601 implements Runnable {
            RunnableC01601() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                p pVar = p.this;
                com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
                if (aVar != null) {
                    aVar.setAudioEnabled(pVar.Dl, false);
                }
                com.kwad.components.ad.splashscreen.h hVar = p.this.Cg;
                if (hVar != null) {
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
                    boolean z = p.this.Dl;
                    AdInfo.AdSplashInfo adSplashInfo = cb.adSplashInfo;
                    String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    } else {
                        KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
                    }
                    p.this.gT.setSelected(false);
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            p.this.Dl = false;
            if (p.this.gT != null) {
                p.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.1.1
                    RunnableC01601() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar = p.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
                        if (aVar != null) {
                            aVar.setAudioEnabled(pVar.Dl, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = p.this.Cg;
                        if (hVar != null) {
                            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
                            boolean z = p.this.Dl;
                            AdInfo.AdSplashInfo adSplashInfo = cb.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
                            }
                            p.this.gT.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.p$2 */
    final class AnonymousClass2 implements com.kwad.components.core.video.i {
        private boolean Dr = false;
        private String Ds = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BQ);

        /* renamed from: com.kwad.components.ad.splashscreen.b.p$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ int Dt;
            final /* synthetic */ long Du;
            final /* synthetic */ String Dv;

            AnonymousClass1(int min2, long j32, String str2) {
                min = min2;
                j3 = j32;
                str = str2;
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SetTextI18n"})
            public final void run() {
                int i2 = (int) (((min * 1000) - j3) / 1000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                p.this.Dn.ag(str + i2);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (this.Dr) {
                return;
            }
            p.this.Cg.kw();
            this.Dr = true;
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            if (p.this.Cl) {
                return;
            }
            p.this.Cg.f(0, "onVideoPlayError");
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j32) {
            p.this.Cg.ab(((int) j32) / 1000);
            int min2 = Math.min(p.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j2) / 1000);
            String str2 = this.Ds;
            p pVar = p.this;
            if (p.a(pVar, pVar.mAdInfo)) {
                p.this.Dn.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.2.1
                    final /* synthetic */ int Dt;
                    final /* synthetic */ long Du;
                    final /* synthetic */ String Dv;

                    AnonymousClass1(int min22, long j322, String str22) {
                        min = min22;
                        j3 = j322;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i2 = (int) (((min * 1000) - j3) / 1000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        p.this.Dn.ag(str + i2);
                    }
                });
            }
            float f2 = j322 / 1000.0f;
            if (min22 > 0) {
                double d2 = f2;
                Double.isNaN(d2);
                if (d2 + 0.5d <= min22 - 1 || this.Dr) {
                    return;
                }
                p pVar2 = p.this;
                if (p.a(pVar2, pVar2.mAdInfo)) {
                    p.this.Cg.kw();
                    this.Dr = true;
                }
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            p pVar = p.this;
            com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cg.BG;
            if (aVar != null) {
                aVar.setAudioEnabled(pVar.Dl, false);
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            if (p.this.Dm) {
                return;
            }
            p.this.Cg.kv();
            com.kwad.components.ad.splashscreen.d.a aVar = p.this.Cg.BG;
            if (aVar != null) {
                aVar.aj(true);
                p pVar = p.this;
                pVar.Cg.BG.setAudioEnabled(pVar.Dl, true);
            }
            p.b(p.this, true);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPrepared() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPreparing() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.p$3 */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p.this.Dl = !r4.Dl;
            String str = p.this.Dl ? p.this.mAdInfo.adSplashInfo.speakerIconUrl : p.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
            if (TextUtils.isEmpty(str)) {
                p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
            } else {
                KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
            }
            p.this.gT.setSelected(p.this.Dl);
            p pVar = p.this;
            pVar.Cg.BG.setAudioEnabled(pVar.Dl, true);
        }
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.a.a.cf(adInfo));
    }

    static /* synthetic */ boolean a(p pVar, AdInfo adInfo) {
        return q(adInfo);
    }

    static /* synthetic */ boolean b(p pVar, boolean z) {
        pVar.Dm = true;
        return true;
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.cc(adInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ar() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.p.ar():void");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Cl = true;
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cg.BG;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        if (this.Ci) {
            return;
        }
        this.Ci = true;
        com.kwad.components.ad.splashscreen.local.c.R(getContext());
        com.kwad.components.core.r.b.pK().a(this.Cg.mAdTemplate, null, null);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cg.BG;
        if (aVar != null) {
            aVar.b(this.Do);
            this.Cg.BG.b(this.gV);
        }
        if (this.Dn.getHandler() != null) {
            this.Dn.getHandler().removeCallbacksAndMessages(null);
        }
        this.Cg.BH.b(this);
    }
}
