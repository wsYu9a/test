package h5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphConstants;
import com.google.common.primitives.Ints;
import e5.z1;
import h5.a;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class a<N> implements l<N> {

    /* renamed from: h5.a$a */
    public class C0705a extends AbstractSet<t<N>> {
        public C0705a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<t<N>> iterator() {
            return u.e(a.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof t)) {
                return false;
            }
            t<?> tVar = (t) obj;
            return a.this.O(tVar) && a.this.m().contains(tVar.d()) && a.this.b((a) tVar.d()).contains(tVar.e());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Ints.x(a.this.N());
        }
    }

    public class b extends g0<N> {
        public b(a aVar, l lVar, Object obj) {
            super(lVar, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: d */
        public z1<t<N>> iterator() {
            return this.f26438c.f() ? Iterators.f0(Iterators.j(Iterators.c0(this.f26438c.a((l<N>) this.f26437b).iterator(), new b5.n() { // from class: h5.b
                public /* synthetic */ b() {
                }

                @Override // b5.n
                public final Object apply(Object obj) {
                    t e10;
                    e10 = a.b.this.e(obj);
                    return e10;
                }
            }), Iterators.c0(Sets.f(this.f26438c.b((l<N>) this.f26437b), ImmutableSet.of(this.f26437b)).iterator(), new b5.n() { // from class: h5.c
                public /* synthetic */ c() {
                }

                @Override // b5.n
                public final Object apply(Object obj) {
                    t f10;
                    f10 = a.b.this.f(obj);
                    return f10;
                }
            }))) : Iterators.f0(Iterators.c0(this.f26438c.k(this.f26437b).iterator(), new b5.n() { // from class: h5.d
                public /* synthetic */ d() {
                }

                @Override // b5.n
                public final Object apply(Object obj) {
                    t g10;
                    g10 = a.b.this.g(obj);
                    return g10;
                }
            }));
        }

        public final /* synthetic */ t e(Object obj) {
            return t.h(obj, this.f26437b);
        }

        public final /* synthetic */ t f(Object obj) {
            return t.h(this.f26437b, obj);
        }

        public final /* synthetic */ t g(Object obj) {
            return t.k(this.f26437b, obj);
        }
    }

    public long N() {
        long j10 = 0;
        while (m().iterator().hasNext()) {
            j10 += g(r0.next());
        }
        b5.u.g0((1 & j10) == 0);
        return j10 >>> 1;
    }

    public final boolean O(t<?> tVar) {
        return tVar.b() || !f();
    }

    public final void P(t<?> tVar) {
        b5.u.E(tVar);
        b5.u.e(O(tVar), GraphConstants.f9996n);
    }

    @Override // h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        Iterable a10;
        a10 = a((a<N>) ((l) obj));
        return a10;
    }

    @Override // h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        Iterable b10;
        b10 = b((a<N>) ((l) obj));
        return b10;
    }

    @Override // h5.l, h5.z
    public boolean c(t<N> tVar) {
        b5.u.E(tVar);
        if (!O(tVar)) {
            return false;
        }
        N d10 = tVar.d();
        return m().contains(d10) && b((a<N>) d10).contains(tVar.e());
    }

    @Override // h5.l
    public Set<t<N>> d() {
        return new C0705a();
    }

    @Override // h5.l, h5.z
    public boolean e(N n10, N n11) {
        b5.u.E(n10);
        b5.u.E(n11);
        return m().contains(n10) && b((a<N>) n10).contains(n11);
    }

    @Override // h5.l, h5.z
    public int g(N n10) {
        if (f()) {
            return l5.f.t(a((a<N>) n10).size(), b((a<N>) n10).size());
        }
        Set<N> k10 = k(n10);
        return l5.f.t(k10.size(), (j() && k10.contains(n10)) ? 1 : 0);
    }

    @Override // h5.l, h5.z
    public int i(N n10) {
        return f() ? b((a<N>) n10).size() : g(n10);
    }

    @Override // h5.l, h5.z
    public Set<t<N>> l(N n10) {
        b5.u.E(n10);
        b5.u.u(m().contains(n10), GraphConstants.f9988f, n10);
        return new b(this, this, n10);
    }

    @Override // h5.l, h5.z
    public int n(N n10) {
        return f() ? a((a<N>) n10).size() : g(n10);
    }

    @Override // h5.l, h5.z
    public ElementOrder<N> p() {
        return ElementOrder.i();
    }
}
