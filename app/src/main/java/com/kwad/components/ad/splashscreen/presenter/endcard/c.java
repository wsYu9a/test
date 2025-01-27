package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.splashscreen.presenter.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    private CloseCountDownView Gd;
    private ViewGroup Ge;
    private ViewGroup Gf;
    private ImageView Gg;
    private TextView Gh;
    private TextView Gi;
    private SplashEndLandView Gj;
    private CloseCountDownView.a Gk = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void dB() {
            a.C0484a c0484a = new a.C0484a();
            com.kwad.components.ad.splashscreen.monitor.a.lk().ac(c.this.EJ.mAdTemplate);
            if (c.this.EJ.mTimerHelper != null) {
                c0484a.duration = c.this.EJ.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.EJ.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(1).b(c0484a).cU(6), (JSONObject) null);
            c.this.EJ.lf();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void ls() {
            a.C0484a c0484a = new a.C0484a();
            if (c.this.EJ.mTimerHelper != null) {
                c0484a.duration = c.this.EJ.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.EJ.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(14).b(c0484a).cU(6), (JSONObject) null);
            c.this.EJ.lj();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.endcard.c$1 */
    public class AnonymousClass1 implements CloseCountDownView.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void dB() {
            a.C0484a c0484a = new a.C0484a();
            com.kwad.components.ad.splashscreen.monitor.a.lk().ac(c.this.EJ.mAdTemplate);
            if (c.this.EJ.mTimerHelper != null) {
                c0484a.duration = c.this.EJ.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.EJ.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(1).b(c0484a).cU(6), (JSONObject) null);
            c.this.EJ.lf();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void ls() {
            a.C0484a c0484a = new a.C0484a();
            if (c.this.EJ.mTimerHelper != null) {
                c0484a.duration = c.this.EJ.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.EJ.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(14).b(c0484a).cU(6), (JSONObject) null);
            c.this.EJ.lj();
        }
    }

    private void u(View view) {
        if (view == this.Ge) {
            this.EJ.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.Gf) {
            this.EJ.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.Gg) {
            this.EJ.c(2, view.getContext(), 15, 2);
        } else if (view == this.Gh) {
            this.EJ.c(2, view.getContext(), 16, 2);
        } else if (view == this.Gi) {
            this.EJ.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.Gj == null) {
            SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
            this.Gj = splashEndLandView;
            this.Gd = splashEndLandView.getCloseView();
            this.Ge = this.Gj.getGiftBoxView();
            this.Gf = this.Gj.getActionBarView();
            this.Gg = this.Gj.getAppIcon();
            this.Gh = this.Gj.getAppName();
            this.Gi = this.Gj.getAppDesc();
        }
        this.Gd.setOnViewClickListener(this.Gk);
        this.Gf.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.Gf.getContext(), this.Gf, this);
        if (com.kwad.sdk.core.response.b.b.dw(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate))) {
            this.Ge.setOnClickListener(this);
            this.Gg.setOnClickListener(this);
            this.Gh.setOnClickListener(this);
            this.Gi.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.Gf.getContext(), this.Ge, this);
            new com.kwad.sdk.widget.f(this.Gf.getContext(), this.Gg, this);
            new com.kwad.sdk.widget.f(this.Gf.getContext(), this.Gh, this);
            new com.kwad.sdk.widget.f(this.Gf.getContext(), this.Gi, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        u(view);
    }
}
