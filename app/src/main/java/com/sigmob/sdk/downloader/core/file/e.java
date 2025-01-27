package com.sigmob.sdk.downloader.core.file;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public final c f19311a = new c();

    public void a(d dVar, f fVar) {
    }

    public boolean b(f fVar) {
        if (!g.j().h().a()) {
            return false;
        }
        if (fVar.v() != null) {
            return fVar.v().booleanValue();
        }
        return true;
    }

    public d a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar) {
        return new d(fVar, cVar, jVar);
    }

    public void a(f fVar) throws IOException {
        File z10 = fVar.z();
        if (z10 != null && z10.exists() && !z10.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public c a() {
        return this.f19311a;
    }
}
