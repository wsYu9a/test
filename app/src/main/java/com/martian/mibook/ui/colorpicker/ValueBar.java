package com.martian.mibook.ui.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.martian.mibook.R;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes4.dex */
public class ValueBar extends View {

    /* renamed from: a */
    private static final String f14229a = "parent";

    /* renamed from: b */
    private static final String f14230b = "color";

    /* renamed from: c */
    private static final String f14231c = "value";

    /* renamed from: d */
    private static final String f14232d = "orientation";

    /* renamed from: e */
    private static final boolean f14233e = true;

    /* renamed from: f */
    private static final boolean f14234f = false;

    /* renamed from: g */
    private static final boolean f14235g = true;
    private int A;

    /* renamed from: h */
    private int f14236h;

    /* renamed from: i */
    private int f14237i;

    /* renamed from: j */
    private int f14238j;
    private int k;
    private int l;
    private int m;
    private Paint n;
    private Paint o;
    private Paint p;
    private final RectF q;
    private Shader r;
    private boolean s;
    private int t;
    private final float[] u;
    private float v;
    private float w;
    private ColorPicker x;
    private boolean y;
    private a z;

    public interface a {
        void a(int value);
    }

    public ValueBar(Context context) {
        super(context);
        this.q = new RectF();
        this.u = new float[3];
        this.x = null;
        b(null, 0);
    }

    private void a(int color) {
        int i2 = color - this.l;
        if (i2 < 0) {
            i2 = 0;
        } else {
            int i3 = this.f14237i;
            if (i2 > i3) {
                i2 = i3;
            }
        }
        float[] fArr = this.u;
        this.t = Color.HSVToColor(new float[]{fArr[0], fArr[1], 1.0f - (this.v * i2)});
    }

