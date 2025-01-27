package com.vivo.mobilead.util;

import com.vivo.mobilead.j.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
public class g0 {
    public static HashMap<Integer, com.vivo.ad.model.t> a(String str) {
        List<com.vivo.ad.model.p> list;
        HashMap<String, List<com.vivo.ad.model.t>> hashMap;
        com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
        HashMap<Integer, com.vivo.ad.model.t> hashMap2 = new HashMap<>();
        if (b2 != null) {
            try {
                if (b2.f29577a != c.C0596c.f28919b && (list = b2.f29580d) != null && list.size() > 0 && (hashMap = b2.f29582f) != null) {
                    Random random = new Random();
                    List<com.vivo.ad.model.t> list2 = hashMap.get(str);
                    if (list2 != null && list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            com.vivo.ad.model.t tVar = list2.get(i2);
                            if (tVar.f26932d > 0.0d && tVar.f26933e > 0.0f && random.nextInt(100) <= tVar.f26932d * 100.0d) {
                                hashMap2.put(Integer.valueOf(tVar.f26929a), tVar);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            Iterator<com.vivo.ad.model.t> it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.vivo.ad.model.t next = it.next();
                                if (next.f26929a == c.a.f28912a.intValue()) {
                                    hashMap2.put(Integer.valueOf(next.f26929a), next);
                                    break;
                                }
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            com.vivo.ad.model.t tVar2 = list2.get(0);
                            hashMap2.put(Integer.valueOf(tVar2.f26929a), tVar2);
                        }
                    }
                }
            } catch (Exception e2) {
                x0.b("PositionHelper", "" + e2.getMessage());
            }
        }
        if (hashMap2.isEmpty()) {
            com.vivo.ad.model.t tVar3 = new com.vivo.ad.model.t();
            int intValue = c.a.f28912a.intValue();
            tVar3.f26929a = intValue;
            tVar3.f26932d = 1.0d;
            tVar3.f26933e = 1.0f;
            tVar3.f26931c = str;
            hashMap2.put(Integer.valueOf(intValue), tVar3);
        }
        return hashMap2;
    }

    public static HashMap<Integer, String> a() {
        com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
        HashMap<Integer, String> hashMap = new HashMap<>();
        if (b2 != null && b2.f29577a != c.C0596c.f28919b) {
            for (com.vivo.ad.model.p pVar : b2.f29580d) {
                hashMap.put(Integer.valueOf(pVar.f26918a), pVar.f26921d);
            }
        }
        return hashMap;
    }

    public static Long a(int i2) {
        HashMap<Integer, Long> hashMap;
        com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
        Long l = com.vivo.mobilead.model.e.l;
        long longValue = l.longValue();
        if (b2 != null && (hashMap = b2.f29584h) != null) {
            Long l2 = hashMap.get(Integer.valueOf(i2));
            if (l2 == null) {
                if (i2 != 9) {
                    if (i2 == 2) {
                        longValue = 1500;
                    } else if (i2 != 3 && i2 != 4 && i2 != 5) {
                        longValue = l.longValue();
                    }
                }
                longValue = 3000;
            } else {
                longValue = l2.longValue();
            }
        }
        return Long.valueOf(longValue);
    }
}
