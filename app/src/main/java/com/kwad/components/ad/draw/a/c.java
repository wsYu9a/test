package com.kwad.components.ad.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.r.m;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a implements View.OnClickListener {
    private ValueAnimator cA;
    private int cB;
    private int cC;
    private int cD;
    private ViewGroup cv;
    private TextView cw;
    private TextView cx;
    private TextView cy;
    private DrawDownloadProgressBar cz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            long j4 = c.this.cD * 1000;
            c cVar = c.this;
            if (j3 >= j4) {
                cVar.bW.co.ax();
                return;
            }
            long j5 = cVar.cC * 1000;
            c cVar2 = c.this;
            if (j3 >= j5) {
                cVar2.av();
            } else if (j3 >= cVar2.cB * 1000) {
                c.this.at();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
        }
    };
    private KsAppDownloadListener cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.a.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aH(c.this.mAdTemplate));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aH(c.this.mAdTemplate), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.T(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.T(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            super.onPaused(i2);
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.xw());
            c.this.cz.f(com.kwad.sdk.core.response.a.a.xw(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            c.this.cy.setText(i2 + "%");
            c.this.cz.f(i2 + "%", i2);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.a.c$1 */
    final class AnonymousClass1 extends j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            long j4 = c.this.cD * 1000;
            c cVar = c.this;
            if (j3 >= j4) {
                cVar.bW.co.ax();
                return;
            }
            long j5 = cVar.cC * 1000;
            c cVar2 = c.this;
            if (j3 >= j5) {
                cVar2.av();
            } else if (j3 >= cVar2.cB * 1000) {
                c.this.at();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
        }
    }

    /* renamed from: com.kwad.components.ad.draw.a.c$2 */
    final class AnonymousClass2 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aH(c.this.mAdTemplate));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aH(c.this.mAdTemplate), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.aw(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.T(c.this.mAdInfo));
            c.this.cz.f(com.kwad.sdk.core.response.a.a.T(c.this.mAdInfo), c.this.cz.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            super.onPaused(i2);
            c.this.cy.setText(com.kwad.sdk.core.response.a.a.xw());
            c.this.cz.f(com.kwad.sdk.core.response.a.a.xw(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            c.this.cy.setText(i2 + "%");
            c.this.cz.f(i2 + "%", i2);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.a.c$3 */
    final class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, 1, c.this.bW.mRootContainer.getTouchCoords());
            if (c.this.bW.bV != null) {
                c.this.bW.bV.onAdClicked();
            }
        }
    }

    private void a(boolean z, int i2) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(this.cv.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(i2).ao(z).a(new a.b() { // from class: com.kwad.components.ad.draw.a.c.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, 1, c.this.bW.mRootContainer.getTouchCoords());
                if (c.this.bW.bV != null) {
                    c.this.bW.bV.onAdClicked();
                }
            }
        }));
    }

    private void as() {
        this.cB = com.kwad.sdk.core.response.a.a.bf(this.mAdInfo);
        this.cC = com.kwad.sdk.core.response.a.a.bg(this.mAdInfo);
        this.cD = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo);
    }

    public void at() {
        if (this.cy.getVisibility() == 0 || this.cz.getVisibility() == 0) {
            return;
        }
        this.cy.setOnClickListener(this);
        this.cy.setVisibility(0);
        TextView textView = this.cy;
        ValueAnimator b2 = m.b(textView, 0, com.kwad.sdk.c.kwai.a.a(textView.getContext(), 44.0f));
        this.cA = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cA.setDuration(300L);
        this.cA.start();
    }

    private void au() {
        ValueAnimator valueAnimator = this.cA;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cA.cancel();
        }
    }

    public void av() {
        if (this.cz.getVisibility() == 0) {
            return;
        }
        this.cz.setOnClickListener(this);
        this.cz.setVisibility(0);
        this.cy.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.bW.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mApkDownloadHelper = this.bW.mApkDownloadHelper;
        as();
        this.mLogoView.S(this.mAdTemplate);
        this.cy.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
        this.cy.setVisibility(8);
        this.cz.f(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo), this.cz.getMax());
        this.cz.setVisibility(8);
        this.cv.setVisibility(0);
        this.cv.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            this.cw.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
            this.cw.setVisibility(0);
            com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.cE);
            }
        } else {
            this.cw.setVisibility(8);
        }
        this.cx.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.cv) {
            av();
            a(false, 2);
        } else if (view == this.cy) {
            av();
            a(true, 1);
        } else if (view == this.cz) {
            a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cv = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cw = (TextView) findViewById(R.id.ksad_ad_normal_title);
        this.cx = (TextView) findViewById(R.id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_normal_logo);
        this.cy = (TextView) findViewById(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_ad_light_convert_btn);
        this.cz = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        au();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.cE) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.bW.bX.b(this.mVideoPlayStateListener);
    }
}
