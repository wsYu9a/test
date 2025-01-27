package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: classes2.dex */
public class de {

    /* renamed from: b */
    private static volatile de f11021b;

    /* renamed from: a */
    private Context f11022a;

    /* renamed from: com.kuaishou.weapon.p0.de$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f11023a;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(de.this.f11022a, "re_po_rt").b(df.B, 0) == 1) {
                    long a10 = df.a(de.this.f11022a).a(df.bn);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a10 >= r1.b(df.E, 2) * 3600000 || i10 == 106) {
                        try {
                            String a11 = new co(de.this.f11022a).a(ck.f10912h);
                            int intValue = Integer.valueOf(ck.f10912h).intValue();
                            if (a11 != null && a11.length() > 10) {
                                new bc(de.this.f11022a, a11, intValue).a("1000");
                            }
                        } catch (Throwable unused) {
                        }
                        df.a(de.this.f11022a).a(df.bn, currentTimeMillis);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private de(Context context) {
        this.f11022a = context;
    }

    public static de a(Context context) {
        if (f11021b == null) {
            synchronized (de.class) {
                try {
                    if (f11021b == null) {
                        f11021b = new de(context);
                    }
                } finally {
                }
            }
        }
        return f11021b;
    }

    public void a(int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.de.1

            /* renamed from: a */
            final /* synthetic */ int f11023a;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(de.this.f11022a, "re_po_rt").b(df.B, 0) == 1) {
                        long a10 = df.a(de.this.f11022a).a(df.bn);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a10 >= r1.b(df.E, 2) * 3600000 || i10 == 106) {
                            try {
                                String a11 = new co(de.this.f11022a).a(ck.f10912h);
                                int intValue = Integer.valueOf(ck.f10912h).intValue();
                                if (a11 != null && a11.length() > 10) {
                                    new bc(de.this.f11022a, a11, intValue).a("1000");
                                }
                            } catch (Throwable unused) {
                            }
                            df.a(de.this.f11022a).a(df.bn, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
