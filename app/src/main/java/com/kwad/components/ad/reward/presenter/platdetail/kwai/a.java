package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.n;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bm;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, bm.a {
    private static final String[] uD = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private TextView gI;
    private bm gK;
    private boolean gL;
    private long gM;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ImageView uA;
    private View uB;
    private TextView uz;
    private boolean uC = false;
    private boolean uE = false;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.a(com.kwad.sdk.core.response.a.a.X(a.this.mAdInfo), j2);
                a.this.gM = j2;
                a.a(a.this, true);
            }
        }
    };
    private final i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            long a2 = com.kwad.components.ad.reward.j.a(j2, a.this.mAdInfo);
            a.this.gM = j3;
            a.this.a(a2, j3);
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            a.b(a.this, true);
            a.this.uz.setText(a.uD[2]);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.a(com.kwad.sdk.core.response.a.a.X(a.this.mAdInfo), j2);
                a.this.gM = j2;
                a.a(a.this, true);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            long a2 = com.kwad.components.ad.reward.j.a(j2, a.this.mAdInfo);
            a.this.gM = j3;
            a.this.a(a2, j3);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$4 */
    final class AnonymousClass4 implements com.kwad.components.ad.reward.d.j {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            a.b(a.this, true);
            a.this.uz.setText(a.uD[2]);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$5 */
    final class AnonymousClass5 extends AnimatorListenerAdapter {
        AnonymousClass5() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            a.this.gI.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$6 */
    final class AnonymousClass6 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass6() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.gI.setAlpha(1.0f - floatValue);
            a.this.uA.setAlpha(floatValue);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.a$7 */
    final class AnonymousClass7 implements a.b {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            a.this.notifyAdClick();
        }
    }

    private void A(int i2) {
        this.qt.py = i2;
        if (!com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            this.gI.setText(String.valueOf(i2));
        } else {
            if (this.uE) {
                return;
            }
            this.uz.setText(String.format(uD[0], Integer.valueOf(i2)));
        }
    }

    private void a(long j2, long j3, long j4) {
        com.kwad.components.ad.reward.i.kwai.a aVar;
        com.kwad.components.ad.reward.i.a.a aVar2;
        if (j2 < (j3 - 800) - j4) {
            int i2 = (int) (((j3 - j2) / 1000.0f) + 0.5f);
            A(i2);
            o oVar = this.qt.pp;
            if (oVar != null) {
                oVar.W(i2);
                return;
            }
            return;
        }
        this.qt.pl = true;
        if (!com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            notifyRewardVerify();
            ie();
            o oVar2 = this.qt.pp;
            if (oVar2 != null) {
                oVar2.W(0);
                return;
            }
            return;
        }
        if (!com.kwad.components.ad.reward.j.o(this.mAdTemplate) || (aVar2 = this.qt.pw) == null) {
            if (com.kwad.components.ad.reward.j.p(this.mAdTemplate) && (aVar = this.qt.px) != null && !aVar.jv()) {
                this.qt.px.ju();
            }
        } else if (!aVar2.jv()) {
            this.qt.pw.ju();
        }
        if (this.uE) {
            return;
        }
        this.uz.setText(uD[1]);
        m57if();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.gL = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.uE = true;
        return true;
    }

    public void cc() {
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        this.mApkDownloadHelper = this.qt.mApkDownloadHelper;
        long a2 = com.kwad.components.ad.reward.j.a(com.kwad.sdk.core.response.a.a.G(cb), this.mAdInfo) / 1000;
        if (com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            this.uB.setVisibility(0);
            this.uB.setOnClickListener(this);
            this.uz.setText(String.format(uD[0], Long.valueOf(a2)));
            this.gI.setVisibility(8);
        } else {
            this.uB.setVisibility(8);
            this.gI.setText(String.valueOf(a2));
            this.gI.setVisibility(0);
            this.gI.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    private void ie() {
        if (this.uC) {
            return;
        }
        this.uC = true;
        this.uA.setAlpha(0.0f);
        this.uA.setVisibility(0);
        this.uA.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
            AnonymousClass5() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.gI.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.6
            AnonymousClass6() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.gI.setAlpha(1.0f - floatValue);
                a.this.uA.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* renamed from: if */
    private void m57if() {
        com.kwad.components.ad.reward.d.d dVar = this.qt.mAdRewardStepListener;
        if (dVar != null) {
            dVar.fo();
        }
    }

    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 41, this.qt.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    private void notifyRewardVerify() {
        this.qt.mAdOpenInteractionListener.onRewardVerify();
    }

    public final void a(long j2, long j3) {
        int aE = com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(this.mAdInfo) : com.kwad.sdk.core.response.a.a.aC(this.mAdInfo);
        com.kwad.components.ad.reward.j jVar = this.qt;
        long j4 = aE * (jVar.pi ? 1000 : 0);
        n.a(jVar, j3, j2, j4);
        a(j3, j2, j4);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qt.fW() || this.qt.fV()) {
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.gM += 500;
            a(com.kwad.sdk.core.response.a.a.X(this.mAdInfo), this.gM);
            this.gK.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gK = new bm(this);
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            return;
        }
        cc();
        if (this.qt.oN.jF()) {
            A((int) (com.kwad.sdk.core.response.a.a.X(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.uA || view == this.uB) {
            com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(2).q(this.qt.oN.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.7
                AnonymousClass7() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gI = (TextView) findViewById(R.id.ksad_video_count_down);
        this.uA = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.uz = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.uB = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.uA.setVisibility(8);
        this.uB.setVisibility(8);
        this.uC = false;
        this.uE = false;
        this.gL = false;
    }
}
