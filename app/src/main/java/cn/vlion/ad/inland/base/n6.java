package cn.vlion.ad.inland.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class n6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ o6 f3118a;

    public n6(o6 o6Var) {
        this.f3118a = o6Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        try {
            AnimatorSet animatorSet = this.f3118a.f3267c;
            if (animatorSet != null) {
                animatorSet.start();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
    }
}