    private void b(AttributeSet attrs, int defStyle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ColorBars, defStyle, 0);
        Resources resources = getContext().getResources();
        this.f14236h = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.bar_thickness));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.bar_length));
        this.f14237i = dimensionPixelSize;
        this.f14238j = dimensionPixelSize;
        this.k = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.bar_pointer_radius));
        this.l = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(com.martian.ttbookhd.R.dimen.bar_pointer_halo_radius));
        this.y = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.n = paint;
        paint.setShader(this.r);
        this.m = this.l;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        paint2.setColor(-16777216);
        this.p.setAlpha(80);
        Paint paint3 = new Paint(1);
        this.o = paint3;
        paint3.setColor(-8257792);
        int i2 = this.f14237i;
        this.v = 1.0f / i2;
        this.w = i2 / 1.0f;
    }

    public int getColor() {
        return this.t;
    }

    public a getOnValueChangedListener() {
        return this.z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        int i3;
        canvas.drawRect(this.q, this.n);
        if (this.y) {
            i2 = this.m;
            i3 = this.l;
        } else {
            i2 = this.l;
            i3 = this.m;
        }
        float f2 = i2;
        float f3 = i3;
        canvas.drawCircle(f2, f3, this.l, this.p);
        canvas.drawCircle(f2, f3, this.k, this.o);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2 = this.f14238j + (this.l * 2);
        if (!this.y) {
            widthMeasureSpec = heightMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        int i3 = this.l;
        int i4 = i3 * 2;
        int i5 = i2 - i4;
        this.f14237i = i5;
        if (this.y) {
            setMeasuredDimension(i5 + i4, i3 * 2);
        } else {
            setMeasuredDimension(i4, i5 + i4);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        super.onRestoreInstanceState(bundle.getParcelable(f14229a));
        setColor(Color.HSVToColor(bundle.getFloatArray(f14230b)));
        setValue(bundle.getFloat("value"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f14229a, onSaveInstanceState);
        bundle.putFloatArray(f14230b, this.u);
        float[] fArr = new float[3];
        Color.colorToHSV(this.t, fArr);
        bundle.putFloat("value", fArr[2]);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h2, int oldW, int oldH) {
        int i2;
        int i3;
        super.onSizeChanged(w, h2, oldW, oldH);
        if (this.y) {
            int i4 = this.f14237i;
            int i5 = this.l;
            i2 = i4 + i5;
            i3 = this.f14236h;
            this.f14237i = w - (i5 * 2);
            this.q.set(i5, i5 - (i3 / 2.0f), r6 + i5, i5 + (i3 / 2.0f));
        } else {
            i2 = this.f14236h;
            int i6 = this.f14237i;
            int i7 = this.l;
            this.f14237i = h2 - (i7 * 2);
            this.q.set(i7 - (i2 / 2.0f), i7, i7 + (i2 / 2.0f), r6 + i7);
            i3 = i6 + i7;
        }
        if (isInEditMode()) {
            this.r = new LinearGradient(this.l, 0.0f, i2, i3, new int[]{-8257792, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
            Color.colorToHSV(-8257792, this.u);
        } else {
            this.r = new LinearGradient(this.l, 0.0f, i2, i3, new int[]{Color.HSVToColor(255, this.u), -16777216}, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.n.setShader(this.r);
        int i8 = this.f14237i;
        this.v = 1.0f / i8;
        this.w = i8 / 1.0f;
        float[] fArr = new float[3];
        Color.colorToHSV(this.t, fArr);
        if (isInEditMode()) {
            this.m = this.l;
        } else {
            this.m = Math.round((this.f14237i - (this.w * fArr[2])) + this.l);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = this.y ? event.getX() : event.getY();
        int action = event.getAction();
        if (action == 0) {
            this.s = true;
            if (x >= this.l && x <= r5 + this.f14237i) {
                this.m = Math.round(x);
                a(Math.round(x));
                this.o.setColor(this.t);
                invalidate();
            }
        } else if (action == 1) {
            this.s = false;
        } else if (action == 2) {
            if (this.s) {
                int i2 = this.l;
                if (x >= i2 && x <= this.f14237i + i2) {
                    this.m = Math.round(x);
                    a(Math.round(x));
                    this.o.setColor(this.t);
                    ColorPicker colorPicker = this.x;
                    if (colorPicker != null) {
                        colorPicker.setNewCenterColor(this.t);
                    }
                    invalidate();
                } else if (x < i2) {
                    this.m = i2;
                    int HSVToColor = Color.HSVToColor(this.u);
                    this.t = HSVToColor;
                    this.o.setColor(HSVToColor);
                    ColorPicker colorPicker2 = this.x;
                    if (colorPicker2 != null) {
                        colorPicker2.setNewCenterColor(this.t);
                    }
                    invalidate();
                } else {
                    int i3 = this.f14237i;
                    if (x > i2 + i3) {
                        this.m = i2 + i3;
                        this.t = -16777216;
                        this.o.setColor(-16777216);
                        ColorPicker colorPicker3 = this.x;
                        if (colorPicker3 != null) {
                            colorPicker3.setNewCenterColor(this.t);
                        }
                        invalidate();
                    }
                }
            }
            a aVar = this.z;
            if (aVar != null) {
                int i4 = this.A;
                int i5 = this.t;
                if (i4 != i5) {
                    aVar.a(i5);
                    this.A = this.t;
                }
            }
        }
        return true;
    }

    public void setColor(int color) {
        int i2;
        int i3;
        if (this.y) {
            i2 = this.f14237i + this.l;
            i3 = this.f14236h;
        } else {
            i2 = this.f14236h;
            i3 = this.f14237i + this.l;
        }
        Color.colorToHSV(color, this.u);
        LinearGradient linearGradient = new LinearGradient(this.l, 0.0f, i2, i3, new int[]{color, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
        this.r = linearGradient;
        this.n.setShader(linearGradient);
        a(this.m);
        this.o.setColor(this.t);
        ColorPicker colorPicker = this.x;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.t);
        }
        invalidate();
    }

    public void setColorPicker(ColorPicker picker) {
        this.x = picker;
    }

    public void setOnValueChangedListener(a listener) {
        this.z = listener;
    }

    public void setValue(float value) {
        int round = Math.round((this.f14237i - (this.w * value)) + this.l);
        this.m = round;
        a(round);
        this.o.setColor(this.t);
        ColorPicker colorPicker = this.x;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.t);
        }
        invalidate();
    }

    public ValueBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.q = new RectF();
        this.u = new float[3];
        this.x = null;
        b(attrs, 0);
    }

    public ValueBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.q = new RectF();
        this.u = new float[3];
        this.x = null;
        b(attrs, defStyle);
    }
}
