package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private HashMap<Integer, e.a> f20624a = new HashMap<>();

    public j(List<e.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e.a aVar : list) {
            this.f20624a.put(Integer.valueOf(aVar.f23520a), aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r5 != 6) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.opos.mobad.ad.b> void a(int r9, java.util.Map<java.lang.Integer, T> r10) {
        /*
            r8 = this;
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L8:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L84
            java.lang.Object r0 = r10.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            if (r0 == 0) goto L8
            java.lang.Object r1 = r0.getValue()
            com.opos.mobad.ad.b r1 = (com.opos.mobad.ad.b) r1
            if (r1 == 0) goto L8
            java.lang.Object r2 = r0.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 0
            java.lang.String r4 = "delegator"
            if (r9 != r2) goto L49
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "notify win "
            r2.append(r5)
            java.lang.Object r0 = r0.getKey()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.opos.cmn.an.f.a.b(r4, r0)
            r1.b(r3)
            goto L8
        L49:
            r2 = 4
            int r5 = r1.d()
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L5e
            if (r5 == r7) goto L5c
            if (r5 == r6) goto L5a
            r7 = 6
            if (r5 == r7) goto L5c
            goto L5f
        L5a:
            r2 = 1
            goto L5f
        L5c:
            r2 = 2
            goto L5f
        L5e:
            r2 = 3
        L5f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "notify loss "
            r5.append(r6)
            java.lang.Object r0 = r0.getKey()
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            r5.append(r2)
            java.lang.String r0 = r5.toString()
            com.opos.cmn.an.f.a.b(r4, r0)
            r0 = 0
            r1.a(r2, r0, r3)
            goto L8
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a.j.a(int, java.util.Map):void");
    }

    public <T extends com.opos.mobad.ad.b> e.a a(Map<Integer, T> map) {
        T value;
        int i2 = 0;
        int i3 = -1;
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.e()) {
                int f2 = value.f();
                if (f2 <= 0) {
                    com.opos.cmn.an.f.a.b("delegator", "bidding channel:" + entry.getKey() + "real fail, use default");
                    e.a aVar = this.f20624a.get(entry.getKey());
                    if (aVar != null) {
                        f2 = aVar.f23526g;
                    }
                }
                if (f2 <= 0) {
                    com.opos.cmn.an.f.a.b("delegator", "biding with fail result");
                    return null;
                }
                if (i2 > f2) {
                    com.opos.cmn.an.f.a.b("delegator", "biding fail by compare:" + entry.getKey());
                } else if (i2 != f2) {
                    i3 = entry.getKey().intValue();
                    i2 = f2;
                } else if (entry.getKey().intValue() == 1) {
                    i3 = entry.getKey().intValue();
                }
            }
        }
        com.opos.cmn.an.f.a.b("delegator", "biding result:" + i3);
        if (i3 == -1) {
            return null;
        }
        a(i3, map);
        return this.f20624a.get(Integer.valueOf(i3));
    }
}
