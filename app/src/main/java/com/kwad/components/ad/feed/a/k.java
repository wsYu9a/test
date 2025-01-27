package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eA;
    private ImageView eC;
    private DownloadProgressView eH;
    private RoundAngleImageView fu;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.feed.a.k$1 */
    final class AnonymousClass1 implements a.b {
        final /* synthetic */ int eK;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            k.this.aL(i2);
        }
    }

    public k(@NonNull Context context) {
        super(context);
    }

    private void bm() {
        this.mLogoView.S(this.mAdTemplate);
        this.eH.D(this.mAdTemplate);
        com.kwad.sdk.c.kwai.a.a(this, this.eA, this.fu, this.eH);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.fu, this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eH.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.eH.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bj();
        }
    }

    private void c(View view, int i2) {
        if (view == this.eC) {
            ru();
        } else {
            com.kwad.components.core.d.b.a.a(new a.C0172a(getContext()).an(5).ao(i2).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.eH ? 1 : 2).ao(view == this.eH).a(new a.b() { // from class: com.kwad.components.ad.feed.a.k.1
                final /* synthetic */ int eK;

                AnonymousClass1(int i22) {
                    i2 = i22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    k.this.aL(i2);
                }
            }));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            c(view, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.eA.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        List<String> aT = com.kwad.sdk.core.response.a.a.aT(this.mAdInfo);
        if (aT.size() > 0) {
            this.ex = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.fu, aT.get(0), this.mAdTemplate, this.ey);
        } else {
            com.kwad.sdk.core.d.b.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        bm();
        this.eC.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.eA = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.fu = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.kwai.a.a(getContext(), 3.0f));
        this.eC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eH.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c(view, view == this.eA ? 25 : view == this.fu ? 100 : view == this.eH ? 1 : 35);
    }
}
