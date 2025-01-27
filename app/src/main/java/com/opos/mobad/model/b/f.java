package com.opos.mobad.model.b;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class f extends a {

    /* renamed from: a */
    private ConcurrentHashMap<String, com.opos.mobad.i.a> f21533a;

    public ConcurrentHashMap<String, com.opos.mobad.i.a> a() {
        return this.f21533a;
    }

    public void a(ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap) {
        this.f21533a = concurrentHashMap;
    }

    public String toString() {
        return "FetchMaterialRequest{downloadRequestMap=" + this.f21533a + '}';
    }
}
