package cn.vlion.ad.inland.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class l6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ m6 f3084a;

    public l6(m6 m6Var) {
        this.f3084a = m6Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        try {
            AnimatorSet animatorSet = this.f3084a.f3099c;
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
