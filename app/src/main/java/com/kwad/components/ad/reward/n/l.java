package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bt;
import com.sigmob.sdk.base.common.y;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l extends s implements View.OnClickListener {
    private ImageView AN;
    private TextView AO;
    private TextView AP;
    private TextView AQ;
    private View AR;
    private Set<ImageView> AS = new HashSet();
    private TextView AT;
    private Animator AU;
    private ImageView gG;
    private TextView mK;
    private com.kwad.components.ad.reward.g rO;

    /* renamed from: com.kwad.components.ad.reward.n.l$1 */
    public class AnonymousClass1 extends bd {

        /* renamed from: com.kwad.components.ad.reward.n.l$1$1 */
        public class C04001 extends AnimatorListenerAdapter {
            public C04001() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (l.this.AU != null) {
                    l.this.AU.start();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            l lVar = l.this;
            lVar.AU = l.a(lVar, lVar.AQ, 100L, 8.0f);
            l.this.AU.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                public C04001() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (l.this.AU != null) {
                        l.this.AU.start();
                    }
                }
            });
            l.this.AU.start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.l$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            l lVar = l.this;
            l.a(lVar, lVar.AR).start();
        }
    }

    public l(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
    }

    private void initView() {
        ViewGroup viewGroup = this.f11741uc;
        if (viewGroup == null) {
            return;
        }
        this.AQ = (TextView) viewGroup.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.AN = (ImageView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.gG = (ImageView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.AO = (TextView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.mK = (TextView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.AP = (TextView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.AR = this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.AS.add(imageView);
        this.AS.add(imageView2);
        this.AS.add(imageView3);
        this.AT = (TextView) this.f11741uc.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.f11741uc.setOnClickListener(this);
        this.AP.setOnClickListener(this);
    }

    private void kv() {
        this.AQ.postDelayed(new bd() { // from class: com.kwad.components.ad.reward.n.l.1

            /* renamed from: com.kwad.components.ad.reward.n.l$1$1 */
            public class C04001 extends AnimatorListenerAdapter {
                public C04001() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (l.this.AU != null) {
                        l.this.AU.start();
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                l lVar = l.this;
                lVar.AU = l.a(lVar, lVar.AQ, 100L, 8.0f);
                l.this.AU.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    public C04001() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.AU != null) {
                            l.this.AU.start();
                        }
                    }
                });
                l.this.AU.start();
            }
        }, 500L);
    }

    private void kw() {
        bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.ad.reward.n.l.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.AR).start();
            }
        }, y.f.f18076n);
    }

    private static Animator s(View view) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ac(boolean z10) {
        super.ac(z10);
        Context context = this.f11741uc.getContext();
        if (an.NS()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f11741uc.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.f11741uc.setLayoutParams(layoutParams);
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    public final void ku() {
        kv();
        kw();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.AP)) {
            this.rO.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.f11741uc)) {
            this.rO.a(1, view.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.AU;
        if (animator != null) {
            animator.cancel();
            this.AU = null;
        }
    }

    public static /* synthetic */ Animator a(l lVar, View view) {
        return s(view);
    }

    public static /* synthetic */ Animator a(l lVar, View view, long j10, float f10) {
        return a(view, 100L, 8.0f);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.N(adTemplate));
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.AO.setText(aVar.getTitle());
        this.mK.setText(aVar.hC());
        this.AP.setText(aVar.hz());
        String gz = aVar.gz();
        Drawable drawable = this.gG.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.gG, gz, drawable);
        String aC = com.kwad.components.ad.e.b.aC();
        if (!bm.isNullString(aC)) {
            KSImageLoader.loadImage(this.AN, aC, aVar.ht());
        }
        if (aVar.hA()) {
            this.AR.setVisibility(0);
            String hy = aVar.hy();
            if (!TextUtils.isEmpty(hy)) {
                this.AT.setText(String.format("%s已预约直播", hy));
            }
            if (aVar.hB() != null) {
                List<String> hB = aVar.hB();
                int i10 = 0;
                for (ImageView imageView : this.AS) {
                    if (i10 < hB.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, hB.get(i10), drawable);
                    }
                    i10++;
                }
                return;
            }
            return;
        }
        this.AR.setVisibility(8);
    }

    private static Animator a(View view, long j10, float f10) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f10).setDuration(j10);
        float f11 = -f10;
        long j11 = j10 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f10, f11).setDuration(j11);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f11, f10).setDuration(j11);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f10, f11).setDuration(j11);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f11, 0.0f).setDuration(j10));
        return animatorSet;
    }
}
