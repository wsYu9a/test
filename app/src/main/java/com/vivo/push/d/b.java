package com.vivo.push.d;

/* loaded from: classes4.dex */
final class b extends com.vivo.push.l {
    public b(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.model.b a10 = com.vivo.push.util.t.a(this.f25064a);
        try {
            if (((com.vivo.push.b.d) oVar).d() ? f.a(this.f25064a) : f.b(this.f25064a)) {
                com.vivo.push.model.b a11 = com.vivo.push.util.t.a(this.f25064a);
                if (a10 == null || a11 == null || a11.a() == null || !a11.a().equals(a10.a())) {
                    if (a10 != null && a10.a() != null) {
                        com.vivo.push.a.a.a(this.f25064a, a10.a(), new com.vivo.push.b.y(a10.a()));
                    }
                    if (a11 == null || a11.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.f25064a, a11.a(), new com.vivo.push.b.f());
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
