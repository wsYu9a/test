package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class db {

    /* renamed from: b */
    private static volatile db f9271b;

    /* renamed from: a */
    private Context f9272a;

    /* renamed from: com.kuaishou.weapon.p0.db$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f9273a;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(db.this.f9272a, "re_po_rt").b(de.au, 1) == 1) {
                    long a2 = de.a(db.this.f9272a).a();
                    long currentTimeMillis = System.currentTimeMillis();
                    long b2 = r0.b(de.aw, 8) * 3600000;
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
                        co.a(db.this.f9272a, new cm(db.this.f9272a, i2).a(cj.f9189b), cj.f9189b, true, true);
                        de.a(db.this.f9272a).a(currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private db(Context context) {
        this.f9272a = context;
    }

    public static db a(Context context) {
        if (f9271b == null) {
            synchronized (db.class) {
                if (f9271b == null) {
                    f9271b = new db(context);
                }
            }
        }
        return f9271b;
    }

    public void a(int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1

            /* renamed from: a */
            final /* synthetic */ int f9273a;

            AnonymousClass1(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(db.this.f9272a, "re_po_rt").b(de.au, 1) == 1) {
                        long a2 = de.a(db.this.f9272a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = r0.b(de.aw, 8) * 3600000;
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
                            co.a(db.this.f9272a, new cm(db.this.f9272a, i2).a(cj.f9189b), cj.f9189b, true, true);
                            de.a(db.this.f9272a).a(currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
