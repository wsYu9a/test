package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public final class u extends a {
    private DetailVideoView oM;
    private ViewGroup tp;
    private FrameLayout tq;
    private ImageView tr;
    private ViewGroup.LayoutParams ts = null;
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.u.1

        /* renamed from: com.kwad.components.ad.reward.presenter.u$1$1 */
        final class RunnableC01521 implements Runnable {
            RunnableC01521() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                u.this.oM.setVisibility(0);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            u.this.oM.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.u.1.1
                RunnableC01521() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    u.this.oM.setVisibility(0);
                }
            }, 200L);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.u$1 */
    final class AnonymousClass1 extends com.kwad.components.core.video.j {

        /* renamed from: com.kwad.components.ad.reward.presenter.u$1$1 */
        final class RunnableC01521 implements Runnable {
            RunnableC01521() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                u.this.oM.setVisibility(0);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            u.this.oM.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.u.1.1
                RunnableC01521() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    u.this.oM.setVisibility(0);
                }
            }, 200L);
        }
    }

    private void Q(@LayoutRes int i2) {
        this.tq.addView(com.kwad.sdk.j.k.a(getContext(), i2, this.tq, false), -1, -1);
    }

    private void hL() {
    }

    private void hM() {
        int i2;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        getContext();
        boolean z = !ai.DL();
        boolean bv = com.kwad.sdk.core.response.a.a.bv(cb);
        boolean z2 = com.kwad.sdk.core.response.a.a.ci(cb) && com.kwad.components.ad.reward.kwai.b.gJ();
        boolean z3 = com.kwad.components.ad.reward.j.o(this.qt.mAdTemplate) || com.kwad.components.ad.reward.j.p(this.qt.mAdTemplate) || bv || z2;
        if (!z || !z3) {
            this.tp.setVisibility(8);
            return;
        }
        this.tp.setVisibility(z2 ? 4 : 0);
        if (bv) {
            this.tr.setVisibility(8);
            i2 = R.layout.ksad_playable_end_info;
        } else {
            i2 = R.layout.ksad_activity_apk_info_landscape;
        }
        Q(i2);
        if (!com.kwad.sdk.core.response.a.a.aR(cb)) {
            this.oM.updateTextureViewGravity(17);
        } else {
            this.oM.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        hL();
        ViewGroup.LayoutParams layoutParams = this.oM.getLayoutParams();
        if (layoutParams != null) {
            this.ts = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qt.oN.jH().a(this.mVideoPlayStateListener);
        hM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.oM = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tp = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.tr = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.tq = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qt.oN.jH().b(this.mVideoPlayStateListener);
        if (this.ts == null || (detailVideoView = this.oM) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ts;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.oM.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.oM;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.ts = null;
    }
}
