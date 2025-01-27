package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.a.d.r.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class j extends b<com.aggmoread.sdk.z.d.a.a.c.a> {

    public class a implements com.aggmoread.sdk.z.d.a.a.c.o.c {

        /* renamed from: a */
        final /* synthetic */ b.g f5568a;

        public a(j jVar, b.g gVar) {
            this.f5568a = gVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.f
        public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.c
        public void b(List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
            if (this.f5568a != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.aggmoread.sdk.z.d.a.a.c.o.d> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.f5568a.onAdLoaded(arrayList);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.o.c
        public void a(List<com.aggmoread.sdk.z.d.a.a.c.o.f> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.aggmoread.sdk.z.d.a.a.c.o.f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            this.f5568a.onAdLoaded(arrayList);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public com.aggmoread.sdk.z.d.a.a.c.f a(com.aggmoread.sdk.z.d.a.a.c.f fVar, b.g<com.aggmoread.sdk.z.d.a.a.c.a> gVar) {
        return new a(this, gVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.r.b
    public void a(com.aggmoread.sdk.z.d.a.a.c.f fVar, List<com.aggmoread.sdk.z.d.a.a.c.a> list) {
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.c) {
            com.aggmoread.sdk.z.d.a.a.c.a aVar = list.get(0);
            if (aVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.d) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((com.aggmoread.sdk.z.d.a.a.c.o.d) aVar);
                ((com.aggmoread.sdk.z.d.a.a.c.o.c) fVar).b(arrayList);
            } else if (aVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.f) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add((com.aggmoread.sdk.z.d.a.a.c.o.f) aVar);
                ((com.aggmoread.sdk.z.d.a.a.c.o.c) fVar).a(arrayList2);
            }
        }
    }
}
