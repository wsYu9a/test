package g5;

import b5.a0;
import b5.r;
import b5.u;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import e5.z0;
import e5.z1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

@e
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: c */
    public static final d5.g<Class<?>, ImmutableList<Method>> f26149c = CacheBuilder.D().M().b(new a());

    /* renamed from: d */
    public static final d5.g<Class<?>, ImmutableSet<Class<?>>> f26150d = CacheBuilder.D().M().b(new b());

    /* renamed from: a */
    public final ConcurrentMap<Class<?>, CopyOnWriteArraySet<j>> f26151a = Maps.V();

    /* renamed from: b */
    @Weak
    public final f f26152b;

    public class a extends CacheLoader<Class<?>, ImmutableList<Method>> {
        @Override // com.google.common.cache.CacheLoader
        /* renamed from: a */
        public ImmutableList<Method> load(Class<?> cls) throws Exception {
            return m.e(cls);
        }
    }

    public class b extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
        @Override // com.google.common.cache.CacheLoader
        /* renamed from: a */
        public ImmutableSet<Class<?>> load(Class<?> cls) {
            return ImmutableSet.copyOf((Collection) TypeToken.of((Class) cls).getTypes().rawTypes());
        }
    }

    public static final class c {

        /* renamed from: a */
        public final String f26153a;

        /* renamed from: b */
        public final List<Class<?>> f26154b;

        public c(Method method) {
            this.f26153a = method.getName();
            this.f26154b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f26153a.equals(cVar.f26153a) && this.f26154b.equals(cVar.f26154b);
        }

        public int hashCode() {
            return r.b(this.f26153a, this.f26154b);
        }
    }

    public m(f fVar) {
        this.f26152b = (f) u.E(fVar);
    }

    @a5.d
    public static ImmutableSet<Class<?>> c(Class<?> cls) {
        try {
            return f26150d.getUnchecked(cls);
        } catch (UncheckedExecutionException e10) {
            throw a0.q(e10.getCause());
        }
    }

    public static ImmutableList<Method> d(Class<?> cls) {
        try {
            return f26149c.getUnchecked(cls);
        } catch (UncheckedExecutionException e10) {
            a0.w(e10.getCause());
            throw e10;
        }
    }

    public static ImmutableList<Method> e(Class<?> cls) {
        Set rawTypes = TypeToken.of((Class) cls).getTypes().rawTypes();
        HashMap Y = Maps.Y();
        Iterator it = rawTypes.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(h.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    u.w(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    u.z(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), n5.h.f(parameterTypes[0]).getSimpleName());
                    c cVar = new c(method);
                    if (!Y.containsKey(cVar)) {
                        Y.put(cVar, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf(Y.values());
    }

    public final z0<Class<?>, j> b(Object obj) {
        HashMultimap create = HashMultimap.create();
        z1<Method> it = d(obj.getClass()).iterator();
        while (it.hasNext()) {
            Method next = it.next();
            create.put(next.getParameterTypes()[0], j.c(this.f26152b, obj, next));
        }
        return create;
    }

    public Iterator<j> f(Object obj) {
        ImmutableSet<Class<?>> c10 = c(obj.getClass());
        ArrayList u10 = Lists.u(c10.size());
        z1<Class<?>> it = c10.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f26151a.get(it.next());
            if (copyOnWriteArraySet != null) {
                u10.add(copyOnWriteArraySet.iterator());
            }
        }
        return Iterators.i(u10.iterator());
    }

    @a5.d
    public Set<j> g(Class<?> cls) {
        return (Set) com.google.common.base.a.a(this.f26151a.get(cls), ImmutableSet.of());
    }

    public void h(Object obj) {
        for (Map.Entry<Class<?>, Collection<j>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<j> value = entry.getValue();
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f26151a.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<j> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) com.google.common.base.a.a(this.f26151a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    public void i(Object obj) {
        for (Map.Entry<Class<?>, Collection<j>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<j> value = entry.getValue();
            CopyOnWriteArraySet<j> copyOnWriteArraySet = this.f26151a.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 65);
                sb2.append("missing event subscriber for an annotated method. Is ");
                sb2.append(valueOf);
                sb2.append(" registered?");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }
}
