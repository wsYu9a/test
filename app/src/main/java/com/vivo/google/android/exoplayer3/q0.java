package com.vivo.google.android.exoplayer3;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class q0 extends r0 {

    /* renamed from: b */
    public long f27943b;

    public q0(n0 n0Var) {
        super(n0Var);
        this.f27943b = C.TIME_UNSET;
    }

    public static Object a(n6 n6Var, int i2) {
        if (i2 == 8) {
            return b(n6Var);
        }
        if (i2 == 10) {
            int o = n6Var.o();
            ArrayList arrayList = new ArrayList(o);
            for (int i3 = 0; i3 < o; i3++) {
                arrayList.add(a(n6Var, n6Var.l()));
            }
            return arrayList;
        }
        if (i2 == 11) {
            Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(n6Var.i())).doubleValue());
            n6Var.e(2);
            return date;
        }
        if (i2 == 0) {
            return Double.valueOf(Double.longBitsToDouble(n6Var.i()));
        }
        if (i2 == 1) {
            return Boolean.valueOf(n6Var.l() == 1);
        }
        if (i2 == 2) {
            int q = n6Var.q();
            int i4 = n6Var.f27875b;
            n6Var.e(q);
            return new String(n6Var.f27874a, i4, q);
        }
        if (i2 != 3) {
            return null;
        }
        HashMap hashMap = new HashMap();
        while (true) {
            int q2 = n6Var.q();
            int i5 = n6Var.f27875b;
            n6Var.e(q2);
            String str = new String(n6Var.f27874a, i5, q2);
            int l = n6Var.l();
            if (l == 9) {
                return hashMap;
            }
            hashMap.put(str, a(n6Var, l));
        }
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public boolean a(n6 n6Var) {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public void b(n6 n6Var, long j2) {
        if (n6Var.l() != 2) {
            throw new f();
        }
        int q = n6Var.q();
        int i2 = n6Var.f27875b;
        n6Var.e(q);
        if ("onMetaData".equals(new String(n6Var.f27874a, i2, q)) && n6Var.l() == 8) {
            HashMap<String, Object> b2 = b(n6Var);
            if (b2.containsKey("duration")) {
                double doubleValue = ((Double) b2.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f27943b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    public static HashMap<String, Object> b(n6 n6Var) {
        int o = n6Var.o();
        HashMap<String, Object> hashMap = new HashMap<>(o);
        for (int i2 = 0; i2 < o; i2++) {
            int q = n6Var.q();
            int i3 = n6Var.f27875b;
            n6Var.e(q);
            hashMap.put(new String(n6Var.f27874a, i3, q), a(n6Var, n6Var.l()));
        }
        return hashMap;
    }
}
