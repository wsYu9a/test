package com.wbl.ad.yzz.gson.t;

import com.wbl.ad.yzz.gson.JsonIOException;
import com.wbl.ad.yzz.gson.internal.LinkedTreeMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public final Map<Type, com.wbl.ad.yzz.gson.g<?>> f32268a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.gson.t.l.b f32269b = com.wbl.ad.yzz.gson.t.l.b.a();

    public class a<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public a(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.t.b$b */
    public class C0724b<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public C0724b(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new TreeMap();
        }
    }

    public class c<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public c(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    public class d<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public d(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new LinkedTreeMap();
        }
    }

    public class e<T> implements com.wbl.ad.yzz.gson.t.f<T> {

        /* renamed from: a */
        public final com.wbl.ad.yzz.gson.t.j f32270a = com.wbl.ad.yzz.gson.t.j.a();

        /* renamed from: b */
        public final /* synthetic */ Class f32271b;

        /* renamed from: c */
        public final /* synthetic */ Type f32272c;

        public e(b bVar, Class cls, Type type) {
            this.f32271b = cls;
            this.f32272c = type;
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            try {
                return (T) this.f32270a.b(this.f32271b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f32272c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    public class f<T> implements com.wbl.ad.yzz.gson.t.f<T> {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.gson.g f32273a;

        /* renamed from: b */
        public final /* synthetic */ Type f32274b;

        public f(b bVar, com.wbl.ad.yzz.gson.g gVar, Type type) {
            this.f32273a = gVar;
            this.f32274b = type;
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) this.f32273a.a(this.f32274b);
        }
    }

    public class g<T> implements com.wbl.ad.yzz.gson.t.f<T> {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.gson.g f32275a;

        /* renamed from: b */
        public final /* synthetic */ Type f32276b;

        public g(b bVar, com.wbl.ad.yzz.gson.g gVar, Type type) {
            this.f32275a = gVar;
            this.f32276b = type;
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) this.f32275a.a(this.f32276b);
        }
    }

    public class h<T> implements com.wbl.ad.yzz.gson.t.f<T> {

        /* renamed from: a */
        public final /* synthetic */ Constructor f32277a;

        public h(b bVar, Constructor constructor) {
            this.f32277a = constructor;
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            try {
                return (T) this.f32277a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f32277a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f32277a + " with no args", e4.getTargetException());
            }
        }
    }

    public class i<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public i(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new TreeSet();
        }
    }

    public class j<T> implements com.wbl.ad.yzz.gson.t.f<T> {

        /* renamed from: a */
        public final /* synthetic */ Type f32278a;

        public j(b bVar, Type type) {
            this.f32278a = type;
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            Type type = this.f32278a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.f32278a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f32278a.toString());
        }
    }

    public class k<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public k(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    public class l<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public l(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    public class m<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public m(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new ArrayList();
        }
    }

    public class n<T> implements com.wbl.ad.yzz.gson.t.f<T> {
        public n(b bVar) {
        }

        @Override // com.wbl.ad.yzz.gson.t.f
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public b(Map<Type, com.wbl.ad.yzz.gson.g<?>> map) {
        this.f32268a = map;
    }

    public <T> com.wbl.ad.yzz.gson.t.f<T> a(com.wbl.ad.yzz.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> a2 = aVar.a();
        com.wbl.ad.yzz.gson.g<?> gVar = this.f32268a.get(type);
        if (gVar != null) {
            return new f(this, gVar, type);
        }
        com.wbl.ad.yzz.gson.g<?> gVar2 = this.f32268a.get(a2);
        if (gVar2 != null) {
            return new g(this, gVar2, type);
        }
        com.wbl.ad.yzz.gson.t.f<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        com.wbl.ad.yzz.gson.t.f<T> a4 = a(type, a2);
        return a4 != null ? a4 : b(type, a2);
    }

    public final <T> com.wbl.ad.yzz.gson.t.f<T> b(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public String toString() {
        return this.f32268a.toString();
    }

    public final <T> com.wbl.ad.yzz.gson.t.f<T> a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f32269b.a(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> com.wbl.ad.yzz.gson.t.f<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new n(this);
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new a(this);
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new C0724b(this);
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.wbl.ad.yzz.gson.u.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
            return new c(this);
        }
        return new d(this);
    }
}
