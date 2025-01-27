package com.sigmob.sdk.downloader.core.interceptor.connect;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements c.a {

    /* renamed from: a */
    public static final String f19320a = "HeaderInterceptor";

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0584a b(f fVar) throws IOException {
        com.sigmob.sdk.downloader.core.breakpoint.c h10 = fVar.h();
        com.sigmob.sdk.downloader.core.connection.a f10 = fVar.f();
        com.sigmob.sdk.downloader.f k10 = fVar.k();
        Map<String, List<String>> m10 = k10.m();
        if (m10 != null) {
            com.sigmob.sdk.downloader.core.c.b(m10, f10);
        }
        if (m10 == null || !m10.containsKey("User-Agent")) {
            com.sigmob.sdk.downloader.core.c.a(f10);
        }
        int c10 = fVar.c();
        com.sigmob.sdk.downloader.core.breakpoint.a b10 = h10.b(c10);
        if (b10 == null) {
            throw new IOException("No block-info found on " + c10);
        }
        String str = "bytes=" + b10.d() + "-";
        if (!h10.l()) {
            str = str + b10.e();
        }
        f10.a("Range", str);
        com.sigmob.sdk.downloader.core.c.a(f19320a, "AssembleHeaderRange (" + k10.b() + ") block(" + c10 + ") downloadFrom(" + b10.d() + ") currentOffset(" + b10.c() + ")");
        String c11 = h10.c();
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) c11)) {
            f10.a("If-Match", c11);
        }
        if (fVar.d().f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        g.j().b().a().a(k10, c10, f10.d());
        a.InterfaceC0584a n10 = fVar.n();
        if (fVar.d().f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        Map<String, List<String>> e10 = n10.e();
        if (e10 == null) {
            e10 = new HashMap<>();
        }
        g.j().b().a().a(k10, c10, n10.f(), e10);
        g.j().f().a(n10, c10, h10).a();
        String c12 = n10.c("Content-Length");
        fVar.b((c12 == null || c12.length() == 0) ? com.sigmob.sdk.downloader.core.c.d(n10.c("Content-Range")) : com.sigmob.sdk.downloader.core.c.c(c12));
        return n10;
    }
}
