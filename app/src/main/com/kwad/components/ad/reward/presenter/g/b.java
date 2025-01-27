package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.f;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.app.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private static float yr = 0.4548105f;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a qO;

    /* renamed from: yk */
    @Nullable
    private ViewGroup f11788yk;

    @Nullable
    private q yl;
    private ViewGroup ym;
    private e yn;
    private c yo;

    @Nullable
    private c yp;
    private int ys = 15;
    private long yt = -1;
    private boolean yu = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.yo != null && g.K(b.this.rO.mAdTemplate)) {
                b.this.yo.kl();
            }
            if (b.this.yp != null) {
                b.this.yp.kl();
            }
        }
    };
    private com.kwad.sdk.core.c.c yv = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.X(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.X(true);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.g.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ KSFrameLayout yw;
        final /* synthetic */ float yx;

        public AnonymousClass1(KSFrameLayout kSFrameLayout, float f10) {
            kSFrameLayout = kSFrameLayout;
            dimension = f10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            kSFrameLayout.getHeight();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.g.b$2 */
    public class AnonymousClass2 implements f {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.n.f
        public final void i(String str, int i10) {
            com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.b.e.eb(b.this.rO.mAdTemplate).status);
            b.this.yo.j(str, i10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.g.b$3 */
    public class AnonymousClass3 implements l {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.yo != null && g.K(b.this.rO.mAdTemplate)) {
                b.this.yo.kl();
            }
            if (b.this.yp != null) {
                b.this.yp.kl();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.g.b$4 */
    public class AnonymousClass4 extends d {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.X(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.X(true);
        }
    }

    public void X(boolean z10) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.qO, getContext(), this.rO.mAdTemplate);
        if (!this.qO.kb()) {
            if (z10) {
                Y(false);
            }
        } else {
            if (!z10) {
                this.yt = System.currentTimeMillis();
                return;
            }
            boolean jy = jy();
            if (jy && (aVar = this.qO) != null) {
                aVar.ka();
                com.kwad.components.ad.reward.b.fv().notifyRewardVerify();
                this.rO.f11688qe.onRewardVerify();
            }
            Y(jy);
        }
    }

    private void Y(boolean z10) {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.yu + " completed: " + z10);
        if (this.yu) {
            return;
        }
        z.c(getContext(), z10 ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z10) {
            this.yu = true;
        }
    }

    private void Z(boolean z10) {
        this.rO.a(1, getContext(), z10 ? 1 : 153, 1);
    }

    private boolean jy() {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.yt);
        return this.yt >= 0 && System.currentTimeMillis() - this.yt > ((long) (this.ys * 1000));
    }

    @Override // com.kwad.sdk.app.a
    public final void Q(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            g gVar = this.rO;
            if (gVar.qO == null || !g.I(gVar.mAdTemplate)) {
                return;
            }
            this.rO.qO.jY();
            com.kwad.sdk.core.c.b.Fi();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.yt = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void R(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onBind");
        if (g.I(this.rO.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
            this.ys = com.kwad.components.ad.reward.a.b.gM();
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.a(this.yv);
            com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
            com.kwad.components.ad.reward.l.b.a jT = com.kwad.components.ad.reward.l.d.jT();
            this.qO = jT;
            this.rO.qO = jT;
            com.kwad.components.ad.reward.l.b.a.a(jT, getContext(), this.rO.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.f11788yk = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.f11788yk);
                this.yp = cVar;
                cVar.a(this.rO.mApkDownloadHelper);
                this.yp.a(this);
                this.yp.c(this.rO.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.f11788yk, this.rO.mApkDownloadHelper, this);
                this.yl = qVar;
                qVar.a(this.rO.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.app.b.BJ().a(this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.b(this.yv);
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        com.kwad.sdk.app.b.BJ().b(this);
        e eVar = this.yn;
        if (eVar != null) {
            eVar.kn();
            this.yn = null;
        }
        c cVar = this.yp;
        if (cVar != null) {
            cVar.kk();
        }
        this.rO.qO = null;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.rO.mAdTemplate)) {
            Z(false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z10, int i10) {
        this.rO.b(1, getContext(), z10 ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!an.NS()) {
            com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.ym = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.ym, this);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        kSFrameLayout.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            final /* synthetic */ KSFrameLayout yw;
            final /* synthetic */ float yx;

            public AnonymousClass1(KSFrameLayout kSFrameLayout2, float f10) {
                kSFrameLayout = kSFrameLayout2;
                dimension = f10;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.ym = viewGroup2;
        c cVar = new c(viewGroup2);
        this.yo = cVar;
        cVar.a(this.rO.mApkDownloadHelper);
        this.yo.a(this);
        this.yo.c(this.rO.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.ym, this.rO.mApkDownloadHelper, this);
        this.yn = eVar;
        eVar.a(new f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.reward.n.f
            public final void i(String str, int i10) {
                com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.b.e.eb(b.this.rO.mAdTemplate).status);
                b.this.yo.j(str, i10);
            }
        });
        this.yn.a(this.rO.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        Z(true);
    }
}
