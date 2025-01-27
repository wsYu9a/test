package com.opos.exoplayer.core;

import android.util.Pair;
import com.opos.exoplayer.core.e.a.a;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public abstract class y {

    /* renamed from: a */
    public static final y f19297a = new y() { // from class: com.opos.exoplayer.core.y.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.y
        public int a(Object obj) {
            return -1;
        }

        @Override // com.opos.exoplayer.core.y
        public a a(int i2, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public b a(int i2, b bVar, boolean z, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public int b() {
            return 0;
        }

        @Override // com.opos.exoplayer.core.y
        public int c() {
            return 0;
        }
    };

    /* renamed from: com.opos.exoplayer.core.y$1 */
    static final class AnonymousClass1 extends y {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.y
        public int a(Object obj) {
            return -1;
        }

        @Override // com.opos.exoplayer.core.y
        public a a(int i2, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public b a(int i2, b bVar, boolean z, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public int b() {
            return 0;
        }

        @Override // com.opos.exoplayer.core.y
        public int c() {
            return 0;
        }
    }

    public static final class a {

        /* renamed from: a */
        public Object f19298a;

        /* renamed from: b */
        public Object f19299b;

        /* renamed from: c */
        public int f19300c;

        /* renamed from: d */
        public long f19301d;

        /* renamed from: e */
        private long f19302e;

        /* renamed from: f */
        private com.opos.exoplayer.core.e.a.a f19303f;

        public int a(int i2, int i3) {
            return this.f19303f.f18397d[i2].a(i3);
        }

        public int a(long j2) {
            return this.f19303f.a(j2);
        }

        public long a() {
            return this.f19301d;
        }

        public long a(int i2) {
            return this.f19303f.f18396c[i2];
        }

        public a a(Object obj, Object obj2, int i2, long j2, long j3) {
            return a(obj, obj2, i2, j2, j3, com.opos.exoplayer.core.e.a.a.f18394a);
        }

        public a a(Object obj, Object obj2, int i2, long j2, long j3, com.opos.exoplayer.core.e.a.a aVar) {
            this.f19298a = obj;
            this.f19299b = obj2;
            this.f19300c = i2;
            this.f19301d = j2;
            this.f19302e = j3;
            this.f19303f = aVar;
            return this;
        }

        public int b(int i2) {
            return this.f19303f.f18397d[i2].a();
        }

        public int b(long j2) {
            return this.f19303f.b(j2);
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.f19302e);
        }

        public boolean b(int i2, int i3) {
            a.C0408a c0408a = this.f19303f.f18397d[i2];
            return (c0408a.f18403a == -1 || c0408a.f18405c[i3] == 0) ? false : true;
        }

        public long c() {
            return this.f19302e;
        }

        public long c(int i2, int i3) {
            a.C0408a c0408a = this.f19303f.f18397d[i2];
            return c0408a.f18403a != -1 ? c0408a.f18406d[i3] : C.TIME_UNSET;
        }

        public boolean c(int i2) {
            return !this.f19303f.f18397d[i2].b();
        }

        public int d() {
            return this.f19303f.f18395b;
        }

        public int d(int i2) {
            return this.f19303f.f18397d[i2].f18403a;
        }

        public long e() {
            return this.f19303f.f18398e;
        }
    }

    public static final class b {

        /* renamed from: a */
        public Object f19304a;

        /* renamed from: b */
        public long f19305b;

        /* renamed from: c */
        public long f19306c;

        /* renamed from: d */
        public boolean f19307d;

        /* renamed from: e */
        public boolean f19308e;

        /* renamed from: f */
        public int f19309f;

        /* renamed from: g */
        public int f19310g;

        /* renamed from: h */
        public long f19311h;

        /* renamed from: i */
        public long f19312i;

        /* renamed from: j */
        public long f19313j;

        public long a() {
            return this.f19311h;
        }

        public b a(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            this.f19304a = obj;
            this.f19305b = j2;
            this.f19306c = j3;
            this.f19307d = z;
            this.f19308e = z2;
            this.f19311h = j4;
            this.f19312i = j5;
            this.f19309f = i2;
            this.f19310g = i3;
            this.f19313j = j6;
            return this;
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.f19312i);
        }

        public long c() {
            return this.f19313j;
        }
    }

    public int a(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            }
            if (i2 == a(z)) {
                return b(z);
            }
        } else if (i2 == a(z)) {
            return -1;
        }
        return i2 + 1;
    }

    public final int a(int i2, a aVar, b bVar, int i3, boolean z) {
        int i4 = a(i2, aVar).f19300c;
        if (a(i4, bVar).f19310g != i2) {
            return i2 + 1;
        }
        int a2 = a(i4, i3, z);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, bVar).f19309f;
    }

    public abstract int a(Object obj);

    public int a(boolean z) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2) {
        return a(bVar, aVar, i2, j2, 0L);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2, long j3) {
        com.opos.exoplayer.core.i.a.a(i2, 0, b());
        a(i2, bVar, false, j3);
        if (j2 == C.TIME_UNSET) {
            j2 = bVar.a();
            if (j2 == C.TIME_UNSET) {
                return null;
            }
        }
        int i3 = bVar.f19309f;
        long c2 = bVar.c() + j2;
        while (true) {
            long a2 = a(i3, aVar).a();
            if (a2 == C.TIME_UNSET || c2 < a2 || i3 >= bVar.f19310g) {
                break;
            }
            c2 -= a2;
            i3++;
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(c2));
    }

    public final a a(int i2, a aVar) {
        return a(i2, aVar, false);
    }

    public abstract a a(int i2, a aVar, boolean z);

    public final b a(int i2, b bVar) {
        return a(i2, bVar, false);
    }

    public final b a(int i2, b bVar, boolean z) {
        return a(i2, bVar, z, 0L);
    }

    public abstract b a(int i2, b bVar, boolean z, long j2);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            }
            if (i2 == b(z)) {
                return a(z);
            }
        } else if (i2 == b(z)) {
            return -1;
        }
        return i2 - 1;
    }

    public int b(boolean z) {
        return a() ? -1 : 0;
    }

    public final boolean b(int i2, a aVar, b bVar, int i3, boolean z) {
        return a(i2, aVar, bVar, i3, z) == -1;
    }

    public abstract int c();
}
