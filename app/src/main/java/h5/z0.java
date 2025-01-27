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
public final class z0<N, E> extends i<N, E> {

    /* renamed from: b */
    @CheckForNull
    @LazyInit
    public transient Reference<com.google.common.collect.s<N>> f26496b;

    public class a extends j0<E> {

        /* renamed from: d */
        public final /* synthetic */ Object f26497d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.f26497d = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z0.this.n().count(this.f26497d);
        }
    }

    public z0(Map<E, N> map) {
        super(map);
    }

    @CheckForNull
    private static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> z0<N, E> p() {
        return new z0<>(new HashMap(2, 1.0f));
    }

    public static <N, E> z0<N, E> q(Map<E, N> map) {
        return new z0<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // h5.q0
    public Set<N> c() {
        return Collections.unmodifiableSet(n().elementSet());
    }

    @Override // h5.i, h5.q0
    @CheckForNull
    public N d(E e10, boolean z10) {
        if (z10) {
            return null;
        }
        return j(e10);
    }

    @Override // h5.i, h5.q0
    public void e(E e10, N n10) {
        super.e(e10, n10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26496b);
        if (sVar != null) {
            b5.u.g0(sVar.add(n10));
        }
    }

    @Override // h5.i, h5.q0
    public void f(E e10, N n10, boolean z10) {
        if (z10) {
            return;
        }
        e(e10, n10);
    }

    @Override // h5.i, h5.q0
    public N j(E e10) {
        N n10 = (N) super.j(e10);
        com.google.common.collect.s sVar = (com.google.common.collect.s) o(this.f26496b);
        if (sVar != null) {
            b5.u.g0(sVar.remove(n10));
        }
        return n10;
    }

    @Override // h5.q0
    public Set<E> l(N n10) {
        return new a(this.f26451a, n10, n10);
    }

    public final com.google.common.collect.s<N> n() {
        com.google.common.collect.s<N> sVar = (com.google.common.collect.s) o(this.f26496b);
        if (sVar != null) {
            return sVar;
        }
        HashMultiset create = HashMultiset.create(this.f26451a.values());
        this.f26496b = new SoftReference(create);
        return create;
    }
}
