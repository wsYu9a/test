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
/* loaded from: classes3.dex */
public class ValueBar extends View {
    public static final boolean A = false;
    public static final boolean B = true;

    /* renamed from: v */
    public static final String f15974v = "parent";

    /* renamed from: w */
    public static final String f15975w = "color";

    /* renamed from: x */
    public static final String f15976x = "value";

    /* renamed from: y */
    public static final String f15977y = "orientation";

    /* renamed from: z */
    public static final boolean f15978z = true;

    /* renamed from: b */
    public int f15979b;

    /* renamed from: c */
    public int f15980c;

    /* renamed from: d */
    public int f15981d;

    /* renamed from: e */
    public int f15982e;

    /* renamed from: f */
    public int f15983f;

    /* renamed from: g */
    public int f15984g;

    /* renamed from: h */
    public Paint f15985h;

    /* renamed from: i */
    public Paint f15986i;

    /* renamed from: j */
    public Paint f15987j;

    /* renamed from: k */
    public final RectF f15988k;

    /* renamed from: l */
    public Shader f15989l;

    /* renamed from: m */
    public boolean f15990m;

    /* renamed from: n */
    public int f15991n;

    /* renamed from: o */
    public final float[] f15992o;

    /* renamed from: p */
    public float f15993p;

    /* renamed from: q */
    public float f15994q;

    /* renamed from: r */
    public ColorPicker f15995r;

    /* renamed from: s */
    public boolean f15996s;

    /* renamed from: t */
    public a f15997t;

    /* renamed from: u */
    public int f15998u;

    public interface a {
        void a(int i10);
    }

    public ValueBar(Context context) {
        super(context);
        this.f15988k = new RectF();
        this.f15992o = new float[3];
        this.f15995r = null;
        b(null, 0);
    }

