package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public abstract class b extends KSFrameLayout {
    private Animator EH;
    private boolean EI;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.b$1 */
    final class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: com.kwad.components.ad.splashscreen.widget.b$1$1 */
        final class RunnableC01611 implements Runnable {
            RunnableC01611() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.EH.start();
            }
        }

        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            b.this.lu();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (b.this.EI) {
                return;
            }
            b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                RunnableC01611() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.EH.start();
                }
            }, b.this.getAnimationDelayTime());
        }
    }

    public b(@NonNull Context context) {
        this(context, null, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.EI = false;
        init(context, attributeSet, i2);
        lb();
    }

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
    }

    @MainThread
    public final void kT() {
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
            this.EH = null;
        }
        Animator lt = lt();
        this.EH = lt;
        if (lt != null) {
            lt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1

                /* renamed from: com.kwad.components.ad.splashscreen.widget.b$1$1 */
                final class RunnableC01611 implements Runnable {
                    RunnableC01611() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.EH.start();
                    }
                }

                AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    b.this.lu();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (b.this.EI) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        RunnableC01611() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.EH.start();
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.EH.start();
        }
    }

    protected abstract void lb();

    protected abstract Animator lt();

    protected abstract void lu();

    public final void lv() {
        this.EI = true;
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
        }
    }
}
