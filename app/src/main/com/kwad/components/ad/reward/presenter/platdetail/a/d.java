package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.i;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView iE;
    private ImageView wU;
    private i.a iF = new i.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1

        /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.d$1$1 */
        public class C04021 extends bd {
            public C04021() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                d.this.iE.setSelected(false);
                d.this.rO.f11689qf.setAudioEnabled(false, false);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.iE == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            d.this.iE.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                public C04021() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    d.this.iE.setSelected(false);
                    d.this.rO.f11689qf.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.ad.reward.m.c wV = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.m.c
        public final void iM() {
            d.this.iK();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.d$1 */
    public class AnonymousClass1 implements i.a {

        /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.d$1$1 */
        public class C04021 extends bd {
            public C04021() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                d.this.iE.setSelected(false);
                d.this.rO.f11689qf.setAudioEnabled(false, false);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.iE == null || com.kwad.components.ad.reward.a.b.gN()) {
                return;
            }
            d.this.iE.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                public C04021() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    d.this.iE.setSelected(false);
                    d.this.rO.f11689qf.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.d$2 */
    public class AnonymousClass2 implements com.kwad.components.ad.reward.m.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.m.c
        public final void iM() {
            d.this.iK();
        }
    }

    private void cw() {
        ImageView imageView;
        int i10 = 8;
        if (hL()) {
            this.iE.setVisibility(8);
            imageView = this.wU;
        } else {
            this.iE.setVisibility(g.K(this.mAdTemplate) ? 8 : 0);
            imageView = this.wU;
            if (g.K(this.mAdTemplate)) {
                i10 = 0;
            }
        }
        imageView.setVisibility(i10);
    }

    public void iK() {
        g gVar = this.rO;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean z10 = true;
        if (!gVar.f11687qd && com.kwad.components.core.s.a.av(getContext()).sa()) {
            this.wU.setSelected(true);
            this.rO.e(false, false);
            z10 = false;
        } else if (ksVideoPlayConfig != null) {
            z10 = ksVideoPlayConfig.isVideoSoundEnable();
            this.wU.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.rO.e(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.wU.setSelected(true);
            this.rO.e(true, true);
        }
        this.iE.setSelected(z10);
        this.rO.f11689qf.setAudioEnabled(z10, false);
    }

    private void iL() {
        this.iE.setOnClickListener(this);
        this.wU.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.a(this.wV);
        this.rO.f11689qf.a(this.iF);
        cw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.iE) {
            this.rO.f11689qf.setAudioEnabled(!r0.isSelected(), true);
            this.iE.setSelected(!r3.isSelected());
        } else {
            if (view == this.wU) {
                this.rO.f11689qf.setAudioEnabled(!r0.isSelected(), true);
                this.wU.setSelected(!r3.isSelected());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.iE = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.wU = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        iL();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.iF);
        this.rO.b(this.wV);
    }
}
