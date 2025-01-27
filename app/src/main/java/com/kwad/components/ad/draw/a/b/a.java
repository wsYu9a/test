package com.kwad.components.ad.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {

    @Nullable
    private com.kwad.components.ad.i.b cp;
    private DrawVideoTailFrame dd;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.b.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (a.this.cp == null || !a.this.cp.az()) {
                a.this.aQ();
            } else {
                a.this.dd.setVisibility(8);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.draw.a.b.a$1 */
    final class AnonymousClass1 extends j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (a.this.cp == null || !a.this.cp.az()) {
                a.this.aQ();
            } else {
                a.this.dd.setVisibility(8);
            }
        }
    }

    public void aQ() {
        this.dd.aX();
        this.dd.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.draw.kwai.b bVar = this.bW;
        this.cp = bVar.cp;
        this.dd.bindView(bVar.mAdTemplate);
        this.dd.setAdBaseFrameLayout(this.bW.mRootContainer);
        this.dd.setApkDownloadHelper(this.bW.mApkDownloadHelper);
        this.dd.setVisibility(8);
        this.dd.setAdInteractionListener(this.bW.bV);
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dd = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.bX.b(this.mVideoPlayStateListener);
        this.dd.release();
    }
}
