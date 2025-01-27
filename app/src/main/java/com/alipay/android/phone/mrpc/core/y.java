package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a */
    public g f6425a;

    /* renamed from: b */
    public Class<?> f6426b;

    /* renamed from: c */
    public z f6427c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f6425a = gVar;
        this.f6426b = cls;
        this.f6427c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f6427c.a(method, objArr);
    }
}
