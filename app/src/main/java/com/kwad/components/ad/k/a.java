package com.kwad.components.ad.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class a {
    private View Jh;
    private Runnable Ji;
    private boolean Jj = false;

    @Nullable
    private Animator iV;
    private View zD;
    private Button zE;
    private Button zF;

    /* renamed from: com.kwad.components.ad.k.a$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.widget.tailframe.appbar.b {

        /* renamed from: com.kwad.components.ad.k.a$1$1 */
        public class RunnableC03871 implements Runnable {
            final /* synthetic */ Animator Jl;

            public RunnableC03871(Animator animator) {
                animator = animator;
            }

            @Override // java.lang.Runnable
            public final void run() {
                animator.start();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (a.this.Jj) {
                return;
            }
            if (a.this.Ji == null) {
                a.this.Ji = new Runnable() { // from class: com.kwad.components.ad.k.a.1.1
                    final /* synthetic */ Animator Jl;

                    public RunnableC03871(Animator animator2) {
                        animator = animator2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        animator.start();
                    }
                };
            }
            bt.a(a.this.Ji, null, 1600L);
        }
    }

    /* renamed from: com.kwad.components.ad.k.a$2 */
    public class AnonymousClass2 extends com.kwad.components.ad.widget.tailframe.appbar.b {
        final /* synthetic */ View Jn;

        public AnonymousClass2(View view) {
            view = view;
        }

        @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setAlpha(1.0f);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = 0;
                layoutParams.height = 0;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.k.a$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float Jo;
        final /* synthetic */ float Jp;
        final /* synthetic */ float Jq;
        final /* synthetic */ View gE;

        public AnonymousClass3(float f10, float f11, float f12, View view) {
            f12 = f10;
            f11 = f11;
            dimension = f12;
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f10 = f12 * floatValue;
            float f11 = f11;
            if (f11 != 0.0f) {
                float f12 = (floatValue / f11) * dimension;
                View view = view;
                if (view instanceof TextView) {
                    ((TextView) view).setTextSize(0, f12);
                }
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) floatValue;
                layoutParams.width = (int) f10;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public a(View view) {
        this.Jh = view;
        initView();
    }

    private static Animator d(View view, long j10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.zE = (Button) this.Jh.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.zF = (Button) this.Jh.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.zD = this.Jh.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void io() {
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.zD.getHeight();
        int width = this.zD.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.iV == null) {
            Animator a10 = a(this.zF, this.zE, width, height, 1600L, 200L);
            this.iV = a10;
            a10.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.k.a.1

                /* renamed from: com.kwad.components.ad.k.a$1$1 */
                public class RunnableC03871 implements Runnable {
                    final /* synthetic */ Animator Jl;

                    public RunnableC03871(Animator animator2) {
                        animator = animator2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        animator.start();
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    if (a.this.Jj) {
                        return;
                    }
                    if (a.this.Ji == null) {
                        a.this.Ji = new Runnable() { // from class: com.kwad.components.ad.k.a.1.1
                            final /* synthetic */ Animator Jl;

                            public RunnableC03871(Animator animator22) {
                                animator = animator22;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bt.a(a.this.Ji, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.iV.isStarted());
        if (!this.iV.isStarted()) {
            com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.iV.start();
        }
        this.Jj = false;
    }

    public final void kk() {
        mR();
    }

    public final void mR() {
        Animator animator = this.iV;
        if (animator != null) {
            animator.cancel();
            this.iV.removeAllListeners();
            this.Jj = true;
        }
        Runnable runnable = this.Ji;
        if (runnable != null) {
            bt.c(runnable);
            this.Ji = null;
        }
    }

    public final void mS() {
        this.Jj = true;
    }

    private static Animator a(View view, View view2, int i10, int i11, long j10, long j11) {
        Animator d10 = d(view, 200L);
        float f10 = i10;
        float f11 = i11;
        Animator a10 = a(view2, f10, f11, 200L);
        a10.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.k.a.2
            final /* synthetic */ View Jn;

            public AnonymousClass2(View view3) {
                view = view3;
            }

            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator d11 = d(view2, 200L);
        Animator a11 = a(view3, f10, f11, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d10, a10, ofFloat, d11, a11);
        return animatorSet;
    }

    private static Animator a(View view, float f10, float f11, long j10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f11);
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.k.a.3
            final /* synthetic */ float Jo;
            final /* synthetic */ float Jp;
            final /* synthetic */ float Jq;
            final /* synthetic */ View gE;

            public AnonymousClass3(float f102, float f112, float f12, View view2) {
                f12 = f102;
                f11 = f112;
                dimension = f12;
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f102 = f12 * floatValue;
                float f112 = f11;
                if (f112 != 0.0f) {
                    float f12 = (floatValue / f112) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f12);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f102;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
