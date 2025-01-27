package com.kwad.components.ad.fullscreen.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.o;
import com.kwad.components.core.s.n;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b implements o, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private com.kwad.sdk.core.f.d fv;
    private Vibrator fx;
    private ViewGroup iN;
    private TextView iO;
    private TextView iP;
    private ImageView iQ;
    private FrameLayout iR;
    private ImageView iS;
    private FrameLayout iT;
    private TextView iU;

    @Nullable
    private Animator iV;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.a.f.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (f.this.iN != null) {
                f.this.iN.setVisibility(8);
            }
            if (f.this.iT != null) {
                f.this.iT.setVisibility(8);
            }
            if (f.this.fv != null) {
                f.this.fv.bA(f.this.getContext());
            }
            if (f.this.iV != null) {
                f.this.iV.cancel();
                f.this.iV = null;
            }
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            if (f.this.iN != null) {
                f.this.iN.setVisibility(8);
            }
            if (f.this.iT != null) {
                f.this.iT.setVisibility(8);
            }
            if (f.this.fv != null) {
                f.this.fv.bA(f.this.getContext());
            }
            if (f.this.iV != null) {
                f.this.iV.cancel();
                f.this.iV = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$10 */
    public class AnonymousClass10 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: je */
        final /* synthetic */ int f11515je;

        /* renamed from: jf */
        final /* synthetic */ int f11516jf;

        public AnonymousClass10(int i10, int i11) {
            color2 = i10;
            dimensionPixelSize = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GradientDrawable gradientDrawable = (GradientDrawable) f.this.iS.getBackground();
                gradientDrawable.mutate();
                gradientDrawable.setColor(intValue);
                if (intValue == color2) {
                    gradientDrawable.setStroke(dimensionPixelSize, -1);
                }
                f.this.iS.setBackground(gradientDrawable);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$11 */
    public class AnonymousClass11 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass11() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f.this.iO.setAlpha(floatValue);
                f.this.iP.setAlpha(floatValue);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$12 */
    public class AnonymousClass12 extends com.kwad.components.ad.widget.a {
        public AnonymousClass12(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            layoutParams.height = (int) ((Float) obj).floatValue();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$13 */
    public class AnonymousClass13 extends com.kwad.components.ad.widget.a {
        public AnonymousClass13(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            layoutParams.height = (int) ((Float) obj).floatValue();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        private boolean iX = false;
        final /* synthetic */ float iY;
        final /* synthetic */ Animator iZ;

        public AnonymousClass2(float f10, Animator animator) {
            dimension2 = f10;
            clone = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.iX = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.iX) {
                return;
            }
            clone.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.iQ.setPivotX(dimension2);
            f.this.iQ.setPivotY(dimension2);
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: ja */
        final /* synthetic */ ViewGroup.LayoutParams f11517ja;

        public AnonymousClass3(ViewGroup.LayoutParams layoutParams) {
            layoutParams = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                f.this.iT.setVisibility(0);
                layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f.this.iT.setLayoutParams(layoutParams);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.fv.Hb();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.d.c.d("ShakePresenter", "onShakeEvent openGate2");
            f.this.fv.Hb();
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$6 */
    public class AnonymousClass6 extends bd {

        /* renamed from: jb */
        final /* synthetic */ AdBaseFrameLayout f11518jb;

        /* renamed from: jc */
        final /* synthetic */ int f11519jc;

        /* renamed from: jd */
        final /* synthetic */ int f11520jd;

        public AnonymousClass6(AdBaseFrameLayout adBaseFrameLayout, int i10, int i11) {
            adBaseFrameLayout = adBaseFrameLayout;
            dimensionPixelSize = i10;
            dimensionPixelSize2 = i11;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int height = adBaseFrameLayout.getHeight();
            f fVar = f.this;
            fVar.iV = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
            if (f.this.iV != null) {
                f.this.iV.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$7 */
    public class AnonymousClass7 extends AnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.iQ.setPivotX(f.this.iQ.getWidth());
            f.this.iQ.setPivotY(f.this.iQ.getHeight());
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$8 */
    public class AnonymousClass8 extends com.kwad.components.ad.widget.a {
        public AnonymousClass8(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            float floatValue = ((Float) obj).floatValue();
            if (layoutParams != null) {
                int i10 = (int) floatValue;
                layoutParams.height = i10;
                layoutParams.width = i10;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.c.a.f$9 */
    public class AnonymousClass9 extends com.kwad.components.ad.widget.a {
        public AnonymousClass9(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            float floatValue = ((Float) obj).floatValue();
            if (layoutParams != null) {
                int i10 = (int) floatValue;
                layoutParams.height = i10;
                layoutParams.width = i10;
            }
        }
    }

    private void cC() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) m.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.iN = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.iN.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) m.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.iT = frameLayout;
        this.iU = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.iT.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.iT, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.iN, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.rO.mAdTemplate, 185, (JSONObject) null);
        this.iN.post(new bd() { // from class: com.kwad.components.ad.fullscreen.c.a.f.6

            /* renamed from: jb */
            final /* synthetic */ AdBaseFrameLayout f11518jb;

            /* renamed from: jc */
            final /* synthetic */ int f11519jc;

            /* renamed from: jd */
            final /* synthetic */ int f11520jd;

            public AnonymousClass6(AdBaseFrameLayout adBaseFrameLayout2, int dimensionPixelSize5, int dimensionPixelSize22) {
                adBaseFrameLayout = adBaseFrameLayout2;
                dimensionPixelSize = dimensionPixelSize5;
                dimensionPixelSize2 = dimensionPixelSize22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.iV = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (f.this.iV != null) {
                    f.this.iV.start();
                }
            }
        });
    }

    private void initView() {
        this.iO = (TextView) this.iN.findViewById(R.id.ksad_shake_center_title);
        this.iP = (TextView) this.iN.findViewById(R.id.ksad_shake_center_sub_title);
        this.iQ = (ImageView) this.iN.findViewById(R.id.ksad_shake_center_icon);
        this.iR = (FrameLayout) this.iN.findViewById(R.id.ksad_shake_center_circle_area);
        this.iS = (ImageView) this.iN.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new com.kwad.sdk.widget.f(getContext(), this.iN, this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.b.a.b(getContext(), this.rO.mAdTemplate)) {
            this.rO.a(this);
            this.rO.b(this.mPlayEndPageListener);
            cC();
            initView();
            a(eb2);
            float dZ = com.kwad.sdk.core.response.b.b.dZ(eb2);
            com.kwad.sdk.core.f.d dVar = this.fv;
            if (dVar == null) {
                com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(dZ);
                this.fv = dVar2;
                dVar2.a(this);
            } else {
                dVar.g(dZ);
            }
            this.fv.bz(getContext());
            Context context = getContext();
            if (context != null) {
                this.fx = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.b.a.G(getContext());
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bw() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int cB() {
        return com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.iN;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.iN.getParent()).removeView(this.iN);
            }
            this.iN = null;
        }
        bt.b(getContext(), this.fx);
        this.fx = null;
        Animator animator = this.iV;
        if (animator != null) {
            animator.cancel();
            this.iV = null;
        }
        this.rO.c(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.rO.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
    }

    private void a(AdInfo adInfo) {
        String eb2 = com.kwad.sdk.core.response.b.b.eb(adInfo);
        TextView textView = this.iO;
        if (textView != null) {
            textView.setText(eb2);
        }
        TextView textView2 = this.iU;
        if (textView2 != null) {
            textView2.setText(eb2);
        }
        String a10 = a(this.rO, adInfo);
        TextView textView3 = this.iP;
        if (textView3 != null) {
            textView3.setText("或点击" + a10);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String ed2 = com.kwad.sdk.core.response.b.b.ed(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo) || cVar == null) {
            return ed2;
        }
        int oK = cVar.oK();
        AdMatrixInfo.DownloadTexts ef2 = com.kwad.sdk.core.response.b.b.ef(adInfo);
        if (oK == 8) {
            return ef2.installAppLabel;
        }
        if (oK != 12) {
            return ef2.adActionDescription;
        }
        return ef2.openAppLabel;
    }

    @Nullable
    public Animator a(float f10, float f11) {
        if (this.iN == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.iN.getResources();
        Animator a10 = n.a((View) this.iQ, (Interpolator) null, 100L, 16.0f);
        a10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.7
            public AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.iQ.setPivotX(f.this.iQ.getWidth());
                f.this.iQ.setPivotY(f.this.iQ.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iN, "translationX", f10 - (this.iN.getLeft() + (this.iN.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.iN, "translationY", f11 - (this.iN.getTop() + (this.iN.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.iR.getWidth();
        float width2 = this.iQ.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.iS) { // from class: com.kwad.components.ad.fullscreen.c.a.f.8
            public AnonymousClass8(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i10 = (int) floatValue;
                    layoutParams.height = i10;
                    layoutParams.width = i10;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.iQ) { // from class: com.kwad.components.ad.fullscreen.c.a.f.9
            public AnonymousClass9(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i10 = (int) floatValue;
                    layoutParams.height = i10;
                    layoutParams.width = i10;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        int color2 = resources.getColor(R.color.ksad_reward_main_color);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.10

            /* renamed from: je */
            final /* synthetic */ int f11515je;

            /* renamed from: jf */
            final /* synthetic */ int f11516jf;

            public AnonymousClass10(int color22, int dimensionPixelSize2) {
                color2 = color22;
                dimensionPixelSize = dimensionPixelSize2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.iS.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.iS.setBackground(gradientDrawable);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.11
            public AnonymousClass11() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.iO.setAlpha(floatValue);
                    f.this.iP.setAlpha(floatValue);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.iO.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.iO) { // from class: com.kwad.components.ad.fullscreen.c.a.f.12
            public AnonymousClass12(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.iP.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.iP) { // from class: com.kwad.components.ad.fullscreen.c.a.f.13
            public AnonymousClass13(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        Animator clone = a10.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.2
            private boolean iX = false;
            final /* synthetic */ float iY;
            final /* synthetic */ Animator iZ;

            public AnonymousClass2(float dimension22, Animator clone2) {
                dimension2 = dimension22;
                clone = clone2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.iX = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.iX) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.iQ.setPivotX(dimension2);
                f.this.iQ.setPivotY(dimension2);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.iT.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.3

            /* renamed from: ja */
            final /* synthetic */ ViewGroup.LayoutParams f11517ja;

            public AnonymousClass3(ViewGroup.LayoutParams layoutParams2) {
                layoutParams = layoutParams2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.iT.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.iT.setLayoutParams(layoutParams);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
        animatorSet3.playTogether(clone2, duration, ObjectAnimator.ofFloat(this.iU, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a10, a10.clone(), a10.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d10) {
        com.kwad.sdk.core.c.b.Fi();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z10 = activity != null && activity.equals(currentActivity);
        if (!com.kwad.components.core.e.c.b.of() && z10) {
            if (this.rO != null) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d10);
                this.rO.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 1, 0L, false, bVar);
            }
            bt.a(new bd() { // from class: com.kwad.components.ad.fullscreen.c.a.f.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("ShakePresenter", "onShakeEvent openGate2");
                    f.this.fv.Hb();
                }
            }, null, 500L);
            bt.a(getContext(), this.fx);
            return;
        }
        bt.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.f.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                f.this.fv.Hb();
            }
        }, null, 500L);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.rO.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
    }
}
