package com.wbl.ad.yzz.util.f0.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class c extends FilterInputStream {

    /* renamed from: a */
    public final long f34284a;

    /* renamed from: b */
    public int f34285b;

    public c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f34284a = j2;
    }

    public static InputStream a(InputStream inputStream, long j2) {
        return (InputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9177, null, inputStream, Long.valueOf(j2));
    }

    public final int a(int i2) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9180, this, Integer.valueOf(i2));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9179, this, null);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9174, this, null);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9173, this, bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9176, this, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
