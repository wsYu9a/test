package h5;

import com.google.common.collect.Maps;
import com.google.common.graph.ElementOrder;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
@a5.a
/* loaded from: classes2.dex */
public abstract class j<N, V> extends h5.a<N> implements c1<N, V> {

    public class a extends f<N> {
        public a() {
        }

        @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
        public /* bridge */ /* synthetic */ Iterable a(Object obj) {
            return a((a) obj);
        }

        @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
        public /* bridge */ /* synthetic */ Iterable b(Object obj) {
            return b((a) obj);
        }

        @Override // h5.f, h5.a, h5.l
        public Set<t<N>> d() {
            return j.this.d();
        }

        @Override // h5.l, h5.z
        public boolean f() {
            return j.this.f();
        }

        @Override // h5.f, h5.a, h5.l, h5.z
        public int g(N n10) {
            return j.this.g(n10);
        }

        @Override // h5.l, h5.z
        public ElementOrder<N> h() {
            return j.this.h();
        }

        @Override // h5.f, h5.a, h5.l, h5.z
        public int i(N n10) {
            return j.this.i(n10);
        }

        @Override // h5.l, h5.z
        public boolean j() {
            return j.this.j();
        }

        @Override // h5.l, h5.z
        public Set<N> k(N n10) {
            return j.this.k(n10);
        }

        @Override // h5.l, h5.z
        public Set<N> m() {
            return j.this.m();
        }

        @Override // h5.f, h5.a, h5.l, h5.z
        public int n(N n10) {
            return j.this.n(n10);
        }

        @Override // h5.f, h5.a, h5.l, h5.z
        public ElementOrder<N> p() {
            return j.this.p();
        }

        @Override // h5.f, h5.a, h5.l, h5.s0, h5.z
        public Set<N> a(N n10) {
            return j.this.a((j) n10);
        }

        @Override // h5.f, h5.a, h5.l, h5.x0, h5.z
        public Set<N> b(N n10) {
            return j.this.b((j) n10);
        }
    }

    public class b implements b5.n<t<N>, V> {

        /* renamed from: b */
        public final /* synthetic */ c1 f26457b;

        public b(c1 c1Var) {
            this.f26457b = c1Var;
        }

        @Override // b5.n
        /* renamed from: a */
        public V apply(t<N> tVar) {
            V v10 = (V) this.f26457b.z(tVar.d(), tVar.e(), null);
            Objects.requireNonNull(v10);
            return v10;
        }
    }

    public static <N, V> Map<t<N>, V> Q(c1<N, V> c1Var) {
        return Maps.j(c1Var.d(), new b(c1Var));
    }

    @Override // h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        Iterable a10;
        a10 = a((j<N, V>) ((c1) obj));
        return a10;
    }

    @Override // h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        Iterable b10;
        b10 = b((j<N, V>) ((c1) obj));
        return b10;
    }

    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean c(t tVar) {
        return super.c(tVar);
    }

    @Override // h5.a, h5.l
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // h5.c1
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return f() == c1Var.f() && m().equals(c1Var.m()) && Q(this).equals(Q(c1Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int g(Object obj) {
        return super.g(obj);
    }

    @Override // h5.c1
    public final int hashCode() {
        return Q(this).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int i(Object obj) {
        return super.i(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ Set l(Object obj) {
        return super.l(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int n(Object obj) {
        return super.n(obj);
    }

    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ ElementOrder p() {
        return super.p();
    }

    public z<N> s() {
        return new a();
    }

    public String toString() {
        boolean f10 = f();
        boolean j10 = j();
        String valueOf = String.valueOf(m());
        String valueOf2 = String.valueOf(Q(this));
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 59 + valueOf2.length());
        sb2.append("isDirected: ");
        sb2.append(f10);
        sb2.append(", allowsSelfLoops: ");
        sb2.append(j10);
        sb2.append(", nodes: ");
        sb2.append(valueOf);
        sb2.append(", edges: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }
}
