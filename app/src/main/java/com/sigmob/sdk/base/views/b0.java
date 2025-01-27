package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes4.dex */
public class b0 extends Drawable {

    /* renamed from: i */
    public static final int f18467i = 1;

    /* renamed from: a */
    public final Paint f18468a;

    /* renamed from: b */
    public final int f18469b;

    /* renamed from: c */
    public final int f18470c;

    /* renamed from: d */
    public final int f18471d;

    /* renamed from: e */
    public final int f18472e;

    /* renamed from: f */
    public final int f18473f;

    /* renamed from: g */
    public final int[] f18474g;

    /* renamed from: h */
    public RectF f18475h;

    public static class b {

        /* renamed from: e */
        public int f18480e;

        /* renamed from: f */
        public int f18481f;

        /* renamed from: a */
        public int f18476a = 1;

        /* renamed from: b */
        public int f18477b = 12;

        /* renamed from: c */
        public int f18478c = Color.parseColor("#4d000000");

        /* renamed from: d */
        public int f18479d = 18;

        /* renamed from: g */
        public int[] f18482g = {0};

        public b() {
            this.f18480e = 0;
            this.f18481f = 0;
            this.f18480e = 0;
            this.f18481f = 0;
        }

        public b0 a() {
            return new b0(this.f18476a, this.f18482g, this.f18477b, this.f18478c, this.f18479d, this.f18480e, this.f18481f);
        }

        public b b(int i10) {
            this.f18480e = i10;
            return this;
        }

        public b c(int i10) {
            this.f18481f = i10;
            return this;
        }

        public b d(int i10) {
            this.f18478c = i10;
            return this;
        }

        public b e(int i10) {
            this.f18479d = i10;
            return this;
        }

        public b f(int i10) {
            this.f18476a = i10;
            return this;
        }

        public b g(int i10) {
            this.f18477b = i10;
            return this;
        }

        public b a(int i10) {
            this.f18482g[0] = i10;
            return this;
        }

        public b a(int[] iArr) {
            this.f18482g = iArr;
            return this;
        }
    }

    public b0(int i10, int[] iArr, int i11, int i12, int i13, int i14, int i15) {
        this.f18470c = i10;
        this.f18474g = iArr;
        this.f18471d = i11;
        this.f18469b = i13;
        this.f18472e = i14;
        this.f18473f = i15;
        Paint paint = new Paint();
        this.f18468a = paint;
        paint.setColor(0);
        paint.setAntiAlias(true);
        paint.setShadowLayer(i13, i14, i15, i12);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    public static void a(View view, int i10, int i11, int i12, int i13, int i14, int i15) {
        b0 a10 = new b().a(i10).g(i11).d(i12).e(i13).b(i14).c(i15).a();
        view.setLayerType(1, null);
        view.setBackground(a10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int[] iArr = this.f18474g;
        if (iArr != null) {
            if (iArr.length == 1) {
                paint.setColor(iArr[0]);
            } else {
                RectF rectF = this.f18475h;
                float f10 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.f18475h;
                paint.setShader(new LinearGradient(f10, height, rectF2.right, rectF2.height() / 2.0f, this.f18474g, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        paint.setAntiAlias(true);
        if (this.f18470c != 1) {
            canvas.drawCircle(this.f18475h.centerX(), this.f18475h.centerY(), Math.min(this.f18475h.width(), this.f18475h.height()) / 2.0f, this.f18468a);
            canvas.drawCircle(this.f18475h.centerX(), this.f18475h.centerY(), Math.min(this.f18475h.width(), this.f18475h.height()) / 2.0f, paint);
            return;
        }
        RectF rectF3 = this.f18475h;
        float f11 = this.f18471d;
        canvas.drawRoundRect(rectF3, f11, f11, this.f18468a);
        RectF rectF4 = this.f18475h;
        float f12 = this.f18471d;
        canvas.drawRoundRect(rectF4, f12, f12, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f18468a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        int i14 = this.f18469b;
        int i15 = this.f18472e;
        int i16 = this.f18473f;
        this.f18475h = new RectF((i10 + i14) - i15, (i11 + i14) - i16, (i12 - i14) - i15, (i13 - i14) - i16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f18468a.setColorFilter(colorFilter);
    }

    public /* synthetic */ b0(int i10, int[] iArr, int i11, int i12, int i13, int i14, int i15, a aVar) {
        this(i10, iArr, i11, i12, i13, i14, i15);
    }
}
