package com.kwad.components.ad.interstitial.e;

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
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes.dex */
public final class f extends KSFrameLayout implements com.kwad.sdk.widget.c {
    private ImageView dJ;
    private TextView eE;
    private ImageView eM;
    private KSFrameLayout kY;
    private KSFrameLayout kf;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private String ma;

    @Nullable
    private View mb;
    private ImageView mc;
    private TextProgressBar md;

    /* renamed from: me */
    private ViewGroup f9537me;
    private ViewGroup mf;
    private ImageView mg;
    private View mh;
    private View mi;
    private TextView mj;
    private ImageView mk;
    private TextView ml;
    private TextView mm;
    private TextView mn;
    private TextProgressBar mo;
    private TextView mp;
    private i mq;
    private final a mr;
    private boolean ms;

    /* renamed from: com.kwad.components.ad.interstitial.e.f$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.this.mg.setSelected(!f.this.mg.isSelected());
            if (f.this.mq != null) {
                f.this.mq.o(f.this.mg.isSelected());
            }
        }
    }

    public static class a {
        private boolean mu = false;
        private boolean mv = false;
        private int mw = 0;
        private boolean mx = true;

        public final void I(int i2) {
            this.mw = i2;
        }

        public final int eF() {
            return this.mw;
        }

        public final boolean eG() {
            return this.mx;
        }

        public final void v(boolean z) {
            this.mu = z;
        }

        public final void w(boolean z) {
            this.mv = z;
        }

        public final void x(boolean z) {
            this.mx = z;
        }
    }

    public f(@NonNull Context context, a aVar) {
        super(context);
        this.ma = "%s秒后进入试玩页";
        this.ms = false;
        this.mr = aVar;
        k.inflate(context, aVar.eG() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        s(aVar.mu);
    }

    private void a(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.kwai.a.a(getContext(), i2);
        layoutParams.height = com.kwad.sdk.c.kwai.a.a(getContext(), i3);
        view.setLayoutParams(layoutParams);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new com.kwad.sdk.widget.f(kSFrameLayout, this);
        this.kf.setWidthBasedRatio(!z);
    }

    private void b(View view, boolean z) {
        i iVar;
        i iVar2;
        i iVar3 = this.mq;
        if (iVar3 != null) {
            iVar3.p(z);
            this.mq.a(this.kY);
        }
        if (view.equals(this)) {
            i iVar4 = this.mq;
            if (iVar4 != null) {
                iVar4.dQ();
                return;
            }
            return;
        }
        if (view.equals(this.mh)) {
            if (!(1 == this.mr.eF()) || (iVar2 = this.mq) == null) {
                return;
            }
            iVar2.dP();
            return;
        }
        if (view.equals(this.mo)) {
            i iVar5 = this.mq;
            if (iVar5 != null) {
                iVar5.dR();
                return;
            }
            return;
        }
        if (view.equals(this.mf)) {
            i iVar6 = this.mq;
            if (iVar6 != null) {
                iVar6.ec();
                return;
            }
            return;
        }
        if (view.equals(this.md)) {
            i iVar7 = this.mq;
            if (iVar7 != null) {
                iVar7.dS();
                return;
            }
            return;
        }
        if (view.equals(this.mi)) {
            i iVar8 = this.mq;
            if (iVar8 != null) {
                iVar8.dV();
                return;
            }
            return;
        }
        if (view.equals(this.kf)) {
            i iVar9 = this.mq;
            if (iVar9 != null) {
                iVar9.dT();
                return;
            }
            return;
        }
        if (view.equals(this.eM)) {
            i iVar10 = this.mq;
            if (iVar10 != null) {
                iVar10.dU();
                return;
            }
            return;
        }
        if (view.equals(this.dJ)) {
            i iVar11 = this.mq;
            if (iVar11 != null) {
                iVar11.dW();
                return;
            }
            return;
        }
        if (view.equals(this.ml)) {
            i iVar12 = this.mq;
            if (iVar12 != null) {
                iVar12.dX();
                return;
            }
            return;
        }
        if (view.equals(this.eE)) {
            i iVar13 = this.mq;
            if (iVar13 != null) {
                iVar13.dY();
                return;
            }
            return;
        }
        if (view.equals(this.mk)) {
            i iVar14 = this.mq;
            if (iVar14 != null) {
                iVar14.dZ();
                return;
            }
            return;
        }
        if (view.equals(this.mm)) {
            i iVar15 = this.mq;
            if (iVar15 != null) {
                iVar15.ea();
                return;
            }
            return;
        }
        if (!view.equals(this.mn) || (iVar = this.mq) == null) {
            return;
        }
        iVar.eb();
    }

    private void d(View view, int i2) {
        com.kwad.sdk.c.kwai.a.b(view, 0, com.kwad.sdk.c.kwai.a.a(getContext(), i2), 0, 0);
    }

    private void ez() {
        a(this.mk, 40, 40);
        a(this.mo, org.mozilla.universalchardet.prober.n.c.m, 30);
        this.mm.setTextSize(14.0f);
        d(this.mo, 11);
        d(this.mm, 7);
        d(this.mn, 7);
    }

    private void s(boolean z) {
        setClickable(true);
        this.kY = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.kf = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.mb = findViewById(R.id.ksad_interstitial_full_bg);
        this.mc = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.f9537me = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.mf = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.md = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.mh = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.md;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.c.kwai.a.a(getContext(), 10.0f));
            this.md.setTextColor(-1);
        }
        this.mg = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.mj = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.mk = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.mm = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.mn = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.mo = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.mi = findViewById(R.id.ksad_ad_download_container);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ml = (TextView) findViewById(R.id.ksad_app_title);
        this.eE = (TextView) findViewById(R.id.ksad_app_desc);
        new com.kwad.sdk.widget.f(this, this);
        new com.kwad.sdk.widget.f(this.eM, this);
        new com.kwad.sdk.widget.f(this.md, this);
        new com.kwad.sdk.widget.f(this.mo, this);
        new com.kwad.sdk.widget.f(this.mh, this);
        new com.kwad.sdk.widget.f(this.mf, this);
        new com.kwad.sdk.widget.f(this.mj, this);
        new com.kwad.sdk.widget.f(this.mi, this);
        new com.kwad.sdk.widget.f(this.dJ, this);
        new com.kwad.sdk.widget.f(this.ml, this);
        new com.kwad.sdk.widget.f(this.eE, this);
        new com.kwad.sdk.widget.f(this.mk, this);
        new com.kwad.sdk.widget.f(this.mm, this);
        new com.kwad.sdk.widget.f(this.mn, this);
        this.mg.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.e.f.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.mg.setSelected(!f.this.mg.isSelected());
                if (f.this.mq != null) {
                    f.this.mq.o(f.this.mg.isSelected());
                }
            }
        });
        this.mp = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.kf, z);
        if (ai.DM()) {
            return;
        }
        ez();
    }

    public final void C(String str) {
        TextView textView = this.mj;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.mr.mv || this.ms || this.mj.getVisibility() == 0) {
            return;
        }
        this.mj.setVisibility(0);
    }

    public final void a(float f2, com.kwad.sdk.core.video.videoview.a aVar) {
        this.kf.setRatio(f2);
        this.kf.addView(aVar);
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

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String bK;
        TextProgressBar textProgressBar;
        String aw;
        ImageView imageView = this.mk;
        int i2 = R.drawable.ksad_default_app_icon;
        imageView.setImageResource(i2);
        if (com.kwad.sdk.core.response.a.a.ci(adInfo)) {
            KSImageLoader.loadCircleIcon(this.mk, com.kwad.sdk.core.response.a.a.cn(adInfo), getContext().getResources().getDrawable(i2));
            this.mm.setText(com.kwad.sdk.core.response.a.a.bL(adInfo));
            this.mn.setText(com.kwad.sdk.core.response.a.a.an(adInfo));
            if (com.kwad.sdk.core.response.a.a.cj(adInfo)) {
                textProgressBar = this.mo;
                aw = com.kwad.components.ad.c.b.ah();
            } else {
                textProgressBar = this.mo;
                aw = com.kwad.components.ad.c.b.ak();
            }
        } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            KSImageLoader.loadWithRadius(this.mk, ct.icon, adTemplate, 4);
            this.mm.setText(ct.name);
            this.mn.setVisibility(8);
            textProgressBar = this.mo;
            aw = com.kwad.components.ad.c.b.ai();
        } else {
            if (com.kwad.sdk.core.response.a.a.ax(adInfo)) {
                KSImageLoader.loadWithRadius(this.mk, com.kwad.sdk.core.response.a.a.bM(adInfo), adTemplate, 4);
                textView = this.mm;
                bK = com.kwad.sdk.core.response.a.a.ao(adInfo);
            } else {
                KSImageLoader.loadWithRadius(this.mk, com.kwad.sdk.core.response.a.d.cg(adTemplate), adTemplate, 4);
                textView = this.mm;
                bK = com.kwad.sdk.core.response.a.a.bK(adInfo);
            }
            textView.setText(bK);
            this.mn.setText(com.kwad.sdk.core.response.a.a.an(adInfo));
            textProgressBar = this.mo;
            aw = com.kwad.sdk.core.response.a.a.aw(adInfo);
        }
        textProgressBar.f(aw, 0);
    }

    public final void a(String str, AdTemplate adTemplate) {
        if (bb.isNullString(str)) {
            return;
        }
        this.eM.setImageDrawable(null);
        KSImageLoader.loadImage(this.eM, str, adTemplate);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void b(boolean z, int i2) {
        TextView textView = this.mp;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i2 >= 0) {
            this.mp.setText(String.format(this.ma, String.valueOf(i2)));
        }
    }

    public final void b(boolean z, boolean z2) {
        ImageView imageView = this.eM;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
            this.eM.setClickable(z2);
        }
    }

    public final void eA() {
        TextView textView = this.mj;
        if (textView != null) {
            textView.setVisibility(8);
            this.ms = true;
        }
    }

    public final void eB() {
        View view = this.mh;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void eC() {
        t(false);
        this.mf.setVisibility(0);
        this.mc.setVisibility(0);
    }

    public final void eD() {
        this.mf.setVisibility(8);
        this.mc.setVisibility(8);
        t(true);
    }

    public final boolean eE() {
        ViewGroup viewGroup = this.mf;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void f(int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i2;
        marginLayoutParams.height = i3;
        setLayoutParams(marginLayoutParams);
    }

    @Nullable
    public final View getBlurBgView() {
        return this.mb;
    }

    public final ImageView getTailFrameView() {
        return this.mc;
    }

    public final void h(String str, int i2) {
        TextProgressBar textProgressBar = this.md;
        if (textProgressBar != null) {
            textProgressBar.f(str, 0);
        }
        TextProgressBar textProgressBar2 = this.mo;
        if (textProgressBar2 != null) {
            textProgressBar2.f(str, 0);
        }
    }

    public final void j(AdTemplate adTemplate) {
        this.mLogoView.S(adTemplate);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(i iVar) {
        this.mq = iVar;
    }

    public final void t(boolean z) {
        ViewGroup viewGroup = this.f9537me;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public final void u(boolean z) {
        ImageView imageView = this.mg;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }
}
