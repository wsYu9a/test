package com.kwad.components.ad.reward.n;

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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class i extends d implements View.OnClickListener {
    private ViewGroup Aj;

    @Nullable
    private KsPriceView Ak;

    @Nullable
    private TextView Al;

    @Nullable
    private KsStyledTextButton Am;

    @Nullable
    private TextView An;

    @Nullable
    private TextView Ao;

    @Nullable
    private View Ap;

    @Nullable
    private ImageView Aq;

    @Nullable
    private TextView iO;

    @Nullable
    private KSCornerImageView mJ;

    @Nullable
    private TextView mK;

    @Nullable
    private KsLogoView mLogoView;
    private com.kwad.components.ad.reward.g rO;

    /* renamed from: uc */
    private ViewGroup f11739uc;

    /* renamed from: com.kwad.components.ad.reward.n.i$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = i.this;
            Animator a10 = iVar.a(iVar.f11739uc, i.this.Am, i.this.mLogoView);
            if (a10 != null) {
                a10.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.i$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: com.kwad.components.ad.reward.n.i$2$1 */
        public class AnonymousClass1 extends AnimatorListenerAdapter {
            private int As = 1;
            final /* synthetic */ Animator At;

            public AnonymousClass1(Animator animator) {
                a10 = animator;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.As >= 3) {
                    return;
                }
                a10.start();
                this.As++;
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (i.this.Am == null || i.this.Am.getWidth() == 0) {
                return;
            }
            float width = i.this.Am.getWidth();
            i iVar = i.this;
            Animator a10 = i.a(iVar, iVar.Aq, width);
            if (a10 != null) {
                a10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                    private int As = 1;
                    final /* synthetic */ Animator At;

                    public AnonymousClass1(Animator a102) {
                        a10 = a102;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.As >= 3) {
                            return;
                        }
                        a10.start();
                        this.As++;
                    }
                });
                a102.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.i$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int Av;
        final /* synthetic */ ViewGroup.MarginLayoutParams Aw;
        final /* synthetic */ int Ax;
        final /* synthetic */ View Ay;
        final /* synthetic */ View Az;

        public AnonymousClass3(int i10, ViewGroup.MarginLayoutParams marginLayoutParams, int i11, View view, View view2) {
            height = i10;
            marginLayoutParams = marginLayoutParams;
            i10 = i11;
            view3 = view;
            view = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i10 = intValue - height;
            ViewGroup.MarginLayoutParams marginLayoutParams = marginLayoutParams;
            marginLayoutParams.bottomMargin = i10 + i10;
            view3.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = intValue;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static class a {
        private String AA;

        @Nullable
        private String AB;
        private String AC;
        private String AE;
        private String mo;
        private String rating;
        private String ry;
        private String rz;
        private String title;
        private String tu;

        private a() {
        }

        private void O(String str) {
            this.tu = str;
        }

        public static a U(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
            AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(eb2);
            a aVar = new a();
            String name = cW.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.ax(eb2);
            }
            aVar.AC = com.kwad.sdk.core.response.b.a.aE(eb2);
            aVar.ry = cW.getIcon();
            aVar.rz = com.kwad.sdk.core.response.b.a.au(eb2);
            aVar.AA = cW.getPrice();
            aVar.mo = cW.getOriginPrice();
            aVar.AE = cW.getVolume();
            aVar.rating = cW.getRating();
            if (!cW.isCouponListEmpty() && (firstCouponList = cW.getFirstCouponList()) != null) {
                aVar.AB = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.O(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String dV() {
            return this.mo;
        }

        public final String gA() {
            return this.rz;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gz() {
            return this.ry;
        }

        public final String hs() {
            return this.tu;
        }

        public final String kq() {
            return this.AA;
        }

        public final String kr() {
            return this.AB;
        }

        public final String ks() {
            return this.AC;
        }

        public final String kt() {
            return this.AE;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.rO = gVar;
        this.mLogoView = ksLogoView;
        this.Aj = viewGroup;
        initView();
    }

    public static /* synthetic */ Animator a(i iVar, View view, float f10) {
        return a(view, f10);
    }

    private void initView() {
        this.f11739uc = (ViewGroup) this.Aj.findViewById(R.id.ksad_reward_jinniu_root);
        this.mJ = (KSCornerImageView) this.Aj.findViewById(R.id.ksad_reward_jinniu_icon);
        this.iO = (TextView) this.Aj.findViewById(R.id.ksad_reward_jinniu_title);
        this.mK = (TextView) this.Aj.findViewById(R.id.ksad_reward_jinniu_desc);
        this.Ak = (KsPriceView) this.Aj.findViewById(R.id.ksad_reward_jinniu_price);
        this.Al = (TextView) this.Aj.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.Am = (KsStyledTextButton) this.Aj.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.Aq = (ImageView) this.Aj.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.Ap = this.Aj.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.An = (TextView) this.Aj.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.Ao = (TextView) this.Aj.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.f11739uc.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.Am;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.f11739uc.getContext();
        if (an.NS()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f11739uc.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.f11739uc.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.f11739uc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f11739uc)) {
            this.rO.a(1, view.getContext(), TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, 2);
        } else if (view.equals(this.Am)) {
            this.rO.a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.U(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.f11739uc;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator a10 = iVar.a(iVar.f11739uc, i.this.Am, i.this.mLogoView);
                    if (a10 != null) {
                        a10.start();
                    }
                }
            }, 3000L);
            this.f11739uc.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2

                /* renamed from: com.kwad.components.ad.reward.n.i$2$1 */
                public class AnonymousClass1 extends AnimatorListenerAdapter {
                    private int As = 1;
                    final /* synthetic */ Animator At;

                    public AnonymousClass1(Animator a102) {
                        a10 = a102;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.As >= 3) {
                            return;
                        }
                        a10.start();
                        this.As++;
                    }
                }

                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.Am == null || i.this.Am.getWidth() == 0) {
                        return;
                    }
                    float width = i.this.Am.getWidth();
                    i iVar = i.this;
                    Animator a102 = i.a(iVar, iVar.Aq, width);
                    if (a102 != null) {
                        a102.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int As = 1;
                            final /* synthetic */ Animator At;

                            public AnonymousClass1(Animator a1022) {
                                a10 = a1022;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.As >= 3) {
                                    return;
                                }
                                a10.start();
                                this.As++;
                            }
                        });
                        a1022.start();
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.mJ, aVar.gz(), adTemplate, 4);
        TextView textView = this.iO;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.mK;
        if (textView2 != null) {
            textView2.setText(aVar.gA());
        }
        KsPriceView ksPriceView = this.Ak;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.Ak.getConfig().af(dimensionPixelSize).ah(dimensionPixelSize).ag(this.Ak.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.Ak.d(aVar.kq(), aVar.dV(), true);
        }
        if (this.Al != null) {
            if (!TextUtils.isEmpty(aVar.kt())) {
                this.Al.setText(aVar.kt());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.Al.setText(aVar.getRating());
            } else {
                this.Al.setVisibility(8);
            }
        }
        if (this.An != null && !TextUtils.isEmpty(aVar.kr())) {
            this.An.setText(aVar.kr());
        }
        if (this.Am != null && !TextUtils.isEmpty(aVar.ks())) {
            this.Am.setText(aVar.ks());
        }
        int i10 = TextUtils.isEmpty(aVar.kr()) ? 8 : 0;
        View view = this.Ap;
        if (view != null) {
            view.setVisibility(i10);
        }
        if (this.Ao == null || TextUtils.isEmpty(aVar.hs())) {
            return;
        }
        this.Ao.setText(aVar.hs());
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
        if (an.NS() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                final /* synthetic */ int Av;
                final /* synthetic */ ViewGroup.MarginLayoutParams Aw;
                final /* synthetic */ int Ax;
                final /* synthetic */ View Ay;
                final /* synthetic */ View Az;

                public AnonymousClass3(int height2, ViewGroup.MarginLayoutParams marginLayoutParams2, int i11, View view32, View view4) {
                    height = height2;
                    marginLayoutParams = marginLayoutParams2;
                    i10 = i11;
                    view3 = view32;
                    view = view4;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i10 = intValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i10 + i10;
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

    @Nullable
    private static Animator a(View view, float f10) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f10).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
