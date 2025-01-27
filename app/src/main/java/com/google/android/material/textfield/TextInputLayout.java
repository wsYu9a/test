package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.j.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: a */
    private static final int f7885a = R.style.Widget_Design_TextInputLayout;

    /* renamed from: b */
    private static final int f7886b = 167;

    /* renamed from: c */
    private static final int f7887c = -1;

    /* renamed from: d */
    private static final String f7888d = "TextInputLayout";

    /* renamed from: e */
    public static final int f7889e = 0;

    /* renamed from: f */
    public static final int f7890f = 1;

    /* renamed from: g */
    public static final int f7891g = 2;

    /* renamed from: h */
    public static final int f7892h = -1;

    /* renamed from: i */
    public static final int f7893i = 0;

    /* renamed from: j */
    public static final int f7894j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private boolean A;
    private View.OnLongClickListener A0;
    private TextView B;

    @NonNull
    private final CheckableImageButton B0;

    @Nullable
    private ColorStateList C;
    private ColorStateList C0;
    private int D;
    private ColorStateList D0;

    @Nullable
    private ColorStateList E;

    @Nullable
    private ColorStateList F;
    private ColorStateList F0;

    @Nullable
    private CharSequence G;

    @ColorInt
    private int G0;

    @NonNull
    private final TextView H;

    @ColorInt
    private int H0;

    @Nullable
    private CharSequence I;

    @ColorInt
    private int I0;

    @NonNull
    private final TextView J;
    private ColorStateList J0;
    private boolean K;

    @ColorInt
    private int K0;
    private CharSequence L;

    @ColorInt
    private int L0;
    private boolean M;

    @ColorInt
    private int M0;

    @Nullable
    private com.google.android.material.j.j N;

    @ColorInt
    private int N0;

    @Nullable
    private com.google.android.material.j.j O;

    @ColorInt
    private int O0;

    @NonNull
    private o P;
    private boolean P0;
    private final int Q;
    final com.google.android.material.internal.a Q0;
    private int R;
    private boolean R0;
    private final int S;
    private ValueAnimator S0;
    private int T;
    private boolean T0;
    private int U;
    private boolean U0;
    private int V;

    @ColorInt
    private int W;

    @ColorInt
    private int a0;
    private final Rect b0;
    private final Rect c0;
    private final RectF d0;
    private Typeface e0;

    @NonNull
    private final CheckableImageButton f0;
    private ColorStateList g0;
    private boolean h0;
    private PorterDuff.Mode i0;
    private boolean j0;

    @Nullable
    private Drawable k0;
    private int l0;

    @NonNull
    private final FrameLayout m;
    private View.OnLongClickListener m0;

    @NonNull
    private final LinearLayout n;
    private final LinkedHashSet<h> n0;

    @NonNull
    private final LinearLayout o;
    private int o0;

    @NonNull
    private final FrameLayout p;
    private final SparseArray<com.google.android.material.textfield.e> p0;
    EditText q;

    @NonNull
    private final CheckableImageButton q0;
    private CharSequence r;
    private final LinkedHashSet<i> r0;
    private final com.google.android.material.textfield.f s;
    private ColorStateList s0;
    boolean t;
    private boolean t0;
    private int u;
    private PorterDuff.Mode u0;
    private boolean v;
    private boolean v0;

    @Nullable
    private TextView w;

    @Nullable
    private Drawable w0;
    private int x;
    private int x0;
    private int y;
    private Drawable y0;
    private CharSequence z;
    private View.OnLongClickListener z0;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout.this.E0(!r0.U0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.t) {
                textInputLayout.w0(editable.length());
            }
            if (TextInputLayout.this.A) {
                TextInputLayout.this.I0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.q0.performClick();
            TextInputLayout.this.q0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.q.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.Q0.h0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends AccessibilityDelegateCompat {

        /* renamed from: d */
        private final TextInputLayout f7899d;

        public e(@NonNull TextInputLayout textInputLayout) {
            this.f7899d = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f7899d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f7899d.getHint();
            CharSequence helperText = this.f7899d.getHelperText();
            CharSequence error = this.f7899d.getError();
            int counterMaxLength = this.f7899d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f7899d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? ", " : "");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb3.append((Object) helperText);
            String sb4 = sb3.toString();
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(sb4)) {
                accessibilityNodeInfoCompat.setText(sb4);
            }
            if (!TextUtils.isEmpty(sb4)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(sb4);
                } else {
                    if (z) {
                        sb4 = ((Object) text) + ", " + sb4;
                    }
                    accessibilityNodeInfoCompat.setText(sb4);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    public interface h {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    public interface i {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    static class j extends AbsSavedState {
        public static final Parcelable.Creator<j> CREATOR = new a();

        /* renamed from: b */
        @Nullable
        CharSequence f7900b;

        /* renamed from: c */
        boolean f7901c;

        static class a implements Parcelable.ClassLoaderCreator<j> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public j createFromParcel(@NonNull Parcel parcel) {
                return new j(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public j createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new j(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public j[] newArray(int i2) {
                return new j[i2];
            }
        }

        j(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f7900b) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f7900b, parcel, i2);
            parcel.writeInt(this.f7901c ? 1 : 0);
        }

        j(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7900b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f7901c = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private void A(boolean z) {
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.S0.cancel();
        }
        if (z && this.R0) {
            h(1.0f);
        } else {
            this.Q0.h0(1.0f);
        }
        this.P0 = false;
        if (B()) {
            c0();
        }
        H0();
        K0();
        N0();
    }

    private boolean B() {
        return this.K && !TextUtils.isEmpty(this.L) && (this.N instanceof com.google.android.material.textfield.c);
    }

    private boolean B0() {
        int max;
        if (this.q == null || this.q.getMeasuredHeight() >= (max = Math.max(this.o.getMeasuredHeight(), this.n.getMeasuredHeight()))) {
            return false;
        }
        this.q.setMinimumHeight(max);
        return true;
    }

    private void C0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void D() {
        Iterator<h> it = this.n0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void D0() {
        if (this.R != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            int u = u();
            if (u != layoutParams.topMargin) {
                layoutParams.topMargin = u;
                this.m.requestLayout();
            }
        }
    }

    private void E(int i2) {
        Iterator<i> it = this.r0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private void F(Canvas canvas) {
        com.google.android.material.j.j jVar = this.O;
        if (jVar != null) {
            Rect bounds = jVar.getBounds();
            bounds.top = bounds.bottom - this.T;
            this.O.draw(canvas);
        }
    }

    private void F0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.q;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.q;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean l2 = this.s.l();
        ColorStateList colorStateList2 = this.D0;
        if (colorStateList2 != null) {
            this.Q0.T(colorStateList2);
            this.Q0.c0(this.D0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.D0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.O0) : this.O0;
            this.Q0.T(ColorStateList.valueOf(colorForState));
            this.Q0.c0(ColorStateList.valueOf(colorForState));
        } else if (l2) {
            this.Q0.T(this.s.q());
        } else if (this.v && (textView = this.w) != null) {
            this.Q0.T(textView.getTextColors());
        } else if (z4 && (colorStateList = this.F0) != null) {
            this.Q0.T(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || l2))) {
            if (z2 || this.P0) {
                A(z);
                return;
            }
            return;
        }
        if (z2 || !this.P0) {
            H(z);
        }
    }

    private void G(@NonNull Canvas canvas) {
        if (this.K) {
            this.Q0.j(canvas);
        }
    }

    private void G0() {
        EditText editText;
        if (this.B == null || (editText = this.q) == null) {
            return;
        }
        this.B.setGravity(editText.getGravity());
        this.B.setPadding(this.q.getCompoundPaddingLeft(), this.q.getCompoundPaddingTop(), this.q.getCompoundPaddingRight(), this.q.getCompoundPaddingBottom());
    }

    private void H(boolean z) {
        ValueAnimator valueAnimator = this.S0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.S0.cancel();
        }
        if (z && this.R0) {
            h(0.0f);
        } else {
            this.Q0.h0(0.0f);
        }
        if (B() && ((com.google.android.material.textfield.c) this.N).O0()) {
            z();
        }
        this.P0 = true;
        L();
        K0();
        N0();
    }

    private void H0() {
        EditText editText = this.q;
        I0(editText == null ? 0 : editText.getText().length());
    }

    private int I(int i2, boolean z) {
        int compoundPaddingLeft = i2 + this.q.getCompoundPaddingLeft();
        return (this.G == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.H.getMeasuredWidth()) + this.H.getPaddingLeft();
    }

    public void I0(int i2) {
        if (i2 != 0 || this.P0) {
            L();
        } else {
            s0();
        }
    }

    private int J(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.q.getCompoundPaddingRight();
        return (this.G == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.H.getMeasuredWidth() - this.H.getPaddingRight());
    }

    private void J0() {
        if (this.q == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.H, a0() ? 0 : ViewCompat.getPaddingStart(this.q), this.q.getCompoundPaddingTop(), 0, this.q.getCompoundPaddingBottom());
    }

    private boolean K() {
        return this.o0 != 0;
    }

    private void K0() {
        this.H.setVisibility((this.G == null || V()) ? 8 : 0);
        z0();
    }

    private void L() {
        TextView textView = this.B;
        if (textView == null || !this.A) {
            return;
        }
        textView.setText((CharSequence) null);
        this.B.setVisibility(4);
    }

    private void L0(boolean z, boolean z2) {
        int defaultColor = this.J0.getDefaultColor();
        int colorForState = this.J0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.J0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z) {
            this.W = colorForState2;
        } else if (z2) {
            this.W = colorForState;
        } else {
            this.W = defaultColor;
        }
    }

    private void M0() {
        if (this.q == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.J, 0, this.q.getPaddingTop(), (O() || Q()) ? 0 : ViewCompat.getPaddingEnd(this.q), this.q.getPaddingBottom());
    }

    private void N0() {
        int visibility = this.J.getVisibility();
        boolean z = (this.I == null || V()) ? false : true;
        this.J.setVisibility(z ? 0 : 8);
        if (visibility != this.J.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        z0();
    }

    private boolean Q() {
        return this.B0.getVisibility() == 0;
    }

    private boolean Y() {
        return this.R == 1 && (Build.VERSION.SDK_INT < 16 || this.q.getMinLines() <= 1);
    }

    private void b0() {
        o();
        k0();
        O0();
        if (this.R != 0) {
            D0();
        }
    }

    private void c0() {
        if (B()) {
            RectF rectF = this.d0;
            this.Q0.m(rectF, this.q.getWidth(), this.q.getGravity());
            k(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((com.google.android.material.textfield.c) this.N).U0(rectF);
        }
    }

    private static void e0(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                e0((ViewGroup) childAt, z);
            }
        }
    }

    private void g() {
        TextView textView = this.B;
        if (textView != null) {
            this.m.addView(textView);
            this.B.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.p0.get(this.o0);
        return eVar != null ? eVar : this.p0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.B0.getVisibility() == 0) {
            return this.B0;
        }
        if (K() && O()) {
            return this.q0;
        }
        return null;
    }

    private void h0() {
        TextView textView = this.B;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void i() {
        com.google.android.material.j.j jVar = this.N;
        if (jVar == null) {
            return;
        }
        jVar.setShapeAppearanceModel(this.P);
        if (v()) {
            this.N.C0(this.T, this.W);
        }
        int p = p();
        this.a0 = p;
        this.N.n0(ColorStateList.valueOf(p));
        if (this.o0 == 3) {
            this.q.getBackground().invalidateSelf();
        }
        j();
        invalidate();
    }

    private void j() {
        if (this.O == null) {
            return;
        }
        if (w()) {
            this.O.n0(ColorStateList.valueOf(this.W));
        }
        invalidate();
    }

    private void k(@NonNull RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.Q;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    private void k0() {
        if (r0()) {
            ViewCompat.setBackground(this.q, this.N);
        }
    }

    private void l() {
        m(this.q0, this.t0, this.s0, this.v0, this.u0);
    }

    private static void l0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = hasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z2 ? 1 : 2);
    }

    private void m(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void m0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        l0(checkableImageButton, onLongClickListener);
    }

    private void n() {
        m(this.f0, this.h0, this.g0, this.j0, this.i0);
    }

    private static void n0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        l0(checkableImageButton, onLongClickListener);
    }

    private void o() {
        int i2 = this.R;
        if (i2 == 0) {
            this.N = null;
            this.O = null;
            return;
        }
        if (i2 == 1) {
            this.N = new com.google.android.material.j.j(this.P);
            this.O = new com.google.android.material.j.j();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(this.R + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.K || (this.N instanceof com.google.android.material.textfield.c)) {
                this.N = new com.google.android.material.j.j(this.P);
            } else {
                this.N = new com.google.android.material.textfield.c(this.P);
            }
            this.O = null;
        }
    }

    private int p() {
        return this.R == 1 ? com.google.android.material.c.a.f(com.google.android.material.c.a.e(this, R.attr.colorSurface, 0), this.a0) : this.a0;
    }

    private boolean p0() {
        return (this.B0.getVisibility() == 0 || ((K() && O()) || this.I != null)) && this.o.getMeasuredWidth() > 0;
    }

    @NonNull
    private Rect q(@NonNull Rect rect) {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.c0;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        rect2.bottom = rect.bottom;
        int i2 = this.R;
        if (i2 == 1) {
            rect2.left = I(rect.left, z);
            rect2.top = rect.top + this.S;
            rect2.right = J(rect.right, z);
            return rect2;
        }
        if (i2 != 2) {
            rect2.left = I(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = J(rect.right, z);
            return rect2;
        }
        rect2.left = rect.left + this.q.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.q.getPaddingRight();
        return rect2;
    }

    private boolean q0() {
        return !(getStartIconDrawable() == null && this.G == null) && this.n.getMeasuredWidth() > 0;
    }

    private int r(@NonNull Rect rect, @NonNull Rect rect2, float f2) {
        return Y() ? (int) (rect2.top + f2) : rect.bottom - this.q.getCompoundPaddingBottom();
    }

    private boolean r0() {
        EditText editText = this.q;
        return (editText == null || this.N == null || editText.getBackground() != null || this.R == 0) ? false : true;
    }

    private int s(@NonNull Rect rect, float f2) {
        return Y() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.q.getCompoundPaddingTop();
    }

    private void s0() {
        TextView textView = this.B;
        if (textView == null || !this.A) {
            return;
        }
        textView.setText(this.z);
        this.B.setVisibility(0);
        this.B.bringToFront();
    }

    private void setEditText(EditText editText) {
        if (this.q != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.o0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i(f7888d, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.q = editText;
        b0();
        setTextInputAccessibilityDelegate(new e(this));
        this.Q0.o0(this.q.getTypeface());
        this.Q0.e0(this.q.getTextSize());
        int gravity = this.q.getGravity();
        this.Q0.U((gravity & (-113)) | 48);
        this.Q0.d0(gravity);
        this.q.addTextChangedListener(new a());
        if (this.D0 == null) {
            this.D0 = this.q.getHintTextColors();
        }
        if (this.K) {
            if (TextUtils.isEmpty(this.L)) {
                CharSequence hint = this.q.getHint();
                this.r = hint;
                setHint(hint);
                this.q.setHint((CharSequence) null);
            }
            this.M = true;
        }
        if (this.w != null) {
            w0(this.q.getText().length());
        }
        A0();
        this.s.e();
        this.n.bringToFront();
        this.o.bringToFront();
        this.p.bringToFront();
        this.B0.bringToFront();
        D();
        J0();
        M0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        F0(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.B0.setVisibility(z ? 0 : 8);
        this.p.setVisibility(z ? 8 : 0);
        M0();
        if (K()) {
            return;
        }
        z0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.L)) {
            return;
        }
        this.L = charSequence;
        this.Q0.m0(charSequence);
        if (this.P0) {
            return;
        }
        c0();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.A == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.B = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.B, 1);
            setPlaceholderTextAppearance(this.D);
            setPlaceholderTextColor(this.C);
            g();
        } else {
            h0();
            this.B = null;
        }
        this.A = z;
    }

    @NonNull
    private Rect t(@NonNull Rect rect) {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.c0;
        float z = this.Q0.z();
        rect2.left = rect.left + this.q.getCompoundPaddingLeft();
        rect2.top = s(rect, z);
        rect2.right = rect.right - this.q.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, z);
        return rect2;
    }

    private void t0(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            l();
            return;
        }
        Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(mutate, this.s.p());
        this.q0.setImageDrawable(mutate);
    }

    private int u() {
        float p;
        if (!this.K) {
            return 0;
        }
        int i2 = this.R;
        if (i2 == 0 || i2 == 1) {
            p = this.Q0.p();
        } else {
            if (i2 != 2) {
                return 0;
            }
            p = this.Q0.p() / 2.0f;
        }
        return (int) p;
    }

    private void u0(@NonNull Rect rect) {
        com.google.android.material.j.j jVar = this.O;
        if (jVar != null) {
            int i2 = rect.bottom;
            jVar.setBounds(rect.left, i2 - this.V, rect.right, i2);
        }
    }

    private boolean v() {
        return this.R == 2 && w();
    }

    private void v0() {
        if (this.w != null) {
            EditText editText = this.q;
            w0(editText == null ? 0 : editText.getText().length());
        }
    }

    private boolean w() {
        return this.T > -1 && this.W != 0;
    }

    private static void x0(@NonNull Context context, @NonNull TextView textView, int i2, int i3, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private void y0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.w;
        if (textView != null) {
            o0(textView, this.v ? this.x : this.y);
            if (!this.v && (colorStateList2 = this.E) != null) {
                this.w.setTextColor(colorStateList2);
            }
            if (!this.v || (colorStateList = this.F) == null) {
                return;
            }
            this.w.setTextColor(colorStateList);
        }
    }

    private void z() {
        if (B()) {
            ((com.google.android.material.textfield.c) this.N).R0();
        }
    }

    private boolean z0() {
        boolean z;
        if (this.q == null) {
            return false;
        }
        boolean z2 = true;
        if (q0()) {
            int measuredWidth = this.n.getMeasuredWidth() - this.q.getPaddingLeft();
            if (this.k0 == null || this.l0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.k0 = colorDrawable;
                this.l0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.q);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.k0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.q, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.k0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.q);
                TextViewCompat.setCompoundDrawablesRelative(this.q, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.k0 = null;
                z = true;
            }
            z = false;
        }
        if (p0()) {
            int measuredWidth2 = this.J.getMeasuredWidth() - this.q.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.q);
            Drawable drawable3 = this.w0;
            if (drawable3 == null || this.x0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.w0 = colorDrawable2;
                    this.x0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.w0;
                if (drawable4 != drawable5) {
                    this.y0 = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.q, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.x0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.q, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.w0, compoundDrawablesRelative3[3]);
            }
        } else {
            if (this.w0 == null) {
                return z;
            }
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.q);
            if (compoundDrawablesRelative4[2] == this.w0) {
                TextViewCompat.setCompoundDrawablesRelative(this.q, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.y0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.w0 = null;
        }
        return z2;
    }

    void A0() {
        Drawable background;
        TextView textView;
        EditText editText = this.q;
        if (editText == null || this.R != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.s.l()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.s.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.v && (textView = this.w) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.q.refreshDrawableState();
        }
    }

    @VisibleForTesting
    boolean C() {
        return B() && ((com.google.android.material.textfield.c) this.N).O0();
    }

    void E0(boolean z) {
        F0(z, false);
    }

    public boolean M() {
        return this.t;
    }

    public boolean N() {
        return this.q0.a();
    }

    public boolean O() {
        return this.p.getVisibility() == 0 && this.q0.getVisibility() == 0;
    }

    void O0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.N == null || this.R == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.q) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.q) != null && editText.isHovered());
        if (!isEnabled()) {
            this.W = this.O0;
        } else if (this.s.l()) {
            if (this.J0 != null) {
                L0(z2, z3);
            } else {
                this.W = this.s.p();
            }
        } else if (!this.v || (textView = this.w) == null) {
            if (z2) {
                this.W = this.I0;
            } else if (z3) {
                this.W = this.H0;
            } else {
                this.W = this.G0;
            }
        } else if (this.J0 != null) {
            L0(z2, z3);
        } else {
            this.W = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.s.B() && this.s.l()) {
            z = true;
        }
        setErrorIconVisible(z);
        C0(this.B0, this.C0);
        C0(this.f0, this.g0);
        C0(this.q0, this.s0);
        if (getEndIconDelegate().d()) {
            t0(this.s.l());
        }
        if (z2 && isEnabled()) {
            this.T = this.V;
        } else {
            this.T = this.U;
        }
        if (this.R == 1) {
            if (!isEnabled()) {
                this.a0 = this.L0;
            } else if (z3 && !z2) {
                this.a0 = this.N0;
            } else if (z2) {
                this.a0 = this.M0;
            } else {
                this.a0 = this.K0;
            }
        }
        i();
    }

    public boolean P() {
        return this.s.B();
    }

    @VisibleForTesting
    final boolean R() {
        return this.s.u();
    }

    public boolean S() {
        return this.s.C();
    }

    public boolean T() {
        return this.R0;
    }

    public boolean U() {
        return this.K;
    }

    @VisibleForTesting
    final boolean V() {
        return this.P0;
    }

    @Deprecated
    public boolean W() {
        return this.o0 == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean X() {
        return this.M;
    }

    public boolean Z() {
        return this.f0.a();
    }

    public boolean a0() {
        return this.f0.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.m.addView(view, layoutParams2);
        this.m.setLayoutParams(layoutParams);
        D0();
        setEditText((EditText) view);
    }

    @Deprecated
    public void d0(boolean z) {
        if (this.o0 == 1) {
            this.q0.performClick();
            if (z) {
                this.q0.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.r == null || (editText = this.q) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z = this.M;
        this.M = false;
        CharSequence hint = editText.getHint();
        this.q.setHint(this.r);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.q.setHint(hint);
            this.M = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.U0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.U0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        G(canvas);
        F(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.T0) {
            return;
        }
        this.T0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.Q0;
        boolean l0 = aVar != null ? aVar.l0(drawableState) | false : false;
        if (this.q != null) {
            E0(ViewCompat.isLaidOut(this) && isEnabled());
        }
        A0();
        O0();
        if (l0) {
            invalidate();
        }
        this.T0 = false;
    }

    public void e(@NonNull h hVar) {
        this.n0.add(hVar);
        if (this.q != null) {
            hVar.a(this);
        }
    }

    public void f(@NonNull i iVar) {
        this.r0.add(iVar);
    }

    public void f0(@NonNull h hVar) {
        this.n0.remove(hVar);
    }

    public void g0(@NonNull i iVar) {
        this.r0.remove(iVar);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.q;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    @NonNull
    com.google.android.material.j.j getBoxBackground() {
        int i2 = this.R;
        if (i2 == 1 || i2 == 2) {
            return this.N;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.a0;
    }

    public int getBoxBackgroundMode() {
        return this.R;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.N.t();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.N.u();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.N.S();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.N.R();
    }

    public int getBoxStrokeColor() {
        return this.I0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.J0;
    }

    public int getBoxStrokeWidth() {
        return this.U;
    }

    public int getBoxStrokeWidthFocused() {
        return this.V;
    }

    public int getCounterMaxLength() {
        return this.u;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.t && this.v && (textView = this.w) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.E;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.E;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.D0;
    }

    @Nullable
    public EditText getEditText() {
        return this.q;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.q0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.q0.getDrawable();
    }

    public int getEndIconMode() {
        return this.o0;
    }

    @NonNull
    CheckableImageButton getEndIconView() {
        return this.q0;
    }

    @Nullable
    public CharSequence getError() {
        if (this.s.B()) {
            return this.s.o();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.s.n();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.s.p();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.B0.getDrawable();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.s.p();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.s.C()) {
            return this.s.r();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.s.t();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.K) {
            return this.L;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.Q0.p();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.Q0.u();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.F0;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.q0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.q0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.A) {
            return this.z;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.D;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.C;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.G;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.H.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.H;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f0.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f0.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.I;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.J.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.J;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.e0;
    }

    @VisibleForTesting
    void h(float f2) {
        if (this.Q0.C() == f2) {
            return;
        }
        if (this.S0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.S0 = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.a.a.f6608b);
            this.S0.setDuration(167L);
            this.S0.addUpdateListener(new d());
        }
        this.S0.setFloatValues(this.Q0.C(), f2);
        this.S0.start();
    }

    public void i0(float f2, float f3, float f4, float f5) {
        com.google.android.material.j.j jVar = this.N;
        if (jVar != null && jVar.R() == f2 && this.N.S() == f3 && this.N.u() == f5 && this.N.t() == f4) {
            return;
        }
        this.P = this.P.v().K(f2).P(f3).C(f5).x(f4).m();
        i();
    }

    public void j0(@DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        i0(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void o0(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.o0(android.widget.TextView, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.q;
        if (editText != null) {
            Rect rect = this.b0;
            com.google.android.material.internal.c.a(this, editText, rect);
            u0(rect);
            if (this.K) {
                this.Q0.e0(this.q.getTextSize());
                int gravity = this.q.getGravity();
                this.Q0.U((gravity & (-113)) | 48);
                this.Q0.d0(gravity);
                this.Q0.Q(q(rect));
                this.Q0.Z(t(rect));
                this.Q0.N();
                if (!B() || this.P0) {
                    return;
                }
                c0();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean B0 = B0();
        boolean z0 = z0();
        if (B0 || z0) {
            this.q.post(new c());
        }
        G0();
        J0();
        M0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        setError(jVar.f7900b);
        if (jVar.f7901c) {
            this.q0.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        if (this.s.l()) {
            jVar.f7900b = getError();
        }
        jVar.f7901c = K() && this.q0.isChecked();
        return jVar;
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.a0 != i2) {
            this.a0 = i2;
            this.K0 = i2;
            this.M0 = i2;
            this.N0 = i2;
            i();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.K0 = defaultColor;
        this.a0 = defaultColor;
        this.L0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.M0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.N0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        i();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.R) {
            return;
        }
        this.R = i2;
        if (this.q != null) {
            b0();
        }
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.I0 != i2) {
            this.I0 = i2;
            O0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.G0 = colorStateList.getDefaultColor();
            this.O0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.H0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.I0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.I0 != colorStateList.getDefaultColor()) {
            this.I0 = colorStateList.getDefaultColor();
        }
        O0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.J0 != colorStateList) {
            this.J0 = colorStateList;
            O0();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.U = i2;
        O0();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.V = i2;
        O0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.t != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.w = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.e0;
                if (typeface != null) {
                    this.w.setTypeface(typeface);
                }
                this.w.setMaxLines(1);
                this.s.d(this.w, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.w.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                y0();
                v0();
            } else {
                this.s.D(this.w, 2);
                this.w = null;
            }
            this.t = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.u != i2) {
            if (i2 > 0) {
                this.u = i2;
            } else {
                this.u = -1;
            }
            if (this.t) {
                v0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.x != i2) {
            this.x = i2;
            y0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            y0();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.y != i2) {
            this.y = i2;
            y0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            y0();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.D0 = colorStateList;
        this.F0 = colorStateList;
        if (this.q != null) {
            E0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        e0(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.q0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.q0.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.o0;
        this.o0 = i2;
        E(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.R)) {
            getEndIconDelegate().a();
            l();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.R + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        m0(this.q0, onClickListener, this.z0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.z0 = onLongClickListener;
        n0(this.q0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.s0 != colorStateList) {
            this.s0 = colorStateList;
            this.t0 = true;
            l();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.u0 != mode) {
            this.u0 = mode;
            this.v0 = true;
            l();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (O() != z) {
            this.q0.setVisibility(z ? 0 : 8);
            M0();
            z0();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.s.B()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.s.w();
        } else {
            this.s.Q(charSequence);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.s.F(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.s.G(z);
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        m0(this.B0, onClickListener, this.A0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.A0 = onLongClickListener;
        n0(this.B0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.C0 = colorStateList;
        Drawable drawable = this.B0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.B0.getDrawable() != drawable) {
            this.B0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.B0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.B0.getDrawable() != drawable) {
            this.B0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.s.H(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.s.I(colorStateList);
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (S()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!S()) {
                setHelperTextEnabled(true);
            }
            this.s.R(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.s.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.s.K(z);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.s.J(i2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.K) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.R0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.K) {
            this.K = z;
            if (z) {
                CharSequence hint = this.q.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.L)) {
                        setHint(hint);
                    }
                    this.q.setHint((CharSequence) null);
                }
                this.M = true;
            } else {
                this.M = false;
                if (!TextUtils.isEmpty(this.L) && TextUtils.isEmpty(this.q.getHint())) {
                    this.q.setHint(this.L);
                }
                setHintInternal(null);
            }
            if (this.q != null) {
                D0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.Q0.R(i2);
        this.F0 = this.Q0.n();
        if (this.q != null) {
            E0(false);
            D0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            if (this.D0 == null) {
                this.Q0.T(colorStateList);
            }
            this.F0 = colorStateList;
            if (this.q != null) {
                E0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.o0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.s0 = colorStateList;
        this.t0 = true;
        l();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.u0 = mode;
        this.v0 = true;
        l();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.A && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.A) {
                setPlaceholderTextEnabled(true);
            }
            this.z = charSequence;
        }
        H0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.D = i2;
        TextView textView = this.B;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            TextView textView = this.B;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.G = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.H.setText(charSequence);
        K0();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.H, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.H.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.f0.setCheckable(z);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        m0(this.f0, onClickListener, this.m0);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.m0 = onLongClickListener;
        n0(this.f0, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.g0 != colorStateList) {
            this.g0 = colorStateList;
            this.h0 = true;
            n();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.i0 != mode) {
            this.i0 = mode;
            this.j0 = true;
            n();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (a0() != z) {
            this.f0.setVisibility(z ? 0 : 8);
            J0();
            z0();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.I = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.J.setText(charSequence);
        N0();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.J, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.J.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable e eVar) {
        EditText editText = this.q;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, eVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.e0) {
            this.e0 = typeface;
            this.Q0.o0(typeface);
            this.s.N(typeface);
            TextView textView = this.w;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void w0(int i2) {
        boolean z = this.v;
        int i3 = this.u;
        if (i3 == -1) {
            this.w.setText(String.valueOf(i2));
            this.w.setContentDescription(null);
            this.v = false;
        } else {
            this.v = i2 > i3;
            x0(getContext(), this.w, i2, this.u, this.v);
            if (z != this.v) {
                y0();
            }
            this.w.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.u))));
        }
        if (this.q == null || z == this.v) {
            return;
        }
        E0(false);
        O0();
        A0();
    }

    public void x() {
        this.n0.clear();
    }

    public void y() {
        this.r0.clear();
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.q0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.q0.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.B0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.s.B());
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.f0.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f0.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            n();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r24, @androidx.annotation.Nullable android.util.AttributeSet r25, int r26) {
        /*
            Method dump skipped, instructions count: 1468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.q0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.q0.setImageDrawable(drawable);
    }
}
