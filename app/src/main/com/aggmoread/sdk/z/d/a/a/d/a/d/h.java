package com.aggmoread.sdk.z.d.a.a.d.a.d;

import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends com.aggmoread.sdk.z.d.a.a.d.b.a {

    /* renamed from: m */
    protected boolean f5357m;

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f5358b;

        public a(List list) {
            this.f5358b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.o.e) h.this.f5842g.f5861g).onAdLoaded(this.f5358b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f5360b;

        public b(List list) {
            this.f5360b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.o.c) h.this.f5842g.f5861g).b(this.f5360b);
        }
    }

    public h(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5357m = false;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void a(int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bidding floor " + i10);
        com.aggmoread.sdk.z.d.a.a.d.b.i iVar = new com.aggmoread.sdk.z.d.a.a.d.b.i(1001006004, "广告无填充!");
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, i10)).b();
        if (this.f5843h.l()) {
            return;
        }
        this.f5842g.f5861g.a(iVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("AMHTAG", "onAdError %s", iVar);
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        if (this.f5357m || !this.f5843h.l()) {
            this.f5842g.f5861g.a(iVar);
        }
    }

    public void c(Object obj, int i10) {
    }

    public void e(List<com.aggmoread.sdk.z.d.a.a.c.o.d> list) {
        Runnable bVar;
        if (list == null || list.size() == 0) {
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(-1000, "广告无填充!"));
            return;
        }
        this.f5357m = true;
        this.f5843h.f5909e = list.size();
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, list.get(0).h())).a(k.b.B, Integer.valueOf(list.size())).b();
        com.aggmoread.sdk.z.d.a.a.c.f fVar = this.f5842g.f5861g;
        if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.e) {
            bVar = new a(list);
        } else if (!(fVar instanceof com.aggmoread.sdk.z.d.a.a.c.o.c)) {
            return;
        } else {
            bVar = new b(list);
        }
        com.aggmoread.sdk.z.d.a.a.e.n.a(bVar);
    }

    public boolean q() {
        return com.aggmoread.sdk.z.d.a.a.e.m.k(this.f5843h);
    }

    public final void a(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bidding floor " + i10);
        a(obj, 1, i10);
    }

    public final void b(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bidding win " + i10);
        if (!com.aggmoread.sdk.z.d.a.a.e.m.i(this.f5843h) && i10 > 0) {
            c(obj, i10);
        }
    }

    public void a(Object obj, int i10, int i11) {
    }
}
