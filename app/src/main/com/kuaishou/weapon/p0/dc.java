package com.kuaishou.weapon.p0;

import android.content.Context;

/* loaded from: classes2.dex */
public class dc {

    /* renamed from: b */
    private static volatile dc f11013b;

    /* renamed from: a */
    private Context f11014a;

    /* renamed from: com.kuaishou.weapon.p0.dc$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f11015a;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h a10 = h.a(dc.this.f11014a, "re_po_rt");
                if (a10.b(df.ap, 1) == 1) {
                    long a11 = df.a(dc.this.f11014a).a(df.bl);
                    long currentTimeMillis = System.currentTimeMillis();
                    int b10 = a10.b(df.as, 0);
                    long j10 = currentTimeMillis - a11;
                    if (j10 >= a10.b(df.ar, 6) * 3600000 || (i10 == 100 && b10 == 1 && j10 >= 14400000)) {
                        cg.a(dc.this.f11014a, new bw(dc.this.f11014a, i10, false).a(ck.f10909e), ck.f10909e, true);
                        df.a(dc.this.f11014a).a(df.bl, currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private dc(Context context) {
        this.f11014a = context;
    }

    public static dc a(Context context) {
        if (f11013b == null) {
            synchronized (dc.class) {
                try {
                    if (f11013b == null) {
                        f11013b = new dc(context);
                    }
                } finally {
                }
            }
        }
        return f11013b;
    }

    public void a(int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1

            /* renamed from: a */
            final /* synthetic */ int f11015a;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    h a10 = h.a(dc.this.f11014a, "re_po_rt");
                    if (a10.b(df.ap, 1) == 1) {
                        long a11 = df.a(dc.this.f11014a).a(df.bl);
                        long currentTimeMillis = System.currentTimeMillis();
                        int b10 = a10.b(df.as, 0);
                        long j10 = currentTimeMillis - a11;
                        if (j10 >= a10.b(df.ar, 6) * 3600000 || (i10 == 100 && b10 == 1 && j10 >= 14400000)) {
                            cg.a(dc.this.f11014a, new bw(dc.this.f11014a, i10, false).a(ck.f10909e), ck.f10909e, true);
                            df.a(dc.this.f11014a).a(df.bl, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
