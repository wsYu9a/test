package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    @Nullable
    private KsAppDownloadListener dL;

    /* renamed from: de */
    private KsDrawAd.AdInteractionListener f11447de;
    private AdBaseFrameLayout eQ;
    private ImageView eR;
    private ViewGroup eS;
    private ImageView eT;
    private TextView eU;
    private AppScoreView eV;
    private TextView eW;
    private TextView eX;
    private DrawDownloadProgressBar eY;
    private ViewGroup eZ;

    /* renamed from: fa */
    private TextView f11448fa;

    /* renamed from: fb */
    private TextView f11449fb;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame$1 */
    public class AnonymousClass1 extends a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.cg(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.eY.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            super.onPaused(i10);
            DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.GN(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            DrawVideoTailFrame.this.eY.e(i10 + "%", i10);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (DrawVideoTailFrame.this.f11447de != null) {
                DrawVideoTailFrame.this.f11447de.onAdClicked();
            }
            com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.eQ.getTouchCoords());
        }
    }

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.eR = (ImageView) findViewById(R.id.ksad_video_cover);
        this.eS = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_name);
        this.eV = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.eW = (TextView) findViewById(R.id.ksad_app_download_count);
        this.eX = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.eY = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.eZ = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.f11448fa = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f11449fb = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.cg(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.eY.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.eY.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                super.onPaused(i10);
                DrawVideoTailFrame.this.eY.e(com.kwad.sdk.core.response.b.a.GN(), i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                DrawVideoTailFrame.this.eY.e(i10 + "%", i10);
            }
        };
    }

    public final void bq() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.dL;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.dL = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void f(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.mAdInfo = eb2;
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(eb2);
        String str = aV.coverUrl;
        this.mLogoView.aK(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i10 = aV.width;
            int i11 = aV.height;
            if (i10 > 0 && i10 > i11) {
                int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i12 = (int) (screenWidth * (i11 / i10));
                ViewGroup.LayoutParams layoutParams = this.eR.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i12;
            }
            KSImageLoader.loadImage(this.eR, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.eT, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, 11);
            this.eU.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
            if (aA >= 3.0f) {
                this.eV.setScore(aA);
                this.eV.setVisibility(0);
            }
            this.eW.setText(com.kwad.sdk.core.response.b.a.az(this.mAdInfo));
            this.eX.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.eS.setVisibility(0);
            this.eZ.setVisibility(8);
        } else {
            this.f11448fa.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.f11449fb.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.eS.setVisibility(8);
            this.eZ.setVisibility(0);
        }
        this.eY.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.eY ? 1 : 2).ap(view == this.eY).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.f11447de != null) {
                    DrawVideoTailFrame.this.f11447de.onAdClicked();
                }
                com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.eQ.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.dL) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.eQ = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f11447de = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        A(context);
    }
}
