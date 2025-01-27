package com.kwad.components.ad.splashscreen.presenter.endcard;

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
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public class SplashEndLandView extends FrameLayout {
    private CloseCountDownView Gd;
    private ViewGroup Ge;
    private ViewGroup Gf;
    private ImageView Gg;
    private TextView Gh;
    private TextView Gi;
    private ImageView Gt;
    private TextView Gu;
    private TextView Gv;
    private TextView Gw;
    private int Gx;
    private KsLogoView cv;

    public SplashEndLandView(@NonNull Context context) {
        super(context);
        this.Gx = 24;
    }

    private void b(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (cVar == null) {
            return;
        }
        String a10 = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfo, cVar.oK(), 0);
        if (TextUtils.isEmpty(a10)) {
            this.Gv.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
        } else {
            this.Gv.setText(a10);
        }
    }

    public final void X(String str) {
        TextView textView = this.Gv;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, float f10) {
        a(new g(getContext(), f10));
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.Gg.setImageResource(R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.d.c.d("SplashEndLandView", "bindView, appIconRadius: " + this.Gx);
        KSImageLoader.loadAppIcon(this.Gg, com.kwad.sdk.core.response.b.a.cm(eb2), adTemplate, this.Gx);
        this.Gh.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
        this.Gi.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        this.cv.aK(adTemplate);
        if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
            b(adTemplate, eb2, cVar);
        } else {
            this.Gv.setText("点击查看");
            this.Gw.setVisibility(0);
            this.Gw.setText("跳转详情页/第三方应用");
        }
        this.Gd.a(eb2, f10);
    }

    public final void bl() {
        CloseCountDownView closeCountDownView = this.Gd;
        if (closeCountDownView != null) {
            closeCountDownView.bl();
        }
    }

    public final void bm() {
        CloseCountDownView closeCountDownView = this.Gd;
        if (closeCountDownView != null) {
            closeCountDownView.bm();
        }
    }

    public ViewGroup getActionBarView() {
        return this.Gf;
    }

    public TextView getAppDesc() {
        return this.Gi;
    }

    public ImageView getAppIcon() {
        return this.Gg;
    }

    public TextView getAppName() {
        return this.Gh;
    }

    public CloseCountDownView getCloseView() {
        return this.Gd;
    }

    public ViewGroup getGiftBoxView() {
        return this.Ge;
    }

    public final void lV() {
        CloseCountDownView closeCountDownView = this.Gd;
        if (closeCountDownView != null) {
            closeCountDownView.bH();
        }
    }

    public final void t(boolean z10) {
        View.inflate(getContext(), z10 ? R.layout.ksad_splash_end_card_area_land : R.layout.ksad_splash_end_card_area, this);
        this.Gt = (ImageView) findViewById(R.id.ksad_ad_endcard_title_view);
        this.Ge = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.Gg = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.Gh = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.Gu = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.Gi = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.cv = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.Gv = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.Gw = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.Gd = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.Gf = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Gx = 24;
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Gx = 24;
    }

    @RequiresApi(api = 21)
    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.Gx = 24;
    }

    private void a(g gVar) {
        ah.a(this.Gt, gVar.lW());
        ah.a(this.Ge, gVar.lX());
        ah.a(this.Gg, gVar.lY());
        ah.a(this.Gf, gVar.ma());
        ah.a(this.Gh, gVar.mb());
        ah.a(this.Gu, gVar.mc());
        ah.a(this.Gi, gVar.md());
        ah.a(this.Gd, gVar.me());
        TextView textView = this.Gh;
        if (textView != null) {
            textView.setTextSize(0, gVar.mf());
        }
        TextView textView2 = this.Gu;
        if (textView2 != null) {
            textView2.setTextSize(0, gVar.mg());
        }
        TextView textView3 = this.Gi;
        if (textView3 != null) {
            textView3.setTextSize(0, gVar.mh());
        }
        TextView textView4 = this.Gv;
        if (textView4 != null) {
            textView4.setTextSize(0, gVar.mi());
        }
        TextView textView5 = this.Gw;
        if (textView5 != null) {
            textView5.setTextSize(0, gVar.mj());
        }
        this.Gx = gVar.lZ();
    }
}
