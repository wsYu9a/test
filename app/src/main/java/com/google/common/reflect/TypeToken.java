package com.google.common.reflect;

import b5.p;
import b5.u;
import b5.v;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import com.google.common.reflect.a;
import com.google.common.reflect.b;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.n0;
import e5.w;
import e5.z1;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import n5.h;
import o5.k;
import o5.l;
import o5.o;

@o5.d
/* loaded from: classes2.dex */
public abstract class TypeToken<T> extends k<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    @CheckForNull
    private transient com.google.common.reflect.b covariantTypeResolver;

    @CheckForNull
    private transient com.google.common.reflect.b invariantTypeResolver;
    private final Type runtimeType;

    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f10212b.a().c(TypeToken.this.getRawTypes()));
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, e5.n0, e5.y, e5.l0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> F = w.r(f.f10211a.a().d(TypeToken.this)).m(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).F();
            this.classes = F;
            return F;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    public enum TypeFilter implements v<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // b5.v
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // b5.v
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* renamed from: com.google.common.reflect.TypeToken$TypeFilter$1 */
        public enum AnonymousClass1 extends TypeFilter {
            @Override // b5.v
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeFilter$2 */
        public enum AnonymousClass2 extends TypeFilter {
            @Override // b5.v
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }
    }

    public class a extends a.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.a.b, com.google.common.reflect.a
        public Type[] d() {
            return TypeToken.this.getCovariantTypeResolver().l(super.d());
        }

        @Override // com.google.common.reflect.a.b, com.google.common.reflect.a
        public Type[] e() {
            return TypeToken.this.getInvariantTypeResolver().l(super.e());
        }

        @Override // com.google.common.reflect.a.b, com.google.common.reflect.a
        public Type f() {
            return TypeToken.this.getCovariantTypeResolver().j(super.f());
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> g() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(g());
            String aVar = super.toString();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(aVar).length());
            sb2.append(valueOf);
            sb2.append(p1.b.f29697h);
            sb2.append(aVar);
            return sb2.toString();
        }
    }

    public class b extends a.C0303a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.a.C0303a, com.google.common.reflect.a
        public Type[] d() {
            return TypeToken.this.getCovariantTypeResolver().l(super.d());
        }

        @Override // com.google.common.reflect.a.C0303a, com.google.common.reflect.a
        public Type[] e() {
            return TypeToken.this.getInvariantTypeResolver().l(super.e());
        }

        @Override // com.google.common.reflect.a.C0303a, com.google.common.reflect.a
        public Type f() {
            return TypeToken.this.getCovariantTypeResolver().j(super.f());
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> g() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(g());
            String n10 = p.p(", ").n(e());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + String.valueOf(n10).length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(n10);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public class c extends o {
        public c() {
        }

        @Override // o5.o
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // o5.o
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // o5.o
        public void e(TypeVariable<?> typeVariable) {
            String valueOf = String.valueOf(TypeToken.this.runtimeType);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 58);
            sb2.append(valueOf);
            sb2.append("contains a type variable and is not safe for the operation");
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // o5.o
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    public class d extends o {

        /* renamed from: b */
        public final /* synthetic */ ImmutableSet.a f10208b;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f10208b = aVar;
        }

        @Override // o5.o
        public void b(Class<?> cls) {
            this.f10208b.g(cls);
        }

        @Override // o5.o
        public void c(GenericArrayType genericArrayType) {
            this.f10208b.g(Types.h(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // o5.o
        public void d(ParameterizedType parameterizedType) {
            this.f10208b.g((Class) parameterizedType.getRawType());
        }

        @Override // o5.o
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // o5.o
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static class e {

        /* renamed from: a */
        public final Type[] f10209a;

        /* renamed from: b */
        public final boolean f10210b;

        public e(Type[] typeArr, boolean z10) {
            this.f10209a = typeArr;
            this.f10210b = z10;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f10209a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z10 = this.f10210b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f10210b;
        }

        public boolean b(Type type) {
            TypeToken<?> of2 = TypeToken.of(type);
            for (Type type2 : this.f10209a) {
                boolean isSubtypeOf = of2.isSubtypeOf(type2);
                boolean z10 = this.f10210b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f10210b;
        }
    }

    public static abstract class f<K> {

        /* renamed from: a */
        public static final f<TypeToken<?>> f10211a = new a();

        /* renamed from: b */
        public static final f<Class<?>> f10212b = new b();

        public class a extends f<TypeToken<?>> {
            public a() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.f
            @CheckForNull
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        public class b extends f<Class<?>> {
            public b() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.f
            @CheckForNull
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        public class c extends e<K> {
            public c(f fVar, f fVar2) {
                super(fVar2);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a builder = ImmutableList.builder();
                for (K k10 : iterable) {
                    if (!f(k10).isInterface()) {
                        builder.a(k10);
                    }
                }
                return super.c(builder.e());
            }

            @Override // com.google.common.reflect.TypeToken.f.e, com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k10) {
                return ImmutableSet.of();
            }
        }

        public class d extends Ordering<K> {

            /* renamed from: b */
            public final /* synthetic */ Comparator f10213b;

            /* renamed from: c */
            public final /* synthetic */ Map f10214c;

            public d(Comparator comparator, Map map) {
                this.f10213b = comparator;
                this.f10214c = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k10, K k11) {
                Comparator comparator = this.f10213b;
                Object obj = this.f10214c.get(k10);
                Objects.requireNonNull(obj);
                Object obj2 = this.f10214c.get(k11);
                Objects.requireNonNull(obj2);
                return comparator.compare(obj, obj2);
            }
        }

        public static class e<K> extends f<K> {

            /* renamed from: c */
            public final f<K> f10215c;

            public e(f<K> fVar) {
                super(null);
                this.f10215c = fVar;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k10) {
                return this.f10215c.e(k10);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Class<?> f(K k10) {
                return this.f10215c.f(k10);
            }

            @Override // com.google.common.reflect.TypeToken.f
            @CheckForNull
            public K g(K k10) {
                return this.f10215c.g(k10);
            }
        }

        public f() {
        }

        public static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final f<K> a() {
            return new c(this, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public final int b(K k10, Map<? super K, Integer> map) {
            Integer num = map.get(k10);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k10).isInterface();
            Iterator<? extends K> it = e(k10).iterator();
            int i10 = isInterface;
            while (it.hasNext()) {
                i10 = Math.max(i10, b(it.next(), map));
            }
            K g10 = g(k10);
            int i11 = i10;
            if (g10 != null) {
                i11 = Math.max(i10, b(g10, map));
            }
            int i12 = i11 + 1;
            map.put(k10, Integer.valueOf(i12));
            return i12;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap Y = Maps.Y();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), Y);
            }
            return h(Y, Ordering.natural().reverse());
        }

        public final ImmutableList<K> d(K k10) {
            return c(ImmutableList.of(k10));
        }

        public abstract Iterable<? extends K> e(K k10);

        public abstract Class<?> f(K k10);

        @CheckForNull
        public abstract K g(K k10);

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    @CheckForNull
    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of2 = of(type);
            if (of2.getRawType().isInterface()) {
                builder.a(of2);
            }
        }
        return builder.e();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? canonicalizeWildcardType(typeVariable, (WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            actualTypeArguments[i10] = canonicalizeTypeArg(typeParameters[i10], actualTypeArguments[i10]);
        }
        return Types.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        return type instanceof ParameterizedType ? canonicalizeWildcardsInParameterizedType((ParameterizedType) type) : type instanceof GenericArrayType ? Types.j(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 36 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" does not appear to be a subtype of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a super type of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public com.google.common.reflect.b getCovariantTypeResolver() {
        com.google.common.reflect.b bVar = this.covariantTypeResolver;
        if (bVar != null) {
            return bVar;
        }
        com.google.common.reflect.b d10 = com.google.common.reflect.b.d(this.runtimeType);
        this.covariantTypeResolver = d10;
        return d10;
    }

    public com.google.common.reflect.b getInvariantTypeResolver() {
        com.google.common.reflect.b bVar = this.invariantTypeResolver;
        if (bVar != null) {
            return bVar;
        }
        com.google.common.reflect.b f10 = com.google.common.reflect.b.f(this.runtimeType);
        this.invariantTypeResolver = f10;
        return f10;
    }

    @CheckForNull
    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a builder = ImmutableSet.builder();
        new d(this, builder).a(this.runtimeType);
        return builder.e();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a subclass of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of2 = of(type);
            if (of2.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of2.getSupertype(cls);
            }
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a super type of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < typeParameters.length; i10++) {
            if (!of(getCovariantTypeResolver().j(typeParameters[i10])).is(actualTypeArguments[i10], typeParameters[i10])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return h.c().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> of2 = of(getCovariantTypeResolver().j(type));
        of2.covariantTypeResolver = this.covariantTypeResolver;
        of2.invariantTypeResolver = this.invariantTypeResolver;
        return of2;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new com.google.common.reflect.b().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        z1<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @a5.d
    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.j(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(Types.m(type, cls, typeParameters)) : of((Class) cls);
    }

    @a5.a
    public final com.google.common.reflect.a<T, T> constructor(Constructor<?> constructor) {
        u.y(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type i10 = Types.i(this.runtimeType);
        if (i10 == null) {
            return null;
        }
        return of(i10);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a(resolveSupertype(type2));
        }
        return builder.e();
    }

    @CheckForNull
    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        u.u(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        u.y(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        u.y(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        u.y(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        return type instanceof TypeVariable ? getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds()) : type instanceof WildcardType ? getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds()) : cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    @a5.a
    public final com.google.common.reflect.a<T, Object> method(Method method) {
        u.y(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        u.E(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.s(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(h.e((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(l<X> lVar, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new com.google.common.reflect.b().o(ImmutableMap.of(new b.d(lVar.f29063b), typeToken.runtimeType)).j(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(h.f((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new com.google.common.reflect.b().j(this.runtimeType));
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return w.r(f.f10212b.c(TypeToken.this.getRawTypes())).m(new v() { // from class: o5.n
                @Override // b5.v
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).F();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, e5.n0, e5.y, e5.l0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> F = w.r(this.allTypes).m(TypeFilter.INTERFACE_ONLY).F();
            this.interfaces = F;
            return F;
        }
    }

    public class TypeSet extends n0<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f10212b.c(TypeToken.this.getRawTypes()));
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> F = w.r(f.f10211a.d(TypeToken.this)).m(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).F();
            this.types = F;
            return F;
        }
    }

    public TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        u.x0(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        u.E(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = com.google.common.reflect.b.d(cls).j(capture);
        }
    }

    public final <X> TypeToken<T> where(l<X> lVar, Class<X> cls) {
        return where(lVar, of((Class) cls));
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) u.E(type);
    }
}
