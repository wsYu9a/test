package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class HandSlideView extends KSFrameLayout {
    private View BE;
    private AnimatorSet BF;
    private float BG;
    private float BH;
    private float BI;
    private long BJ;
    private long BK;
    private int BL;
    private int BM;
    private ImageView gy;
    private boolean started;

    /* renamed from: com.kwad.components.ad.reward.widget.HandSlideView$1 */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ a BN;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (HandSlideView.this.BF == null) {
                return;
            }
            HandSlideView.b(HandSlideView.this);
            if (HandSlideView.this.BM < HandSlideView.this.BL) {
                HandSlideView.this.BF.start();
                return;
            }
            HandSlideView.this.BF.removeListener(this);
            a aVar = aVar;
            if (aVar != null) {
                aVar.onHandSlideLoopEnd();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.HandSlideView$2 */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View gE;

        public AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) floatValue;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public interface a {
        void onHandSlideLoopEnd();
    }

    public HandSlideView(@NonNull Context context) {
        super(context);
        this.BJ = 600L;
        this.BK = 500L;
        this.BL = 3;
        this.BM = 0;
        this.started = false;
    }

    public static /* synthetic */ int b(HandSlideView handSlideView) {
        int i10 = handSlideView.BM;
        handSlideView.BM = i10 + 1;
        return i10;
    }

    private static ValueAnimator.AnimatorUpdateListener t(View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            final /* synthetic */ View gE;

            public AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.BF;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.BF.cancel();
            this.BF = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        View.inflate(getContext(), R.layout.ksad_hand_slide, this);
        this.gy = (ImageView) findViewById(R.id.ksad_hand_slide_hand);
        this.BE = findViewById(R.id.ksad_hand_slide_tail);
        this.BG = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_up);
        this.BH = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_start);
        this.BI = getContext().getResources().getDimension(R.dimen.ksad_hand_slide_tail_height_end);
    }

    public final boolean isStarted() {
        return this.started;
    }

    private AnimatorSet b(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -this.BG);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 30.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat3.setDuration(10L);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(this.BH, this.BI);
        ofFloat4.addUpdateListener(t(view2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.BJ);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f));
        animatorSet2.setDuration(this.BK);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    public final void a(@Nullable a aVar) {
        this.started = true;
        AnimatorSet b10 = b(this.gy, this.BE);
        this.BF = b10;
        b10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            final /* synthetic */ a BN;

            public AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.BF == null) {
                    return;
                }
                HandSlideView.b(HandSlideView.this);
                if (HandSlideView.this.BM < HandSlideView.this.BL) {
                    HandSlideView.this.BF.start();
                    return;
                }
                HandSlideView.this.BF.removeListener(this);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onHandSlideLoopEnd();
                }
            }
        });
        this.BF.start();
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BJ = 600L;
        this.BK = 500L;
        this.BL = 3;
        this.BM = 0;
        this.started = false;
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.BJ = 600L;
        this.BK = 500L;
        this.BL = 3;
        this.BM = 0;
        this.started = false;
    }
}
