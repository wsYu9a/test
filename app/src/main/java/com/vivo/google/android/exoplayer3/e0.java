package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import java.io.EOFException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class e0 implements n0 {

    /* renamed from: a */
    public final k5 f27307a;

    /* renamed from: b */
    public final int f27308b;

    /* renamed from: c */
    public final c f27309c;

    /* renamed from: d */
    public final LinkedBlockingDeque<j5> f27310d;

    /* renamed from: e */
    public final b f27311e;

    /* renamed from: f */
    public final n6 f27312f;

    /* renamed from: g */
    public final AtomicInteger f27313g;

    /* renamed from: h */
    public long f27314h;

    /* renamed from: i */
    public Format f27315i;

    /* renamed from: j */
    public boolean f27316j;
    public Format k;
    public long l;
    public j5 m;
    public int n;
    public boolean o;
    public d p;

    public static final class b {

        /* renamed from: a */
        public int f27317a;

        /* renamed from: b */
        public long f27318b;

        /* renamed from: c */
        public long f27319c;

        /* renamed from: d */
        public byte[] f27320d;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public interface d {
    }

    public e0(k5 k5Var) {
        this.f27307a = k5Var;
        int b2 = ((r5) k5Var).b();
        this.f27308b = b2;
        this.f27309c = new c();
        this.f27310d = new LinkedBlockingDeque<>();
        this.f27311e = new b();
        this.f27312f = new n6(32);
        this.f27313g = new AtomicInteger();
        this.n = b2;
    }

    public final int a(int i2) {
        if (this.n == this.f27308b) {
            this.n = 0;
            j5 a2 = ((r5) this.f27307a).a();
            this.m = a2;
            this.f27310d.add(a2);
        }
        return Math.min(i2, this.f27308b - this.n);
    }

    public final void a() {
        c cVar = this.f27309c;
        cVar.f27330j = 0;
        cVar.k = 0;
        cVar.l = 0;
        cVar.f27329i = 0;
        cVar.o = true;
        k5 k5Var = this.f27307a;
        LinkedBlockingDeque<j5> linkedBlockingDeque = this.f27310d;
        ((r5) k5Var).a((j5[]) linkedBlockingDeque.toArray(new j5[linkedBlockingDeque.size()]));
        this.f27310d.clear();
        ((r5) this.f27307a).e();
        this.f27314h = 0L;
        this.l = 0L;
        this.m = null;
        this.n = this.f27308b;
    }

    public final void a(long j2) {
        int i2 = ((int) (j2 - this.f27314h)) / this.f27308b;
        for (int i3 = 0; i3 < i2; i3++) {
            ((r5) this.f27307a).a(this.f27310d.remove());
            this.f27314h += this.f27308b;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(long j2, int i2, int i3, int i4, byte[] bArr) {
        if (this.f27316j) {
            a(this.k);
        }
        if (!d()) {
            this.f27309c.b(j2);
            return;
        }
        try {
            if (this.o) {
                if ((i2 & 1) != 0 && this.f27309c.a(j2)) {
                    this.o = false;
                }
                return;
            }
            this.f27309c.a(0 + j2, i2, (this.l - i3) - i4, i3, bArr);
        } finally {
            c();
        }
    }

    public void b() {
        if (this.f27313g.getAndSet(2) == 0) {
            a();
        }
    }

    public final void c() {
        if (this.f27313g.compareAndSet(1, 0)) {
            return;
        }
        a();
    }

    public final boolean d() {
        return this.f27313g.compareAndSet(0, 1);
    }

    public static final class c {

        /* renamed from: i */
        public int f27329i;

        /* renamed from: j */
        public int f27330j;
        public int k;
        public int l;
        public Format q;

        /* renamed from: a */
        public int f27321a = 1000;

        /* renamed from: b */
        public int[] f27322b = new int[1000];

        /* renamed from: c */
        public long[] f27323c = new long[1000];

        /* renamed from: f */
        public long[] f27326f = new long[1000];

        /* renamed from: e */
        public int[] f27325e = new int[1000];

        /* renamed from: d */
        public int[] f27324d = new int[1000];

        /* renamed from: g */
        public byte[][] f27327g = new byte[1000][];

        /* renamed from: h */
        public Format[] f27328h = new Format[1000];
        public long m = Long.MIN_VALUE;
        public long n = Long.MIN_VALUE;
        public boolean p = true;
        public boolean o = true;

        public synchronized long a() {
            return Math.max(this.m, this.n);
        }

        public synchronized long a(long j2, boolean z) {
            if (this.f27329i != 0) {
                long[] jArr = this.f27326f;
                int i2 = this.k;
                if (j2 >= jArr[i2]) {
                    if (j2 > this.n && !z) {
                        return -1L;
                    }
                    int i3 = 0;
                    int i4 = -1;
                    while (i2 != this.l && this.f27326f[i2] <= j2) {
                        if ((this.f27325e[i2] & 1) != 0) {
                            i4 = i3;
                        }
                        i2 = (i2 + 1) % this.f27321a;
                        i3++;
                    }
                    if (i4 == -1) {
                        return -1L;
                    }
                    int i5 = (this.k + i4) % this.f27321a;
                    this.k = i5;
                    this.f27330j += i4;
                    this.f27329i -= i4;
                    return this.f27323c[i5];
                }
            }
            return -1L;
        }

        public synchronized void a(long j2, int i2, long j3, int i3, byte[] bArr) {
            if (this.o) {
                if ((i2 & 1) == 0) {
                    return;
                } else {
                    this.o = false;
                }
            }
            g1.b(!this.p);
            b(j2);
            long[] jArr = this.f27326f;
            int i4 = this.l;
            jArr[i4] = j2;
            long[] jArr2 = this.f27323c;
            jArr2[i4] = j3;
            this.f27324d[i4] = i3;
            this.f27325e[i4] = i2;
            this.f27327g[i4] = bArr;
            this.f27328h[i4] = this.q;
            this.f27322b[i4] = 0;
            int i5 = this.f27329i + 1;
            this.f27329i = i5;
            int i6 = this.f27321a;
            if (i5 == i6) {
                int i7 = i6 + 1000;
                int[] iArr = new int[i7];
                long[] jArr3 = new long[i7];
                long[] jArr4 = new long[i7];
                int[] iArr2 = new int[i7];
                int[] iArr3 = new int[i7];
                byte[][] bArr2 = new byte[i7][];
                Format[] formatArr = new Format[i7];
                int i8 = this.k;
                int i9 = i6 - i8;
                System.arraycopy(jArr2, i8, jArr3, 0, i9);
                System.arraycopy(this.f27326f, this.k, jArr4, 0, i9);
                System.arraycopy(this.f27325e, this.k, iArr2, 0, i9);
                System.arraycopy(this.f27324d, this.k, iArr3, 0, i9);
                System.arraycopy(this.f27327g, this.k, bArr2, 0, i9);
                System.arraycopy(this.f27328h, this.k, formatArr, 0, i9);
                System.arraycopy(this.f27322b, this.k, iArr, 0, i9);
                int i10 = this.k;
                System.arraycopy(this.f27323c, 0, jArr3, i9, i10);
                System.arraycopy(this.f27326f, 0, jArr4, i9, i10);
                System.arraycopy(this.f27325e, 0, iArr2, i9, i10);
                System.arraycopy(this.f27324d, 0, iArr3, i9, i10);
                System.arraycopy(this.f27327g, 0, bArr2, i9, i10);
                System.arraycopy(this.f27328h, 0, formatArr, i9, i10);
                System.arraycopy(this.f27322b, 0, iArr, i9, i10);
                this.f27323c = jArr3;
                this.f27326f = jArr4;
                this.f27325e = iArr2;
                this.f27324d = iArr3;
                this.f27327g = bArr2;
                this.f27328h = formatArr;
                this.f27322b = iArr;
                this.k = 0;
                int i11 = this.f27321a;
                this.l = i11;
                this.f27329i = i11;
                this.f27321a = i7;
            } else {
                int i12 = i4 + 1;
                this.l = i12;
                if (i12 == i6) {
                    this.l = 0;
                }
            }
        }

        public synchronized boolean a(long j2) {
            boolean z = false;
            if (this.m >= j2) {
                return false;
            }
            int i2 = this.f27329i;
            while (i2 > 0 && this.f27326f[((this.k + i2) - 1) % this.f27321a] >= j2) {
                i2--;
            }
            int i3 = this.f27330j;
            int i4 = this.f27329i;
            int i5 = (i3 + i4) - (i2 + i3);
            if (i5 >= 0 && i5 <= i4) {
                z = true;
            }
            g1.a(z);
            if (i5 != 0) {
                int i6 = this.f27329i - i5;
                this.f27329i = i6;
                int i7 = this.l;
                int i8 = this.f27321a;
                this.l = ((i7 + i8) - i5) % i8;
                this.n = Long.MIN_VALUE;
                for (int i9 = i6 - 1; i9 >= 0; i9--) {
                    int i10 = (this.k + i9) % this.f27321a;
                    this.n = Math.max(this.n, this.f27326f[i10]);
                    if ((this.f27325e[i10] & 1) != 0) {
                        break;
                    }
                }
                long j3 = this.f27323c[this.l];
            } else if (this.f27330j != 0) {
                int i11 = this.l;
                if (i11 == 0) {
                    i11 = this.f27321a;
                }
                int i12 = i11 - 1;
                long j4 = this.f27323c[i12];
                int i13 = this.f27324d[i12];
            }
            return true;
        }

        public synchronized boolean a(Format format) {
            if (format == null) {
                this.p = true;
                return false;
            }
            this.p = false;
            if (Util.areEqual(format, this.q)) {
                return false;
            }
            this.q = format;
            return true;
        }

        public synchronized Format b() {
            return this.p ? null : this.q;
        }

        public synchronized void b(long j2) {
            this.n = Math.max(this.n, j2);
        }

        public synchronized boolean c() {
            return this.f27329i == 0;
        }

        public synchronized long d() {
            int i2 = this.f27329i;
            if (i2 == 0) {
                return -1L;
            }
            int i3 = this.k + i2;
            int i4 = this.f27321a;
            int i5 = (i3 - 1) % i4;
            this.k = i3 % i4;
            this.f27330j += i2;
            this.f27329i = 0;
            return this.f27323c[i5] + this.f27324d[i5];
        }

        public synchronized int a(C0922c c0922c, w wVar, boolean z, boolean z2, Format format, b bVar) {
            if (this.f27329i == 0) {
                if (z2) {
                    wVar.f28074a = 4;
                    return -4;
                }
                Format format2 = this.q;
                if (format2 == null || (!z && format2 == format)) {
                    return -3;
                }
                c0922c.f27231a = format2;
                return -5;
            }
            if (!z) {
                Format[] formatArr = this.f27328h;
                int i2 = this.k;
                if (formatArr[i2] == format) {
                    if (wVar.f28192c == null && wVar.f28194e == 0) {
                        return -3;
                    }
                    long j2 = this.f27326f[i2];
                    wVar.f28193d = j2;
                    wVar.f28074a = this.f27325e[i2];
                    bVar.f27317a = this.f27324d[i2];
                    bVar.f27318b = this.f27323c[i2];
                    bVar.f27320d = this.f27327g[i2];
                    this.m = Math.max(this.m, j2);
                    int i3 = this.f27329i - 1;
                    this.f27329i = i3;
                    int i4 = this.k + 1;
                    this.k = i4;
                    this.f27330j++;
                    if (i4 == this.f27321a) {
                        this.k = 0;
                    }
                    bVar.f27319c = i3 > 0 ? this.f27323c[this.k] : bVar.f27318b + bVar.f27317a;
                    return -4;
                }
            }
            c0922c.f27231a = this.f27328h[this.k];
            return -5;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(Format format) {
        boolean a2 = this.f27309c.a(format == null ? null : format);
        this.k = format;
        this.f27316j = false;
        d dVar = this.p;
        if (dVar == null || !a2) {
            return;
        }
        l3 l3Var = (l3) dVar;
        l3Var.n.post(l3Var.l);
    }

    public final void a(long j2, byte[] bArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            a(j2);
            int i4 = (int) (j2 - this.f27314h);
            int min = Math.min(i2 - i3, this.f27308b - i4);
            j5 peek = this.f27310d.peek();
            System.arraycopy(peek.f27544a, peek.f27545b + i4, bArr, i3, min);
            j2 += min;
            i3 += min;
        }
    }

    public void a(boolean z) {
        int andSet = this.f27313g.getAndSet(z ? 0 : 2);
        a();
        c cVar = this.f27309c;
        cVar.m = Long.MIN_VALUE;
        cVar.n = Long.MIN_VALUE;
        if (andSet == 2) {
            this.f27315i = null;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public int a(h0 h0Var, int i2, boolean z) {
        if (!d()) {
            int b2 = ((d0) h0Var).b(i2);
            if (b2 != -1) {
                return b2;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int a2 = a(i2);
            j5 j5Var = this.m;
            int a3 = ((d0) h0Var).a(j5Var.f27544a, j5Var.f27545b + this.n, a2);
            if (a3 == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            this.n += a3;
            this.l += a3;
            return a3;
        } finally {
            c();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.n0
    public void a(n6 n6Var, int i2) {
        if (!d()) {
            n6Var.d(n6Var.f27875b + i2);
            return;
        }
        while (i2 > 0) {
            int a2 = a(i2);
            j5 j5Var = this.m;
            n6Var.a(j5Var.f27544a, j5Var.f27545b + this.n, a2);
            this.n += a2;
            this.l += a2;
            i2 -= a2;
        }
        c();
    }
}
