package com.opos.cmn.i;

import android.util.LruCache;

/* loaded from: classes4.dex */
public class c<K, V> extends LruCache<K, V> {

    /* renamed from: a */
    private a f17429a;

    public interface a<K, V> {
        void a(K k, V v);
    }

    public c(int i2, a<K, V> aVar) {
        super(i2);
        this.f17429a = aVar;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, K k, V v, V v2) {
        a aVar;
        if (!z || (aVar = this.f17429a) == null) {
            return;
        }
        aVar.a(k, v);
    }
}
