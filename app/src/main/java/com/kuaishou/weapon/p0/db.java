package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class db {

    /* renamed from: b */
    private static volatile db f11008b;

    /* renamed from: a */
    private Context f11009a;

    /* renamed from: com.kuaishou.weapon.p0.db$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f11010a;

        /* renamed from: b */
        final /* synthetic */ int f11011b;

        public AnonymousClass1(int i10, int i11) {
            i10 = i10;
            i11 = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j10;
            int i10;
            try {
                h a10 = h.a(db.this.f11009a, "re_po_rt");
                if (a10.b(df.P, 1) == 1) {
                    long a11 = df.a(db.this.f11009a).a(df.f11047bj);
                    long currentTimeMillis = System.currentTimeMillis();
                    long b10 = a10.b(df.R, 1) * 3600000;
                    long b11 = a10.b(df.S, 5) * 60000;
                    int b12 = a10.b(df.T, 0);
                    if (a11 > 0) {
                        j10 = a11;
                        if (currentTimeMillis - a11 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(hours);
                            if (list.contains(sb2.toString())) {
                                return;
                            }
                        }
                    } else {
                        j10 = a11;
                    }
                    long j11 = currentTimeMillis - j10;
                    if (j11 >= b10 || (((i10 = i10) == 100 && b12 == 1) || i10 == 106 || (i10 != 100 && i10 > 0 && j11 >= b11))) {
                        cp.a(db.this.f11009a, new cl(db.this.f11009a, i10, i11).a(ck.f10907c), ck.f10907c, true, true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private db(Context context) {
        this.f11009a = context;
    }

    public static db a(Context context) {
        if (f11008b == null) {
            synchronized (db.class) {
                try {
                    if (f11008b == null) {
                        f11008b = new db(context);
                    }
                } finally {
                }
            }
        }
        return f11008b;
    }

    public void a(int i10, int i11) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.db.1

            /* renamed from: a */
            final /* synthetic */ int f11010a;

            /* renamed from: b */
            final /* synthetic */ int f11011b;

            public AnonymousClass1(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j10;
                int i102;
                try {
                    h a10 = h.a(db.this.f11009a, "re_po_rt");
                    if (a10.b(df.P, 1) == 1) {
                        long a11 = df.a(db.this.f11009a).a(df.f11047bj);
                        long currentTimeMillis = System.currentTimeMillis();
                        long b10 = a10.b(df.R, 1) * 3600000;
                        long b11 = a10.b(df.S, 5) * 60000;
                        int b12 = a10.b(df.T, 0);
                        if (a11 > 0) {
                            j10 = a11;
                            if (currentTimeMillis - a11 < WeaponHI.f10723ii * 3600000 && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(hours);
                                if (list.contains(sb2.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j10 = a11;
                        }
                        long j11 = currentTimeMillis - j10;
                        if (j11 >= b10 || (((i102 = i10) == 100 && b12 == 1) || i102 == 106 || (i102 != 100 && i102 > 0 && j11 >= b11))) {
                            cp.a(db.this.f11009a, new cl(db.this.f11009a, i10, i11).a(ck.f10907c), ck.f10907c, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
