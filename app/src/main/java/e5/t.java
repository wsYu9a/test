package e5;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class t<K, V> extends AbstractCollection<V> {

    /* renamed from: b */
    @Weak
    public final s<K, V> f25636b;

    public t(s<K, V> sVar) {
        this.f25636b = (s) b5.u.E(sVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f25636b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return this.f25636b.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return Maps.O0(this.f25636b.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@CheckForNull Object obj) {
        b5.v<? super Map.Entry<K, V>> c10 = this.f25636b.c();
        Iterator<Map.Entry<K, V>> it = this.f25636b.a().entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (c10.apply(next) && b5.r.a(next.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return u0.J(this.f25636b.a().entries(), Predicates.d(this.f25636b.c(), Maps.Q0(Predicates.n(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return u0.J(this.f25636b.a().entries(), Predicates.d(this.f25636b.c(), Maps.Q0(Predicates.q(Predicates.n(collection)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f25636b.size();
    }
}
