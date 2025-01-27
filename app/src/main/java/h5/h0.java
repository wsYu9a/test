package h5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.z1;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public class h0<K, V> {

    /* renamed from: a */
    public final Map<K, V> f26446a;

    /* renamed from: b */
    @CheckForNull
    public volatile transient Map.Entry<K, V> f26447b;

    public class a extends AbstractSet<K> {

        /* renamed from: h5.h0$a$a */
        public class C0708a extends z1<K> {

            /* renamed from: b */
            public final /* synthetic */ Iterator f26449b;

            public C0708a(Iterator it) {
                this.f26449b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26449b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry entry = (Map.Entry) this.f26449b.next();
                h0.this.f26447b = entry;
                return (K) entry.getKey();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public z1<K> iterator() {
            return new C0708a(h0.this.f26446a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return h0.this.e(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.f26446a.size();
        }
    }

    public h0(Map<K, V> map) {
        this.f26446a = (Map) b5.u.E(map);
    }

    public final void c() {
        d();
        this.f26446a.clear();
    }

    public void d() {
        this.f26447b = null;
    }

    public final boolean e(@CheckForNull Object obj) {
        return g(obj) != null || this.f26446a.containsKey(obj);
    }

    @CheckForNull
    public V f(Object obj) {
        b5.u.E(obj);
        V g10 = g(obj);
        return g10 == null ? h(obj) : g10;
    }

    @CheckForNull
    public V g(@CheckForNull Object obj) {
        Map.Entry<K, V> entry = this.f26447b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    @CheckForNull
    public final V h(Object obj) {
        b5.u.E(obj);
        return this.f26446a.get(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final V i(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        d();
        return this.f26446a.put(k10, v10);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final V j(Object obj) {
        b5.u.E(obj);
        d();
        return this.f26446a.remove(obj);
    }

    public final Set<K> k() {
        return new a();
    }
}
