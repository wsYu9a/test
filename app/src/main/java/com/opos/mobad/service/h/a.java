package com.opos.mobad.service.h;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.e.c;
import com.opos.cmn.i.f;
import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ah;
import com.opos.mobad.b.a.g;
import com.opos.mobad.b.a.k;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.b.a.p;
import com.opos.mobad.b.a.u;
import com.opos.mobad.b.a.w;
import com.opos.mobad.service.f.a;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static ab f23680a;

    /* renamed from: b */
    private static n f23681b;

    public static final m a(Context context) {
        l b2 = new l.a().a(com.opos.mobad.service.e.a.a().m()).b(com.opos.mobad.service.e.a.a().e()).c(com.opos.cmn.f.a.a(context)).g(com.opos.mobad.service.e.a.a().n()).h(com.opos.mobad.service.e.a.a().g()).i(com.opos.mobad.service.e.a.a().h()).j(com.opos.mobad.service.e.a.a().i()).k(f.a(context)).b();
        o b3 = new o.a().a(Float.valueOf(com.opos.cmn.an.h.f.a.f(context))).a(Integer.valueOf(com.opos.cmn.an.h.f.a.c(context))).b(Integer.valueOf(com.opos.cmn.an.h.f.a.b(context))).b();
        double[] c2 = c.a().c();
        return new m.a().a(b2).a(f()).a(b3).a(new p.a().a(new k.a().b(String.valueOf(c2[0])).a(String.valueOf(c2[1])).a(Long.valueOf(System.currentTimeMillis())).b()).a(c(context)).a(a(com.opos.mobad.service.f.a.a().t())).a(Integer.valueOf(com.opos.cmn.an.h.f.a.i(context))).b()).a(com.opos.cmn.an.b.c.a()).b(c()).c(com.opos.cmn.an.b.a.a(context)).d(com.opos.mobad.service.e.a.a().b()).e(com.opos.mobad.service.e.a.a().c()).a(Boolean.valueOf(com.opos.cmn.an.f.a.b(context))).b();
    }

    private static final p.c a(String str) {
        p.c cVar = p.c.UNKNOWN_OPERATOR;
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        str.hashCode();
        switch (str) {
            case "telecom":
                return p.c.CHINA_TELECOM;
            case "mobile":
                return p.c.CHINA_MOBILE;
            case "unicom":
                return p.c.CHINA_UNICOM;
            default:
                return cVar;
        }
    }

    public static final u a() {
        return new u.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().c())).a(com.opos.mobad.service.f.a.a().d()).b(com.opos.mobad.service.f.a.a().b()).a(Long.valueOf(com.opos.mobad.service.f.a.a().s())).b();
    }

    public static final ah b() {
        return new ah.a().a(Boolean.valueOf(com.opos.mobad.service.f.a.a().e())).a(com.opos.mobad.service.f.a.a().f()).b(com.opos.mobad.service.f.a.a().g()).b();
    }

    public static final w b(Context context) {
        a.d n = com.opos.mobad.service.f.a.a().n();
        return new w.a().a(n.f23644b).a(Integer.valueOf(n.f23643a)).b();
    }

    private static final p.b c(Context context) {
        p.b bVar;
        bVar = p.b.CONNECTION_UNKNOWN;
        String h2 = com.opos.cmn.an.h.c.a.h(context);
        h2.hashCode();
        switch (h2) {
            case "2g":
                return p.b.CELL_2G;
            case "3g":
                return p.b.CELL_3G;
            case "4g":
                return p.b.CELL_4G;
            case "wifi":
                return p.b.WIFI;
            default:
                return bVar;
        }
    }

    public static final String c() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e2);
            return "";
        }
    }

    public static final ab d() {
        if (f23680a == null) {
            f23680a = new ab.a().a(Integer.valueOf(com.opos.mobad.service.f.a.a().o())).a(com.opos.mobad.service.f.a.a().p()).b(Integer.valueOf(com.opos.mobad.service.f.a.a().q())).c(Integer.valueOf(com.opos.cmn.f.a.a())).b();
        }
        return f23680a;
    }

    public static final g e() {
        return new g.a().a(com.opos.mobad.service.f.a.a().l()).b(com.opos.mobad.service.f.a.a().k()).c(com.opos.mobad.service.f.a.a().m()).b();
    }

    private static final n f() {
        if (f23681b == null) {
            f23681b = new n.a().a(com.opos.mobad.service.f.a.a().h()).c(com.opos.mobad.service.f.a.a().j()).b(com.opos.mobad.service.f.a.a().i()).b();
        }
        return f23681b;
    }
}
