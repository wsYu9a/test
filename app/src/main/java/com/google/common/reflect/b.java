package com.google.common.reflect;

import b5.p;
import b5.r;
import b5.u;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import o5.o;

@o5.d
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final c f10228a;

    public class a extends o {

        /* renamed from: b */
        public final /* synthetic */ Map f10229b;

        /* renamed from: c */
        public final /* synthetic */ Type f10230c;

        public a(Map map, Type type) {
            this.f10229b = map;
            this.f10230c = type;
        }

        @Override // o5.o
        public void b(Class<?> cls) {
            if (this.f10230c instanceof WildcardType) {
                return;
            }
            String valueOf = String.valueOf(cls);
            String valueOf2 = String.valueOf(this.f10230c);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25 + valueOf2.length());
            sb2.append("No type mapping from ");
            sb2.append(valueOf);
            sb2.append(" to ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // o5.o
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f10230c;
            if (type instanceof WildcardType) {
                return;
            }
            Type i10 = Types.i(type);
            u.u(i10 != null, "%s is not an array type.", this.f10230c);
            b.g(this.f10229b, genericArrayType.getGenericComponentType(), i10);
        }

        @Override // o5.o
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f10230c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) b.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                b.g(this.f10229b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            u.y(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f10230c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            u.y(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                b.g(this.f10229b, actualTypeArguments[i10], actualTypeArguments2[i10]);
            }
        }

        @Override // o5.o
        public void e(TypeVariable<?> typeVariable) {
            this.f10229b.put(new d(typeVariable), this.f10230c);
        }

        @Override // o5.o
        public void f(WildcardType wildcardType) {
            Type type = this.f10230c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                u.y(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f10230c);
                for (int i10 = 0; i10 < upperBounds.length; i10++) {
                    b.g(this.f10229b, upperBounds[i10], upperBounds2[i10]);
                }
                for (int i11 = 0; i11 < lowerBounds.length; i11++) {
                    b.g(this.f10229b, lowerBounds[i11], lowerBounds2[i11]);
                }
            }
        }
    }

    /* renamed from: com.google.common.reflect.b$b */
    public static final class C0304b extends o {

        /* renamed from: b */
        public final Map<d, Type> f10231b = Maps.Y();

        public static ImmutableMap<d, Type> g(Type type) {
            u.E(type);
            C0304b c0304b = new C0304b();
            c0304b.a(type);
            return ImmutableMap.copyOf((Map) c0304b.f10231b);
        }

        @Override // o5.o
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // o5.o
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            u.g0(typeParameters.length == actualTypeArguments.length);
            for (int i10 = 0; i10 < typeParameters.length; i10++) {
                h(new d(typeParameters[i10]), actualTypeArguments[i10]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // o5.o
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // o5.o
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.f10231b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f10231b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f10231b.get(d.c(type2));
            }
            this.f10231b.put(dVar, type);
        }
    }

    public static final class d {

        /* renamed from: a */
        public final TypeVariable<?> f10235a;

        public d(TypeVariable<?> typeVariable) {
            this.f10235a = (TypeVariable) u.E(typeVariable);
        }

        @CheckForNull
        public static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            return this.f10235a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f10235a.getName().equals(typeVariable.getName());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f10235a);
            }
            return false;
        }

        public int hashCode() {
            return r.b(this.f10235a.getGenericDeclaration(), this.f10235a.getName());
        }

        public String toString() {
            return this.f10235a.toString();
        }
    }

    public static class e {

        /* renamed from: b */
        public static final e f10236b = new e();

        /* renamed from: a */
        public final AtomicInteger f10237a;

        public class a extends e {

            /* renamed from: c */
            public final /* synthetic */ TypeVariable f10238c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f10238c = typeVariable;
            }

            @Override // com.google.common.reflect.b.e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f10238c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            u.E(type);
            if (type instanceof Class) {
                return type;
            }
            if (type instanceof TypeVariable) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                actualTypeArguments[i10] = d(typeParameters[i10]).a(actualTypeArguments[i10]);
            }
            return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable<?> b(Type[] typeArr) {
            int incrementAndGet = this.f10237a.incrementAndGet();
            String n10 = p.o(Typography.amp).n(typeArr);
            StringBuilder sb2 = new StringBuilder(String.valueOf(n10).length() + 33);
            sb2.append("capture#");
            sb2.append(incrementAndGet);
            sb2.append("-of ? extends ");
            sb2.append(n10);
            return Types.k(e.class, sb2.toString(), typeArr);
        }

        @CheckForNull
        public final Type c(@CheckForNull Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f10237a, typeVariable);
        }

        public final e e() {
            return new e(this.f10237a);
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger atomicInteger) {
            this.f10237a = atomicInteger;
        }
    }

    public /* synthetic */ b(c cVar, a aVar) {
        this(cVar);
    }

    public static b d(Type type) {
        return new b().o(C0304b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(obj);
            String simpleName = cls.getSimpleName();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10 + simpleName.length());
            sb2.append(valueOf);
            sb2.append(" is not a ");
            sb2.append(simpleName);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static b f(Type type) {
        return new b().o(C0304b.g(e.f10236b.a(type)));
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        u.E(type);
        return type instanceof TypeVariable ? this.f10228a.a((TypeVariable) type) : type instanceof ParameterizedType ? i((ParameterizedType) type) : type instanceof GenericArrayType ? h((GenericArrayType) type) : type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr2[i10] = j(typeArr[i10]);
        }
        return typeArr2;
    }

    public Type[] l(Type[] typeArr) {
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr[i10] = j(typeArr[i10]);
        }
        return typeArr;
    }

    public final WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public b n(Type type, Type type2) {
        HashMap Y = Maps.Y();
        g(Y, (Type) u.E(type), (Type) u.E(type2));
        return o(Y);
    }

    public b o(Map<d, ? extends Type> map) {
        return new b(this.f10228a.c(map));
    }

    public static class c {

        /* renamed from: a */
        public final ImmutableMap<d, Type> f10232a;

        public class a extends c {

            /* renamed from: b */
            public final /* synthetic */ TypeVariable f10233b;

            /* renamed from: c */
            public final /* synthetic */ c f10234c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f10233b = typeVariable;
                this.f10234c = cVar2;
            }

            @Override // com.google.common.reflect.b.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f10233b.getGenericDeclaration()) ? typeVariable : this.f10234c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f10232a = ImmutableMap.of();
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f10232a.get(new d(typeVariable));
            if (type != null) {
                return new b(cVar, null).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] k10 = new b(cVar, null).k(bounds);
            return (Types.b.f10218a && Arrays.equals(bounds, k10)) ? typeVariable : Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), k10);
        }

        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.l(this.f10232a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                u.u(!key.a(value), "Type variable %s bound to itself", key);
                builder.i(key, value);
            }
            return new c(builder.d());
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.f10232a = immutableMap;
        }
    }

    public b() {
        this.f10228a = new c();
    }

    public b(c cVar) {
        this.f10228a = cVar;
    }
}
