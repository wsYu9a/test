package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a implements c.a, c.b {

    /* renamed from: a */
    public static final String f19312a = "BreakpointInterceptor";

    /* renamed from: b */
    public static final Pattern f19313b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Content-Range"
            java.lang.String r0 = r7.c(r0)
            boolean r1 = com.sigmob.sdk.downloader.core.c.a(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            long r0 = a(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L1a
            r4 = 1
            long r0 = r0 + r4
            goto L1c
        L1a:
            r0 = -1
        L1c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L30
            java.lang.String r2 = "Content-Length"
            java.lang.String r7 = r7.c(r2)
            boolean r2 = com.sigmob.sdk.downloader.core.c.a(r7)
            if (r2 != 0) goto L30
            long r0 = java.lang.Long.parseLong(r7)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.interceptor.a.a(com.sigmob.sdk.downloader.core.connection.a$a):long");
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0584a b(f fVar) throws IOException {
        a.InterfaceC0584a n10 = fVar.n();
        com.sigmob.sdk.downloader.core.breakpoint.c h10 = fVar.h();
        if (fVar.d().f()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
        }
        if (h10.b() == 1 && !h10.l()) {
            long a10 = a(n10);
            long i10 = h10.i();
            if (a10 > 0 && a10 != i10) {
                com.sigmob.sdk.downloader.core.c.a(f19312a, "SingleBlock special check: the response instance-length[" + a10 + "] isn't equal to the instance length from trial-connection[" + i10 + "]");
                boolean z10 = h10.b(0).d() != 0;
                com.sigmob.sdk.downloader.core.breakpoint.a aVar = new com.sigmob.sdk.downloader.core.breakpoint.a(0L, a10);
                h10.o();
                h10.a(aVar);
                if (z10) {
                    com.sigmob.sdk.downloader.core.c.c(f19312a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(fVar.k(), h10, com.sigmob.sdk.downloader.core.cause.b.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (fVar.g().a(h10)) {
                return n10;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e10) {
            throw new IOException("Update store failed!", e10);
        }
    }

    public static long a(String str) {
        Matcher matcher = f19313b.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long a(f fVar) throws IOException {
        long j10 = fVar.j();
        int c10 = fVar.c();
        boolean z10 = j10 != -1;
        com.sigmob.sdk.downloader.core.file.d i10 = fVar.i();
        long j11 = 0;
        while (true) {
            try {
                long m10 = fVar.m();
                if (m10 == -1) {
                    break;
                }
                j11 += m10;
            } finally {
                fVar.b();
                if (!fVar.d().k()) {
                    i10.c(c10);
                }
            }
        }
        if (z10) {
            i10.d(c10);
            if (j11 != j10) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j11 + "!= " + j10);
            }
        }
        return j11;
    }
}
