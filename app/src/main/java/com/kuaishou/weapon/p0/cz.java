package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class cz {

    /* renamed from: b */
    private static volatile cz f9260b;

    /* renamed from: a */
    private Context f9261a;

    /* renamed from: com.kuaishou.weapon.p0.cz$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f9262a;

        /* renamed from: b */
        final /* synthetic */ int f9263b;

        AnonymousClass1(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            try {
                h a2 = h.a(cz.this.f9261a, "re_po_rt");
                if (a2.b(de.N, 1) == 1) {
                    long a3 = de.a(cz.this.f9261a).a(de.bb);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b2 = a2.b(de.P, 1) * 3600000;
                    long b3 = a2.b(de.Q, 5) * 60000;
                    int b4 = a2.b(de.R, 0);
                    if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                        int hours = new Date(currentTimeMillis).getHours();
                        List<Integer> list = WeaponHI.isList;
                        StringBuilder sb = new StringBuilder();
                        sb.append(hours);
                        if (list.contains(sb.toString())) {
                            dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), ((new Random().nextInt(60) + 1) * 60000) + 3600000, "env://");
                            return;
                        }
                    }
                    long j2 = currentTimeMillis - a3;
                    if (j2 < b2 && (((i2 = i2) != 100 || b4 != 1) && i2 != 106 && (i2 == 100 || i2 <= 0 || j2 < b3))) {
                        dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), b2 - j2, "env://");
                        return;
                    }
                    co.a(cz.this.f9261a, new ck(cz.this.f9261a, i2, i3).a(cj.f9190c), cj.f9190c, true, true);
                    de.a(cz.this.f9261a).a(de.bb, currentTimeMillis);
                    dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), b2, "env://");
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cz(Context context) {
        this.f9261a = context;
    }

    public static cz a(Context context) {
        if (f9260b == null) {
            synchronized (cz.class) {
                if (f9260b == null) {
                    f9260b = new cz(context);
                }
            }
        }
        return f9260b;
    }

    public void a(int i2, int i3) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1

            /* renamed from: a */
            final /* synthetic */ int f9262a;

            /* renamed from: b */
            final /* synthetic */ int f9263b;

            AnonymousClass1(int i22, int i32) {
                i2 = i22;
                i3 = i32;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i22;
                try {
                    h a2 = h.a(cz.this.f9261a, "re_po_rt");
                    if (a2.b(de.N, 1) == 1) {
                        long a3 = de.a(cz.this.f9261a).a(de.bb);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.P, 1) * 3600000;
                        long b3 = a2.b(de.Q, 5) * 60000;
                        int b4 = a2.b(de.R, 0);
                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), ((new Random().nextInt(60) + 1) * 60000) + 3600000, "env://");
                                return;
                            }
                        }
                        long j2 = currentTimeMillis - a3;
                        if (j2 < b2 && (((i22 = i2) != 100 || b4 != 1) && i22 != 106 && (i22 == 100 || i22 <= 0 || j2 < b3))) {
                            dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), b2 - j2, "env://");
                            return;
                        }
                        co.a(cz.this.f9261a, new ck(cz.this.f9261a, i2, i3).a(cj.f9190c), cj.f9190c, true, true);
                        de.a(cz.this.f9261a).a(de.bb, currentTimeMillis);
                        dd.a(cz.this.f9261a, bp.f9128f, Integer.valueOf(cj.f9190c).intValue(), b2, "env://");
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
