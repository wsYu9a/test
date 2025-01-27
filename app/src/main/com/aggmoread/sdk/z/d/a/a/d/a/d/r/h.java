package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class h extends b<com.aggmoread.sdk.z.d.a.a.c.p.b> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.p.c {

        /* renamed from: a */
        final /* synthetic */ b.g f5566a;

        public a(h hVar, b.g gVar) {
            this.f5566a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5566a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.p.b> list) {
            b.g gVar = this.f5566a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.p.c
        public void onAdVideoCached() {
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.p.b> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.p.b> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.p.c) {
            ((com.aggmoread.sdk.z.d.a.a.c.p.c) fVar).onAdLoaded(list);
        }
    }
}
