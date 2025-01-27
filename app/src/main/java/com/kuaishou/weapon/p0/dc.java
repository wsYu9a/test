package com.kuaishou.weapon.p0;

import android.content.Context;
import com.tencent.connect.common.Constants;

/* loaded from: classes.dex */
public class dc {

    /* renamed from: b */
    private static volatile dc f9275b;

    /* renamed from: a */
    private Context f9276a;

    /* renamed from: com.kuaishou.weapon.p0.dc$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(dc.this.f9276a, "re_po_rt").b(de.z, 0) == 1) {
                    long a2 = de.a(dc.this.f9276a).a(de.bf);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a2 >= r1.b(de.C, 2) * 3600000) {
                        try {
                            String a3 = new cn(dc.this.f9276a).a(cj.f9195h);
                            int intValue = Integer.valueOf(cj.f9195h).intValue();
                            if (a3 != null && a3.length() > 10) {
                                new bb(dc.this.f9276a, a3, intValue).a(Constants.DEFAULT_UIN);
                            }
                        } catch (Throwable unused) {
                        }
                        de.a(dc.this.f9276a).a(de.bf, currentTimeMillis);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private dc(Context context) {
        this.f9276a = context;
    }

    public static dc a(Context context) {
        if (f9275b == null) {
            synchronized (dc.class) {
                if (f9275b == null) {
                    f9275b = new dc(context);
                }
            }
        }
        return f9275b;
    }

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dc.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dc.this.f9276a, "re_po_rt").b(de.z, 0) == 1) {
                        long a2 = de.a(dc.this.f9276a).a(de.bf);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a2 >= r1.b(de.C, 2) * 3600000) {
                            try {
                                String a3 = new cn(dc.this.f9276a).a(cj.f9195h);
                                int intValue = Integer.valueOf(cj.f9195h).intValue();
                                if (a3 != null && a3.length() > 10) {
                                    new bb(dc.this.f9276a, a3, intValue).a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            de.a(dc.this.f9276a).a(de.bf, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
