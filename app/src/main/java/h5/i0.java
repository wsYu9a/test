package h5;

import java.util.Map;
import javax.annotation.CheckForNull;

@s
/* loaded from: classes2.dex */
public final class i0<K, V> extends h0<K, V> {

    /* renamed from: c */
    @CheckForNull
    public volatile transient a<K, V> f26452c;

    /* renamed from: d */
    @CheckForNull
    public volatile transient a<K, V> f26453d;

    public static final class a<K, V> {

        /* renamed from: a */
        public final K f26454a;

        /* renamed from: b */
        public final V f26455b;

        public a(K k10, V v10) {
            this.f26454a = k10;
            this.f26455b = v10;
        }
    }

    public i0(Map<K, V> map) {
        super(map);
    }

    @Override // h5.h0
    public void d() {
        super.d();
        this.f26452c = null;
        this.f26453d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.h0
    @CheckForNull
    public V f(Object obj) {
        b5.u.E(obj);
        V g10 = g(obj);
        if (g10 != null) {
            return g10;
        }
        V h10 = h(obj);
        if (h10 != null) {
            m(obj, h10);
        }
        return h10;
    }

    @Override // h5.h0
    @CheckForNull
    public V g(@CheckForNull Object obj) {
        V v10 = (V) super.g(obj);
        if (v10 != null) {
            return v10;
        }
        a<K, V> aVar = this.f26452c;
        if (aVar != null && aVar.f26454a == obj) {
            return aVar.f26455b;
        }
        a<K, V> aVar2 = this.f26453d;
        if (aVar2 == null || aVar2.f26454a != obj) {
            return null;
        }
        l(aVar2);
        return aVar2.f26455b;
    }

    public final void l(a<K, V> aVar) {
        this.f26453d = this.f26452c;
        this.f26452c = aVar;
    }

    public final void m(K k10, V v10) {
        l(new a<>(k10, v10));
    }
}
