package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bx;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, bx.a {
    private static final String[] wJ = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private bx bO;
    private TextView iv;
    private boolean ix;
    private long iy;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TextView wF;
    private ImageView wG;
    private View wH;
    private boolean wI = false;
    private boolean wK = false;
    private boolean wL = false;

    /* renamed from: ia */
    private final l f11812ia = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.ix) {
                return;
            }
            a.this.bO.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            long a10 = g.a(j10, a.this.mAdInfo);
            a.this.iy = j11;
            a.this.a(a10, j11);
        }
    };
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.wF.setText(a.wJ[2]);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.ix) {
                return;
            }
            a.this.bO.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            long a10 = g.a(j10, a.this.mAdInfo);
            a.this.iy = j11;
            a.this.a(a10, j11);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a$2 */
    public class AnonymousClass2 implements com.kwad.components.ad.reward.e.l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.wF.setText(a.wJ[2]);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            a.this.iv.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a$4 */
    public class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.iv.setAlpha(1.0f - floatValue);
            a.this.wG.setAlpha(floatValue);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.a$5 */
    public class AnonymousClass5 implements a.b {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            a.this.notifyAdClick();
        }
    }

    private void cw() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        this.mAdInfo = eb2;
        this.mApkDownloadHelper = this.rO.mApkDownloadHelper;
        long a10 = g.a(com.kwad.sdk.core.response.b.a.M(eb2), this.mAdInfo) / 1000;
        if (g.K(this.mAdTemplate)) {
            this.wH.setVisibility(0);
            this.wH.setOnClickListener(this);
            this.wF.setText(String.format(wJ[0], Long.valueOf(a10)));
            this.iv.setVisibility(8);
        } else {
            this.wH.setVisibility(8);
            this.iv.setText(String.valueOf(a10));
            this.iv.setVisibility(0);
            this.iv.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.rO.f11689qf.a(this.f11812ia);
    }

    private void iG() {
        if (this.wI) {
            return;
        }
        this.wI = true;
        this.wG.setAlpha(0.0f);
        this.wG.setVisibility(0);
        this.wG.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            public AnonymousClass3() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.iv.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            public AnonymousClass4() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.iv.setAlpha(1.0f - floatValue);
                a.this.wG.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void iH() {
        com.kwad.components.ad.reward.e.d dVar = this.rO.mAdRewardStepListener;
        if (dVar != null) {
            dVar.fA();
        }
    }

    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(41), this.rO.mReportExtData);
        this.rO.f11688qe.cg();
    }

    private void notifyRewardVerify() {
        this.rO.f11688qe.onRewardVerify();
    }

    private void x(int i10) {
        this.rO.qQ = i10;
        if (!g.K(this.mAdTemplate)) {
            this.iv.setText(String.valueOf(i10));
        } else {
            if (this.wK) {
                return;
            }
            this.wF.setText(String.format(wJ[0], Integer.valueOf(i10)));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.bO = new bx(this);
        cw();
        if (this.rO.f11689qf.kh()) {
            x((int) (com.kwad.sdk.core.response.b.a.ag(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.wG || view == this.wH) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(2).v(this.rO.f11689qf.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.iv = (TextView) findViewById(R.id.ksad_video_count_down);
        this.wG = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.wF = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.wH = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        this.rO.f11689qf.b(this.f11812ia);
        this.wG.setVisibility(8);
        this.wH.setVisibility(8);
        this.wI = false;
        this.wK = false;
        this.ix = false;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.wK = true;
        return true;
    }

    public final void a(long j10, long j11) {
        int aK;
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) && com.kwad.components.core.q.a.rJ().rK() == 0) {
            aK = com.kwad.sdk.core.response.b.a.aM(this.mAdInfo);
        } else {
            aK = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo);
        }
        g gVar = this.rO;
        long j12 = aK * (gVar.qx ? 1000 : 0);
        m.b(gVar, j11, j10, j12);
        if (!this.wL) {
            this.wL = k.a(this.rO, j11, j10, j12);
        }
        a(j11, j10, j12);
    }

    private void a(long j10, long j11, long j12) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (j10 < (j11 - 800) - j12) {
            int floor = (int) Math.floor((j11 - j10) / 1000.0f);
            int i10 = floor > 0 ? floor : 1;
            x(i10);
            p pVar = this.rO.qG;
            if (pVar != null) {
                pVar.U(i10);
                return;
            }
            return;
        }
        this.rO.qA = true;
        if (g.K(this.mAdTemplate)) {
            if (g.I(this.mAdTemplate) && (aVar2 = this.rO.qO) != null) {
                if (!aVar2.jW()) {
                    this.rO.qO.jV();
                }
            } else if (g.J(this.mAdTemplate) && (aVar = this.rO.qP) != null && !aVar.jW()) {
                this.rO.qP.jV();
            }
            if (this.wK) {
                return;
            }
            this.wF.setText(wJ[1]);
            iH();
            return;
        }
        notifyRewardVerify();
        iG();
        p pVar2 = this.rO.qG;
        if (pVar2 != null) {
            pVar2.U(0);
        }
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.rO.gg() && !this.rO.gf()) {
                this.iy += 500;
                a(com.kwad.sdk.core.response.b.a.ag(this.mAdInfo), this.iy);
                this.bO.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.bO.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
