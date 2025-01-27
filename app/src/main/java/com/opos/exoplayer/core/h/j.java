package com.opos.exoplayer.core.h;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class j implements b {

    /* renamed from: a */
    private final boolean f18925a;

    /* renamed from: b */
    private final int f18926b;

    /* renamed from: c */
    private final byte[] f18927c;

    /* renamed from: d */
    private final a[] f18928d;

    /* renamed from: e */
    private int f18929e;

    /* renamed from: f */
    private int f18930f;

    /* renamed from: g */
    private int f18931g;

    /* renamed from: h */
    private a[] f18932h;

    public j(boolean z, int i2) {
        this(z, i2, 0);
    }

    public j(boolean z, int i2, int i3) {
        com.opos.exoplayer.core.i.a.a(i2 > 0);
        com.opos.exoplayer.core.i.a.a(i3 >= 0);
        this.f18925a = z;
        this.f18926b = i2;
        this.f18931g = i3;
        this.f18932h = new a[i3 + 100];
        if (i3 > 0) {
            this.f18927c = new byte[i3 * i2];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f18932h[i4] = new a(this.f18927c, i4 * i2);
            }
        } else {
            this.f18927c = null;
        }
        this.f18928d = new a[1];
    }

    @Override // com.opos.exoplayer.core.h.b
    public a a() {
        a aVar;
        synchronized (this) {
            this.f18930f++;
            int i2 = this.f18931g;
            if (i2 > 0) {
                a[] aVarArr = this.f18932h;
                int i3 = i2 - 1;
                this.f18931g = i3;
                aVar = aVarArr[i3];
                aVarArr[i3] = null;
            } else {
                aVar = new a(new byte[this.f18926b], 0);
            }
        }
        return aVar;
    }

    public void a(int i2) {
        synchronized (this) {
            boolean z = i2 < this.f18929e;
            this.f18929e = i2;
            if (z) {
                b();
            }
        }
    }

    @Override // com.opos.exoplayer.core.h.b
    public void a(a aVar) {
        synchronized (this) {
            a[] aVarArr = this.f18928d;
            aVarArr[0] = aVar;
            a(aVarArr);
        }
    }

    @Override // com.opos.exoplayer.core.h.b
    public void a(a[] aVarArr) {
        boolean z;
        synchronized (this) {
            int i2 = this.f18931g;
            int length = aVarArr.length + i2;
            a[] aVarArr2 = this.f18932h;
            if (length >= aVarArr2.length) {
                this.f18932h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i2 + aVarArr.length));
            }
            for (a aVar : aVarArr) {
                byte[] bArr = aVar.f18899a;
                if (bArr != this.f18927c && bArr.length != this.f18926b) {
                    z = false;
                    com.opos.exoplayer.core.i.a.a(z);
                    a[] aVarArr3 = this.f18932h;
                    int i3 = this.f18931g;
                    this.f18931g = i3 + 1;
                    aVarArr3[i3] = aVar;
                }
                z = true;
                com.opos.exoplayer.core.i.a.a(z);
                a[] aVarArr32 = this.f18932h;
                int i32 = this.f18931g;
                this.f18931g = i32 + 1;
                aVarArr32[i32] = aVar;
            }
            this.f18930f -= aVarArr.length;
            notifyAll();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:
    
        if (r0 < r8.f18931g) goto L59;
     */
    @Override // com.opos.exoplayer.core.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.f18929e     // Catch: java.lang.Throwable -> L52
            int r1 = r8.f18926b     // Catch: java.lang.Throwable -> L52
            int r0 = com.opos.exoplayer.core.i.u.a(r0, r1)     // Catch: java.lang.Throwable -> L52
            int r1 = r8.f18930f     // Catch: java.lang.Throwable -> L52
            int r0 = r0 - r1
            r1 = 0
            int r0 = java.lang.Math.max(r1, r0)     // Catch: java.lang.Throwable -> L52
            int r2 = r8.f18931g     // Catch: java.lang.Throwable -> L52
            if (r0 < r2) goto L16
            goto L50
        L16:
            byte[] r3 = r8.f18927c     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L46
            int r2 = r2 + (-1)
        L1c:
            if (r1 > r2) goto L3e
            com.opos.exoplayer.core.h.a[] r3 = r8.f18932h     // Catch: java.lang.Throwable -> L52
            r4 = r3[r1]     // Catch: java.lang.Throwable -> L52
            byte[] r5 = r4.f18899a     // Catch: java.lang.Throwable -> L52
            byte[] r6 = r8.f18927c     // Catch: java.lang.Throwable -> L52
            if (r5 != r6) goto L2b
            int r1 = r1 + 1
            goto L1c
        L2b:
            r5 = r3[r2]     // Catch: java.lang.Throwable -> L52
            byte[] r7 = r5.f18899a     // Catch: java.lang.Throwable -> L52
            if (r7 == r6) goto L34
            int r2 = r2 + (-1)
            goto L1c
        L34:
            int r6 = r1 + 1
            r3[r1] = r5
            r3[r2] = r4     // Catch: java.lang.Throwable -> L52
            int r2 = r2 + (-1)
            r1 = r6
            goto L1c
        L3e:
            int r0 = java.lang.Math.max(r0, r1)     // Catch: java.lang.Throwable -> L52
            int r1 = r8.f18931g     // Catch: java.lang.Throwable -> L52
            if (r0 >= r1) goto L50
        L46:
            com.opos.exoplayer.core.h.a[] r1 = r8.f18932h     // Catch: java.lang.Throwable -> L52
            int r2 = r8.f18931g     // Catch: java.lang.Throwable -> L52
            r3 = 0
            java.util.Arrays.fill(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L52
            r8.f18931g = r0     // Catch: java.lang.Throwable -> L52
        L50:
            monitor-exit(r8)
            return
        L52:
            r0 = move-exception
            monitor-exit(r8)
            goto L56
        L55:
            throw r0
        L56:
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.j.b():void");
    }

    @Override // com.opos.exoplayer.core.h.b
    public int c() {
        return this.f18926b;
    }

    public void d() {
        synchronized (this) {
            if (this.f18925a) {
                a(0);
            }
        }
    }

    public int e() {
        int i2;
        int i3;
        synchronized (this) {
            i2 = this.f18930f;
            i3 = this.f18926b;
        }
        return i2 * i3;
    }
}
