package cn.vlion.ad.inland.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class j6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ k6 f2998a;

    public j6(k6 k6Var) {
        this.f2998a = k6Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        try {
            AnimatorSet animatorSet = this.f2998a.f3050c;
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
