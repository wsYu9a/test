package h5;

import com.google.common.base.Optional;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public class w0<N, V> extends j<N, V> {

    /* renamed from: a */
    public final boolean f26489a;

    /* renamed from: b */
    public final boolean f26490b;

    /* renamed from: c */
    public final ElementOrder<N> f26491c;

    /* renamed from: d */
    public final h0<N, a0<N, V>> f26492d;

    /* renamed from: e */
    public long f26493e;

    public class a extends g0<N> {

        /* renamed from: d */
        public final /* synthetic */ a0 f26494d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w0 w0Var, l lVar, Object obj, a0 a0Var) {
            super(lVar, obj);
            this.f26494d = a0Var;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<t<N>> iterator() {
            return this.f26494d.g(this.f26437b);
        }
    }

    public w0(g<? super N> gVar) {
        this(gVar, gVar.f26434c.c(gVar.f26436e.or((Optional<Integer>) 10).intValue()), 0L);
    }

    @CheckForNull
    public V L(t<N> tVar, @CheckForNull V v10) {
        P(tVar);
        return T(tVar.d(), tVar.e(), v10);
    }

    @Override // h5.a
    public long N() {
        return this.f26493e;
    }

    public final a0<N, V> R(N n10) {
        a0<N, V> f10 = this.f26492d.f(n10);
        if (f10 != null) {
            return f10;
        }
        b5.u.E(n10);
        String valueOf = String.valueOf(n10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 38);
        sb2.append("Node ");
        sb2.append(valueOf);
        sb2.append(" is not an element of this graph.");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean S(@CheckForNull N n10) {
        return this.f26492d.e(n10);
    }

    @CheckForNull
    public final V T(N n10, N n11, @CheckForNull V v10) {
        a0<N, V> f10 = this.f26492d.f(n10);
        V d10 = f10 == null ? null : f10.d(n11);
        return d10 == null ? v10 : d10;
    }

    public final boolean U(N n10, N n11) {
        a0<N, V> f10 = this.f26492d.f(n10);
        return f10 != null && f10.a().contains(n11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.j, h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a((w0<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.j, h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b((w0<N, V>) obj);
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public boolean c(t<N> tVar) {
        b5.u.E(tVar);
        return O(tVar) && U(tVar.d(), tVar.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.j, h5.a, h5.l, h5.z
    public boolean e(N n10, N n11) {
        return U(b5.u.E(n10), b5.u.E(n11));
    }

    @Override // h5.l, h5.z
    public boolean f() {
        return this.f26489a;
    }

    @Override // h5.l, h5.z
    public ElementOrder<N> h() {
        return this.f26491c;
    }

    @Override // h5.l, h5.z
    public boolean j() {
        return this.f26490b;
    }

    @Override // h5.l, h5.z
    public Set<N> k(N n10) {
        return R(n10).c();
    }

    @Override // h5.j, h5.a, h5.l, h5.z
    public Set<t<N>> l(N n10) {
        return new a(this, this, n10, R(n10));
    }

    @Override // h5.l, h5.z
    public Set<N> m() {
        return this.f26492d.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public V z(N n10, N n11, @CheckForNull V v10) {
        return (V) T(b5.u.E(n10), b5.u.E(n11), v10);
    }

    @Override // h5.j, h5.a, h5.l, h5.s0, h5.z
    public Set<N> a(N n10) {
        return R(n10).b();
    }

    @Override // h5.j, h5.a, h5.l, h5.x0, h5.z
    public Set<N> b(N n10) {
        return R(n10).a();
    }

    public w0(g<? super N> gVar, Map<N, a0<N, V>> map, long j10) {
        h0<N, a0<N, V>> h0Var;
        this.f26489a = gVar.f26432a;
        this.f26490b = gVar.f26433b;
        this.f26491c = (ElementOrder<N>) gVar.f26434c.a();
        if (map instanceof TreeMap) {
            h0Var = new i0<>(map);
        } else {
            h0Var = new h0<>(map);
        }
        this.f26492d = h0Var;
        this.f26493e = Graphs.c(j10);
    }
}
