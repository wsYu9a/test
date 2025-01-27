package com.sigmob.sdk.base.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.czhj.sdk.common.utils.Dips;
import com.martian.libmars.widget.FoldedTextView;

/* loaded from: classes4.dex */
public class g0 extends View {

    /* renamed from: a */
    public Paint f18574a;

    /* renamed from: b */
    public RectF f18575b;

    /* renamed from: c */
    public float f18576c;

    /* renamed from: d */
    public String f18577d;

    /* renamed from: e */
    public Paint f18578e;

    /* renamed from: f */
    public Path f18579f;

    /* renamed from: g */
    public Paint f18580g;

    /* renamed from: h */
    public Path f18581h;

    /* renamed from: i */
    public int f18582i;

    /* renamed from: j */
    public int f18583j;

    /* renamed from: k */
    public int f18584k;

    /* renamed from: l */
    public float f18585l;

    /* renamed from: m */
    public int f18586m;

    /* renamed from: n */
    public int f18587n;

    /* renamed from: o */
    public int f18588o;

    /* renamed from: p */
    public int f18589p;

    /* renamed from: q */
    public ValueAnimator f18590q;

    /* renamed from: r */
    public ValueAnimator f18591r;
    private String title;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g0.this.f18582i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g0.this.d();
            g0.this.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g0.this.f18585l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    public g0(Context context) {
        super(context);
        this.f18585l = 1.0f;
        a();
    }

    public final void b() {
        this.f18579f = new Path();
        this.f18580g = new Paint();
        this.f18583j = this.f18587n;
        this.f18584k = Dips.dipsToIntPixels(60.0f, getContext());
        this.f18580g.setShader(new LinearGradient(0.0f, this.f18583j, this.f18584k, 0.0f, new int[]{a(-1, 0.2f), a(-1, 0.5f), a(-1, 0.2f)}, new float[]{0.2f, 0.8f, 1.0f}, Shader.TileMode.MIRROR));
    }

