package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.c {
    private ImageView eT;

    /* renamed from: gb */
    private TextView f11619gb;

    /* renamed from: gh */
    private ImageView f11620gh;
    private KSFrameLayout lF;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private String mT;

    @Nullable
    private View mU;
    private ImageView mV;
    private TextProgressBar mW;
    private ViewGroup mX;
    private ViewGroup mY;
    private ImageView mZ;

    /* renamed from: ma */
    private KSFrameLayout f11621ma;

    /* renamed from: na */
    private View f11622na;

    /* renamed from: nb */
    private View f11623nb;

    /* renamed from: nc */
    private TextView f11624nc;

    /* renamed from: nd */
    private ImageView f11625nd;

    /* renamed from: ne */
    private TextView f11626ne;

    /* renamed from: nf */
    private TextView f11627nf;

    /* renamed from: ng */
    private TextView f11628ng;

    /* renamed from: nh */
    private TextProgressBar f11629nh;

    /* renamed from: ni */
    private TextView f11630ni;

    /* renamed from: nj */
    private e f11631nj;

    /* renamed from: nk */
    private final a f11632nk;
    private boolean nl;

    /* renamed from: com.kwad.components.ad.interstitial.h.d$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.mZ.setSelected(!d.this.mZ.isSelected());
            if (d.this.f11631nj != null) {
                d.this.f11631nj.p(d.this.mZ.isSelected());
            }
        }
    }

    public static class a {
        private boolean nn = false;
        private boolean no = false;
        private int np = 0;
        private boolean nq = true;

        public final void F(int i10) {
            this.np = i10;
        }

        public final int eE() {
            return this.np;
        }

        public final boolean eF() {
            return this.nq;
        }

        public final void w(boolean z10) {
            this.nn = z10;
        }

        public final void x(boolean z10) {
            this.no = z10;
        }

        public final void y(boolean z10) {
            this.nq = z10;
        }
    }

    public d(@NonNull Context context, a aVar) {
        super(context);
        this.mT = "%s秒后进入试玩页";
        this.nl = false;
        this.f11632nk = aVar;
        m.inflate(context, aVar.eF() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        t(aVar.nn);
    }

    private void d(View view, int i10) {
        com.kwad.sdk.c.a.a.b(view, 0, com.kwad.sdk.c.a.a.a(getContext(), i10), 0, 0);
    }

    private void ey() {
        a(this.f11625nd, 40, 40);
        a(this.f11629nh, 130, 30);
        this.f11627nf.setTextSize(14.0f);
        d(this.f11629nh, 11);
        d(this.f11627nf, 7);
        d(this.f11628ng, 7);
    }

    private void t(boolean z10) {
        setClickable(true);
        this.lF = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.f11621ma = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.mU = findViewById(R.id.ksad_interstitial_full_bg);
        this.mV = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.f11620gh = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.mX = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.mY = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.mW = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.f11622na = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.mW;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 10.0f));
            this.mW.setTextColor(-1);
        }
        this.mZ = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.f11624nc = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.f11625nd = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.f11627nf = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.f11628ng = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.f11629nh = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f11623nb = findViewById(R.id.ksad_ad_download_container);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f11626ne = (TextView) findViewById(R.id.ksad_app_title);
        this.f11619gb = (TextView) findViewById(R.id.ksad_app_desc);
        new f(this, this);
        new f(this.f11620gh, this);
        new f(this.mW, this);
        new f(this.f11629nh, this);
        new f(this.f11622na, this);
        new f(this.mY, this);
        new f(this.f11624nc, this);
        new f(this.f11623nb, this);
        new f(this.eT, this);
        new f(this.f11626ne, this);
        new f(this.f11619gb, this);
        new f(this.f11625nd, this);
        new f(this.f11627nf, this);
        new f(this.f11628ng, this);
        this.mZ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.h.d.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.mZ.setSelected(!d.this.mZ.isSelected());
                if (d.this.f11631nj != null) {
                    d.this.f11631nj.p(d.this.mZ.isSelected());
                }
            }
        });
        this.f11630ni = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.f11621ma, z10);
        if (an.isOrientationPortrait()) {
            return;
        }
        ey();
    }

    public final void C(AdTemplate adTemplate) {
        this.mLogoView.aK(adTemplate);
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (bm.isNullString(str)) {
            return;
        }
        this.f11620gh.setImageDrawable(null);
        KSImageLoader.loadImage(this.f11620gh, str, adTemplate);
    }

    public final void eA() {
        View view = this.f11622na;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void eB() {
        u(false);
        this.mY.setVisibility(0);
        this.mV.setVisibility(0);
    }

    public final void eC() {
        this.mY.setVisibility(8);
        this.mV.setVisibility(8);
        u(true);
    }

    public final boolean eD() {
        ViewGroup viewGroup = this.mY;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void ez() {
        TextView textView = this.f11624nc;
        if (textView != null) {
            textView.setVisibility(8);
            this.nl = true;
        }
    }

    public final void f(String str, int i10) {
        TextProgressBar textProgressBar = this.mW;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.f11629nh;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    @Nullable
    public final View getBlurBgView() {
        return this.mU;
    }

    public final ImageView getTailFrameView() {
        return this.mV;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(e eVar) {
        this.f11631nj = eVar;
    }

    public final void u(boolean z10) {
        ViewGroup viewGroup = this.mX;
        if (viewGroup != null) {
            viewGroup.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void v(boolean z10) {
        ImageView imageView = this.mZ;
        if (imageView != null) {
            imageView.setSelected(z10);
        }
    }

    public final void x(String str) {
        TextView textView = this.f11624nc;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.f11632nk.no || this.nl || this.f11624nc.getVisibility() == 0) {
            return;
        }
        this.f11624nc.setVisibility(0);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z10) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.f11621ma.setWidthBasedRatio(!z10);
    }

    public final void b(boolean z10, int i10) {
        TextView textView = this.f11630ni;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i10 >= 0) {
            this.f11630ni.setText(String.format(this.mT, String.valueOf(i10)));
        }
    }

    public final void c(boolean z10, boolean z11) {
        ImageView imageView = this.f11620gh;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
            this.f11620gh.setClickable(z11);
        }
    }

    private void a(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), i10);
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i11);
        view.setLayoutParams(layoutParams);
    }

    private void b(View view, boolean z10) {
        e eVar;
        e eVar2;
        e eVar3 = this.f11631nj;
        if (eVar3 != null) {
            eVar3.q(z10);
            this.f11631nj.a(this.lF);
        }
        if (view.equals(this)) {
            e eVar4 = this.f11631nj;
            if (eVar4 != null) {
                eVar4.dC();
                return;
            }
            return;
        }
        if (view.equals(this.f11622na)) {
            if (1 != this.f11632nk.eE() || (eVar2 = this.f11631nj) == null) {
                return;
            }
            eVar2.dB();
            return;
        }
        if (view.equals(this.f11629nh)) {
            e eVar5 = this.f11631nj;
            if (eVar5 != null) {
                eVar5.dD();
                return;
            }
            return;
        }
        if (view.equals(this.mY)) {
            e eVar6 = this.f11631nj;
            if (eVar6 != null) {
                eVar6.dO();
                return;
            }
            return;
        }
        if (view.equals(this.mW)) {
            e eVar7 = this.f11631nj;
            if (eVar7 != null) {
                eVar7.dE();
                return;
            }
            return;
        }
        if (view.equals(this.f11623nb)) {
            e eVar8 = this.f11631nj;
            if (eVar8 != null) {
                eVar8.dH();
                return;
            }
            return;
        }
        if (view.equals(this.f11621ma)) {
            e eVar9 = this.f11631nj;
            if (eVar9 != null) {
                eVar9.dF();
                return;
            }
            return;
        }
        if (view.equals(this.f11620gh)) {
            e eVar10 = this.f11631nj;
            if (eVar10 != null) {
                eVar10.dG();
                return;
            }
            return;
        }
        if (view.equals(this.eT)) {
            e eVar11 = this.f11631nj;
            if (eVar11 != null) {
                eVar11.dI();
                return;
            }
            return;
        }
        if (view.equals(this.f11626ne)) {
            e eVar12 = this.f11631nj;
            if (eVar12 != null) {
                eVar12.dJ();
                return;
            }
            return;
        }
        if (view.equals(this.f11619gb)) {
            e eVar13 = this.f11631nj;
            if (eVar13 != null) {
                eVar13.dK();
                return;
            }
            return;
        }
        if (view.equals(this.f11625nd)) {
            e eVar14 = this.f11631nj;
            if (eVar14 != null) {
                eVar14.dL();
                return;
            }
            return;
        }
        if (view.equals(this.f11627nf)) {
            e eVar15 = this.f11631nj;
            if (eVar15 != null) {
                eVar15.dM();
                return;
            }
            return;
        }
        if (!view.equals(this.f11628ng) || (eVar = this.f11631nj) == null) {
            return;
        }
        eVar.dN();
    }

    public final void f(int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i10;
        marginLayoutParams.height = i11;
        setLayoutParams(marginLayoutParams);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        this.f11625nd.setImageResource(R.drawable.ksad_default_app_icon);
        if (com.kwad.sdk.core.response.b.a.ch(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.f11625nd, com.kwad.sdk.core.response.b.a.cP(adInfo), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            this.f11627nf.setText(com.kwad.sdk.core.response.b.a.cl(adInfo));
            this.f11628ng.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            if (com.kwad.sdk.core.response.b.a.cL(adInfo)) {
                this.f11629nh.e(com.kwad.components.ad.e.b.aA(), 0);
                return;
            } else {
                this.f11629nh.e(com.kwad.components.ad.e.b.aD(), 0);
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dh() && com.kwad.sdk.core.response.b.a.ch(adInfo) == 3) {
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
            KSImageLoader.loadWithRadius(this.f11625nd, cW.icon, adTemplate, 4);
            this.f11627nf.setText(cW.name);
            this.f11628ng.setVisibility(8);
            this.f11629nh.e(com.kwad.components.ad.e.b.aB(), 0);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            KSImageLoader.loadWithRadius(this.f11625nd, com.kwad.sdk.core.response.b.a.cm(adInfo), adTemplate, 4);
            this.f11627nf.setText(com.kwad.sdk.core.response.b.a.av(adInfo));
            this.f11628ng.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.f11629nh.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
            return;
        }
        KSImageLoader.loadWithRadius(this.f11625nd, com.kwad.sdk.core.response.b.e.eg(adTemplate), adTemplate, 4);
        this.f11627nf.setText(com.kwad.sdk.core.response.b.a.cj(adInfo));
        this.f11628ng.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.f11629nh.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
    }

    public final void a(float f10, com.kwad.sdk.core.video.videoview.a aVar) {
        this.f11621ma.setRatio(f10);
        this.f11621ma.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
