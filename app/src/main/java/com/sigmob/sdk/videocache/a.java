package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a */
    public volatile byte[] f20578a;

    /* renamed from: b */
    public volatile boolean f20579b;

    public a() {
        this(new byte[0]);
    }

    @Override // com.sigmob.sdk.videocache.c
    public void a(byte[] bArr, int i10) throws q {
        o.a(this.f20578a);
        o.a(i10 >= 0 && i10 <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.f20578a, this.f20578a.length + i10);
        System.arraycopy(bArr, 0, copyOf, this.f20578a.length, i10);
        this.f20578a = copyOf;
    }

    @Override // com.sigmob.sdk.videocache.c
    public boolean b() {
        return this.f20579b;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void c() {
        this.f20579b = true;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void close() throws q {
    }

    public a(byte[] bArr) {
        this.f20578a = (byte[]) o.a(bArr);
    }

    @Override // com.sigmob.sdk.videocache.c
    public long a() throws q {
        return this.f20578a.length;
    }

    @Override // com.sigmob.sdk.videocache.c
    public int a(byte[] bArr, long j10, int i10) throws q {
        if (j10 >= this.f20578a.length) {
            return -1;
        }
        if (j10 <= 2147483647L) {
            return new ByteArrayInputStream(this.f20578a).read(bArr, (int) j10, i10);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j10);
    }
}
