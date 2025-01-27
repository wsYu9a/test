package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class g extends s implements View.OnClickListener {
    private TextView iO;
    private com.kwad.components.ad.reward.g rO;

    /* renamed from: com.kwad.components.ad.reward.n.g$1 */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ a zZ;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            a aVar = aVar;
            if (aVar != null) {
                aVar.hQ();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a aVar = aVar;
            if (aVar != null) {
                aVar.hQ();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.g$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ Animator Ab;

        public AnonymousClass2(Animator animator) {
            r10 = animator;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            r10.start();
        }
    }

    public interface a {
        void hQ();
    }

    public g(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
    }

    private static Animator r(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_card_tips_animation_y);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(create);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(2500L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f).setDuration(500L);
        duration3.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void a(a aVar, long j10) {
        Animator r10 = r(this.f11741uc);
        if (r10 == null) {
            aVar.hQ();
        } else {
            r10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.g.1
                final /* synthetic */ a zZ;

                public AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.hQ();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.hQ();
                    }
                }
            });
            this.f11741uc.postDelayed(new bd() { // from class: com.kwad.components.ad.reward.n.g.2
                final /* synthetic */ Animator Ab;

                public AnonymousClass2(Animator r102) {
                    r10 = r102;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    r10.start();
                }
            }, 500L);
        }
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_card_tips_view, R.id.ksad_card_tips_root);
        if (this.iO == null) {
            this.iO = (TextView) this.f11741uc.findViewById(R.id.ksad_card_tips_title);
        }
        this.f11741uc.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.s, com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.f11741uc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f11741uc)) {
            com.kwad.components.ad.reward.g gVar = this.rO;
            gVar.a(1, gVar.mContext, 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        String str;
        TextView textView;
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.b.b.dk(adTemplate).title) == null || (textView = this.iO) == null) {
            return;
        }
        textView.setText(str);
    }
}
