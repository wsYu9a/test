package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.h;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener {
    private ImageView gT;
    private com.kwad.components.ad.reward.j.a gU;
    private AdTemplate mAdTemplate;
    private ImageView uN;
    private h.a gV = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1

        /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.d$1$1 */
        final class RunnableC01511 implements Runnable {
            RunnableC01511() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.gT.setSelected(false);
                d.this.qt.oN.setAudioEnabled(false, false);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.gT == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            d.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                RunnableC01511() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.gT.setSelected(false);
                    d.this.qt.oN.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.d$1 */
    final class AnonymousClass1 implements h.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.d$1$1 */
        final class RunnableC01511 implements Runnable {
            RunnableC01511() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.gT.setSelected(false);
                d.this.qt.oN.setAudioEnabled(false, false);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.gT == null || com.kwad.components.ad.reward.kwai.b.gz()) {
                return;
            }
            d.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                RunnableC01511() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.gT.setSelected(false);
                    d.this.qt.oN.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.kwai.d$2 */
    final class AnonymousClass2 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", d.this.qt.mAdTemplate).equals(str)) {
                d.this.cc();
            }
        }
    }

    public void cc() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        this.mAdTemplate = jVar.mAdTemplate;
        this.gU = jVar.oN.jH();
        this.gT.setVisibility(com.kwad.components.ad.reward.j.q(this.mAdTemplate) ? 8 : 0);
        this.uN.setVisibility(com.kwad.components.ad.reward.j.q(this.mAdTemplate) ? 0 : 8);
        KsVideoPlayConfig ksVideoPlayConfig = this.qt.mVideoPlayConfig;
        boolean z = true;
        if (!this.gU.jC() && com.kwad.components.core.r.a.aj(getContext()).pI()) {
            this.uN.setSelected(true);
            this.qt.c(false, false);
            z = false;
        } else if (ksVideoPlayConfig != null) {
            z = ksVideoPlayConfig.isVideoSoundEnable();
            this.uN.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qt.c(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.uN.setSelected(true);
            this.qt.c(true, true);
        }
        this.gT.setSelected(z);
        this.gU.setAudioEnabled(z, false);
        this.qt.c(z, false);
        this.gU.a(this.gV);
    }

    private void ii() {
        this.gT.setOnClickListener(this);
        this.uN.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
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
        } else {
            if (view == this.uN) {
                this.qt.oN.setAudioEnabled(!r0.isSelected(), true);
                this.uN.setSelected(!r3.isSelected());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gT = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.uN = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        ii();
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
