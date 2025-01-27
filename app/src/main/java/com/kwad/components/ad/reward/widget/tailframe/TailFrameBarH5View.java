package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView dQ;
    protected TextView dR;
    protected ValueAnimator iW;

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View$1 */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TailFrameBarH5View.this.dR.setScaleY(floatValue);
            TailFrameBarH5View.this.dR.setScaleX(floatValue);
        }
    }

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void f(Context context, int i2) {
        k.inflate(context, i2, this);
        this.dQ = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.dR = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void kh() {
        if (this.iW != null) {
            ki();
            this.iW.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.iW = ofFloat;
        ofFloat.setDuration(1200L);
        this.iW.setRepeatCount(-1);
        this.iW.setRepeatMode(1);
        this.iW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dR.setScaleY(floatValue);
                TailFrameBarH5View.this.dR.setScaleX(floatValue);
            }
        });
        this.iW.start();
    }

    public final void bindView(@NonNull AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        this.dQ.setText(com.kwad.sdk.core.response.a.a.an(cb));
        this.dR.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        kh();
    }

    public final void e(boolean z, boolean z2) {
        f(getContext(), z ? z2 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal : R.layout.ksad_video_tf_bar_h5_landscape);
    }

    public TextView getH5OpenBtn() {
        return this.dR;
    }

    public final void ki() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.iW.cancel();
        this.iW.end();
    }
}
