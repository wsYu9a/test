package com.opos.mobad.service.c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Map<Integer, String> f23547a = new ConcurrentHashMap();

    a() {
    }

    private boolean b(Map<Integer, String> map) {
        return map != null && map.size() > 0;
    }

    public void a(Map<Integer, String> map) {
        if (map == null || map.size() <= 0) {
            com.opos.cmn.an.f.a.a("Dynamic-Config", "refreshStrategy dynamic but null map");
            return;
        }
        this.f23547a = new ConcurrentHashMap(map);
        com.opos.cmn.an.f.a.b("Dynamic-Config", "refreshStrategy map = " + this.f23547a);
    }

    public boolean a() {
        Map<Integer, String> map = this.f23547a;
        com.opos.cmn.an.f.a.b("Dynamic-Config", "checkConfigEnable ", map);
        return b(map);
    }

    public boolean a(int i2) {
        Map<Integer, String> map = this.f23547a;
        return map != null && map.containsKey(Integer.valueOf(i2));
    }

    public String b(int i2) {
        Map<Integer, String> map = this.f23547a;
        return (!a(i2) || map == null) ? "" : map.get(Integer.valueOf(i2));
    }

    public String[] b() {
        Map<Integer, String> map = this.f23547a;
        if (!b(map)) {
            return null;
        }
        String[] strArr = new String[map.size()];
        map.values().toArray(strArr);
        return strArr;
    }
}
