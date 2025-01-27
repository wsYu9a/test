package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes4.dex */
public class c extends View {

    /* renamed from: a */
    public int f22010a;

    /* renamed from: b */
    public final int f22011b;

    /* renamed from: c */
    private Paint f22012c;

    /* renamed from: d */
    private int f22013d;

    /* renamed from: e */
    private int f22014e;

    /* renamed from: f */
    private int f22015f;

    /* renamed from: g */
    private int f22016g;

    /* renamed from: h */
    private int f22017h;

    /* renamed from: i */
    private int f22018i;

    /* renamed from: j */
    private int f22019j;
    private int k;
    private Bitmap l;

    public static class a {

        /* renamed from: a */
        public final int f22020a;

        /* renamed from: b */
        public final int f22021b;

        /* renamed from: c */
        public final int f22022c;

        public a(int i2, int i3, int i4) {
            this.f22020a = i2;
            this.f22021b = i3;
            this.f22022c = i4;
        }
    }

    public c(Context context, a aVar) {
        super(context);
        setBackgroundColor(-1);
        int i2 = aVar.f22020a;
        this.f22011b = i2;
        Paint paint = new Paint();
        this.f22012c = paint;
        paint.setAntiAlias(true);
        this.f22012c.setStyle(Paint.Style.FILL);
        this.f22012c.setColor(486539264);
        this.f22013d = com.opos.cmn.an.h.f.a.a(getContext(), aVar.f22021b / 2);
        this.f22014e = com.opos.cmn.an.h.f.a.a(getContext(), aVar.f22022c / 2);
        this.f22010a = com.opos.cmn.an.h.f.a.a(getContext(), i2);
        this.f22015f = (com.opos.cmn.an.h.f.a.a(getContext(), aVar.f22021b) - this.f22010a) / 2;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), aVar.f22022c);
        int i3 = this.f22010a;
        int i4 = (a2 - i3) / 2;
        this.f22016g = i4;
        this.f22017h = this.f22015f + i3;
        this.f22018i = i4 + i3;
        this.f22019j = i3 + com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i3, i4);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f2 = i2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static c a(Context context) {
        return new c(context, new a(121, 258, 169));
    }

    private void a(Canvas canvas) {
        if (this.l == null) {
            com.opos.cmn.an.f.a.a("cell icon", "not set bitmap");
            return;
        }
        int save = canvas.save();
        canvas.rotate(-45.0f, this.f22013d, this.f22014e);
        Rect rect = new Rect(0, 0, this.l.getWidth(), this.l.getHeight());
        int i2 = this.f22015f;
        int i3 = this.f22019j;
        RectF rectF = new RectF(i2 - i3, this.f22016g - i3, this.f22017h - i3, this.f22018i - i3);
        int i4 = this.k;
        canvas.drawRoundRect(rectF, i4, i4, this.f22012c);
        a(canvas, this.l, rect, rectF);
        float f2 = this.f22015f;
        int i5 = this.f22016g;
        int i6 = this.f22019j;
        RectF rectF2 = new RectF(f2, i5 - i6, this.f22017h, this.f22018i - i6);
        int i7 = this.k;
        canvas.drawRoundRect(rectF2, i7, i7, this.f22012c);
        a(canvas, this.l, rect, rectF2);
        int i8 = this.f22015f;
        int i9 = this.f22019j;
        RectF rectF3 = new RectF(i8 - i9, this.f22016g, this.f22017h - i9, this.f22018i);
        int i10 = this.k;
        canvas.drawRoundRect(rectF3, i10, i10, this.f22012c);
        a(canvas, this.l, rect, rectF3);
        RectF rectF4 = new RectF(this.f22015f, this.f22016g, this.f22017h, this.f22018i);
        int i11 = this.k;
        canvas.drawRoundRect(rectF4, i11, i11, this.f22012c);
        a(canvas, this.l, rect, rectF4);
        int i12 = this.f22015f;
        int i13 = this.f22019j;
        RectF rectF5 = new RectF(i12 + i13, this.f22016g, this.f22017h + i13, this.f22018i);
        int i14 = this.k;
        canvas.drawRoundRect(rectF5, i14, i14, this.f22012c);
        a(canvas, this.l, rect, rectF5);
        float f3 = this.f22015f;
        int i15 = this.f22016g;
        int i16 = this.f22019j;
        RectF rectF6 = new RectF(f3, i15 + i16, this.f22017h, this.f22018i + i16);
        int i17 = this.k;
        canvas.drawRoundRect(rectF6, i17, i17, this.f22012c);
        a(canvas, this.l, rect, rectF6);
        int i18 = this.f22015f;
        int i19 = this.f22019j;
        RectF rectF7 = new RectF(i18 + i19, this.f22016g + i19, this.f22017h + i19, this.f22018i + i19);
        int i20 = this.k;
        canvas.drawRoundRect(rectF7, i20, i20, this.f22012c);
        a(canvas, this.l, rect, rectF7);
        canvas.restoreToCount(save);
    }

    private void a(Canvas canvas, Bitmap bitmap, Rect rect, RectF rectF) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
        }
    }

    public static c b(Context context) {
        return new c(context, new a(128, 272, 179));
    }

    public void a(Bitmap bitmap, int i2) {
        if (bitmap == null) {
            com.opos.cmn.an.f.a.b("", "null bitmap");
        }
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), i2);
        this.k = a2;
        int i3 = this.f22010a;
        this.l = a(bitmap, a2, i3, i3);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
        super.onDraw(canvas);
    }
}
