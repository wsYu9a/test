package com.google.common.reflect;

import b5.u;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import o5.d;
import o5.h;

@a5.a
@d
/* loaded from: classes2.dex */
public abstract class a<T, R> implements AnnotatedElement, Member {

    /* renamed from: a */
    public final AccessibleObject f10224a;

    /* renamed from: b */
    public final Member f10225b;

    /* renamed from: com.google.common.reflect.a$a */
    public static class C0303a<T> extends a<T, T> {

        /* renamed from: c */
        public final Constructor<?> f10226c;

        public C0303a(Constructor<?> constructor) {
            super(constructor);
            this.f10226c = constructor;
        }

        public final boolean F() {
            Class<?> declaringClass = this.f10226c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.a
        public Type[] d() {
            return this.f10226c.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.a
        public Type[] e() {
            Type[] genericParameterTypes = this.f10226c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !F()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f10226c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // com.google.common.reflect.a
        public Type f() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.l(declaringClass, typeParameters) : declaringClass;
        }

        @Override // com.google.common.reflect.a
        public final Annotation[][] h() {
            return this.f10226c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.a
        public final TypeVariable<?>[] k() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f10226c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.a
        public final Object m(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.f10226c.newInstance(objArr);
            } catch (InstantiationException e10) {
                String valueOf = String.valueOf(this.f10226c);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
                sb2.append(valueOf);
                sb2.append(" failed.");
                throw new RuntimeException(sb2.toString(), e10);
            }
        }

        @Override // com.google.common.reflect.a
        public final boolean r() {
            return false;
        }

        @Override // com.google.common.reflect.a
        public final boolean z() {
            return this.f10226c.isVarArgs();
        }
    }

    public static class b<T> extends a<T, Object> {

        /* renamed from: c */
        public final Method f10227c;

        public b(Method method) {
            super(method);
            this.f10227c = method;
        }

        @Override // com.google.common.reflect.a
        public Type[] d() {
            return this.f10227c.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.a
        public Type[] e() {
            return this.f10227c.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.a
        public Type f() {
            return this.f10227c.getGenericReturnType();
        }

        @Override // com.google.common.reflect.a
        public final Annotation[][] h() {
            return this.f10227c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.a
        public final TypeVariable<?>[] k() {
            return this.f10227c.getTypeParameters();
        }

        @Override // com.google.common.reflect.a
        @CheckForNull
        public final Object m(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.f10227c.invoke(obj, objArr);
        }

        @Override // com.google.common.reflect.a
        public final boolean r() {
            return (p() || t() || w() || Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.a
        public final boolean z() {
            return this.f10227c.isVarArgs();
        }
    }

    public <M extends AccessibleObject & Member> a(M m10) {
        u.E(m10);
        this.f10224a = m10;
        this.f10225b = m10;
    }

    public static <T> a<T, T> a(Constructor<T> constructor) {
        return new C0303a(constructor);
    }

    public static a<?, Object> b(Method method) {
        return new b(method);
    }

    public final boolean A() {
        return Modifier.isVolatile(getModifiers());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> a<T, R1> B(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(j())) {
            return this;
        }
        String valueOf = String.valueOf(j());
        String valueOf2 = String.valueOf(typeToken);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 35 + valueOf2.length());
        sb2.append("Invokable is known to return ");
        sb2.append(valueOf);
        sb2.append(", not ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final <R1 extends R> a<T, R1> C(Class<R1> cls) {
        return B(TypeToken.of((Class) cls));
    }

    public final void D(boolean z10) {
        this.f10224a.setAccessible(z10);
    }

    public final boolean E() {
        try {
            this.f10224a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public final ImmutableList<TypeToken<? extends Throwable>> c() {
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type : d()) {
            builder.a(TypeToken.of(type));
        }
        return builder.e();
    }

    public abstract Type[] d();

    public abstract Type[] e();

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g().equals(aVar.g()) && this.f10225b.equals(aVar.f10225b);
    }

    public abstract Type f();

    public TypeToken<T> g() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f10224a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f10224a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f10224a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f10225b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f10225b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f10225b.getName();
    }

    public abstract Annotation[][] h();

    public int hashCode() {
        return this.f10225b.hashCode();
    }

    public final ImmutableList<h> i() {
        Type[] e10 = e();
        Annotation[][] h10 = h();
        ImmutableList.a builder = ImmutableList.builder();
        for (int i10 = 0; i10 < e10.length; i10++) {
            builder.a(new h(this, i10, TypeToken.of(e10[i10]), h10[i10]));
        }
        return builder.e();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f10224a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f10225b.isSynthetic();
    }

    public final TypeToken<? extends R> j() {
        return (TypeToken<? extends R>) TypeToken.of(f());
    }

    public abstract TypeVariable<?>[] k();

    @CanIgnoreReturnValue
    @CheckForNull
    public final R l(@CheckForNull T t10, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return (R) m(t10, (Object[]) u.E(objArr));
    }

    @CheckForNull
    public abstract Object m(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public final boolean n() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean o() {
        return this.f10224a.isAccessible();
    }

    public final boolean p() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean q() {
        return Modifier.isNative(getModifiers());
    }

    public abstract boolean r();

    public final boolean s() {
        return (t() || v() || u()) ? false : true;
    }

    public final boolean t() {
        return Modifier.isPrivate(getModifiers());
    }

    public String toString() {
        return this.f10225b.toString();
    }

    public final boolean u() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean v() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean w() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean x() {
        return Modifier.isSynchronized(getModifiers());
    }

    public final boolean y() {
        return Modifier.isTransient(getModifiers());
    }

    public abstract boolean z();
}
