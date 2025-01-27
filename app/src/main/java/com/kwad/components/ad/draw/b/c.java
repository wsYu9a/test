package com.kwad.components.ad.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.draw.a.a implements View.OnClickListener {
    private ViewGroup dC;
    private TextView dD;
    private TextView dE;
    private TextView dF;
    private DrawDownloadProgressBar dG;
    private ValueAnimator dH;
    private int dI;
    private int dJ;
    private int dK;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (j11 >= c.this.dK * 1000) {
                c.this.f11413df.dv.aO();
            } else if (j11 >= c.this.dJ * 1000) {
                c.this.aM();
            } else if (j11 >= c.this.dI * 1000) {
                c.this.aK();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
        }
    };
    private KsAppDownloadListener dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.b.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.cg(c.this.mAdTemplate));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.cg(c.this.mAdTemplate), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            super.onPaused(i10);
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.GN());
            c.this.dG.e(com.kwad.sdk.core.response.b.a.GN(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            c.this.dF.setText(i10 + "%");
            c.this.dG.e(i10 + "%", i10);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.c$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (j11 >= c.this.dK * 1000) {
                c.this.f11413df.dv.aO();
            } else if (j11 >= c.this.dJ * 1000) {
                c.this.aM();
            } else if (j11 >= c.this.dI * 1000) {
                c.this.aK();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.c$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.cg(c.this.mAdTemplate));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.cg(c.this.mAdTemplate), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo));
            c.this.dG.e(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo), c.this.dG.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            super.onPaused(i10);
            c.this.dF.setText(com.kwad.sdk.core.response.b.a.GN());
            c.this.dG.e(com.kwad.sdk.core.response.b.a.GN(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            c.this.dF.setText(i10 + "%");
            c.this.dG.e(i10 + "%", i10);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.c$3 */
    public class AnonymousClass3 implements a.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 1, c.this.f11413df.mRootContainer.getTouchCoords());
            if (c.this.f11413df.f11414de != null) {
                c.this.f11413df.f11414de.onAdClicked();
            }
        }
    }

    private void aJ() {
        this.dI = com.kwad.sdk.core.response.b.a.bq(this.mAdInfo);
        this.dJ = com.kwad.sdk.core.response.b.a.br(this.mAdInfo);
        this.dK = com.kwad.sdk.core.response.b.a.bs(this.mAdInfo);
    }

    public void aK() {
        if (this.dF.getVisibility() == 0 || this.dG.getVisibility() == 0) {
            return;
        }
        this.dF.setOnClickListener(this);
        this.dF.setVisibility(0);
        TextView textView = this.dF;
        ValueAnimator b10 = n.b(textView, 0, com.kwad.sdk.c.a.a.a(textView.getContext(), 44.0f));
        this.dH = b10;
        b10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.dH.setDuration(300L);
        this.dH.start();
    }

    private void aL() {
        ValueAnimator valueAnimator = this.dH;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.dH.cancel();
        }
    }

    public void aM() {
        if (this.dG.getVisibility() == 0) {
            return;
        }
        this.dG.setOnClickListener(this);
        this.dG.setVisibility(0);
        this.dF.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.f11413df.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eb(adTemplate);
        this.mApkDownloadHelper = this.f11413df.mApkDownloadHelper;
        aJ();
        this.mLogoView.aK(this.mAdTemplate);
        this.dF.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.dF.setVisibility(8);
        this.dG.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), this.dG.getMax());
        this.dG.setVisibility(8);
        this.dC.setVisibility(0);
        this.dC.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.dD.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            this.dD.setVisibility(0);
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.dL);
            }
        } else {
            this.dD.setVisibility(8);
        }
        this.dE.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.f11413df.f11415dg.b(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.dC) {
            aM();
            a(false, 2);
        } else if (view == this.dF) {
            aM();
            a(true, 1);
        } else if (view == this.dG) {
            a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dC = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.dD = (TextView) findViewById(R.id.ksad_ad_normal_title);
        this.dE = (TextView) findViewById(R.id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_normal_logo);
        this.dF = (TextView) findViewById(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_ad_light_convert_btn);
        this.dG = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        aL();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.dL) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
    }

    private void a(boolean z10, int i10) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(this.dC.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(i10).ap(z10).a(new a.b() { // from class: com.kwad.components.ad.draw.b.c.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 1, c.this.f11413df.mRootContainer.getTouchCoords());
                if (c.this.f11413df.f11414de != null) {
                    c.this.f11413df.f11414de.onAdClicked();
                }
            }
        }));
    }
}
