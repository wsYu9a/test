package com.martian.mibook.ui.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.martian.mibook.R;
import com.vivo.advv.Color;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes4.dex */
public class ColorPicker extends View {

    /* renamed from: a */
    private static final String f14197a = "parent";

    /* renamed from: b */
    private static final String f14198b = "angle";

    /* renamed from: c */
    private static final String f14199c = "color";

    /* renamed from: d */
    private static final String f14200d = "showColor";

    /* renamed from: e */
    private static final int[] f14201e = {-65536, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, -256, -65536};
    private float A;
    private float B;
    private Paint C;
    private Paint D;
    private Paint E;
    private final float[] F;
    private SaturationBar G;
    private boolean H;
    private ValueBar I;
    private a J;
    private b K;
    private int L;
    private int M;

    /* renamed from: f */
    private Paint f14202f;

    /* renamed from: g */
    private Paint f14203g;

    /* renamed from: h */
    private Paint f14204h;

    /* renamed from: i */
    private int f14205i;

    /* renamed from: j */
    private int f14206j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final RectF r;
    private final RectF s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private int x;
    private float y;
    private float z;

    public interface a {
        void a(int color);
    }

    public interface b {
        void a(int color);
    }

    public ColorPicker(Context context) {
        super(context);
        this.r = new RectF();
        this.s = new RectF();
        this.t = false;
        this.F = new float[3];
        this.G = null;
        this.H = true;
        this.I = null;
        k(null, 0);
    }

    private int c(int s, int d2, float p) {
        return s + Math.round(p * (d2 - s));
    }

    private int d(float angle) {
        double d2 = angle;
        Double.isNaN(d2);
        float f2 = (float) (d2 / 6.283185307179586d);
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        if (f2 <= 0.0f) {
            int[] iArr = f14201e;
            this.u = iArr[0];
            return iArr[0];
        }
        if (f2 >= 1.0f) {
            int[] iArr2 = f14201e;
            this.u = iArr2[iArr2.length - 1];
            return iArr2[iArr2.length - 1];
        }
        int[] iArr3 = f14201e;
        float length = f2 * (iArr3.length - 1);
        int i2 = (int) length;
        float f3 = length - i2;
        int i3 = iArr3[i2];
        int i4 = iArr3[i2 + 1];
        int c2 = c(android.graphics.Color.alpha(i3), android.graphics.Color.alpha(i4), f3);
        int c3 = c(android.graphics.Color.red(i3), android.graphics.Color.red(i4), f3);
        int c4 = c(android.graphics.Color.green(i3), android.graphics.Color.green(i4), f3);
        int c5 = c(android.graphics.Color.blue(i3), android.graphics.Color.blue(i4), f3);
        this.u = android.graphics.Color.argb(c2, c3, c4, c5);
        return android.graphics.Color.argb(c2, c3, c4, c5);
    }

    private float[] e(float angle) {
        double d2 = this.f14206j;
        double d3 = angle;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        float f2 = (float) (d2 * cos);
        double d4 = this.f14206j;
        double sin = Math.sin(d3);
        Double.isNaN(d4);
        return new float[]{f2, (float) (d4 * sin)};
    }

    private float h(int color) {
        android.graphics.Color.colorToHSV(color, new float[3]);
        return (float) Math.toRadians(-r0[0]);
    }

