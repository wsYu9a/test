package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public class i implements Closeable {

    /* renamed from: a */
    public final InputStream f32091a;

    /* renamed from: b */
    public final Charset f32092b;

    /* renamed from: c */
    public byte[] f32093c;

    /* renamed from: d */
    public int f32094d;

    /* renamed from: e */
    public int f32095e;

    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13892, this, null);
        }
    }

    public i(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public static /* synthetic */ Charset a(i iVar) {
        return (Charset) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13891, null, iVar);
    }

    public final void a() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13918, this, null);
    }

    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13917, this, null);
    }

    public String c() throws IOException {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13920, this, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13919, this, null);
    }

    public i(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(com.wbl.ad.yzz.download.i.a.f32052a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f32091a = inputStream;
        this.f32092b = charset;
        this.f32093c = new byte[i2];
    }
}
