package com.google.android.material.m.w;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.android.material.m.w.l;

@RequiresApi(21)
/* loaded from: classes.dex */
class j {

    /* renamed from: a */
    private final Path f7616a = new Path();

    /* renamed from: b */
    private final Path f7617b = new Path();

    /* renamed from: c */
    private final Path f7618c = new Path();

    /* renamed from: d */
    private final com.google.android.material.j.p f7619d = new com.google.android.material.j.p();

    /* renamed from: e */
    private com.google.android.material.j.o f7620e;

    j() {
    }

    void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f7616a);
        } else {
            canvas.clipPath(this.f7617b);
            canvas.clipPath(this.f7618c, Region.Op.UNION);
        }
    }

    void b(float f2, com.google.android.material.j.o oVar, com.google.android.material.j.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        com.google.android.material.j.o n = v.n(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f2);
        this.f7620e = n;
        this.f7619d.d(n, 1.0f, rectF2, this.f7617b);
        this.f7619d.d(this.f7620e, 1.0f, rectF3, this.f7618c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f7616a.op(this.f7617b, this.f7618c, Path.Op.UNION);
        }
    }

    com.google.android.material.j.o c() {
        return this.f7620e;
    }

    Path d() {
        return this.f7616a;
    }
}
