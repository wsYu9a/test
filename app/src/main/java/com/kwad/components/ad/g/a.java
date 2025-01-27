package com.kwad.components.ad.g;

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
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class a {
    private View FY;
    private Runnable FZ;
    private boolean Ga = false;

    @Nullable
    private Animator hl;
    private View xF;
    private Button xG;
    private Button xH;

    /* renamed from: com.kwad.components.ad.g.a$1 */
    final class AnonymousClass1 extends com.kwad.components.ad.widget.tailframe.appbar.b {

        /* renamed from: com.kwad.components.ad.g.a$1$1 */
        final class RunnableC01301 implements Runnable {
            final /* synthetic */ Animator Gc;

            RunnableC01301(Animator animator) {
                animator = animator;
            }

            @Override // java.lang.Runnable
            public final void run() {
                animator.start();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (a.this.Ga) {
                return;
            }
            if (a.this.FZ == null) {
                a.this.FZ = new Runnable() { // from class: com.kwad.components.ad.g.a.1.1
                    final /* synthetic */ Animator Gc;

                    RunnableC01301(Animator animator2) {
                        animator = animator2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        animator.start();
                    }
                };
            }
            bi.a(a.this.FZ, null, 1600L);
        }
    }

    /* renamed from: com.kwad.components.ad.g.a$2 */
    static class AnonymousClass2 extends com.kwad.components.ad.widget.tailframe.appbar.b {
        final /* synthetic */ View Ge;

        AnonymousClass2(View view) {
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

    /* renamed from: com.kwad.components.ad.g.a$3 */
    static class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float Gf;
        final /* synthetic */ float Gg;
        final /* synthetic */ float Gh;
        final /* synthetic */ View fn;

        AnonymousClass3(float f2, float f3, float f4, View view) {
            f4 = f2;
            f3 = f3;
            dimension = f4;
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f2 = f4 * floatValue;
            float f3 = f3;
            if (f3 != 0.0f) {
                float f4 = (floatValue / f3) * dimension;
                View view = view;
                if (view instanceof TextView) {
                    ((TextView) view).setTextSize(0, f4);
                }
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) floatValue;
                layoutParams.width = (int) f2;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public a(View view) {
        this.FY = view;
        initView();
    }

    private static Animator a(View view, float f2, float f3, long j2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
        ofFloat.setDuration(j2);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.g.a.3
            final /* synthetic */ float Gf;
            final /* synthetic */ float Gg;
            final /* synthetic */ float Gh;
            final /* synthetic */ View fn;

            AnonymousClass3(float f22, float f32, float f4, View view2) {
                f4 = f22;
                f3 = f32;
                dimension = f4;
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f22 = f4 * floatValue;
                float f32 = f3;
                if (f32 != 0.0f) {
                    float f4 = (floatValue / f32) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f4);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f22;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    private static Animator a(View view, View view2, int i2, int i3, long j2, long j3) {
        Animator b2 = b(view, 200L);
        float f2 = i2;
        float f3 = i3;
        Animator a2 = a(view2, f2, f3, 200L);
        a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.2
            final /* synthetic */ View Ge;

            AnonymousClass2(View view3) {
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
        Animator b3 = b(view2, 200L);
        Animator a3 = a(view3, f2, f3, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(b2, a2, ofFloat, b3, a3);
        return animatorSet;
    }

    private static Animator b(View view, long j2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j2);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.xG = (Button) this.FY.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.xH = (Button) this.FY.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xF = this.FY.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void jI() {
        lC();
    }

    public final void lB() {
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.xF.getHeight();
        int width = this.xF.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.hl == null) {
            Animator a2 = a(this.xH, this.xG, width, height, 1600L, 200L);
            this.hl = a2;
            a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.1

                /* renamed from: com.kwad.components.ad.g.a$1$1 */
                final class RunnableC01301 implements Runnable {
                    final /* synthetic */ Animator Gc;

                    RunnableC01301(Animator animator2) {
                        animator = animator2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        animator.start();
                    }
                }

                AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    if (a.this.Ga) {
                        return;
                    }
                    if (a.this.FZ == null) {
                        a.this.FZ = new Runnable() { // from class: com.kwad.components.ad.g.a.1.1
                            final /* synthetic */ Animator Gc;

                            RunnableC01301(Animator animator22) {
                                animator = animator22;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bi.a(a.this.FZ, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hl.isStarted());
        if (!this.hl.isStarted()) {
            com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.hl.start();
        }
        this.Ga = false;
    }

    public final void lC() {
        Animator animator = this.hl;
        if (animator != null) {
            animator.cancel();
            this.hl.removeAllListeners();
            this.Ga = true;
        }
        Runnable runnable = this.FZ;
        if (runnable != null) {
            bi.b(runnable);
            this.FZ = null;
        }
    }

    public final void lD() {
        this.Ga = true;
    }
}
