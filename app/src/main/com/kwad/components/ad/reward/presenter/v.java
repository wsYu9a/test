package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class v extends b {

    /* renamed from: vc */
    private DetailVideoView f11882vc;

    /* renamed from: vd */
    private ViewGroup f11883vd;

    /* renamed from: ve */
    private FrameLayout f11884ve;

    /* renamed from: vf */
    private ImageView f11885vf;

    /* renamed from: vg */
    private ViewGroup.LayoutParams f11886vg = null;

    /* renamed from: ia */
    private com.kwad.components.core.video.l f11881ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.v.1

        /* renamed from: com.kwad.components.ad.reward.presenter.v$1$1 */
        public class RunnableC04031 implements Runnable {
            public RunnableC04031() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                v.this.f11882vc.setVisibility(0);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.f11882vc.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                public RunnableC04031() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v.this.f11882vc.setVisibility(0);
                }
            }, 200L);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.v$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {

        /* renamed from: com.kwad.components.ad.reward.presenter.v$1$1 */
        public class RunnableC04031 implements Runnable {
            public RunnableC04031() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                v.this.f11882vc.setVisibility(0);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.f11882vc.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                public RunnableC04031() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v.this.f11882vc.setVisibility(0);
                }
            }, 200L);
        }
    }

    private void P(@LayoutRes int i10) {
        this.f11884ve.addView(com.kwad.sdk.n.m.a(getContext(), i10, this.f11884ve, false), -1, -1);
    }

    /* renamed from: if */
    private void m34if() {
    }

    private void ig() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        getContext();
        boolean z10 = !an.NS();
        boolean bJ = com.kwad.sdk.core.response.b.a.bJ(eb2);
        boolean z11 = com.kwad.sdk.core.response.b.a.cK(eb2) && com.kwad.components.ad.reward.a.b.gX();
        boolean z12 = com.kwad.components.ad.reward.g.I(this.rO.mAdTemplate) || com.kwad.components.ad.reward.g.J(this.rO.mAdTemplate) || bJ || z11;
        if (!z10 || !z12) {
            this.f11883vd.setVisibility(8);
            return;
        }
        this.f11883vd.setVisibility(z11 ? 4 : 0);
        if (bJ) {
            this.f11885vf.setVisibility(8);
            P(R.layout.ksad_playable_end_info);
        } else {
            P(R.layout.ksad_activity_apk_info_landscape);
        }
        if (!com.kwad.sdk.core.response.b.a.aY(eb2)) {
            this.f11882vc.updateTextureViewGravity(17);
        } else {
            this.f11882vc.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        m34if();
        ViewGroup.LayoutParams layoutParams = this.f11882vc.getLayoutParams();
        if (layoutParams != null) {
            this.f11886vg = new ViewGroup.LayoutParams(layoutParams);
        }
        this.rO.f11689qf.a(this.f11881ia);
        ig();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11882vc = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.f11883vd = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.f11885vf = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.f11884ve = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.rO.f11689qf.b(this.f11881ia);
        if (this.f11886vg == null || (detailVideoView = this.f11882vc) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.f11886vg;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.f11882vc.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.f11882vc;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.f11886vg = null;
    }
}
