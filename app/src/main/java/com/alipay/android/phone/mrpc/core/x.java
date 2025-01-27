package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a */
    public g f6423a;

    /* renamed from: b */
    public z f6424b = new z(this);

    public x(g gVar) {
        this.f6423a = gVar;
    }

    public final g a() {
        return this.f6423a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f6423a, cls, this.f6424b));
    }
}
