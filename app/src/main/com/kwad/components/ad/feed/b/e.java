package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class e extends FrameLayout {
    private View gF;
    private ImageView gG;

    @Nullable
    private Animator gH;
    private com.kwad.sdk.widget.c gI;

    /* renamed from: com.kwad.components.ad.feed.b.e$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AnimatorListenerAdapter gJ;

        public AnonymousClass1(AnimatorListenerAdapter animatorListenerAdapter) {
            animatorListenerAdapter = animatorListenerAdapter;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            e eVar = e.this;
            eVar.gH = eVar.bQ();
            if (e.this.gH == null) {
                animatorListenerAdapter.onAnimationEnd(null);
            } else {
                e.this.gH.addListener(animatorListenerAdapter);
                e.this.gH.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.e$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View gE;

        public AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            view.setVisibility(0);
            view.setClickable(true);
            new com.kwad.sdk.widget.f(view, e.this.gI);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.e$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ View gE;

        public AnonymousClass3(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(8);
        }
    }

    public e(@NonNull Context context) {
        this(context, null);
    }

    public Animator bQ() {
        View view = this.gF;
        if (view == null || this.gG == null || view.getWidth() + this.gF.getHeight() == 0 || this.gG.getWidth() + this.gG.getHeight() == 0) {
            return null;
        }
        Animator bR = bR();
        Animator a10 = a(this.gG, 100L, 16.0f);
        Animator bS = bS();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(bR, a10, bS);
        return animatorSet;
    }

    private Animator bR() {
        Animator b10 = b(this.gF, com.kwad.sdk.c.a.a.a(getContext(), 128.0f));
        Animator b11 = b(this.gG, com.kwad.sdk.c.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(b10, b11);
        return animatorSet;
    }

    private Animator bS() {
        Animator g10 = g(this.gF);
        Animator g11 = g(this.gG);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(g10, g11);
        return animatorSet;
    }

    private Animator g(View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.3
            final /* synthetic */ View gE;

            public AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.n.m.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.gF = findViewById(R.id.ksad_feed_shake_bg);
        this.gG = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.gI = cVar;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animator b(View view, int i10) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i10 / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.2
            final /* synthetic */ View gE;

            public AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.f(view, e.this.gI);
            }
        });
        return animatorSet;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        init(context);
    }

    @MainThread
    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.gH;
        if (animator != null) {
            animator.cancel();
            this.gH = null;
        }
        this.gG.post(new bd() { // from class: com.kwad.components.ad.feed.b.e.1
            final /* synthetic */ AnimatorListenerAdapter gJ;

            public AnonymousClass1(AnimatorListenerAdapter animatorListenerAdapter2) {
                animatorListenerAdapter = animatorListenerAdapter2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                e eVar = e.this;
                eVar.gH = eVar.bQ();
                if (e.this.gH == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.gH.addListener(animatorListenerAdapter);
                    e.this.gH.start();
                }
            }
        });
    }

    private Animator a(View view, long j10, float f10) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.gG.setPivotX(view.getWidth());
        this.gG.setPivotY(view.getHeight());
        Animator a10 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        Animator a11 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        Animator a12 = com.kwad.components.core.s.n.a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a10, a11, a12);
        return animatorSet;
    }
}
