package com.opos.cmn.an.g.a.b;

import android.content.Context;
import com.opos.cmn.an.g.b;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a */
    private Map<Long, com.opos.cmn.an.g.a.a.b> f16483a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.b
    public g a(Context context, long j2, f fVar) throws Exception {
        g gVar;
        if (context == null || fVar == null) {
            gVar = null;
        } else {
            com.opos.cmn.an.g.a.a.b bVar = new com.opos.cmn.an.g.a.a.b(context, fVar);
            this.f16483a.put(Long.valueOf(j2), bVar);
            gVar = bVar.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("execute taskCode=");
        sb.append(j2);
        sb.append(",netRequest=");
        sb.append(fVar != null ? fVar.toString() : "null");
        sb.append(",netResponse=");
        sb.append(gVar != null ? gVar.toString() : "null");
        com.opos.cmn.an.f.a.b("HttpExecutorImpl", sb.toString());
        return gVar;
    }

    @Override // com.opos.cmn.an.g.b
    public void a(long j2) throws Exception {
        com.opos.cmn.an.f.a.b("HttpExecutorImpl", "shutDown taskCode=" + j2);
        Map<Long, com.opos.cmn.an.g.a.a.b> map = this.f16483a;
        if (map == null || !map.containsKey(Long.valueOf(j2))) {
            return;
        }
        com.opos.cmn.an.g.a.a.b bVar = this.f16483a.get(Long.valueOf(j2));
        if (bVar != null) {
            bVar.b();
        }
        this.f16483a.remove(Long.valueOf(j2));
    }
}
