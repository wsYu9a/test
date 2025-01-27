package com.vivo.push.d;

/* loaded from: classes4.dex */
final class ai extends com.vivo.push.l {
    public ai(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
        com.vivo.push.model.b a10 = com.vivo.push.util.t.a(this.f25064a);
        if (a10 == null) {
            com.vivo.push.e.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a11 = a10.a();
        if (a10.c()) {
            com.vivo.push.e.a().a(cVar.h(), 1004, new Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a12 = com.vivo.push.util.s.a(cVar);
            if (a12 != 0) {
                com.vivo.push.e.a().a(cVar.h(), a12, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f25064a, a11, oVar);
    }
}
