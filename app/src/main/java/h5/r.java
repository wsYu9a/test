package h5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import e5.z1;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class r<E> extends AbstractSet<E> {

    /* renamed from: b */
    public final Map<?, E> f26472b;

    /* renamed from: c */
    public final Object f26473c;

    public r(Map<?, E> map, Object obj) {
        this.f26472b = (Map) b5.u.E(map);
        this.f26473c = b5.u.E(obj);
    }

    @CheckForNull
    public final E a() {
        return this.f26472b.get(this.f26473c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b */
    public z1<E> iterator() {
        E a10 = a();
        return a10 == null ? ImmutableSet.of().iterator() : Iterators.Y(a10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        E a10 = a();
        return a10 != null && a10.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
