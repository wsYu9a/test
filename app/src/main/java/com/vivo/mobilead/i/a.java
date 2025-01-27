package com.vivo.mobilead.i;

import java.util.Map;

/* loaded from: classes4.dex */
public class a extends k<Boolean> {

    /* renamed from: f */
    private static byte[] f28885f = new byte[0];

    /* renamed from: e */
    private String f28886e;

    public a(String str, d dVar) {
        super(1, str, dVar);
        this.f28886e = str;
    }

    @Override // com.vivo.mobilead.i.k
    public Map<String, String> b() {
        return null;
    }

    @Override // com.vivo.mobilead.i.k
    public Boolean a(e eVar) {
        Boolean valueOf;
        synchronized (f28885f) {
            valueOf = Boolean.valueOf(com.vivo.mobilead.h.b.a().a(this.f28886e, eVar.f28890a));
        }
        return valueOf;
    }
}
