package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class LinePagerIndicator extends View implements h {

    /* renamed from: a */
    public static final int f10208a = 0;

    /* renamed from: b */
    public static final int f10209b = 1;

    /* renamed from: c */
    public static final int f10210c = 2;

    /* renamed from: d */
    private int f10211d;

    /* renamed from: e */
    private Interpolator f10212e;

    /* renamed from: f */
    private Interpolator f10213f;

    /* renamed from: g */
    private float f10214g;

    /* renamed from: h */
    private float f10215h;

    /* renamed from: i */
    private float f10216i;

    /* renamed from: j */
    private float f10217j;
    private float k;
    private Paint l;
    private List<l> m;
    private List<Integer> n;
    private final RectF o;

    public LinePagerIndicator(Context context) {
        super(context);
        this.f10212e = new LinearInterpolator();
        this.f10213f = new LinearInterpolator();
        this.o = new RectF();
        b();
    }

    private void b() {
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f10215h = com.martian.libmars.d.h.b(3.0f);
        this.f10217j = com.martian.libmars.d.h.b(10.0f);
    }

    @Override // com.martian.libmars.utils.tablayout.h
    public void a(List<l> dataList) {
        this.m = dataList;
    }

    public LinePagerIndicator c(Integer... colors) {
        this.n = Arrays.asList(colors);
        return this;
    }

    public LinePagerIndicator d(Interpolator endInterpolator) {
        this.f10213f = endInterpolator;
        if (endInterpolator == null) {
            this.f10213f = new LinearInterpolator();
        }
        return this;
    }

    public LinePagerIndicator e(float lineHeight) {
        this.f10215h = lineHeight;
        return this;
    }

    public LinePagerIndicator f(float lineWidth) {
        this.f10217j = lineWidth;
        return this;
    }

    public LinePagerIndicator g(int mode) {
        if (mode == 2 || mode == 0 || mode == 1) {
            this.f10211d = mode;
            return this;
        }
        throw new IllegalArgumentException("mode " + mode + " not supported.");
    }

    public List<Integer> getColors() {
        return this.n;
    }

    public Interpolator getEndInterpolator() {
        return this.f10213f;
    }

    public float getLineHeight() {
        return this.f10215h;
    }

    public float getLineWidth() {
        return this.f10217j;
    }

    public int getMode() {
        return this.f10211d;
    }

    public Paint getPaint() {
        return this.l;
    }

    public float getRoundRadius() {
        return this.k;
    }

    public Interpolator getStartInterpolator() {
        return this.f10212e;
    }

    public float getXOffset() {
        return this.f10216i;
    }

    public float getYOffset() {
        return this.f10214g;
    }

    public LinePagerIndicator h(float roundRadius) {
        this.k = roundRadius;
        return this;
    }

    public LinePagerIndicator i(Interpolator startInterpolator) {
        this.f10212e = startInterpolator;
        if (startInterpolator == null) {
            this.f10212e = new LinearInterpolator();
        }
        return this;
    }

    public LinePagerIndicator j(float yOffset) {
        this.f10214g = yOffset;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.o;
        float f2 = this.k;
        canvas.drawRoundRect(rectF, f2, f2, this.l);
    }

    @Override // com.martian.libmars.utils.tablayout.h
    public void onPageScrollStateChanged(int state) {
    }

    @Override // com.martian.libmars.utils.tablayout.h
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i2;
        List<l> list = this.m;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.n;
        if (list2 != null && list2.size() > 0) {
            this.l.setColor(c.a(positionOffset, this.n.get(Math.abs(position) % this.n.size()).intValue(), this.n.get(Math.abs(position + 1) % this.n.size()).intValue()));
        }
        l g2 = g.g(this.m, position);
        l g3 = g.g(this.m, position + 1);
        int i3 = this.f10211d;
        if (i3 == 0) {
            float f7 = g2.f10255a;
            f6 = this.f10216i;
            f2 = f7 + f6;
            f5 = g3.f10255a + f6;
            f3 = g2.f10257c - f6;
            i2 = g3.f10257c;
        } else {
            if (i3 != 1) {
                f2 = g2.f10255a + ((g2.f() - this.f10217j) / 2.0f);
                float f8 = g3.f10255a + ((g3.f() - this.f10217j) / 2.0f);
                f3 = ((g2.f() + this.f10217j) / 2.0f) + g2.f10255a;
                f4 = ((g3.f() + this.f10217j) / 2.0f) + g3.f10255a;
                f5 = f8;
                this.o.left = f2 + ((f5 - f2) * this.f10212e.getInterpolation(positionOffset));
                this.o.right = f3 + ((f4 - f3) * this.f10213f.getInterpolation(positionOffset));
                this.o.top = (getHeight() - this.f10215h) - this.f10214g;
                this.o.bottom = getHeight() - this.f10214g;
                invalidate();
            }
            float f9 = g2.f10259e;
            f6 = this.f10216i;
            f2 = f9 + f6;
            f5 = g3.f10259e + f6;
            f3 = g2.f10261g - f6;
            i2 = g3.f10261g;
        }
        f4 = i2 - f6;
        this.o.left = f2 + ((f5 - f2) * this.f10212e.getInterpolation(positionOffset));
        this.o.right = f3 + ((f4 - f3) * this.f10213f.getInterpolation(positionOffset));
        this.o.top = (getHeight() - this.f10215h) - this.f10214g;
        this.o.bottom = getHeight() - this.f10214g;
        invalidate();
    }

    @Override // com.martian.libmars.utils.tablayout.h
    public void onPageSelected(int position) {
    }

    public void setXOffset(float xOffset) {
        this.f10216i = xOffset;
    }
}
