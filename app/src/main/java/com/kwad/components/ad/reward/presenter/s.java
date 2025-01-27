package com.kwad.components.ad.reward.presenter;

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
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bi;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s extends a implements View.OnClickListener, com.kwad.components.ad.reward.d.m, com.kwad.sdk.core.f.b {
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private ViewGroup hd;
    private TextView he;
    private TextView hf;
    private ImageView hg;
    private FrameLayout hh;
    private ImageView hi;
    private FrameLayout hj;
    private TextView hk;

    @Nullable
    private Animator hl;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.s.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (s.this.hd != null) {
                s.this.hd.setVisibility(8);
            }
            if (s.this.hj != null) {
                s.this.hj.setVisibility(8);
            }
            if (s.this.ef != null) {
                s.this.ef.aY(s.this.getContext());
            }
            if (s.this.hl != null) {
                s.this.hl.cancel();
                s.this.hl = null;
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.s$1 */
    final class AnonymousClass1 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (s.this.hd != null) {
                s.this.hd.setVisibility(8);
            }
            if (s.this.hj != null) {
                s.this.hj.setVisibility(8);
            }
            if (s.this.ef != null) {
                s.this.ef.aY(s.this.getContext());
            }
            if (s.this.hl != null) {
                s.this.hl.cancel();
                s.this.hl = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$10 */
    final class AnonymousClass10 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int hu;
        final /* synthetic */ int hv;

        AnonymousClass10(int i2, int i3) {
            color2 = i2;
            dimensionPixelSize = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GradientDrawable gradientDrawable = (GradientDrawable) s.this.hi.getBackground();
                gradientDrawable.mutate();
                gradientDrawable.setColor(intValue);
                if (intValue == color2) {
                    gradientDrawable.setStroke(dimensionPixelSize, -1);
                }
                s.this.hi.setBackground(gradientDrawable);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$11 */
    final class AnonymousClass11 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass11() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                s.this.he.setAlpha(floatValue);
                s.this.hf.setAlpha(floatValue);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$12 */
    final class AnonymousClass12 extends com.kwad.components.ad.widget.a {
        AnonymousClass12(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            layoutParams.height = (int) ((Float) obj).floatValue();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$13 */
    final class AnonymousClass13 extends com.kwad.components.ad.widget.a {
        AnonymousClass13(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            layoutParams.height = (int) ((Float) obj).floatValue();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        private boolean hn = false;
        final /* synthetic */ float ho;
        final /* synthetic */ Animator hp;

        AnonymousClass2(float f2, Animator animator) {
            dimension2 = f2;
            clone = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.hn = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.hn) {
                return;
            }
            clone.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            s.this.hg.setPivotX(dimension2);
            s.this.hg.setPivotY(dimension2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.LayoutParams hq;

        AnonymousClass3(ViewGroup.LayoutParams layoutParams) {
            layoutParams = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                s.this.hj.setVisibility(0);
                layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                s.this.hj.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            s.this.ef.xD();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$5 */
    final class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("RewardShakePresenter", "onShakeEvent openGate2");
            s.this.ef.xD();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$6 */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ AdBaseFrameLayout hr;
        final /* synthetic */ int hs;
        final /* synthetic */ int ht;

        AnonymousClass6(AdBaseFrameLayout adBaseFrameLayout, int i2, int i3) {
            adBaseFrameLayout = adBaseFrameLayout;
            dimensionPixelSize = i2;
            dimensionPixelSize2 = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int height = adBaseFrameLayout.getHeight();
            s sVar = s.this;
            sVar.hl = sVar.a(dimensionPixelSize, height - dimensionPixelSize2);
            if (s.this.hl != null) {
                s.this.hl.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$7 */
    final class AnonymousClass7 extends AnimatorListenerAdapter {
        AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            s.this.hg.setPivotX(s.this.hg.getWidth());
            s.this.hg.setPivotY(s.this.hg.getHeight());
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$8 */
    final class AnonymousClass8 extends com.kwad.components.ad.widget.a {
        AnonymousClass8(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            float floatValue = ((Float) obj).floatValue();
            if (layoutParams != null) {
                int i2 = (int) floatValue;
                layoutParams.height = i2;
                layoutParams.width = i2;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$9 */
    final class AnonymousClass9 extends com.kwad.components.ad.widget.a {
        AnonymousClass9(View view) {
            super(view);
        }

        @Override // com.kwad.components.ad.widget.a
        public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
            float floatValue = ((Float) obj).floatValue();
            if (layoutParams != null) {
                int i2 = (int) floatValue;
                layoutParams.height = i2;
                layoutParams.width = i2;
            }
        }
    }

    @Nullable
    public Animator a(float f2, float f3) {
        if (this.hd == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.hd.getResources();
        Animator a2 = com.kwad.components.core.r.m.a((View) this.hg, (Interpolator) null, 100L, 16.0f);
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.s.7
            AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                s.this.hg.setPivotX(s.this.hg.getWidth());
                s.this.hg.setPivotY(s.this.hg.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hd, "translationX", f2 - (this.hd.getLeft() + (this.hd.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hd, "translationY", f3 - (this.hd.getTop() + (this.hd.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.hh.getWidth();
        float width2 = this.hg.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hi) { // from class: com.kwad.components.ad.reward.presenter.s.8
            AnonymousClass8(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i2 = (int) floatValue;
                    layoutParams.height = i2;
                    layoutParams.width = i2;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hg) { // from class: com.kwad.components.ad.reward.presenter.s.9
            AnonymousClass9(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i2 = (int) floatValue;
                    layoutParams.height = i2;
                    layoutParams.width = i2;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        int color2 = resources.getColor(R.color.ksad_reward_main_color);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.10
            final /* synthetic */ int hu;
            final /* synthetic */ int hv;

            AnonymousClass10(int color22, int dimensionPixelSize2) {
                color2 = color22;
                dimensionPixelSize = dimensionPixelSize2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) s.this.hi.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    s.this.hi.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.11
            AnonymousClass11() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.he.setAlpha(floatValue);
                    s.this.hf.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.he.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.he) { // from class: com.kwad.components.ad.reward.presenter.s.12
            AnonymousClass12(View view) {
                super(view);
            }

            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hf.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hf) { // from class: com.kwad.components.ad.reward.presenter.s.13
            AnonymousClass13(View view) {
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
        Animator clone = a2.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.s.2
            private boolean hn = false;
            final /* synthetic */ float ho;
            final /* synthetic */ Animator hp;

            AnonymousClass2(float dimension22, Animator clone2) {
                dimension2 = dimension22;
                clone = clone2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hn = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.hn) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                s.this.hg.setPivotX(dimension2);
                s.this.hg.setPivotY(dimension2);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.hj.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
            final /* synthetic */ ViewGroup.LayoutParams hq;

            AnonymousClass3(ViewGroup.LayoutParams layoutParams2) {
                layoutParams = layoutParams2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    s.this.hj.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.hj.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone2, duration, ObjectAnimator.ofFloat(this.hk, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a2, a2.clone(), a2.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    private static String a(com.kwad.components.ad.reward.j jVar, AdInfo adInfo) {
        String dq = com.kwad.sdk.core.response.a.b.dq(adInfo);
        com.kwad.components.core.d.b.c cVar = jVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.a.a.ax(adInfo) || cVar == null) {
            return dq;
        }
        int nb = cVar.nb();
        AdMatrixInfo.DownloadTexts ds = com.kwad.sdk.core.response.a.b.ds(adInfo);
        return nb != 8 ? nb != 12 ? ds.adActionDescription : ds.openAppLabel : ds.installAppLabel;
    }

    private void a(AdInfo adInfo) {
        String m59do = com.kwad.sdk.core.response.a.b.m59do(adInfo);
        TextView textView = this.he;
        if (textView != null) {
            textView.setText(m59do);
        }
        TextView textView2 = this.hk;
        if (textView2 != null) {
            textView2.setText(m59do);
        }
        String a2 = a(this.qt, adInfo);
        TextView textView3 = this.hf;
        if (textView3 != null) {
            textView3.setText("或点击" + a2);
        }
    }

    private void ci() {
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.j.k.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.hd = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hd.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        int dimensionPixelSize2 = this.qt.mScreenOrientation == 1 ? resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom) + com.kwad.sdk.c.kwai.a.a(getContext(), 50.0f) : resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = this.qt.mScreenOrientation == 1 ? resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.kwai.a.a(getContext(), 50.0f) : resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.j.k.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.hj = frameLayout;
        this.hk = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.hj.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hj, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.hd, layoutParams2);
        com.kwad.sdk.core.report.a.b(this.qt.mAdTemplate, 185, (JSONObject) null);
        this.hd.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.6
            final /* synthetic */ AdBaseFrameLayout hr;
            final /* synthetic */ int hs;
            final /* synthetic */ int ht;

            AnonymousClass6(AdBaseFrameLayout adBaseFrameLayout2, int dimensionPixelSize5, int dimensionPixelSize22) {
                adBaseFrameLayout = adBaseFrameLayout2;
                dimensionPixelSize = dimensionPixelSize5;
                dimensionPixelSize2 = dimensionPixelSize22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                s sVar = s.this;
                sVar.hl = sVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (s.this.hl != null) {
                    s.this.hl.start();
                }
            }
        });
    }

    private void initView() {
        this.he = (TextView) this.hd.findViewById(R.id.ksad_shake_center_title);
        this.hf = (TextView) this.hd.findViewById(R.id.ksad_shake_center_sub_title);
        this.hg = (ImageView) this.hd.findViewById(R.id.ksad_shake_center_icon);
        this.hh = (FrameLayout) this.hd.findViewById(R.id.ksad_shake_center_circle_area);
        this.hi = (ImageView) this.hd.findViewById(R.id.ksad_shake_center_circle_area_bg);
        this.he.setOnClickListener(this);
        this.hf.setOnClickListener(this);
        this.hh.setOnClickListener(this);
        this.hk.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d2) {
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.d.a.b.mF() || !z) {
            bi.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    s.this.ef.xD();
                }
            }, null, 500L);
            return;
        }
        com.kwad.components.ad.reward.j jVar = this.qt;
        if (jVar != null && !jVar.fW()) {
            com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
            iVar.i(d2);
            this.qt.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 1, 0L, false, iVar);
        }
        bi.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("RewardShakePresenter", "onShakeEvent openGate2");
                s.this.ef.xD();
            }
        }, null, 500L);
        com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        if (this.qt.fW()) {
            return;
        }
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        this.qt.a(this);
        this.qt.b(this.mPlayEndPageListener);
        ci();
        initView();
        a(cb);
        float dm = com.kwad.sdk.core.response.a.b.dm(cb);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar == null) {
            com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(dm);
            this.ef = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(dm);
        }
        this.ef.aX(getContext());
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
    }

    @Override // com.kwad.components.ad.reward.d.m
    public final int ch() {
        return com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.kwai.a.g(getContext(), R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.core.response.a.b.dk(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate))) {
            this.qt.a(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.hd;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.hd.getParent()).removeView(this.hd);
            }
            this.hd = null;
        }
        bi.b(getContext(), this.eg);
        this.eg = null;
        Animator animator = this.hl;
        if (animator != null) {
            animator.cancel();
            this.hl = null;
        }
        this.qt.c(this.mPlayEndPageListener);
    }
}
