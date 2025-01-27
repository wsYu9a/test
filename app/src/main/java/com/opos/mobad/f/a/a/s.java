package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class s {

    /* renamed from: a */
    private HashMap<Integer, e.a> f20630a = new HashMap<>();

    public s(List<e.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e.a aVar : list) {
            this.f20630a.put(Integer.valueOf(aVar.f23520a), aVar);
        }
    }

    private <T extends com.opos.mobad.ad.g> void a(List<T> list) {
        for (T t : list) {
            if (t != null) {
                t.b(0);
            }
        }
    }

    private <T extends com.opos.mobad.ad.g> void a(List<T> list, int i2) {
        for (T t : list) {
            if (t != null) {
                t.a(i2, null, 0);
            }
        }
    }

    public <T extends com.opos.mobad.ad.g> e.a a(HashMap<Integer, List<T>> hashMap) {
        List<T> value;
        T t;
        e.a aVar;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        for (Map.Entry<Integer, List<T>> entry : hashMap.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.size() > 0 && (t = value.get(0)) != null) {
                int f2 = t.f();
                if (f2 <= 0 && (aVar = this.f20630a.get(entry.getKey())) != null) {
                    f2 = aVar.f23526g;
                }
                if (f2 <= 0) {
                    com.opos.cmn.an.f.a.b("delegator", "biding with fail result");
                    return null;
                }
                if (i3 > f2) {
                    com.opos.cmn.an.f.a.b("delegator", "biding fail by compare:" + entry.getKey());
                } else if (i3 != f2) {
                    i2 = entry.getKey().intValue();
                    i3 = f2;
                } else if (entry.getKey().intValue() == 1) {
                    i2 = entry.getKey().intValue();
                }
            }
        }
        com.opos.cmn.an.f.a.b("delegator", "biding result:" + i2);
        if (i2 == -1) {
            return null;
        }
        a(i2, hashMap);
        return this.f20630a.get(Integer.valueOf(i2));
    }

    public <T extends com.opos.mobad.ad.g> void a(int i2, HashMap<Integer, List<T>> hashMap) {
        List<T> value;
        for (Map.Entry<Integer, List<T>> entry : hashMap.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.size() > 0) {
                if (i2 == entry.getKey().intValue()) {
                    com.opos.cmn.an.f.a.b("delegator", "notify win " + i2);
                    a(value);
                } else {
                    com.opos.cmn.an.f.a.b("delegator", "notify loss " + entry.getKey() + ":1");
                    a(value, 1);
                }
            }
        }
    }
}
