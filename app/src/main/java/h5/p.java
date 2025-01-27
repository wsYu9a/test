package h5;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class p<N, E> extends e<N, E> {

    /* renamed from: d */
    @CheckForNull
    @LazyInit
    public transient Reference<com.google.common.collect.s<N>> f26465d;

    /* renamed from: e */
    @CheckForNull
    @LazyInit
    public transient Reference<com.google.common.collect.s<N>> f26466e;

    public class a extends j0<E> {

        /* renamed from: d */
        public final /* synthetic */ Object f26467d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.f26467d = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.s().count(this.f26467d);
        }
    }

    public p(Map<E, N> map, Map<E, N> map2, int i10) {
        super(map, map2, i10);
    }

    @CheckForNull
    public static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> p<N, E> p() {
        return new p<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> p<N, E> q(Map<E, N> map, Map<E, N> map2, int i10) {
        return new p<>(ImmutableMap.copyOf((Map) map), ImmutableMap.copyOf((Map) map2), i10);
    }

    @Override // h5.q0
    public Set<N> a() {
        return Collections.unmodifiableSet(s().elementSet());
    }

    @Override // h5.q0
    public Set<N> b() {
        return Collections.unmodifiableSet(r().elementSet());
    }

    @Override // h5.e, h5.q0
    public N d(E e10, boolean z10) {
        N n10 = (N) super.d(e10, z10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26465d);
        if (sVar != null) {
            b5.u.g0(sVar.remove(n10));
        }
        return n10;
    }

    @Override // h5.e, h5.q0
    public void e(E e10, N n10) {
        super.e(e10, n10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26466e);
        if (sVar != null) {
            b5.u.g0(sVar.add(n10));
        }
    }

    @Override // h5.e, h5.q0
    public void f(E e10, N n10, boolean z10) {
        super.f(e10, n10, z10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26465d);
        if (sVar != null) {
            b5.u.g0(sVar.add(n10));
        }
    }

    @Override // h5.e, h5.q0
    public N j(E e10) {
        N n10 = (N) super.j(e10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26466e);
        if (sVar != null) {
            b5.u.g0(sVar.remove(n10));
        }
        return n10;
    }

    @Override // h5.q0
    public Set<E> l(N n10) {
        return new a(this.f26426b, n10, n10);
    }

    public final com.google.common.collect.s<N> r() {
        com.google.common.collect.s<N> sVar = (com.google.common.collect.s) o(this.f26465d);
        if (sVar != null) {
            return sVar;
        }
        HashMultiset create = HashMultiset.create(this.f26425a.values());
        this.f26465d = new SoftReference(create);
        return create;
    }

    public final com.google.common.collect.s<N> s() {
        com.google.common.collect.s<N> sVar = (com.google.common.collect.s) o(this.f26466e);
        if (sVar != null) {
            return sVar;
        }
        HashMultiset create = HashMultiset.create(this.f26426b.values());
        this.f26466e = new SoftReference(create);
        return create;
    }
}
