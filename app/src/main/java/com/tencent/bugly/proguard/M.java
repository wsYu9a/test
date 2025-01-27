package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class M {
    public static ta a(UserInfoBean userInfoBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        ta taVar = new ta();
        taVar.f25157b = userInfoBean.f24711e;
        taVar.f25161f = userInfoBean.f24716j;
        taVar.f25160e = userInfoBean.f24709c;
        taVar.f25159d = userInfoBean.f24710d;
        taVar.f25164i = userInfoBean.o == 1;
        int i2 = userInfoBean.f24708b;
        if (i2 == 1) {
            taVar.f25158c = (byte) 1;
        } else if (i2 == 2) {
            taVar.f25158c = (byte) 4;
        } else if (i2 == 3) {
            taVar.f25158c = (byte) 2;
        } else if (i2 == 4) {
            taVar.f25158c = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                X.b("unknown uinfo type %d ", Integer.valueOf(i2));
                return null;
            }
            taVar.f25158c = (byte) i2;
        }
        HashMap hashMap = new HashMap();
        taVar.f25162g = hashMap;
        if (userInfoBean.p >= 0) {
            hashMap.put("C01", "" + userInfoBean.p);
        }
        if (userInfoBean.q >= 0) {
            taVar.f25162g.put("C02", "" + userInfoBean.q);
        }
        Map<String, String> map = userInfoBean.r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                taVar.f25162g.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                taVar.f25162g.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = taVar.f25162g;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(!userInfoBean.l);
        map3.put("A36", sb.toString());
        taVar.f25162g.put("F02", "" + userInfoBean.f24713g);
        taVar.f25162g.put("F03", "" + userInfoBean.f24714h);
        taVar.f25162g.put("F04", "" + userInfoBean.f24716j);
        taVar.f25162g.put("F05", "" + userInfoBean.f24715i);
        taVar.f25162g.put("F06", "" + userInfoBean.m);
        taVar.f25162g.put("F10", "" + userInfoBean.k);
        X.a("summary type %d vm:%d", Byte.valueOf(taVar.f25158c), Integer.valueOf(taVar.f25162g.size()));
        return taVar;
    }

    public static ua a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a m;
        if (list == null || list.size() == 0 || (m = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
            return null;
        }
        m.E();
        ua uaVar = new ua();
        uaVar.f25169d = m.f24755h;
        uaVar.f25170e = m.l();
        ArrayList<ta> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            ta a2 = a(it.next(), m);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        uaVar.f25171f = arrayList;
        HashMap hashMap = new HashMap();
        uaVar.f25172g = hashMap;
        hashMap.put("A7", "" + m.n);
        uaVar.f25172g.put("A6", "" + m.j());
        uaVar.f25172g.put("A5", "" + m.k());
        uaVar.f25172g.put("A2", "" + m.v());
        uaVar.f25172g.put("A1", "" + m.v());
        uaVar.f25172g.put("A24", "" + m.p);
        uaVar.f25172g.put("A17", "" + m.x());
        uaVar.f25172g.put("A15", "" + m.i());
        uaVar.f25172g.put("A13", "" + m.n());
        uaVar.f25172g.put("F08", "" + m.ca);
        uaVar.f25172g.put("F09", "" + m.da);
        Map<String, String> g2 = m.g();
        if (g2 != null && g2.size() > 0) {
            for (Map.Entry<String, String> entry : g2.entrySet()) {
                uaVar.f25172g.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                X.b("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            uaVar.f25168c = (byte) 2;
        } else {
            uaVar.f25168c = (byte) 1;
        }
        return uaVar;
    }

    public static <T extends AbstractC0909m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C0907k c0907k = new C0907k(bArr);
                c0907k.a("utf-8");
                newInstance.a(c0907k);
                return newInstance;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static pa a(Context context, int i2, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (m != null && c2 != null) {
            try {
                pa paVar = new pa();
                synchronized (m) {
                    paVar.f25114c = m.f24753f;
                    paVar.f25115d = m.e();
                    paVar.f25116e = m.f24754g;
                    paVar.f25117f = m.E;
                    paVar.f25118g = m.I;
                    paVar.f25119h = m.l;
                    paVar.f25120i = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    paVar.f25121j = bArr;
                    paVar.k = m.o;
                    paVar.l = m.p;
                    paVar.m = new HashMap();
                    paVar.n = m.u();
                    paVar.o = c2.o;
                    paVar.q = m.l();
                    paVar.r = com.tencent.bugly.crashreport.common.info.b.c(context);
                    paVar.s = System.currentTimeMillis();
                    paVar.u = m.q();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(m.l());
                    paVar.x = sb.toString();
                    paVar.y = paVar.r;
                    paVar.p = "com.tencent.bugly";
                    Map<String, String> map = paVar.m;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(m.r());
                    map.put("A26", sb2.toString());
                    Map<String, String> map2 = paVar.m;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(m.D());
                    map2.put("A62", sb3.toString());
                    Map<String, String> map3 = paVar.m;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(m.B());
                    map3.put("A63", sb4.toString());
                    Map<String, String> map4 = paVar.m;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(m.ha);
                    map4.put("F11", sb5.toString());
                    Map<String, String> map5 = paVar.m;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("");
                    sb6.append(m.ga);
                    map5.put("F12", sb6.toString());
                    Map<String, String> map6 = paVar.m;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    sb7.append(m.G);
                    map6.put("D3", sb7.toString());
                    List<com.tencent.bugly.a> list = com.tencent.bugly.b.f24587b;
                    if (list != null) {
                        for (com.tencent.bugly.a aVar : list) {
                            String str2 = aVar.versionKey;
                            if (str2 != null && (str = aVar.version) != null) {
                                paVar.m.put(str2, str);
                            }
                        }
                    }
                    paVar.m.put("G15", ca.b("G15", ""));
                    paVar.m.put("D4", ca.b("D4", "0"));
                }
                Map<String, String> f2 = m.f();
                if (f2 != null) {
                    for (Map.Entry<String, String> entry : f2.entrySet()) {
                        paVar.m.put(entry.getKey(), entry.getValue());
                    }
                }
                return paVar;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        X.b("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            C0901e c0901e = new C0901e();
            c0901e.a();
            c0901e.a("utf-8");
            c0901e.a(1);
            c0901e.c("RqdServer");
            c0901e.b("sync");
            c0901e.a("detail", (String) obj);
            return c0901e.b();
        } catch (Throwable th) {
            if (X.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static qa a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                C0901e c0901e = new C0901e();
                c0901e.a();
                c0901e.a("utf-8");
                c0901e.a(bArr);
                Object b2 = c0901e.b("detail", new qa());
                if (qa.class.isInstance(b2)) {
                    return (qa) qa.class.cast(b2);
                }
                return null;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(AbstractC0909m abstractC0909m) {
        try {
            C0908l c0908l = new C0908l();
            c0908l.a("utf-8");
            abstractC0909m.a(c0908l);
            return c0908l.b();
        } catch (Throwable th) {
            if (X.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
