package com.vivo.mobilead.util;

import com.vivo.mobilead.model.a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class u0 {
    public static void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        a(bVar, enumC0603a, i2, i3, i4, i5, i6, i7, i8, i9, null, str);
    }

    public static void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, com.vivo.ad.model.w wVar, String str) {
        if (bVar == null || bVar.h() == null || bVar.h().size() <= 0) {
            return;
        }
        int a2 = a(bVar, enumC0603a);
        ArrayList arrayList = new ArrayList();
        for (com.vivo.ad.model.h hVar : bVar.h()) {
            if (hVar.b() == enumC0603a.a()) {
                arrayList.add(hVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.vivo.ad.model.h hVar2 = (com.vivo.ad.model.h) it.next();
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.i.g.a(hVar2.c(), System.currentTimeMillis(), a2, i2, i3, i4, i5, i6, i7, i8, i9, wVar), "vivo");
            cVar.c(hVar2.a());
            cVar.b(1);
            cVar.a(enumC0603a);
            cVar.e(str);
            cVar.a(bVar.n());
            com.vivo.mobilead.b.b.c().b(cVar);
            com.vivo.mobilead.manager.c.d().a(cVar);
            it = it;
            a2 = a2;
        }
    }

    private static int a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a) {
        com.vivo.ad.model.q y;
        if (a.EnumC0603a.CLICK == enumC0603a) {
            if (bVar.T() && (y = bVar.y()) != null) {
                if (!j.b(com.vivo.mobilead.manager.f.j().c(), y.a())) {
                    return 1;
                }
                com.vivo.ad.model.r z = bVar.z();
                return (z == null || 1 != z.a()) ? 2 : 3;
            }
            return 0;
        }
        if (bVar.U()) {
            com.vivo.ad.model.q y2 = bVar.y();
            if (y2 != null) {
                return j.b(com.vivo.mobilead.manager.f.j().c(), y2.e()) ? 2 : 4;
            }
            return 0;
        }
    }

    public static void a(com.vivo.ad.model.b bVar, a.EnumC0603a enumC0603a, String str) {
        a(bVar, enumC0603a, -999, -999, -999, -999, -999, -999, -999, -999, str);
    }
}
