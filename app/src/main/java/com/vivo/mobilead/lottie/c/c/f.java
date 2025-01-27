package com.vivo.mobilead.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.c.b.n;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends a {

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.a.a.d f29372e;

    f(com.vivo.mobilead.lottie.c cVar, d dVar) {
        super(cVar, dVar);
        com.vivo.mobilead.lottie.a.a.d dVar2 = new com.vivo.mobilead.lottie.a.a.d(cVar, this, new n("__container", dVar.n(), false));
        this.f29372e = dVar2;
        dVar2.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.f29372e.a(rectF, this.f29324a, z);
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        this.f29372e.a(canvas, matrix, i2);
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    protected void b(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        this.f29372e.a(eVar, i2, list, eVar2);
    }
}
