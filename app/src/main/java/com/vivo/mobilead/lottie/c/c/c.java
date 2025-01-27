package com.vivo.mobilead.lottie.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.p;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: e */
    private final Paint f29345e;

    /* renamed from: f */
    private final Rect f29346f;

    /* renamed from: g */
    private final Rect f29347g;

    /* renamed from: h */
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> f29348h;

    c(com.vivo.mobilead.lottie.c cVar, d dVar) {
        super(cVar, dVar);
        this.f29345e = new com.vivo.mobilead.lottie.a.a(3);
        this.f29346f = new Rect();
        this.f29347g = new Rect();
    }

    private Bitmap f() {
        return this.f29325b.e(this.f29326c.g());
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (f() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.vivo.mobilead.lottie.f.h.a(), r3.getHeight() * com.vivo.mobilead.lottie.f.h.a());
            this.f29324a.mapRect(rectF);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        super.a((c) t, (com.vivo.mobilead.lottie.g.c<c>) cVar);
        if (t == com.vivo.mobilead.lottie.g.B) {
            this.f29348h = cVar == null ? null : new p(cVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        Bitmap f2 = f();
        if (f2 == null || f2.isRecycled()) {
            return;
        }
        float a2 = com.vivo.mobilead.lottie.f.h.a();
        this.f29345e.setAlpha(i2);
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f29348h;
        if (aVar != null) {
            this.f29345e.setColorFilter(aVar.g());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f29346f.set(0, 0, f2.getWidth(), f2.getHeight());
        this.f29347g.set(0, 0, (int) (f2.getWidth() * a2), (int) (f2.getHeight() * a2));
        canvas.drawBitmap(f2, this.f29346f, this.f29347g, this.f29345e);
        canvas.restore();
    }
}
