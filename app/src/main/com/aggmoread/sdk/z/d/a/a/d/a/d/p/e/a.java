package com.aggmoread.sdk.z.d.a.a.d.a.d.p.e;

import android.text.TextUtils;
import android.view.View;
import com.aggmoread.sdk.z.b.h.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.h;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class a extends h implements com.aggmoread.sdk.z.b.k.a {

    /* renamed from: n */
    private final HashMap<com.aggmoread.sdk.z.b.k.c, b> f5425n;

    public a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f5425n = new HashMap<>();
    }

    @Override // com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void b(com.aggmoread.sdk.z.b.k.c cVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("APIEXPRESSHTAG", "onADExposure");
        b bVar = this.f5425n.get(cVar);
        if (bVar != null) {
            System.currentTimeMillis();
            com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = bVar.a();
            l.a(a10, bVar.f5281n);
            l.a(this.f5842g.f5856b, bVar.f5281n, com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW, a10, new View[0], new WeakReference(a10), null);
            l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
            byte[] b10 = this.f5842g.f5872r.b();
            if (b10 != null) {
                l.a(this.f5842g.f5856b, b10);
            }
            l.a((Object) bVar.f5281n, true, true);
            l.a(bVar.f5281n, this.f5843h);
            bVar.k();
        }
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void c(com.aggmoread.sdk.z.b.k.c cVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("APIEXPRESSHTAG", "onADClicked");
        b bVar = this.f5425n.get(cVar);
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void d(com.aggmoread.sdk.z.b.k.c cVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("APIEXPRESSHTAG", "onADClosed");
        b bVar = this.f5425n.get(cVar);
        if (bVar != null) {
            bVar.j();
        }
        this.f5425n.remove(bVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        try {
            com.aggmoread.sdk.z.d.a.a.d.a.d.p.c.a().a(j.f6027q);
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("ex_")) {
                c10 = c10.replace("ex_", "").trim();
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("APIEXPRESSHTAG", "slot id " + c10);
            new c.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(c10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(this.f5843h)).d().a(this);
            new k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void onAdLoaded(List<com.aggmoread.sdk.z.b.k.c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (com.aggmoread.sdk.z.b.k.c cVar : list) {
                if (q() && (cVar instanceof com.aggmoread.sdk.z.b.k.b)) {
                    i10 = ((com.aggmoread.sdk.z.b.k.b) cVar).b();
                    if (com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(this.f5843h, i10)) {
                    }
                }
                b bVar = new b(cVar, this.f5842g, this.f5843h, this.f5841f);
                arrayList.add(bVar);
                this.f5425n.put(cVar, bVar);
            }
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void a(com.aggmoread.sdk.z.b.k.c cVar) {
        b bVar = this.f5425n.get(cVar);
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.aggmoread.sdk.z.b.k.a
    public void a(com.aggmoread.sdk.z.b.k.c cVar, com.aggmoread.sdk.z.b.g.e eVar) {
        b bVar = this.f5425n.get(cVar);
        this.f5425n.remove(bVar);
        if (bVar != null) {
            bVar.n();
        }
    }
}
