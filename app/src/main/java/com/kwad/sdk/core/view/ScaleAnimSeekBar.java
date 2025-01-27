package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class ScaleAnimSeekBar extends View {
    private int aoA;
    private int aoB;
    private int aoC;
    private int aoD;
    private int aoE;
    private int aoF;
    private boolean aoG;
    private int aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private int aoL;
    private int aoM;
    private int aoN;
    private GradientDrawable aoO;
    private GradientDrawable aoP;
    private GradientDrawable aoQ;
    private Rect aoR;
    private Rect aoS;
    private Rect aoT;
    private Rect aoU;
    private Drawable aoV;
    private boolean aoW;
    private boolean aoX;
    private boolean aoY;
    private boolean aoZ;
    private Paint aox;
    private int aoy;
    private int aoz;
    private boolean apa;
    private WeakReference<a> apb;
    private boolean apc;
    private boolean apd;
    private ValueAnimator ape;
    private ValueAnimator apf;
    private ValueAnimator apg;
    private float aph;
    private float api;
    private float apj;
    private float apk;
    private int apl;
    private boolean apm;

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$1 */
    final class AnonymousClass1 implements Interpolator {
        AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3) + 1.0f;
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$2 */
    final class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
            scaleAnimSeekBar.aoJ = scaleAnimSeekBar.bE((int) floatValue);
            ScaleAnimSeekBar.this.g(floatValue);
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScaleAnimSeekBar.this.aph = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar.this.requestLayout();
        }
    }

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$4 */
    final class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScaleAnimSeekBar.this.apj = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScaleAnimSeekBar.this.requestLayout();
        }
    }

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void rz();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aoD = 100;
        this.aoG = false;
        this.aoV = null;
        this.aoW = false;
        this.aoX = false;
        this.aoY = false;
        this.aoZ = true;
        this.apc = true;
        this.apd = false;
        this.aph = 1.0f;
        this.api = 1.34f;
        this.apj = 1.0f;
        this.apk = 2.0f;
        init(context, attributeSet);
    }

    private void a(int i2, boolean z, boolean z2) {
        int i3 = this.aoC;
        if (i2 <= i3 || i2 >= (i3 = this.aoD)) {
            i2 = i3;
        }
        h(z, i2);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aoK != this.aoJ) {
            this.aoY = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aoY = false;
        }
        this.aoK = this.aoJ;
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f2 = rect.top;
        float f3 = this.apj;
        rect2.top = (int) (f2 * f3);
        rect2.bottom = (int) (rect.bottom * f3);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aoE * this.apj);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void aZ(boolean z) {
        if (this.apc) {
            boolean z2 = z;
            ba(z2);
            bb(z2);
        }
    }

    private float bD(int i2) {
        int i3 = this.aoH;
        int i4 = this.aoC;
        return ((i3 * (i2 - i4)) / (this.aoD - i4)) - (i3 / 2.0f);
    }

    public int bE(int i2) {
        int i3 = this.aoH;
        return i2 > i3 / 2 ? this.aoD : i2 < (-i3) / 2 ? this.aoC : Math.round(((i2 + (i3 / 2.0f)) * (this.aoD - this.aoC)) / i3) + this.aoC;
    }

    private void ba(boolean z) {
        float f2 = this.aph;
        float f3 = z ? this.api : 1.0f;
        ValueAnimator valueAnimator = this.ape;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.ape = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.ape.setInterpolator(new LinearInterpolator());
            this.ape.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                AnonymousClass3() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aph = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.ape.setFloatValues(f2, f3);
        this.ape.start();
    }

    private void bb(boolean z) {
        float f2 = this.apj;
        float f3 = z ? this.apk : 1.0f;
        ValueAnimator valueAnimator = this.apf;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.apf = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.apf.setInterpolator(new LinearInterpolator());
            this.apf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                AnonymousClass4() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.apj = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.apf.setFloatValues(f2, f3);
        this.apf.start();
    }

    private void bd(Context context) {
        this.apc = true;
        this.apl = com.kwad.sdk.c.kwai.a.a(context, 10.0f);
        this.aoB = com.kwad.sdk.c.kwai.a.a(context, 3.0f);
        this.aoI = com.kwad.sdk.c.kwai.a.a(context, 20.0f);
        this.aoV = null;
        this.apd = false;
        this.aoF = com.kwad.sdk.c.kwai.a.a(context, 0.3f);
        this.aoE = com.kwad.sdk.c.kwai.a.a(context, 1.0f);
        this.aoy = 654311423;
        this.aoz = -1;
        this.aoA = 1090519039;
        this.aoC = 0;
        this.aoD = 100;
        this.aoG = false;
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aoV;
        if (drawable != null) {
            drawable.setBounds(this.aoU);
            this.aoV.draw(canvas);
        } else {
            this.aox.setColor(this.aoz);
            canvas.drawCircle(this.aoU.centerX(), this.aoU.centerY(), (this.aoU.width() * this.aph) / 2.0f, this.aox);
        }
        canvas.restore();
    }

    private boolean d(float f2, float f3) {
        int i2;
        int i3;
        Rect rect = this.aoU;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 >= i5 || (i2 = rect.top) >= (i3 = rect.bottom)) {
            return false;
        }
        float f4 = this.aph;
        int i6 = this.aoI;
        return f2 >= (((float) i4) * f4) - ((float) i6) && f2 <= (((float) i5) * f4) + ((float) i6) && f3 >= (((float) i2) * f4) - ((float) i6) && f3 <= (((float) i3) * f4) + ((float) i6);
    }

    private boolean e(float f2, float f3) {
        int i2;
        int i3;
        Rect rect = this.aoR;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 >= i5 || (i2 = rect.top) >= (i3 = rect.bottom)) {
            return false;
        }
        float f4 = this.apj;
        int i6 = this.aoI;
        return f2 >= (((float) i4) * f4) - ((float) i6) && f2 <= (((float) i5) * f4) + ((float) i6) && f3 >= (((float) i2) * f4) - ((float) i6) && f3 <= (((float) i3) * f4) + ((float) i6);
    }

    public void g(float f2) {
        Rect rect = this.aoU;
        int i2 = this.aoB;
        rect.left = (int) (f2 - i2);
        rect.right = (int) (i2 + f2);
        this.aoS.right = (int) f2;
        invalidate();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.apb;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float h(float f2) {
        float f3 = this.aoH / 2;
        if (f2 > f3) {
            return f3;
        }
        float f4 = -f3;
        return f2 < f4 ? f4 : f2;
    }

    private void h(boolean z, int i2) {
        if (!z) {
            this.aoJ = i2;
            g(h(bD(i2)));
            return;
        }
        float h2 = h(bD(this.aoJ));
        float h3 = h(bD(i2));
        ValueAnimator valueAnimator = this.apg;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.apg = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.apg.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                AnonymousClass1() {
                }

                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f2) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3) + 1.0f;
                }
            });
            this.apg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                AnonymousClass2() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aoJ = scaleAnimSeekBar.bE((int) floatValue);
                    ScaleAnimSeekBar.this.g(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.apg.setFloatValues(h2, h3);
        this.apg.start();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bd(context);
        }
        Paint paint = new Paint();
        this.aox = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aox.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aoO = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aoO.setColor(this.aoy);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aoP = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aoP.setColor(this.aoz);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aoQ = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aoQ.setColor(this.aoA);
        this.aoR = new Rect();
        this.aoS = new Rect();
        this.aoU = new Rect();
        this.aoT = new Rect();
        this.aoJ = this.aoC;
    }

    private void s(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.aoH = this.apc ? (int) (i2 - ((this.apl * 2) * (this.api - this.aph))) : i2 - (this.apl * 2);
        Rect rect = this.aoR;
        int i4 = this.aoF;
        int i5 = -i4;
        rect.top = i5;
        rect.bottom = -i5;
        boolean z = this.aoG;
        rect.left = (z ? -i2 : -this.aoH) / 2;
        rect.right = z ? i2 / 2 : this.aoH / 2;
        Rect rect2 = this.aoS;
        int i6 = -i4;
        rect2.top = i6;
        rect2.bottom = -i6;
        rect2.left = (z ? -i2 : -this.aoH) / 2;
        int i7 = this.aoH;
        rect2.right = (-i7) / 2;
        Rect rect3 = this.aoT;
        rect3.top = -i4;
        rect3.bottom = -rect2.top;
        rect3.left = (z ? -i2 : -i7) / 2;
        rect3.right = (-i7) / 2;
        Rect rect4 = this.aoU;
        int i8 = this.aoB;
        rect4.top = -i8;
        rect4.bottom = i8;
        rect4.left = ((-i7) / 2) - i8;
        rect4.right = ((-i7) / 2) + i8;
        setThumbDrawable(this.aoV);
        setProgress(this.aoJ);
        setSecondaryProgress(this.aoL);
    }

    public final void aY(boolean z) {
        this.apm = z;
        aZ(z);
    }

    public int getMaxProgress() {
        return this.aoD;
    }

    public int getProgress() {
        return this.aoJ;
    }

    public int getProgressLength() {
        return this.aoH;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aoB * this.api));
    }

    public int getSecondaryProgress() {
        return this.aoL;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aoN / 2, this.aoM / 2);
        a(canvas, this.aoR, this.aoO);
        a(canvas, this.aoT, this.aoQ);
        a(canvas, this.aoS, this.aoP);
        if (this.apm) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            size = getWidth();
        }
        this.aoN = size;
        if (mode2 == 1073741824) {
            this.aoM = size2;
        } else {
            this.aoM = getHeight();
        }
        s(this.aoN, this.aoM);
        setMeasuredDimension(this.aoN, this.aoM);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        if (r3 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        r3.requestDisallowInterceptTouchEvent(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
    
        if (r3 != null) goto L73;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            int r1 = r7.aoN
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            float r0 = r0 - r1
            float r1 = r8.getY()
            int r3 = r7.aoM
            int r3 = r3 / r2
            float r3 = (float) r3
            float r1 = r1 - r3
            android.view.ViewParent r3 = r7.getParent()
            com.kwad.sdk.core.view.ScaleAnimSeekBar$a r4 = r7.getOnSeekBarChangedListener()
            int r5 = r8.getAction()
            r6 = 1
            if (r5 == 0) goto L5d
            r8 = 0
            if (r5 == r6) goto L3a
            if (r5 == r2) goto L29
            goto L91
        L29:
            boolean r1 = r7.aoW
            if (r1 != 0) goto L31
            boolean r1 = r7.aoX
            if (r1 == 0) goto L91
        L31:
            int r0 = (int) r0
            int r0 = r7.bE(r0)
            r7.a(r0, r8, r6)
            goto L91
        L3a:
            r7.apa = r8
            boolean r1 = r7.aoX
            if (r1 != 0) goto L44
            boolean r1 = r7.aoW
            if (r1 == 0) goto L57
        L44:
            r7.aoX = r8
            r7.aoW = r8
            int r0 = (int) r0
            int r0 = r7.bE(r0)
            boolean r1 = r7.apd
            r7.a(r0, r1, r6)
            if (r4 == 0) goto L57
            r4.a(r7)
        L57:
            if (r3 == 0) goto L91
            r3.requestDisallowInterceptTouchEvent(r8)
            goto L91
        L5d:
            boolean r2 = r7.aoZ
            if (r2 != 0) goto L66
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L66:
            boolean r8 = r7.d(r0, r1)
            if (r8 == 0) goto L7e
            r7.aZ(r6)
            r7.aoW = r6
            r7.apa = r6
            if (r4 == 0) goto L78
            r4.rz()
        L78:
            if (r3 == 0) goto L91
        L7a:
            r3.requestDisallowInterceptTouchEvent(r6)
            goto L91
        L7e:
            boolean r8 = r7.e(r0, r1)
            if (r8 == 0) goto L91
            r7.aZ(r6)
            r7.aoX = r6
            if (r4 == 0) goto L8e
            r4.rz()
        L8e:
            if (r3 == 0) goto L91
            goto L7a
        L91:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.view.ScaleAnimSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setMaxProgress(int i2) {
        this.aoD = i2;
    }

    public void setMinProgress(int i2) {
        this.aoC = i2;
        if (this.aoJ < i2) {
            this.aoJ = i2;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.apb = new WeakReference<>(aVar);
    }

    public void setProgress(int i2) {
        a(i2, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i2) {
        this.aoy = i2;
        this.aoO.setColor(i2);
    }

    public void setProgressColor(@ColorInt int i2) {
        this.aoz = i2;
        this.aoP.setColor(i2);
    }

    public void setSecondaryProgress(int i2) {
        int i3 = this.aoC;
        if (i2 <= i3 || i2 >= (i3 = this.aoD)) {
            i2 = i3;
        }
        this.aoL = i2;
        this.aoT.right = (int) h(bD(i2));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i2) {
        this.aoA = i2;
        this.aoQ.setColor(i2);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aoV = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aoZ = z;
    }

    public void setThumbScale(float f2) {
        this.aph = f2;
    }

    public void setThumbTouchOffset(int i2) {
        this.aoI = i2;
        invalidate();
    }
}
