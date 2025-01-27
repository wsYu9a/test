package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.s0;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public class t<K> {

    /* renamed from: i */
    public static final int f9959i = 1073741824;

    /* renamed from: j */
    public static final float f9960j = 1.0f;

    /* renamed from: k */
    public static final long f9961k = 4294967295L;

    /* renamed from: l */
    public static final long f9962l = -4294967296L;

    /* renamed from: m */
    public static final int f9963m = 3;

    /* renamed from: n */
    public static final int f9964n = -1;

    /* renamed from: a */
    public transient Object[] f9965a;

    /* renamed from: b */
    public transient int[] f9966b;

    /* renamed from: c */
    public transient int f9967c;

    /* renamed from: d */
    public transient int f9968d;

    /* renamed from: e */
    public transient int[] f9969e;

    /* renamed from: f */
    @a5.d
    public transient long[] f9970f;

    /* renamed from: g */
    public transient float f9971g;

    /* renamed from: h */
    public transient int f9972h;

    public class a extends Multisets.f<K> {

        /* renamed from: b */
        @d1
        public final K f9973b;

        /* renamed from: c */
        public int f9974c;

        public a(int i10) {
            this.f9973b = (K) t.this.f9965a[i10];
            this.f9974c = i10;
        }

        @CanIgnoreReturnValue
        public int a(int i10) {
            b();
            int i11 = this.f9974c;
            if (i11 == -1) {
                t.this.v(this.f9973b, i10);
                return 0;
            }
            int[] iArr = t.this.f9966b;
            int i12 = iArr[i11];
            iArr[i11] = i10;
            return i12;
        }

        public void b() {
            int i10 = this.f9974c;
            if (i10 == -1 || i10 >= t.this.D() || !b5.r.a(this.f9973b, t.this.f9965a[this.f9974c])) {
                this.f9974c = t.this.n(this.f9973b);
            }
        }

        @Override // com.google.common.collect.s.a
        public int getCount() {
            b();
            int i10 = this.f9974c;
            if (i10 == -1) {
                return 0;
            }
            return t.this.f9966b[i10];
        }

        @Override // com.google.common.collect.s.a
        @d1
        public K getElement() {
            return this.f9973b;
        }
    }

    public t() {
        o(3, 1.0f);
    }

    public static long E(long j10, int i10) {
        return (j10 & f9962l) | (4294967295L & i10);
    }

    public static <K> t<K> c() {
        return new t<>();
    }

    public static <K> t<K> d(int i10) {
        return new t<>(i10);
    }

    public static int i(long j10) {
        return (int) (j10 >>> 32);
    }

    public static int k(long j10) {
        return (int) j10;
    }

    public static long[] r(int i10) {
        long[] jArr = new long[i10];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] s(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i10) {
        int length = this.f9970f.length;
        if (i10 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                z(max);
            }
        }
    }

    public final void B(int i10) {
        if (this.f9969e.length >= 1073741824) {
            this.f9972h = Integer.MAX_VALUE;
            return;
        }
        int i11 = ((int) (i10 * this.f9971g)) + 1;
        int[] s10 = s(i10);
        long[] jArr = this.f9970f;
        int length = s10.length - 1;
        for (int i12 = 0; i12 < this.f9967c; i12++) {
            int i13 = i(jArr[i12]);
            int i14 = i13 & length;
            int i15 = s10[i14];
            s10[i14] = i12;
            jArr[i12] = (i13 << 32) | (i15 & 4294967295L);
        }
        this.f9972h = i11;
        this.f9969e = s10;
    }

    public void C(int i10, int i11) {
        b5.u.C(i10, this.f9967c);
        this.f9966b[i10] = i11;
    }

    public int D() {
        return this.f9967c;
    }

    public void a() {
        this.f9968d++;
        Arrays.fill(this.f9965a, 0, this.f9967c, (Object) null);
        Arrays.fill(this.f9966b, 0, this.f9967c, 0);
        Arrays.fill(this.f9969e, -1);
        Arrays.fill(this.f9970f, -1L);
        this.f9967c = 0;
    }

    public boolean b(@CheckForNull Object obj) {
        return n(obj) != -1;
    }

    public void e(int i10) {
        if (i10 > this.f9970f.length) {
            z(i10);
        }
        if (i10 >= this.f9972h) {
            B(Math.max(2, Integer.highestOneBit(i10 - 1) << 1));
        }
    }

    public int f() {
        return this.f9967c == 0 ? -1 : 0;
    }

    public int g(@CheckForNull Object obj) {
        int n10 = n(obj);
        if (n10 == -1) {
            return 0;
        }
        return this.f9966b[n10];
    }

    public s.a<K> h(int i10) {
        b5.u.C(i10, this.f9967c);
        return new a(i10);
    }

    @d1
    public K j(int i10) {
        b5.u.C(i10, this.f9967c);
        return (K) this.f9965a[i10];
    }

    public int l(int i10) {
        b5.u.C(i10, this.f9967c);
        return this.f9966b[i10];
    }

    public final int m() {
        return this.f9969e.length - 1;
    }

    public int n(@CheckForNull Object obj) {
        int d10 = s0.d(obj);
        int i10 = this.f9969e[m() & d10];
        while (i10 != -1) {
            long j10 = this.f9970f[i10];
            if (i(j10) == d10 && b5.r.a(obj, this.f9965a[i10])) {
                return i10;
            }
            i10 = k(j10);
        }
        return -1;
    }

    public void o(int i10, float f10) {
        b5.u.e(i10 >= 0, "Initial capacity must be non-negative");
        b5.u.e(f10 > 0.0f, "Illegal load factor");
        int a10 = s0.a(i10, f10);
        this.f9969e = s(a10);
        this.f9971g = f10;
        this.f9965a = new Object[i10];
        this.f9966b = new int[i10];
        this.f9970f = r(i10);
        this.f9972h = Math.max(1, (int) (a10 * f10));
    }

    public void p(int i10, @d1 K k10, int i11, int i12) {
        this.f9970f[i10] = (i12 << 32) | 4294967295L;
        this.f9965a[i10] = k10;
        this.f9966b[i10] = i11;
    }

    public void q(int i10) {
        int D = D() - 1;
        if (i10 >= D) {
            this.f9965a[i10] = null;
            this.f9966b[i10] = 0;
            this.f9970f[i10] = -1;
            return;
        }
        Object[] objArr = this.f9965a;
        objArr[i10] = objArr[D];
        int[] iArr = this.f9966b;
        iArr[i10] = iArr[D];
        objArr[D] = null;
        iArr[D] = 0;
        long[] jArr = this.f9970f;
        long j10 = jArr[D];
        jArr[i10] = j10;
        jArr[D] = -1;
        int i11 = i(j10) & m();
        int[] iArr2 = this.f9969e;
        int i12 = iArr2[i11];
        if (i12 == D) {
            iArr2[i11] = i10;
            return;
        }
        while (true) {
            long j11 = this.f9970f[i12];
            int k10 = k(j11);
            if (k10 == D) {
                this.f9970f[i12] = E(j11, i10);
                return;
            }
            i12 = k10;
        }
    }

    public int t(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f9967c) {
            return i11;
        }
        return -1;
    }

    public int u(int i10, int i11) {
        return i10 - 1;
    }

    @CanIgnoreReturnValue
    public int v(@d1 K k10, int i10) {
        e5.i.d(i10, c7.g.f1744b);
        long[] jArr = this.f9970f;
        Object[] objArr = this.f9965a;
        int[] iArr = this.f9966b;
        int d10 = s0.d(k10);
        int m10 = m() & d10;
        int i11 = this.f9967c;
        int[] iArr2 = this.f9969e;
        int i12 = iArr2[m10];
        if (i12 == -1) {
            iArr2[m10] = i11;
        } else {
            while (true) {
                long j10 = jArr[i12];
                if (i(j10) == d10 && b5.r.a(k10, objArr[i12])) {
                    int i13 = iArr[i12];
                    iArr[i12] = i10;
                    return i13;
                }
                int k11 = k(j10);
                if (k11 == -1) {
                    jArr[i12] = E(j10, i11);
                    break;
                }
                i12 = k11;
            }
        }
        if (i11 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i14 = i11 + 1;
        A(i14);
        p(i11, k10, i10, d10);
        this.f9967c = i14;
        if (i11 >= this.f9972h) {
            B(this.f9969e.length * 2);
        }
        this.f9968d++;
        return 0;
    }

    @CanIgnoreReturnValue
    public int w(@CheckForNull Object obj) {
        return x(obj, s0.d(obj));
    }

    public final int x(@CheckForNull Object obj, int i10) {
        int m10 = m() & i10;
        int i11 = this.f9969e[m10];
        if (i11 == -1) {
            return 0;
        }
        int i12 = -1;
        while (true) {
            if (i(this.f9970f[i11]) == i10 && b5.r.a(obj, this.f9965a[i11])) {
                int i13 = this.f9966b[i11];
                if (i12 == -1) {
                    this.f9969e[m10] = k(this.f9970f[i11]);
                } else {
                    long[] jArr = this.f9970f;
                    jArr[i12] = E(jArr[i12], k(jArr[i11]));
                }
                q(i11);
                this.f9967c--;
                this.f9968d++;
                return i13;
            }
            int k10 = k(this.f9970f[i11]);
            if (k10 == -1) {
                return 0;
            }
            i12 = i11;
            i11 = k10;
        }
    }

    @CanIgnoreReturnValue
    public int y(int i10) {
        return x(this.f9965a[i10], i(this.f9970f[i10]));
    }

    public void z(int i10) {
        this.f9965a = Arrays.copyOf(this.f9965a, i10);
        this.f9966b = Arrays.copyOf(this.f9966b, i10);
        long[] jArr = this.f9970f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        if (i10 > length) {
            Arrays.fill(copyOf, length, i10, -1L);
        }
        this.f9970f = copyOf;
    }

    public t(t<? extends K> tVar) {
        o(tVar.D(), 1.0f);
        int f10 = tVar.f();
        while (f10 != -1) {
            v(tVar.j(f10), tVar.l(f10));
            f10 = tVar.t(f10);
        }
    }

    public t(int i10) {
        this(i10, 1.0f);
    }

    public t(int i10, float f10) {
        o(i10, f10);
    }
}
