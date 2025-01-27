package com.martian.ttbook.b.c.a.a.d.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public d f15699a;

    /* renamed from: b */
    public com.martian.ttbook.b.c.a.a.e.e f15700b;

    /* renamed from: c */
    public com.martian.ttbook.b.c.a.a.e.e f15701c;

    /* renamed from: d */
    public com.martian.ttbook.b.c.a.a.e.e f15702d;

    /* renamed from: e */
    public int f15703e;

    /* renamed from: g */
    public int f15705g;

    /* renamed from: h */
    private f f15706h;

    /* renamed from: i */
    private f f15707i;

    /* renamed from: f */
    public int f15704f = 0;

    /* renamed from: j */
    public boolean f15708j = false;
    public boolean k = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            g.e(eVar.f15699a, eVar);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            l.g(eVar.f15699a.f15668b, eVar.f15702d.a(c.p), e.this.f15702d.a(c.q), e.this.f15702d.a(c.r), e.this.f15702d.g(c.A), e.this.f15702d.g(c.z), e.this.f15702d.g(c.n), e.this.f15699a.l(), e.this.f15702d.g(c.u));
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final Object f15711a = new Object();

        /* renamed from: b */
        public static final Object f15712b = new Object();

        /* renamed from: c */
        public static final Object f15713c = new Object();

        /* renamed from: d */
        public static final Object f15714d = new Object();

        /* renamed from: e */
        public static final Object f15715e = new Object();

        /* renamed from: f */
        public static final Object f15716f = new Object();

        /* renamed from: g */
        public static final Object f15717g = new Object();

        /* renamed from: h */
        public static final Object f15718h = new Object();

        /* renamed from: i */
        public static final Object f15719i = new Object();

        /* renamed from: j */
        public static final Object f15720j = new Object();
        public static final Object k = new Object();
        public static final Object l = new Object();
        public static final Object m = new Object();
        public static final Object n = new Object();
        public static final Object o = new Object();
        public static final Object p = new Object();
        public static final Object q = new Object();
        public static final Object r = new Object();
        public static final Object s = new Object();
        public static final Object t = new Object();
        public static final Object u = new Object();
        public static final Object v = new Object();
        public static final Object w = new Object();
        public static final Object x = new Object();
        public static final Object y = new Object();
        public static final Object z = new Object();
        public static final Object A = new Object();
        public static final Object B = new Object();
        public static final Object C = new Object();
        public static final Object D = new Object();
        public static final Object E = new Object();
        public static final Object F = new Object();
        public static final Object G = new Object();
        public static final Object H = new Object();
        public static final Object I = new Object();
        public static final Object J = new Object();
        public static final Object K = new Object();
        public static final Object L = new Object();
        public static final Object M = new Object();
        public static final Object N = new Object();
        public static final Object O = new Object();
        public static final Object P = new Object();
        public static final Object Q = new Object();
        public static final Object R = new Object();
        public static final Object S = new Object();
        public static final Object T = new Object();
        public static final Object U = new Object();
        public static final Object V = new Object();
        public static final Object W = new Object();
        public static final Object X = new Object();
    }

    public e(d dVar, Map<Object, Object> map) {
        this.f15705g = 0;
        this.f15699a = dVar;
        this.f15700b = new com.martian.ttbook.b.c.a.a.e.e(map);
        this.f15705g = 0;
    }

    public static void g() {
        com.martian.ttbook.b.c.a.a.b.m(new Object[]{new Object[]{c.f15717g, c.f15716f, c.f15714d, c.f15715e, c.f15713c, c.f15712b, c.f15711a}, new Object[]{c.H, c.V, c.U, c.T, c.I, c.J, c.K, c.O, c.L, c.S, c.M, c.N, c.P, c.Q, c.R, c.W, c.X}, new Object[]{c.s, c.z, c.r, c.B, c.n, c.l, c.m, c.C, c.p, c.o, c.f15718h, c.w, c.u, c.f15719i, c.v, c.D, c.f15720j, c.k, c.y, c.t, c.A, c.q, c.x, c.E, c.F, c.G}});
    }

    public void a(k kVar) {
        f fVar;
        if (!this.f15708j || (fVar = this.f15707i) == null) {
            return;
        }
        fVar.b(kVar);
        throw null;
    }

    public boolean b() {
        int g2 = this.f15702d.g(c.x);
        return g2 <= 0 || g2 > this.f15699a.A.i();
    }

    public i c() {
        List list;
        Map<Object, Object> map = this.f15700b.f15826a;
        Object obj = c.f15711a;
        if (map.containsKey(obj) && (list = (List) this.f15700b.f15826a.get(obj)) != null && list.size() > 0) {
            com.martian.ttbook.b.c.a.a.e.e eVar = new com.martian.ttbook.b.c.a.a.e.e((Map) list.get(0));
            if (eVar.g(c.S) > this.f15699a.v) {
                this.f15701c = eVar;
                this.f15704f = 0;
            }
        }
        Map<Object, Object> map2 = this.f15700b.f15826a;
        Object obj2 = c.f15712b;
        this.f15702d = map2.containsKey(obj2) ? new com.martian.ttbook.b.c.a.a.e.e((Map) this.f15700b.f15826a.get(obj2)) : new com.martian.ttbook.b.c.a.a.e.e(new HashMap());
        if (this.f15701c == null) {
            return new i(10008, "广告无填充");
        }
        com.martian.ttbook.b.c.a.a.e.j.c(new b());
        return null;
    }

    public void d(k kVar) {
        f fVar;
        if (!this.f15708j || (fVar = this.f15706h) == null) {
            return;
        }
        fVar.b(kVar);
        throw null;
    }

    public boolean e() {
        int g2 = this.f15702d.g(c.l);
        if (g2 > 0 && g2 <= this.f15699a.A.i()) {
            return false;
        }
        int g3 = this.f15702d.g(c.m);
        return g3 <= 0 || g3 > this.f15699a.B.i();
    }

    public int f() {
        return this.f15701c.c(c.V, -1);
    }

    public void h() {
    }

    public void i() {
        if (this.f15708j) {
            this.f15708j = false;
            f fVar = this.f15706h;
            if (fVar != null) {
                fVar.a();
                throw null;
            }
            f fVar2 = this.f15707i;
            if (fVar2 == null) {
                com.martian.ttbook.b.c.a.a.e.d.g("ADHTTPTAG", "stopBatchCollection");
            } else {
                fVar2.a();
                throw null;
            }
        }
    }

    public void j() {
        com.martian.ttbook.b.c.a.a.e.d.g("ADHTTPTAG", "tryEnd " + this.k);
        if (!this.f15708j || this.k) {
            return;
        }
        this.k = true;
        f fVar = this.f15706h;
        if (fVar != null) {
            fVar.c();
            throw null;
        }
        f fVar2 = this.f15707i;
        if (fVar2 == null) {
            i();
        } else {
            fVar2.c();
            throw null;
        }
    }

    public boolean k() {
        this.f15705g++;
        int c2 = this.f15702d.c(c.y, 1);
        if (c2 < 1) {
            c2 = 1;
        }
        int i2 = this.f15705g % c2;
        if (i2 == 0) {
            this.f15704f++;
        }
        com.martian.ttbook.b.c.a.a.e.d.a("r = " + i2 + ", v1 = " + c2 + ",v2 = " + this.f15705g + ", v3 = " + this.f15704f);
        List list = (List) this.f15700b.f15826a.get(c.f15711a);
        if (list != null && list.size() > 0 && this.f15704f < list.size()) {
            com.martian.ttbook.b.c.a.a.e.d.a("next ");
            com.martian.ttbook.b.c.a.a.e.e eVar = new com.martian.ttbook.b.c.a.a.e.e((Map) list.get(this.f15704f));
            if (eVar.g(c.S) > this.f15699a.v) {
                this.f15701c = eVar;
                com.martian.ttbook.b.c.a.a.e.j.b(new a(), this.f15702d.c(c.w, 0));
                return true;
            }
        }
        com.martian.ttbook.b.c.a.a.e.d.a("next end!");
        j();
        return false;
    }
}
