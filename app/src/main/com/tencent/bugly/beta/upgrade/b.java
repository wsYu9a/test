package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.AbstractC0868m;
import com.tencent.bugly.proguard.C0880z;
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
    public static b f22146a = new b();

    public synchronized void a(int i10, int i11, byte[] bArr, a aVar, boolean z10, String str) {
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            pa a10 = M.a(e.f22100b.f22126v, i10, bArr);
            if (a10 != null) {
                e eVar = e.f22100b;
                a10.f22803d = eVar.f22128x;
                if (!TextUtils.isEmpty(eVar.R)) {
                    a10.f22806g = eVar.R;
                }
                Map<String, String> map = a10.f22812m;
                if (map != null) {
                    map.put("G6", eVar.f22129y);
                    a10.f22812m.put("G10", "1.5.23");
                    Map<String, String> map2 = a10.f22812m;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(eVar.A);
                    map2.put("G3", sb2.toString());
                    a10.f22812m.put("G11", String.valueOf(eVar.f22130z));
                    a10.f22812m.put("G2", String.valueOf(com.tencent.bugly.beta.global.a.a(e.f22100b.f22126v)));
                    int i12 = eVar.f22122r;
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    a10.f22812m.put("G12", String.valueOf(i12));
                    Map<String, String> map3 = a10.f22812m;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(m10.y());
                    map3.put("A21", sb3.toString());
                    Map<String, String> map4 = a10.f22812m;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(m10.l());
                    map4.put("A22", sb4.toString());
                    Map<String, String> map5 = a10.f22812m;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(eVar.L);
                    map5.put("G13", sb5.toString());
                    Map<String, String> map6 = a10.f22812m;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("");
                    sb6.append(eVar.M);
                    map6.put("G14", sb6.toString());
                    Map<String, String> map7 = a10.f22812m;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    sb7.append(eVar.O);
                    map7.put("G15", sb7.toString());
                    Map<String, String> map8 = a10.f22812m;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("");
                    sb8.append(m10.n());
                    map8.put("G17", sb8.toString());
                    Map<String, String> map9 = a10.f22812m;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("");
                    sb9.append(m10.A());
                    map9.put("C01", sb9.toString());
                    Map<String, String> map10 = a10.f22812m;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("");
                    sb10.append(m10.y());
                    map10.put("G18", sb10.toString());
                    Map<String, String> map11 = a10.f22812m;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("");
                    sb11.append(i11);
                    map11.put("strategyType", sb11.toString());
                    Map<String, String> map12 = a10.f22812m;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append("");
                    sb12.append(z10);
                    map12.put("strategyRequestManner", sb12.toString());
                    Map<String, String> h10 = m10.h();
                    if (h10 != null && h10.size() > 0) {
                        for (Map.Entry<String, String> entry : h10.entrySet()) {
                            Map<String, String> map13 = a10.f22812m;
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append("C03_");
                            sb13.append(entry.getKey());
                            map13.put(sb13.toString(), entry.getValue());
                        }
                    }
                    X.a("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", eVar.A, Integer.valueOf(eVar.f22130z), m10.l(), a10.f22806g, Integer.valueOf(eVar.f22122r), eVar.L, eVar.M, eVar.O, Integer.valueOf(i11));
                    HashMap hashMap = new HashMap();
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(e.f22100b.H.f22141b);
                    sb14.append("");
                    hashMap.put("grayStrategyUpdateTime", sb14.toString());
                    if (z10) {
                        T.a().a(1002, a10.f22808i, M.a((Object) a10), str, str, aVar, 0, 1, true, hashMap);
                    } else {
                        T.a().a(1002, a10.f22808i, M.a((Object) a10), str, str, (P) aVar, false, (Map<String, String>) hashMap);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (!X.b(th)) {
                th.printStackTrace();
            }
            aVar.a(i10, null, 0L, 0L, false, "sendRequest failed");
        }
    }

    public synchronized void a(C0880z c0880z, boolean z10) {
        if (c0880z == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0880z);
        A a10 = new A(arrayList);
        try {
            a(803, -1, M.a((AbstractC0868m) a10), new a(2, 803, a10, Boolean.valueOf(z10)), false, e.f22100b.H.f22140a.f22856g);
        } catch (Throwable th2) {
            if (!X.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public synchronized void a(A a10, boolean z10) {
        if (a10 == null) {
            return;
        }
        try {
            a(803, -1, M.a((AbstractC0868m) a10), new a(2, 803, a10, Boolean.valueOf(z10)), false, e.f22100b.H.f22140a.f22856g);
        } finally {
        }
    }
}