    public final void a(int i10) {
        int i11 = i10 - this.f15983f;
        if (i11 < 0) {
            i11 = 0;
        } else {
            int i12 = this.f15980c;
            if (i11 > i12) {
                i11 = i12;
            }
        }
        float[] fArr = this.f15992o;
        this.f15991n = Color.HSVToColor(new float[]{fArr[0], fArr[1], 1.0f - (this.f15993p * i11)});
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorBars, i10, 0);
        Resources resources = getContext().getResources();
        this.f15979b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_thickness, resources.getDimensionPixelSize(R.dimen.bar_thickness));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_length, resources.getDimensionPixelSize(R.dimen.bar_length));
        this.f15980c = dimensionPixelSize;
        this.f15981d = dimensionPixelSize;
        this.f15982e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_pointer_radius, resources.getDimensionPixelSize(R.dimen.bar_pointer_radius));
        this.f15983f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_pointer_halo_radius, resources.getDimensionPixelSize(R.dimen.bar_pointer_halo_radius));
        this.f15996s = obtainStyledAttributes.getBoolean(R.styleable.ColorBars_bar_orientation_horizontal, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f15985h = paint;
        paint.setShader(this.f15989l);
        this.f15984g = this.f15983f;
        Paint paint2 = new Paint(1);
        this.f15987j = paint2;
        paint2.setColor(-16777216);
        this.f15987j.setAlpha(80);
        Paint paint3 = new Paint(1);
        this.f15986i = paint3;
        paint3.setColor(-8257792);
        int i11 = this.f15980c;
        this.f15993p = 1.0f / i11;
        this.f15994q = i11;
    }

    public int getColor() {
        return this.f15991n;
    }

    public a getOnValueChangedListener() {
        return this.f15997t;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        int i11;
        canvas.drawRect(this.f15988k, this.f15985h);
        if (this.f15996s) {
            i10 = this.f15984g;
            i11 = this.f15983f;
        } else {
            i10 = this.f15983f;
            i11 = this.f15984g;
        }
        float f10 = i10;
        float f11 = i11;
        canvas.drawCircle(f10, f11, this.f15983f, this.f15987j);
        canvas.drawCircle(f10, f11, this.f15982e, this.f15986i);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f15981d + (this.f15983f * 2);
        if (!this.f15996s) {
            i10 = i11;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            i12 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size);
        }
        int i13 = this.f15983f;
        int i14 = i13 * 2;
        int i15 = i12 - i14;
        this.f15980c = i15;
        if (this.f15996s) {
            setMeasuredDimension(i15 + i14, i13 * 2);
        } else {
            setMeasuredDimension(i14, i15 + i14);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("parent"));
        setColor(Color.HSVToColor(bundle.getFloatArray("color")));
        setValue(bundle.getFloat("value"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", onSaveInstanceState);
        bundle.putFloatArray("color", this.f15992o);
        float[] fArr = new float[3];
        Color.colorToHSV(this.f15991n, fArr);
        bundle.putFloat("value", fArr[2]);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f15996s) {
            int i16 = this.f15980c;
            int i17 = this.f15983f;
            i14 = i16 + i17;
            i15 = this.f15979b;
            this.f15980c = i10 - (i17 * 2);
            this.f15988k.set(i17, i17 - (i15 / 2.0f), r5 + i17, i17 + (i15 / 2.0f));
        } else {
            i14 = this.f15979b;
            int i18 = this.f15980c;
            int i19 = this.f15983f;
            this.f15980c = i11 - (i19 * 2);
            this.f15988k.set(i19 - (i14 / 2.0f), i19, i19 + (i14 / 2.0f), r5 + i19);
            i15 = i18 + i19;
        }
        if (isInEditMode()) {
            this.f15989l = new LinearGradient(this.f15983f, 0.0f, i14, i15, new int[]{-8257792, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
            Color.colorToHSV(-8257792, this.f15992o);
        } else {
            this.f15989l = new LinearGradient(this.f15983f, 0.0f, i14, i15, new int[]{Color.HSVToColor(255, this.f15992o), -16777216}, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.f15985h.setShader(this.f15989l);
        int i20 = this.f15980c;
        this.f15993p = 1.0f / i20;
        this.f15994q = i20;
        float[] fArr = new float[3];
        Color.colorToHSV(this.f15991n, fArr);
        if (isInEditMode()) {
            this.f15984g = this.f15983f;
        } else {
            this.f15984g = Math.round((this.f15980c - (this.f15994q * fArr[2])) + this.f15983f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x10 = this.f15996s ? motionEvent.getX() : motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15990m = true;
            if (x10 >= this.f15983f && x10 <= r5 + this.f15980c) {
                this.f15984g = Math.round(x10);
                a(Math.round(x10));
                this.f15986i.setColor(this.f15991n);
                invalidate();
            }
        } else if (action == 1) {
            this.f15990m = false;
        } else if (action == 2) {
            if (this.f15990m) {
                int i10 = this.f15983f;
                if (x10 >= i10 && x10 <= this.f15980c + i10) {
                    this.f15984g = Math.round(x10);
                    a(Math.round(x10));
                    this.f15986i.setColor(this.f15991n);
                    ColorPicker colorPicker = this.f15995r;
                    if (colorPicker != null) {
                        colorPicker.setNewCenterColor(this.f15991n);
                    }
                    invalidate();
                } else if (x10 < i10) {
                    this.f15984g = i10;
                    int HSVToColor = Color.HSVToColor(this.f15992o);
                    this.f15991n = HSVToColor;
                    this.f15986i.setColor(HSVToColor);
                    ColorPicker colorPicker2 = this.f15995r;
                    if (colorPicker2 != null) {
                        colorPicker2.setNewCenterColor(this.f15991n);
                    }
                    invalidate();
                } else {
                    int i11 = this.f15980c;
                    if (x10 > i10 + i11) {
                        this.f15984g = i10 + i11;
                        this.f15991n = -16777216;
                        this.f15986i.setColor(-16777216);
                        ColorPicker colorPicker3 = this.f15995r;
                        if (colorPicker3 != null) {
                            colorPicker3.setNewCenterColor(this.f15991n);
                        }
                        invalidate();
                    }
                }
            }
            a aVar = this.f15997t;
            if (aVar != null) {
                int i12 = this.f15998u;
                int i13 = this.f15991n;
                if (i12 != i13) {
                    aVar.a(i13);
                    this.f15998u = this.f15991n;
                }
            }
        }
        return true;
    }

    public void setColor(int i10) {
        int i11;
        int i12;
        if (this.f15996s) {
            i11 = this.f15980c + this.f15983f;
            i12 = this.f15979b;
        } else {
            i11 = this.f15979b;
            i12 = this.f15980c + this.f15983f;
        }
        Color.colorToHSV(i10, this.f15992o);
        LinearGradient linearGradient = new LinearGradient(this.f15983f, 0.0f, i11, i12, new int[]{i10, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
        this.f15989l = linearGradient;
        this.f15985h.setShader(linearGradient);
        a(this.f15984g);
        this.f15986i.setColor(this.f15991n);
        ColorPicker colorPicker = this.f15995r;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.f15991n);
        }
        invalidate();
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.f15995r = colorPicker;
    }

    public void setOnValueChangedListener(a aVar) {
        this.f15997t = aVar;
    }

    public void setValue(float f10) {
        int round = Math.round((this.f15980c - (this.f15994q * f10)) + this.f15983f);
        this.f15984g = round;
        a(round);
        this.f15986i.setColor(this.f15991n);
        ColorPicker colorPicker = this.f15995r;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.f15991n);
        }
        invalidate();
    }

    public ValueBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15988k = new RectF();
        this.f15992o = new float[3];
        this.f15995r = null;
        b(attributeSet, 0);
    }

    public ValueBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15988k = new RectF();
        this.f15992o = new float[3];
        this.f15995r = null;
        b(attributeSet, i10);
    }
}
