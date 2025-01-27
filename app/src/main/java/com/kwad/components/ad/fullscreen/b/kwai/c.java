package com.kwad.components.ad.fullscreen.b.kwai;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;

/* loaded from: classes.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private ImageView gT;
    private com.kwad.components.ad.reward.j.a gU;
    private h.a gV = new h.a() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1

        /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.c$1$1 */
        final class RunnableC01281 implements Runnable {
            RunnableC01281() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.gT.setSelected(false);
                c.this.qt.oN.setAudioEnabled(false, false);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.gT == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            c.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
                RunnableC01281() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.this.gT.setSelected(false);
                    c.this.qt.oN.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cc();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.c$1 */
    final class AnonymousClass1 implements h.a {

        /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.c$1$1 */
        final class RunnableC01281 implements Runnable {
            RunnableC01281() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.gT.setSelected(false);
                c.this.qt.oN.setAudioEnabled(false, false);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.gT == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            c.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
                RunnableC01281() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c.this.gT.setSelected(false);
                    c.this.qt.oN.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.kwai.c$2 */
    final class AnonymousClass2 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str)) {
                c.this.cc();
            }
        }
    }

    public void cc() {
        ImageView imageView;
        this.gU = this.qt.oN.jH();
        boolean z = false;
        this.gT.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.qt.mVideoPlayConfig;
        if (!this.gU.jC() && com.kwad.components.core.r.a.aj(getContext()).pI()) {
            imageView = this.gT;
        } else {
            if (ksVideoPlayConfig != null) {
                this.gT.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.qt.c(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
                this.gU.a(this.gV);
            }
            imageView = this.gT;
            z = true;
        }
        imageView.setSelected(z);
        this.qt.c(z, z);
        this.gU.a(this.gV);
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.gT) {
            this.qt.oN.setAudioEnabled(!r0.isSelected(), true);
            this.gT.setSelected(!r3.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.gT = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        com.kwad.components.ad.reward.j.a aVar = this.gU;
        if (aVar != null) {
            aVar.b(this.gV);
        }
    }
}
