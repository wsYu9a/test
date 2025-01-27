package com.martian.ttbook.b.c.a.a.b.a.d.c.f;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
import com.martian.ttbook.b.c.a.a.b.a.d.o;
import com.martian.ttbook.b.c.a.a.b.a.d.p;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends h {

    /* renamed from: f */
    private c f15385f;

    /* renamed from: g */
    private boolean f15386g;

    /* renamed from: h */
    private Object[] f15387h;

    /* renamed from: j */
    private AtomicBoolean f15388j;

    class a implements p<View> {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.f.b$a$a */
        class RunnableC0316a implements Runnable {
            RunnableC0316a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                Object obj = bVar.f15662c.f15668b;
                Object[] objArr = bVar.f15387h;
                b bVar2 = b.this;
                l.o(obj, objArr, bVar2.f15662c.f15671e, Integer.valueOf(bVar2.f15663d.f()));
                b bVar3 = b.this;
                l.s(bVar3.f15662c.f15668b, bVar3.f15663d.e(), b.this.f15663d.b());
                byte[] h2 = b.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(b.this.f15662c.f15668b, h2);
                }
                l.i(b.this.f15387h, true, true);
                l.q(b.this.f15387h, 2);
            }
        }

        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void a(i iVar) {
            d.g("VVINTAG", "onError  " + iVar);
            b.this.J(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        /* renamed from: b */
        public void a(View view) {
            d.g("VVINTAG", "onInterstitialAdLoad");
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(b.this.f15385f.g());
            if (com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(b.this.f15663d, c2)) {
                b.this.A(0);
                return;
            }
            b.this.B(c2);
            b.this.f15386g = true;
            b bVar = b.this;
            new k(bVar.f15662c, bVar.f15663d).a(4).h();
            b bVar2 = b.this;
            com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(bVar2.f15661b, c2, bVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(b.this);
            e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdClicked() {
            d.g("VVINTAG", "onADClicked");
            l.i(b.this.f15387h, false, true);
            b bVar = b.this;
            k kVar = new k(bVar.f15662c, bVar.f15663d);
            b bVar2 = b.this;
            boolean g2 = kVar.g(bVar2.f15663d, null, 0L, bVar2.f15387h);
            kVar.h();
            if (g2) {
                e eVar = b.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdDismissed() {
            d.g("VVINTAG", "onADClosed");
            b bVar = b.this;
            new k(bVar.f15662c, bVar.f15663d).a(1).h();
            e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdExposed() {
            d.g("VVINTAG", "onADExposure");
            b bVar = b.this;
            new k(bVar.f15662c, bVar.f15663d).a(5).c(k.b.q, b.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdExposed();
            }
            n.c(new RunnableC0316a(), 1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdShow() {
            com.martian.ttbook.b.c.a.a.c.e eVar = b.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdShow();
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.f.b$b */
    class C0317b implements o {

        /* renamed from: a */
        final /* synthetic */ Activity f15391a;

        C0317b(Activity activity) {
            this.f15391a = activity;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            d.g("VVINTAG", "init success");
            b.this.G(this.f15391a);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            b.this.J(new i(-1000, "广告加载失败！"));
            d.g("VVINTAG", "returen #1");
        }
    }

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15386g = false;
        this.f15388j = new AtomicBoolean();
        this.f15387h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void J(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15386g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    protected void G(Activity activity) {
        String l = this.f15663d.f15701c.l(e.c.Q);
        d.g("VVINTAG", "handle #3");
        this.f15386g = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        d.g("VVINTAG", "load ad");
        this.f15385f.e(activity, l, this.f15662c.f15674h);
    }

    protected p<View> K() {
        return new a();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        c cVar = this.f15385f;
        if (cVar != null) {
            cVar.c(i2, i3, str);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void b() {
        c cVar = this.f15385f;
        if (cVar != null) {
            cVar.a();
            this.f15385f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        c cVar = this.f15385f;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show() {
        if (this.f15386g && this.f15385f != null && this.f15388j.compareAndSet(false, true)) {
            this.f15385f.i();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("VVINTAG", "handle enter");
        Activity d2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.d(this.f15662c.f15670d);
        if (d2 == null) {
            J(new i(-1001, "当前传入Activity为空"));
        } else {
            this.f15385f = new c(K());
            com.martian.ttbook.b.c.a.a.b.a.d.n.b(d2.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new C0317b(d2));
        }
    }
}
