package com.martian.ttbook.b.c.a.a.b.a.d.c.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
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
public class a extends g {

    /* renamed from: f */
    private c f15377f;

    /* renamed from: g */
    private boolean f15378g;

    /* renamed from: h */
    private Object[] f15379h;

    /* renamed from: j */
    private AtomicBoolean f15380j;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.f.a$a */
    class C0314a implements p<View> {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.f.a$a$a */
        class RunnableC0315a implements Runnable {
            RunnableC0315a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15379h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15379h, true, true);
                l.q(a.this.f15379h, 2);
            }
        }

        C0314a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void a(i iVar) {
            d.g("VVINTAG", "onError  " + iVar);
            a.this.J(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        /* renamed from: b */
        public void a(View view) {
            d.g("VVINTAG", "onInterstitialAdLoad");
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(a.this.f15377f.g());
            if (com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(a.this.f15663d, c2)) {
                a.this.A(0);
                return;
            }
            a.this.B(c2);
            a.this.f15378g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(aVar2.f15661b, c2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdClicked() {
            d.g("VVINTAG", "onADClicked");
            l.i(a.this.f15379h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15379h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdDismissed() {
            d.g("VVINTAG", "onADClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdExposed() {
            d.g("VVINTAG", "onADExposure");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdExposed();
            }
            n.c(new RunnableC0315a(), 1L);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.p
        public void onAdShow() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
            }
        }
    }

    class b implements o {

        /* renamed from: a */
        final /* synthetic */ Activity f15383a;

        b(Activity activity) {
            this.f15383a = activity;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            d.g("VVINTAG", "init success");
            a.this.G(this.f15383a);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            a.this.J(new i(-1000, "广告加载失败！"));
            d.g("VVINTAG", "returen #1");
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15378g = false;
        this.f15380j = new AtomicBoolean();
        this.f15379h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void J(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15378g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    protected void G(Activity activity) {
        String l = this.f15663d.f15701c.l(e.c.Q);
        d.g("VVINTAG", "handle #3");
        this.f15378g = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        d.g("VVINTAG", "load ad");
        this.f15377f.h(activity, l, this.f15662c.f15674h);
    }

    protected p<View> K() {
        return new C0314a();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        c cVar = this.f15377f;
        if (cVar != null) {
            cVar.c(i2, i3, str);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        c cVar = this.f15377f;
        if (cVar != null) {
            cVar.a();
            this.f15377f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        c cVar = this.f15377f;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show(Activity activity) {
        if (this.f15378g && this.f15377f != null && this.f15380j.compareAndSet(false, true)) {
            if (activity == null) {
                super.show();
            } else {
                this.f15377f.d(activity);
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("VVINTAG", "handle enter");
        Activity d2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.d(this.f15662c.f15670d);
        if (d2 == null) {
            J(new i(-1001, "当前传入Activity为空"));
        } else {
            this.f15377f = new c(K());
            com.martian.ttbook.b.c.a.a.b.a.d.n.b(d2.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new b(d2));
        }
    }
}
