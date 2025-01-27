package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: classes.dex */
public class da {

    /* renamed from: b */
    private static volatile da f9267b;

    /* renamed from: a */
    private Context f9268a;

    /* renamed from: com.kuaishou.weapon.p0.da$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f9269a;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h a2 = h.a(da.this.f9268a, "re_po_rt");
                if (a2.b(de.ah, 1) == 1) {
                    long a3 = de.a(da.this.f9268a).a(de.bd);
                    long currentTimeMillis = System.currentTimeMillis();
                    int b2 = a2.b(de.ak, 0);
                    long j2 = currentTimeMillis - a3;
                    if (j2 >= a2.b(de.aj, 6) * 3600000 || (i2 == 100 && b2 == 1 && j2 >= 14400000)) {
                        cf.a(da.this.f9268a, new bv(da.this.f9268a, i2, false).a(cj.f9192e), cj.f9192e, true);
                        de.a(da.this.f9268a).a(de.bd, currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private da(Context context) {
        this.f9268a = context;
    }

    public static da a(Context context) {
        if (f9267b == null) {
            synchronized (da.class) {
                if (f9267b == null) {
                    f9267b = new da(context);
                }
            }
        }
        return f9267b;
    }

    public void a(int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1

            /* renamed from: a */
            final /* synthetic */ int f9269a;

            AnonymousClass1(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a2 = h.a(da.this.f9268a, "re_po_rt");
                    if (a2.b(de.ah, 1) == 1) {
                        long a3 = de.a(da.this.f9268a).a(de.bd);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b2 = a2.b(de.ak, 0);
                        long j2 = currentTimeMillis - a3;
                        if (j2 >= a2.b(de.aj, 6) * 3600000 || (i2 == 100 && b2 == 1 && j2 >= 14400000)) {
                            cf.a(da.this.f9268a, new bv(da.this.f9268a, i2, false).a(cj.f9192e), cj.f9192e, true);
                            de.a(da.this.f9268a).a(de.bd, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