    private void k(AttributeSet attrs, int defStyle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ColorPicker, defStyle, 0);
        Resources resources = getContext().getResources();
        this.f14205i = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_wheel_thickness));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_wheel_radius));
        this.f14206j = dimensionPixelSize;
        this.k = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_center_radius));
        this.l = dimensionPixelSize2;
        this.m = dimensionPixelSize2;
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_center_halo_radius));
        this.n = dimensionPixelSize3;
        this.o = dimensionPixelSize3;
        this.p = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_pointer_radius));
        this.q = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.color_pointer_halo_radius));
        obtainStyledAttributes.recycle();
        this.B = -1.5707964f;
        SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, f14201e, (float[]) null);
        Paint paint = new Paint(1);
        this.f14202f = paint;
        paint.setShader(sweepGradient);
        this.f14202f.setStyle(Paint.Style.STROKE);
        this.f14202f.setStrokeWidth(this.f14205i);
        Paint paint2 = new Paint(1);
        this.f14203g = paint2;
        paint2.setColor(-16777216);
        this.f14203g.setAlpha(80);
        Paint paint3 = new Paint(1);
        this.f14204h = paint3;
        paint3.setColor(d(this.B));
        Paint paint4 = new Paint(1);
        this.D = paint4;
        paint4.setColor(d(this.B));
        this.D.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.C = paint5;
        paint5.setColor(d(this.B));
        this.C.setStyle(Paint.Style.FILL);
        Paint paint6 = new Paint(1);
        this.E = paint6;
        paint6.setColor(-16777216);
        this.E.setAlpha(0);
        this.x = d(this.B);
        this.v = d(this.B);
        this.w = true;
    }

    public void a(SaturationBar bar) {
        this.G = bar;
        bar.setColorPicker(this);
        this.G.setColor(this.u);
    }

    public void b(ValueBar bar) {
        this.I = bar;
        bar.setColorPicker(this);
        this.I.setColor(this.u);
    }

    public void f(int color) {
        SaturationBar saturationBar = this.G;
        if (saturationBar != null) {
            saturationBar.setColor(color);
        }
    }

    public void g(int color) {
        ValueBar valueBar = this.I;
        if (valueBar != null) {
            valueBar.setColor(color);
        }
    }

    public int getColor() {
        return this.x;
    }

    public int getOldCenterColor() {
        return this.v;
    }

    public a getOnColorChangedListener() {
        return this.J;
    }

    public b getOnColorSelectedListener() {
        return this.K;
    }

    public boolean getShowOldCenterColor() {
        return this.w;
    }

    public boolean getTouchAnywhereOnColorWheel() {
        return this.H;
    }

    public boolean i() {
        return this.G != null;
    }

    public boolean j() {
        return this.I != null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2 = this.y;
        canvas.translate(f2, f2);
        canvas.drawOval(this.r, this.f14202f);
        float[] e2 = e(this.B);
        canvas.drawCircle(e2[0], e2[1], this.q, this.f14203g);
        canvas.drawCircle(e2[0], e2[1], this.p, this.f14204h);
        canvas.drawCircle(0.0f, 0.0f, this.n, this.E);
        if (!this.w) {
            canvas.drawArc(this.s, 0.0f, 360.0f, true, this.D);
        } else {
            canvas.drawArc(this.s, 90.0f, 180.0f, true, this.C);
            canvas.drawArc(this.s, 270.0f, 180.0f, true, this.D);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2 = (this.k + this.q) * 2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        if (mode2 == 1073741824) {
            i2 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size2);
        }
        int min = Math.min(size, i2);
        setMeasuredDimension(min, min);
        this.y = min * 0.5f;
        int i3 = ((min / 2) - this.f14205i) - this.q;
        this.f14206j = i3;
        this.r.set(-i3, -i3, i3, i3);
        float f2 = this.m;
        int i4 = this.f14206j;
        int i5 = this.k;
        int i6 = (int) (f2 * (i4 / i5));
        this.l = i6;
        this.n = (int) (this.o * (i4 / i5));
        this.s.set(-i6, -i6, i6, i6);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        super.onRestoreInstanceState(bundle.getParcelable(f14197a));
        this.B = bundle.getFloat(f14198b);
        setOldCenterColor(bundle.getInt(f14199c));
        this.w = bundle.getBoolean(f14200d);
        int d2 = d(this.B);
        this.f14204h.setColor(d2);
        setNewCenterColor(d2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f14197a, onSaveInstanceState);
        bundle.putFloat(f14198b, this.B);
        bundle.putInt(f14199c, this.v);
        bundle.putBoolean(f14200d, this.w);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        b bVar;
        int i3;
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = event.getX() - this.y;
        float y = event.getY() - this.y;
        int action = event.getAction();
        if (action == 0) {
            float[] e2 = e(this.B);
            double sqrt = Math.sqrt((x * x) + (y * y));
            float f2 = e2[0];
            int i4 = this.q;
            if (x < f2 - i4 || x > e2[0] + i4 || y < e2[1] - i4 || y > e2[1] + i4) {
                int i5 = this.l;
                if (x < (-i5) || x > i5 || y < (-i5) || y > i5 || !this.w) {
                    int i6 = this.f14206j;
                    if (sqrt > i6 + i4 || sqrt < i6 - i4 || !this.H) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    this.t = true;
                    invalidate();
                } else {
                    this.E.setAlpha(80);
                    setColor(getOldCenterColor());
                    invalidate();
                }
            } else {
                this.z = x - e2[0];
                this.A = y - e2[1];
                this.t = true;
                invalidate();
            }
        } else if (action == 1) {
            this.t = false;
            this.E.setAlpha(0);
            b bVar2 = this.K;
            if (bVar2 != null && (i2 = this.x) != this.M) {
                bVar2.a(i2);
                this.M = this.x;
            }
            invalidate();
        } else if (action != 2) {
            if (action == 3 && (bVar = this.K) != null && (i3 = this.x) != this.M) {
                bVar.a(i3);
                this.M = this.x;
            }
        } else {
            if (!this.t) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            float atan2 = (float) Math.atan2(y - this.A, x - this.z);
            this.B = atan2;
            this.f14204h.setColor(d(atan2));
            int d2 = d(this.B);
            this.x = d2;
            setNewCenterColor(d2);
            ValueBar valueBar = this.I;
            if (valueBar != null) {
                valueBar.setColor(this.u);
            }
            SaturationBar saturationBar = this.G;
            if (saturationBar != null) {
                saturationBar.setColor(this.u);
            }
            invalidate();
        }
        return true;
    }

    public void setColor(int color) {
        float h2 = h(color);
        this.B = h2;
        this.f14204h.setColor(d(h2));
        if (this.G != null) {
            android.graphics.Color.colorToHSV(color, this.F);
            this.G.setColor(this.u);
            this.G.setSaturation(this.F[1]);
        }
        ValueBar valueBar = this.I;
        if (valueBar != null && this.G == null) {
            android.graphics.Color.colorToHSV(color, this.F);
            this.I.setColor(this.u);
            this.I.setValue(this.F[2]);
        } else if (valueBar != null) {
            android.graphics.Color.colorToHSV(color, this.F);
            this.I.setValue(this.F[2]);
        }
        setNewCenterColor(color);
    }

    public void setNewCenterColor(int color) {
        this.x = color;
        this.D.setColor(color);
        if (this.v == 0) {
            this.v = color;
            this.C.setColor(color);
        }
        a aVar = this.J;
        if (aVar != null && color != this.L) {
            aVar.a(color);
            this.L = color;
        }
        invalidate();
    }

    public void setOldCenterColor(int color) {
        this.v = color;
        this.C.setColor(color);
        invalidate();
    }

    public void setOnColorChangedListener(a listener) {
        this.J = listener;
    }

    public void setOnColorSelectedListener(b listener) {
        this.K = listener;
    }

    public void setShowOldCenterColor(boolean show) {
        this.w = show;
        invalidate();
    }

    public void setTouchAnywhereOnColorWheelEnabled(boolean TouchAnywhereOnColorWheelEnabled) {
        this.H = TouchAnywhereOnColorWheelEnabled;
    }

    public ColorPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.r = new RectF();
        this.s = new RectF();
        this.t = false;
        this.F = new float[3];
        this.G = null;
        this.H = true;
        this.I = null;
        k(attrs, 0);
    }

    public ColorPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.r = new RectF();
        this.s = new RectF();
        this.t = false;
        this.F = new float[3];
        this.G = null;
        this.H = true;
        this.I = null;
        k(attrs, defStyle);
    }
}