    public final void c() {
        ValueAnimator valueAnimator = this.f18590q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.f18584k, this.f18586m + this.f18587n);
        this.f18590q = ofInt;
        ofInt.addUpdateListener(new a());
        this.f18590q.setDuration(800L);
        this.f18590q.setRepeatCount(-1);
        this.f18590q.setRepeatMode(1);
        this.f18590q.start();
        ValueAnimator valueAnimator2 = this.f18591r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.15f);
        this.f18591r = ofFloat;
        ofFloat.addUpdateListener(new b());
        this.f18591r.setDuration(1000L);
        this.f18591r.setRepeatCount(-1);
        this.f18591r.setRepeatMode(2);
        this.f18591r.start();
    }

    public final void d() {
        this.f18579f.reset();
        this.f18579f.moveTo((this.f18584k / 2.0f) + this.f18582i, 0.0f);
        this.f18579f.lineTo(this.f18584k + this.f18582i, 0.0f);
        this.f18579f.lineTo((this.f18584k / 2.0f) + this.f18582i, this.f18583j);
        this.f18579f.lineTo(this.f18582i, this.f18583j);
        this.f18579f.close();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f18590q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f18591r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        super.onDraw(canvas);
        this.f18574a.setStyle(Paint.Style.STROKE);
        this.f18574a.setColor(-1);
        this.f18574a.setAlpha(204);
        this.f18574a.setStrokeWidth(this.f18576c);
        RectF rectF = this.f18575b;
        float f11 = this.f18576c;
        float f12 = f11 * 2.0f;
        rectF.set(f11, f11, this.f18586m - f12, this.f18587n - f12);
        Path path = this.f18581h;
        RectF rectF2 = this.f18575b;
        float f13 = this.f18589p;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF2, f13, f13, direction);
        canvas.drawPath(this.f18581h, this.f18574a);
        Paint paint = this.f18574a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f18574a.setColor(-16777216);
        this.f18574a.setAlpha(76);
        this.f18581h.reset();
        Path path2 = this.f18581h;
        RectF rectF3 = this.f18575b;
        path2.addRoundRect(rectF3, rectF3.height() / 2.0f, this.f18575b.height() / 2.0f, direction);
        canvas.drawPath(this.f18581h, this.f18574a);
        float f14 = this.f18587n * 0.3f;
        float f15 = this.f18585l * f14;
        float f16 = this.f18586m - (f14 * 2.0f);
        this.f18574a.setColor(-1);
        this.f18574a.setStyle(style);
        canvas.drawCircle(f16, this.f18587n / 2, f15, this.f18574a);
        this.f18574a.setColor(-16777216);
        this.f18574a.setTextSize(TypedValue.applyDimension(2, this.f18585l * 16.0f, getResources().getDisplayMetrics()));
        Paint paint2 = this.f18574a;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        paint2.setTypeface(typeface);
        float measureText = f16 - (this.f18574a.measureText("GO") / 1.5f);
        canvas.drawText("GO", measureText, ((this.f18587n / 2) + ((this.f18574a.getFontMetrics().bottom - this.f18574a.getFontMetrics().top) / 2.0f)) - this.f18574a.getFontMetrics().bottom, this.f18574a);
        float measureText2 = this.f18574a.measureText("GO") * 0.4f;
        Path path3 = new Path();
        float f17 = measureText2 / 4.0f;
        float f18 = measureText2 / 2.0f;
        path3.moveTo(this.f18574a.measureText("GO") + measureText + f17, (this.f18587n / 2) - f18);
        path3.lineTo(this.f18574a.measureText("GO") + measureText + measureText2, this.f18587n / 2);
        path3.lineTo(measureText + this.f18574a.measureText("GO") + f17, (this.f18587n / 2) + f18);
        path3.close();
        canvas.drawPath(path3, this.f18574a);
        this.f18578e.setStyle(style);
        this.f18578e.setColor(-1);
        int i10 = 5;
        if (TextUtils.isEmpty(this.title)) {
            f10 = 0.0f;
        } else {
            this.f18578e.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
            this.f18578e.setTypeface(typeface);
            String str = this.title;
            f10 = (this.f18578e.getFontMetrics().bottom - this.f18578e.getFontMetrics().top) * 1.5f;
            int i11 = 5;
            while (true) {
                if (i11 >= this.title.length()) {
                    break;
                }
                float measureText3 = this.f18578e.measureText(this.title, 0, i11) + f10;
                RectF rectF4 = this.f18575b;
                if (measureText3 > ((rectF4.right - rectF4.left) - f10) - f15) {
                    str = this.title.substring(0, i11 - 2) + FoldedTextView.f12585y;
                    break;
                }
                i11++;
            }
            canvas.drawText(str, f10, ((this.f18587n / 2) - (this.f18578e.getFontMetrics().bottom - this.f18578e.getFontMetrics().top)) - this.f18578e.getFontMetrics().top, this.f18578e);
        }
        if (!TextUtils.isEmpty(this.f18577d)) {
            this.f18578e.setTextSize(TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            this.f18578e.setTypeface(Typeface.DEFAULT);
            float f19 = f10 > 0.0f ? f10 : (this.f18578e.getFontMetrics().bottom - this.f18578e.getFontMetrics().top) * 1.5f;
            String str2 = this.f18577d;
            while (true) {
                if (i10 >= this.f18577d.length()) {
                    break;
                }
                float measureText4 = this.f18578e.measureText(this.f18577d, 0, i10) + f10;
                RectF rectF5 = this.f18575b;
                if (measureText4 > ((rectF5.right - rectF5.left) - f10) - f15) {
                    str2 = this.f18577d.substring(0, i10 - 2) + FoldedTextView.f12585y;
                    break;
                }
                i10++;
            }
            canvas.drawText(str2, f19, (this.f18587n / 2) + (this.f18578e.getFontMetrics().bottom - this.f18578e.getFontMetrics().top), this.f18578e);
        }
        canvas.clipPath(this.f18581h);
        canvas.drawPath(this.f18579f, this.f18580g);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18586m = i10;
        this.f18587n = (int) (i11 * 0.8f);
        this.f18588o = i10 / 2;
        this.f18589p = i11 / 2;
        b();
        c();
    }

    public g0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18585l = 1.0f;
        a();
    }

    public g0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18585l = 1.0f;
        a();
    }

    public final int a(int i10, float f10) {
        return Color.argb((int) (Color.alpha(i10) * f10), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public final void a() {
        setBackgroundColor(SupportMenu.CATEGORY_MASK);
        this.f18574a = new Paint(1);
        this.f18578e = new Paint(1);
        this.f18575b = new RectF();
        this.f18581h = new Path();
        this.f18576c = Dips.dipsToIntPixels(2.0f, getContext());
        setBackgroundColor(0);
    }

    public void a(String str, String str2) {
        this.title = str;
        this.f18577d = str2;
    }
}
