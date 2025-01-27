package com.sigmob.sdk.downloader.core.interceptor;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;

/* loaded from: classes4.dex */
public class d implements c.a, c.b {
    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long a(f fVar) throws IOException {
        try {
            return fVar.o();
        } catch (IOException e10) {
            fVar.d().a(e10);
            throw e10;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0584a b(f fVar) throws IOException {
        com.sigmob.sdk.downloader.core.download.d d10 = fVar.d();
        while (true) {
            try {
                if (d10.f()) {
                    throw com.sigmob.sdk.downloader.core.exception.c.f19267a;
                }
                return fVar.n();
            } catch (IOException e10) {
                if (!(e10 instanceof g)) {
                    fVar.d().a(e10);
                    fVar.i().a(fVar.c());
                    throw e10;
                }
                fVar.r();
            }
        }
    }
}
