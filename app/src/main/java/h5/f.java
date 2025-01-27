package h5;

import com.google.common.graph.ElementOrder;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
@a5.a
/* loaded from: classes2.dex */
public abstract class f<N> extends a<N> implements z<N> {
    @Override // h5.a, h5.l, h5.s0, h5.z
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        Iterable a10;
        a10 = a((f<N>) ((z) obj));
        return a10;
    }

    @Override // h5.a, h5.l, h5.x0, h5.z
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        Iterable b10;
        b10 = b((f<N>) ((z) obj));
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

    @Override // h5.z
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return f() == zVar.f() && m().equals(zVar.m()) && d().equals(zVar.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.a, h5.l, h5.z
    public /* bridge */ /* synthetic */ int g(Object obj) {
        return super.g(obj);
    }

    @Override // h5.z
    public final int hashCode() {
        return d().hashCode();
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

    public String toString() {
        boolean f10 = f();
        boolean j10 = j();
        String valueOf = String.valueOf(m());
        String valueOf2 = String.valueOf(d());
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
