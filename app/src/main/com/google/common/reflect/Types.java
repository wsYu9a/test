package com.google.common.reflect;

import b5.n;
import b5.p;
import b5.r;
import b5.u;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.Types;
import e5.u0;
import e5.z1;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import o5.j;
import o5.k;
import o5.o;
import okhttp3.HttpUrl;

@o5.d
/* loaded from: classes2.dex */
public final class Types {

    /* renamed from: a */
    public static final p f10216a = p.p(", ").s("null");

    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };

        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$1 */
        public enum AnonymousClass1 extends ClassOwnership {
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            public Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$2 */
        public enum AnonymousClass2 extends ClassOwnership {
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            public Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        public class a<T> {
        }

        public class b extends a<String> {
        }

        private static ClassOwnership detectJvmBehavior() {
            new b();
            ParameterizedType parameterizedType = (ParameterizedType) b.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(a.class) == parameterizedType2.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        @CheckForNull
        public abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(a aVar) {
            this();
        }
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof GenericArrayType) {
                return r.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return String.valueOf(Types.s(this.componentType)).concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
    }

    public static abstract class JavaVersion extends Enum<JavaVersion> {
        private static final /* synthetic */ JavaVersion[] $VALUES = $values();
        static final JavaVersion CURRENT;
        public static final JavaVersion JAVA6;
        public static final JavaVersion JAVA7;
        public static final JavaVersion JAVA8;
        public static final JavaVersion JAVA9;

        /* renamed from: com.google.common.reflect.Types$JavaVersion$1 */
        public enum AnonymousClass1 extends JavaVersion {
            public AnonymousClass1(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                u.E(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$2 */
        public enum AnonymousClass2 extends JavaVersion {
            public AnonymousClass2(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return type instanceof Class ? Types.h((Class) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return (Type) u.E(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$3 */
        public enum AnonymousClass3 extends JavaVersion {
            public AnonymousClass3(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$4 */
        public enum AnonymousClass4 extends JavaVersion {
            public AnonymousClass4(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type newArrayType(Type type) {
                return JavaVersion.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        }

        public class a extends k<Map.Entry<String, int[][]>> {
        }

        public class b extends k<int[]> {
        }

        private static /* synthetic */ JavaVersion[] $values() {
            return new JavaVersion[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        static {
            AnonymousClass1 anonymousClass1 = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.1
                public AnonymousClass1(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    u.E(type);
                    if (!(type instanceof Class)) {
                        return type;
                    }
                    Class cls = (Class) type;
                    return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public GenericArrayType newArrayType(Type type) {
                    return new GenericArrayTypeImpl(type);
                }
            };
            JAVA6 = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.2
                public AnonymousClass2(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    return type instanceof Class ? Types.h((Class) type) : new GenericArrayTypeImpl(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    return (Type) u.E(type);
                }
            };
            JAVA7 = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.3
                public AnonymousClass3(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    return JavaVersion.JAVA7.newArrayType(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public String typeName(Type type) {
                    try {
                        return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
                    } catch (IllegalAccessException e10) {
                        throw new RuntimeException(e10);
                    } catch (NoSuchMethodException unused) {
                        throw new AssertionError("Type.getTypeName should be available in Java 8");
                    } catch (InvocationTargetException e11) {
                        throw new RuntimeException(e11);
                    }
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    return JavaVersion.JAVA7.usedInGenericType(type);
                }
            };
            JAVA8 = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.4
                public AnonymousClass4(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public boolean jdkTypeDuplicatesOwnerName() {
                    return false;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    return JavaVersion.JAVA8.newArrayType(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public String typeName(Type type) {
                    return JavaVersion.JAVA8.typeName(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    return JavaVersion.JAVA8.usedInGenericType(type);
                }
            };
            JAVA9 = anonymousClass4;
            $VALUES = $values();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = anonymousClass3;
                    return;
                } else {
                    CURRENT = anonymousClass4;
                    return;
                }
            }
            if (new b().capture() instanceof Class) {
                CURRENT = anonymousClass2;
            } else {
                CURRENT = anonymousClass1;
            }
        }

        private JavaVersion(String str, int i10) {
            super(str, i10);
        }

        public static JavaVersion valueOf(String str) {
            return (JavaVersion) Enum.valueOf(JavaVersion.class, str);
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) $VALUES.clone();
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            return Types.s(type);
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a(usedInGenericType(type));
            }
            return builder.e();
        }

        public abstract Type usedInGenericType(Type type);

        public /* synthetic */ JavaVersion(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;

        @CheckForNull
        private final Type ownerType;
        private final Class<?> rawType;

        public ParameterizedTypeImpl(@CheckForNull Type type, Class<?> cls, Type[] typeArr) {
            u.E(cls);
            u.d(typeArr.length == cls.getTypeParameters().length);
            Types.f(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && r.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.r(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        @CheckForNull
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.ownerType != null) {
                JavaVersion javaVersion = JavaVersion.CURRENT;
                if (javaVersion.jdkTypeDuplicatesOwnerName()) {
                    sb2.append(javaVersion.typeName(this.ownerType));
                    sb2.append('.');
                }
            }
            sb2.append(this.rawType.getName());
            sb2.append(Typography.less);
            p pVar = Types.f10216a;
            ImmutableList<Type> immutableList = this.argumentsList;
            JavaVersion javaVersion2 = JavaVersion.CURRENT;
            Objects.requireNonNull(javaVersion2);
            sb2.append(pVar.k(u0.U(immutableList, new n() { // from class: com.google.common.reflect.c
                public /* synthetic */ c() {
                }

                @Override // b5.n
                public final Object apply(Object obj) {
                    return Types.JavaVersion.this.typeName((Type) obj);
                }
            })));
            sb2.append(Typography.greater);
            return sb2.toString();
        }
    }

    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.f(typeArr, "lower bound for wildcard");
            Types.f(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.CURRENT;
            this.lowerBounds = javaVersion.usedInGenericType(typeArr);
            this.upperBounds = javaVersion.usedInGenericType(typeArr2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.r(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.r(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("?");
            z1<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                Type next = it.next();
                sb2.append(" super ");
                sb2.append(JavaVersion.CURRENT.typeName(next));
            }
            for (Type type : Types.g(this.upperBounds)) {
                sb2.append(" extends ");
                sb2.append(JavaVersion.CURRENT.typeName(type));
            }
            return sb2.toString();
        }
    }

    public class a extends o {

        /* renamed from: b */
        public final /* synthetic */ AtomicReference f10217b;

        public a(AtomicReference atomicReference) {
            this.f10217b = atomicReference;
        }

        @Override // o5.o
        public void b(Class<?> cls) {
            this.f10217b.set(cls.getComponentType());
        }

        @Override // o5.o
        public void c(GenericArrayType genericArrayType) {
            this.f10217b.set(genericArrayType.getGenericComponentType());
        }

        @Override // o5.o
        public void e(TypeVariable<?> typeVariable) {
            this.f10217b.set(Types.p(typeVariable.getBounds()));
        }

        @Override // o5.o
        public void f(WildcardType wildcardType) {
            this.f10217b.set(Types.p(wildcardType.getUpperBounds()));
        }
    }

    public static final class b<X> {

        /* renamed from: a */
        public static final boolean f10218a = !b.class.getTypeParameters()[0].equals(Types.k(b.class, "X", new Type[0]));
    }

    public static final class c<D extends GenericDeclaration> {

        /* renamed from: a */
        public final D f10219a;

        /* renamed from: b */
        public final String f10220b;

        /* renamed from: c */
        public final ImmutableList<Type> f10221c;

        public c(D d10, String str, Type[] typeArr) {
            Types.f(typeArr, "bound for type variable");
            this.f10219a = (D) u.E(d10);
            this.f10220b = (String) u.E(str);
            this.f10221c = ImmutableList.copyOf(typeArr);
        }

        public Type[] a() {
            return Types.r(this.f10221c);
        }

        public D b() {
            return this.f10219a;
        }

        public String c() {
            return this.f10220b;
        }

        public String d() {
            return this.f10220b;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!b.f10218a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f10220b.equals(typeVariable.getName()) && this.f10219a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof d)) {
                return false;
            }
            c cVar = ((d) Proxy.getInvocationHandler(obj)).f10223b;
            return this.f10220b.equals(cVar.c()) && this.f10219a.equals(cVar.b()) && this.f10221c.equals(cVar.f10221c);
        }

        public int hashCode() {
            return this.f10219a.hashCode() ^ this.f10220b.hashCode();
        }

        public String toString() {
            return this.f10220b;
        }
    }

    public static final class d implements InvocationHandler {

        /* renamed from: c */
        public static final ImmutableMap<String, Method> f10222c;

        /* renamed from: b */
        public final c<?> f10223b;

        static {
            ImmutableMap.b builder = ImmutableMap.builder();
            for (Method method : c.class.getMethods()) {
                if (method.getDeclaringClass().equals(c.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.i(method.getName(), method);
                }
            }
            f10222c = builder.c();
        }

        public d(c<?> cVar) {
            this.f10223b = cVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f10222c.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f10223b, objArr);
            } catch (InvocationTargetException e10) {
                throw e10.getCause();
            }
        }
    }

    public static void f(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                u.y(!r2.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    public static Iterable<Type> g(Iterable<Type> iterable) {
        return u0.o(iterable, Predicates.q(Predicates.m(Object.class)));
    }

    public static Class<?> h(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    @CheckForNull
    public static Type i(Type type) {
        u.E(type);
        AtomicReference atomicReference = new AtomicReference();
        new a(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type j(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        u.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        u.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    public static <D extends GenericDeclaration> TypeVariable<D> k(D d10, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(d10, str, typeArr);
    }

    public static ParameterizedType l(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    public static ParameterizedType m(@CheckForNull Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return l(cls, typeArr);
        }
        u.E(typeArr);
        u.u(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> n(D d10, String str, Type[] typeArr) {
        return (TypeVariable) j.d(TypeVariable.class, new d(new c(d10, str, typeArr)));
    }

    @a5.d
    public static WildcardType o(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    @CheckForNull
    public static Type p(Type[] typeArr) {
        for (Type type : typeArr) {
            Type i10 = i(type);
            if (i10 != null) {
                if (i10 instanceof Class) {
                    Class cls = (Class) i10;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(i10);
            }
        }
        return null;
    }

    @a5.d
    public static WildcardType q(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    public static Type[] r(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
