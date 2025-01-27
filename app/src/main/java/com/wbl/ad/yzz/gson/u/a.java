package com.wbl.ad.yzz.gson.u;

import com.wbl.ad.yzz.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public class a<T> {

    /* renamed from: a */
    public final Class<? super T> f32382a;

    /* renamed from: b */
    public final Type f32383b;

    /* renamed from: c */
    public final int f32384c;

    public a() {
        Type b2 = b(getClass());
        this.f32383b = b2;
        this.f32382a = (Class<? super T>) C$Gson$Types.e(b2);
        this.f32384c = b2.hashCode();
    }

    public static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.f32382a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.f32383b, ((a) obj).f32383b);
    }

    public final Type getType() {
        return this.f32383b;
    }

    public final int hashCode() {
        return this.f32384c;
    }

    public final String toString() {
        return C$Gson$Types.h(this.f32383b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public a(Type type) {
        Type b2 = C$Gson$Types.b((Type) com.wbl.ad.yzz.gson.t.a.a(type));
        this.f32383b = b2;
        this.f32382a = (Class<? super T>) C$Gson$Types.e(b2);
        this.f32384c = b2.hashCode();
    }
}
