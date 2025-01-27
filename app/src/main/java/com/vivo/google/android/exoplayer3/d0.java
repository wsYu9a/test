package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.util.Util;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class d0 implements h0 {

    /* renamed from: g */
    public static final byte[] f27265g = new byte[4096];

    /* renamed from: a */
    public final DataSource f27266a;

    /* renamed from: b */
    public final long f27267b;

    /* renamed from: c */
    public long f27268c;

    /* renamed from: d */
    public byte[] f27269d = new byte[65536];

    /* renamed from: e */
    public int f27270e;

    /* renamed from: f */
    public int f27271f;

    public d0(DataSource dataSource, long j2, long j3) {
        this.f27266a = dataSource;
        this.f27268c = j2;
        this.f27267b = j3;
    }

    public final int a(byte[] bArr, int i2, int i3, int i4, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.f27266a.read(bArr, i2 + i4, i3 - i4);
        if (read != -1) {
            return i4 + read;
        }
        if (i4 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void a(int i2) {
        if (i2 != -1) {
            this.f27268c += i2;
        }
    }

    public boolean a(int i2, boolean z) {
        int i3 = this.f27270e + i2;
        byte[] bArr = this.f27269d;
        if (i3 > bArr.length) {
            this.f27269d = Arrays.copyOf(this.f27269d, Util.constrainValue(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
        int min = Math.min(this.f27271f - this.f27270e, i2);
        while (min < i2) {
            min = a(this.f27269d, this.f27270e, i2, min, z);
            if (min == -1) {
                return false;
            }
        }
        int i4 = this.f27270e + i2;
        this.f27270e = i4;
        this.f27271f = Math.max(this.f27271f, i4);
        return true;
    }

    public boolean a(byte[] bArr, int i2, int i3, boolean z) {
        if (!a(i3, z)) {
            return false;
        }
        System.arraycopy(this.f27269d, this.f27270e - i3, bArr, i2, i3);
        return true;
    }

    public boolean b(byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        int i5 = this.f27271f;
        if (i5 == 0) {
            i4 = 0;
        } else {
            int min = Math.min(i5, i3);
            System.arraycopy(this.f27269d, 0, bArr, i2, min);
            d(min);
            i4 = min;
        }
        while (i4 < i3 && i4 != -1) {
            i4 = a(bArr, i2, i3, i4, z);
        }
        a(i4);
        return i4 != -1;
    }

    public void c(int i2) {
        int min = Math.min(this.f27271f, i2);
        d(min);
        int i3 = min;
        while (i3 < i2 && i3 != -1) {
            byte[] bArr = f27265g;
            i3 = a(bArr, -i3, Math.min(i2, bArr.length + i3), i3, false);
        }
        a(i3);
    }

    public final void d(int i2) {
        int i3 = this.f27271f - i2;
        this.f27271f = i3;
        this.f27270e = 0;
        byte[] bArr = this.f27269d;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f27269d = bArr2;
    }

    public int a(byte[] bArr, int i2, int i3) {
        int i4 = this.f27271f;
        int i5 = 0;
        if (i4 != 0) {
            int min = Math.min(i4, i3);
            System.arraycopy(this.f27269d, 0, bArr, i2, min);
            d(min);
            i5 = min;
        }
        if (i5 == 0) {
            i5 = a(bArr, i2, i3, 0, true);
        }
        a(i5);
        return i5;
    }

    public int b(int i2) {
        int min = Math.min(this.f27271f, i2);
        d(min);
        if (min == 0) {
            byte[] bArr = f27265g;
            min = a(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        a(min);
        return min;
    }
}
