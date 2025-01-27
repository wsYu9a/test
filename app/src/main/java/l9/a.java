package l9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public static int f27955a = 0;

    /* renamed from: b */
    public static int f27956b = 1;

    /* renamed from: c */
    public static int f27957c = 2;

    /* renamed from: d */
    public static int f27958d = 3;

    /* renamed from: e */
    public static int f27959e = 4;

    /* renamed from: l9.a$a */
    public class C0732a extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ View f27960b;

        public C0732a(View view) {
            this.f27960b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f27960b.setVisibility(8);
        }
    }

    public static void a(Context context, View view, boolean z10, int i10) {
        Animation loadAnimation;
        if (view == null || context == null) {
            return;
        }
        if ((view.getVisibility() == 0) == z10) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
            loadAnimation = i10 == f27956b ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_top_in) : i10 == f27957c ? AnimationUtils.loadAnimation(context, R.anim.fade_in) : i10 == f27958d ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_right_in) : i10 == f27959e ? AnimationUtils.loadAnimation(context, R.anim.fade_in_slide_in) : AnimationUtils.loadAnimation(context, R.anim.activity_pop_in);
        } else {
            view.setVisibility(8);
            loadAnimation = i10 == f27956b ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_top_out) : i10 == f27957c ? AnimationUtils.loadAnimation(context, R.anim.fade_out) : i10 == f27958d ? AnimationUtils.loadAnimation(context, R.anim.activity_pop_right_out) : i10 == f27959e ? AnimationUtils.loadAnimation(context, R.anim.fade_out_slide_out) : AnimationUtils.loadAnimation(context, R.anim.activity_pop_out);
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
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.08f, 1.0f, 1.08f, 1, 0.2f, 1, 0.0f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setRepeatCount(16);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    public static void d(View view) {
        e(view, false);
    }

    public static void e(View view, boolean z10) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.05f, 1.0f);
        ofFloat.setRepeatCount(10);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.05f, 1.0f);
        ofFloat2.setRepeatCount(10);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(640L);
        animatorSet.start();
        if (z10) {
            animatorSet.addListener(new C0732a(view));
        }
    }

    public static void f(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 8.0f, 0.0f, 8.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
        translateAnimation.setDuration(300L);
        view.startAnimation(translateAnimation);
    }
}
