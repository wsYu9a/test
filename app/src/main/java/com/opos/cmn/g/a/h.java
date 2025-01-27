package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private static final String f17401a = "h";

    /* renamed from: b */
    private static final byte[] f17402b = new byte[0];

    /* renamed from: c */
    private static final byte[] f17403c = new byte[0];

    /* renamed from: d */
    private static volatile long f17404d = 0;

    /* renamed from: e */
    private static volatile String f17405e = "";

    /* renamed from: f */
    private static volatile String f17406f = "";

    /* renamed from: g */
    private static volatile String f17407g = "";

    /* renamed from: h */
    private static volatile boolean f17408h = false;

    /* renamed from: i */
    private static volatile boolean f17409i = false;

    /* renamed from: com.opos.cmn.g.a.h$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17410a;

        AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.f17402b) {
                    com.opos.cmn.an.f.a.b(h.f17401a, "updateOpenId begin!");
                    String b2 = g.b(applicationContext);
                    String c2 = g.c(applicationContext);
                    String a2 = g.a(applicationContext);
                    if (!TextUtils.isEmpty(b2)) {
                        String unused = h.f17405e = b2;
                        i.a(applicationContext, h.f17405e);
                    }
                    if (!TextUtils.isEmpty(c2)) {
                        String unused2 = h.f17406f = c2;
                        i.b(applicationContext, h.f17406f);
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        String unused3 = h.f17407g = a2;
                        i.c(applicationContext, h.f17407g);
                    }
                    com.opos.cmn.an.f.a.b(h.f17401a, "updateOpenId end!");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(h.f17401a, "", e2);
            }
        }
    }

    /* renamed from: com.opos.cmn.g.a.h$2 */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17411a;

        AnonymousClass2(Context context) {
            applicationContext = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (h.f17403c) {
                    com.opos.cmn.an.f.a.b(h.f17401a, "updateOUIDStatus begin!");
                    boolean unused = h.f17408h = g.e(applicationContext);
                    i.a(applicationContext, h.f17408h);
                    long unused2 = h.f17404d = System.currentTimeMillis();
                    com.opos.cmn.an.f.a.b(h.f17401a, "updateOUIDStatus end! OUIDStatus=" + h.f17408h + " sLastUpdateOUIDStatusTime=" + h.f17404d);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(h.f17401a, "", e2);
            }
        }
    }

    public static void a(Context context) {
        synchronized (h.class) {
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                f17409i = true;
                new Thread(new Runnable() { // from class: com.opos.cmn.g.a.h.1

                    /* renamed from: a */
                    final /* synthetic */ Context f17410a;

                    AnonymousClass1(Context applicationContext2) {
                        applicationContext = applicationContext2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (h.f17402b) {
                                com.opos.cmn.an.f.a.b(h.f17401a, "updateOpenId begin!");
                                String b2 = g.b(applicationContext);
                                String c2 = g.c(applicationContext);
                                String a2 = g.a(applicationContext);
                                if (!TextUtils.isEmpty(b2)) {
                                    String unused = h.f17405e = b2;
                                    i.a(applicationContext, h.f17405e);
                                }
                                if (!TextUtils.isEmpty(c2)) {
                                    String unused2 = h.f17406f = c2;
                                    i.b(applicationContext, h.f17406f);
                                }
                                if (!TextUtils.isEmpty(a2)) {
                                    String unused3 = h.f17407g = a2;
                                    i.c(applicationContext, h.f17407g);
                                }
                                com.opos.cmn.an.f.a.b(h.f17401a, "updateOpenId end!");
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.c(h.f17401a, "", e2);
                        }
                    }
                }).start();
            }
        }
    }

    public static void b(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (System.currentTimeMillis() >= f17404d + 5000) {
                new Thread(new Runnable() { // from class: com.opos.cmn.g.a.h.2

                    /* renamed from: a */
                    final /* synthetic */ Context f17411a;

                    AnonymousClass2(Context applicationContext2) {
                        applicationContext = applicationContext2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (h.f17403c) {
                                com.opos.cmn.an.f.a.b(h.f17401a, "updateOUIDStatus begin!");
                                boolean unused = h.f17408h = g.e(applicationContext);
                                i.a(applicationContext, h.f17408h);
                                long unused2 = h.f17404d = System.currentTimeMillis();
                                com.opos.cmn.an.f.a.b(h.f17401a, "updateOUIDStatus end! OUIDStatus=" + h.f17408h + " sLastUpdateOUIDStatusTime=" + h.f17404d);
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.c(h.f17401a, "", e2);
                        }
                    }
                }).start();
            }
        }
    }

    public static String c(Context context) {
        if (context != null && TextUtils.isEmpty(f17405e)) {
            f17405e = i.a(context);
        }
        com.opos.cmn.an.f.a.b(f17401a, "getOUID " + f17405e);
        if (!f17409i) {
            a(context);
        }
        return f17405e;
    }

    public static String d(Context context) {
        if (context != null && TextUtils.isEmpty(f17406f)) {
            f17406f = i.b(context);
        }
        com.opos.cmn.an.f.a.b(f17401a, "getDUID " + f17406f);
        if (!f17409i) {
            a(context);
        }
        return f17406f;
    }

    public static String e(Context context) {
        if (context != null && TextUtils.isEmpty(f17407g)) {
            f17407g = i.c(context);
        }
        com.opos.cmn.an.f.a.b(f17401a, "getGUID " + f17407g);
        if (!f17409i) {
            a(context);
        }
        return f17407g;
    }

    public static boolean f(Context context) {
        if (context != null) {
            f17408h = i.e(context);
        }
        com.opos.cmn.an.f.a.b(f17401a, "getOUIDStatus " + f17408h);
        return f17408h;
    }
}
