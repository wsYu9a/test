package com.kwad.components.ad.j;

import com.kwad.components.core.proxy.f;
import com.kwad.components.core.proxy.l;
import com.kwad.components.core.proxy.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class b implements com.kwad.components.core.internal.api.b {

    /* renamed from: pa */
    private static final Object f11633pa = new Object();

    /* renamed from: pb */
    private static volatile b f11634pb;

    /* renamed from: pd */
    private Set<Integer> f11635pd = new HashSet();

    /* renamed from: pe */
    private List<c> f11636pe = new ArrayList();

    /* renamed from: pf */
    private Map<com.kwad.components.core.internal.api.a, Object> f11637pf = new WeakHashMap();

    /* renamed from: pg */
    private Map<f, Object> f11638pg = new WeakHashMap();

    /* renamed from: ph */
    private m f11639ph = new m() { // from class: com.kwad.components.ad.j.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(f fVar) {
            super.d(fVar);
            b.this.f11638pg.put(fVar, b.f11633pa);
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(f fVar) {
            super.c(fVar);
            b.this.f11638pg.remove(fVar);
            if (b.this.f11638pg.isEmpty()) {
                b.this.fd();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.j.b$1 */
    public class AnonymousClass1 extends m {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(f fVar) {
            super.d(fVar);
            b.this.f11638pg.put(fVar, b.f11633pa);
        }

        @Override // com.kwad.components.core.proxy.m, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(f fVar) {
            super.c(fVar);
            b.this.f11638pg.remove(fVar);
            if (b.this.f11638pg.isEmpty()) {
                b.this.fd();
            }
        }
    }

    private b() {
        l.qZ().a(this.f11639ph);
        this.f11635pd.add(2);
        this.f11635pd.add(3);
        this.f11635pd.add(13);
        this.f11635pd.add(6);
    }

    private boolean E(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.f11635pd.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.f11637pf.put(aVar, f11633pa);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.fg();
            this.f11636pe.add(cVar);
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.f11637pf.remove(aVar);
        Iterator<c> it = this.f11636pe.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        if (E(aVar.getAdTemplate())) {
            fd();
        }
    }

    public static b fc() {
        if (f11634pb == null) {
            synchronized (b.class) {
                try {
                    if (f11634pb == null) {
                        f11634pb = new b();
                    }
                } finally {
                }
            }
        }
        return f11634pb;
    }

    public synchronized void fd() {
        boolean fe2 = fe();
        com.kwad.sdk.core.d.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + fe2);
        if (fe2) {
            Iterator<c> it = this.f11636pe.iterator();
            while (it.hasNext()) {
                it.next().fi();
            }
        }
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (aVar.supportPushAd()) {
            return com.kwad.sdk.core.response.b.a.db(com.kwad.sdk.core.response.b.e.eb(aVar.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    public final synchronized boolean fe() {
        Iterator<com.kwad.components.core.internal.api.a> it = this.f11637pf.keySet().iterator();
        while (it.hasNext()) {
            if (E(it.next().getAdTemplate())) {
                return false;
            }
        }
        return this.f11638pg.isEmpty();
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.f11636pe.remove(cVar);
        }
    }
}
