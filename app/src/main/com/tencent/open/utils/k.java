package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;

/* loaded from: classes4.dex */
public final class k implements Cloneable {

    /* renamed from: a */
    private int f23293a;

    public k(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i10 = this.f23293a;
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.f23293a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && this.f23293a == ((k) obj).b();
    }

    public int hashCode() {
        return this.f23293a;
    }

    public k(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f23293a = i11;
        this.f23293a = i11 + (bArr[i10] & 255);
    }

    public k(int i10) {
        this.f23293a = i10;
    }
}
