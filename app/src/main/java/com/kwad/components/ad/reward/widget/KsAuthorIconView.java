package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bx;

/* loaded from: classes2.dex */
public class KsAuthorIconView extends FrameLayout implements bx.a {
    private KSCornerImageView Bd;
    private ViewGroup Cf;
    private KSCornerImageView Cg;
    private KSCornerImageView Ch;
    private KSCornerImageView Ci;
    private TextView Cj;
    private View Ck;
    private View Cl;
    private ImageView Cm;
    private View Cn;
    private View Co;
    private View Cp;
    private View Cq;
    private final bx bO;

    /* renamed from: com.kwad.components.ad.reward.widget.KsAuthorIconView$1 */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ boolean Cr;
        final /* synthetic */ View gE;

        public AnonymousClass1(View view, boolean z10) {
            view = view;
            z10 = z10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                int i10 = (int) floatValue;
                layoutParams.width = i10;
                if (!z10) {
                    layoutParams.height = i10;
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.KsAuthorIconView$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ Animator Cs;
        final /* synthetic */ Animator Ct;
        final /* synthetic */ Animator Cu;
        final /* synthetic */ Animator Cv;

        public AnonymousClass2(Animator animator, Animator animator2, Animator animator3, Animator animator4) {
            c10 = animator;
            c11 = animator2;
            e10 = animator3;
            i10 = animator4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c10.start();
            c11.start();
            e10.start();
            i10.start();
        }
    }

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.bO = new bx(this);
        R(context);
    }

    private void R(@NonNull Context context) {
        m.inflate(context, R.layout.ksad_author_icon, this);
        this.Cf = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.Bd = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.Cg = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.Ch = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.Ci = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.Cj = (TextView) findViewById(R.id.ksad_fans_count);
        this.Cl = findViewById(R.id.ksad_fans_hot_icon);
        this.Ck = findViewById(R.id.ksad_author_btn_follow);
        this.Cm = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.Co = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.Cn = findViewById(R.id.ksad_top_layout);
        this.Cq = findViewById(R.id.ksad_author_icon_layout);
        this.Cp = findViewById(R.id.ksad_top_flag_layout);
    }

    private Animator c(View view, long j10) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(f(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static Animator e(View view, boolean z10) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f10 = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f10);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f10);
        ofFloat.addUpdateListener(f(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f10, width);
        ofFloat2.addUpdateListener(f(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static Animator i(View view, int i10) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    public final void a(e eVar) {
        i.a(eVar, this);
        this.Cm.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.Ch.getBackground());
        a(eVar, this.Cg.getBackground());
        a(eVar, this.Ci.getBackground());
        a(eVar, this.Cf.getBackground());
    }

    public final void f(AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        String cm = a.cm(eb2);
        if (!TextUtils.isEmpty(cm)) {
            KSImageLoader.loadImage(this.Bd, cm, adTemplate);
        }
        int bf2 = a.bf(eb2);
        if (a.cS(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            this.Cj.setText("直播中");
            this.Cl.setVisibility(8);
            this.Ck.setVisibility(8);
            if (bf2 == 8) {
                this.Cp.setVisibility(8);
                this.Cm.setVisibility(8);
                this.Co.setVisibility(0);
            } else {
                this.Co.setVisibility(8);
                this.Cm.setVisibility(0);
                this.Co.setVisibility(8);
            }
        } else {
            this.Cj.setText(a.cN(eb2));
        }
        this.bO.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bO = new bx(this);
        R(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.bO = new bx(this);
        R(context);
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.uB());
        }
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.bO = new bx(this);
        R(context);
    }

    @Override // com.kwad.sdk.utils.bx.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        Animator c10 = c(this.Ch, 900L);
        Animator c11 = c(this.Ci, 1000L);
        Animator e10 = e(this.Bd, false);
        Animator i10 = i(this.Cn, 500);
        if (i10 != null && c10 != null && c11 != null && e10 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(e10, c10, c11);
            animatorSet.start();
            e10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                final /* synthetic */ Animator Cs;
                final /* synthetic */ Animator Ct;
                final /* synthetic */ Animator Cu;
                final /* synthetic */ Animator Cv;

                public AnonymousClass2(Animator c102, Animator c112, Animator e102, Animator i102) {
                    c10 = c102;
                    c11 = c112;
                    e10 = e102;
                    i10 = i102;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c10.start();
                    c11.start();
                    e10.start();
                    i10.start();
                }
            });
            return;
        }
        this.bO.sendEmptyMessageDelayed(1, 500L);
    }

    private static ValueAnimator.AnimatorUpdateListener f(View view, boolean z10) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            final /* synthetic */ boolean Cr;
            final /* synthetic */ View gE;

            public AnonymousClass1(View view2, boolean z102) {
                view = view2;
                z10 = z102;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i10 = (int) floatValue;
                    layoutParams.width = i10;
                    if (!z10) {
                        layoutParams.height = i10;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }
}
