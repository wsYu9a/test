package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class j implements com.kwai.sodler.lib.a.e {
    private final com.kwai.sodler.lib.ext.c aJN;
    private final com.kwai.sodler.lib.a.d aJX;
    private final com.kwai.sodler.lib.a.g aJY;
    private final com.kwai.sodler.lib.a.c aJZ;
    private final com.kwai.sodler.lib.a.b aKa;
    private final com.kwai.sodler.lib.ext.a aKb;

    public static abstract class a {
        final com.kwai.sodler.lib.a.e aKc;

        /* renamed from: com.kwai.sodler.lib.j$a$a */
        static class C0250a extends a {
            public C0250a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jr().e(fVar);
            }
        }

        static class b extends a {
            b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jo().f(fVar);
            }
        }

        static class c extends a {
            c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aKc.Jp().i(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.aKc = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i2) {
            return i2 != 1 ? i2 != 256 ? new b(eVar) : new C0250a(eVar) : new c(eVar);
        }

        public abstract void m(com.kwai.sodler.lib.a.f fVar);
    }

    public j(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.aJX = dVar;
        this.aJY = gVar;
        this.aJZ = cVar;
        this.aJN = cVar2;
        this.aKb = aVar;
        this.aKa = bVar;
    }

    protected static Map f(Map map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c Jn() {
        return this.aJN;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d Jo() {
        return this.aJX;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g Jp() {
        return this.aJY;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c Jq() {
        return this.aJZ;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b Jr() {
        return this.aKa;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a Js() {
        return this.aKb;
    }

    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull a aVar) {
        if (fVar.JA() == null) {
            fVar.a(this);
        }
        StringBuilder sb = new StringBuilder("request id = ");
        sb.append(fVar.getId());
        sb.append(", state log = ");
        sb.append(fVar.JB());
        aVar.m(fVar);
        return fVar;
    }
}
