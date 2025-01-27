package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class cw {

    /* renamed from: b */
    private static volatile cw f9247b;

    /* renamed from: a */
    private Context f9248a;

    /* renamed from: com.kuaishou.weapon.p0.cw$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f9249a;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            try {
                h a2 = h.a(cw.this.f9248a, "re_po_rt");
                if (a2.b(de.w, 0) == 1) {
                    long a3 = de.a(cw.this.f9248a).a(de.aZ);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b2 = a2.b(de.x, 8) * 3600000;
                    int b3 = a2.b(de.o, 0);
                    if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                        int hours = new Date(currentTimeMillis).getHours();
                        List<Integer> list = WeaponHI.isList;
                        StringBuilder sb = new StringBuilder();
                        sb.append(hours);
                        if (list.contains(sb.toString())) {
                            return;
                        }
                    }
                    if (currentTimeMillis - a3 >= b2 || (i2 = i2) == 106 || (i2 == 100 && b3 == 1)) {
                        co.a(cw.this.f9248a, new cg(cw.this.f9248a, i2).a(cj.f9196i), cj.f9196i, false, true);
                        de.a(cw.this.f9248a).a(de.aZ, currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cw(Context context) {
        this.f9248a = context;
    }

    public static cw a(Context context) {
        if (f9247b == null) {
            synchronized (cw.class) {
                if (f9247b == null) {
                    f9247b = new cw(context);
                }
            }
        }
        return f9247b;
    }

    public void a(int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cw.1

            /* renamed from: a */
            final /* synthetic */ int f9249a;

            AnonymousClass1(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i22;
                try {
                    h a2 = h.a(cw.this.f9248a, "re_po_rt");
                    if (a2.b(de.w, 0) == 1) {
                        long a3 = de.a(cw.this.f9248a).a(de.aZ);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.x, 8) * 3600000;
                        int b3 = a2.b(de.o, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a3 >= b2 || (i22 = i2) == 106 || (i22 == 100 && b3 == 1)) {
                            co.a(cw.this.f9248a, new cg(cw.this.f9248a, i2).a(cj.f9196i), cj.f9196i, false, true);
                            de.a(cw.this.f9248a).a(de.aZ, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
