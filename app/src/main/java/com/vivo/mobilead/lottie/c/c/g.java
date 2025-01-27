package com.vivo.mobilead.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.p;

/* loaded from: classes4.dex */
public class g extends a {

    /* renamed from: e */
    private final RectF f29373e;

    /* renamed from: f */
    private final Paint f29374f;

    /* renamed from: g */
    private final float[] f29375g;

    /* renamed from: h */
    private final Path f29376h;

    /* renamed from: i */
    private final d f29377i;

    /* renamed from: j */
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> f29378j;

    g(com.vivo.mobilead.lottie.c cVar, d dVar) {
        super(cVar, dVar);
        this.f29373e = new RectF();
        com.vivo.mobilead.lottie.a.a aVar = new com.vivo.mobilead.lottie.a.a();
        this.f29374f = aVar;
        this.f29375g = new float[8];
        this.f29376h = new Path();
        this.f29377i = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.p());
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f29373e.set(0.0f, 0.0f, this.f29377i.r(), this.f29377i.q());
        this.f29324a.mapRect(this.f29373e);
        rectF.set(this.f29373e);
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        super.a((g) t, (com.vivo.mobilead.lottie.g.c<g>) cVar);
        if (t == com.vivo.mobilead.lottie.g.B) {
            this.f29378j = cVar == null ? null : new p(cVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.f29377i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i2 / 255.0f) * (((alpha / 255.0f) * (this.f29327d.a() == null ? 100 : this.f29327d.a().g().intValue())) / 100.0f) * 255.0f);
        this.f29374f.setAlpha(intValue);
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f29378j;
        if (aVar != null) {
            this.f29374f.setColorFilter(aVar.g());
        }
        if (intValue > 0) {
            float[] fArr = this.f29375g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f29377i.r();
            float[] fArr2 = this.f29375g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f29377i.r();
            this.f29375g[5] = this.f29377i.q();
            float[] fArr3 = this.f29375g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f29377i.q();
            matrix.mapPoints(this.f29375g);
            this.f29376h.reset();
            Path path = this.f29376h;
            float[] fArr4 = this.f29375g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f29376h;
            float[] fArr5 = this.f29375g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f29376h;
            float[] fArr6 = this.f29375g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f29376h;
            float[] fArr7 = this.f29375g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f29376h;
            float[] fArr8 = this.f29375g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f29376h.close();
            canvas.drawPath(this.f29376h, this.f29374f);
        }
    }
}
