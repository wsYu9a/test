package com.opos.mobad.l;

import android.app.Activity;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class h extends k implements com.opos.mobad.ad.d.a {

    /* renamed from: a */
    private com.opos.mobad.ad.d.b f21194a;

    /* renamed from: com.opos.mobad.l.h$1 */
    class AnonymousClass1 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ boolean f21195a;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(h.this.b(z));
        }
    }

    public h(com.opos.mobad.ad.d.b bVar) {
        super(bVar);
        this.f21194a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(long j2) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.a(j2);
    }

    @Override // com.opos.mobad.ad.d.a
    public void a(boolean z) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.l.h.1

            /* renamed from: a */
            final /* synthetic */ boolean f21195a;

            AnonymousClass1(boolean z2) {
                z = z2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(h.this.b(z));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Object... objArr) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.a(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(long j2) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.b(j2);
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        return b(false);
    }

    protected abstract boolean b(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(String str) {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.b(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h_() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        com.opos.mobad.ad.d.b bVar;
        if (d() == 5 || (bVar = this.f21194a) == null) {
            return;
        }
        bVar.f();
    }
}
