package com.google.common.graph;

import b5.n;
import b5.u;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.graph.ElementOrder;
import h5.a0;
import h5.s;
import h5.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class f<N, V> implements a0<N, V> {

    /* renamed from: a */
    public final Map<N, V> f10042a;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10043a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f10043a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10043a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public f(Map<N, V> map) {
        this.f10042a = (Map) u.E(map);
    }

    public static <N, V> f<N, V> l(ElementOrder<N> elementOrder) {
        int i10 = a.f10043a[elementOrder.h().ordinal()];
        if (i10 == 1) {
            return new f<>(new HashMap(2, 1.0f));
        }
        if (i10 == 2) {
            return new f<>(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(elementOrder.h());
    }

    public static <N, V> f<N, V> m(Map<N, V> map) {
        return new f<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // h5.a0
    public Set<N> a() {
        return c();
    }

    @Override // h5.a0
    public Set<N> b() {
        return c();
    }

    @Override // h5.a0
    public Set<N> c() {
        return Collections.unmodifiableSet(this.f10042a.keySet());
    }

    @Override // h5.a0
    @CheckForNull
    public V d(N n10) {
        return this.f10042a.get(n10);
    }

    @Override // h5.a0
    @CheckForNull
    public V e(N n10) {
        return this.f10042a.remove(n10);
    }

    @Override // h5.a0
    public void f(N n10) {
        e(n10);
    }

    @Override // h5.a0
    public Iterator<t<N>> g(N n10) {
        return Iterators.c0(this.f10042a.keySet().iterator(), new n() { // from class: h5.y0

            /* renamed from: b */
            public final /* synthetic */ Object f26495b;

            public /* synthetic */ y0(Object n102) {
                n10 = n102;
            }

            @Override // b5.n
            public final Object apply(Object obj) {
                t k10;
                k10 = t.k(n10, obj);
                return k10;
            }
        });
    }

    @Override // h5.a0
    @CheckForNull
    public V h(N n10, V v10) {
        return this.f10042a.put(n10, v10);
    }

    @Override // h5.a0
    public void i(N n10, V v10) {
        h(n10, v10);
    }
}
