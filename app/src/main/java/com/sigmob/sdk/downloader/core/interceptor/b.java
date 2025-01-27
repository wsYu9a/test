package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class b implements c.b {

    /* renamed from: a */
    public final InputStream f19314a;

    /* renamed from: b */
    public final byte[] f19315b;

    /* renamed from: c */
    public final com.sigmob.sdk.downloader.core.file.d f19316c;

    /* renamed from: d */
    public final int f19317d;

    /* renamed from: e */
    public final f f19318e;

    /* renamed from: f */
    public final com.sigmob.sdk.downloader.core.dispatcher.a f19319f = g.j().b();

    public b(int i10, InputStream inputStream, com.sigmob.sdk.downloader.core.file.d dVar, f fVar) {
        this.f19317d = i10;
        this.f19314a = inputStream;
        this.f19315b = new byte[fVar.s()];
        this.f19316c = dVar;
        this.f19318e = fVar;
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long a(com.sigmob.sdk.downloader.core.download.f fVar) throws IOException {
        if (fVar.d().f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        g.j().f().a(fVar.k());
        int read = this.f19314a.read(this.f19315b);
        if (read == -1) {
            return read;
        }
        this.f19316c.a(this.f19317d, this.f19315b, read);
        long j10 = read;
        fVar.a(j10);
        if (this.f19319f.a(this.f19318e)) {
            fVar.b();
        }
        return j10;
    }
}
