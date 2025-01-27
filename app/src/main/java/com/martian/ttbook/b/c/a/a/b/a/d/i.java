package com.martian.ttbook.b.c.a.a.b.a.d;

import com.martian.ttbook.b.c.a.a.d.b.a;

/* loaded from: classes4.dex */
public abstract class i extends a {

    /* renamed from: f */
    protected boolean f15406f;

    public i(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15406f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding floor " + i2);
        B(obj, 1, i2);
    }

    protected void B(Object obj, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding win " + i2);
        if (!com.martian.ttbook.b.c.a.a.e.i.m(this.f15663d) && i2 > 0) {
            E(obj, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(com.martian.ttbook.b.c.a.a.d.b.i iVar) {
        com.martian.ttbook.b.c.a.a.e.d.c("ADHTAG", "onAdError %s", iVar);
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15406f || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    protected void E(Object obj, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F() {
        return com.martian.ttbook.b.c.a.a.e.i.n(this.f15663d);
    }
}
