package com.vivo.google.android.exoplayer3;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class p2 {

    /* renamed from: a */
    public final int f27928a;

    /* renamed from: b */
    public boolean f27929b;

    /* renamed from: c */
    public boolean f27930c;

    /* renamed from: d */
    public byte[] f27931d;

    /* renamed from: e */
    public int f27932e;

    public p2(int i2, int i3) {
        this.f27928a = i2;
        byte[] bArr = new byte[i3 + 3];
        this.f27931d = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.f27929b = false;
        this.f27930c = false;
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f27929b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f27931d;
            int length = bArr2.length;
            int i5 = this.f27932e + i4;
            if (length < i5) {
                this.f27931d = Arrays.copyOf(bArr2, i5 * 2);
            }
            System.arraycopy(bArr, i2, this.f27931d, this.f27932e, i4);
            this.f27932e += i4;
        }
    }

    public boolean a(int i2) {
        if (!this.f27929b) {
            return false;
        }
        this.f27932e -= i2;
        this.f27929b = false;
        this.f27930c = true;
        return true;
    }

    public void b(int i2) {
        g1.b(!this.f27929b);
        boolean z = i2 == this.f27928a;
        this.f27929b = z;
        if (z) {
            this.f27932e = 3;
            this.f27930c = false;
        }
    }
}
