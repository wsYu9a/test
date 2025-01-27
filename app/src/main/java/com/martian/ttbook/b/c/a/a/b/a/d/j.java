package com.martian.ttbook.b.c.a.a.b.a.d;

import android.app.Activity;
import com.martian.ttbook.b.c.a.a.b.a.c;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class j extends com.martian.ttbook.b.c.a.a.d.b.a implements com.martian.ttbook.b.c.a.a.c.o.a {

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.D();
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15408a;

        b(Activity activity) {
            this.f15408a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.C(this.f15408a);
        }
    }

    public j(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
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

    protected void C(Activity activity) {
        D();
    }

    protected void D() {
        com.martian.ttbook.b.c.a.a.e.d.f("当前传入Activity为空");
    }

    @Override // com.martian.ttbook.b.c.a.a.c.o.a
    public Map<String, Object> a() {
        return this.f15661b;
    }

    public void a(int i2, int i3, String str) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
    }

    public void sendWinNotification(int i2) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.o.a
    public void show() {
        if (com.martian.ttbook.b.c.a.a.e.i.e()) {
            D();
        } else {
            com.martian.ttbook.b.c.a.a.e.j.c(new a());
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.o.a
    public void show(Activity activity) {
        if (com.martian.ttbook.b.c.a.a.e.i.e()) {
            C(activity);
        } else {
            com.martian.ttbook.b.c.a.a.e.j.c(new b(activity));
        }
    }
}
