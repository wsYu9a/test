package com.vivo.mobilead.e.a.h;

import android.content.Context;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    private static com.vivo.mobilead.e.a.c f28786a;

    public static com.vivo.mobilead.e.a.c a(Context context) {
        com.vivo.mobilead.e.a.c cVar = f28786a;
        if (cVar != null) {
            return cVar;
        }
        if (context == null || context.getApplicationContext() == null) {
            return f28786a;
        }
        com.vivo.mobilead.e.a.c b2 = b(context.getApplicationContext());
        f28786a = b2;
        if (b2 == null || !b2.a()) {
            return null;
        }
        com.vivo.mobilead.e.a.e.a("Manufacturer interface has been found: " + f28786a.getClass().getName());
        return f28786a;
    }

    private static com.vivo.mobilead.e.a.c b(Context context) {
        if (com.vivo.mobilead.e.a.f.e() || com.vivo.mobilead.e.a.f.h()) {
            return new c(context);
        }
        if (com.vivo.mobilead.e.a.f.f()) {
            return new d(context);
        }
        if (com.vivo.mobilead.e.a.f.i()) {
            return new e(context);
        }
        if (com.vivo.mobilead.e.a.f.n() || com.vivo.mobilead.e.a.f.g() || com.vivo.mobilead.e.a.f.b()) {
            return new k(context);
        }
        if (com.vivo.mobilead.e.a.f.l()) {
            return new i(context);
        }
        if (com.vivo.mobilead.e.a.f.m()) {
            return new j(context);
        }
        if (com.vivo.mobilead.e.a.f.a()) {
            return new a(context);
        }
        if (com.vivo.mobilead.e.a.f.d() || com.vivo.mobilead.e.a.f.c()) {
            return new b(context);
        }
        if (com.vivo.mobilead.e.a.f.k() || com.vivo.mobilead.e.a.f.j()) {
            return new h(context);
        }
        return null;
    }
}
