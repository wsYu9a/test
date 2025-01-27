package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class l extends b<com.aggmoread.sdk.z.d.a.a.c.r.a> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.r.b {

        /* renamed from: a */
        final /* synthetic */ b.g f5570a;

        public a(l lVar, b.g gVar) {
            this.f5570a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5570a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.b
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.r.a> list) {
            b.g gVar = this.f5570a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.r.b
        public void onAdVideoCached() {
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.r.a> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.r.a> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.r.b) {
            ((com.aggmoread.sdk.z.d.a.a.c.r.b) fVar).onAdLoaded(list);
        }
    }
}
