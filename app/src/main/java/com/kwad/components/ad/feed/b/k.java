package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: classes2.dex */
public final class k extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView fX;
    private ImageView fZ;
    private RoundAngleImageView gL;

    /* renamed from: ge */
    private DownloadProgressView f11479ge;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.feed.b.k$1 */
    public class AnonymousClass1 implements a.b {
        final /* synthetic */ int cO;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            k.this.aM(i10);
        }
    }

    public k(@NonNull Context context) {
        super(context);
    }

    private void bG() {
        this.mLogoView.aK(this.mAdTemplate);
        this.f11479ge.am(this.mAdTemplate);
        com.kwad.sdk.c.a.a.a(this, this.fX, this.gL, this.f11479ge);
        new com.kwad.sdk.widget.f(getContext(), this.fX, this);
        new com.kwad.sdk.widget.f(getContext(), this.gL, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11479ge, this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.f11479ge.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.f11479ge.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bD();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        DownloadProgressView downloadProgressView;
        super.Z();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.f11479ge) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            c(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        this.fX = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.gL = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.fZ = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f11479ge = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bH() {
        super.bH();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.f11479ge.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((k) adResultData);
        this.fX.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        List<String> ba2 = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        if (ba2.size() > 0) {
            this.fQ = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.gL, ba2.get(0), this.mAdTemplate, this.fV);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        bG();
        this.fZ.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c(view, view == this.fX ? 25 : view == this.gL ? 100 : view == this.f11479ge ? 1 : 35);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void c(View view, int i10) {
        if (view == this.fZ) {
            us();
        } else {
            com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).am(5).an(i10).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.f11479ge ? 1 : 2).ap(view == this.f11479ge).a(new a.b() { // from class: com.kwad.components.ad.feed.b.k.1
                final /* synthetic */ int cO;

                public AnonymousClass1(int i102) {
                    i10 = i102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    k.this.aM(i10);
                }
            }));
        }
    }
}
