package com.vivo.advv.vaf.expr.engine.data;

/* loaded from: classes4.dex */
public abstract class Value {
    protected static ValueCache sValueCache = ValueCache.getInstance();

    @Override // 
    /* renamed from: clone */
    public abstract Value mo79clone();

    public abstract void copy(Value value);

    public abstract Object getValue();

    public abstract Class<?> getValueClass();
}
