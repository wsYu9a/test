package com.martian.ttbook.b.c.a.a.b.a.d;

import com.martian.ttbook.b.c.a.a.b.a.a;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.c.l.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class e extends a implements b {
    protected Map<String, Object> l;

    public e(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar);
        HashMap hashMap = new HashMap();
        this.l = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public Map<String, Object> a() {
        return this.l;
    }

    public void a(int i2, int i3, String str) {
    }

    public void c(c cVar) {
    }

    public void sendWinNotification(int i2) {
    }
}
