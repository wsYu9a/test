package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.i;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView iE;
    private i.a iF = new i.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1

        /* renamed from: com.kwad.components.ad.fullscreen.c.a.c$1$1 */
        public class C03711 extends bd {
            public C03711() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.iE.setSelected(false);
                c.this.rO.f11689qf.setAudioEnabled(false, false);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (c.this.iE == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            c.this.iE.post(new bd() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                public C03711() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.this.iE.setSelected(false);
                    c.this.rO.f11689qf.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.c$1 */
    public class AnonymousClass1 implements i.a {

        /* renamed from: com.kwad.components.ad.fullscreen.c.a.c$1$1 */
        public class C03711 extends bd {
            public C03711() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.iE.setSelected(false);
                c.this.rO.f11689qf.setAudioEnabled(false, false);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (c.this.iE == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            c.this.iE.post(new bd() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                public C03711() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.this.iE.setSelected(false);
                    c.this.rO.f11689qf.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    }

    private void cw() {
        this.iE.setVisibility(0);
        g gVar = this.rO;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        if (!gVar.f11687qd && com.kwad.components.core.s.a.av(getContext()).sa()) {
            this.iE.setSelected(false);
            this.rO.e(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.iE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.rO.e(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.iE.setSelected(true);
            this.rO.e(true, true);
        }
        this.rO.f11689qf.a(this.iF);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.iE) {
            this.rO.f11689qf.setAudioEnabled(!r0.isSelected(), true);
            this.iE.setSelected(!r3.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.iE = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.iF);
    }
}
