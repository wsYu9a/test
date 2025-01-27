package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class u {

    /* renamed from: a */
    private List<e.a> f20639a;

    /* renamed from: b */
    private HashMap<Integer, e.a> f20640b = new HashMap<>();

    u(List<e.a> list) {
        this.f20639a = list;
        for (e.a aVar : this.f20639a) {
            this.f20640b.put(Integer.valueOf(aVar.f23520a), aVar);
        }
    }

    private static final int a(int i2) {
        if (i2 <= 0) {
            return 1;
        }
        int i3 = 1;
        while (i2 >= 10) {
            if (i2 < 100) {
                return i3 * 10;
            }
            if (i2 < 1000) {
                return i3 * 100;
            }
            if (i2 < 10000) {
                return i3 * 1000;
            }
            i2 /= 10000;
            i3 *= 10000;
        }
        return i3 * 1;
    }

    public e.a a(int i2, com.opos.cmn.i.e<e.a, Boolean> eVar) {
        e.a aVar;
        String str;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            aVar = null;
            if (i3 >= 100) {
                str = "rank max";
                break;
            }
            double a2 = a(i2);
            double pow = Math.pow(10.0d, i4 - 1);
            Double.isNaN(a2);
            int i5 = (int) (a2 / pow);
            if (i5 <= 0) {
                str = "rank select but filter <= 0";
                break;
            }
            i2 %= i5;
            if (i2 <= 0) {
                str = "rank select but rank <= 0";
                break;
            }
            int a3 = i2 / a(i2);
            aVar = this.f20640b.get(Integer.valueOf(a3));
            if (aVar != null) {
                com.opos.cmn.an.f.a.b("delegator", "select but entity null:" + a3);
                if (eVar.a(aVar).booleanValue()) {
                    break;
                }
            }
            i3++;
            i4++;
        }
        com.opos.cmn.an.f.a.b("delegator", str);
        return aVar;
    }

    public void a() {
    }
}
