package com.martian.ttbook.b.c.a.a.b.a.d;

import com.martian.ttbook.sdk.client.AdExtras;
import java.util.Map;

/* loaded from: classes4.dex */
public class m {
    public void a(Map<String, Object> map, int i2, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        if (map != null) {
            int a2 = com.martian.ttbook.b.c.a.a.e.i.a(i2, eVar);
            com.martian.ttbook.b.c.a.a.e.d.a("add extras  e " + i2 + ", expose  " + a2);
            map.put(AdExtras.EXTRA_ECPM, String.valueOf(a2));
        }
    }
}
