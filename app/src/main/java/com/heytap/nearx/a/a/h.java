package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.e;
import com.heytap.nearx.a.a.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class h<E extends i> extends e<E> {
    private final Class<E> r;
    private Method s;

    h(Class<E> cls) {
        super(a.VARINT, cls);
        this.r = cls;
    }

    private Method b() {
        Method method = this.s;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.r.getMethod("fromValue", Integer.TYPE);
            this.s = method2;
            return method2;
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.heytap.nearx.a.a.e
    public int a(E e2) {
        return g.c(e2.a());
    }

    @Override // com.heytap.nearx.a.a.e
    public void a(g gVar, E e2) throws IOException {
        gVar.g(e2.a());
    }

    @Override // com.heytap.nearx.a.a.e
    /* renamed from: b */
    public E a(f fVar) throws IOException {
        int f2 = fVar.f();
        try {
            E e2 = (E) b().invoke(null, Integer.valueOf(f2));
            if (e2 != null) {
                return e2;
            }
            throw new e.a(f2, this.r);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && ((h) obj).r == this.r;
    }

    public int hashCode() {
        return this.r.hashCode();
    }
}
