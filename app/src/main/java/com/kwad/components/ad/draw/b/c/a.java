package com.kwad.components.ad.draw.b.c;

import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.draw.a.a {

    @Nullable
    private com.kwad.components.ad.m.b dw;
    private DrawVideoTailFrame el;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.c.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.dw == null || !a.this.dw.aQ()) {
                a.this.bh();
            } else {
                a.this.el.setVisibility(8);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.c.a$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.dw == null || !a.this.dw.aQ()) {
                a.this.bh();
            } else {
                a.this.el.setVisibility(8);
            }
        }
    }

    public void bh() {
        this.el.bq();
        this.el.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.draw.a.b bVar = this.f11413df;
        this.dw = bVar.dw;
        this.el.f(bVar.mAdTemplate);
        this.el.setAdBaseFrameLayout(this.f11413df.mRootContainer);
        this.el.setApkDownloadHelper(this.f11413df.mApkDownloadHelper);
        this.el.setVisibility(8);
        this.el.setAdInteractionListener(this.f11413df.f11414de);
        this.f11413df.f11415dg.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.el = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
        this.el.release();
    }
}
