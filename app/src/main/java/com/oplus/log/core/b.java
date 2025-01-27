package com.oplus.log.core;

import com.oplus.log.core.e;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    static boolean f16111a = false;

    /* renamed from: b */
    public d f16112b;

    public final void a(c cVar) {
        this.f16112b = new d(cVar);
    }

    public final void b(e.b bVar) {
        d dVar = this.f16112b;
        if (dVar == null) {
            throw new RuntimeException("Please initialize Logan first");
        }
        dVar.a(bVar);
    }

    public final void c(i iVar) {
        this.f16112b.b(iVar);
    }
}
