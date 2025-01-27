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
public class SaturationBar extends View {
    public static final boolean A = false;
    public static final boolean B = true;

    /* renamed from: v */
    public static final String f15949v = "parent";

    /* renamed from: w */
    public static final String f15950w = "color";

    /* renamed from: x */
    public static final String f15951x = "saturation";

    /* renamed from: y */
    public static final String f15952y = "orientation";

    /* renamed from: z */
    public static final boolean f15953z = true;

    /* renamed from: b */
    public int f15954b;

    /* renamed from: c */
    public int f15955c;

    /* renamed from: d */
    public int f15956d;

    /* renamed from: e */
    public int f15957e;

    /* renamed from: f */
    public int f15958f;

    /* renamed from: g */
    public int f15959g;

    /* renamed from: h */
    public Paint f15960h;

    /* renamed from: i */
    public Paint f15961i;

    /* renamed from: j */
    public Paint f15962j;

    /* renamed from: k */
    public final RectF f15963k;

    /* renamed from: l */
    public Shader f15964l;

    /* renamed from: m */
    public boolean f15965m;

    /* renamed from: n */
    public int f15966n;

    /* renamed from: o */
    public final float[] f15967o;

    /* renamed from: p */
    public float f15968p;

    /* renamed from: q */
    public float f15969q;

    /* renamed from: r */
    public ColorPicker f15970r;

    /* renamed from: s */
    public boolean f15971s;

    /* renamed from: t */
    public a f15972t;

    /* renamed from: u */
    public int f15973u;

    public interface a {
        void a(int i10);
    }

    public SaturationBar(Context context) {
        super(context);
        this.f15963k = new RectF();
        this.f15967o = new float[3];
        this.f15970r = null;
        b(null, 0);
    }

