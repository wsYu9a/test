package h5;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@s
/* loaded from: classes2.dex */
public final class a1<N, E> extends i<N, E> {
    public a1(Map<E, N> map) {
        super(map);
    }

    public static <N, E> a1<N, E> m() {
        return new a1<>(HashBiMap.create(2));
    }

    public static <N, E> a1<N, E> n(Map<E, N> map) {
        return new a1<>(ImmutableBiMap.copyOf((Map) map));
    }

    @Override // h5.q0
    public Set<N> c() {
        return Collections.unmodifiableSet(((e5.g) this.f26451a).values());
    }

    @Override // h5.q0
    public Set<E> l(N n10) {
        return new r(((e5.g) this.f26451a).inverse(), n10);
    }
}
