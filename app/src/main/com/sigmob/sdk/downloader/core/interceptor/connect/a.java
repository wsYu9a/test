package com.sigmob.sdk.downloader.core.interceptor.connect;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;

/* loaded from: classes4.dex */
public class a implements c.a {
    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0584a b(f fVar) throws IOException {
        g.j().f().a(fVar.k());
        g.j().f().a();
        return fVar.f().execute();
    }
}
