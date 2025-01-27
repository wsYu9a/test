package com.aggmoread.sdk.z.d.a.a.d.a.d.t.c;

import com.aggmoread.sdk.z.b.l.c;
import com.aggmoread.sdk.z.c.b.a;
import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a extends k implements com.aggmoread.sdk.z.b.l.a {
    public a(d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.b.l.a, com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        try {
            com.aggmoread.sdk.z.d.a.a.d.a.d.t.b.a().a(j.f6027q);
            new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(this.f5843h.f5907c.c(e.c.T)).d().a(this);
            new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.a
    public void onAdLoaded(List<c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next(), this.f5842g, this.f5843h, this.f5841f));
            }
        }
        e(arrayList);
    }
}
