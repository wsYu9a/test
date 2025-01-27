package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public final class h extends d implements View.OnClickListener {

    @Nullable
    private TextView he;

    @Nullable
    private KSCornerImageView lO;

    @Nullable
    private TextView lP;

    @Nullable
    private KsLogoView mLogoView;
    private com.kwad.components.ad.reward.j qt;
    private ViewGroup sn;
    private ViewGroup ye;

    @Nullable
    private KsPriceView yf;

    @Nullable
    private TextView yg;

    @Nullable
    private KsStyledTextButton yh;

    @Nullable
    private TextView yi;

    @Nullable
    private TextView yj;

    @Nullable
    private View yk;

    @Nullable
    private ImageView yl;

    /* renamed from: com.kwad.components.ad.reward.k.h$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h hVar = h.this;
            Animator a2 = hVar.a(hVar.sn, h.this.yh, h.this.mLogoView);
            if (a2 != null) {
                a2.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k.h$2 */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: com.kwad.components.ad.reward.k.h$2$1 */
        final class AnonymousClass1 extends AnimatorListenerAdapter {
            private int yn = 1;
            final /* synthetic */ Animator yo;

            AnonymousClass1(Animator animator) {
                a2 = animator;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.yn >= 3) {
                    return;
                }
                a2.start();
                this.yn++;
            }
        }

        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.yh == null || h.this.yh.getWidth() == 0) {
                return;
            }
            float width = h.this.yh.getWidth();
            h hVar = h.this;
            Animator a2 = h.a(hVar, hVar.yl, width);
            if (a2 != null) {
                a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.h.2.1
                    private int yn = 1;
                    final /* synthetic */ Animator yo;

                    AnonymousClass1(Animator a22) {
                        a2 = a22;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.yn >= 3) {
                            return;
                        }
                        a2.start();
                        this.yn++;
                    }
                });
                a22.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k.h$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int yq;
        final /* synthetic */ ViewGroup.MarginLayoutParams yr;
        final /* synthetic */ int ys;
        final /* synthetic */ View yt;
        final /* synthetic */ View yu;

        AnonymousClass3(int i2, ViewGroup.MarginLayoutParams marginLayoutParams, int i3, View view, View view2) {
            height = i2;
            marginLayoutParams = marginLayoutParams;
            i2 = i3;
            view3 = view;
            view = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i2 = intValue - height;
            ViewGroup.MarginLayoutParams marginLayoutParams = marginLayoutParams;
            marginLayoutParams.bottomMargin = i2 + i2;
            view3.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = intValue;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    static class a {
        private String lB;
        private String qh;
        private String qi;
        private String rE;
        private String rating;
        private String title;
        private String yv;

        @Nullable
        private String yw;
        private String yx;
        private String yy;

        private a() {
        }

        static a A(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(cb);
            a aVar = new a();
            String name = ct.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.a.a.ap(cb);
            }
            aVar.yx = com.kwad.sdk.core.response.a.a.aw(cb);
            aVar.qh = ct.getIcon();
            aVar.qi = com.kwad.sdk.core.response.a.a.an(cb);
            aVar.yv = ct.getPrice();
            aVar.lB = ct.getOriginPrice();
            aVar.yy = ct.getVolume();
            aVar.rating = ct.getRating();
            if (!ct.isCouponListEmpty() && (firstCouponList = ct.getFirstCouponList()) != null) {
                aVar.yw = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.U(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        private void U(String str) {
            this.rE = str;
        }

        public final String el() {
            return this.lB;
        }

        public final String gZ() {
            return this.rE;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gm() {
            return this.qh;
        }

        public final String gn() {
            return this.qi;
        }

        public final String jN() {
            return this.yv;
        }

        public final String jO() {
            return this.yw;
        }

        public final String jP() {
            return this.yx;
        }

        public final String jQ() {
            return this.yy;
        }
    }

    public h(com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.qt = jVar;
        this.mLogoView = ksLogoView;
        this.ye = viewGroup;
        initView();
    }

    @Nullable
    private static Animator a(View view, float f2) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f2).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }

    @Nullable
    public Animator a(View view, View view2, View view3) {
        int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(create);
        view.getContext();
        if (ai.DL() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.k.h.3
                final /* synthetic */ int yq;
                final /* synthetic */ ViewGroup.MarginLayoutParams yr;
                final /* synthetic */ int ys;
                final /* synthetic */ View yt;
                final /* synthetic */ View yu;

                AnonymousClass3(int height2, ViewGroup.MarginLayoutParams marginLayoutParams2, int i3, View view32, View view4) {
                    height = height2;
                    marginLayoutParams = marginLayoutParams2;
                    i2 = i3;
                    view3 = view32;
                    view = view4;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = intValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i2 + i2;
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(create2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    static /* synthetic */ Animator a(h hVar, View view, float f2) {
        return a(view, f2);
    }

    private void a(AdTemplate adTemplate, a aVar) {
        TextView textView;
        String rating;
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.lO, aVar.gm(), adTemplate, 4);
        TextView textView2 = this.he;
        if (textView2 != null) {
            textView2.setText(aVar.getTitle());
        }
        TextView textView3 = this.lP;
        if (textView3 != null) {
            textView3.setText(aVar.gn());
        }
        KsPriceView ksPriceView = this.yf;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.yf.getConfig().aj(dimensionPixelSize).al(dimensionPixelSize).ak(this.yf.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.yf.d(aVar.jN(), aVar.el(), true);
        }
        if (this.yg != null) {
            if (!TextUtils.isEmpty(aVar.jQ())) {
                textView = this.yg;
                rating = aVar.jQ();
            } else if (TextUtils.isEmpty(aVar.getRating())) {
                this.yg.setVisibility(8);
            } else {
                textView = this.yg;
                rating = aVar.getRating();
            }
            textView.setText(rating);
        }
        if (this.yi != null && !TextUtils.isEmpty(aVar.jO())) {
            this.yi.setText(aVar.jO());
        }
        if (this.yh != null && !TextUtils.isEmpty(aVar.jP())) {
            this.yh.setText(aVar.jP());
        }
        int i2 = TextUtils.isEmpty(aVar.jO()) ? 8 : 0;
        View view = this.yk;
        if (view != null) {
            view.setVisibility(i2);
        }
        if (this.yj == null || TextUtils.isEmpty(aVar.gZ())) {
            return;
        }
        this.yj.setText(aVar.gZ());
    }

    private void initView() {
        this.sn = (ViewGroup) this.ye.findViewById(R.id.ksad_reward_jinniu_root);
        this.lO = (KSCornerImageView) this.ye.findViewById(R.id.ksad_reward_jinniu_icon);
        this.he = (TextView) this.ye.findViewById(R.id.ksad_reward_jinniu_title);
        this.lP = (TextView) this.ye.findViewById(R.id.ksad_reward_jinniu_desc);
        this.yf = (KsPriceView) this.ye.findViewById(R.id.ksad_reward_jinniu_price);
        this.yg = (TextView) this.ye.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.yh = (KsStyledTextButton) this.ye.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.yl = (ImageView) this.ye.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.yk = this.ye.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.yi = (TextView) this.ye.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.yj = (TextView) this.ye.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.sn.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.yh;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.sn.getContext();
        if (ai.DL()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sn.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.sn.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        if (vVar == null) {
            return;
        }
        a(vVar.getAdTemplate(), a.A(vVar.getAdTemplate()));
        ViewGroup viewGroup = this.sn;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = h.this;
                    Animator a2 = hVar.a(hVar.sn, h.this.yh, h.this.mLogoView);
                    if (a2 != null) {
                        a2.start();
                    }
                }
            }, 3000L);
            this.sn.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.2

                /* renamed from: com.kwad.components.ad.reward.k.h$2$1 */
                final class AnonymousClass1 extends AnimatorListenerAdapter {
                    private int yn = 1;
                    final /* synthetic */ Animator yo;

                    AnonymousClass1(Animator a22) {
                        a2 = a22;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.yn >= 3) {
                            return;
                        }
                        a2.start();
                        this.yn++;
                    }
                }

                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.yh == null || h.this.yh.getWidth() == 0) {
                        return;
                    }
                    float width = h.this.yh.getWidth();
                    h hVar = h.this;
                    Animator a22 = h.a(hVar, hVar.yl, width);
                    if (a22 != null) {
                        a22.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.h.2.1
                            private int yn = 1;
                            final /* synthetic */ Animator yo;

                            AnonymousClass1(Animator a222) {
                                a2 = a222;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.yn >= 3) {
                                    return;
                                }
                                a2.start();
                                this.yn++;
                            }
                        });
                        a222.start();
                    }
                }
            }, 5000L);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.sn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sn)) {
            this.qt.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.yh)) {
            this.qt.a(1, view.getContext(), 1, 1);
        }
    }
}
