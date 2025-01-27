package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.i;

/* loaded from: classes2.dex */
public final class q extends e implements com.kwad.sdk.core.h.c {
    private SkipView FO;
    private ImageView iE;
    private AdInfo mAdInfo;
    private volatile boolean FL = false;
    private boolean FM = false;
    private boolean FN = false;
    private i.a iF = new i.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$1$1 */
        public class C04131 extends bd {
            public C04131() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                q qVar = q.this;
                com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
                if (aVar != null) {
                    aVar.setAudioEnabled(qVar.FL, false);
                }
                com.kwad.components.ad.splashscreen.h hVar = q.this.EJ;
                if (hVar != null) {
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(hVar.mAdTemplate);
                    String str = q.this.FL ? eb2.adSplashInfo.speakerIconUrl : eb2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    } else {
                        KSImageLoader.loadImage(q.this.iE, str, q.this.EJ.mAdTemplate);
                    }
                    q.this.iE.setSelected(false);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            q.this.FL = false;
            if (q.this.iE != null) {
                q.this.iE.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                    public C04131() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        q qVar = q.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
                        if (aVar != null) {
                            aVar.setAudioEnabled(qVar.FL, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = q.this.EJ;
                        if (hVar != null) {
                            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(hVar.mAdTemplate);
                            String str = q.this.FL ? eb2.adSplashInfo.speakerIconUrl : eb2.adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(q.this.iE, str, q.this.EJ.mAdTemplate);
                            }
                            q.this.iE.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.k FP = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2
        private boolean FS = false;
        private String FT = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Eq);

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ int FU;
            final /* synthetic */ String FV;

            /* renamed from: tj */
            final /* synthetic */ long f11907tj;

            public AnonymousClass1(int i10, long j10, String str) {
                min = i10;
                j11 = j10;
                str = str;
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SetTextI18n"})
            public final void run() {
                int i10 = (int) (((min * 1000) - j11) / 1000);
                if (i10 <= 0) {
                    i10 = 1;
                }
                q.this.FO.Y(str + i10);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (this.FS) {
                return;
            }
            q.this.EJ.ld();
            this.FS = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            if (q.this.FN) {
                return;
            }
            q.this.EJ.c(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            q.this.EJ.Y(((int) j11) / 1000);
            int min = Math.min(q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j10) / 1000);
            String str = this.FT;
            q qVar = q.this;
            if (q.a(qVar, qVar.mAdInfo)) {
                q.this.FO.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2.1
                    final /* synthetic */ int FU;
                    final /* synthetic */ String FV;

                    /* renamed from: tj */
                    final /* synthetic */ long f11907tj;

                    public AnonymousClass1(int min2, long j112, String str2) {
                        min = min2;
                        j11 = j112;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i10 = (int) (((min * 1000) - j11) / 1000);
                        if (i10 <= 0) {
                            i10 = 1;
                        }
                        q.this.FO.Y(str + i10);
                    }
                });
            }
            float f10 = j112 / 1000.0f;
            if (min2 <= 0 || f10 + 0.5d <= min2 - 1 || this.FS) {
                return;
            }
            q qVar2 = q.this;
            if (q.a(qVar2, qVar2.mAdInfo)) {
                q.this.EJ.ld();
                this.FS = true;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            q qVar = q.this;
            com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
            if (aVar != null) {
                aVar.setAudioEnabled(qVar.FL, false);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (q.this.FM) {
                return;
            }
            q.this.EJ.kT();
            com.kwad.components.ad.splashscreen.d.a aVar = q.this.EJ.DT;
            if (aVar != null) {
                aVar.af(true);
                q qVar = q.this;
                qVar.EJ.DT.setAudioEnabled(qVar.FL, true);
            }
            q.b(q.this, true);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$1 */
    public class AnonymousClass1 implements i.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$1$1 */
        public class C04131 extends bd {
            public C04131() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                q qVar = q.this;
                com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
                if (aVar != null) {
                    aVar.setAudioEnabled(qVar.FL, false);
                }
                com.kwad.components.ad.splashscreen.h hVar = q.this.EJ;
                if (hVar != null) {
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(hVar.mAdTemplate);
                    String str = q.this.FL ? eb2.adSplashInfo.speakerIconUrl : eb2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    } else {
                        KSImageLoader.loadImage(q.this.iE, str, q.this.EJ.mAdTemplate);
                    }
                    q.this.iE.setSelected(false);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            q.this.FL = false;
            if (q.this.iE != null) {
                q.this.iE.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                    public C04131() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        q qVar = q.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
                        if (aVar != null) {
                            aVar.setAudioEnabled(qVar.FL, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = q.this.EJ;
                        if (hVar != null) {
                            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(hVar.mAdTemplate);
                            String str = q.this.FL ? eb2.adSplashInfo.speakerIconUrl : eb2.adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(q.this.iE, str, q.this.EJ.mAdTemplate);
                            }
                            q.this.iE.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$2 */
    public class AnonymousClass2 extends com.kwad.components.core.video.l {
        private boolean FS = false;
        private String FT = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Eq);

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ int FU;
            final /* synthetic */ String FV;

            /* renamed from: tj */
            final /* synthetic */ long f11907tj;

            public AnonymousClass1(int min2, long j112, String str2) {
                min = min2;
                j11 = j112;
                str = str2;
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SetTextI18n"})
            public final void run() {
                int i10 = (int) (((min * 1000) - j11) / 1000);
                if (i10 <= 0) {
                    i10 = 1;
                }
                q.this.FO.Y(str + i10);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            if (this.FS) {
                return;
            }
            q.this.EJ.ld();
            this.FS = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            if (q.this.FN) {
                return;
            }
            q.this.EJ.c(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j112) {
            q.this.EJ.Y(((int) j112) / 1000);
            int min2 = Math.min(q.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j10) / 1000);
            String str2 = this.FT;
            q qVar = q.this;
            if (q.a(qVar, qVar.mAdInfo)) {
                q.this.FO.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2.1
                    final /* synthetic */ int FU;
                    final /* synthetic */ String FV;

                    /* renamed from: tj */
                    final /* synthetic */ long f11907tj;

                    public AnonymousClass1(int min22, long j1122, String str22) {
                        min = min22;
                        j11 = j1122;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i10 = (int) (((min * 1000) - j11) / 1000);
                        if (i10 <= 0) {
                            i10 = 1;
                        }
                        q.this.FO.Y(str + i10);
                    }
                });
            }
            float f10 = j1122 / 1000.0f;
            if (min22 <= 0 || f10 + 0.5d <= min22 - 1 || this.FS) {
                return;
            }
            q qVar2 = q.this;
            if (q.a(qVar2, qVar2.mAdInfo)) {
                q.this.EJ.ld();
                this.FS = true;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            q qVar = q.this;
            com.kwad.components.ad.splashscreen.d.a aVar = qVar.EJ.DT;
            if (aVar != null) {
                aVar.setAudioEnabled(qVar.FL, false);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            if (q.this.FM) {
                return;
            }
            q.this.EJ.kT();
            com.kwad.components.ad.splashscreen.d.a aVar = q.this.EJ.DT;
            if (aVar != null) {
                aVar.af(true);
                q qVar = q.this;
                qVar.EJ.DT.setAudioEnabled(qVar.FL, true);
            }
            q.b(q.this, true);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ View FX;
        final /* synthetic */ DetailVideoView FY;

        public AnonymousClass3(View view, DetailVideoView detailVideoView) {
            findViewById = view;
            detailVideoView = detailVideoView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            float width = findViewById.getWidth();
            float height = findViewById.getHeight();
            if (width <= 0.0f || height <= 0.0f) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aV(q.this.mAdInfo).videoWidth > 0) {
                com.kwad.sdk.c.a.a.a(detailVideoView, r0.width, r0.height);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.q$4 */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q.this.FL = !r4.FL;
            String str = q.this.FL ? q.this.mAdInfo.adSplashInfo.speakerIconUrl : q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
            if (TextUtils.isEmpty(str)) {
                q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
            } else {
                KSImageLoader.loadImage(q.this.iE, str, q.this.EJ.mAdTemplate);
            }
            q.this.iE.setSelected(q.this.FL);
            q qVar = q.this;
            qVar.EJ.DT.setAudioEnabled(qVar.FL, true);
        }
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cC(adInfo);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.EJ.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.m37do(this.mAdInfo)) {
            a(detailVideoView);
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.b(this.FP);
        }
        this.EJ.DV.a(this);
        this.FO = (SkipView) this.EJ.mRootContainer.findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        if (u(this.mAdInfo)) {
            a(this.FO, this.mAdInfo);
        }
        int i10 = this.mAdInfo.adSplashInfo.mute;
        if (i10 == 2) {
            this.FL = true;
        } else if (i10 != 3) {
            this.FL = false;
        } else {
            this.FL = com.kwad.sdk.utils.l.cj(this.EJ.mRootContainer.getContext()) > 0;
        }
        if (com.kwad.components.core.s.a.av(getContext()).sa()) {
            this.FL = false;
        }
        com.kwad.components.ad.splashscreen.d.a aVar2 = this.EJ.DT;
        if (aVar2 != null) {
            aVar2.setAudioEnabled(this.FL, false);
            this.EJ.DT.a(this.iF);
        }
        this.iE = (ImageView) this.EJ.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iE.getLayoutParams();
            layoutParams.gravity = 51;
            this.iE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iE.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.iE.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.iE.getContext(), 16.0f);
            }
        }
        this.iE.setVisibility(0);
        String str = this.FL ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (TextUtils.isEmpty(str)) {
            this.iE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        } else {
            KSImageLoader.loadImage(this.iE, str, this.EJ.mAdTemplate);
        }
        this.iE.setSelected(this.FL);
        this.iE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.q.4
            public AnonymousClass4() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.this.FL = !r4.FL;
                String str2 = q.this.FL ? q.this.mAdInfo.adSplashInfo.speakerIconUrl : q.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    q.this.iE.setImageDrawable(q.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(q.this.iE, str2, q.this.EJ.mAdTemplate);
                }
                q.this.iE.setSelected(q.this.FL);
                q qVar = q.this;
                qVar.EJ.DT.setAudioEnabled(qVar.FL, true);
            }
        });
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.FN = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            aVar.a(this.FP);
            this.EJ.DT.b(this.iF);
        }
        if (this.FO.getHandler() != null) {
            this.FO.getHandler().removeCallbacksAndMessages(null);
        }
        this.EJ.DV.b(this);
    }

    public static /* synthetic */ boolean a(q qVar, AdInfo adInfo) {
        return u(adInfo);
    }

    public static /* synthetic */ boolean b(q qVar, boolean z10) {
        qVar.FM = true;
        return true;
    }

    private void a(DetailVideoView detailVideoView) {
        View findViewById = findViewById(R.id.splash_play_card_view);
        findViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.q.3
            final /* synthetic */ View FX;
            final /* synthetic */ DetailVideoView FY;

            public AnonymousClass3(View findViewById2, DetailVideoView detailVideoView2) {
                findViewById = findViewById2;
                detailVideoView = detailVideoView2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                float width = findViewById.getWidth();
                float height = findViewById.getHeight();
                if (width <= 0.0f || height <= 0.0f) {
                    return;
                }
                if (com.kwad.sdk.core.response.b.a.aV(q.this.mAdInfo).videoWidth > 0) {
                    com.kwad.sdk.c.a.a.a(detailVideoView, r0.width, r0.height);
                }
            }
        });
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cF(adInfo));
    }
}
