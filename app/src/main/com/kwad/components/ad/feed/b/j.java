package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: classes2.dex */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView fX;
    private ImageView fY;
    private ImageView fZ;
    private KsLogoView mLogoView;

    public j(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            c(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.fX = (TextView) findViewById(R.id.ksad_ad_desc);
        this.fY = (ImageView) findViewById(R.id.ksad_ad_image);
        this.fZ = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((j) adResultData);
        this.fX.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        List<String> ba2 = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        this.mLogoView.aK(this.mAdTemplate);
        if (ba2.size() > 0) {
            KSImageLoader.loadFeeImage(this.fY, ba2.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.c.a.a.a(this, this.fX, this.fY, this.fZ);
        new com.kwad.sdk.widget.f(getContext(), this.fX, this);
        new com.kwad.sdk.widget.f(getContext(), this.fY, this);
        new com.kwad.sdk.widget.f(getContext(), this.fZ, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bD();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c(view, view == this.fX ? 25 : view == this.fY ? 100 : 35);
    }

    private void c(View view, int i10) {
        if (view == this.fZ) {
            us();
            return;
        }
        if (com.kwad.components.core.e.d.d.a(new a.C0427a(getContext()).au(this.mAdTemplate), 1) == 1) {
            aM(i10);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            aM(i10);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.aer);
        } else {
            aM(i10);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }
}
