package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class KsRotateView extends b {
    private static int EM = 50;
    private static int EN = -12;
    private static int EO = -25;
    private static int EP = 12;
    private static int EQ = 25;
    private ImageView EL;

    @DrawableRes
    private int ER;
    private ImageView fp;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected View getInteractionView() {
        return this.fp;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
        this.ER = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.EL = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.EL, layoutParams);
        this.fp = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.c.kwai.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.fp, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void lb() {
        this.fp.setImageResource(this.ER);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final Animator lt() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EO).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", EO, 0.0f).setDuration(EM);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EP).setDuration(EM);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", EP, 0.0f).setDuration(EM);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EN).setDuration(EM);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", EN, 0.0f).setDuration(EM);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EQ).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", EQ, 0.0f).setDuration(EM), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EN).setDuration(EM), ObjectAnimator.ofFloat(interactionView, "rotation", EN, 0.0f).setDuration(EM), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, EP).setDuration(EM), ObjectAnimator.ofFloat(interactionView, "rotation", EP, 0.0f).setDuration(EM));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    protected final void lu() {
        getInteractionView().setRotation(0.0f);
    }
}
