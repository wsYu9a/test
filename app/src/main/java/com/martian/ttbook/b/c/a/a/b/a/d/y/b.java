package com.martian.ttbook.b.c.a.a.b.a.d.y;

import android.text.TextUtils;
import com.martian.ttbook.b.c.a.a.b.a.d.y.e.f;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;

/* loaded from: classes4.dex */
public class b extends com.martian.ttbook.b.c.a.a.d.b.b {
    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a b(d dVar, e eVar) {
        return new com.martian.ttbook.b.c.a.a.b.a.d.y.d.a(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a c(d dVar, e eVar) {
        String l = eVar.f15701c.l(e.c.R);
        com.martian.ttbook.b.c.a.a.e.d.g("xxx", "slotType " + l);
        if (!TextUtils.isEmpty(l) && Integer.parseInt(l) == h.INFORMATION_FLOW.a()) {
            String d2 = eVar.f15701c.d(e.c.P, "2");
            com.martian.ttbook.b.c.a.a.e.d.g("xxx", "v = " + d2);
            if ("2".equals(d2)) {
                return new com.martian.ttbook.b.c.a.a.b.a.d.y.e.a(dVar, eVar);
            }
        }
        return super.c(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a d(d dVar, e eVar) {
        return new com.martian.ttbook.b.c.a.a.b.a.d.y.g.a(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a e(d dVar, e eVar) {
        return eVar.f15701c.d(e.c.P, "2").equalsIgnoreCase("2") ? new f(dVar, eVar) : new com.martian.ttbook.b.c.a.a.b.a.d.y.e.c(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a f(d dVar, e eVar) {
        return "2".equals(eVar.f15701c.d(e.c.P, "2")) ? new com.martian.ttbook.b.c.a.a.b.a.d.y.f.c(dVar, eVar) : new com.martian.ttbook.b.c.a.a.b.a.d.y.f.a(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a g(d dVar, e eVar) {
        return new com.martian.ttbook.b.c.a.a.b.a.d.y.g.b(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.b
    public com.martian.ttbook.b.c.a.a.d.b.a h(d dVar, e eVar) {
        return new com.martian.ttbook.b.c.a.a.b.a.d.y.h.b(dVar, eVar);
    }
}
