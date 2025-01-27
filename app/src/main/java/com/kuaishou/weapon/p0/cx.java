package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class cx {

    /* renamed from: b */
    private static volatile cx f9251b;

    /* renamed from: a */
    private Context f9252a;

    /* renamed from: com.kuaishou.weapon.p0.cx$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9253a;

        /* renamed from: b */
        final /* synthetic */ boolean f9254b;

        /* renamed from: c */
        final /* synthetic */ int f9255c;

        AnonymousClass1(boolean z, boolean z2, int i2) {
            e2 = z;
            e3 = z2;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j2;
            int i2;
            try {
                h a2 = h.a(cx.this.f9252a, "re_po_rt");
                if (a2.b(de.m, 1) == 1) {
                    if (e2 || e3) {
                        long a3 = de.a(cx.this.f9252a).a(de.ba);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b2 = a2.b(de.n, 8) * 3600000;
                        int b3 = a2.b(de.o, 0);
                        long b4 = a2.b(de.q, 20) * 60000;
                        if (a3 > 0) {
                            j2 = a3;
                            if (currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb = new StringBuilder();
                                sb.append(hours);
                                if (list.contains(sb.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j2 = a3;
                        }
                        long j3 = currentTimeMillis - j2;
                        if (j3 >= b2 || (((i2 = i2) == 100 && b3 == 1) || ((i2 == 101 || i2 == 102) && j3 >= b4))) {
                            co.a(cx.this.f9252a, new ch(cx.this.f9252a, i2).a(cj.f9191d), cj.f9191d, true, true);
                            de.a(cx.this.f9252a).a(de.ba, currentTimeMillis);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private cx(Context context) {
        this.f9252a = context;
    }

    public static cx a(Context context) {
        if (f9251b == null) {
            synchronized (cx.class) {
                if (f9251b == null) {
                    f9251b = new cx(context);
                }
            }
        }
        return f9251b;
    }

    public void a(int i2) {
        try {
            h a2 = h.a(this.f9252a, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            if ((e2 || e3) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cx.1

                    /* renamed from: a */
                    final /* synthetic */ boolean f9253a;

                    /* renamed from: b */
                    final /* synthetic */ boolean f9254b;

                    /* renamed from: c */
                    final /* synthetic */ int f9255c;

                    AnonymousClass1(boolean e22, boolean e32, int i22) {
                        e2 = e22;
                        e3 = e32;
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        long j2;
                        int i22;
                        try {
                            h a22 = h.a(cx.this.f9252a, "re_po_rt");
                            if (a22.b(de.m, 1) == 1) {
                                if (e2 || e3) {
                                    long a3 = de.a(cx.this.f9252a).a(de.ba);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long b2 = a22.b(de.n, 8) * 3600000;
                                    int b3 = a22.b(de.o, 0);
                                    long b4 = a22.b(de.q, 20) * 60000;
                                    if (a3 > 0) {
                                        j2 = a3;
                                        if (currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                            int hours = new Date(currentTimeMillis).getHours();
                                            List<Integer> list = WeaponHI.isList;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(hours);
                                            if (list.contains(sb.toString())) {
                                                return;
                                            }
                                        }
                                    } else {
                                        j2 = a3;
                                    }
                                    long j3 = currentTimeMillis - j2;
                                    if (j3 >= b2 || (((i22 = i2) == 100 && b3 == 1) || ((i22 == 101 || i22 == 102) && j3 >= b4))) {
                                        co.a(cx.this.f9252a, new ch(cx.this.f9252a, i2).a(cj.f9191d), cj.f9191d, true, true);
                                        de.a(cx.this.f9252a).a(de.ba, currentTimeMillis);
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
