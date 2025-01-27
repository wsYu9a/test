package com.martian.ttbook.b.c.a.a.b.a.d;

import com.martian.ttbook.b.c.a.a.d.b.a;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class d extends a implements com.martian.ttbook.b.c.a.a.c.k.a {
    public d(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    protected void A(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding floor " + i2);
        a(1, i2, null);
        com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！");
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15663d.k()) {
            return;
        }
        this.f15662c.f15673g.a(iVar);
    }

    protected void B(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding win " + i2);
        if (!com.martian.ttbook.b.c.a.a.e.i.m(this.f15663d) && i2 > 0) {
            sendWinNotification(i2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public Map<String, Object> a() {
        return this.f15661b;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
    }
}
