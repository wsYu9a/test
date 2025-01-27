package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.martian.libmars.common.ConfigSingleton;
import java.util.Arrays;
import java.util.List;
import m9.e;
import m9.i;

/* loaded from: classes3.dex */
public class LinePagerIndicator extends View implements e {

    /* renamed from: p */
    public static final int f12444p = 0;

    /* renamed from: q */
    public static final int f12445q = 1;

    /* renamed from: r */
    public static final int f12446r = 2;

    /* renamed from: b */
    public int f12447b;

    /* renamed from: c */
    public Interpolator f12448c;

    /* renamed from: d */
    public Interpolator f12449d;

    /* renamed from: e */
    public float f12450e;

    /* renamed from: f */
    public float f12451f;

    /* renamed from: g */
    public float f12452g;

    /* renamed from: h */
    public float f12453h;

    /* renamed from: i */
    public float f12454i;

    /* renamed from: j */
    public float f12455j;

    /* renamed from: k */
    public Paint f12456k;

    /* renamed from: l */
    public List<i> f12457l;

    /* renamed from: m */
    public List<Integer> f12458m;

    /* renamed from: n */
    public int f12459n;

    /* renamed from: o */
    public final RectF f12460o;

    public LinePagerIndicator(Context context) {
        super(context);
        this.f12448c = new LinearInterpolator();
        this.f12449d = new LinearInterpolator();
        this.f12460o = new RectF();
        b();
    }

    @Override // m9.e
    public void a(List<i> list) {
        this.f12457l = list;
    }

    public final void b() {
        Paint paint = new Paint(1);
        this.f12456k = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12451f = ConfigSingleton.i(3.0f);
        this.f12454i = ConfigSingleton.i(10.0f);
    }

    public LinePagerIndicator c(int i10) {
        this.f12459n = i10;
        return this;
    }

    public LinePagerIndicator d(Integer... numArr) {
        this.f12458m = Arrays.asList(numArr);
        return this;
    }

    public LinePagerIndicator e(Interpolator interpolator) {
        this.f12449d = interpolator;
        if (interpolator == null) {
            this.f12449d = new LinearInterpolator();
        }
        return this;
    }

    public LinePagerIndicator f(float f10) {
        this.f12451f = f10;
        return this;
    }

    public LinePagerIndicator g(float f10) {
        this.f12454i = f10;
        return this;
    }

    public List<Integer> getColors() {
        return this.f12458m;
    }

    public Interpolator getEndInterpolator() {
        return this.f12449d;
    }

    public float getLineHeight() {
        return this.f12451f;
    }

    public float getLineWidth() {
        return this.f12454i;
    }

    public int getMode() {
        return this.f12447b;
    }

    public Paint getPaint() {
        return this.f12456k;
    }

    public float getRoundRadius() {
        return this.f12455j;
    }

    public Interpolator getStartInterpolator() {
        return this.f12448c;
    }

    public float getXOffset() {
        return this.f12453h;
    }

    public float getYOffset() {
        return this.f12450e;
    }

    public LinePagerIndicator h(float f10) {
        this.f12451f = -1.0f;
        this.f12452g = f10;
        this.f12450e = f10;
        return this;
    }

    public LinePagerIndicator i(int i10) {
        if (i10 == 2 || i10 == 0 || i10 == 1) {
            this.f12447b = i10;
            return this;
        }
        throw new IllegalArgumentException("mode " + i10 + " not supported.");
    }

    public LinePagerIndicator j(float f10) {
        this.f12455j = f10;
        return this;
    }

    public LinePagerIndicator k(Interpolator interpolator) {
        this.f12448c = interpolator;
        if (interpolator == null) {
            this.f12448c = new LinearInterpolator();
        }
        return this;
    }

    public LinePagerIndicator l(float f10) {
        this.f12450e = f10;
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f12460o;
        float f10 = this.f12455j;
        canvas.drawRoundRect(rectF, f10, f10, this.f12456k);
    }

    @Override // m9.e
    public void onPageScrollStateChanged(int i10) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f6  */
    @Override // m9.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageScrolled(int r6, float r7, int r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.utils.tablayout.LinePagerIndicator.onPageScrolled(int, float, int):void");
    }

    @Override // m9.e
    public void onPageSelected(int i10) {
    }

    public void setXOffset(float f10) {
        this.f12453h = f10;
    }
}
