package com.opos.mobad.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.d.h;

/* loaded from: classes4.dex */
public class f {

    public static class a {

        /* renamed from: a */
        public final com.opos.mobad.ad.e.e f21176a;

        /* renamed from: b */
        public final a.C0457a f21177b;

        /* renamed from: c */
        public boolean f21178c;

        /* renamed from: d */
        private final com.opos.mobad.ad.e.d f21179d;

        private a(com.opos.mobad.ad.e.d dVar, com.opos.mobad.ad.e.e eVar, a.C0457a c0457a) {
            this.f21178c = false;
            this.f21179d = dVar;
            this.f21176a = eVar;
            this.f21177b = c0457a;
        }

        /* synthetic */ a(com.opos.mobad.ad.e.d dVar, com.opos.mobad.ad.e.e eVar, a.C0457a c0457a, AnonymousClass1 anonymousClass1) {
            this(dVar, eVar, c0457a);
        }

        public long a() {
            a.C0457a c0457a = this.f21177b;
            if (c0457a == null) {
                return 0L;
            }
            return c0457a.f21744b.o();
        }

        public com.opos.mobad.ad.e.d b() {
            if (!c() || d()) {
                return null;
            }
            return this.f21179d;
        }

        public boolean c() {
            a.C0457a c0457a = this.f21177b;
            if (c0457a == null) {
                return true;
            }
            return c0457a.f21745c.a();
        }

        public boolean d() {
            int d2;
            a.C0457a c0457a = this.f21177b;
            return c0457a != null && ((d2 = c0457a.f21745c.d()) == 11 || d2 == 5);
        }

        public String toString() {
            return "SplashVo{bottomArea=" + this.f21179d + ", customSkipView=" + this.f21176a + ", adHelperData=" + this.f21177b + '}';
        }
    }

    public static a a(@NonNull com.opos.mobad.ad.e.f fVar, @NonNull a.C0457a c0457a) {
        if (fVar == null || c0457a == null) {
            return null;
        }
        return new a(fVar.f19493e, fVar.f19495g, c0457a);
    }

    public static h a(Context context, a aVar, com.opos.mobad.n.d dVar, com.opos.mobad.n.c cVar) {
        if (aVar == null) {
            return null;
        }
        MaterialFileData b2 = b(aVar);
        String a2 = b2 != null ? com.opos.cmn.d.d.a(context, b2.a()) : "";
        a.C0457a c0457a = aVar.f21177b;
        h a3 = com.opos.mobad.model.a.a(context, c0457a.f21744b, c0457a.f21745c, false, false, com.opos.mobad.service.f.b().m().a(), com.opos.mobad.service.f.b().m().b());
        a3.a(aVar.a(), aVar.a()).e(a2, b2 != null ? b2.b() : "").a(dVar).a(cVar).d(d(aVar)).f(e(aVar));
        return a3;
    }

    public static boolean a(a aVar) {
        AdData adData;
        com.opos.mobad.ad.e.e eVar;
        return (!c(aVar) || (adData = aVar.f21177b.f21743a) == null || !adData.b() || (eVar = aVar.f21176a) == null || eVar.a() == null) ? false : true;
    }

    public static MaterialFileData b(a aVar) {
        if (c(aVar)) {
            return aVar.f21177b.f21746d;
        }
        return null;
    }

    public static boolean c(a aVar) {
        return (aVar == null || aVar.f21177b == null) ? false : true;
    }

    private static String d(a aVar) {
        return !TextUtils.isEmpty(aVar.f21177b.f21745c.Y()) ? aVar.f21177b.f21745c.Y() : "点击跳转详情页或第三方应用";
    }

    private static int e(a aVar) {
        int E = aVar.f21177b.f21744b.E();
        if (!aVar.c() || aVar.d()) {
            E = 0;
        }
        if (E != 1) {
            return E != 2 ? 0 : 2;
        }
        return 1;
    }
}
