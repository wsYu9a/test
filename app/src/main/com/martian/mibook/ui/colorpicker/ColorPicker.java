package com.martian.mibook.ui.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.martian.mibook.R;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public class ColorPicker extends View {
    public static final String J = "parent";
    public static final String K = "angle";
    public static final String L = "color";
    public static final String M = "showColor";
    public static final int[] N = {SupportMenu.CATEGORY_MASK, -65281, -16776961, -16711681, -16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
    public Paint A;
    public final float[] B;
    public SaturationBar C;
    public boolean D;
    public ValueBar E;
    public a F;
    public b G;
    public int H;
    public int I;

    /* renamed from: b */
    public Paint f15909b;

    /* renamed from: c */
    public Paint f15910c;

    /* renamed from: d */
    public Paint f15911d;

    /* renamed from: e */
    public int f15912e;

    /* renamed from: f */
    public int f15913f;

    /* renamed from: g */
    public int f15914g;

    /* renamed from: h */
    public int f15915h;

    /* renamed from: i */
    public int f15916i;

    /* renamed from: j */
    public int f15917j;

    /* renamed from: k */
    public int f15918k;

    /* renamed from: l */
    public int f15919l;

    /* renamed from: m */
    public int f15920m;

    /* renamed from: n */
    public final RectF f15921n;

    /* renamed from: o */
    public final RectF f15922o;

    /* renamed from: p */
    public boolean f15923p;

    /* renamed from: q */
    public int f15924q;

    /* renamed from: r */
    public int f15925r;

    /* renamed from: s */
    public boolean f15926s;

    /* renamed from: t */
    public int f15927t;

    /* renamed from: u */
    public float f15928u;

    /* renamed from: v */
    public float f15929v;

    /* renamed from: w */
    public float f15930w;

    /* renamed from: x */
    public float f15931x;

    /* renamed from: y */
    public Paint f15932y;

    /* renamed from: z */
    public Paint f15933z;

    public interface a {
        void a(int i10);
    }

    public interface b {
        void a(int i10);
    }

    public ColorPicker(Context context) {
        super(context);
        this.f15921n = new RectF();
        this.f15922o = new RectF();
        this.f15923p = false;
        this.B = new float[3];
        this.C = null;
        this.D = true;
        this.E = null;
        k(null, 0);
    }

    public void a(SaturationBar saturationBar) {
        this.C = saturationBar;
        saturationBar.setColorPicker(this);
        this.C.setColor(this.f15924q);
    }

    public void b(ValueBar valueBar) {
        this.E = valueBar;
        valueBar.setColorPicker(this);
        this.E.setColor(this.f15924q);
    }

    public final int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }

    public final int d(float f10) {
        float f11 = (float) (f10 / 6.283185307179586d);
        if (f11 < 0.0f) {
            f11 += 1.0f;
        }
        if (f11 <= 0.0f) {
            int i10 = N[0];
            this.f15924q = i10;
            return i10;
        }
        if (f11 >= 1.0f) {
            int[] iArr = N;
            this.f15924q = iArr[iArr.length - 1];
            return iArr[iArr.length - 1];
        }
        int[] iArr2 = N;
        float length = f11 * (iArr2.length - 1);
        int i11 = (int) length;
        float f12 = length - i11;
        int i12 = iArr2[i11];
        int i13 = iArr2[i11 + 1];
        int c10 = c(Color.alpha(i12), Color.alpha(i13), f12);
        int c11 = c(Color.red(i12), Color.red(i13), f12);
        int c12 = c(Color.green(i12), Color.green(i13), f12);
        int c13 = c(Color.blue(i12), Color.blue(i13), f12);
        this.f15924q = Color.argb(c10, c11, c12, c13);
        return Color.argb(c10, c11, c12, c13);
    }

    public final float[] e(float f10) {
        double d10 = f10;
        return new float[]{(float) (this.f15913f * Math.cos(d10)), (float) (this.f15913f * Math.sin(d10))};
    }

    public void f(int i10) {
        SaturationBar saturationBar = this.C;
        if (saturationBar != null) {
            saturationBar.setColor(i10);
        }
    }

    public void g(int i10) {
        ValueBar valueBar = this.E;
        if (valueBar != null) {
            valueBar.setColor(i10);
        }
    }

    public int getColor() {
        return this.f15927t;
    }

    public int getOldCenterColor() {
        return this.f15925r;
    }

    public a getOnColorChangedListener() {
        return this.F;
    }

    public b getOnColorSelectedListener() {
        return this.G;
    }

    public boolean getShowOldCenterColor() {
        return this.f15926s;
    }

    public boolean getTouchAnywhereOnColorWheel() {
        return this.D;
    }

    public final float h(int i10) {
        Color.colorToHSV(i10, new float[3]);
        return (float) Math.toRadians(-r0[0]);
    }

    public boolean i() {
        return this.C != null;
    }

    public boolean j() {
        return this.E != null;
    }

    public final void k(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPicker, i10, 0);
        Resources resources = getContext().getResources();
        this.f15912e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_wheel_thickness, resources.getDimensionPixelSize(R.dimen.color_wheel_thickness));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_wheel_radius, resources.getDimensionPixelSize(R.dimen.color_wheel_radius));
        this.f15913f = dimensionPixelSize;
        this.f15914g = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_center_radius, resources.getDimensionPixelSize(R.dimen.color_center_radius));
        this.f15915h = dimensionPixelSize2;
        this.f15916i = dimensionPixelSize2;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_center_halo_radius, resources.getDimensionPixelSize(R.dimen.color_center_halo_radius));
        this.f15917j = dimensionPixelSize3;
        this.f15918k = dimensionPixelSize3;
        this.f15919l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_pointer_radius, resources.getDimensionPixelSize(R.dimen.color_pointer_radius));
        this.f15920m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_color_pointer_halo_radius, resources.getDimensionPixelSize(R.dimen.color_pointer_halo_radius));
        obtainStyledAttributes.recycle();
        this.f15931x = -1.5707964f;
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, N, (float[]) null);
        Paint paint = new Paint(1);
        this.f15909b = paint;
        paint.setShader(sweepGradient);
        this.f15909b.setStyle(Paint.Style.STROKE);
        this.f15909b.setStrokeWidth(this.f15912e);
        Paint paint2 = new Paint(1);
        this.f15910c = paint2;
        paint2.setColor(-16777216);
        this.f15910c.setAlpha(80);
        Paint paint3 = new Paint(1);
        this.f15911d = paint3;
        paint3.setColor(d(this.f15931x));
        Paint paint4 = new Paint(1);
        this.f15933z = paint4;
        paint4.setColor(d(this.f15931x));
        Paint paint5 = this.f15933z;
        Paint.Style style = Paint.Style.FILL;
        paint5.setStyle(style);
        Paint paint6 = new Paint(1);
        this.f15932y = paint6;
        paint6.setColor(d(this.f15931x));
        this.f15932y.setStyle(style);
        Paint paint7 = new Paint(1);
        this.A = paint7;
        paint7.setColor(-16777216);
        this.A.setAlpha(0);
        this.f15927t = d(this.f15931x);
        this.f15925r = d(this.f15931x);
        this.f15926s = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = this.f15928u;
        canvas.translate(f10, f10);
        canvas.drawOval(this.f15921n, this.f15909b);
        float[] e10 = e(this.f15931x);
        canvas.drawCircle(e10[0], e10[1], this.f15920m, this.f15910c);
        canvas.drawCircle(e10[0], e10[1], this.f15919l, this.f15911d);
        canvas.drawCircle(0.0f, 0.0f, this.f15917j, this.A);
        if (!this.f15926s) {
            canvas.drawArc(this.f15922o, 0.0f, 360.0f, true, this.f15933z);
        } else {
            canvas.drawArc(this.f15922o, 90.0f, 180.0f, true, this.f15932y);
            canvas.drawArc(this.f15922o, 270.0f, 180.0f, true, this.f15933z);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = (this.f15914g + this.f15920m) * 2;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i12, size) : i12;
        }
        if (mode2 == 1073741824) {
            i12 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size2);
        }
        int min = Math.min(size, i12);
        setMeasuredDimension(min, min);
        this.f15928u = min * 0.5f;
        int i13 = ((min / 2) - this.f15912e) - this.f15920m;
        this.f15913f = i13;
        this.f15921n.set(-i13, -i13, i13, i13);
        float f10 = this.f15916i;
        int i14 = this.f15913f;
        int i15 = this.f15914g;
        int i16 = (int) (f10 * (i14 / i15));
        this.f15915h = i16;
        this.f15917j = (int) (this.f15918k * (i14 / i15));
        this.f15922o.set(-i16, -i16, i16, i16);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("parent"));
        this.f15931x = bundle.getFloat(K);
        setOldCenterColor(bundle.getInt("color"));
        this.f15926s = bundle.getBoolean(M);
        int d10 = d(this.f15931x);
        this.f15911d.setColor(d10);
        setNewCenterColor(d10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", onSaveInstanceState);
        bundle.putFloat(K, this.f15931x);
        bundle.putInt("color", this.f15925r);
        bundle.putBoolean(M, this.f15926s);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        b bVar;
        int i11;
        getParent().requestDisallowInterceptTouchEvent(true);
        float x10 = motionEvent.getX() - this.f15928u;
        float y10 = motionEvent.getY() - this.f15928u;
        int action = motionEvent.getAction();
        if (action == 0) {
            float[] e10 = e(this.f15931x);
            double sqrt = Math.sqrt((x10 * x10) + (y10 * y10));
            float f10 = e10[0];
            int i12 = this.f15920m;
            if (x10 >= f10 - i12 && x10 <= i12 + f10) {
                float f11 = e10[1];
                if (y10 >= f11 - i12 && y10 <= i12 + f11) {
                    this.f15929v = x10 - f10;
                    this.f15930w = y10 - f11;
                    this.f15923p = true;
                    invalidate();
                }
            }
            int i13 = this.f15915h;
            if (x10 < (-i13) || x10 > i13 || y10 < (-i13) || y10 > i13 || !this.f15926s) {
                int i14 = this.f15913f;
                if (sqrt > i14 + i12 || sqrt < i14 - i12 || !this.D) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                this.f15923p = true;
                invalidate();
            } else {
                this.A.setAlpha(80);
                setColor(getOldCenterColor());
                invalidate();
            }
        } else if (action == 1) {
            this.f15923p = false;
            this.A.setAlpha(0);
            b bVar2 = this.G;
            if (bVar2 != null && (i10 = this.f15927t) != this.I) {
                bVar2.a(i10);
                this.I = this.f15927t;
            }
            invalidate();
        } else if (action != 2) {
            if (action == 3 && (bVar = this.G) != null && (i11 = this.f15927t) != this.I) {
                bVar.a(i11);
                this.I = this.f15927t;
            }
        } else {
            if (!this.f15923p) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            float atan2 = (float) Math.atan2(y10 - this.f15930w, x10 - this.f15929v);
            this.f15931x = atan2;
            this.f15911d.setColor(d(atan2));
            int d10 = d(this.f15931x);
            this.f15927t = d10;
            setNewCenterColor(d10);
            ValueBar valueBar = this.E;
            if (valueBar != null) {
                valueBar.setColor(this.f15924q);
            }
            SaturationBar saturationBar = this.C;
            if (saturationBar != null) {
                saturationBar.setColor(this.f15924q);
            }
            invalidate();
        }
        return true;
    }

    public void setColor(int i10) {
        float h10 = h(i10);
        this.f15931x = h10;
        this.f15911d.setColor(d(h10));
        if (this.C != null) {
            Color.colorToHSV(i10, this.B);
            this.C.setColor(this.f15924q);
            this.C.setSaturation(this.B[1]);
        }
        ValueBar valueBar = this.E;
        if (valueBar != null && this.C == null) {
            Color.colorToHSV(i10, this.B);
            this.E.setColor(this.f15924q);
            this.E.setValue(this.B[2]);
        } else if (valueBar != null) {
            Color.colorToHSV(i10, this.B);
            this.E.setValue(this.B[2]);
        }
        setNewCenterColor(i10);
    }

    public void setNewCenterColor(int i10) {
        this.f15927t = i10;
        this.f15933z.setColor(i10);
        if (this.f15925r == 0) {
            this.f15925r = i10;
            this.f15932y.setColor(i10);
        }
        a aVar = this.F;
        if (aVar != null && i10 != this.H) {
            aVar.a(i10);
            this.H = i10;
        }
        invalidate();
    }

    public void setOldCenterColor(int i10) {
        this.f15925r = i10;
        this.f15932y.setColor(i10);
        invalidate();
    }

    public void setOnColorChangedListener(a aVar) {
        this.F = aVar;
    }

    public void setOnColorSelectedListener(b bVar) {
        this.G = bVar;
    }

    public void setShowOldCenterColor(boolean z10) {
        this.f15926s = z10;
        invalidate();
    }

    public void setTouchAnywhereOnColorWheelEnabled(boolean z10) {
        this.D = z10;
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15921n = new RectF();
        this.f15922o = new RectF();
        this.f15923p = false;
        this.B = new float[3];
        this.C = null;
        this.D = true;
        this.E = null;
        k(attributeSet, 0);
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15921n = new RectF();
        this.f15922o = new RectF();
        this.f15923p = false;
        this.B = new float[3];
        this.C = null;
        this.D = true;
        this.E = null;
        k(attributeSet, i10);
    }
}
