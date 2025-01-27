package h5;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public abstract class i<N, E> implements q0<N, E> {

    /* renamed from: a */
    public final Map<E, N> f26451a;

    public i(Map<E, N> map) {
        this.f26451a = (Map) b5.u.E(map);
    }

    @Override // h5.q0
    public Set<N> a() {
        return c();
    }

    @Override // h5.q0
    public Set<N> b() {
        return c();
    }

    @Override // h5.q0
    @CheckForNull
    public N d(E e10, boolean z10) {
        if (z10) {
            return null;
        }
        return j(e10);
    }

    @Override // h5.q0
    public void e(E e10, N n10) {
        b5.u.g0(this.f26451a.put(e10, n10) == null);
    }

    @Override // h5.q0
    public void f(E e10, N n10, boolean z10) {
        if (z10) {
            return;
        }
        e(e10, n10);
    }

    @Override // h5.q0
    public Set<E> g() {
        return Collections.unmodifiableSet(this.f26451a.keySet());
    }

    @Override // h5.q0
    public N h(E e10) {
        N n10 = this.f26451a.get(e10);
        Objects.requireNonNull(n10);
        return n10;
    }

    @Override // h5.q0
    public Set<E> i() {
        return g();
    }

    @Override // h5.q0
    public N j(E e10) {
        N remove = this.f26451a.remove(e10);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // h5.q0
    public Set<E> k() {
        return g();
    }
}
