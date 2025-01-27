package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class TailFrameBarH5View extends LinearLayout {

    /* renamed from: fa */
    protected TextView f11894fa;

    /* renamed from: fb */
    protected TextView f11895fb;
    protected ValueAnimator ky;

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View$1 */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TailFrameBarH5View.this.f11895fb.setScaleY(floatValue);
            TailFrameBarH5View.this.f11895fb.setScaleX(floatValue);
        }
    }

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i10) {
        m.inflate(context, i10, this);
        this.f11894fa = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f11895fb = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void kG() {
        if (this.ky != null) {
            kH();
            this.ky.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.ky = ofFloat;
        ofFloat.setDuration(1200L);
        this.ky.setRepeatCount(-1);
        this.ky.setRepeatMode(1);
        this.ky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            public AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.f11895fb.setScaleY(floatValue);
                TailFrameBarH5View.this.f11895fb.setScaleX(floatValue);
            }
        });
        this.ky.start();
    }

    public TextView getH5OpenBtn() {
        return this.f11895fb;
    }

    public final void h(boolean z10, boolean z11) {
        f(getContext(), z10 ? z11 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal : R.layout.ksad_video_tf_bar_h5_landscape);
    }

    public final void kH() {
        ValueAnimator valueAnimator = this.ky;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.ky.cancel();
        this.ky.end();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public final void f(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        this.f11894fa.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        this.f11895fb.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        kG();
    }
}
