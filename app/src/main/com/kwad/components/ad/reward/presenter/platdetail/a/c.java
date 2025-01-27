package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private AdInfo mAdInfo;
    private ImageView wO;
    private TextView wP;
    private boolean wQ = false;
    private View wR = null;
    private long wS = -1;

    /* renamed from: ia */
    private final l f11814ia = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (c.this.wS >= 0) {
                if (j11 > Math.min(Math.min(c.this.wS, com.kwad.sdk.core.response.b.a.ag(c.this.mAdInfo)), j10)) {
                    c.this.iJ();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e iL = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.e
        public final void cA() {
            c.a(c.this, true);
            c.this.iJ();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.c$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (c.this.wS >= 0) {
                if (j11 > Math.min(Math.min(c.this.wS, com.kwad.sdk.core.response.b.a.ag(c.this.mAdInfo)), j10)) {
                    c.this.iJ();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.c$2 */
    public class AnonymousClass2 implements com.kwad.components.ad.reward.e.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.e
        public final void cA() {
            c.a(c.this, true);
            c.this.iJ();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.c$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.wR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private void cw() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        this.rO.f11689qf.a(this.f11814ia);
        this.rO.qq.add(this.iL);
        long af2 = com.kwad.sdk.core.response.b.a.af(this.mAdInfo);
        this.wS = af2;
        if (af2 == 0) {
            this.wR.setVisibility(0);
        } else {
            this.wR.setVisibility(8);
        }
    }

    public void iJ() {
        if (this.wR.getVisibility() == 0) {
            return;
        }
        this.wR.setAlpha(0.0f);
        this.wR.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            public AnonymousClass3() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.wR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.wR) {
            f.a(this.rO, this.wQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wO = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.wP = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.gL())) {
            if (com.kwad.components.ad.reward.a.b.gK() == 0) {
                this.wO.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.wO.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.wR = this.wO;
        } else {
            this.wP.setText(com.kwad.components.ad.reward.a.b.gL());
            this.wR = this.wP;
        }
        this.wR.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.f11689qf.b(this.f11814ia);
        this.rO.qq.remove(this.iL);
        this.wR.setVisibility(8);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.wQ = true;
        return true;
    }
}
