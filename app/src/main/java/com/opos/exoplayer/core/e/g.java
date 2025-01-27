package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
final class g {

    /* renamed from: i */
    private int f18484i;

    /* renamed from: j */
    private int f18485j;
    private int k;
    private int l;
    private Format q;
    private int r;

    /* renamed from: a */
    private int f18476a = 1000;

    /* renamed from: b */
    private int[] f18477b = new int[1000];

    /* renamed from: c */
    private long[] f18478c = new long[1000];

    /* renamed from: f */
    private long[] f18481f = new long[1000];

    /* renamed from: e */
    private int[] f18480e = new int[1000];

    /* renamed from: d */
    private int[] f18479d = new int[1000];

    /* renamed from: g */
    private n.a[] f18482g = new n.a[1000];

    /* renamed from: h */
    private Format[] f18483h = new Format[1000];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    public static final class a {

        /* renamed from: a */
        public int f18486a;

        /* renamed from: b */
        public long f18487b;

        /* renamed from: c */
        public n.a f18488c;
    }

    private int a(int i2, int i3, long j2, boolean z) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3 && this.f18481f[i2] <= j2; i5++) {
            if (!z || (this.f18480e[i2] & 1) != 0) {
                i4 = i5;
            }
            i2++;
            if (i2 == this.f18476a) {
                i2 = 0;
            }
        }
        return i4;
    }

    private long b(int i2) {
        this.m = Math.max(this.m, c(i2));
        int i3 = this.f18484i - i2;
        this.f18484i = i3;
        this.f18485j += i2;
        int i4 = this.k + i2;
        this.k = i4;
        int i5 = this.f18476a;
        if (i4 >= i5) {
            this.k = i4 - i5;
        }
        int i6 = this.l - i2;
        this.l = i6;
        if (i6 < 0) {
            this.l = 0;
        }
        if (i3 != 0) {
            return this.f18478c[this.k];
        }
        int i7 = this.k;
        if (i7 != 0) {
            i5 = i7;
        }
        return this.f18479d[r2] + this.f18478c[i5 - 1];
    }

    private long c(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 != 0) {
            int d2 = d(i2 - 1);
            for (int i3 = 0; i3 < i2; i3++) {
                j2 = Math.max(j2, this.f18481f[d2]);
                if ((this.f18480e[d2] & 1) != 0) {
                    break;
                }
                d2--;
                if (d2 == -1) {
                    d2 = this.f18476a - 1;
                }
            }
        }
        return j2;
    }

    private int d(int i2) {
        int i3 = this.k + i2;
        int i4 = this.f18476a;
        return i3 < i4 ? i3 : i3 - i4;
    }

    public int a() {
        return this.f18485j + this.f18484i;
    }

    public int a(long j2, boolean z, boolean z2) {
        int i2;
        int a2;
        synchronized (this) {
            int d2 = d(this.l);
            i2 = -1;
            if (c() && j2 >= this.f18481f[d2] && ((j2 <= this.n || z2) && (a2 = a(d2, this.f18484i - this.l, j2, z)) != -1)) {
                this.l += a2;
                i2 = a2;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
    
        if (r5 != r8) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.opos.exoplayer.core.l r4, com.opos.exoplayer.core.b.e r5, boolean r6, boolean r7, com.opos.exoplayer.core.Format r8, com.opos.exoplayer.core.e.g.a r9) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.c()     // Catch: java.lang.Throwable -> L61
            r1 = -5
            r2 = -3
            if (r0 != 0) goto L1d
            if (r7 == 0) goto L10
            r4 = 4
            r5.a_(r4)     // Catch: java.lang.Throwable -> L61
            goto L58
        L10:
            com.opos.exoplayer.core.Format r5 = r3.q     // Catch: java.lang.Throwable -> L61
            if (r5 == 0) goto L1b
            if (r6 != 0) goto L18
            if (r5 == r8) goto L1b
        L18:
            r4.f19091a = r5     // Catch: java.lang.Throwable -> L61
            goto L5f
        L1b:
            r1 = -3
            goto L5f
        L1d:
            int r7 = r3.l     // Catch: java.lang.Throwable -> L61
            int r7 = r3.d(r7)     // Catch: java.lang.Throwable -> L61
            if (r6 != 0) goto L5a
            com.opos.exoplayer.core.Format[] r6 = r3.f18483h     // Catch: java.lang.Throwable -> L61
            r6 = r6[r7]     // Catch: java.lang.Throwable -> L61
            if (r6 == r8) goto L2c
            goto L5a
        L2c:
            boolean r4 = r5.f()     // Catch: java.lang.Throwable -> L61
            if (r4 == 0) goto L33
            goto L1b
        L33:
            long[] r4 = r3.f18481f     // Catch: java.lang.Throwable -> L61
            r0 = r4[r7]     // Catch: java.lang.Throwable -> L61
            r5.f17740c = r0     // Catch: java.lang.Throwable -> L61
            int[] r4 = r3.f18480e     // Catch: java.lang.Throwable -> L61
            r4 = r4[r7]     // Catch: java.lang.Throwable -> L61
            r5.a_(r4)     // Catch: java.lang.Throwable -> L61
            int[] r4 = r3.f18479d     // Catch: java.lang.Throwable -> L61
            r4 = r4[r7]     // Catch: java.lang.Throwable -> L61
            r9.f18486a = r4     // Catch: java.lang.Throwable -> L61
            long[] r4 = r3.f18478c     // Catch: java.lang.Throwable -> L61
            r5 = r4[r7]     // Catch: java.lang.Throwable -> L61
            r9.f18487b = r5     // Catch: java.lang.Throwable -> L61
            com.opos.exoplayer.core.c.n$a[] r4 = r3.f18482g     // Catch: java.lang.Throwable -> L61
            r4 = r4[r7]     // Catch: java.lang.Throwable -> L61
            r9.f18488c = r4     // Catch: java.lang.Throwable -> L61
            int r4 = r3.l     // Catch: java.lang.Throwable -> L61
            int r4 = r4 + 1
            r3.l = r4     // Catch: java.lang.Throwable -> L61
        L58:
            r1 = -4
            goto L5f
        L5a:
            com.opos.exoplayer.core.Format[] r5 = r3.f18483h     // Catch: java.lang.Throwable -> L61
            r5 = r5[r7]     // Catch: java.lang.Throwable -> L61
            goto L18
        L5f:
            monitor-exit(r3)
            return r1
        L61:
            r4 = move-exception
            monitor-exit(r3)
            goto L65
        L64:
            throw r4
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.g.a(com.opos.exoplayer.core.l, com.opos.exoplayer.core.b.e, boolean, boolean, com.opos.exoplayer.core.Format, com.opos.exoplayer.core.e.g$a):int");
    }

    public long a(int i2) {
        int a2 = a() - i2;
        com.opos.exoplayer.core.i.a.a(a2 >= 0 && a2 <= this.f18484i - this.l);
        int i3 = this.f18484i - a2;
        this.f18484i = i3;
        this.n = Math.max(this.m, c(i3));
        int i4 = this.f18484i;
        if (i4 == 0) {
            return 0L;
        }
        return this.f18478c[d(i4 - 1)] + this.f18479d[r6];
    }

    public void a(long j2) {
        synchronized (this) {
            this.n = Math.max(this.n, j2);
        }
    }

    public void a(long j2, int i2, long j3, int i3, n.a aVar) {
        synchronized (this) {
            if (this.o) {
                if ((i2 & 1) != 0) {
                    this.o = false;
                }
            }
            com.opos.exoplayer.core.i.a.b(!this.p);
            a(j2);
            int d2 = d(this.f18484i);
            this.f18481f[d2] = j2;
            long[] jArr = this.f18478c;
            jArr[d2] = j3;
            this.f18479d[d2] = i3;
            this.f18480e[d2] = i2;
            this.f18482g[d2] = aVar;
            this.f18483h[d2] = this.q;
            this.f18477b[d2] = this.r;
            int i4 = this.f18484i + 1;
            this.f18484i = i4;
            int i5 = this.f18476a;
            if (i4 == i5) {
                int i6 = i5 + 1000;
                int[] iArr = new int[i6];
                long[] jArr2 = new long[i6];
                long[] jArr3 = new long[i6];
                int[] iArr2 = new int[i6];
                int[] iArr3 = new int[i6];
                n.a[] aVarArr = new n.a[i6];
                Format[] formatArr = new Format[i6];
                int i7 = this.k;
                int i8 = i5 - i7;
                System.arraycopy(jArr, i7, jArr2, 0, i8);
                System.arraycopy(this.f18481f, this.k, jArr3, 0, i8);
                System.arraycopy(this.f18480e, this.k, iArr2, 0, i8);
                System.arraycopy(this.f18479d, this.k, iArr3, 0, i8);
                System.arraycopy(this.f18482g, this.k, aVarArr, 0, i8);
                System.arraycopy(this.f18483h, this.k, formatArr, 0, i8);
                System.arraycopy(this.f18477b, this.k, iArr, 0, i8);
                int i9 = this.k;
                System.arraycopy(this.f18478c, 0, jArr2, i8, i9);
                System.arraycopy(this.f18481f, 0, jArr3, i8, i9);
                System.arraycopy(this.f18480e, 0, iArr2, i8, i9);
                System.arraycopy(this.f18479d, 0, iArr3, i8, i9);
                System.arraycopy(this.f18482g, 0, aVarArr, i8, i9);
                System.arraycopy(this.f18483h, 0, formatArr, i8, i9);
                System.arraycopy(this.f18477b, 0, iArr, i8, i9);
                this.f18478c = jArr2;
                this.f18481f = jArr3;
                this.f18480e = iArr2;
                this.f18479d = iArr3;
                this.f18482g = aVarArr;
                this.f18483h = formatArr;
                this.f18477b = iArr;
                this.k = 0;
                this.f18484i = this.f18476a;
                this.f18476a = i6;
            }
        }
    }

    public void a(boolean z) {
        this.f18484i = 0;
        this.f18485j = 0;
        this.k = 0;
        this.l = 0;
        this.o = true;
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        if (z) {
            this.q = null;
            this.p = true;
        }
    }

    public boolean a(Format format) {
        boolean z;
        synchronized (this) {
            z = true;
            if (format == null) {
                this.p = true;
            } else {
                this.p = false;
                if (!u.a(format, this.q)) {
                    this.q = format;
                }
            }
            z = false;
        }
        return z;
    }

    public int b() {
        return this.f18485j + this.l;
    }

    public long b(long j2, boolean z, boolean z2) {
        long j3;
        int i2;
        synchronized (this) {
            int i3 = this.f18484i;
            j3 = -1;
            if (i3 != 0) {
                long[] jArr = this.f18481f;
                int i4 = this.k;
                if (j2 >= jArr[i4]) {
                    if (z2 && (i2 = this.l) != i3) {
                        i3 = i2 + 1;
                    }
                    int a2 = a(i4, i3, j2, z);
                    if (a2 != -1) {
                        j3 = b(a2);
                    }
                }
            }
        }
        return j3;
    }

    public boolean b(long j2) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.f18484i == 0) {
                if (j2 > this.m) {
                    z = true;
                }
            } else if (Math.max(this.m, c(this.l)) < j2) {
                int i2 = this.f18484i;
                int d2 = d(i2 - 1);
                while (i2 > this.l && this.f18481f[d2] >= j2) {
                    i2--;
                    d2--;
                    if (d2 == -1) {
                        d2 = this.f18476a - 1;
                    }
                }
                a(this.f18485j + i2);
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.l != this.f18484i;
        }
        return z;
    }

    public Format d() {
        Format format;
        synchronized (this) {
            format = this.p ? null : this.q;
        }
        return format;
    }

    public long e() {
        long j2;
        synchronized (this) {
            j2 = this.n;
        }
        return j2;
    }

    public void f() {
        synchronized (this) {
            this.l = 0;
        }
    }

    public int g() {
        int i2;
        int i3;
        synchronized (this) {
            i2 = this.f18484i;
            i3 = this.l;
            this.l = i2;
        }
        return i2 - i3;
    }

    public long h() {
        long b2;
        synchronized (this) {
            int i2 = this.f18484i;
            b2 = i2 == 0 ? -1L : b(i2);
        }
        return b2;
    }
}
