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
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.kwai.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.j.k;

/* loaded from: classes.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsDrawAd.AdInteractionListener bV;

    @Nullable
    private KsAppDownloadListener cE;
    private AdBaseFrameLayout dG;
    private ImageView dH;
    private ViewGroup dI;
    private ImageView dJ;
    private TextView dK;
    private AppScoreView dL;
    private TextView dM;
    private TextView dN;
    private DrawDownloadProgressBar dO;
    private ViewGroup dP;
    private TextView dQ;
    private TextView dR;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame$1 */
    final class AnonymousClass1 extends a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aH(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dO.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.T(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            super.onPaused(i2);
            DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.xw(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            DrawVideoTailFrame.this.dO.f(i2 + "%", i2);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (DrawVideoTailFrame.this.bV != null) {
                DrawVideoTailFrame.this.bV.onAdClicked();
            }
            com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dG.getTouchCoords());
        }
    }

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        D(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        k.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.dH = (ImageView) findViewById(R.id.ksad_video_cover);
        this.dI = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_name);
        this.dL = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dM = (TextView) findViewById(R.id.ksad_app_download_count);
        this.dN = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.dO = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.dP = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dR = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aH(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.aw(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.T(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dO.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                super.onPaused(i2);
                DrawVideoTailFrame.this.dO.f(com.kwad.sdk.core.response.a.a.xw(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DrawVideoTailFrame.this.dO.f(i2 + "%", i2);
            }
        };
    }

    public final void aX() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.cE;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.cE = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void bindView(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(cb);
        String str = aN.coverUrl;
        this.mLogoView.S(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i2 = aN.width;
            int i3 = aN.height;
            if (i2 > 0 && i2 > i3) {
                int screenWidth = com.kwad.sdk.c.kwai.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i4 = (int) (screenWidth * (i3 / i2));
                ViewGroup.LayoutParams layoutParams = this.dH.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i4;
            }
            KSImageLoader.loadImage(this.dH, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 11);
            this.dK.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
            float as = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
            if (as >= 3.0f) {
                this.dL.setScore(as);
                this.dL.setVisibility(0);
            }
            this.dM.setText(com.kwad.sdk.core.response.a.a.ar(this.mAdInfo));
            this.dN.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
            this.dI.setVisibility(0);
            this.dP.setVisibility(8);
        } else {
            this.dQ.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
            this.dR.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
            this.dI.setVisibility(8);
            this.dP.setVisibility(0);
        }
        this.dO.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.dO ? 1 : 2).ao(view == this.dO).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.bV != null) {
                    DrawVideoTailFrame.this.bV.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dG.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.cE) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.dG = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
