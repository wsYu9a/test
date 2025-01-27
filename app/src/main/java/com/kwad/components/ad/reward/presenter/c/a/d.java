package com.kwad.components.ad.reward.presenter.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c {
    private static final String[] vv = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private e gG = new e() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (com.kwad.components.ad.reward.j.q(d.this.qt.mAdTemplate)) {
                d.this.iC();
            }
        }
    };
    private ViewGroup vr;
    private ImageView vs;
    private ViewGroup vt;
    private TextView vu;

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a.d$1 */
    final class AnonymousClass1 extends e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a.d$2 */
    final class AnonymousClass2 implements com.kwad.components.ad.reward.d.j {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (com.kwad.components.ad.reward.j.q(d.this.qt.mAdTemplate)) {
                d.this.iC();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.a.d$3 */
    final class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            d.this.notifyAdClick();
        }
    }

    public void cc() {
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.vr.setVisibility(0);
        this.vt.setVisibility(com.kwad.components.ad.reward.j.q(this.qt.mAdTemplate) ? 0 : 8);
    }

    private void iB() {
        ImageView imageView = this.vs;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vs.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vr;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vr.setVisibility(0);
        }
    }

    public void iC() {
        this.vu.setText(vv[2]);
    }

    public void notifyAdClick() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 41, jVar.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a.c
    public final void iz() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        boolean z = jVar.pq;
        AdTemplate adTemplate = jVar.mAdTemplate;
        if (z) {
            if (com.kwad.sdk.core.response.a.a.aj(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
                this.vt.setVisibility(8);
            }
        } else if (com.kwad.components.ad.reward.j.o(adTemplate) || com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate)) {
            if (this.qt.fX()) {
                return;
            }
            this.vu.setText(this.qt.pl ? vv[1] : vv[0]);
        } else if (this.qt.fX()) {
            iB();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vs || view == this.vr) {
            com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.qt.mAdTemplate).b(this.qt.mApkDownloadHelper).ao(false).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.c.a.d.3
                AnonymousClass3() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vr = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.vs = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.vt = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.vu = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.vr.setVisibility(8);
        this.vs.setVisibility(8);
        this.vt.setVisibility(8);
    }
}
