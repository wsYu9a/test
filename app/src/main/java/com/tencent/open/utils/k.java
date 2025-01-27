package com.tencent.open.utils;

/* loaded from: classes4.dex */
public final class k implements Cloneable {

    /* renamed from: a */
    private int f25559a;

    public k(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i2 = this.f25559a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public int b() {
        return this.f25559a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f25559a == ((k) obj).b();
    }

    public int hashCode() {
        return this.f25559a;
    }

    public k(byte[] bArr, int i2) {
        int i3 = (bArr[i2 + 1] << 8) & 65280;
        this.f25559a = i3;
        this.f25559a = i3 + (bArr[i2] & 255);
    }

    public k(int i2) {
        this.f25559a = i2;
    }
}
