package com.vivo.mobilead.i;

import com.vivo.mobilead.util.w0;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class r implements Callable<com.vivo.mobilead.model.e> {

    /* renamed from: a */
    private f f28906a;

    /* renamed from: b */
    private p f28907b;

    public r(String str, p pVar) {
        this.f28907b = pVar;
        HashMap hashMap = new HashMap();
        hashMap.put("mediaId", str);
        hashMap.put("orientationSplash", String.valueOf(w0.c()));
        this.f28906a = new f(2, com.vivo.mobilead.model.a.f29552b, hashMap, null, new com.vivo.mobilead.j.d());
    }

    @Override // java.util.concurrent.Callable
    public com.vivo.mobilead.model.e call() throws Exception {
        try {
            com.vivo.mobilead.model.e eVar = (com.vivo.mobilead.model.e) new b(this.f28906a).a();
            p pVar = this.f28907b;
            if (pVar != null) {
                pVar.a(eVar);
            }
            return eVar;
        } catch (c e2) {
            p pVar2 = this.f28907b;
            if (pVar2 == null) {
                return null;
            }
            pVar2.a(e2.a(), e2.b());
            return null;
        }
    }
}
