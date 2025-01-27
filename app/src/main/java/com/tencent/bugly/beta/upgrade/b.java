package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.AbstractC0909m;
import com.tencent.bugly.proguard.C0921z;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.pa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static b f24645a = new b();

    public synchronized void a(int i2, int i3, byte[] bArr, a aVar, boolean z, String str) {
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        try {
            try {
                pa a2 = M.a(e.f24621b.v, i2, bArr);
                if (a2 != null) {
                    e eVar = e.f24621b;
                    a2.f25115d = eVar.x;
                    if (!TextUtils.isEmpty(eVar.R)) {
                        a2.f25118g = eVar.R;
                    }
                    Map<String, String> map = a2.m;
                    if (map != null) {
                        map.put("G6", eVar.y);
                        a2.m.put("G10", "1.5.23");
                        Map<String, String> map2 = a2.m;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(eVar.A);
                        map2.put("G3", sb.toString());
                        a2.m.put("G11", String.valueOf(eVar.z));
                        a2.m.put("G2", String.valueOf(com.tencent.bugly.beta.global.a.a(e.f24621b.v)));
                        int i4 = eVar.r;
                        if (i4 < 0) {
                            i4 = 0;
                        }
                        a2.m.put("G12", String.valueOf(i4));
                        Map<String, String> map3 = a2.m;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(m.y());
                        map3.put("A21", sb2.toString());
                        Map<String, String> map4 = a2.m;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(m.l());
                        map4.put("A22", sb3.toString());
                        Map<String, String> map5 = a2.m;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("");
                        sb4.append(eVar.L);
                        map5.put("G13", sb4.toString());
                        Map<String, String> map6 = a2.m;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("");
                        sb5.append(eVar.M);
                        map6.put("G14", sb5.toString());
                        Map<String, String> map7 = a2.m;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("");
                        sb6.append(eVar.O);
                        map7.put("G15", sb6.toString());
                        Map<String, String> map8 = a2.m;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("");
                        sb7.append(m.n());
                        map8.put("G17", sb7.toString());
                        Map<String, String> map9 = a2.m;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("");
                        sb8.append(m.A());
                        map9.put("C01", sb8.toString());
                        Map<String, String> map10 = a2.m;
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("");
                        sb9.append(m.y());
                        map10.put("G18", sb9.toString());
                        Map<String, String> map11 = a2.m;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("");
                        sb10.append(i3);
                        map11.put("strategyType", sb10.toString());
                        Map<String, String> map12 = a2.m;
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("");
                        sb11.append(z);
                        map12.put("strategyRequestManner", sb11.toString());
                        Map<String, String> h2 = m.h();
                        if (h2 != null && h2.size() > 0) {
                            for (Map.Entry<String, String> entry : h2.entrySet()) {
                                Map<String, String> map13 = a2.m;
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append("C03_");
                                sb12.append(entry.getKey());
                                map13.put(sb12.toString(), entry.getValue());
                            }
                        }
                        X.a("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", eVar.A, Integer.valueOf(eVar.z), m.l(), a2.f25118g, Integer.valueOf(eVar.r), eVar.L, eVar.M, eVar.O, Integer.valueOf(i3));
                        HashMap hashMap = new HashMap();
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append(e.f24621b.H.f24640b);
                        sb13.append("");
                        hashMap.put("grayStrategyUpdateTime", sb13.toString());
                        if (z) {
                            T.a().a(1002, a2.f25120i, M.a((Object) a2), str, str, aVar, 0, 1, true, hashMap);
                        } else {
                            T.a().a(1002, a2.f25120i, M.a((Object) a2), str, str, (P) aVar, false, (Map<String, String>) hashMap);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                aVar.a(i2, null, 0L, 0L, false, "sendRequest failed");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void a(C0921z c0921z, boolean z) {
        if (c0921z == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0921z);
        A a2 = new A(arrayList);
        try {
            a(803, -1, M.a((AbstractC0909m) a2), new a(2, 803, a2, Boolean.valueOf(z)), false, e.f24621b.H.f24639a.f25152g);
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(A a2, boolean z) {
        if (a2 == null) {
            return;
        }
        try {
            a(803, -1, M.a((AbstractC0909m) a2), new a(2, 803, a2, Boolean.valueOf(z)), false, e.f24621b.H.f24639a.f25152g);
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
        }
    }
}
