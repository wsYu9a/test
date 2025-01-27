package com.opos.cmn.an.g.a.d;

import android.content.Context;
import com.opos.cmn.an.g.a.a.b;
import com.opos.cmn.an.g.c;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a */
    private Map<Long, b> f16484a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.c
    public g a(Context context, long j2, f fVar) throws Exception {
        g gVar;
        if (context == null || fVar == null) {
            gVar = null;
        } else {
            b bVar = new b(context, fVar);
            this.f16484a.put(Long.valueOf(j2), bVar);
            gVar = bVar.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("execute taskCode=");
        sb.append(j2);
        sb.append(",netRequest=");
        sb.append(fVar != null ? fVar.toString() : "null");
        sb.append(",netResponse=");
        sb.append(gVar != null ? gVar.toString() : "null");
        com.opos.cmn.an.f.a.b("HttpsExecutorImpl", sb.toString());
        return gVar;
    }

    @Override // com.opos.cmn.an.g.c
    public void a(long j2) throws Exception {
        com.opos.cmn.an.f.a.b("HttpsExecutorImpl", "shutDown taskCode=" + j2);
        Map<Long, b> map = this.f16484a;
        if (map == null || !map.containsKey(Long.valueOf(j2))) {
            return;
        }
        b bVar = this.f16484a.get(Long.valueOf(j2));
        if (bVar != null) {
            bVar.b();
        }
        this.f16484a.remove(Long.valueOf(j2));
    }
}
