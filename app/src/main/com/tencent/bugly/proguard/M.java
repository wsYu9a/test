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
        taVar.f22866b = userInfoBean.f22233e;
        taVar.f22870f = userInfoBean.f22238j;
        taVar.f22869e = userInfoBean.f22231c;
        taVar.f22868d = userInfoBean.f22232d;
        taVar.f22873i = userInfoBean.f22243o == 1;
        int i10 = userInfoBean.f22230b;
        if (i10 == 1) {
            taVar.f22867c = (byte) 1;
        } else if (i10 == 2) {
            taVar.f22867c = (byte) 4;
        } else if (i10 == 3) {
            taVar.f22867c = (byte) 2;
        } else if (i10 == 4) {
            taVar.f22867c = (byte) 3;
        } else {
            if (i10 < 10 || i10 >= 20) {
                X.b("unknown uinfo type %d ", Integer.valueOf(i10));
                return null;
            }
            taVar.f22867c = (byte) i10;
        }
        HashMap hashMap = new HashMap();
        taVar.f22871g = hashMap;
        if (userInfoBean.f22244p >= 0) {
            hashMap.put("C01", "" + userInfoBean.f22244p);
        }
        if (userInfoBean.f22245q >= 0) {
            taVar.f22871g.put("C02", "" + userInfoBean.f22245q);
        }
        Map<String, String> map = userInfoBean.f22246r;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f22246r.entrySet()) {
                taVar.f22871g.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = userInfoBean.f22247s;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f22247s.entrySet()) {
                taVar.f22871g.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map3 = taVar.f22871g;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(!userInfoBean.f22240l);
        map3.put("A36", sb2.toString());
        taVar.f22871g.put("F02", "" + userInfoBean.f22235g);
        taVar.f22871g.put("F03", "" + userInfoBean.f22236h);
        taVar.f22871g.put("F04", "" + userInfoBean.f22238j);
        taVar.f22871g.put("F05", "" + userInfoBean.f22237i);
        taVar.f22871g.put("F06", "" + userInfoBean.f22241m);
        taVar.f22871g.put("F10", "" + userInfoBean.f22239k);
        X.a("summary type %d vm:%d", Byte.valueOf(taVar.f22867c), Integer.valueOf(taVar.f22871g.size()));
        return taVar;
    }

    public static ua a(List<UserInfoBean> list, int i10) {
        com.tencent.bugly.crashreport.common.info.a m10;
        if (list == null || list.size() == 0 || (m10 = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
            return null;
        }
        m10.E();
        ua uaVar = new ua();
        uaVar.f22878d = m10.f22296h;
        uaVar.f22879e = m10.l();
        ArrayList<ta> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            ta a10 = a(it.next(), m10);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        uaVar.f22880f = arrayList;
        HashMap hashMap = new HashMap();
        uaVar.f22881g = hashMap;
        hashMap.put("A7", "" + m10.f22308n);
        uaVar.f22881g.put("A6", "" + m10.j());
        uaVar.f22881g.put("A5", "" + m10.k());
        uaVar.f22881g.put("A2", "" + m10.v());
        uaVar.f22881g.put("A1", "" + m10.v());
        uaVar.f22881g.put("A24", "" + m10.f22312p);
        uaVar.f22881g.put("A17", "" + m10.x());
        uaVar.f22881g.put("A15", "" + m10.i());
        uaVar.f22881g.put("A13", "" + m10.n());
        uaVar.f22881g.put("F08", "" + m10.f22287ca);
        uaVar.f22881g.put("F09", "" + m10.f22289da);
        Map<String, String> g10 = m10.g();
        if (g10 != null && g10.size() > 0) {
            for (Map.Entry<String, String> entry : g10.entrySet()) {
                uaVar.f22881g.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                X.b("unknown up type %d ", Integer.valueOf(i10));
                return null;
            }
            uaVar.f22877c = (byte) 2;
        } else {
            uaVar.f22877c = (byte) 1;
        }
        return uaVar;
    }

    public static <T extends AbstractC0868m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                C0866k c0866k = new C0866k(bArr);
                c0866k.a("utf-8");
                newInstance.a(c0866k);
                return newInstance;
            } catch (Throwable th2) {
                if (!X.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static pa a(Context context, int i10, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        StrategyBean c10 = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (m10 != null && c10 != null) {
            try {
                pa paVar = new pa();
                synchronized (m10) {
                    try {
                        paVar.f22802c = m10.f22292f;
                        paVar.f22803d = m10.e();
                        paVar.f22804e = m10.f22294g;
                        paVar.f22805f = m10.E;
                        paVar.f22806g = m10.I;
                        paVar.f22807h = m10.f22304l;
                        paVar.f22808i = i10;
                        if (bArr == null) {
                            bArr = "".getBytes();
                        }
                        paVar.f22809j = bArr;
                        paVar.f22810k = m10.f22310o;
                        paVar.f22811l = m10.f22312p;
                        paVar.f22812m = new HashMap();
                        paVar.f22813n = m10.u();
                        paVar.f22814o = c10.f22351o;
                        paVar.f22816q = m10.l();
                        paVar.f22817r = com.tencent.bugly.crashreport.common.info.b.c(context);
                        paVar.f22818s = System.currentTimeMillis();
                        paVar.f22820u = m10.q();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(m10.l());
                        paVar.f22823x = sb2.toString();
                        paVar.f22824y = paVar.f22817r;
                        paVar.f22815p = "com.tencent.bugly";
                        Map<String, String> map = paVar.f22812m;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(m10.r());
                        map.put("A26", sb3.toString());
                        Map<String, String> map2 = paVar.f22812m;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("");
                        sb4.append(m10.D());
                        map2.put("A62", sb4.toString());
                        Map<String, String> map3 = paVar.f22812m;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("");
                        sb5.append(m10.B());
                        map3.put("A63", sb5.toString());
                        Map<String, String> map4 = paVar.f22812m;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("");
                        sb6.append(m10.f22297ha);
                        map4.put("F11", sb6.toString());
                        Map<String, String> map5 = paVar.f22812m;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("");
                        sb7.append(m10.f22295ga);
                        map5.put("F12", sb7.toString());
                        Map<String, String> map6 = paVar.f22812m;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("");
                        sb8.append(m10.G);
                        map6.put("D3", sb8.toString());
                        List<com.tencent.bugly.a> list = com.tencent.bugly.b.f22065b;
                        if (list != null) {
                            for (com.tencent.bugly.a aVar : list) {
                                String str2 = aVar.versionKey;
                                if (str2 != null && (str = aVar.version) != null) {
                                    paVar.f22812m.put(str2, str);
                                }
                            }
                        }
                        paVar.f22812m.put("G15", ca.b("G15", ""));
                        paVar.f22812m.put("D4", ca.b("D4", "0"));
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                Map<String, String> f10 = m10.f();
                if (f10 != null) {
                    for (Map.Entry<String, String> entry : f10.entrySet()) {
                        paVar.f22812m.put(entry.getKey(), entry.getValue());
                    }
                }
                return paVar;
            } catch (Throwable th3) {
                if (!X.a(th3)) {
                    th3.printStackTrace();
                }
                return null;
            }
        }
        X.b("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            C0860e c0860e = new C0860e();
            c0860e.a();
            c0860e.a("utf-8");
            c0860e.a(1);
            c0860e.c("RqdServer");
            c0860e.b("sync");
            c0860e.a("detail", (String) obj);
            return c0860e.b();
        } catch (Throwable th2) {
            if (X.a(th2)) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    public static qa a(byte[] bArr, StrategyBean strategyBean, boolean z10) {
        if (bArr != null) {
            try {
                C0860e c0860e = new C0860e();
                c0860e.a();
                c0860e.a("utf-8");
                c0860e.a(bArr);
                Object b10 = c0860e.b("detail", new qa());
                if (qa.class.isInstance(b10)) {
                    return (qa) qa.class.cast(b10);
                }
                return null;
            } catch (Throwable th2) {
                if (!X.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(AbstractC0868m abstractC0868m) {
        try {
            C0867l c0867l = new C0867l();
            c0867l.a("utf-8");
            abstractC0868m.a(c0867l);
            return c0867l.b();
        } catch (Throwable th2) {
            if (X.a(th2)) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }
}
