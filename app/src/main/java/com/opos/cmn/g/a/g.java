package com.opos.cmn.g.a;

import android.content.Context;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static volatile boolean f17399a = false;

    /* renamed from: b */
    private static volatile com.opos.cmn.g.a.a f17400b;

    private static class a extends com.opos.cmn.g.a.a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.cmn.g.a.a
        public String a(Context context) {
            return b.h.b.a.a.e(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean a() {
            return b.h.b.a.a.b();
        }

        @Override // com.opos.cmn.g.a.a
        public String b(Context context) {
            return b.h.b.a.a.g(context);
        }

        @Override // com.opos.cmn.g.a.a
        public String c(Context context) {
            return b.h.b.a.a.h(context);
        }

        @Override // com.opos.cmn.g.a.a
        public boolean d(Context context) {
            return b.h.b.a.a.f(context);
        }

        @Override // com.opos.cmn.g.a.a
        public void e(Context context) {
            b.h.b.a.a.c(context);
        }
    }

    private static com.opos.cmn.g.a.a a() {
        com.opos.cmn.g.a.a aVar;
        synchronized (g.class) {
            if (f17400b == null) {
                f17400b = new a();
            }
            aVar = f17400b;
        }
        return aVar;
    }

    public static String a(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            String a2 = a().a() ? a().a(context) : "";
            try {
                com.opos.cmn.an.f.a.b("IdentifierManager", "getGUID costTime=" + (System.currentTimeMillis() - currentTimeMillis) + " result=" + a2);
                return a2;
            } catch (Exception e2) {
                str = a2;
                e = e2;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    public static String b(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            String b2 = a().a() ? a().b(context) : "";
            try {
                com.opos.cmn.an.f.a.b("IdentifierManager", "getOUID costTime=" + (System.currentTimeMillis() - currentTimeMillis) + " result=" + b2);
                return b2;
            } catch (Exception e2) {
                str = b2;
                e = e2;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    public static String c(Context context) {
        String str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f(context);
            String c2 = a().a() ? a().c(context) : "";
            try {
                com.opos.cmn.an.f.a.b("IdentifierManager", "getDUID costTime=" + (System.currentTimeMillis() - currentTimeMillis) + " result=" + c2);
                return c2;
            } catch (Exception e2) {
                str = c2;
                e = e2;
                com.opos.cmn.an.f.a.c("IdentifierManager", "", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    public static boolean d(Context context) {
        boolean z;
        try {
            f(context);
            z = a().a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("IdentifierManager", "isSupportedOpenId " + z);
        return z;
    }

    public static boolean e(Context context) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f(context);
            z = a().d(context);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("IdentifierManager", "", e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("IdentifierManager", "getOUIDStatus costTime=" + (System.currentTimeMillis() - currentTimeMillis) + " result=" + z);
        return z;
    }

    private static void f(Context context) {
        if (f17399a) {
            return;
        }
        a().e(context);
        f17399a = true;
    }
}
