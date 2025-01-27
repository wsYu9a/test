package com.kwad.components.ad.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    private ImageView dy;
    private com.kwad.sdk.core.response.model.b dz;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.this.dy.getVisibility() == 0) {
                b.this.dy.setVisibility(8);
            }
        }
    };
    private Runnable dA = new Runnable() { // from class: com.kwad.components.ad.draw.b.b.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.dy.getLayoutParams();
            int width2 = b.this.dz.getWidth();
            int height = b.this.dz.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.dy.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.dy.setLayoutParams(layoutParams);
                b.this.dy.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.dy.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.dy, b.this.dz.getUrl(), b.this.f11413df.mAdTemplate);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.b$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.this.dy.getVisibility() == 0) {
                b.this.dy.setVisibility(8);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.dy.getLayoutParams();
            int width2 = b.this.dz.getWidth();
            int height = b.this.dz.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.dy.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.dy.setLayoutParams(layoutParams);
                b.this.dy.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.dy.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.dy, b.this.dz.getUrl(), b.this.f11413df.mAdTemplate);
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.response.model.b bt = com.kwad.sdk.core.response.b.a.bt(e.eb(this.f11413df.mAdTemplate));
        this.dz = bt;
        if (TextUtils.isEmpty(bt.getUrl())) {
            return;
        }
        getRootView().post(this.dA);
        this.dy.setVisibility(0);
        this.f11413df.f11415dg.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dy = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.dA);
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
    }
}
