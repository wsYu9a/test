package h5;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@s
/* loaded from: classes2.dex */
public final class q<N, E> extends e<N, E> {
    public q(Map<E, N> map, Map<E, N> map2, int i10) {
        super(map, map2, i10);
    }

    public static <N, E> q<N, E> n() {
        return new q<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    public static <N, E> q<N, E> o(Map<E, N> map, Map<E, N> map2, int i10) {
        return new q<>(ImmutableBiMap.copyOf((Map) map), ImmutableBiMap.copyOf((Map) map2), i10);
    }

    @Override // h5.q0
    public Set<N> a() {
        return Collections.unmodifiableSet(((e5.g) this.f26426b).values());
    }

    @Override // h5.q0
    public Set<N> b() {
        return Collections.unmodifiableSet(((e5.g) this.f26425a).values());
    }

    @Override // h5.q0
    public Set<E> l(N n10) {
        return new r(((e5.g) this.f26426b).inverse(), n10);
    }
}
