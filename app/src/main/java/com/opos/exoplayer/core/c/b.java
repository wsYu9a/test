package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.i.u;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class b implements f {

    /* renamed from: b */
    private final com.opos.exoplayer.core.h.g f17783b;

    /* renamed from: c */
    private final long f17784c;

    /* renamed from: d */
    private long f17785d;

    /* renamed from: f */
    private int f17787f;

    /* renamed from: g */
    private int f17788g;

    /* renamed from: e */
    private byte[] f17786e = new byte[65536];

    /* renamed from: a */
    private final byte[] f17782a = new byte[4096];

    public b(com.opos.exoplayer.core.h.g gVar, long j2, long j3) {
        this.f17783b = gVar;
        this.f17785d = j2;
        this.f17784c = j3;
    }

    private int a(byte[] bArr, int i2, int i3, int i4, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a2 = this.f17783b.a(bArr, i2 + i4, i3 - i4);
        if (a2 != -1) {
            return i4 + a2;
        }
        if (i4 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private int d(byte[] bArr, int i2, int i3) {
        int i4 = this.f17788g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f17786e, 0, bArr, i2, min);
        f(min);
        return min;
    }

    private void d(int i2) {
        int i3 = this.f17787f + i2;
        byte[] bArr = this.f17786e;
        if (i3 > bArr.length) {
            this.f17786e = Arrays.copyOf(this.f17786e, u.a(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int e(int i2) {
        int min = Math.min(this.f17788g, i2);
        f(min);
        return min;
    }

    private void f(int i2) {
        int i3 = this.f17788g - i2;
        this.f17788g = i3;
        this.f17787f = 0;
        byte[] bArr = this.f17786e;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f17786e = bArr2;
    }

    private void g(int i2) {
        if (i2 != -1) {
            this.f17785d += i2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f
    public int a(int i2) {
        int e2 = e(i2);
        if (e2 == 0) {
            byte[] bArr = this.f17782a;
            e2 = a(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        g(e2);
        return e2;
    }

    @Override // com.opos.exoplayer.core.c.f
    public int a(byte[] bArr, int i2, int i3) {
        int d2 = d(bArr, i2, i3);
        if (d2 == 0) {
            d2 = a(bArr, i2, i3, 0, true);
        }
        g(d2);
        return d2;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void a() {
        this.f17787f = 0;
    }

    public boolean a(int i2, boolean z) {
        int e2 = e(i2);
        while (e2 < i2 && e2 != -1) {
            e2 = a(this.f17782a, -e2, Math.min(i2, this.f17782a.length + e2), e2, z);
        }
        g(e2);
        return e2 != -1;
    }

    @Override // com.opos.exoplayer.core.c.f
    public boolean a(byte[] bArr, int i2, int i3, boolean z) {
        int d2 = d(bArr, i2, i3);
        while (d2 < i3 && d2 != -1) {
            d2 = a(bArr, i2, i3, d2, z);
        }
        g(d2);
        return d2 != -1;
    }

    @Override // com.opos.exoplayer.core.c.f
    public long b() {
        return this.f17785d + this.f17787f;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void b(int i2) {
        a(i2, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public void b(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3, false);
    }

    public boolean b(int i2, boolean z) {
        d(i2);
        int min = Math.min(this.f17788g - this.f17787f, i2);
        while (min < i2) {
            min = a(this.f17786e, this.f17787f, i2, min, z);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.f17787f + i2;
        this.f17787f = i3;
        this.f17788g = Math.max(this.f17788g, i3);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.f
    public boolean b(byte[] bArr, int i2, int i3, boolean z) {
        if (!b(i3, z)) {
            return false;
        }
        System.arraycopy(this.f17786e, this.f17787f - i3, bArr, i2, i3);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.f
    public long c() {
        return this.f17785d;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void c(int i2) {
        b(i2, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public void c(byte[] bArr, int i2, int i3) {
        b(bArr, i2, i3, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public long d() {
        return this.f17784c;
    }
}
