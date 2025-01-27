package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class dd {

    /* renamed from: b */
    private static volatile dd f11017b;

    /* renamed from: a */
    private Context f11018a;

    /* renamed from: com.kuaishou.weapon.p0.dd$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f11019a;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(dd.this.f11018a, "re_po_rt").b(df.aC, 1) == 1) {
                    long a10 = df.a(dd.this.f11018a).a();
                    long currentTimeMillis = System.currentTimeMillis();
                    long b10 = r0.b(df.aE, 8) * 3600000;
                    if (a10 > 0 && currentTimeMillis - a10 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                        int hours = new Date(currentTimeMillis).getHours();
                        List<Integer> list = WeaponHI.isList;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(hours);
                        if (list.contains(sb2.toString())) {
                            return;
                        }
                    }
                    if (currentTimeMillis - a10 >= b10 || i10 == 106) {
                        cp.a(dd.this.f11018a, new cn(dd.this.f11018a, i10).a(ck.f10906b), ck.f10906b, true, true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private dd(Context context) {
        this.f11018a = context;
    }

    public static dd a(Context context) {
        if (f11017b == null) {
            synchronized (dd.class) {
                try {
                    if (f11017b == null) {
                        f11017b = new dd(context);
                    }
                } finally {
                }
            }
        }
        return f11017b;
    }

    public void a(int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.dd.1

            /* renamed from: a */
            final /* synthetic */ int f11019a;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(dd.this.f11018a, "re_po_rt").b(df.aC, 1) == 1) {
                        long a10 = df.a(dd.this.f11018a).a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long b10 = r0.b(df.aE, 8) * 3600000;
                        if (a10 > 0 && currentTimeMillis - a10 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(hours);
                            if (list.contains(sb2.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a10 >= b10 || i10 == 106) {
                            cp.a(dd.this.f11018a, new cn(dd.this.f11018a, i10).a(ck.f10906b), ck.f10906b, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
