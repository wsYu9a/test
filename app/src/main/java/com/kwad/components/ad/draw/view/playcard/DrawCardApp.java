package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener dL;
    private ImageView eA;
    private ImageView eB;
    private TextView eC;
    private ViewGroup eD;
    private AppScoreView eE;
    private TextView eF;
    private TextView eG;
    private KsLogoView eH;
    private DrawDownloadProgressBar eI;
    private ValueAnimator eJ;
    private a ez;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.cg(DrawCardApp.this.mAdTemplate), DrawCardApp.this.eI.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            super.onPaused(i10);
            DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.GN(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            DrawCardApp.this.eI.e(i10 + "%", i10);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (DrawCardApp.this.ez != null) {
                DrawCardApp.this.ez.aV();
            }
        }
    }

    public interface a {
        void aU();

        void aV();
    }

    public DrawCardApp(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_draw_card_app, this);
        this.eA = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.eB = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.eC = (TextView) findViewById(R.id.ksad_card_app_name);
        this.eD = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.eE = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.eF = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.eG = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.eH = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.eI = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.c.a.a.a(context, 156.0f);
    }

    private void bf() {
        ValueAnimator valueAnimator = this.eJ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.eJ.cancel();
        }
    }

    private void bo() {
        d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dL == null) {
            this.dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.cg(DrawCardApp.this.mAdTemplate), DrawCardApp.this.eI.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.eI.getMax());
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    super.onPaused(i10);
                    DrawCardApp.this.eI.e(com.kwad.sdk.core.response.b.a.GN(), i10);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    DrawCardApp.this.eI.e(i10 + "%", i10);
                }
            };
        }
        return this.dL;
    }

    public final void bn() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eA) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.eI).ao(view == this.eI ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (DrawCardApp.this.ez != null) {
                        DrawCardApp.this.ez.aV();
                    }
                }
            }));
            return;
        }
        bo();
        a aVar = this.ez;
        if (aVar != null) {
            aVar.aU();
        }
    }

    public final void release() {
        bf();
        this.mApkDownloadHelper = null;
    }

    private void d(int i10, int i11) {
        bf();
        ValueAnimator b10 = n.b(this, i10, i11);
        this.eJ = b10;
        b10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eJ.setDuration(300L);
        this.eJ.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eb(adTemplate);
        this.ez = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.eB, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), adTemplate, 11);
        this.eC.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z10 = aA >= 3.0f;
        if (z10) {
            this.eE.setScore(aA);
            this.eE.setVisibility(0);
        }
        boolean z11 = !TextUtils.isEmpty(az);
        if (z11) {
            this.eF.setText(az);
            this.eF.setVisibility(0);
        }
        if (z10 || z11) {
            this.eD.setVisibility(0);
        } else {
            this.eD.setVisibility(8);
        }
        this.eH.aK(this.mAdTemplate);
        this.eG.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.eA.setOnClickListener(this);
        this.eI.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        A(context);
    }
}
