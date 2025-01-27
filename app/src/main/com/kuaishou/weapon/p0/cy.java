package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class cy {

    /* renamed from: b */
    private static volatile cy f10987b;

    /* renamed from: a */
    private Context f10988a;

    /* renamed from: com.kuaishou.weapon.p0.cy$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f10989a;

        /* renamed from: b */
        final /* synthetic */ boolean f10990b;

        /* renamed from: c */
        final /* synthetic */ int f10991c;

        public AnonymousClass1(boolean z10, boolean z11, int i10) {
            e10 = z10;
            e11 = z11;
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            try {
                h a10 = h.a(cy.this.f10988a, "re_po_rt");
                if (a10.b(df.f11061o, 0) == 1) {
                    if (e10 || e11) {
                        long a11 = df.a(cy.this.f10988a).a(df.f11046bi);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b10 = a10.b(df.f11062p, 8) * 3600000;
                        int b11 = a10.b(df.f11063q, 0);
                        if (a11 > 0 && currentTimeMillis - a11 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(hours);
                            if (list.contains(sb2.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a11 >= b10 || (((i10 = i10) == 100 && b11 == 1) || i10 == 106)) {
                            cp.a(cy.this.f10988a, new ci(cy.this.f10988a, i10).a(ck.f10908d), ck.f10908d, true, true);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cy(Context context) {
        this.f10988a = context;
    }

    public static cy a(Context context) {
        if (f10987b == null) {
            synchronized (cy.class) {
                try {
                    if (f10987b == null) {
                        f10987b = new cy(context);
                    }
                } finally {
                }
            }
        }
        return f10987b;
    }

    public void a(int i10) {
        try {
            h a10 = h.a(this.f10988a, "re_po_rt");
            boolean e10 = a10.e("a1_p_s_p_s");
            boolean e11 = a10.e("a1_p_s_p_s_c_b");
            if ((e10 || e11) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1

                    /* renamed from: a */
                    final /* synthetic */ boolean f10989a;

                    /* renamed from: b */
                    final /* synthetic */ boolean f10990b;

                    /* renamed from: c */
                    final /* synthetic */ int f10991c;

                    public AnonymousClass1(boolean e102, boolean e112, int i102) {
                        e10 = e102;
                        e11 = e112;
                        i10 = i102;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i102;
                        try {
                            h a102 = h.a(cy.this.f10988a, "re_po_rt");
                            if (a102.b(df.f11061o, 0) == 1) {
                                if (e10 || e11) {
                                    long a11 = df.a(cy.this.f10988a).a(df.f11046bi);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b10 = a102.b(df.f11062p, 8) * 3600000;
                                    int b11 = a102.b(df.f11063q, 0);
                                    if (a11 > 0 && currentTimeMillis - a11 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(hours);
                                        if (list.contains(sb2.toString())) {
                                            return;
                                        }
                                    }
                                    if (currentTimeMillis - a11 >= b10 || (((i102 = i10) == 100 && b11 == 1) || i102 == 106)) {
                                        cp.a(cy.this.f10988a, new ci(cy.this.f10988a, i10).a(ck.f10908d), ck.f10908d, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
