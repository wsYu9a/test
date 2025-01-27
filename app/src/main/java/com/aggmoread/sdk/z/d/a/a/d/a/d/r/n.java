package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class n extends b<com.aggmoread.sdk.z.d.a.a.c.o.f> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.o.g {

        /* renamed from: a */
        final /* synthetic */ b.g f5572a;

        public a(n nVar, b.g gVar) {
            this.f5572a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5572a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.g
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.o.f> list) {
            b.g gVar = this.f5572a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.o.f> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.o.f> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.g) {
            ((com.aggmoread.sdk.z.d.a.a.c.o.g) fVar).onAdLoaded(list);
        }
    }
}
