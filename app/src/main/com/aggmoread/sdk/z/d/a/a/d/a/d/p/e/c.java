package com.aggmoread.sdk.z.d.a.a.d.a.d.p.e;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.h.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends k implements com.aggmoread.sdk.z.b.l.a {
    public c(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.b.l.a, com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        try {
            com.aggmoread.sdk.z.d.a.a.d.a.d.p.c.a().a(j.f6027q);
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("nv_")) {
                c10 = c10.replace("nv_", "").trim();
            }
            new c.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(c10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(this.f5843h)).d().a(this);
            new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.a
    public void onAdLoaded(List<com.aggmoread.sdk.z.b.l.c> list) {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        for (com.aggmoread.sdk.z.b.l.c cVar : list) {
            if (q() && (cVar instanceof com.aggmoread.sdk.z.b.l.d)) {
                i10 = ((com.aggmoread.sdk.z.b.l.d) cVar).e();
                if (com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(this.f5843h, i10)) {
                }
            }
            arrayList.add(new d(cVar, this.f5842g, this.f5843h, this.f5841f));
        }
        if (q() && arrayList.size() == 0) {
            a(i10, 0);
        } else {
            e(arrayList);
        }
    }
}
