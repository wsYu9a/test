package com.google.android.material.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a */
    private static final float f7474a = 270.0f;

    /* renamed from: b */
    protected static final float f7475b = 180.0f;

    /* renamed from: c */
    @Deprecated
    public float f7476c;

    /* renamed from: d */
    @Deprecated
    public float f7477d;

    /* renamed from: e */
    @Deprecated
    public float f7478e;

    /* renamed from: f */
    @Deprecated
    public float f7479f;

    /* renamed from: g */
    @Deprecated
    public float f7480g;

    /* renamed from: h */
    @Deprecated
    public float f7481h;

    /* renamed from: i */
    private final List<g> f7482i = new ArrayList();

    /* renamed from: j */
    private final List<i> f7483j = new ArrayList();
    private boolean k;

    class a extends i {

        /* renamed from: b */
        final /* synthetic */ List f7484b;

        /* renamed from: c */
        final /* synthetic */ Matrix f7485c;

        a(List list, Matrix matrix) {
            this.f7484b = list;
            this.f7485c = matrix;
        }

        @Override // com.google.android.material.j.q.i
        public void a(Matrix matrix, com.google.android.material.i.b bVar, int i2, Canvas canvas) {
            Iterator it = this.f7484b.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(this.f7485c, bVar, i2, canvas);
            }
        }
    }

    static class b extends i {

        /* renamed from: b */
        private final d f7487b;

        public b(d dVar) {
            this.f7487b = dVar;
        }

        @Override // com.google.android.material.j.q.i
        public void a(Matrix matrix, @NonNull com.google.android.material.i.b bVar, int i2, @NonNull Canvas canvas) {
            bVar.a(canvas, matrix, new RectF(this.f7487b.k(), this.f7487b.o(), this.f7487b.l(), this.f7487b.j()), i2, this.f7487b.m(), this.f7487b.n());
        }
    }

    static class c extends i {

        /* renamed from: b */
        private final f f7488b;

        /* renamed from: c */
        private final float f7489c;

        /* renamed from: d */
        private final float f7490d;

        public c(f fVar, float f2, float f3) {
            this.f7488b = fVar;
            this.f7489c = f2;
            this.f7490d = f3;
        }

        @Override // com.google.android.material.j.q.i
        public void a(Matrix matrix, @NonNull com.google.android.material.i.b bVar, int i2, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f7488b.f7505c - this.f7490d, this.f7488b.f7504b - this.f7489c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f7489c, this.f7490d);
            matrix2.preRotate(c());
            bVar.b(canvas, matrix2, rectF, i2);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f7488b.f7505c - this.f7490d) / (this.f7488b.f7504b - this.f7489c)));
        }
    }

    public static class d extends g {

        /* renamed from: b */
        private static final RectF f7491b = new RectF();

        /* renamed from: c */
        @Deprecated
        public float f7492c;

        /* renamed from: d */
        @Deprecated
        public float f7493d;

        /* renamed from: e */
        @Deprecated
        public float f7494e;

        /* renamed from: f */
        @Deprecated
        public float f7495f;

        /* renamed from: g */
        @Deprecated
        public float f7496g;

        /* renamed from: h */
        @Deprecated
        public float f7497h;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        public float j() {
            return this.f7495f;
        }

        public float k() {
            return this.f7492c;
        }

        public float l() {
            return this.f7494e;
        }

        public float m() {
            return this.f7496g;
        }

        public float n() {
            return this.f7497h;
        }

        public float o() {
            return this.f7493d;
        }

        private void p(float f2) {
            this.f7495f = f2;
        }

        private void q(float f2) {
            this.f7492c = f2;
        }

        private void r(float f2) {
            this.f7494e = f2;
        }

        public void s(float f2) {
            this.f7496g = f2;
        }

        public void t(float f2) {
            this.f7497h = f2;
        }

        private void u(float f2) {
            this.f7493d = f2;
        }

        @Override // com.google.android.material.j.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f7506a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f7491b;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends g {

        /* renamed from: b */
        private float f7498b;

        /* renamed from: c */
        private float f7499c;

        /* renamed from: d */
        private float f7500d;

        /* renamed from: e */
        private float f7501e;

        /* renamed from: f */
        private float f7502f;

        /* renamed from: g */
        private float f7503g;

        public e(float f2, float f3, float f4, float f5, float f6, float f7) {
            h(f2);
            j(f3);
            i(f4);
            k(f5);
            l(f6);
            m(f7);
        }

        private float b() {
            return this.f7498b;
        }

        private float c() {
            return this.f7500d;
        }

        private float d() {
            return this.f7499c;
        }

        private float e() {
            return this.f7499c;
        }

        private float f() {
            return this.f7502f;
        }

        private float g() {
            return this.f7503g;
        }

        private void h(float f2) {
            this.f7498b = f2;
        }

        private void i(float f2) {
            this.f7500d = f2;
        }

        private void j(float f2) {
            this.f7499c = f2;
        }

        private void k(float f2) {
            this.f7501e = f2;
        }

        private void l(float f2) {
            this.f7502f = f2;
        }

        private void m(float f2) {
            this.f7503g = f2;
        }

        @Override // com.google.android.material.j.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f7506a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f7498b, this.f7499c, this.f7500d, this.f7501e, this.f7502f, this.f7503g);
            path.transform(matrix);
        }
    }

    public static class f extends g {

        /* renamed from: b */
        private float f7504b;

        /* renamed from: c */
        private float f7505c;

        @Override // com.google.android.material.j.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f7506a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f7504b, this.f7505c);
            path.transform(matrix);
        }
    }

    public static abstract class g {

        /* renamed from: a */
        protected final Matrix f7506a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class h extends g {

        /* renamed from: b */
        @Deprecated
        public float f7507b;

        /* renamed from: c */
        @Deprecated
        public float f7508c;

        /* renamed from: d */
        @Deprecated
        public float f7509d;

        /* renamed from: e */
        @Deprecated
        public float f7510e;

        private float f() {
            return this.f7507b;
        }

        private float g() {
            return this.f7508c;
        }

        private float h() {
            return this.f7509d;
        }

        private float i() {
            return this.f7510e;
        }

        public void j(float f2) {
            this.f7507b = f2;
        }

        public void k(float f2) {
            this.f7508c = f2;
        }

        public void l(float f2) {
            this.f7509d = f2;
        }

        public void m(float f2) {
            this.f7510e = f2;
        }

        @Override // com.google.android.material.j.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f7506a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(f(), g(), h(), i());
            path.transform(matrix);
        }
    }

    static abstract class i {

        /* renamed from: a */
        static final Matrix f7511a = new Matrix();

        i() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.i.b bVar, int i2, Canvas canvas);

        public final void b(com.google.android.material.i.b bVar, int i2, Canvas canvas) {
            a(f7511a, bVar, i2, canvas);
        }
    }

    public q() {
        p(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (h() == f2) {
            return;
        }
        float h2 = ((f2 - h()) + 360.0f) % 360.0f;
        if (h2 > f7475b) {
            return;
        }
        d dVar = new d(j(), k(), j(), k());
        dVar.s(h());
        dVar.t(h2);
        this.f7483j.add(new b(dVar));
        r(f2);
    }

    private void c(i iVar, float f2, float f3) {
        b(f2);
        this.f7483j.add(iVar);
        r(f3);
    }

    private float h() {
        return this.f7480g;
    }

    private float i() {
        return this.f7481h;
    }

    private void r(float f2) {
        this.f7480g = f2;
    }

    private void s(float f2) {
        this.f7481h = f2;
    }

    private void t(float f2) {
        this.f7478e = f2;
    }

    private void u(float f2) {
        this.f7479f = f2;
    }

    private void v(float f2) {
        this.f7476c = f2;
    }

    private void w(float f2) {
        this.f7477d = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f7482i.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + f7475b) % 360.0f;
        }
        c(bVar, f6, z ? (f7475b + f8) % 360.0f : f8);
        double d2 = f8;
        t(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        u(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f7482i.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f7482i.get(i2).a(matrix, path);
        }
    }

    boolean e() {
        return this.k;
    }

    @NonNull
    i f(Matrix matrix) {
        b(i());
        return new a(new ArrayList(this.f7483j), matrix);
    }

    @RequiresApi(21)
    public void g(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f7482i.add(new e(f2, f3, f4, f5, f6, f7));
        this.k = true;
        t(f6);
        u(f7);
    }

    float j() {
        return this.f7478e;
    }

    float k() {
        return this.f7479f;
    }

    float l() {
        return this.f7476c;
    }

    float m() {
        return this.f7477d;
    }

    public void n(float f2, float f3) {
        f fVar = new f();
        fVar.f7504b = f2;
        fVar.f7505c = f3;
        this.f7482i.add(fVar);
        c cVar = new c(fVar, j(), k());
        c(cVar, cVar.c() + f7474a, cVar.c() + f7474a);
        t(f2);
        u(f3);
    }

    @RequiresApi(21)
    public void o(float f2, float f3, float f4, float f5) {
        h hVar = new h();
        hVar.j(f2);
        hVar.k(f3);
        hVar.l(f4);
        hVar.m(f5);
        this.f7482i.add(hVar);
        this.k = true;
        t(f4);
        u(f5);
    }

    public void p(float f2, float f3) {
        q(f2, f3, f7474a, 0.0f);
    }

    public void q(float f2, float f3, float f4, float f5) {
        v(f2);
        w(f3);
        t(f2);
        u(f3);
        r(f4);
        s((f4 + f5) % 360.0f);
        this.f7482i.clear();
        this.f7483j.clear();
        this.k = false;
    }

    public q(float f2, float f3) {
        p(f2, f3);
    }
}
