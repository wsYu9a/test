package e5;

import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public class q<K, V> extends com.google.common.collect.a<K, V> implements s<K, V> {

    /* renamed from: b */
    public final z0<K, V> f25628b;

    /* renamed from: c */
    public final b5.v<? super K> f25629c;

    public static class a<K, V> extends g0<V> {

        /* renamed from: b */
        @d1
        public final K f25630b;

        public a(@d1 K k10) {
            this.f25630b = k10;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 V v10) {
            add(0, v10);
            return true;
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        @Override // e5.g0, e5.y, e5.l0
        /* renamed from: e */
        public List<V> delegate() {
            return Collections.emptyList();
        }

        @Override // e5.g0, java.util.List
        public void add(int i10, @d1 V v10) {
            b5.u.d0(i10, 0);
            String valueOf = String.valueOf(this.f25630b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Key does not satisfy predicate: ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // e5.g0, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i10, Collection<? extends V> collection) {
            b5.u.E(collection);
            b5.u.d0(i10, 0);
            String valueOf = String.valueOf(this.f25630b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Key does not satisfy predicate: ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public class c extends y<Map.Entry<K, V>> {
        public c() {
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (q.this.f25628b.containsKey(entry.getKey()) && q.this.f25629c.apply((Object) entry.getKey())) {
                return q.this.f25628b.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // e5.y, e5.l0
        public Collection<Map.Entry<K, V>> delegate() {
            return com.google.common.collect.f.d(q.this.f25628b.entries(), q.this.c());
        }
    }

    public q(z0<K, V> z0Var, b5.v<? super K> vVar) {
        this.f25628b = (z0) b5.u.E(z0Var);
        this.f25629c = (b5.v) b5.u.E(vVar);
    }

    public z0<K, V> a() {
        return this.f25628b;
    }

    public Collection<V> b() {
        return this.f25628b instanceof l1 ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // e5.s
    public b5.v<? super Map.Entry<K, V>> c() {
        return Maps.U(this.f25629c);
    }

    @Override // e5.z0
    public void clear() {
        keySet().clear();
    }

    @Override // e5.z0
    public boolean containsKey(@CheckForNull Object obj) {
        if (this.f25628b.containsKey(obj)) {
            return this.f25629c.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.a
    public Map<K, Collection<V>> createAsMap() {
        return Maps.G(this.f25628b.asMap(), this.f25629c);
    }

    @Override // com.google.common.collect.a
    public Collection<Map.Entry<K, V>> createEntries() {
        return new c();
    }

    @Override // com.google.common.collect.a
    public Set<K> createKeySet() {
        return Sets.i(this.f25628b.keySet(), this.f25629c);
    }

    @Override // com.google.common.collect.a
    public com.google.common.collect.s<K> createKeys() {
        return Multisets.j(this.f25628b.keys(), this.f25629c);
    }

    @Override // com.google.common.collect.a
    public Collection<V> createValues() {
        return new t(this);
    }

    @Override // com.google.common.collect.a
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // e5.z0, e5.x0
    public Collection<V> get(@d1 K k10) {
        return this.f25629c.apply(k10) ? this.f25628b.get(k10) : this.f25628b instanceof l1 ? new b(k10) : new a(k10);
    }

    @Override // e5.z0, e5.x0
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return containsKey(obj) ? this.f25628b.removeAll(obj) : b();
    }

    @Override // e5.z0
    public int size() {
        Iterator<Collection<V>> it = asMap().values().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().size();
        }
        return i10;
    }

    public static class b<K, V> extends n0<V> {

        /* renamed from: b */
        @d1
        public final K f25631b;

        public b(@d1 K k10) {
            this.f25631b = k10;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 V v10) {
            String valueOf = String.valueOf(this.f25631b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Key does not satisfy predicate: ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            b5.u.E(collection);
            String valueOf = String.valueOf(this.f25631b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Key does not satisfy predicate: ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}
