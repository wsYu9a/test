package com.kwad.components.ad.fullscreen.b.kwai;

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
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private ImageView gY;
    private TextView gZ;
    private AdTemplate mAdTemplate;
    private View ha = null;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    };
    private com.kwad.components.ad.reward.d.e hb = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            d.this.cf();
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            d.this.f(j2);
        }
    };
    private i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.f(j3);
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.d$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.d$2 */
    final class AnonymousClass2 implements com.kwad.components.ad.reward.d.e {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            d.this.cf();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.d$3 */
    final class AnonymousClass3 extends AdLivePlayStateListenerAdapter {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            d.this.f(j2);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.d$4 */
    final class AnonymousClass4 extends com.kwad.components.core.video.j {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.f(j3);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.d$5 */
    final class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.ha.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public void cc() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        this.mAdTemplate = jVar.mAdTemplate;
        jVar.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qt.oY.add(this.hb);
    }

    public void cf() {
        if (this.ha.getVisibility() == 0) {
            return;
        }
        this.ha.setAlpha(0.0f);
        this.ha.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.5
            AnonymousClass5() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.ha.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.ha.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.c(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    public final void f(long j2) {
        if (j2 >= com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            cf();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ha) {
            com.kwad.components.ad.reward.presenter.e.a(this.qt, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i2;
        View view;
        super.onCreate();
        this.gY = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.gZ = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.fullscreen.kwai.b.bP())) {
            if (com.kwad.components.ad.fullscreen.kwai.b.bO() == 0) {
                imageView = this.gY;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.gY;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.gZ.setVisibility(8);
            view = this.gY;
        } else {
            this.gZ.setText(com.kwad.components.ad.fullscreen.kwai.b.bP());
            this.gY.setVisibility(8);
            view = this.gZ;
        }
        this.ha = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.oY.remove(this.hb);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
