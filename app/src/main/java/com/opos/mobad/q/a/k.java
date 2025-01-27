package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.q.a.d;

/* loaded from: classes4.dex */
public class k extends c {
    private boolean p;

    /* renamed from: com.opos.mobad.q.a.k$1 */
    class AnonymousClass1 implements d.a {

        /* renamed from: a */
        final /* synthetic */ AdItemData f23362a;

        /* renamed from: b */
        final /* synthetic */ MaterialData f23363b;

        /* renamed from: c */
        final /* synthetic */ int f23364c;

        /* renamed from: d */
        final /* synthetic */ g f23365d;

        AnonymousClass1(AdItemData adItemData, MaterialData materialData, int i2, g gVar) {
            adItemData = adItemData;
            materialData = materialData;
            i2 = i2;
            gVar = gVar;
        }

        @Override // com.opos.mobad.q.a.d.a
        public void a() {
            com.opos.mobad.q.a.e.b.a(false);
            k.this.a(adItemData, materialData, i2, gVar);
        }

        @Override // com.opos.mobad.q.a.d.a
        public void b() {
            k.this.f();
        }
    }

    public k(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4, com.opos.mobad.n.a aVar5) {
        super(activity, str, aVar, aVar2, dVar, aVar3, aVar4, aVar5);
        this.p = false;
    }

    private void a(long j2) {
        if (this.p) {
            return;
        }
        this.p = true;
        try {
            String d2 = this.n.d(j2);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            Toast.makeText(((c) this).f23191b, d2, 1).show();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("RWCommonPresenter", "", (Throwable) e2);
        }
    }

    private void h() {
        MaterialData materialData;
        if (this.f23193d == null || (materialData = this.f23194e) == null) {
            return;
        }
        int T = materialData.T();
        if (T == 0) {
            g gVar = this.f23197h;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        if (T == 1) {
            i();
        } else if (T != 2) {
            l(null, null);
        }
    }

    private void i() {
        com.opos.mobad.n.a aVar = this.k;
        if (aVar == null) {
            return;
        }
        aVar.c().setVisibility(0);
    }

    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(long j2, long j3) {
        super.a(j2, j3);
        h();
    }

    @Override // com.opos.mobad.q.a.c
    public void a(Configuration configuration) {
        com.opos.mobad.n.a aVar = this.f23192c;
        if (aVar instanceof com.opos.mobad.q.a.f.c) {
            ((com.opos.mobad.q.a.f.c) aVar).t();
        }
    }

    @Override // com.opos.mobad.q.a.m
    public void a(com.opos.mobad.ad.h hVar, Object... objArr) {
        if (this.n.b()) {
            this.f23195f.c(0);
            this.f23192c.a(this.f23195f);
        }
        super.a(hVar, objArr);
    }

    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m
    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return super.a(view, iArr, aVar, false);
    }

    public void b(AdItemData adItemData, MaterialData materialData, int i2, g gVar) {
        this.f23197h = gVar;
        this.p = false;
        if (adItemData.r() == 2 && !com.opos.cmn.an.h.c.a.e(((c) this).f23191b) && com.opos.mobad.q.a.e.b.a(adItemData)) {
            this.f23196g.b(new d.a() { // from class: com.opos.mobad.q.a.k.1

                /* renamed from: a */
                final /* synthetic */ AdItemData f23362a;

                /* renamed from: b */
                final /* synthetic */ MaterialData f23363b;

                /* renamed from: c */
                final /* synthetic */ int f23364c;

                /* renamed from: d */
                final /* synthetic */ g f23365d;

                AnonymousClass1(AdItemData adItemData2, MaterialData materialData2, int i22, g gVar2) {
                    adItemData = adItemData2;
                    materialData = materialData2;
                    i2 = i22;
                    gVar = gVar2;
                }

                @Override // com.opos.mobad.q.a.d.a
                public void a() {
                    com.opos.mobad.q.a.e.b.a(false);
                    k.this.a(adItemData, materialData, i2, gVar);
                }

                @Override // com.opos.mobad.q.a.d.a
                public void b() {
                    k.this.f();
                }
            });
        } else {
            a(adItemData2, materialData2, i22, gVar2);
        }
    }

    @Override // com.opos.mobad.q.a.c, com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(long j2, long j3) {
        super.d(j2, j3);
        a(j3);
    }
}
