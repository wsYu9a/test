package com.aggmoread.sdk.z.d.a.a.d.a.d;

import com.aggmoread.sdk.client.AMConst;
import java.util.Map;

/* loaded from: classes.dex */
public class l {
    public void a(Map<String, Object> map, int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (map != null) {
            int a10 = com.aggmoread.sdk.z.d.a.a.e.m.a(i10, eVar);
            com.aggmoread.sdk.z.d.a.a.e.e.a("add extras  e " + i10 + ", expose  " + a10);
            map.put(AMConst.ExtrasKey.AD_PRICE, String.valueOf(a10));
        }
    }
}
