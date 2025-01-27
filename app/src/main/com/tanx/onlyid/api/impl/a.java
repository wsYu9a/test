package com.tanx.onlyid.api.impl;

import android.app.Application;
import android.content.Context;
import ug.d;
import ug.e;
import ug.f;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static d f22033a;

    public static d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        d dVar = f22033a;
        if (dVar != null) {
            return dVar;
        }
        d b10 = b(context);
        f22033a = b10;
        if (b10 == null || !b10.b()) {
            d c10 = c(context);
            f22033a = c10;
            return c10;
        }
        e.b("Manufacturer interface has been found: " + f22033a.getClass().getName());
        return f22033a;
    }

    public static d b(Context context) {
        if (f.i() || f.l()) {
            return new LenovoImpl(context);
        }
        if (f.j()) {
            return new MeizuImpl(context);
        }
        if (f.m()) {
            return new NubiaImpl(context);
        }
        if (f.r() || f.k() || f.b()) {
            return new XiaomiImpl(context);
        }
        if (f.p()) {
            return new SamsungImpl(context);
        }
        if (f.q()) {
            return new VivoImpl(context);
        }
        if (f.a()) {
            return new AsusImpl(context);
        }
        if (f.g()) {
            HonorImpl honorImpl = new HonorImpl(context);
            if (honorImpl.b()) {
                return honorImpl;
            }
        }
        if (f.h() || f.e()) {
            return new HuaweiImpl(context);
        }
        if (f.o() || f.n()) {
            return new OppoImpl(context);
        }
        if (f.c(context)) {
            return new CoolpadImpl(context);
        }
        if (f.d()) {
            return new CooseaImpl(context);
        }
        if (f.f()) {
            return new FreemeImpl(context);
        }
        return null;
    }

    public static d c(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (msaImpl.b()) {
            e.b("Mobile Security Alliance has been found: " + MsaImpl.class.getName());
            return msaImpl;
        }
        GmsImpl gmsImpl = new GmsImpl(context);
        if (gmsImpl.b()) {
            e.b("Google Play Service has been found: " + GmsImpl.class.getName());
            return gmsImpl;
        }
        vg.a aVar = new vg.a();
        e.b("OAID/AAID was not supported: " + vg.a.class.getName());
        return aVar;
    }
}
