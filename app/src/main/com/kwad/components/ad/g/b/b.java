package com.kwad.components.ad.g.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.g.a.a {
    private Runnable dA = new Runnable() { // from class: com.kwad.components.ad.g.b.b.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.a.a.d(b.this.dy, b.this.dz.getWidth(), b.this.dz.getHeight());
            b.this.dy.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.dy, b.this.dz.getUrl(), b.this.f11530oe.mAdTemplate);
        }
    };
    private ImageView dy;
    private com.kwad.sdk.core.response.model.b dz;

    /* renamed from: com.kwad.components.ad.g.b.b$1 */
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

    /* renamed from: com.kwad.components.ad.g.b.b$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.a.a.d(b.this.dy, b.this.dz.getWidth(), b.this.dz.getHeight());
            b.this.dy.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.dy, b.this.dz.getUrl(), b.this.f11530oe.mAdTemplate);
        }
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.response.model.b bt = com.kwad.sdk.core.response.b.a.bt(com.kwad.sdk.core.response.b.e.eb(this.f11530oe.mAdTemplate));
        this.dz = bt;
        if (TextUtils.isEmpty(bt.getUrl())) {
            return;
        }
        getRootView().post(this.dA);
        this.dy.setVisibility(0);
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.b.1
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
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dy = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.dA);
    }
}
