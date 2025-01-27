package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a */
    final Class<? super T> f8001a;

    /* renamed from: b */
    final Type f8002b;

    /* renamed from: c */
    final int f8003c;

    protected a() {
        Type e2 = e(getClass());
        this.f8002b = e2;
        this.f8001a = (Class<? super T>) C$Gson$Types.m(e2);
        this.f8003c = e2.hashCode();
    }

    private static AssertionError a(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
        for (Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(", ");
        }
        sb.append("but got: ");
        sb.append(type.getClass().getName());
        sb.append(", for type token: ");
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError(sb.toString());
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> c(Type type) {
        return new a<>(type);
    }

    static Type e(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean i(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return j(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    private static boolean j(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> m = C$Gson$Types.m(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeParameters = m.getTypeParameters();
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                Type type2 = actualTypeArguments[i2];
                TypeVariable<Class<?>> typeVariable = typeParameters[i2];
                while (type2 instanceof TypeVariable) {
                    type2 = map.get(((TypeVariable) type2).getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (l(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type3 : m.getGenericInterfaces()) {
            if (j(type3, parameterizedType, new HashMap(map))) {
                return true;
            }
        }
        return j(m.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean k(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    private static boolean l(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            if (!k(actualTypeArguments[i2], actualTypeArguments2[i2], map)) {
                return false;
            }
        }
        return true;
    }

    public final Class<? super T> d() {
        return this.f8001a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.h(this.f8002b, ((a) obj).f8002b);
    }

    @Deprecated
    public boolean f(a<?> aVar) {
        return h(aVar.getType());
    }

    @Deprecated
    public boolean g(Class<?> cls) {
        return h(cls);
    }

    public final Type getType() {
        return this.f8002b;
    }

    @Deprecated
    public boolean h(Type type) {
        if (type == null) {
            return false;
        }
        if (this.f8002b.equals(type)) {
            return true;
        }
        Type type2 = this.f8002b;
        if (type2 instanceof Class) {
            return this.f8001a.isAssignableFrom(C$Gson$Types.m(type));
        }
        if (type2 instanceof ParameterizedType) {
            return j(type, (ParameterizedType) type2, new HashMap());
        }
        if (type2 instanceof GenericArrayType) {
            return this.f8001a.isAssignableFrom(C$Gson$Types.m(type)) && i(type, (GenericArrayType) this.f8002b);
        }
        throw a(type2, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    public final int hashCode() {
        return this.f8003c;
    }

    public final String toString() {
        return C$Gson$Types.v(this.f8002b);
    }

    a(Type type) {
        Type d2 = C$Gson$Types.d((Type) com.google.gson.internal.a.b(type));
        this.f8002b = d2;
        this.f8001a = (Class<? super T>) C$Gson$Types.m(d2);
        this.f8003c = d2.hashCode();
    }
}
