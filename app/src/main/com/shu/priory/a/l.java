package com.shu.priory.a;

/* loaded from: classes3.dex */
final class l {

    /* renamed from: a */
    private final g f16816a;

    /* renamed from: b */
    private final long f16817b;

    public l(g gVar, long j10) {
        this.f16816a = gVar;
        this.f16817b = j10;
    }

    public byte[] a() {
        long c10 = this.f16816a.e().c();
        int i10 = this.f16816a.e().a() == 16 ? 1 : 2;
        byte e10 = this.f16816a.e().e();
        long j10 = this.f16817b;
        return a(j10 - 44, j10 - 8, c10, i10, ((e10 * c10) * i10) / 8, e10);
    }

    private byte[] a(long j10, long j11, long j12, int i10, long j13, byte b10) {
        return new byte[]{82, 73, 70, 70, (byte) (j11 & 255), (byte) ((j11 >> 8) & 255), (byte) ((j11 >> 16) & 255), (byte) ((j11 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i10, 0, (byte) (j12 & 255), (byte) ((j12 >> 8) & 255), (byte) ((j12 >> 16) & 255), (byte) ((j12 >> 24) & 255), (byte) (j13 & 255), (byte) ((j13 >> 8) & 255), (byte) ((j13 >> 16) & 255), (byte) ((j13 >> 24) & 255), (byte) (i10 * (b10 / 8)), 0, b10, 0, 100, 97, 116, 97, (byte) (j10 & 255), (byte) ((j10 >> 8) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 24) & 255)};
    }
}
