package com.tencent.open.utils;

/* loaded from: classes4.dex */
public final class j implements Cloneable {

    /* renamed from: a */
    private long f25558a;

    public j(long j2) {
        this.f25558a = j2;
    }

    public byte[] a() {
        long j2 = this.f25558a;
        return new byte[]{(byte) (255 & j2), (byte) ((65280 & j2) >> 8), (byte) ((16711680 & j2) >> 16), (byte) ((j2 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f25558a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof j) && this.f25558a == ((j) obj).b();
    }

    public int hashCode() {
        return (int) this.f25558a;
    }
}
