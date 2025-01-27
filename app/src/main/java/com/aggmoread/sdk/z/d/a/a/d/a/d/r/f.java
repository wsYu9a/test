package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class f extends b<com.aggmoread.sdk.z.d.a.a.c.n.a> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.n.c {

        /* renamed from: a */
        final /* synthetic */ b.g f5564a;

        public a(f fVar, b.g gVar) {
            this.f5564a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5564a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.n.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.n.a> list) {
            b.g gVar = this.f5564a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.n.a> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.n.a> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.n.c) {
            ((com.aggmoread.sdk.z.d.a.a.c.n.c) fVar).onAdLoaded(list);
        }
    }
}
