package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public abstract class c extends KSFrameLayout {
    private Animator HQ;
    private boolean HR;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.c$1 */
    public class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: com.kwad.components.ad.splashscreen.widget.c$1$1 */
        public class C04141 extends bd {
            public C04141() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (c.this.HQ != null) {
                    c.this.HQ.start();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            c.this.mJ();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (c.this.HR) {
                return;
            }
            c.this.getInteractionView().postDelayed(new bd() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                public C04141() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.HQ != null) {
                        c.this.HQ.start();
                    }
                }
            }, c.this.getAnimationDelayTime());
        }
    }

    public c(@NonNull Context context) {
        this(context, null, 0);
    }

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        Animator animator = this.HQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    @MainThread
    public final void lF() {
        Animator animator = this.HQ;
        if (animator != null) {
            animator.cancel();
            this.HQ = null;
        }
        Animator mI = mI();
        this.HQ = mI;
        if (mI != null) {
            mI.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1

                /* renamed from: com.kwad.components.ad.splashscreen.widget.c$1$1 */
                public class C04141 extends bd {
                    public C04141() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (c.this.HQ != null) {
                            c.this.HQ.start();
                        }
                    }
                }

                public AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.mJ();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.HR) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bd() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        public C04141() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            if (c.this.HQ != null) {
                                c.this.HQ.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }
            });
            this.HQ.start();
        }
    }

    public abstract void mH();

    public abstract Animator mI();

    public abstract void mJ();

    public final void mK() {
        this.HR = true;
        Animator animator = this.HQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.HR = false;
        a(context, attributeSet, i10);
        mH();
    }
}
