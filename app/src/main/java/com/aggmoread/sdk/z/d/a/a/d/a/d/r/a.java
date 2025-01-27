package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.List;

/* loaded from: classes.dex */
public class a extends b<com.aggmoread.sdk.z.d.a.a.c.m.a> {

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.r.a$a */
    public class C0140a implements com.aggmoread.sdk.z.d.a.a.c.m.b {

        /* renamed from: a */
        final /* synthetic */ b.g f5520a;

        public C0140a(a aVar, b.g gVar) {
            this.f5520a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
            b.g gVar = this.f5520a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.m.b
        public void onAdLoaded(List<com.aggmoread.sdk.z.d.a.a.c.m.a> list) {
            b.g gVar = this.f5520a;
            if (gVar != null) {
                gVar.onAdLoaded(list);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.m.a> gVar) {
        return new C0140a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.m.a> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.m.b) {
            ((com.aggmoread.sdk.z.d.a.a.c.m.b) fVar).onAdLoaded(list);
        }
    }
}
