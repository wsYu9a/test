package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: classes4.dex */
public class m extends RelativeLayout {

    /* renamed from: a */
    public final ImageView f18758a;

    /* renamed from: b */
    public final TextView f18759b;

    /* renamed from: c */
    public final TextView f18760c;

    /* renamed from: d */
    public final int f18761d;

    /* renamed from: e */
    public TextView f18762e;

    /* renamed from: f */
    public TextView f18763f;

    /* renamed from: g */
    public t f18764g;

    /* renamed from: h */
    public m f18765h;

    /* renamed from: i */
    public int f18766i;

    /* renamed from: j */
    public int f18767j;

    /* renamed from: k */
    public boolean f18768k;

    /* renamed from: l */
    public int f18769l;

    /* renamed from: m */
    public int f18770m;

    /* renamed from: n */
    public boolean f18771n;

    /* renamed from: o */
    public boolean f18772o;

    /* renamed from: p */
    public boolean f18773p;

    /* renamed from: q */
    public LinearLayout f18774q;

    /* renamed from: r */
    public BaseAdUnit f18775r;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            SigmobLog.e("input: " + f10);
            return (float) ((Math.pow(2.0d, (-10.0f) * f10) * Math.sin(((f10 - 0.13333334f) * 6.283185307179586d) / 0.4000000059604645d)) + 1.0d);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            m.this.f18772o = false;
            m.this.f18773p = false;
            m.this.f18765h.clearAnimation();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            m.this.f18772o = false;
            m.this.f18773p = false;
            m.this.f18765h.clearAnimation();
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.f18772o = false;
            m.this.f18765h.clearAnimation();
            SigmobLog.d("startDownToUpAnimator end");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            m.this.f18772o = true;
            m.this.f18765h.clearAnimation();
            m.this.a();
            SigmobLog.d("startUpToDownAnimator end");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class e implements ImageManager.BitmapLoadedListener {
        public e() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            m.this.f18758a.setImageBitmap(bitmap);
            m.this.f18758a.setVisibility(0);
            if (m.this.f18768k) {
                m.this.e();
            }
        }
    }

    public m(Context context, BaseAdUnit baseAdUnit, String str, String str2, float f10, String str3, int i10, int i11, String str4, int i12, int i13, int i14, int i15, int i16, float f11) {
        super(context);
        this.f18765h = null;
        this.f18767j = 0;
        this.f18766i = Dips.asIntPixels(f11, context);
        this.f18770m = Dips.asIntPixels(10.0f, context);
        this.f18775r = baseAdUnit;
        this.f18767j = i10;
        this.f18761d = i11;
        TextView textView = new TextView(context);
        this.f18760c = textView;
        textView.setText(str);
        textView.setTextSize(1, 16.0f);
        textView.setTextColor(-16777216);
        textView.setSingleLine();
        textView.setTypeface(Typeface.defaultFromStyle(0));
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setGravity(16);
        textView.setId(ClientMetadata.generateViewId());
        textView.setPadding(this.f18770m / 6, 0, 0, 0);
        this.f18769l = i14;
        TextView textView2 = new TextView(context);
        this.f18759b = textView2;
        textView2.setId(ClientMetadata.generateViewId());
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(i13);
        textView2.setGravity(17);
        textView.setSingleLine();
        textView2.setEllipsize(truncateAt);
        textView2.setText(str2);
        int asIntPixels = Dips.asIntPixels(5.0f, context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i12);
        gradientDrawable.setCornerRadius(asIntPixels * 6);
        CircleImageView circleImageView = new CircleImageView(context);
        this.f18758a = circleImageView;
        circleImageView.setScaleType(ImageView.ScaleType.FIT_START);
        circleImageView.setId(ClientMetadata.generateViewId());
        circleImageView.f18421e = false;
        float f12 = asIntPixels * 2;
        circleImageView.f18420d = f12;
        textView2.setBackground(gradientDrawable);
        textView2.setId(ClientMetadata.generateViewId());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f12);
        gradientDrawable2.setColor(i15);
        gradientDrawable2.setAlpha(i16);
        setBackground(gradientDrawable2);
        this.f18765h = this;
        if (i11 == 1) {
            a(context, f10);
        } else {
            a(context, str3);
        }
        if (baseAdUnit.getMaterial() != null && baseAdUnit.getMaterial().ad_privacy != null) {
            a(context);
        }
        setupUILayout(context);
        circleImageView.setVisibility(4);
        a(str4);
        a();
    }

    private void setupUILayout(Context context) {
        int asIntPixels = Dips.asIntPixels(60.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(asIntPixels, asIntPixels);
        layoutParams.addRule(15);
        int i10 = this.f18770m;
        layoutParams.setMargins(i10, i10 / 4, 0, 0);
        this.f18758a.setId(ClientMetadata.generateViewId());
        addView(this.f18758a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, (int) (asIntPixels / 1.8f));
        layoutParams2.setMargins(0, 0, this.f18770m, 0);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        TextView textView = this.f18759b;
        int i11 = this.f18770m;
        textView.setPadding(i11, 0, i11, 0);
        addView(this.f18759b, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(this.f18770m / 2, 0, 0, 0);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, this.f18758a.getId());
        layoutParams3.addRule(0, this.f18759b.getId());
        addView(linearLayout, layoutParams3);
        linearLayout.addView(this.f18760c, new RelativeLayout.LayoutParams(-2, -2));
        if (this.f18762e != null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.addView(this.f18762e, new RelativeLayout.LayoutParams(-2, -2));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(1, this.f18762e.getId());
            layoutParams4.addRule(6, this.f18762e.getId());
            layoutParams4.addRule(8, this.f18762e.getId());
            relativeLayout.addView(this.f18764g, layoutParams4);
            linearLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        } else if (this.f18763f != null) {
            linearLayout.addView(this.f18763f, new RelativeLayout.LayoutParams(-2, -2));
        }
        if (this.f18774q != null) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(8, this.f18758a.getId());
            linearLayout.addView(this.f18774q, layoutParams5);
        }
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void f() {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 0.95f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.6f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.7f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.8f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        d();
        this.f18773p = true;
        ofPropertyValuesHolder.addListener(new b());
        ofPropertyValuesHolder.start();
    }

    public final void g() {
        SigmobLog.d("startDownToUpAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        d();
        translateAnimation.setAnimationListener(new c());
        this.f18765h.startAnimation(translateAnimation);
    }

    public LinearLayout getFourElementsLayout() {
        return this.f18774q;
    }

    @Override // android.view.View
    public int getVisibility() {
        return super.getVisibility();
    }

    public final void h() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.3f, 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.3f, 0.5f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new a());
        d();
        ofPropertyValuesHolder.setDuration(y.f.f18076n);
        ofPropertyValuesHolder.start();
    }

    public final void i() {
        SigmobLog.d("startUpToDownAnimator");
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setAnimationListener(new d());
        this.f18765h.startAnimation(translateAnimation);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (this.f18769l == 1) {
            this.f18759b.setOnTouchListener(onTouchListener);
        } else {
            super.setOnTouchListener(onTouchListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 == 8) {
            super.setVisibility(i10);
            this.f18768k = false;
            return;
        }
        if (i10 == 0) {
            this.f18768k = true;
            if (this.f18765h.getAnimation() == null && !this.f18773p && this.f18758a.getVisibility() == 0) {
                e();
                return;
            }
            return;
        }
        if (i10 != 4) {
            super.setVisibility(i10);
        } else {
            if (this.f18765h.getAnimation() != null) {
                return;
            }
            i();
        }
    }

    public boolean c() {
        return this.f18771n;
    }

    public final void d() {
        this.f18771n = true;
        super.setVisibility(0);
    }

    public final void e() {
        int i10 = this.f18767j;
        if (i10 == 1) {
            f();
        } else if (i10 == 2 || i10 != 3) {
            g();
        } else {
            d();
        }
    }

    public void a(Context context, String str) {
        TextView textView = new TextView(context);
        this.f18763f = textView;
        textView.setId(ClientMetadata.generateViewId());
        this.f18763f.setTextColor(-7829368);
        this.f18763f.setSingleLine();
        this.f18763f.setGravity(17);
        this.f18763f.setTextSize(1, 14.0f);
        this.f18763f.setEllipsize(TextUtils.TruncateAt.END);
        this.f18763f.setText(str);
    }

    public boolean b() {
        return this.f18772o;
    }

    public void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f18774q = linearLayout;
        linearLayout.setOrientation(0);
        this.f18774q.setId(ClientMetadata.generateViewId());
        int asIntPixels = Dips.asIntPixels(2.0f, context);
        String[] strArr = {"名称", "版本", "开发者", "权限", "隐私协议", "介绍"};
        for (int i10 = 0; i10 < 6; i10++) {
            TextView textView = new TextView(context);
            textView.setTextSize(1, 8.0f);
            textView.setText(strArr[i10]);
            textView.setTextColor(-7829368);
            textView.setAlpha(0.7f);
            textView.getPaint().setAntiAlias(true);
            textView.getPaint().setFlags(8);
            int i11 = asIntPixels / 2;
            textView.setPadding(i11, 0, i11, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, asIntPixels, 0);
            this.f18774q.addView(textView, layoutParams);
        }
    }

    public void a(Context context, float f10) {
        TextView textView = new TextView(context);
        this.f18762e = textView;
        textView.setTextSize(1, 14.0f);
        this.f18762e.setId(ClientMetadata.generateViewId());
        this.f18762e.setGravity(17);
        this.f18762e.setTextColor(-7829368);
        if (f10 > 0.0f) {
            this.f18762e.setText(String.format("%.1f", Float.valueOf(f10)));
        }
        this.f18764g = new t(context, f10);
    }

    public final void a() {
        super.setVisibility(4);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.sigmob.sdk.base.common.h.o().getBitmap(str, new e());
    }
}
