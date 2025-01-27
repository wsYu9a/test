package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] xz = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.K(d.this.rO.mAdTemplate)) {
                d.this.jc();
            }
        }
    };
    private ViewGroup xv;
    private ImageView xw;
    private ViewGroup xx;
    private TextView xy;

    /* renamed from: com.kwad.components.ad.reward.presenter.d.b.d$1 */
    public class AnonymousClass1 implements l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.K(d.this.rO.mAdTemplate)) {
                d.this.jc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.b.d$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            d.this.notifyAdClick();
        }
    }

    private void cw() {
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.xv.setVisibility(0);
        this.xx.setVisibility(g.K(this.rO.mAdTemplate) ? 0 : 8);
    }

    private void jb() {
        ImageView imageView = this.xw;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.xw.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.xv;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.xv.setVisibility(0);
        }
    }

    public void jc() {
        this.xy.setText(xz[2]);
    }

    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.b cL = new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(41);
        g gVar = this.rO;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, (String) null, (String) null, cL, gVar.mReportExtData);
        this.rO.f11688qe.cg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iZ() {
        g gVar = this.rO;
        if (gVar.qH) {
            if (com.kwad.sdk.core.response.b.a.as(e.eb(gVar.mAdTemplate))) {
                this.xx.setVisibility(8);
            }
        } else if (g.I(gVar.mAdTemplate) || g.J(this.rO.mAdTemplate)) {
            if (this.rO.gh()) {
                return;
            }
            this.xy.setText(this.rO.qA ? xz[1] : xz[0]);
        } else if (this.rO.gh()) {
            jb();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.xw || view == this.xv) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.rO.mAdTemplate).b(this.rO.mApkDownloadHelper).ap(false).ao(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xv = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.xw = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.xx = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.xy = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        this.xv.setVisibility(8);
        this.xw.setVisibility(8);
        this.xx.setVisibility(8);
    }
}
