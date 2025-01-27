package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class cz {

    /* renamed from: b */
    private static volatile cz f10993b;

    /* renamed from: a */
    private Context f10994a;

    /* renamed from: com.kuaishou.weapon.p0.cz$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f10995a;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.a(cz.this.f10994a, "re_po_rt").b(df.G, 1) == 1) {
                    long a10 = df.a(cz.this.f10994a).a(df.bm);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b10 = r0.b(df.I, 12) * 3600000;
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
                        cp.a(cz.this.f10994a, new cj(cz.this.f10994a).a(ck.f10911g), ck.f10911g, true, true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cz(Context context) {
        this.f10994a = context;
    }

    public static cz a(Context context) {
        if (f10993b == null) {
            synchronized (cz.class) {
                try {
                    if (f10993b == null) {
                        f10993b = new cz(context);
                    }
                } finally {
                }
            }
        }
        return f10993b;
    }

    public void a(int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1

            /* renamed from: a */
            final /* synthetic */ int f10995a;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.a(cz.this.f10994a, "re_po_rt").b(df.G, 1) == 1) {
                        long a10 = df.a(cz.this.f10994a).a(df.bm);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b10 = r0.b(df.I, 12) * 3600000;
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
                            cp.a(cz.this.f10994a, new cj(cz.this.f10994a).a(ck.f10911g), ck.f10911g, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
