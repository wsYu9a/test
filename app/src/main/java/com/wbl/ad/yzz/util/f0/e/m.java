package com.wbl.ad.yzz.util.f0.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public class m implements Closeable {

    /* renamed from: a */
    public final InputStream f34326a;

    /* renamed from: b */
    public final Charset f34327b;

    /* renamed from: c */
    public byte[] f34328c;

    /* renamed from: d */
    public int f34329d;

    /* renamed from: e */
    public int f34330e;

    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8304, this, null);
        }
    }

    public m(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public static /* synthetic */ Charset a(m mVar) {
        return (Charset) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8303, null, mVar);
    }

    public final void a() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8298, this, null);
    }

    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8297, this, null);
    }

    public String c() throws IOException {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8300, this, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8299, this, null);
    }

    public m(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(n.f34332a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f34326a = inputStream;
        this.f34327b = charset;
        this.f34328c = new byte[i2];
    }
}
