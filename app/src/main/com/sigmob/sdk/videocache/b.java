package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: classes4.dex */
public class b implements u {

    /* renamed from: a */
    public final byte[] f20580a;

    /* renamed from: b */
    public ByteArrayInputStream f20581b;

    public b(byte[] bArr) {
        this.f20580a = bArr;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String a() throws q {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v b() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void close() throws q {
    }

    @Override // com.sigmob.sdk.videocache.u
    public long d() throws q {
        return this.f20580a.length;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public int read(byte[] bArr) throws q {
        return this.f20581b.read(bArr, 0, bArr.length);
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j10) throws q {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f20580a);
        this.f20581b = byteArrayInputStream;
        byteArrayInputStream.skip(j10);
    }
}
