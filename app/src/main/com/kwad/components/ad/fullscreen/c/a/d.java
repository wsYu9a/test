package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView iI;
    private TextView iJ;
    private View iK = null;
    private com.kwad.components.ad.reward.e.e iL = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.e
        public final void cA() {
            d.this.cz();
        }
    };

    /* renamed from: ia */
    private l f11514ia = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.g(j11);
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.d$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.reward.e.e {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.e
        public final void cA() {
            d.this.cz();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.d$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.g(j11);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.d$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.iK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private void cw() {
        this.rO.f11689qf.a(this.f11514ia);
        this.rO.qq.add(this.iL);
    }

    public void cz() {
        if (this.iK.getVisibility() == 0) {
            return;
        }
        this.iK.setAlpha(0.0f);
        this.iK.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            public AnonymousClass3() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.iK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.iK.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    public final void g(long j10) {
        if (j10 >= com.kwad.sdk.core.response.b.a.al(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
            cz();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.iK) {
            com.kwad.components.ad.reward.presenter.f.a(this.rO, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.iI = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.iJ = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.cj())) {
            this.iJ.setText(com.kwad.components.ad.fullscreen.a.b.cj());
            this.iI.setVisibility(8);
            this.iK = this.iJ;
        } else {
            if (com.kwad.components.ad.fullscreen.a.b.ci() == 0) {
                this.iI.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.iI.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.iJ.setVisibility(8);
            this.iK = this.iI;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.qq.remove(this.iL);
        this.rO.f11689qf.b(this.f11514ia);
    }
}
