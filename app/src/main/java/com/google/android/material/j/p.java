package com.google.android.material.j;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    private final q[] f7459a = new q[4];

    /* renamed from: b */
    private final Matrix[] f7460b = new Matrix[4];

    /* renamed from: c */
    private final Matrix[] f7461c = new Matrix[4];

    /* renamed from: d */
    private final PointF f7462d = new PointF();

    /* renamed from: e */
    private final Path f7463e = new Path();

    /* renamed from: f */
    private final Path f7464f = new Path();

    /* renamed from: g */
    private final q f7465g = new q();

    /* renamed from: h */
    private final float[] f7466h = new float[2];

    /* renamed from: i */
    private final float[] f7467i = new float[2];

    /* renamed from: j */
    private boolean f7468j = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface a {
        void a(q qVar, Matrix matrix, int i2);

        void b(q qVar, Matrix matrix, int i2);
    }

    static final class b {

        /* renamed from: a */
        @NonNull
        public final o f7469a;

        /* renamed from: b */
        @NonNull
        public final Path f7470b;

        /* renamed from: c */
        @NonNull
        public final RectF f7471c;

        /* renamed from: d */
        @Nullable
        public final a f7472d;

        /* renamed from: e */
        public final float f7473e;

        b(@NonNull o oVar, float f2, RectF rectF, @Nullable a aVar, Path path) {
            this.f7472d = aVar;
            this.f7469a = oVar;
            this.f7473e = f2;
            this.f7471c = rectF;
            this.f7470b = path;
        }
    }

    public p() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f7459a[i2] = new q();
            this.f7460b[i2] = new Matrix();
            this.f7461c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (i2 + 1) * 90;
    }

    private void b(@NonNull b bVar, int i2) {
        this.f7466h[0] = this.f7459a[i2].l();
        this.f7466h[1] = this.f7459a[i2].m();
        this.f7460b[i2].mapPoints(this.f7466h);
        if (i2 == 0) {
            Path path = bVar.f7470b;
            float[] fArr = this.f7466h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f7470b;
            float[] fArr2 = this.f7466h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f7459a[i2].d(this.f7460b[i2], bVar.f7470b);
        a aVar = bVar.f7472d;
        if (aVar != null) {
            aVar.a(this.f7459a[i2], this.f7460b[i2], i2);
        }
    }

    private void c(@NonNull b bVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f7466h[0] = this.f7459a[i2].j();
        this.f7466h[1] = this.f7459a[i2].k();
        this.f7460b[i2].mapPoints(this.f7466h);
        this.f7467i[0] = this.f7459a[i3].l();
        this.f7467i[1] = this.f7459a[i3].m();
        this.f7460b[i3].mapPoints(this.f7467i);
        float f2 = this.f7466h[0];
        float[] fArr = this.f7467i;
        float max = Math.max(((float) Math.hypot(f2 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i4 = i(bVar.f7471c, i2);
        this.f7465g.p(0.0f, 0.0f);
        g j2 = j(i2, bVar.f7469a);
        j2.b(max, i4, bVar.f7473e, this.f7465g);
        Path path = new Path();
        this.f7465g.d(this.f7461c[i2], path);
        if (this.f7468j && Build.VERSION.SDK_INT >= 19 && (j2.a() || k(path, i2) || k(path, i3))) {
            path.op(path, this.f7464f, Path.Op.DIFFERENCE);
            this.f7466h[0] = this.f7465g.l();
            this.f7466h[1] = this.f7465g.m();
            this.f7461c[i2].mapPoints(this.f7466h);
            Path path2 = this.f7463e;
            float[] fArr2 = this.f7466h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f7465g.d(this.f7461c[i2], this.f7463e);
        } else {
            this.f7465g.d(this.f7461c[i2], bVar.f7470b);
        }
        a aVar = bVar.f7472d;
        if (aVar != null) {
            aVar.b(this.f7465g, this.f7461c[i2], i2);
        }
    }

    private void f(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private d g(int i2, @NonNull o oVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? oVar.t() : oVar.r() : oVar.j() : oVar.l();
    }

    private e h(int i2, @NonNull o oVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? oVar.s() : oVar.q() : oVar.i() : oVar.k();
    }

    private float i(@NonNull RectF rectF, int i2) {
        float[] fArr = this.f7466h;
        q[] qVarArr = this.f7459a;
        fArr[0] = qVarArr[i2].f7478e;
        fArr[1] = qVarArr[i2].f7479f;
        this.f7460b[i2].mapPoints(fArr);
        return (i2 == 1 || i2 == 3) ? Math.abs(rectF.centerX() - this.f7466h[0]) : Math.abs(rectF.centerY() - this.f7466h[1]);
    }

    private g j(int i2, @NonNull o oVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? oVar.o() : oVar.p() : oVar.n() : oVar.h();
    }

    @RequiresApi(19)
    private boolean k(Path path, int i2) {
        Path path2 = new Path();
        this.f7459a[i2].d(this.f7460b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void l(@NonNull b bVar, int i2) {
        h(i2, bVar.f7469a).c(this.f7459a[i2], 90.0f, bVar.f7473e, bVar.f7471c, g(i2, bVar.f7469a));
        float a2 = a(i2);
        this.f7460b[i2].reset();
        f(i2, bVar.f7471c, this.f7462d);
        Matrix matrix = this.f7460b[i2];
        PointF pointF = this.f7462d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f7460b[i2].preRotate(a2);
    }

    private void n(int i2) {
        this.f7466h[0] = this.f7459a[i2].j();
        this.f7466h[1] = this.f7459a[i2].k();
        this.f7460b[i2].mapPoints(this.f7466h);
        float a2 = a(i2);
        this.f7461c[i2].reset();
        Matrix matrix = this.f7461c[i2];
        float[] fArr = this.f7466h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f7461c[i2].preRotate(a2);
    }

    public void d(o oVar, float f2, RectF rectF, @NonNull Path path) {
        e(oVar, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(o oVar, float f2, RectF rectF, a aVar, @NonNull Path path) {
        path.rewind();
        this.f7463e.rewind();
        this.f7464f.rewind();
        this.f7464f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(oVar, f2, rectF, aVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            l(bVar, i2);
            n(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(bVar, i3);
            c(bVar, i3);
        }
        path.close();
        this.f7463e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f7463e.isEmpty()) {
            return;
        }
        path.op(this.f7463e, Path.Op.UNION);
    }

    void m(boolean z) {
        this.f7468j = z;
    }
}
