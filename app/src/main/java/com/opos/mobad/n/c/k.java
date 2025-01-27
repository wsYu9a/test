package com.opos.mobad.n.c;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* loaded from: classes4.dex */
public class k extends Drawable {

    /* renamed from: a */
    private Paint f22042a;

    /* renamed from: b */
    private Paint f22043b;

    /* renamed from: c */
    private int f22044c;

    /* renamed from: d */
    private int f22045d;

    /* renamed from: e */
    private int f22046e;

    /* renamed from: f */
    private int f22047f;

    /* renamed from: g */
    private int f22048g;

    /* renamed from: h */
    private int[] f22049h;

    /* renamed from: i */
    private RectF f22050i;

    public static class a {

        /* renamed from: e */
        private int f22055e;

        /* renamed from: f */
        private int f22056f;

        /* renamed from: a */
        private int f22051a = 1;

        /* renamed from: b */
        private int f22052b = 12;

        /* renamed from: c */
        private int f22053c = Color.parseColor("#4d000000");

        /* renamed from: d */
        private int f22054d = 18;

        /* renamed from: g */
        private int[] f22057g = {0};

        public a() {
            this.f22055e = 0;
            this.f22056f = 0;
            this.f22055e = 0;
            this.f22056f = 0;
        }

        public a a(int i2) {
            this.f22052b = i2;
            return this;
        }

        public k a() {
            return new k(this.f22051a, this.f22057g, this.f22052b, this.f22053c, this.f22054d, this.f22055e, this.f22056f);
        }

        public a b(int i2) {
            this.f22053c = i2;
            return this;
        }

        public a c(int i2) {
            this.f22054d = i2;
            return this;
        }

        public a d(int i2) {
            this.f22055e = i2;
            return this;
        }

        public a e(int i2) {
            this.f22056f = i2;
            return this;
        }

        public a f(int i2) {
            this.f22057g[0] = i2;
            return this;
        }
    }

    private k(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        this.f22045d = i2;
        this.f22049h = iArr;
        this.f22046e = i3;
        this.f22044c = i5;
        this.f22047f = i6;
        this.f22048g = i7;
        Paint paint = new Paint();
        this.f22042a = paint;
        paint.setColor(0);
        this.f22042a.setAntiAlias(true);
        this.f22042a.setShadowLayer(i5, i6, i7, i4);
        this.f22042a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f22043b = paint2;
        paint2.setAntiAlias(true);
    }

    /* synthetic */ k(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(i2, iArr, i3, i4, i5, i6, i7);
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        k a2 = new a().f(i2).a(i3).b(i4).c(i5).d(i6).e(i7).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.f22049h;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f22043b.setColor(iArr[0]);
            } else {
                Paint paint = this.f22043b;
                RectF rectF = this.f22050i;
                float f2 = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.f22050i;
                paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f22049h, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f22045d != 1) {
            canvas.drawCircle(this.f22050i.centerX(), this.f22050i.centerY(), Math.min(this.f22050i.width(), this.f22050i.height()) / 2.0f, this.f22042a);
            canvas.drawCircle(this.f22050i.centerX(), this.f22050i.centerY(), Math.min(this.f22050i.width(), this.f22050i.height()) / 2.0f, this.f22043b);
            return;
        }
        RectF rectF3 = this.f22050i;
        int i2 = this.f22046e;
        canvas.drawRoundRect(rectF3, i2, i2, this.f22042a);
        RectF rectF4 = this.f22050i;
        int i3 = this.f22046e;
        canvas.drawRoundRect(rectF4, i3, i3, this.f22043b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f22042a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        int i6 = this.f22044c;
        int i7 = this.f22047f;
        int i8 = this.f22048g;
        this.f22050i = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f22042a.setColorFilter(colorFilter);
    }
}
