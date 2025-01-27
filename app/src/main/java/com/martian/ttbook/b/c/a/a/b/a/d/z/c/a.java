package com.martian.ttbook.b.c.a.a.b.a.d.z.c;

import b.d.e.c.a.h.c;
import com.martian.ttbook.b.b.b.a;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.j;
import com.martian.ttbook.b.c.a.a.d.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends l implements b.d.e.c.a.h.a {
    public a(d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // b.d.e.c.a.h.a, b.d.e.c.a.g.b
    public void b(b.d.e.c.a.f.e eVar) {
        D(new i(eVar.a(), eVar.b()));
    }

    @Override // b.d.e.c.a.h.a
    public void onAdLoaded(List<c> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next(), this.f15662c, this.f15663d, this.f15661b));
            }
        }
        this.f15663d.f15703e = arrayList.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(arrayList.size())).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.e) {
            ((com.martian.ttbook.b.c.a.a.c.l.e) eVar).onAdLoaded(arrayList);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        try {
            com.martian.ttbook.b.c.a.a.b.a.d.z.b.a().b(j.q);
            new a.b(this.f15662c.f15670d).e(this.f15662c.m).g(this.f15663d.f15701c.l(e.c.Q)).j().j(this);
            new k(this.f15662c, this.f15663d).a(3).h();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
