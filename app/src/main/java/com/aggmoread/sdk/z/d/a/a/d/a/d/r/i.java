package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class i extends b<com.aggmoread.sdk.z.d.a.a.c.q.b> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.q.c {

        /* renamed from: a */
        final /* synthetic */ b.g f5567a;

        public a(i iVar, b.g gVar) {
            this.f5567a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5567a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.c
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.q.b> list) {
            b.g gVar = this.f5567a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.q.c
        public void onAdVideoCached() {
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.q.b> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.q.b> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.q.c) {
            ((com.aggmoread.sdk.z.d.a.a.c.q.c) fVar).onAdLoaded(list);
        }
    }
}
