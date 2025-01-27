package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class g extends b<com.aggmoread.sdk.z.d.a.a.c.o.d> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.o.e {

        /* renamed from: a */
        final /* synthetic */ b.g f5565a;

        public a(g gVar, b.g gVar2) {
            this.f5565a = gVar2;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5565a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.e
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
            b.g gVar = this.f5565a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.o.d> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.e) {
            ((com.aggmoread.sdk.z.d.a.a.c.o.e) fVar).onAdLoaded(list);
        }
    }
}
