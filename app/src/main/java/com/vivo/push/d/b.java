package com.vivo.push.d;

/* loaded from: classes4.dex */
final class b extends com.vivo.push.l {
    b(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        com.vivo.push.model.b a2 = com.vivo.push.util.t.a(this.f31028a);
        try {
            if (((com.vivo.push.b.d) oVar).d() ? f.a(this.f31028a) : f.b(this.f31028a)) {
                com.vivo.push.model.b a3 = com.vivo.push.util.t.a(this.f31028a);
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.f31028a, a2.a(), new com.vivo.push.b.y(a2.a()));
                    }
                    if (a3 == null || a3.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.f31028a, a3.a(), new com.vivo.push.b.f());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
