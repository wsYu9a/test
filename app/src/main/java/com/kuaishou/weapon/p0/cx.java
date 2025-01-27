package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class cx {

    /* renamed from: b */
    private static volatile cx f10983b;

    /* renamed from: a */
    private Context f10984a;

    /* renamed from: com.kuaishou.weapon.p0.cx$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f10985a;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            try {
                h a10 = h.a(cx.this.f10984a, "re_po_rt");
                if (a10.b(df.f11071y, 0) == 1) {
                    long a11 = df.a(cx.this.f10984a).a(df.f11045bh);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b10 = a10.b(df.f11072z, 8) * 3600000;
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
                    if (currentTimeMillis - a11 >= b10 || (i10 = i10) == 106 || (i10 == 100 && b11 == 1)) {
                        cp.a(cx.this.f10984a, new ch(cx.this.f10984a, i10).a(ck.f10913i), ck.f10913i, false, true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cx(Context context) {
        this.f10984a = context;
    }

    public static cx a(Context context) {
        if (f10983b == null) {
            synchronized (cx.class) {
                try {
                    if (f10983b == null) {
                        f10983b = new cx(context);
                    }
                } finally {
                }
            }
        }
        return f10983b;
    }

    public void a(int i10) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1

            /* renamed from: a */
            final /* synthetic */ int f10985a;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i102;
                try {
                    h a10 = h.a(cx.this.f10984a, "re_po_rt");
                    if (a10.b(df.f11071y, 0) == 1) {
                        long a11 = df.a(cx.this.f10984a).a(df.f11045bh);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b10 = a10.b(df.f11072z, 8) * 3600000;
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
                        if (currentTimeMillis - a11 >= b10 || (i102 = i10) == 106 || (i102 == 100 && b11 == 1)) {
                            cp.a(cx.this.f10984a, new ch(cx.this.f10984a, i10).a(ck.f10913i), ck.f10913i, false, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
