package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends d implements View.OnClickListener {
    private TextView iO;

    /* renamed from: if */
    private final ViewGroup f2if;
    private TextView mK;
    private int[] sl;
    private View sm;
    private ImageView sn;
    private TextView so;
    private Button sp;

    @Nullable
    private b sq;

    /* renamed from: com.kwad.components.ad.reward.b.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ r sr;
        final /* synthetic */ long ss;

        /* renamed from: com.kwad.components.ad.reward.b.a$1$1 */
        public class C03921 extends AnimatorListenerAdapter {
            final /* synthetic */ Animator su;

            /* renamed from: com.kwad.components.ad.reward.b.a$1$1$1 */
            public class RunnableC03931 implements Runnable {
                public RunnableC03931() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.hb();
                }
            }

            public C03921(Animator animator) {
                a10 = animator;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a10.removeListener(this);
                com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.sr.getAdTemplate(), 169, (JSONObject) null);
                a aVar = a.this;
                a.a(aVar, aVar.sn, AnonymousClass1.this.ss).start();
                bt.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                    public RunnableC03931() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.hb();
                    }
                }, null, AnonymousClass1.this.ss);
            }
        }

        public AnonymousClass1(r rVar, long j10) {
            this.sr = rVar;
            this.ss = j10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a aVar = a.this;
            Animator a10 = a.a(aVar, aVar.sm);
            a10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                final /* synthetic */ Animator su;

                /* renamed from: com.kwad.components.ad.reward.b.a$1$1$1 */
                public class RunnableC03931 implements Runnable {
                    public RunnableC03931() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.hb();
                    }
                }

                public C03921(Animator a102) {
                    a10 = a102;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a10.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.sr.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.sn, AnonymousClass1.this.ss).start();
                    bt.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        public RunnableC03931() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hb();
                        }
                    }, null, AnonymousClass1.this.ss);
                }
            });
            a102.start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ Animator sx;

        public AnonymousClass2(Animator animator) {
            o10 = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            o10.removeListener(this);
            if (a.this.sq != null) {
                a.this.sq.hf();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$a */
    public static class C0394a {
        private CharSequence sA;
        private CharSequence sy;
        private CharSequence sz;
        private CharSequence title;

        private C0394a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.sy = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.sz = "";
            } else {
                this.sz = String.format("满%s可用", couponInfo.displayBase);
            }
            this.sA = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0394a L(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(e.eb(adTemplate));
            if (cW == null || (list = cW.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(cW.couponList.get(0));
        }

        @Nullable
        private static C0394a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0394a(couponInfo);
        }

        public final CharSequence N(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.sy));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence hc() {
            return this.sz;
        }

        public final CharSequence hd() {
            return this.sA;
        }
    }

    public interface b {
        void he();

        void hf();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.sl = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.f2if = viewGroup2;
        d(viewGroup2);
    }

    public static /* synthetic */ Animator a(a aVar, View view) {
        return n(view);
    }

    public void hb() {
        Animator o10 = o(this.sm);
        o10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            final /* synthetic */ Animator sx;

            public AnonymousClass2(Animator o102) {
                o10 = o102;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                o10.removeListener(this);
                if (a.this.sq != null) {
                    a.this.sq.hf();
                }
            }
        });
        o102.start();
    }

    private static Animator n(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator o(View view) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        int[] G;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.sl;
        if (iArr == null || iArr.length < 2 || (G = com.kwad.sdk.c.a.a.G(view)) == null) {
            objectAnimator = null;
            objectAnimator2 = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator = ObjectAnimator.ofFloat(view, "translationX", this.sl[0] - G[0]);
            objectAnimator2 = ObjectAnimator.ofFloat(view, "translationY", this.sl[1] - G[1]);
            objectAnimator.setInterpolator(create2);
            objectAnimator2.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator, objectAnimator2);
        } else {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        }
        return animatorSet2;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.f2if;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.sp) || (bVar = this.sq) == null) {
            return;
        }
        bVar.he();
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j10) {
        return a(imageView, j10);
    }

    private void d(ViewGroup viewGroup) {
        this.sm = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.sn = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.iO = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.so = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.mK = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.sp = button;
        button.setOnClickListener(this);
    }

    public final void a(@Nullable b bVar) {
        this.sq = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0394a.L(rVar.getAdTemplate()));
        this.f2if.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.gT()));
    }

    private void a(C0394a c0394a) {
        if (c0394a == null) {
            return;
        }
        TextView textView = this.iO;
        if (textView != null) {
            textView.setText(c0394a.getTitle());
        }
        TextView textView2 = this.so;
        if (textView2 != null) {
            textView2.setText(c0394a.N(this.f2if.getContext()));
        }
        TextView textView3 = this.mK;
        if (textView3 != null) {
            textView3.setText(c0394a.hc());
        }
        Button button = this.sp;
        if (button != null) {
            button.setText(c0394a.hd());
        }
    }

    private static Animator a(ImageView imageView, long j10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j10);
        return ofFloat;
    }
}
