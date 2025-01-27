package com.opos.mobad.model.b;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class g extends a {

    /* renamed from: a */
    private ConcurrentHashMap<String, com.opos.mobad.i.b> f21534a = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, com.opos.mobad.i.b> a() {
        return this.f21534a;
    }

    public void a(String str, com.opos.mobad.i.b bVar) {
        this.f21534a.put(str, bVar);
    }

    public String toString() {
        return "FetchMaterialResponse{downloadResponseMap=" + this.f21534a + '}';
    }
}
