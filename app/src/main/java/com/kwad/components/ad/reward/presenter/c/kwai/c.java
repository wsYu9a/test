package com.kwad.components.ad.reward.presenter.c.kwai;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.i.b;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k.t;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    private com.kwad.components.ad.i.b cp;
    private FrameLayout df;
    private DetailVideoView mDetailVideoView;
    private com.kwad.components.ad.i.b oS;

    @Nullable
    private FrameLayout vi;
    private int sU = Integer.MIN_VALUE;
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.cp == null || !com.kwad.components.ad.reward.j.q(c.this.qt.mAdTemplate)) {
                return;
            }
            c.this.cp.al(true);
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            c.this.qt.mAdOpenInteractionListener.bN();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.c$1 */
    final class AnonymousClass1 implements j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.cp == null || !com.kwad.components.ad.reward.j.q(c.this.qt.mAdTemplate)) {
                return;
            }
            c.this.cp.al(true);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.c.kwai.c$2 */
    final class AnonymousClass2 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            c.this.qt.mAdOpenInteractionListener.bN();
        }
    }

    private void iv() {
        FrameLayout frameLayout;
        com.kwad.components.ad.i.b bVar;
        AdTemplate adTemplate = this.qt.mAdTemplate;
        if (!com.kwad.sdk.core.response.a.b.bF(adTemplate) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bH(adTemplate)) || (frameLayout = this.vi) == null || (bVar = this.oS) == null) {
            return;
        }
        com.kwad.components.ad.reward.j jVar = this.qt;
        bVar.a(frameLayout, jVar.mRootContainer, adTemplate, jVar.mApkDownloadHelper, jVar.mScreenOrientation);
        this.oS.a((b.InterfaceC0132b) null);
        ViewGroup.LayoutParams layoutParams = this.vi.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            getContext();
            if (ai.DL()) {
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_animate_margin);
            } else {
                marginLayoutParams.bottomMargin = 0;
                int screenWidth = com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / 2;
                marginLayoutParams.width = screenWidth;
                marginLayoutParams.height = -1;
                marginLayoutParams.rightMargin = -screenWidth;
            }
            this.vi.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void a(com.kwad.components.ad.i.b bVar) {
        Animator a2;
        if (bVar.equals(this.oS)) {
            getContext();
            if (ai.DL()) {
                this.sU = com.kwad.sdk.c.kwai.a.D(this.mDetailVideoView);
                com.kwad.sdk.c.kwai.a.n(this.mDetailVideoView, 49);
                a2 = t.a(this.qt.mAdTemplate, this.oS.lL(), this.mDetailVideoView);
            } else {
                a2 = t.a(this.qt.mAdTemplate, this.mDetailVideoView, this.oS.lL());
            }
            if (a2 != null) {
                a2.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qt;
        AdTemplate adTemplate = jVar.mAdTemplate;
        l lVar = jVar.oR;
        this.cp = lVar;
        if (lVar == null) {
            return;
        }
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.cp.a(this.mWebCardClickListener);
        com.kwad.components.ad.i.b bVar = this.cp;
        FrameLayout frameLayout = this.df;
        com.kwad.components.ad.reward.j jVar2 = this.qt;
        bVar.a(frameLayout, jVar2.mRootContainer, adTemplate, jVar2.mApkDownloadHelper, jVar2.mScreenOrientation);
        this.cp.a((b.InterfaceC0132b) null);
        com.kwad.components.ad.i.b bVar2 = this.qt.oS;
        this.oS = bVar2;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        com.kwad.components.ad.i.b bVar3 = this.cp;
        if (bVar3 != null) {
            bVar3.a(this);
        }
        iv();
    }

    @Override // com.kwad.components.ad.i.b.a
    public final void iw() {
        hq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.df = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.vi = (FrameLayout) findViewById(R.id.ksad_play_again_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i2;
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.cp;
        if (bVar != null) {
            bVar.lK();
            this.cp.jW();
        }
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        com.kwad.components.ad.i.b bVar2 = this.oS;
        if (bVar2 != null) {
            bVar2.lK();
            this.oS.jW();
            this.oS.a((b.a) null);
        }
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i2 = this.sU) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.kwai.a.n(detailVideoView, i2);
    }
}
