package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private ImageView uH;
    private TextView uI;
    private boolean uJ = false;
    private View uK = null;
    private long uL = -1;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (c.this.uL >= 0) {
                if (j2 > Math.min(c.this.uL, com.kwad.sdk.core.response.a.a.X(c.this.mAdInfo))) {
                    c.this.ih();
                }
            }
        }
    };
    private final i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            if (c.this.uL >= 0) {
                if (j3 > Math.min(Math.min(c.this.uL, com.kwad.sdk.core.response.a.a.X(c.this.mAdInfo)), j2)) {
                    c.this.ih();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.d.e hb = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            c.a(c.this, true);
            c.this.ih();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.c$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.c$2 */
    final class AnonymousClass2 extends AdLivePlayStateListenerAdapter {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (c.this.uL >= 0) {
                if (j2 > Math.min(c.this.uL, com.kwad.sdk.core.response.a.a.X(c.this.mAdInfo))) {
                    c.this.ih();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.c$3 */
    final class AnonymousClass3 extends com.kwad.components.core.video.j {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            if (c.this.uL >= 0) {
                if (j3 > Math.min(Math.min(c.this.uL, com.kwad.sdk.core.response.a.a.X(c.this.mAdInfo)), j2)) {
                    c.this.ih();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.c$4 */
    final class AnonymousClass4 implements com.kwad.components.ad.reward.d.e {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            c.a(c.this, true);
            c.this.ih();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.c$5 */
    final class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.uK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.uJ = true;
        return true;
    }

    public void cc() {
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.oY.add(this.hb);
        long W = com.kwad.sdk.core.response.a.a.W(this.mAdInfo);
        this.uL = W;
        this.uK.setVisibility(W == 0 ? 0 : 8);
    }

    public void ih() {
        if (this.uK.getVisibility() == 0) {
            return;
        }
        this.uK.setAlpha(0.0f);
        this.uK.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.5
            AnonymousClass5() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.uK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.uK) {
            com.kwad.components.ad.reward.presenter.e.a(this.qt, this.uJ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i2;
        View view;
        super.onCreate();
        this.uH = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.uI = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.reward.kwai.b.gx())) {
            if (com.kwad.components.ad.reward.kwai.b.gw() == 0) {
                imageView = this.uH;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.uH;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            view = this.uH;
        } else {
            this.uI.setText(com.kwad.components.ad.reward.kwai.b.gx());
            view = this.uI;
        }
        this.uK = view;
        this.uK.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.oY.remove(this.hb);
        this.uK.setVisibility(8);
    }
}
