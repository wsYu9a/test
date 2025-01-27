package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private final Map<Type, InstanceCreator<?>> f8057a;

    class a<T> implements com.google.gson.internal.d<T> {
        a() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.b$b */
    class C0109b<T> implements com.google.gson.internal.d<T> {
        C0109b() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new LinkedTreeMap();
        }
    }

    class c<T> implements com.google.gson.internal.d<T> {

        /* renamed from: a */
        private final com.google.gson.internal.g f8060a = com.google.gson.internal.g.a();

        /* renamed from: b */
        final /* synthetic */ Class f8061b;

        /* renamed from: c */
        final /* synthetic */ Type f8062c;

        c(Class cls, Type type) {
            this.f8061b = cls;
            this.f8062c = type;
        }

        @Override // com.google.gson.internal.d
        public T a() {
            try {
                return (T) this.f8060a.b(this.f8061b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f8062c + ". Register an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    class d<T> implements com.google.gson.internal.d<T> {

        /* renamed from: a */
        final /* synthetic */ InstanceCreator f8064a;

        /* renamed from: b */
        final /* synthetic */ Type f8065b;

        d(InstanceCreator instanceCreator, Type type) {
            this.f8064a = instanceCreator;
            this.f8065b = type;
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) this.f8064a.createInstance(this.f8065b);
        }
    }

    class e<T> implements com.google.gson.internal.d<T> {

        /* renamed from: a */
        final /* synthetic */ InstanceCreator f8067a;

        /* renamed from: b */
        final /* synthetic */ Type f8068b;

        e(InstanceCreator instanceCreator, Type type) {
            this.f8067a = instanceCreator;
            this.f8068b = type;
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) this.f8067a.createInstance(this.f8068b);
        }
    }

    class f<T> implements com.google.gson.internal.d<T> {

        /* renamed from: a */
        final /* synthetic */ Constructor f8070a;

        f(Constructor constructor) {
            this.f8070a = constructor;
        }

        @Override // com.google.gson.internal.d
        public T a() {
            try {
                return (T) this.f8070a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f8070a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f8070a + " with no args", e4.getTargetException());
            }
        }
    }

    class g<T> implements com.google.gson.internal.d<T> {
        g() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new TreeSet();
        }
    }

    class h<T> implements com.google.gson.internal.d<T> {

        /* renamed from: a */
        final /* synthetic */ Type f8073a;

        h(Type type) {
            this.f8073a = type;
        }

        @Override // com.google.gson.internal.d
        public T a() {
            Type type = this.f8073a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.f8073a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f8073a.toString());
        }
    }

    class i<T> implements com.google.gson.internal.d<T> {
        i() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    class j<T> implements com.google.gson.internal.d<T> {
        j() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new LinkedList();
        }
    }

    class k<T> implements com.google.gson.internal.d<T> {
        k() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new ArrayList();
        }
    }

    class l<T> implements com.google.gson.internal.d<T> {
        l() {
        }

        @Override // com.google.gson.internal.d
        public T a() {
            return (T) new TreeMap();
        }
    }

    public b(Map<Type, InstanceCreator<?>> map) {
        this.f8057a = map;
    }

    private <T> com.google.gson.internal.d<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new f(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.internal.d<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new g() : EnumSet.class.isAssignableFrom(cls) ? new h(type) : Set.class.isAssignableFrom(cls) ? new i() : Queue.class.isAssignableFrom(cls) ? new j() : new k();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new l() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.b.a.c(((ParameterizedType) type).getActualTypeArguments()[0]).d())) ? new C0109b() : new a();
        }
        return null;
    }

    private <T> com.google.gson.internal.d<T> d(Type type, Class<? super T> cls) {
        return new c(cls, type);
    }

    public <T> com.google.gson.internal.d<T> a(com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> d2 = aVar.d();
        InstanceCreator<?> instanceCreator = this.f8057a.get(type);
        if (instanceCreator != null) {
            return new d(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.f8057a.get(d2);
        if (instanceCreator2 != null) {
            return new e(instanceCreator2, type);
        }
        com.google.gson.internal.d<T> b2 = b(d2);
        if (b2 != null) {
            return b2;
        }
        com.google.gson.internal.d<T> c2 = c(type, d2);
        return c2 != null ? c2 : d(type, d2);
    }

    public String toString() {
        return this.f8057a.toString();
    }
}
