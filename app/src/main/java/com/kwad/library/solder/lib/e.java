package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c amf;
    private final com.kwad.library.solder.lib.a.c amh;
    private final com.kwad.library.solder.lib.a.f ami;
    private final com.kwad.library.solder.lib.a.b amj;
    private final com.kwad.library.solder.lib.ext.a amk;
    private Map<String, b> aml;

    /* renamed from: com.kwad.library.solder.lib.e$1 */
    public class AnonymousClass1 implements Callable<com.kwad.library.solder.lib.a.e> {
        final /* synthetic */ com.kwad.library.solder.lib.a.e amm;
        final /* synthetic */ a amn;

        public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar, a aVar) {
            eVar = eVar;
            aVar = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: yl */
        public com.kwad.library.solder.lib.a.e call() {
            return e.this.a(eVar, aVar);
        }
    }

    public static abstract class a {
        final com.kwad.library.solder.lib.a.d amp;

        /* renamed from: com.kwad.library.solder.lib.e$a$a */
        public static class C0474a extends a {
            public C0474a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.amp.yh().g(eVar);
            }
        }

        public static class b extends a {
            public b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.amp.yi().k(eVar);
            }
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.amp = dVar;
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i10) {
            return i10 != 1 ? new C0474a(dVar) : new b(dVar);
        }

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);
    }

    public static class b {
        private final com.kwad.library.solder.lib.a.e amq;
        private final Future<com.kwad.library.solder.lib.a.e> amr;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.amq = eVar;
            this.amr = future;
        }

        public final void cancel() {
            this.amq.cancel();
            this.amr.cancel(true);
        }
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.amh = cVar;
        this.ami = fVar;
        this.amj = bVar;
        this.amf = cVar2;
        this.amk = aVar;
    }

    private b b(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        b bL = bL(eVar.yx());
        if (bL != null) {
            bL.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.amf.yQ().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            final /* synthetic */ com.kwad.library.solder.lib.a.e amm;
            final /* synthetic */ a amn;

            public AnonymousClass1(com.kwad.library.solder.lib.a.e eVar2, a aVar2) {
                eVar = eVar2;
                aVar = aVar2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: yl */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar2.yx(), bVar);
        return bVar;
    }

    @Nullable
    private synchronized b bL(String str) {
        Map<String, b> d10 = d(this.aml);
        this.aml = d10;
        if (str == null) {
            return null;
        }
        return d10.get(str);
    }

    private static Map<String, b> d(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.yt() == null) {
            eVar.a(this);
        }
        eVar.yx();
        eVar.yu();
        aVar.j(eVar);
        return eVar;
    }

    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bL = bL(eVar.yx());
        if (bL != null) {
            bL.cancel();
        }
        a(eVar.yx(), (b) null);
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c yg() {
        return this.amf;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c yh() {
        return this.amh;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f yi() {
        return this.ami;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b yj() {
        return this.amj;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a yk() {
        return this.amk;
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i10) {
        return b(eVar, a.a(this, 16));
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> d10 = d(this.aml);
        this.aml = d10;
        if (str != null) {
            d10.put(str, bVar);
        }
    }
}
