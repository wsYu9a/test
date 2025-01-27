package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a */
    private static final int f7941a = 217;

    /* renamed from: b */
    private static final int f7942b = 167;

    /* renamed from: c */
    static final int f7943c = 0;

    /* renamed from: d */
    static final int f7944d = 1;

    /* renamed from: e */
    static final int f7945e = 2;

    /* renamed from: f */
    private static final int f7946f = 0;

    /* renamed from: g */
    private static final int f7947g = 1;

    /* renamed from: h */
    private static final int f7948h = 2;

    @Nullable
    private TextView A;
    private int B;

    @Nullable
    private ColorStateList C;
    private Typeface D;

    /* renamed from: i */
    private final Context f7949i;

    /* renamed from: j */
    @NonNull
    private final TextInputLayout f7950j;
    private LinearLayout k;
    private int l;
    private FrameLayout m;
    private int n;

    @Nullable
    private Animator o;
    private final float p;
    private int q;
    private int r;

    @Nullable
    private CharSequence s;
    private boolean t;

    @Nullable
    private TextView u;

    @Nullable
    private CharSequence v;
    private int w;

    @Nullable
    private ColorStateList x;
    private CharSequence y;
    private boolean z;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f7951a;

        /* renamed from: b */
        final /* synthetic */ TextView f7952b;

        /* renamed from: c */
        final /* synthetic */ int f7953c;

        /* renamed from: d */
        final /* synthetic */ TextView f7954d;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.f7951a = i2;
            this.f7952b = textView;
            this.f7953c = i3;
            this.f7954d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.q = this.f7951a;
            f.this.o = null;
            TextView textView = this.f7952b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f7953c == 1 && f.this.u != null) {
                    f.this.u.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f7954d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f7954d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f7954d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(@NonNull TextInputLayout textInputLayout) {
        this.f7949i = textInputLayout.getContext();
        this.f7950j = textInputLayout;
        this.p = r0.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private void E(int i2, int i3) {
        TextView m;
        TextView m2;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (m2 = m(i3)) != null) {
            m2.setVisibility(0);
            m2.setAlpha(1.0f);
        }
        if (i2 != 0 && (m = m(i2)) != null) {
            m.setVisibility(4);
            if (i2 == 1) {
                m.setText((CharSequence) null);
            }
        }
        this.q = i3;
    }

    private void M(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f7950j) && this.f7950j.isEnabled() && !(this.r == this.q && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void S(int i2, int i3, boolean z) {
        if (i2 == i3) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.o = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.z, this.A, 2, i2, i3);
            h(arrayList, this.t, this.u, 1, i2, i3);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, m(i2), i2, m(i3)));
            animatorSet.start();
        } else {
            E(i2, i3);
        }
        this.f7950j.A0();
        this.f7950j.E0(z);
        this.f7950j.O0();
    }

    private boolean f() {
        return (this.k == null || this.f7950j.getEditText() == null) ? false : true;
    }

    private void h(@NonNull List<Animator> list, boolean z, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(i(textView, i4 == i2));
            if (i4 == i2) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6607a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.p, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6610d);
        return ofFloat;
    }

    @Nullable
    private TextView m(int i2) {
        if (i2 == 1) {
            return this.u;
        }
        if (i2 != 2) {
            return null;
        }
        return this.A;
    }

    private boolean y(int i2) {
        return (i2 != 1 || this.u == null || TextUtils.isEmpty(this.s)) ? false : true;
    }

    private boolean z(int i2) {
        return (i2 != 2 || this.A == null || TextUtils.isEmpty(this.y)) ? false : true;
    }

    boolean A(int i2) {
        return i2 == 0 || i2 == 1;
    }

    boolean B() {
        return this.t;
    }

    boolean C() {
        return this.z;
    }

    void D(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.k == null) {
            return;
        }
        if (!A(i2) || (frameLayout = this.m) == null) {
            this.k.removeView(textView);
        } else {
            int i3 = this.n - 1;
            this.n = i3;
            O(frameLayout, i3);
            this.m.removeView(textView);
        }
        int i4 = this.l - 1;
        this.l = i4;
        O(this.k, i4);
    }

    void F(@Nullable CharSequence charSequence) {
        this.v = charSequence;
        TextView textView = this.u;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void G(boolean z) {
        if (this.t == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f7949i);
            this.u = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.u.setTextAlignment(5);
            }
            Typeface typeface = this.D;
            if (typeface != null) {
                this.u.setTypeface(typeface);
            }
            H(this.w);
            I(this.x);
            F(this.v);
            this.u.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.u, 1);
            d(this.u, 0);
        } else {
            w();
            D(this.u, 0);
            this.u = null;
            this.f7950j.A0();
            this.f7950j.O0();
        }
        this.t = z;
    }

    void H(@StyleRes int i2) {
        this.w = i2;
        TextView textView = this.u;
        if (textView != null) {
            this.f7950j.o0(textView, i2);
        }
    }

    void I(@Nullable ColorStateList colorStateList) {
        this.x = colorStateList;
        TextView textView = this.u;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void J(@StyleRes int i2) {
        this.B = i2;
        TextView textView = this.A;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    void K(boolean z) {
        if (this.z == z) {
            return;
        }
        g();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f7949i);
            this.A = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.A.setTextAlignment(5);
            }
            Typeface typeface = this.D;
            if (typeface != null) {
                this.A.setTypeface(typeface);
            }
            this.A.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.A, 1);
            J(this.B);
            L(this.C);
            d(this.A, 1);
        } else {
            x();
            D(this.A, 1);
            this.A = null;
            this.f7950j.A0();
            this.f7950j.O0();
        }
        this.z = z;
    }

    void L(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        TextView textView = this.A;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void N(Typeface typeface) {
        if (typeface != this.D) {
            this.D = typeface;
            M(this.u, typeface);
            M(this.A, typeface);
        }
    }

    void Q(CharSequence charSequence) {
        g();
        this.s = charSequence;
        this.u.setText(charSequence);
        int i2 = this.q;
        if (i2 != 1) {
            this.r = 1;
        }
        S(i2, this.r, P(this.u, charSequence));
    }

    void R(CharSequence charSequence) {
        g();
        this.y = charSequence;
        this.A.setText(charSequence);
        int i2 = this.q;
        if (i2 != 2) {
            this.r = 2;
        }
        S(i2, this.r, P(this.A, charSequence));
    }

    void d(TextView textView, int i2) {
        if (this.k == null && this.m == null) {
            LinearLayout linearLayout = new LinearLayout(this.f7949i);
            this.k = linearLayout;
            linearLayout.setOrientation(0);
            this.f7950j.addView(this.k, -1, -2);
            this.m = new FrameLayout(this.f7949i);
            this.k.addView(this.m, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f7950j.getEditText() != null) {
                e();
            }
        }
        if (A(i2)) {
            this.m.setVisibility(0);
            this.m.addView(textView);
            this.n++;
        } else {
            this.k.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.k.setVisibility(0);
        this.l++;
    }

    void e() {
        if (f()) {
            ViewCompat.setPaddingRelative(this.k, ViewCompat.getPaddingStart(this.f7950j.getEditText()), 0, ViewCompat.getPaddingEnd(this.f7950j.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean k() {
        return y(this.q);
    }

    boolean l() {
        return y(this.r);
    }

    @Nullable
    CharSequence n() {
        return this.v;
    }

    @Nullable
    CharSequence o() {
        return this.s;
    }

    @ColorInt
    int p() {
        TextView textView = this.u;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    ColorStateList q() {
        TextView textView = this.u;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence r() {
        return this.y;
    }

    @Nullable
    ColorStateList s() {
        TextView textView = this.A;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @ColorInt
    int t() {
        TextView textView = this.A;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    boolean u() {
        return z(this.q);
    }

    boolean v() {
        return z(this.r);
    }

    void w() {
        this.s = null;
        g();
        if (this.q == 1) {
            if (!this.z || TextUtils.isEmpty(this.y)) {
                this.r = 0;
            } else {
                this.r = 2;
            }
        }
        S(this.q, this.r, P(this.u, null));
    }

    void x() {
        g();
        int i2 = this.q;
        if (i2 == 2) {
            this.r = 0;
        }
        S(i2, this.r, P(this.A, null));
    }
}
