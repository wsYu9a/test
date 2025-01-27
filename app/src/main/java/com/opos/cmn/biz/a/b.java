package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static volatile String f16616a = "";

    /* renamed from: com.opos.cmn.biz.a.b$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16617a;

        AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a(applicationContext, b.f16616a);
        }
    }

    public static String a(Context context) {
        String str;
        if (!a(f16616a)) {
            if (context != null) {
                f16616a = f.a(context);
            }
            if (!a(f16616a)) {
                f16616a = com.opos.cmn.an.b.c.d();
                com.opos.cmn.an.f.a.b("BrandTool", "get brand by os:" + f16616a);
                if (!a(f16616a)) {
                    f16616a = a.f16615c;
                    str = "set default brand";
                }
            }
            return f16616a;
        }
        str = "get Brand result= " + f16616a;
        com.opos.cmn.an.f.a.b("BrandTool", str);
        return f16616a;
    }

    public static void a(Context context, String str) {
        synchronized (b.class) {
            if (com.opos.cmn.an.c.a.a(str)) {
                com.opos.cmn.an.f.a.b("BrandTool", "init, set Brand = null");
            } else {
                try {
                    String upperCase = str.toUpperCase();
                    if (a(upperCase) && !upperCase.contentEquals(f16616a)) {
                        f16616a = upperCase;
                        if (context != null) {
                            new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.b.1

                                /* renamed from: a */
                                final /* synthetic */ Context f16617a;

                                AnonymousClass1(Context context2) {
                                    applicationContext = context2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    f.a(applicationContext, b.f16616a);
                                }
                            }).start();
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("BrandTool", "setBrand", e2);
                }
                com.opos.cmn.an.f.a.b("BrandTool", "init, set Brand = " + str);
            }
        }
    }

    private static boolean a(String str) {
        Boolean bool = Boolean.TRUE;
        if (com.opos.cmn.an.c.a.a(str) || (!a.f16615c.equalsIgnoreCase(str) && !a.f16613a.equalsIgnoreCase(str) && !a.f16614b.equalsIgnoreCase(str))) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }
}
