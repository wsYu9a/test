package com.google.android.material.m;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.m.l;

/* loaded from: classes.dex */
class j {

    /* renamed from: a */
    private final Path f7543a = new Path();

    /* renamed from: b */
    private final Path f7544b = new Path();

    /* renamed from: c */
    private final Path f7545c = new Path();

    /* renamed from: d */
    private final com.google.android.material.j.p f7546d = new com.google.android.material.j.p();

    /* renamed from: e */
    private com.google.android.material.j.o f7547e;

    j() {
    }

    void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f7543a);
        } else {
            canvas.clipPath(this.f7544b);
            canvas.clipPath(this.f7545c, Region.Op.UNION);
        }
    }

    void b(float f2, com.google.android.material.j.o oVar, com.google.android.material.j.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        com.google.android.material.j.o n = u.n(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f2);
        this.f7547e = n;
        this.f7546d.d(n, 1.0f, rectF2, this.f7544b);
        this.f7546d.d(this.f7547e, 1.0f, rectF3, this.f7545c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f7543a.op(this.f7544b, this.f7545c, Path.Op.UNION);
        }
    }

    com.google.android.material.j.o c() {
        return this.f7547e;
    }

    Path d() {
        return this.f7543a;
    }
}
