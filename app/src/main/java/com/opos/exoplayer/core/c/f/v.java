package com.opos.exoplayer.core.c.f;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class v {

    /* renamed from: a */
    public byte[] f18286a;

    /* renamed from: b */
    public int f18287b;

    /* renamed from: c */
    private final int f18288c;

    /* renamed from: d */
    private boolean f18289d;

    /* renamed from: e */
    private boolean f18290e;

    public v(int i2, int i3) {
        this.f18288c = i2;
        byte[] bArr = new byte[i3 + 3];
        this.f18286a = bArr;
        bArr[2] = (byte) 1;
    }

    public void a() {
        this.f18289d = false;
        this.f18290e = false;
    }

    public void a(int i2) {
        com.opos.exoplayer.core.i.a.b(!this.f18289d);
        boolean z = i2 == this.f18288c;
        this.f18289d = z;
        if (z) {
            this.f18287b = 3;
            this.f18290e = false;
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f18289d) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f18286a;
            int length = bArr2.length;
            int i5 = this.f18287b;
            if (length < i5 + i4) {
                this.f18286a = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f18286a, this.f18287b, i4);
            this.f18287b = i4 + this.f18287b;
        }
    }

    public boolean b() {
        return this.f18290e;
    }

    public boolean b(int i2) {
        if (!this.f18289d) {
            return false;
        }
        this.f18287b -= i2;
        this.f18289d = false;
        this.f18290e = true;
        return true;
    }
}
