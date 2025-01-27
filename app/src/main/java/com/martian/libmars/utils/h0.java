package com.martian.libmars.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class h0 {

    /* renamed from: a */
    public static int f10144a = 0;

    /* renamed from: b */
    public static int f10145b = 1;

    /* renamed from: c */
    public static int f10146c = 2;

    /* renamed from: d */
    public static int f10147d = 3;

    /* renamed from: e */
    public static int f10148e = 4;

    public static void a(Context context, final View view, boolean show, int animType) {
        Animation loadAnimation;
        if (view == null) {
            return;
        }
        if ((view.getVisibility() == 0) == show) {
            return;
        }
        if (show) {
            view.setVisibility(0);
            loadAnimation = animType == f10145b ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_top_in) : animType == f10146c ? AnimationUtils.loadAnimation(context, R.anim.fade_in) : animType == f10147d ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_right_in) : animType == f10148e ? AnimationUtils.loadAnimation(context, R.anim.fade_in_slide_in) : AnimationUtils.loadAnimation(context, R.anim.activity_pop_in);
        } else {
            view.setVisibility(8);
            loadAnimation = animType == f10145b ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_top_out) : animType == f10146c ? AnimationUtils.loadAnimation(context, R.anim.fade_out) : animType == f10147d ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_right_out) : animType == f10148e ? AnimationUtils.loadAnimation(context, R.anim.fade_out_slide_out) : AnimationUtils.loadAnimation(context, R.anim.activity_pop_out);
        }
        view.startAnimation(loadAnimation);
    }

    public static ObjectAnimator b(View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 359.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(8000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        return ofFloat;
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.08f, 1.0f, 1.08f, 1, 0.2f, 1, 0.0f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
        view.postDelayed(new Runnable() { // from class: com.martian.libmars.utils.g0
            @Override // java.lang.Runnable
            public final void run() {
                scaleAnimation.cancel();
            }
        }, 8000L);
    }

    public static void d(View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.05f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.05f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(640L);
        animatorSet.start();
        view.postDelayed(new Runnable() { // from class: com.martian.libmars.utils.f0
            @Override // java.lang.Runnable
            public final void run() {
                animatorSet.cancel();
            }
        }, 6400L);
    }

    public static void e(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        translateAnimation.setDuration(300L);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(2);
        view.startAnimation(translateAnimation);
    }
}
