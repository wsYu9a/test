package com.martian.ttbook.b.c.a.a.b.a.d;

import android.app.Activity;
import com.martian.ttbook.b.c.a.a.d.b.a;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class h extends a implements com.martian.ttbook.b.c.a.a.c.n.a {
    public h(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding floor " + i2);
        a(1, i2, null);
        com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！");
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15663d.k()) {
            return;
        }
        this.f15662c.f15673g.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding win " + i2);
        if (!com.martian.ttbook.b.c.a.a.e.i.m(this.f15663d) && i2 > 0) {
            sendWinNotification(i2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.n.a
    public Map<String, Object> a() {
        return this.f15661b;
    }

    public void a(int i2, int i3, String str) {
    }

    public void b() {
    }

    public int getAdPatternType() {
        return 0;
    }

    public void sendWinNotification(int i2) {
    }

    public void show() {
        com.martian.ttbook.b.c.a.a.e.d.f("当前传入Activity为空");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar != null) {
            eVar.a(new com.martian.ttbook.b.c.a.a.d.b.i(-1001, "show failed,当前传入Activity为空"));
        }
    }

    public void show(Activity activity) {
        show();
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void z() {
        if (x()) {
            return;
        }
        super.z();
    }
}
