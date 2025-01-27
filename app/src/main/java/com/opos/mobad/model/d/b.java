package com.opos.mobad.model.d;

import com.opos.mobad.l.o;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class b implements m {

    /* renamed from: a */
    private m.a f21556a;

    /* renamed from: b */
    private com.opos.mobad.l.o f21557b = new o.a(1).a(1, 2, 8).a(2, 3, 4, 8).a(3, 5, 8).a(4, 8).a(5, 6, 7, 8).a(6, 8).a(7, 8).a();

    /* renamed from: com.opos.mobad.model.d.b$1 */
    class AnonymousClass1 implements Callable<Boolean> {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            b.this.e();
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.model.d.b$2 */
    class AnonymousClass2 implements Callable<Boolean> {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            b.this.b();
            return Boolean.TRUE;
        }
    }

    public b(m.a aVar) {
        this.f21556a = aVar;
    }

    protected abstract void a();

    protected void a(AdData adData) {
        int a2 = this.f21557b.a(4);
        if (a2 == 4) {
            m.a aVar = this.f21556a;
            if (aVar != null) {
                aVar.a(adData);
                return;
            }
            return;
        }
        if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":4");
        }
    }

    protected boolean a(Callable<Boolean> callable) {
        int a2 = this.f21557b.a(3, callable);
        if (a2 == 3) {
            m.a aVar = this.f21556a;
            if (aVar != null) {
                aVar.a();
            }
            return true;
        }
        if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":3");
        }
        return false;
    }

    protected abstract void b();

    protected void b(AdData adData) {
        int a2 = this.f21557b.a(7);
        if (a2 == 7) {
            m.a aVar = this.f21556a;
            if (aVar != null) {
                aVar.c(adData);
                return;
            }
            return;
        }
        if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":7");
        }
    }

    protected void c(AdData adData) {
        int a2 = this.f21557b.a(6);
        if (a2 == 6) {
            m.a aVar = this.f21556a;
            if (aVar != null) {
                aVar.b(adData);
                return;
            }
            return;
        }
        if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":7");
        }
    }

    protected abstract void e();

    public void f() {
        int a2 = this.f21557b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.model.d.b.1
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.e();
                return Boolean.TRUE;
            }
        });
        if (a2 != 2) {
            com.opos.cmn.an.f.a.b("ALoader", "error state:" + a2 + ":2");
        }
    }

    @Override // com.opos.mobad.model.d.m
    public void g() {
        int a2 = this.f21557b.a(5);
        if (5 == a2) {
            a();
            return;
        }
        com.opos.cmn.an.f.a.b("ALoader", "error state:" + a2 + ":5");
    }

    protected boolean h() {
        int a2 = this.f21557b.a(2, 3);
        if (a2 == 3) {
            m.a aVar = this.f21556a;
            if (aVar != null) {
                aVar.a();
            }
            return true;
        }
        if (a2 != 8) {
            com.opos.cmn.an.f.a.c("ALoader", "error state:" + a2 + ":3");
        }
        return false;
    }

    public void i() {
        this.f21557b.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.model.d.b.2
            AnonymousClass2() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.this.b();
                return Boolean.TRUE;
            }
        });
    }

    public int j() {
        return this.f21557b.a();
    }
}
