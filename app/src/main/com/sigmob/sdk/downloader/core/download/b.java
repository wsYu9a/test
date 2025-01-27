package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public boolean f19198a;

    /* renamed from: b */
    public boolean f19199b;

    /* renamed from: c */
    public com.sigmob.sdk.downloader.core.cause.b f19200c;

    /* renamed from: d */
    public long f19201d;

    /* renamed from: e */
    public final com.sigmob.sdk.downloader.f f19202e;

    /* renamed from: f */
    public final com.sigmob.sdk.downloader.core.breakpoint.c f19203f;

    public b(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f19202e = fVar;
        this.f19203f = cVar;
    }

    public boolean a(int i10, long j10, boolean z10) {
        return i10 == 416 && j10 >= 0 && z10;
    }

    public c b() {
        return new c(this.f19202e, this.f19203f);
    }

    public com.sigmob.sdk.downloader.core.cause.b c() {
        return this.f19200c;
    }

    public com.sigmob.sdk.downloader.core.cause.b d() {
        com.sigmob.sdk.downloader.core.cause.b bVar = this.f19200c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.f19199b);
    }

    public long e() {
        return this.f19201d;
    }

    public boolean f() {
        return this.f19198a;
    }

    public boolean g() {
        return this.f19199b;
    }

    public String toString() {
        return "acceptRange[" + this.f19198a + "] resumable[" + this.f19199b + "] failedCause[" + this.f19200c + "] instanceLength[" + this.f19201d + "] " + super.toString();
    }

    public void a() throws IOException {
        g f10 = com.sigmob.sdk.downloader.g.j().f();
        c b10 = b();
        b10.a();
        boolean f11 = b10.f();
        boolean g10 = b10.g();
        long b11 = b10.b();
        String d10 = b10.d();
        String e10 = b10.e();
        int c10 = b10.c();
        f10.a(e10, this.f19202e, this.f19203f);
        this.f19203f.a(g10);
        this.f19203f.a(d10);
        if (com.sigmob.sdk.downloader.g.j().e().i(this.f19202e)) {
            throw com.sigmob.sdk.downloader.core.exception.b.f19266a;
        }
        com.sigmob.sdk.downloader.core.cause.b a10 = f10.a(c10, this.f19203f.j() != 0, this.f19203f, d10);
        boolean z10 = a10 == null;
        this.f19199b = z10;
        this.f19200c = a10;
        this.f19201d = b11;
        this.f19198a = f11;
        if (a(c10, b11, z10)) {
            return;
        }
        if (f10.a(c10, this.f19203f.j() != 0)) {
            throw new i(c10, this.f19203f.j());
        }
    }
}
