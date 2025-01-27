package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements ar.b {

    @Nullable
    private com.kwad.components.ad.m.b dw;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;

    /* renamed from: xf */
    private TailFrameView f11759xf;

    /* renamed from: xg */
    private volatile boolean f11760xg;

    /* renamed from: xh */
    private boolean f11761xh;

    /* renamed from: xi */
    private k f11762xi;
    private Drawable xl;
    private boolean uu = false;

    /* renamed from: xj */
    private int f11763xj = Integer.MIN_VALUE;

    /* renamed from: xk */
    private int f11764xk = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.iS();
            if (b.this.f11759xf == null || !g.K(b.this.mAdTemplate)) {
                return;
            }
            b.this.f11759xf.kl();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if ((!e.eo(b.this.mAdTemplate) && b.this.uu && !b.this.rO.gb()) || b.this.rO.qH || b.this.rO.qN) {
                return;
            }
            b.this.f11761xh = true;
            if (b.this.dw != null && b.this.dw.aQ()) {
                b.this.f11761xh = false;
            }
            b.this.rO.qY = true ^ b.this.f11761xh;
            if (b.this.f11761xh) {
                if (b.this.rO.f11693qj != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.rO.mAdTemplate, b.this.rO.qu, "end_card", com.kwad.sdk.core.response.b.b.cG(b.this.mAdTemplate), System.currentTimeMillis() - b.this.rO.f11693qj.getLoadTime(), 1);
                }
                b.this.bh();
            }
        }

        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.b$1 */
    public class AnonymousClass1 implements l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.iS();
            if (b.this.f11759xf == null || !g.K(b.this.mAdTemplate)) {
                return;
            }
            b.this.f11759xf.kl();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.b$2 */
    public class AnonymousClass2 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if ((!e.eo(b.this.mAdTemplate) && b.this.uu && !b.this.rO.gb()) || b.this.rO.qH || b.this.rO.qN) {
                return;
            }
            b.this.f11761xh = true;
            if (b.this.dw != null && b.this.dw.aQ()) {
                b.this.f11761xh = false;
            }
            b.this.rO.qY = true ^ b.this.f11761xh;
            if (b.this.f11761xh) {
                if (b.this.rO.f11693qj != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.rO.mAdTemplate, b.this.rO.qu, "end_card", com.kwad.sdk.core.response.b.b.cG(b.this.mAdTemplate), System.currentTimeMillis() - b.this.rO.f11693qj.getLoadTime(), 1);
                }
                b.this.bh();
            }
        }

        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.b$3 */
    public class AnonymousClass3 implements com.kwad.components.ad.reward.widget.tailframe.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.b
        public final void O(boolean z10) {
            b.this.L(z10);
        }
    }

    public void L(boolean z10) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(z10 ? 2 : 153), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    private void Q(int i10) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i10;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    public void bh() {
        iS();
        this.f11759xf.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void O(boolean z10) {
                b.this.L(z10);
            }
        });
        this.f11759xf.setVisibility(0);
    }

    public void iS() {
        if (this.f11760xg) {
            return;
        }
        iT();
    }

    private void iT() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.f11759xf.a(getContext(), this.rO.mScreenOrientation == 0, iV());
        this.f11760xg = true;
    }

    private void iU() {
        if (this.f11761xh) {
            iS();
            this.f11759xf.destroy();
            this.f11759xf.setVisibility(8);
            this.f11762xi.hide();
        }
    }

    private boolean iV() {
        AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
        return aX.height > aX.width;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.core.playable.a aVar = this.rO.f11691qh;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.eb(this.mAdTemplate);
        g gVar = this.rO;
        this.dw = gVar.f11693qj;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.f11759xf.setCallerContext(this.rO);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.f11762xi = new k(this.rO, viewStub);
        } else {
            this.f11762xi = new k(this.rO, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11759xf = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.rO.f11691qh;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        iU();
        this.rO.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i10 = this.f11764xk;
            if (i10 != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i10);
            }
            com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.f11763xj);
            int i11 = this.f11763xj;
            if (i11 != Integer.MIN_VALUE) {
                Q(i11);
            }
            Drawable drawable = this.xl;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ar.b
    public final void a(ar.a aVar) {
        this.uu = aVar.isSuccess();
    }
}
