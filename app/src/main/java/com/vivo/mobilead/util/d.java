package com.vivo.mobilead.util;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class d {
    public static boolean a(com.vivo.ad.model.b bVar) {
        return (bVar == null || bVar.z() == null || bVar.z().a() == 0) ? false : true;
    }

    public static String b(com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.y() == null) {
            return "";
        }
        com.vivo.ad.model.q y = bVar.y();
        return bVar.U() ? y.e() : y.a();
    }

    public static String c(com.vivo.ad.model.b bVar) {
        return f.b(bVar);
    }

    public static String d(com.vivo.ad.model.b bVar) {
        String str = "";
        if (bVar == null) {
            return "";
        }
        if (bVar.Q() != null) {
            str = bVar.Q().e();
        } else if (bVar.f() != null) {
            str = bVar.f().e();
        }
        if (TextUtils.isEmpty(str) || str.length() <= 10) {
            return str;
        }
        return str.substring(0, 10) + "...";
    }

    public static int e(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return -1;
        }
        com.vivo.ad.model.a0 Q = bVar.Q();
        if (Q != null && !TextUtils.isEmpty(Q.g())) {
            return 4;
        }
        if (bVar.f() == null || bVar.f().b() == null || bVar.f().b().size() <= 0) {
            return -1;
        }
        if (bVar.f().b().size() > 2) {
            return 1;
        }
        if (TextUtils.isEmpty(bVar.f().a()) || !bVar.f().a().contains("*")) {
            return -1;
        }
        return d0.a(bVar.f().a().split("\\*")[0]) > 240 ? 2 : 3;
    }

    public static String f(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return "";
        }
        com.vivo.ad.model.a0 Q = bVar.Q();
        return (Q == null || TextUtils.isEmpty(Q.g())) ? (bVar.f() == null || bVar.f().b() == null || bVar.f().b().isEmpty()) ? "" : bVar.f().b().get(0) : Q.d();
    }

    public static String g(com.vivo.ad.model.b bVar) {
        return bVar != null ? bVar.Q() != null ? bVar.Q().a() : bVar.f() != null ? bVar.f().d() : "" : "";
    }

    public static String h(com.vivo.ad.model.b bVar) {
        if (bVar != null) {
            if (bVar.Q() != null) {
                return bVar.Q().e();
            }
            if (bVar.f() != null) {
                return bVar.f().e();
            }
        }
        return "";
    }

    public static boolean i(com.vivo.ad.model.b bVar) {
        int F;
        return (bVar == null || (F = bVar.F()) == 2 || F == 3 || F == 4) ? false : true;
    }
}
