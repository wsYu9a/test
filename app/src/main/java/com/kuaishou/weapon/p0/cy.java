package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class cy {

    /* renamed from: b */
    private static volatile cy f9257b;

    /* renamed from: a */
    private Context f9258a;

    /* renamed from: com.kuaishou.weapon.p0.cy$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(cy.this.f9258a, "re_po_rt").b(de.E, 1) == 1) {
                    long a2 = de.a(cy.this.f9258a).a(de.be);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b2 = r1.b(de.G, 12) * 3600000;
                    if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                        int hours = new Date(currentTimeMillis).getHours();
                        List<Integer> list = WeaponHI.isList;
                        StringBuilder sb = new StringBuilder();
                        sb.append(hours);
                        if (list.contains(sb.toString())) {
                            return;
                        }
                    }
                    if (currentTimeMillis - a2 >= b2) {
                        co.a(cy.this.f9258a, new ci(cy.this.f9258a).a(cj.f9194g), cj.f9194g, true, true);
                        de.a(cy.this.f9258a).a(de.be, currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cy(Context context) {
        this.f9258a = context;
    }

    public static cy a(Context context) {
        if (f9257b == null) {
            synchronized (cy.class) {
                if (f9257b == null) {
                    f9257b = new cy(context);
                }
            }
        }
        return f9257b;
    }

    public void a() {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(cy.this.f9258a, "re_po_rt").b(de.E, 1) == 1) {
                        long a2 = de.a(cy.this.f9258a).a(de.be);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = r1.b(de.G, 12) * 3600000;
                        if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a2 >= b2) {
                            co.a(cy.this.f9258a, new ci(cy.this.f9258a).a(cj.f9194g), cj.f9194g, true, true);
                            de.a(cy.this.f9258a).a(de.be, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
