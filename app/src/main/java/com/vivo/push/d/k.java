package com.vivo.push.d;

/* loaded from: classes4.dex */
public final class k extends z {
    k(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) oVar;
        int d2 = lVar.d();
        int e2 = lVar.e();
        com.vivo.push.util.w.b().a("key_dispatch_environment", d2);
        com.vivo.push.util.w.b().a("key_dispatch_area", e2);
    }
}
