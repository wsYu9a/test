package com.opos.cmn.biz.a;

import android.content.Context;
import com.opos.acs.st.STManager;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static volatile String f16621a = "";

    /* renamed from: com.opos.cmn.biz.a.d$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16622a;

        AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b(applicationContext, d.f16621a);
        }
    }

    public static String a(Context context) {
        String str;
        if (com.opos.cmn.an.c.a.a(f16621a)) {
            if (context != null) {
                f16621a = f.b(context);
            }
            if (com.opos.cmn.an.c.a.a(f16621a)) {
                f16621a = com.opos.cmn.an.b.d.c();
                com.opos.cmn.an.f.a.b("RegionTool", "get region by os:" + f16621a);
                if (com.opos.cmn.an.c.a.a(f16621a)) {
                    f16621a = STManager.REGION_OF_CN;
                    str = "set default region";
                }
            }
            return f16621a;
        }
        str = "get Region result =" + f16621a;
        com.opos.cmn.an.f.a.b("RegionTool", str);
        return f16621a;
    }

    public static void a(Context context, String str) {
        synchronized (d.class) {
            if (com.opos.cmn.an.c.a.a(str)) {
                com.opos.cmn.an.f.a.b("RegionTool", "init, setRegion= null");
            } else {
                try {
                    String upperCase = str.toUpperCase();
                    if (!com.opos.cmn.an.c.a.a(upperCase) && !upperCase.contentEquals(f16621a)) {
                        f16621a = upperCase;
                        if (context != null) {
                            new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.d.1

                                /* renamed from: a */
                                final /* synthetic */ Context f16622a;

                                AnonymousClass1(Context context2) {
                                    applicationContext = context2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    f.b(applicationContext, d.f16621a);
                                }
                            }).start();
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("RegionTool", "setRegion", e2);
                }
                com.opos.cmn.an.f.a.b("RegionTool", "init, setRegion=" + str);
            }
        }
    }
}
