package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class d extends b {

    /* renamed from: b */
    private long f17776b;

    public d() {
        super(null);
        this.f17776b = C.TIME_UNSET;
    }

    private static Object a(m mVar, int i2) {
        if (i2 == 0) {
            return d(mVar);
        }
        if (i2 == 1) {
            return c(mVar);
        }
        if (i2 == 2) {
            return e(mVar);
        }
        if (i2 == 3) {
            return g(mVar);
        }
        if (i2 == 8) {
            return h(mVar);
        }
        if (i2 == 10) {
            return f(mVar);
        }
        if (i2 != 11) {
            return null;
        }
        return i(mVar);
    }

    private static int b(m mVar) {
        return mVar.g();
    }

    private static Boolean c(m mVar) {
        return Boolean.valueOf(mVar.g() == 1);
    }

    private static Double d(m mVar) {
        return Double.valueOf(Double.longBitsToDouble(mVar.q()));
    }

    private static String e(m mVar) {
        int h2 = mVar.h();
        int d2 = mVar.d();
        mVar.d(h2);
        return new String(mVar.f19048a, d2, h2);
    }

    private static ArrayList<Object> f(m mVar) {
        int u = mVar.u();
        ArrayList<Object> arrayList = new ArrayList<>(u);
        for (int i2 = 0; i2 < u; i2++) {
            arrayList.add(a(mVar, b(mVar)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(m mVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e2 = e(mVar);
            int b2 = b(mVar);
            if (b2 == 9) {
                return hashMap;
            }
            hashMap.put(e2, a(mVar, b2));
        }
    }

    private static HashMap<String, Object> h(m mVar) {
        int u = mVar.u();
        HashMap<String, Object> hashMap = new HashMap<>(u);
        for (int i2 = 0; i2 < u; i2++) {
            hashMap.put(e(mVar), a(mVar, b(mVar)));
        }
        return hashMap;
    }

    private static Date i(m mVar) {
        Date date = new Date((long) d(mVar).doubleValue());
        mVar.d(2);
        return date;
    }

    public long a() {
        return this.f17776b;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j2) {
        if (b(mVar) != 2) {
            throw new o();
        }
        if ("onMetaData".equals(e(mVar)) && b(mVar) == 8) {
            HashMap<String, Object> h2 = h(mVar);
            if (h2.containsKey("duration")) {
                double doubleValue = ((Double) h2.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f17776b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }
}
