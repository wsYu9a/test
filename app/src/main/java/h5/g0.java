package h5;

import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class g0<N> extends AbstractSet<t<N>> {

    /* renamed from: b */
    public final N f26437b;

    /* renamed from: c */
    public final l<N> f26438c;

    public g0(l<N> lVar, N n10) {
        this.f26438c = lVar;
        this.f26437b = n10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f26438c.f()) {
            if (!tVar.b()) {
                return false;
            }
            Object i10 = tVar.i();
            Object j10 = tVar.j();
            return (this.f26437b.equals(i10) && this.f26438c.b((l<N>) this.f26437b).contains(j10)) || (this.f26437b.equals(j10) && this.f26438c.a((l<N>) this.f26437b).contains(i10));
        }
        if (tVar.b()) {
            return false;
        }
        Set<N> k10 = this.f26438c.k(this.f26437b);
        Object d10 = tVar.d();
        Object e10 = tVar.e();
        return (this.f26437b.equals(e10) && k10.contains(d10)) || (this.f26437b.equals(d10) && k10.contains(e10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f26438c.f() ? (this.f26438c.n(this.f26437b) + this.f26438c.i(this.f26437b)) - (this.f26438c.b((l<N>) this.f26437b).contains(this.f26437b) ? 1 : 0) : this.f26438c.k(this.f26437b).size();
    }
}
