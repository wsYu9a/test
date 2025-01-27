package com.kwad.components.ad.interstitial.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class g extends com.kwad.components.ad.interstitial.f.b {

    /* renamed from: mh */
    private static int f11610mh = 4;
    private c kY;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: mf */
    private a f11611mf = new a();

    /* renamed from: mg */
    private b f11612mg = new b();

    public static class a {

        /* renamed from: mi */
        private ImageView f11613mi;

        /* renamed from: mj */
        private TextView f11614mj;

        /* renamed from: mk */
        private TextView f11615mk;
        private KsPriceView ml;
    }

    public static class b {
        private String appIconUrl;
        private String mm;
        private CharSequence mn;
        private String mo;
        private String mp;
        private String price;

        public final void a(CharSequence charSequence) {
            this.mn = charSequence;
        }

        public final String dT() {
            return this.mm;
        }

        public final CharSequence dU() {
            return this.mn;
        }

        public final String dV() {
            return this.mo;
        }

        public final String dW() {
            return this.mp;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void setPrice(String str) {
            this.price = str;
        }

        public final void t(String str) {
            this.appIconUrl = str;
        }

        public final void u(String str) {
            this.mm = str;
        }

        public final void v(String str) {
            this.mo = str;
        }

        public final void w(String str) {
            this.mp = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.f11613mi;
        if (TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.cg(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, f11610mh);
            }
        }
        aVar.f11614mj.setText(bVar.dT());
        if (com.kwad.components.ad.interstitial.b.b.dh() && com.kwad.sdk.core.response.b.a.cg(adInfo) == 3) {
            aVar.ml.d(bVar.getPrice(), bVar.dV(), true);
            aVar.ml.setVisibility(0);
            aVar.f11615mk.setVisibility(8);
            dS();
        } else {
            aVar.f11615mk.setText(bVar.dU());
        }
        this.kY.kZ.f(bVar.dW(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cg(adInfo) == 2) {
            this.f11612mg.t(com.kwad.sdk.core.response.b.a.cP(adInfo));
            this.f11612mg.u(com.kwad.sdk.core.response.b.a.cl(adInfo));
            CharSequence b10 = com.kwad.sdk.core.response.b.a.b(adInfo, com.kwad.components.core.widget.e.afv);
            if (TextUtils.isEmpty(b10)) {
                b10 = com.kwad.sdk.core.response.b.a.cO(adInfo);
            }
            this.f11612mg.a(b10);
            if (com.kwad.sdk.core.response.b.a.cL(adInfo)) {
                this.f11612mg.w(com.kwad.components.ad.e.b.aA());
                return;
            } else {
                this.f11612mg.w(com.kwad.components.ad.e.b.aD());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dh() && com.kwad.sdk.core.response.b.a.cg(adInfo) == 3) {
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            this.f11612mg.t(cW.icon);
            this.f11612mg.u(cW.name);
            this.f11612mg.v(cW.originPrice);
            this.f11612mg.setPrice(cW.price);
            this.f11612mg.w(com.kwad.components.ad.e.b.aB());
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.f11612mg.t(com.kwad.sdk.core.response.b.a.cm(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.av(adInfo))) {
                this.f11612mg.u(com.kwad.sdk.core.response.b.a.av(adInfo));
            } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.f11612mg.u(getContext().getString(R.string.ksad_ad_default_username_normal));
            } else {
                this.f11612mg.u(adInfo.advertiserInfo.adAuthorText);
            }
            this.f11612mg.a(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.f11612mg.w(com.kwad.sdk.core.response.b.a.aE(adInfo));
            return;
        }
        this.f11612mg.t(com.kwad.sdk.core.response.b.a.cm(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.ax(adInfo))) {
            this.f11612mg.u(com.kwad.sdk.core.response.b.a.ax(adInfo));
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.f11612mg.u(getContext().getString(R.string.ksad_ad_default_username_normal));
        } else {
            this.f11612mg.u(adInfo.advertiserInfo.adAuthorText);
        }
        this.f11612mg.a(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.f11612mg.w(com.kwad.sdk.core.response.b.a.aE(adInfo));
    }

    private void dS() {
        View findViewById = this.kY.kZ.findViewById(R.id.ksad_ad_desc_layout);
        View findViewById2 = this.kY.kZ.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        c cVar = (c) Lj();
        this.kY = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.f11611mf.f11613mi = (ImageView) this.kY.kZ.findViewById(R.id.ksad_app_icon);
        this.f11611mf.f11614mj = (TextView) this.kY.kZ.findViewById(R.id.ksad_app_title);
        this.f11611mf.f11615mk = (TextView) this.kY.kZ.findViewById(R.id.ksad_app_desc);
        this.f11611mf.ml = (KsPriceView) this.kY.kZ.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.f11611mf, this.f11612mg, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
