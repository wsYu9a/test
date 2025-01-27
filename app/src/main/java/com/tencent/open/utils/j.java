package com.tencent.open.utils;

/* loaded from: classes4.dex */
public final class j implements Cloneable {

    /* renamed from: a */
    private long f23292a;

    public j(long j10) {
        this.f23292a = j10;
    }

    public byte[] a() {
        long j10 = this.f23292a;
        return new byte[]{(byte) (255 & j10), (byte) ((65280 & j10) >> 8), (byte) ((16711680 & j10) >> 16), (byte) ((j10 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f23292a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof j) && this.f23292a == ((j) obj).b();
    }

    public int hashCode() {
        return (int) this.f23292a;
    }
}
