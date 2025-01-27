package com.czhj.wire;

import com.czhj.wire.WireEnum;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {

    /* renamed from: a */
    public final Class<E> f8877a;

    /* renamed from: b */
    public Method f8878b;

    public RuntimeEnumAdapter(Class<E> cls) {
        super(cls);
        this.f8877a = cls;
    }

    public final Method c() {
        Method method = this.f8878b;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.f8877a.getMethod("fromValue", Integer.TYPE);
            this.f8878b = method2;
            return method2;
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).f8877a == this.f8877a;
    }

    @Override // com.czhj.wire.EnumAdapter
    public E fromValue(int i10) {
        try {
            return (E) c().invoke(null, Integer.valueOf(i10));
        } catch (Throwable th2) {
            throw new AssertionError(th2);
        }
    }

    public int hashCode() {
        return this.f8877a.hashCode();
    }
}
