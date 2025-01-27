package com.kwad.components.ad.g.b;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class i extends com.kwad.components.ad.g.a.a implements View.OnClickListener, View.OnTouchListener {
    private DetailVideoView mDetailVideoView;
    private MotionEvent ov;

    /* renamed from: com.kwad.components.ad.g.b.i$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            i.this.mDetailVideoView.setOnClickListener(i.this);
            i.this.mDetailVideoView.setOnTouchListener(i.this);
        }
    }

    /* renamed from: com.kwad.components.ad.g.b.i$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(i.this.f11530oe.mAdTemplate, 2, i.this.f11530oe.nZ.getTouchCoords());
        }
    }

    /* renamed from: com.kwad.components.ad.g.b.i$3 */
    public class AnonymousClass3 implements a.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(i.this.f11530oe.mAdTemplate, 153, i.this.f11530oe.nZ.getTouchCoords());
        }
    }

    private void eS() {
        com.kwad.components.core.e.d.a.a(new a.C0427a(this.mDetailVideoView.getContext()).au(this.f11530oe.mAdTemplate).b(this.f11530oe.mApkDownloadHelper).v(this.f11530oe.f11531of.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.g.b.i.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.f11530oe.mAdTemplate, 153, i.this.f11530oe.nZ.getTouchCoords());
            }
        }));
    }

    private void eU() {
        com.kwad.components.core.e.d.a.a(new a.C0427a(this.mDetailVideoView.getContext()).au(this.f11530oe.mAdTemplate).b(this.f11530oe.mApkDownloadHelper).v(this.f11530oe.f11531of.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.g.b.i.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.f11530oe.mAdTemplate, 2, i.this.f11530oe.nZ.getTouchCoords());
            }
        }));
    }

    private void m(View view) {
        if (view == this.mDetailVideoView) {
            eS();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        this.f11530oe.nN.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.i.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
                i.this.mDetailVideoView.setOnTouchListener(i.this);
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f11530oe.nL && view == this.mDetailVideoView) {
            eU();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            this.ov = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            com.kwad.components.ad.g.a.b bVar = this.f11530oe;
            if (bVar.nK && (motionEvent2 = this.ov) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, bVar.mAdTemplate)) {
                m(view);
                z10 = true;
            }
            this.ov = null;
        }
        return z10;
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
