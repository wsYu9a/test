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
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.r.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;

/* loaded from: classes.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener cE;
    private a dp;
    private ImageView dq;
    private ImageView dr;
    private TextView ds;
    private ViewGroup dt;
    private AppScoreView du;
    private TextView dv;
    private TextView dw;
    private KsLogoView dx;
    private DrawDownloadProgressBar dy;
    private ValueAnimator dz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aw(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aH(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dy.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aw(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.T(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            super.onPaused(i2);
            DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.xw(), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            DrawCardApp.this.dy.f(i2 + "%", i2);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardApp$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (DrawCardApp.this.dp != null) {
                DrawCardApp.this.dp.aE();
            }
        }
    }

    public interface a {
        void aD();

        void aE();
    }

    public DrawCardApp(Context context) {
        super(context);
        D(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        k.inflate(context, R.layout.ksad_draw_card_app, this);
        this.dq = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.dr = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.ds = (TextView) findViewById(R.id.ksad_card_app_name);
        this.dt = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.du = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.dv = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.dw = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.dx = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.dy = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.c.kwai.a.a(context, 156.0f);
    }

    private void aO() {
        ValueAnimator valueAnimator = this.dz;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.dz.cancel();
        }
    }

    private void aV() {
        d(this.mHeight, 0);
    }

    private void d(int i2, int i3) {
        aO();
        ValueAnimator b2 = m.b(this, i2, i3);
        this.dz = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.dz.setDuration(300L);
        this.dz.start();
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aw(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aH(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dy.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.aw(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.T(DrawCardApp.this.mAdInfo), DrawCardApp.this.dy.getMax());
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    super.onPaused(i2);
                    DrawCardApp.this.dy.f(com.kwad.sdk.core.response.a.a.xw(), i2);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    DrawCardApp.this.dy.f(i2 + "%", i2);
                }
            };
        }
        return this.cE;
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.dp = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.dr, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), adTemplate, 11);
        this.ds.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        String ar = com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
        float as = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
        boolean z = as >= 3.0f;
        if (z) {
            this.du.setScore(as);
            this.du.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(ar);
        if (z2) {
            this.dv.setText(ar);
            this.dv.setVisibility(0);
        }
        if (z || z2) {
            this.dt.setVisibility(0);
        } else {
            this.dt.setVisibility(8);
        }
        this.dx.S(this.mAdTemplate);
        this.dw.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
        this.dq.setOnClickListener(this);
        this.dy.setOnClickListener(this);
        setOnClickListener(this);
    }

    public final void aU() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.dq) {
            com.kwad.components.core.d.b.a.a(new a.C0172a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.dy).ap(view == this.dy ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                AnonymousClass2() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (DrawCardApp.this.dp != null) {
                        DrawCardApp.this.dp.aE();
                    }
                }
            }));
            return;
        }
        aV();
        a aVar = this.dp;
        if (aVar != null) {
            aVar.aD();
        }
    }

    public final void release() {
        aO();
        this.mApkDownloadHelper = null;
    }
}