    public final void a(int i10) {
        int i11 = i10 - this.f15958f;
        if (i11 < 0) {
            i11 = 0;
        } else {
            int i12 = this.f15955c;
            if (i11 > i12) {
                i11 = i12;
            }
        }
        this.f15966n = Color.HSVToColor(new float[]{this.f15967o[0], this.f15968p * i11, 1.0f});
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorBars, i10, 0);
        Resources resources = getContext().getResources();
        this.f15954b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_thickness, resources.getDimensionPixelSize(R.dimen.bar_thickness));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_length, resources.getDimensionPixelSize(R.dimen.bar_length));
        this.f15955c = dimensionPixelSize;
        this.f15956d = dimensionPixelSize;
        this.f15957e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_pointer_radius, resources.getDimensionPixelSize(R.dimen.bar_pointer_radius));
        this.f15958f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorBars_bar_pointer_halo_radius, resources.getDimensionPixelSize(R.dimen.bar_pointer_halo_radius));
        this.f15971s = obtainStyledAttributes.getBoolean(R.styleable.ColorBars_bar_orientation_horizontal, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f15960h = paint;
        paint.setShader(this.f15964l);
        this.f15959g = this.f15955c + this.f15958f;
        Paint paint2 = new Paint(1);
        this.f15962j = paint2;
        paint2.setColor(-16777216);
        this.f15962j.setAlpha(80);
        Paint paint3 = new Paint(1);
        this.f15961i = paint3;
        paint3.setColor(-8257792);
        int i11 = this.f15955c;
        this.f15968p = 1.0f / i11;
        this.f15969q = i11;
    }

    public int getColor() {
        return this.f15966n;
    }

    public a getOnSaturationChangedListener() {
        return this.f15972t;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        int i11;
        canvas.drawRect(this.f15963k, this.f15960h);
        if (this.f15971s) {
            i10 = this.f15959g;
            i11 = this.f15958f;
        } else {
            i10 = this.f15958f;
            i11 = this.f15959g;
        }
        float f10 = i10;
        float f11 = i11;
        canvas.drawCircle(f10, f11, this.f15958f, this.f15962j);
        canvas.drawCircle(f10, f11, this.f15957e, this.f15961i);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f15956d + (this.f15958f * 2);
        if (!this.f15971s) {
            i10 = i11;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            i12 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size);
        }
        int i13 = this.f15958f;
        int i14 = i13 * 2;
        int i15 = i12 - i14;
        this.f15955c = i15;
        if (this.f15971s) {
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
        setSaturation(bundle.getFloat(f15951x));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("parent", onSaveInstanceState);
        bundle.putFloatArray("color", this.f15967o);
        float[] fArr = new float[3];
        Color.colorToHSV(this.f15966n, fArr);
        bundle.putFloat(f15951x, fArr[1]);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f15971s) {
            int i16 = this.f15955c;
            int i17 = this.f15958f;
            i14 = i16 + i17;
            i15 = this.f15954b;
            this.f15955c = i10 - (i17 * 2);
            this.f15963k.set(i17, i17 - (i15 / 2.0f), r6 + i17, i17 + (i15 / 2.0f));
        } else {
            i14 = this.f15954b;
            int i18 = this.f15955c;
            int i19 = this.f15958f;
            this.f15955c = i11 - (i19 * 2);
            this.f15963k.set(i19 - (i14 / 2.0f), i19, i19 + (i14 / 2.0f), r6 + i19);
            i15 = i18 + i19;
        }
        if (isInEditMode()) {
            this.f15964l = new LinearGradient(this.f15958f, 0.0f, i14, i15, new int[]{-1, -8257792}, (float[]) null, Shader.TileMode.CLAMP);
            Color.colorToHSV(-8257792, this.f15967o);
        } else {
            this.f15964l = new LinearGradient(this.f15958f, 0.0f, i14, i15, new int[]{-1, Color.HSVToColor(255, this.f15967o)}, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.f15960h.setShader(this.f15964l);
        int i20 = this.f15955c;
        this.f15968p = 1.0f / i20;
        this.f15969q = i20;
        float[] fArr = new float[3];
        Color.colorToHSV(this.f15966n, fArr);
        if (isInEditMode()) {
            this.f15959g = this.f15955c + this.f15958f;
        } else {
            this.f15959g = Math.round((this.f15969q * fArr[1]) + this.f15958f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x10 = this.f15971s ? motionEvent.getX() : motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15965m = true;
            if (x10 >= this.f15958f && x10 <= r5 + this.f15955c) {
                this.f15959g = Math.round(x10);
                a(Math.round(x10));
                this.f15961i.setColor(this.f15966n);
                invalidate();
            }
        } else if (action == 1) {
            this.f15965m = false;
        } else if (action == 2) {
            if (this.f15965m) {
                int i10 = this.f15958f;
                if (x10 >= i10 && x10 <= this.f15955c + i10) {
                    this.f15959g = Math.round(x10);
                    a(Math.round(x10));
                    this.f15961i.setColor(this.f15966n);
                    ColorPicker colorPicker = this.f15970r;
                    if (colorPicker != null) {
                        colorPicker.setNewCenterColor(this.f15966n);
                        this.f15970r.g(this.f15966n);
                    }
                    invalidate();
                } else if (x10 < i10) {
                    this.f15959g = i10;
                    this.f15966n = -1;
                    this.f15961i.setColor(-1);
                    ColorPicker colorPicker2 = this.f15970r;
                    if (colorPicker2 != null) {
                        colorPicker2.setNewCenterColor(this.f15966n);
                        this.f15970r.g(this.f15966n);
                    }
                    invalidate();
                } else {
                    int i11 = this.f15955c;
                    if (x10 > i10 + i11) {
                        this.f15959g = i10 + i11;
                        int HSVToColor = Color.HSVToColor(this.f15967o);
                        this.f15966n = HSVToColor;
                        this.f15961i.setColor(HSVToColor);
                        ColorPicker colorPicker3 = this.f15970r;
                        if (colorPicker3 != null) {
                            colorPicker3.setNewCenterColor(this.f15966n);
                            this.f15970r.g(this.f15966n);
                        }
                        invalidate();
                    }
                }
            }
            a aVar = this.f15972t;
            if (aVar != null) {
                int i12 = this.f15973u;
                int i13 = this.f15966n;
                if (i12 != i13) {
                    aVar.a(i13);
                    this.f15973u = this.f15966n;
                }
            }
        }
        return true;
    }

    public void setColor(int i10) {
        int i11;
        int i12;
        if (this.f15971s) {
            i11 = this.f15955c + this.f15958f;
            i12 = this.f15954b;
        } else {
            i11 = this.f15954b;
            i12 = this.f15955c + this.f15958f;
        }
        Color.colorToHSV(i10, this.f15967o);
        LinearGradient linearGradient = new LinearGradient(this.f15958f, 0.0f, i11, i12, new int[]{-1, i10}, (float[]) null, Shader.TileMode.CLAMP);
        this.f15964l = linearGradient;
        this.f15960h.setShader(linearGradient);
        a(this.f15959g);
        this.f15961i.setColor(this.f15966n);
        ColorPicker colorPicker = this.f15970r;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.f15966n);
            if (this.f15970r.j()) {
                this.f15970r.g(this.f15966n);
            }
        }
        invalidate();
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.f15970r = colorPicker;
    }

    public void setOnSaturationChangedListener(a aVar) {
        this.f15972t = aVar;
    }

    public void setSaturation(float f10) {
        int round = Math.round(this.f15969q * f10) + this.f15958f;
        this.f15959g = round;
        a(round);
        this.f15961i.setColor(this.f15966n);
        ColorPicker colorPicker = this.f15970r;
        if (colorPicker != null) {
            colorPicker.setNewCenterColor(this.f15966n);
            this.f15970r.g(this.f15966n);
        }
        invalidate();
    }

    public SaturationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15963k = new RectF();
        this.f15967o = new float[3];
        this.f15970r = null;
        b(attributeSet, 0);
    }

    public SaturationBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15963k = new RectF();
        this.f15967o = new float[3];
        this.f15970r = null;
        b(attributeSet, i10);
    }
}
