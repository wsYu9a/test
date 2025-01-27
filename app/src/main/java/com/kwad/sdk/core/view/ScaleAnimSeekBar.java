package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class ScaleAnimSeekBar extends View {
    private GradientDrawable aHA;
    private GradientDrawable aHB;
    private GradientDrawable aHC;
    private Rect aHD;
    private Rect aHE;
    private Rect aHF;
    private Rect aHG;
    private Drawable aHH;
    private boolean aHI;
    private boolean aHJ;
    private boolean aHK;
    private boolean aHL;
    private boolean aHM;
    private WeakReference<a> aHN;
    private boolean aHO;
    private boolean aHP;
    private ValueAnimator aHQ;
    private ValueAnimator aHR;
    private ValueAnimator aHS;
    private float aHT;
    private float aHU;
    private float aHV;
    private float aHW;
    private int aHX;
    private boolean aHY;
    private Paint aHj;
    private int aHk;
    private int aHl;
    private int aHm;
    private int aHn;
    private int aHo;
    private int aHp;
    private int aHq;
    private int aHr;
    private boolean aHs;
    private int aHt;
    private int aHu;
    private int aHv;
    private int aHw;
    private int aHx;
    private int aHy;
    private int aHz;

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$1 */
    public class AnonymousClass1 implements Interpolator {
        public AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11) + 1.0f;
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$2 */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
            scaleAnimSeekBar.aHv = scaleAnimSeekBar.dA((int) floatValue);
            ScaleAnimSeekBar.this.i(floatValue);
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScaleAnimSeekBar.this.aHT = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar.this.requestLayout();
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$4 */
    public class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScaleAnimSeekBar.this.aHV = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar.this.requestLayout();
        }
    }

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z10);

        void uz();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bD(Context context) {
        this.aHO = true;
        this.aHX = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.aHn = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.aHu = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.aHH = null;
        this.aHP = false;
        this.aHr = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.aHq = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.aHk = 654311423;
        this.aHl = -1;
        this.aHm = 1090519039;
        this.aHo = 0;
        this.aHp = 100;
        this.aHs = false;
    }

    private void bs(boolean z10) {
        if (this.aHO) {
            if (z10) {
                bt(true);
                bu(true);
            } else {
                bt(false);
                bu(false);
            }
        }
    }

    private void bt(boolean z10) {
        float f10 = this.aHT;
        float f11 = z10 ? this.aHU : 1.0f;
        ValueAnimator valueAnimator = this.aHQ;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aHQ = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aHQ.setInterpolator(new LinearInterpolator());
            this.aHQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                public AnonymousClass3() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aHT = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aHQ.setFloatValues(f10, f11);
        this.aHQ.start();
    }

    private void bu(boolean z10) {
        float f10 = this.aHV;
        float f11 = z10 ? this.aHW : 1.0f;
        ValueAnimator valueAnimator = this.aHR;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aHR = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aHR.setInterpolator(new LinearInterpolator());
            this.aHR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                public AnonymousClass4() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aHV = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aHR.setFloatValues(f10, f11);
        this.aHR.start();
    }

    private boolean d(float f10, float f11) {
        int i10;
        int i11;
        Rect rect = this.aHG;
        int i12 = rect.left;
        int i13 = rect.right;
        if (i12 >= i13 || (i10 = rect.top) >= (i11 = rect.bottom)) {
            return false;
        }
        float f12 = this.aHT;
        int i14 = this.aHu;
        return f10 >= (((float) i12) * f12) - ((float) i14) && f10 <= (((float) i13) * f12) + ((float) i14) && f11 >= (((float) i10) * f12) - ((float) i14) && f11 <= (((float) i11) * f12) + ((float) i14);
    }

    public int dA(int i10) {
        int i11 = this.aHt;
        return i10 > i11 / 2 ? this.aHp : i10 < (-i11) / 2 ? this.aHo : Math.round(((i10 + (i11 / 2.0f)) * (this.aHp - this.aHo)) / i11) + this.aHo;
    }

    private float dz(int i10) {
        int i11 = this.aHt;
        int i12 = this.aHo;
        return ((i11 * (i10 - i12)) / (this.aHp - i12)) - (i11 / 2.0f);
    }

    private boolean e(float f10, float f11) {
        int i10;
        int i11;
        Rect rect = this.aHD;
        int i12 = rect.left;
        int i13 = rect.right;
        if (i12 >= i13 || (i10 = rect.top) >= (i11 = rect.bottom)) {
            return false;
        }
        float f12 = this.aHV;
        int i14 = this.aHu;
        return f10 >= (((float) i12) * f12) - ((float) i14) && f10 <= (((float) i13) * f12) + ((float) i14) && f11 >= (((float) i10) * f12) - ((float) i14) && f11 <= (((float) i11) * f12) + ((float) i14);
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aHN;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void i(boolean z10, int i10) {
        if (!z10) {
            this.aHv = i10;
            i(j(dz(i10)));
            return;
        }
        float j10 = j(dz(this.aHv));
        float j11 = j(dz(i10));
        ValueAnimator valueAnimator = this.aHS;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aHS = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.aHS.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                public AnonymousClass1() {
                }

                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f10) {
                    float f11 = f10 - 1.0f;
                    return (f11 * f11 * f11) + 1.0f;
                }
            });
            this.aHS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                public AnonymousClass2() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aHv = scaleAnimSeekBar.dA((int) floatValue);
                    ScaleAnimSeekBar.this.i(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aHS.setFloatValues(j10, j11);
        this.aHS.start();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bD(context);
        }
        Paint paint = new Paint();
        this.aHj = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aHj.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aHA = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aHA.setColor(this.aHk);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aHB = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aHB.setColor(this.aHl);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aHC = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aHC.setColor(this.aHm);
        this.aHD = new Rect();
        this.aHE = new Rect();
        this.aHG = new Rect();
        this.aHF = new Rect();
        this.aHv = this.aHo;
    }

    private float j(float f10) {
        float f11 = this.aHt / 2;
        if (f10 > f11) {
            return f11;
        }
        float f12 = -f11;
        return f10 < f12 ? f12 : f10;
    }

    private void x(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        if (this.aHO) {
            this.aHt = (int) (i10 - ((this.aHX * 2) * (this.aHU - this.aHT)));
        } else {
            this.aHt = i10 - (this.aHX * 2);
        }
        Rect rect = this.aHD;
        int i12 = this.aHr;
        int i13 = -i12;
        rect.top = i13;
        rect.bottom = -i13;
        boolean z10 = this.aHs;
        rect.left = (z10 ? -i10 : -this.aHt) / 2;
        rect.right = z10 ? i10 / 2 : this.aHt / 2;
        Rect rect2 = this.aHE;
        int i14 = -i12;
        rect2.top = i14;
        rect2.bottom = -i14;
        rect2.left = (z10 ? -i10 : -this.aHt) / 2;
        int i15 = this.aHt;
        rect2.right = (-i15) / 2;
        Rect rect3 = this.aHF;
        rect3.top = -i12;
        rect3.bottom = -rect2.top;
        rect3.left = (z10 ? -i10 : -i15) / 2;
        rect3.right = (-i15) / 2;
        Rect rect4 = this.aHG;
        int i16 = this.aHn;
        rect4.top = -i16;
        rect4.bottom = i16;
        rect4.left = ((-i15) / 2) - i16;
        rect4.right = ((-i15) / 2) + i16;
        setThumbDrawable(this.aHH);
        setProgress(this.aHv);
        setSecondaryProgress(this.aHx);
    }

    public final void br(boolean z10) {
        this.aHY = z10;
        bs(z10);
    }

    public int getMaxProgress() {
        return this.aHp;
    }

    public int getProgress() {
        return this.aHv;
    }

    public int getProgressLength() {
        return this.aHt;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aHn * this.aHU));
    }

    public int getSecondaryProgress() {
        return this.aHx;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aHz / 2, this.aHy / 2);
        a(canvas, this.aHD, this.aHA);
        a(canvas, this.aHF, this.aHC);
        a(canvas, this.aHE, this.aHB);
        if (this.aHY) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824) {
            this.aHz = size;
        } else {
            this.aHz = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aHy = size2;
        } else {
            this.aHy = getHeight();
        }
        x(this.aHz, this.aHy);
        setMeasuredDimension(this.aHz, this.aHy);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX() - (this.aHz / 2);
        float y10 = motionEvent.getY() - (this.aHy / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aHM = false;
                if (this.aHJ || this.aHI) {
                    this.aHJ = false;
                    this.aHI = false;
                    a(dA((int) x10), this.aHP, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (action == 2 && (this.aHI || this.aHJ)) {
                a(dA((int) x10), false, true);
            }
        } else {
            if (!this.aHL) {
                return super.onTouchEvent(motionEvent);
            }
            if (d(x10, y10)) {
                bs(true);
                this.aHI = true;
                this.aHM = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.uz();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x10, y10)) {
                bs(true);
                this.aHJ = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.uz();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i10) {
        this.aHp = i10;
    }

    public void setMinProgress(int i10) {
        this.aHo = i10;
        if (this.aHv < i10) {
            this.aHv = i10;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aHN = new WeakReference<>(aVar);
    }

    public void setProgress(int i10) {
        a(i10, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i10) {
        this.aHk = i10;
        this.aHA.setColor(i10);
    }

    public void setProgressColor(@ColorInt int i10) {
        this.aHl = i10;
        this.aHB.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.aHo;
        if (i10 <= i11 || i10 >= (i11 = this.aHp)) {
            i10 = i11;
        }
        this.aHx = i10;
        this.aHF.right = (int) j(dz(i10));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i10) {
        this.aHm = i10;
        this.aHC.setColor(i10);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aHH = drawable;
    }

    public void setThumbEnable(boolean z10) {
        this.aHL = z10;
    }

    public void setThumbScale(float f10) {
        this.aHT = f10;
    }

    public void setThumbTouchOffset(int i10) {
        this.aHu = i10;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aHH;
        if (drawable != null) {
            drawable.setBounds(this.aHG);
            this.aHH.draw(canvas);
        } else {
            this.aHj.setColor(this.aHl);
            canvas.drawCircle(this.aHG.centerX(), this.aHG.centerY(), (this.aHG.width() * this.aHT) / 2.0f, this.aHj);
        }
        canvas.restore();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aHp = 100;
        this.aHs = false;
        this.aHH = null;
        this.aHI = false;
        this.aHJ = false;
        this.aHK = false;
        this.aHL = true;
        this.aHO = true;
        this.aHP = false;
        this.aHT = 1.0f;
        this.aHU = 1.34f;
        this.aHV = 1.0f;
        this.aHW = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f10 = rect.top;
        float f11 = this.aHV;
        rect2.top = (int) (f10 * f11);
        rect2.bottom = (int) (rect.bottom * f11);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aHq * this.aHV);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(int i10, boolean z10, boolean z11) {
        int i11 = this.aHo;
        if (i10 <= i11 || i10 >= (i11 = this.aHp)) {
            i10 = i11;
        }
        i(z10, i10);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aHw != this.aHv) {
            this.aHK = z11;
            onSeekBarChangedListener.a(this, z11);
            this.aHK = false;
        }
        this.aHw = this.aHv;
    }

    public void i(float f10) {
        Rect rect = this.aHG;
        int i10 = this.aHn;
        rect.left = (int) (f10 - i10);
        rect.right = (int) (i10 + f10);
        this.aHE.right = (int) f10;
        invalidate();
    }
}
