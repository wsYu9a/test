package com.vivo.mobilead.i;

import java.util.Map;

/* loaded from: classes4.dex */
public class h extends k<a> {

    /* renamed from: f */
    private static byte[] f28895f = new byte[0];

    /* renamed from: e */
    private String f28896e;

    public static class a {

        /* renamed from: a */
        public Boolean f28897a;
    }

    public h(String str, d dVar) {
        super(1, str, dVar);
        this.f28896e = str;
    }

    @Override // com.vivo.mobilead.i.k
    public Map<String, String> b() {
        return null;
    }

    @Override // com.vivo.mobilead.i.k
    public a a(e eVar) {
        a aVar;
        synchronized (f28895f) {
            aVar = new a();
            aVar.f28897a = Boolean.valueOf(com.vivo.mobilead.h.b.a().b(this.f28896e, eVar.f28890a));
        }
        return aVar;
    }
}
