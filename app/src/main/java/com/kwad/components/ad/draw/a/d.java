package com.kwad.components.ad.draw.a;

import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;

/* loaded from: classes.dex */
public final class d extends com.kwad.components.ad.draw.kwai.a {
    private TextView cG;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.d.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            d.this.cG.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            d.this.cG.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            d.this.cG.setVisibility(8);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.a.d$1 */
    final class AnonymousClass1 extends j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            d.this.cG.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            d.this.cG.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            d.this.cG.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        TextView textView;
        int i2;
        super.ar();
        if (ag.isNetworkConnected(getContext())) {
            textView = this.cG;
            i2 = 8;
        } else {
            textView = this.cG;
            i2 = 0;
        }
        textView.setVisibility(i2);
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cG = (TextView) findViewById(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.bX.b(this.mVideoPlayStateListener);
    }
}
