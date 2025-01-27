package h5;

import com.google.common.collect.Iterators;
import com.google.common.graph.GraphConstants;
import com.google.errorprone.annotations.Immutable;
import e5.z1;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N"})
@a5.a
@s
/* loaded from: classes2.dex */
public abstract class t<N> implements Iterable<N> {

    /* renamed from: b */
    public final N f26474b;

    /* renamed from: c */
    public final N f26475c;

    public static final class b<N> extends t<N> {
        public /* synthetic */ b(Object obj, Object obj2, a aVar) {
            this(obj, obj2);
        }

        @Override // h5.t
        public boolean b() {
            return true;
        }

        @Override // h5.t
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            return b() == tVar.b() && i().equals(tVar.i()) && j().equals(tVar.j());
        }

        @Override // h5.t
        public int hashCode() {
            return b5.r.b(i(), j());
        }

        @Override // h5.t
        public N i() {
            return d();
        }

        @Override // h5.t, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // h5.t
        public N j() {
            return e();
        }

        public String toString() {
            String valueOf = String.valueOf(i());
            String valueOf2 = String.valueOf(j());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 6 + valueOf2.length());
            sb2.append("<");
            sb2.append(valueOf);
            sb2.append(" -> ");
            sb2.append(valueOf2);
            sb2.append(">");
            return sb2.toString();
        }

        public b(N n10, N n11) {
            super(n10, n11);
        }
    }

    public static final class c<N> extends t<N> {
        public /* synthetic */ c(Object obj, Object obj2, a aVar) {
            this(obj, obj2);
        }

        @Override // h5.t
        public boolean b() {
            return false;
        }

        @Override // h5.t
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            if (b() != tVar.b()) {
                return false;
            }
            return d().equals(tVar.d()) ? e().equals(tVar.e()) : d().equals(tVar.e()) && e().equals(tVar.d());
        }

        @Override // h5.t
        public int hashCode() {
            return d().hashCode() + e().hashCode();
        }

        @Override // h5.t
        public N i() {
            throw new UnsupportedOperationException(GraphConstants.f9994l);
        }

        @Override // h5.t, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // h5.t
        public N j() {
            throw new UnsupportedOperationException(GraphConstants.f9994l);
        }

        public String toString() {
            String valueOf = String.valueOf(d());
            String valueOf2 = String.valueOf(e());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length());
            sb2.append("[");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        }

        public c(N n10, N n11) {
            super(n10, n11);
        }
    }

    public /* synthetic */ t(Object obj, Object obj2, a aVar) {
        this(obj, obj2);
    }

    public static <N> t<N> f(z<?> zVar, N n10, N n11) {
        return zVar.f() ? h(n10, n11) : k(n10, n11);
    }

    public static <N> t<N> g(o0<?, ?> o0Var, N n10, N n11) {
        return o0Var.f() ? h(n10, n11) : k(n10, n11);
    }

    public static <N> t<N> h(N n10, N n11) {
        return new b(n10, n11);
    }

    public static <N> t<N> k(N n10, N n11) {
        return new c(n11, n10);
    }

    public final N a(N n10) {
        if (n10.equals(this.f26474b)) {
            return this.f26475c;
        }
        if (n10.equals(this.f26475c)) {
            return this.f26474b;
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(n10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 36 + valueOf2.length());
        sb2.append("EndpointPair ");
        sb2.append(valueOf);
        sb2.append(" does not contain node ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public abstract boolean b();

    @Override // java.lang.Iterable
    /* renamed from: c */
    public final z1<N> iterator() {
        return Iterators.B(this.f26474b, this.f26475c);
    }

    public final N d() {
        return this.f26474b;
    }

    public final N e() {
        return this.f26475c;
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract N i();

    public abstract N j();

    public t(N n10, N n11) {
        this.f26474b = (N) b5.u.E(n10);
        this.f26475c = (N) b5.u.E(n11);
    }
}
