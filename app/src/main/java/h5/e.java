package h5;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.Graphs;
import e5.z1;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class e<N, E> implements q0<N, E> {

    /* renamed from: a */
    public final Map<E, N> f26425a;

    /* renamed from: b */
    public final Map<E, N> f26426b;

    /* renamed from: c */
    public int f26427c;

    public class a extends AbstractSet<E> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<E> iterator() {
            return Iterators.f0((e.this.f26427c == 0 ? e5.u0.f(e.this.f26425a.keySet(), e.this.f26426b.keySet()) : Sets.N(e.this.f26425a.keySet(), e.this.f26426b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return e.this.f26425a.containsKey(obj) || e.this.f26426b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return l5.f.t(e.this.f26425a.size(), e.this.f26426b.size() - e.this.f26427c);
        }
    }

    public e(Map<E, N> map, Map<E, N> map2, int i10) {
        this.f26425a = (Map) b5.u.E(map);
        this.f26426b = (Map) b5.u.E(map2);
        this.f26427c = Graphs.b(i10);
        b5.u.g0(i10 <= map.size() && i10 <= map2.size());
    }

    @Override // h5.q0
    public Set<N> c() {
        return Sets.N(b(), a());
    }

    @Override // h5.q0
    public N d(E e10, boolean z10) {
        if (z10) {
            int i10 = this.f26427c - 1;
            this.f26427c = i10;
            Graphs.b(i10);
        }
        N remove = this.f26425a.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // h5.q0
    public void e(E e10, N n10) {
        b5.u.E(e10);
        b5.u.E(n10);
        b5.u.g0(this.f26426b.put(e10, n10) == null);
    }

    @Override // h5.q0
    public void f(E e10, N n10, boolean z10) {
        b5.u.E(e10);
        b5.u.E(n10);
        if (z10) {
            int i10 = this.f26427c + 1;
            this.f26427c = i10;
            Graphs.d(i10);
        }
        b5.u.g0(this.f26425a.put(e10, n10) == null);
    }

    @Override // h5.q0
    public Set<E> g() {
        return new a();
    }

    @Override // h5.q0
    public N h(E e10) {
        N n10 = this.f26426b.get(e10);
        Objects.requireNonNull(n10);
        return n10;
    }

    @Override // h5.q0
    public Set<E> i() {
        return Collections.unmodifiableSet(this.f26425a.keySet());
    }

    @Override // h5.q0
    public N j(E e10) {
        N remove = this.f26426b.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // h5.q0
    public Set<E> k() {
        return Collections.unmodifiableSet(this.f26426b.keySet());
    }
}
