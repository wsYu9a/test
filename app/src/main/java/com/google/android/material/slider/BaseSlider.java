package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.internal.t;
import com.google.android.material.internal.u;
import com.google.android.material.j.j;
import com.google.android.material.j.o;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* renamed from: b */
    private static final String f7709b = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";

    /* renamed from: c */
    private static final String f7710c = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";

    /* renamed from: d */
    private static final String f7711d = "valueFrom(%s) must be smaller than valueTo(%s)";

    /* renamed from: e */
    private static final String f7712e = "valueTo(%s) must be greater than valueFrom(%s)";

    /* renamed from: f */
    private static final String f7713f = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";

    /* renamed from: g */
    private static final String f7714g = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";

    /* renamed from: h */
    private static final int f7715h = 200;

    /* renamed from: i */
    private static final int f7716i = 63;

    /* renamed from: j */
    private static final double f7717j = 1.0E-4d;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private float H;
    private MotionEvent I;
    private com.google.android.material.slider.d J;
    private boolean K;
    private float L;
    private float M;
    private ArrayList<Float> N;
    private int O;
    private int P;
    private float Q;
    private float[] R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;

    @NonNull
    private ColorStateList W;

    @NonNull
    private ColorStateList a0;

    @NonNull
    private ColorStateList b0;

    @NonNull
    private ColorStateList c0;

    @NonNull
    private ColorStateList d0;

    @NonNull
    private final j e0;
    private float f0;

    @NonNull
    private final Paint l;

    @NonNull
    private final Paint m;

    @NonNull
    private final Paint n;

    @NonNull
    private final Paint o;

    @NonNull
    private final Paint p;

    @NonNull
    private final Paint q;

    @NonNull
    private final c r;
    private final AccessibilityManager s;
    private BaseSlider<S, L, T>.b t;

    @NonNull
    private final e u;

    @NonNull
    private final List<com.google.android.material.l.a> v;

    @NonNull
    private final List<L> w;

    @NonNull
    private final List<T> x;
    private final int y;
    private int z;

    /* renamed from: a */
    private static final String f7708a = BaseSlider.class.getSimpleName();
    private static final int k = R.style.Widget_MaterialComponents_Slider;

    class a implements e {

        /* renamed from: a */
        final /* synthetic */ AttributeSet f7718a;

        /* renamed from: b */
        final /* synthetic */ int f7719b;

        a(AttributeSet attributeSet, int i2) {
            this.f7718a = attributeSet;
            this.f7719b = i2;
        }

        @Override // com.google.android.material.slider.BaseSlider.e
        public com.google.android.material.l.a a() {
            TypedArray j2 = n.j(BaseSlider.this.getContext(), this.f7718a, R.styleable.Slider, this.f7719b, BaseSlider.k, new int[0]);
            com.google.android.material.l.a R = BaseSlider.R(BaseSlider.this.getContext(), j2);
            j2.recycle();
            return R;
        }
    }

    private static class c extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> r;
        Rect s;

        c(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.s = new Rect();
            this.r = baseSlider;
        }

        @NonNull
        private String F(int i2) {
            return i2 == this.r.getValues().size() + (-1) ? this.r.getContext().getString(R.string.material_slider_range_end) : i2 == 0 ? this.r.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int n(float f2, float f3) {
            for (int i2 = 0; i2 < this.r.getValues().size(); i2++) {
                this.r.e0(i2, this.s);
                if (this.s.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void o(List<Integer> list) {
            for (int i2 = 0; i2 < this.r.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean u(int i2, int i3, Bundle bundle) {
            if (!this.r.isEnabled()) {
                return false;
            }
            if (i3 != 4096 && i3 != 8192) {
                if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.r.c0(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.r.f0();
                        this.r.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                }
                return false;
            }
            float m = this.r.m(20);
            if (i3 == 8192) {
                m = -m;
            }
            if (this.r.I()) {
                m = -m;
            }
            if (!this.r.c0(i2, MathUtils.clamp(this.r.getValues().get(i2).floatValue() + m, this.r.getValueFrom(), this.r.getValueTo()))) {
                return false;
            }
            this.r.f0();
            this.r.postInvalidate();
            invalidateVirtualView(i2);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void y(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.r.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.r.getValueFrom();
            float valueTo = this.r.getValueTo();
            if (this.r.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.r.getContentDescription() != null) {
                sb.append(this.r.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(F(i2));
                sb.append(this.r.C(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.r.e0(i2, this.s);
            accessibilityNodeInfoCompat.setBoundsInParent(this.s);
        }
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a */
        float f7723a;

        /* renamed from: b */
        float f7724b;

        /* renamed from: c */
        ArrayList<Float> f7725c;

        /* renamed from: d */
        float f7726d;

        /* renamed from: e */
        boolean f7727e;

        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public d createFromParcel(@NonNull Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        /* synthetic */ d(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f7723a);
            parcel.writeFloat(this.f7724b);
            parcel.writeList(this.f7725c);
            parcel.writeFloat(this.f7726d);
            parcel.writeBooleanArray(new boolean[]{this.f7727e});
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        private d(@NonNull Parcel parcel) {
            super(parcel);
            this.f7723a = parcel.readFloat();
            this.f7724b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f7725c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f7726d = parcel.readFloat();
            this.f7727e = parcel.createBooleanArray()[0];
        }
    }

    private interface e {
        com.google.android.material.l.a a();
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private void A(int i2) {
        if (i2 == 1) {
            L(Integer.MAX_VALUE);
            return;
        }
        if (i2 == 2) {
            L(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            M(Integer.MAX_VALUE);
        } else {
            if (i2 != 66) {
                return;
            }
            M(Integer.MIN_VALUE);
        }
    }

    public String C(float f2) {
        if (F()) {
            return this.J.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    private float D(int i2, float f2) {
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return MathUtils.clamp(f2, i4 < 0 ? this.L : this.N.get(i4).floatValue(), i3 >= this.N.size() ? this.M : this.N.get(i3).floatValue());
    }

    @ColorInt
    private int E(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private void G() {
        this.l.setStrokeWidth(this.B);
        this.m.setStrokeWidth(this.B);
        this.p.setStrokeWidth(this.B / 2.0f);
        this.q.setStrokeWidth(this.B / 2.0f);
    }

    private boolean H() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void J(@NonNull Resources resources) {
        this.z = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        this.C = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.D = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.G = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void K(@NonNull Canvas canvas, int i2, int i3) {
        if (Z()) {
            int N = (int) (this.C + (N(this.N.get(this.P).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.F;
                canvas.clipRect(N - i4, i3 - i4, N + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(N, i3, this.F, this.o);
        }
    }

    private boolean L(int i2) {
        int i3 = this.P;
        int clamp = (int) MathUtils.clamp(i3 + i2, 0L, this.N.size() - 1);
        this.P = clamp;
        if (clamp == i3) {
            return false;
        }
        if (this.O != -1) {
            this.O = clamp;
        }
        f0();
        postInvalidate();
        return true;
    }

    private boolean M(int i2) {
        if (I()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return L(i2);
    }

    private float N(float f2) {
        float f3 = this.L;
        float f4 = (f2 - f3) / (this.M - f3);
        return I() ? 1.0f - f4 : f4;
    }

    private Boolean O(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(L(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(L(-1)) : Boolean.FALSE;
        }
        if (i2 != 66) {
            if (i2 != 81) {
                if (i2 == 69) {
                    L(-1);
                    return Boolean.TRUE;
                }
                if (i2 != 70) {
                    switch (i2) {
                        case 21:
                            M(-1);
                            break;
                        case 22:
                            M(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            L(1);
            return Boolean.TRUE;
        }
        this.O = this.P;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void P() {
        Iterator<T> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void Q() {
        Iterator<T> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    @NonNull
    public static com.google.android.material.l.a R(@NonNull Context context, @NonNull TypedArray typedArray) {
        return com.google.android.material.l.a.U0(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int T(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    private void U(Context context, AttributeSet attributeSet, int i2) {
        TypedArray j2 = n.j(context, attributeSet, R.styleable.Slider, i2, k, new int[0]);
        this.L = j2.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.M = j2.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.L));
        this.Q = j2.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i3 = R.styleable.Slider_trackColor;
        boolean hasValue = j2.hasValue(i3);
        int i4 = hasValue ? i3 : R.styleable.Slider_trackColorInactive;
        if (!hasValue) {
            i3 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList a2 = com.google.android.material.g.c.a(context, j2, i4);
        if (a2 == null) {
            a2 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a2);
        ColorStateList a3 = com.google.android.material.g.c.a(context, j2, i3);
        if (a3 == null) {
            a3 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a3);
        this.e0.n0(com.google.android.material.g.c.a(context, j2, R.styleable.Slider_thumbColor));
        ColorStateList a4 = com.google.android.material.g.c.a(context, j2, R.styleable.Slider_haloColor);
        if (a4 == null) {
            a4 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(a4);
        int i5 = R.styleable.Slider_tickColor;
        boolean hasValue2 = j2.hasValue(i5);
        int i6 = hasValue2 ? i5 : R.styleable.Slider_tickColorInactive;
        if (!hasValue2) {
            i5 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList a5 = com.google.android.material.g.c.a(context, j2, i6);
        if (a5 == null) {
            a5 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a5);
        ColorStateList a6 = com.google.android.material.g.c.a(context, j2, i5);
        if (a6 == null) {
            a6 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a6);
        setThumbRadius(j2.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(j2.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(j2.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(j2.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.A = j2.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!j2.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        j2.recycle();
    }

    private void X(int i2) {
        BaseSlider<S, L, T>.b bVar = this.t;
        if (bVar == null) {
            this.t = new b(this, null);
        } else {
            removeCallbacks(bVar);
        }
        this.t.a(i2);
        postDelayed(this.t, 200L);
    }

    private void Y(com.google.android.material.l.a aVar, float f2) {
        aVar.k1(C(f2));
        int N = (this.C + ((int) (N(f2) * this.S))) - (aVar.getIntrinsicWidth() / 2);
        int o = o() - (this.G + this.E);
        aVar.setBounds(N, o - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + N, o);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.c(u.e(this), this, rect);
        aVar.setBounds(rect);
        u.f(this).add(aVar);
    }

    private boolean Z() {
        return this.T || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private boolean a0(float f2) {
        return c0(this.O, f2);
    }

    private double b0(float f2) {
        float f3 = this.Q;
        if (f3 <= 0.0f) {
            return f2;
        }
        int i2 = (int) ((this.M - this.L) / f3);
        double round = Math.round(f2 * i2);
        double d2 = i2;
        Double.isNaN(round);
        Double.isNaN(d2);
        return round / d2;
    }

    public boolean c0(int i2, float f2) {
        if (Math.abs(f2 - this.N.get(i2).floatValue()) < f7717j) {
            return false;
        }
        this.N.set(i2, Float.valueOf(D(i2, f2)));
        this.P = i2;
        t(i2);
        return true;
    }

    private boolean d0() {
        return a0(getValueOfTouchPosition());
    }

    public void f0() {
        if (Z() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int N = (int) ((N(this.N.get(this.P).floatValue()) * this.S) + this.C);
            int o = o();
            int i2 = this.F;
            DrawableCompat.setHotspotBounds(background, N - i2, o - i2, N + i2, o + i2);
        }
    }

    private void g0() {
        if (this.V) {
            i0();
            j0();
            h0();
            k0();
            n0();
            this.V = false;
        }
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.N.size() == 1) {
            floatValue2 = this.L;
        }
        float N = N(floatValue2);
        float N2 = N(floatValue);
        return I() ? new float[]{N2, N} : new float[]{N, N2};
    }

    private float getValueOfTouchPosition() {
        double b0 = b0(this.f0);
        if (I()) {
            b0 = 1.0d - b0;
        }
        float f2 = this.M;
        float f3 = this.L;
        double d2 = f2 - f3;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        return (float) ((b0 * d2) + d3);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.f0;
        if (I()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.M;
        float f4 = this.L;
        return (f2 * (f3 - f4)) + f4;
    }

    private void h0() {
        if (this.Q > 0.0f && !l0(this.M)) {
            throw new IllegalStateException(String.format(f7713f, Float.toString(this.Q), Float.toString(this.L), Float.toString(this.M)));
        }
    }

    private void i0() {
        if (this.L >= this.M) {
            throw new IllegalStateException(String.format(f7711d, Float.toString(this.L), Float.toString(this.M)));
        }
    }

    private void j(com.google.android.material.l.a aVar) {
        aVar.j1(u.e(this));
    }

    private void j0() {
        if (this.M <= this.L) {
            throw new IllegalStateException(String.format(f7712e, Float.toString(this.M), Float.toString(this.L)));
        }
    }

    private Float k(int i2) {
        float m = this.U ? m(20) : l();
        if (i2 == 21) {
            if (!I()) {
                m = -m;
            }
            return Float.valueOf(m);
        }
        if (i2 == 22) {
            if (I()) {
                m = -m;
            }
            return Float.valueOf(m);
        }
        if (i2 == 69) {
            return Float.valueOf(-m);
        }
        if (i2 == 70 || i2 == 81) {
            return Float.valueOf(m);
        }
        return null;
    }

    private void k0() {
        Iterator<Float> it = this.N.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.L || next.floatValue() > this.M) {
                throw new IllegalStateException(String.format(f7709b, Float.toString(next.floatValue()), Float.toString(this.L), Float.toString(this.M)));
            }
            if (this.Q > 0.0f && !l0(next.floatValue())) {
                throw new IllegalStateException(String.format(f7710c, Float.toString(next.floatValue()), Float.toString(this.L), Float.toString(this.Q), Float.toString(this.Q)));
            }
        }
    }

    private float l() {
        float f2 = this.Q;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private boolean l0(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.L))).divide(new BigDecimal(Float.toString(this.Q)), MathContext.DECIMAL64).doubleValue();
        double round = Math.round(doubleValue);
        Double.isNaN(round);
        return Math.abs(round - doubleValue) < f7717j;
    }

    public float m(int i2) {
        float l = l();
        return (this.M - this.L) / l <= i2 ? l : Math.round(r1 / r4) * l;
    }

    private float m0(float f2) {
        return (N(f2) * this.S) + this.C;
    }

    private void n() {
        g0();
        int min = Math.min((int) (((this.M - this.L) / this.Q) + 1.0f), (this.S / (this.B * 2)) + 1);
        float[] fArr = this.R;
        if (fArr == null || fArr.length != min * 2) {
            this.R = new float[min * 2];
        }
        float f2 = this.S / (min - 1);
        for (int i2 = 0; i2 < min * 2; i2 += 2) {
            float[] fArr2 = this.R;
            fArr2[i2] = this.C + ((i2 / 2) * f2);
            fArr2[i2 + 1] = o();
        }
    }

    private void n0() {
        float f2 = this.Q;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            Log.w(f7708a, String.format(f7714g, "stepSize", Float.valueOf(f2)));
        }
        float f3 = this.L;
        if (((int) f3) != f3) {
            Log.w(f7708a, String.format(f7714g, "valueFrom", Float.valueOf(f3)));
        }
        float f4 = this.M;
        if (((int) f4) != f4) {
            Log.w(f7708a, String.format(f7714g, "valueTo", Float.valueOf(f4)));
        }
    }

    private int o() {
        return this.D + (this.A == 1 ? this.v.get(0).getIntrinsicHeight() : 0);
    }

    private void r() {
        if (this.v.size() > this.N.size()) {
            List<com.google.android.material.l.a> subList = this.v.subList(this.N.size(), this.v.size());
            for (com.google.android.material.l.a aVar : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    s(aVar);
                }
            }
            subList.clear();
        }
        while (this.v.size() < this.N.size()) {
            com.google.android.material.l.a a2 = this.u.a();
            this.v.add(a2);
            if (ViewCompat.isAttachedToWindow(this)) {
                j(a2);
            }
        }
        int i2 = this.v.size() == 1 ? 0 : 1;
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        while (it.hasNext()) {
            it.next().H0(i2);
        }
    }

    private void s(com.google.android.material.l.a aVar) {
        t f2 = u.f(this);
        if (f2 != null) {
            f2.remove(aVar);
            aVar.W0(u.e(this));
        }
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.N.size() == arrayList.size() && this.N.equals(arrayList)) {
            return;
        }
        this.N = arrayList;
        this.V = true;
        this.P = 0;
        f0();
        r();
        u();
        postInvalidate();
    }

    private void t(int i2) {
        Iterator<L> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.N.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.s;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        X(i2);
    }

    private void u() {
        for (L l : this.w) {
            Iterator<Float> it = this.N.iterator();
            while (it.hasNext()) {
                l.a(this, it.next().floatValue(), false);
            }
        }
    }

    private void v(@NonNull Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.C;
        float f2 = i2;
        float f3 = i3;
        canvas.drawLine(i4 + (activeRange[0] * f2), f3, i4 + (activeRange[1] * f2), f3, this.m);
    }

    private void w(@NonNull Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        float f2 = i2;
        float f3 = this.C + (activeRange[1] * f2);
        if (f3 < r1 + i2) {
            float f4 = i3;
            canvas.drawLine(f3, f4, r1 + i2, f4, this.l);
        }
        int i4 = this.C;
        float f5 = i4 + (activeRange[0] * f2);
        if (f5 > i4) {
            float f6 = i3;
            canvas.drawLine(i4, f6, f5, f6, this.l);
        }
    }

    private void x(@NonNull Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it = this.N.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.C + (N(it.next().floatValue()) * i2), i3, this.E, this.n);
            }
        }
        Iterator<Float> it2 = this.N.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            canvas.save();
            int N = this.C + ((int) (N(next.floatValue()) * i2));
            int i4 = this.E;
            canvas.translate(N - i4, i3 - i4);
            this.e0.draw(canvas);
            canvas.restore();
        }
    }

    private void y(@NonNull Canvas canvas) {
        float[] activeRange = getActiveRange();
        int T = T(this.R, activeRange[0]);
        int T2 = T(this.R, activeRange[1]);
        int i2 = T * 2;
        canvas.drawPoints(this.R, 0, i2, this.p);
        int i3 = T2 * 2;
        canvas.drawPoints(this.R, i2, i3 - i2, this.q);
        float[] fArr = this.R;
        canvas.drawPoints(fArr, i3, fArr.length - i3, this.p);
    }

    private void z() {
        if (this.A == 2) {
            return;
        }
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        for (int i2 = 0; i2 < this.N.size() && it.hasNext(); i2++) {
            if (i2 != this.P) {
                Y(it.next(), this.N.get(i2).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.v.size()), Integer.valueOf(this.N.size())));
        }
        Y(it.next(), this.N.get(this.P).floatValue());
    }

    @VisibleForTesting
    void B(boolean z) {
        this.T = z;
    }

    public boolean F() {
        return this.J != null;
    }

    final boolean I() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    protected boolean S() {
        if (this.O != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float m0 = m0(valueOfTouchPositionAbsolute);
        this.O = 0;
        float abs = Math.abs(this.N.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.N.size(); i2++) {
            float abs2 = Math.abs(this.N.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float m02 = m0(this.N.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z = !I() ? m02 - m0 >= 0.0f : m02 - m0 <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.O = i2;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(m02 - m0) < this.y) {
                        this.O = -1;
                        return false;
                    }
                    if (z) {
                        this.O = i2;
                    }
                }
            }
            abs = abs2;
        }
        return this.O != -1;
    }

    public void V(@NonNull L l) {
        this.w.remove(l);
    }

    public void W(@NonNull T t) {
        this.x.remove(t);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.r.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.l.setColor(E(this.d0));
        this.m.setColor(E(this.c0));
        this.p.setColor(E(this.b0));
        this.q.setColor(E(this.a0));
        for (com.google.android.material.l.a aVar : this.v) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.e0.isStateful()) {
            this.e0.setState(getDrawableState());
        }
        this.o.setColor(E(this.W));
        this.o.setAlpha(63);
    }

    void e0(int i2, Rect rect) {
        int N = this.C + ((int) (N(getValues().get(i2).floatValue()) * this.S));
        int o = o();
        int i3 = this.E;
        rect.set(N - i3, o - i3, N + i3, o + i3);
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.r.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.O;
    }

    public int getFocusedThumbIndex() {
        return this.P;
    }

    @Dimension
    public int getHaloRadius() {
        return this.F;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.W;
    }

    public int getLabelBehavior() {
        return this.A;
    }

    public float getStepSize() {
        return this.Q;
    }

    public float getThumbElevation() {
        return this.e0.x();
    }

    @Dimension
    public int getThumbRadius() {
        return this.E;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.e0.y();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.a0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.b0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.b0.equals(this.a0)) {
            return this.a0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.c0;
    }

    @Dimension
    public int getTrackHeight() {
        return this.B;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.d0;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.C;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.d0.equals(this.c0)) {
            return this.c0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.S;
    }

    public float getValueFrom() {
        return this.L;
    }

    public float getValueTo() {
        return this.M;
    }

    @NonNull
    List<Float> getValues() {
        return new ArrayList(this.N);
    }

    public void h(@Nullable L l) {
        this.w.add(l);
    }

    public void i(@NonNull T t) {
        this.x.add(t);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        while (it.hasNext()) {
            j(it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.b bVar = this.t;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.V) {
            g0();
            if (this.Q > 0.0f) {
                n();
            }
        }
        super.onDraw(canvas);
        int o = o();
        w(canvas, this.S, o);
        if (((Float) Collections.max(getValues())).floatValue() > this.L) {
            v(canvas, this.S, o);
        }
        if (this.Q > 0.0f) {
            y(canvas);
        }
        if ((this.K || isFocused()) && isEnabled()) {
            K(canvas, this.S, o);
            if (this.O != -1) {
                z();
            }
        }
        x(canvas, this.S, o);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z) {
            A(i2);
            this.r.requestKeyboardFocusForVirtualView(this.P);
            return;
        }
        this.O = -1;
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        while (it.hasNext()) {
            u.f(this).remove(it.next());
        }
        this.r.clearKeyboardFocusForVirtualView(this.P);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.N.size() == 1) {
            this.O = 0;
        }
        if (this.O == -1) {
            Boolean O = O(i2, keyEvent);
            return O != null ? O.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.U |= keyEvent.isLongPress();
        Float k2 = k(i2);
        if (k2 != null) {
            if (a0(this.N.get(this.O).floatValue() + k2.floatValue())) {
                f0();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return L(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return L(-1);
                }
                return false;
            }
            if (i2 != 66) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        this.O = -1;
        Iterator<com.google.android.material.l.a> it = this.v.iterator();
        while (it.hasNext()) {
            u.f(this).remove(it.next());
        }
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.U = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.z + (this.A == 1 ? this.v.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.L = dVar.f7723a;
        this.M = dVar.f7724b;
        setValuesInternal(dVar.f7725c);
        this.Q = dVar.f7726d;
        if (dVar.f7727e) {
            requestFocus();
        }
        u();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f7723a = this.L;
        dVar.f7724b = this.M;
        dVar.f7725c = new ArrayList<>(this.N);
        dVar.f7726d = this.Q;
        dVar.f7727e = hasFocus();
        return dVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.S = Math.max(i2 - (this.C * 2), 0);
        if (this.Q > 0.0f) {
            n();
        }
        f0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f2 = (x - this.C) / this.S;
        this.f0 = f2;
        float max = Math.max(0.0f, f2);
        this.f0 = max;
        this.f0 = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.H = x;
            if (!H()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (S()) {
                    requestFocus();
                    this.K = true;
                    d0();
                    f0();
                    invalidate();
                    P();
                }
            }
        } else if (actionMasked == 1) {
            this.K = false;
            MotionEvent motionEvent2 = this.I;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.I.getX() - motionEvent.getX()) <= this.y && Math.abs(this.I.getY() - motionEvent.getY()) <= this.y) {
                S();
            }
            if (this.O != -1) {
                d0();
                this.O = -1;
            }
            Iterator<com.google.android.material.l.a> it = this.v.iterator();
            while (it.hasNext()) {
                u.f(this).remove(it.next());
            }
            Q();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.K) {
                if (Math.abs(x - this.H) < this.y) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                P();
            }
            if (S()) {
                this.K = true;
                d0();
                f0();
                invalidate();
            }
        }
        setPressed(this.K);
        this.I = MotionEvent.obtain(motionEvent);
        return true;
    }

    public void p() {
        this.w.clear();
    }

    public void q() {
        this.x.clear();
    }

    protected void setActiveThumbIndex(int i2) {
        this.O = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.N.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.P = i2;
        this.r.requestKeyboardFocusForVirtualView(i2);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.F) {
            return;
        }
        this.F = i2;
        Drawable background = getBackground();
        if (Z() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            com.google.android.material.d.a.b((RippleDrawable) background, this.F);
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.W)) {
            return;
        }
        this.W = colorStateList;
        Drawable background = getBackground();
        if (!Z() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.o.setColor(E(colorStateList));
        this.o.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.A != i2) {
            this.A = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.d dVar) {
        this.J = dVar;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format(f7713f, Float.toString(f2), Float.toString(this.L), Float.toString(this.M)));
        }
        if (this.Q != f2) {
            this.Q = f2;
            this.V = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.e0.m0(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.E) {
            return;
        }
        this.E = i2;
        this.e0.setShapeAppearanceModel(o.a().q(0, this.E).m());
        j jVar = this.e0;
        int i3 = this.E;
        jVar.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        this.e0.n0(colorStateList);
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.a0)) {
            return;
        }
        this.a0 = colorStateList;
        this.q.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.b0)) {
            return;
        }
        this.b0 = colorStateList;
        this.p.setColor(E(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.c0)) {
            return;
        }
        this.c0 = colorStateList;
        this.m.setColor(E(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.B != i2) {
            this.B = i2;
            G();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.d0)) {
            return;
        }
        this.d0 = colorStateList;
        this.l.setColor(E(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.L = f2;
        this.V = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.M = f2;
        this.V = true;
        postInvalidate();
    }

    void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    private class b implements Runnable {

        /* renamed from: a */
        int f7721a;

        private b() {
            this.f7721a = -1;
        }

        void a(int i2) {
            this.f7721a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.r.sendEventForVirtualView(this.f7721a, 4);
        }

        /* synthetic */ b(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, k), attributeSet, i2);
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.K = false;
        this.N = new ArrayList<>();
        this.O = -1;
        this.P = -1;
        this.Q = 0.0f;
        this.U = false;
        j jVar = new j();
        this.e0 = jVar;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.l = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.m = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.n = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.o = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.p = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.q = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        J(context2.getResources());
        this.u = new a(attributeSet, i2);
        U(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        jVar.w0(2);
        this.y = ViewConfiguration.get(context2).getScaledTouchSlop();
        c cVar = new c(this);
        this.r = cVar;
        ViewCompat.setAccessibilityDelegate(this, cVar);
        this.s = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}
