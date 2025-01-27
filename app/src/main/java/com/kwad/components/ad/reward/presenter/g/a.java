package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.l.d;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.yo != null) {
                a.this.yo.kl();
            }
            if (a.this.yp != null) {
                a.this.yp.kl();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a qP;

    /* renamed from: yk */
    @Nullable
    private ViewGroup f11787yk;

    @Nullable
    private q yl;
    private ViewGroup ym;
    private e yn;
    private c yo;

    @Nullable
    private c yp;

    /* renamed from: com.kwad.components.ad.reward.presenter.g.a$1 */
    public class AnonymousClass1 implements l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.yo != null) {
                a.this.yo.kl();
            }
            if (a.this.yp != null) {
                a.this.yp.kl();
            }
        }
    }

    private void c(View view, boolean z10) {
        int id2 = view.getId();
        if (id2 == R.id.ksad_reward_apk_info_card_native_container || id2 == R.id.ksad_activity_apk_info_area_native) {
            e(z10, 2);
        }
    }

    private void e(boolean z10, int i10) {
        this.rO.a(1, getContext(), z10 ? 1 : 153, i10);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onBind");
        if (g.J(this.rO.mAdTemplate)) {
            com.kwad.components.ad.reward.l.a.a jU = d.jU();
            this.qP = jU;
            this.rO.qP = jU;
            com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.f11787yk = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.f11787yk.setVisibility(8);
                new f(this.f11787yk, this);
                c cVar = new c(this.f11787yk);
                this.yp = cVar;
                cVar.a(this);
                this.yp.c(this.rO.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.f11787yk, null, this);
                this.yl = qVar;
                qVar.a(this.rO.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z10, int i10) {
        e(z10, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.yn;
        if (eVar != null) {
            eVar.kn();
            this.yn = null;
        }
        c cVar = this.yp;
        if (cVar != null) {
            cVar.kk();
        }
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        this.rO.qP = null;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.rO.mAdTemplate)) {
            c(view, false);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!an.NS()) {
            com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.b.d.dS(this.rO.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.ym = viewGroup;
        viewGroup.setClickable(true);
        new f(this.ym, this);
        c cVar = new c(this.ym);
        this.yo = cVar;
        cVar.a(this);
        this.yo.c(this.rO.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.ym, null, this);
        this.yn = eVar;
        eVar.a(this.rO.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }
}
