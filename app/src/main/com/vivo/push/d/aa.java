package com.vivo.push.d;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class aa extends z {
    public aa(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) oVar;
        ArrayList<String> d10 = tVar.d();
        List<String> e10 = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h10 = tVar.h();
        String g10 = tVar.g();
        if (d10 != null) {
            for (String str : d10) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e10 != null) {
            for (String str2 : e10) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                com.vivo.push.e.a().a(arrayList);
            }
            com.vivo.push.e.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h10);
            com.vivo.push.m.b(new ab(this, h10, arrayList, arrayList3, g10));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.e.a().b((String) arrayList2.get(0));
            }
            com.vivo.push.e.a().a(tVar.g(), h10);
            com.vivo.push.m.b(new ac(this, h10, arrayList2, arrayList4, g10));
        }
    }
}
