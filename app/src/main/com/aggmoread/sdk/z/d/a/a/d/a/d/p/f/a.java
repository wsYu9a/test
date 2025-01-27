package com.aggmoread.sdk.z.d.a.a.d.a.d.p.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.aggmoread.sdk.z.b.h.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: p */
    private c f5435p;

    /* renamed from: q */
    private com.aggmoread.sdk.z.b.a f5436q;

    /* renamed from: r */
    private AtomicBoolean f5437r;

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.s.c f5438s;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.p.f.a$a */
    public class C0123a implements com.aggmoread.sdk.z.b.s.c {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.p.f.a$a$a */
        public class RunnableC0124a implements Runnable {

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.p.f.a$a$a$a */
            public class RunnableC0125a implements Runnable {
                public RunnableC0125a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.a(((g) a.this).f5343n, 2);
                }
            }

            public RunnableC0124a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f5842g.f5856b;
                Object[] objArr = ((g) aVar).f5343n;
                a aVar2 = a.this;
                l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
                a aVar3 = a.this;
                l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
                byte[] b10 = a.this.f5842g.f5872r.b();
                if (b10 != null) {
                    l.a(a.this.f5842g.f5856b, b10);
                }
                l.a((Object) ((g) a.this).f5343n, true, true);
                l.a(((g) a.this).f5343n, a.this.f5843h);
                n.a(new RunnableC0125a(), 500L);
            }
        }

        public C0123a() {
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void a() {
            e.b("AMITAGBD", "onADClosed");
            a.this.s();
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void d() {
            e.b("AMITAGBD", "onADExposure");
            a.this.t();
            n.a(new RunnableC0124a(), 1L);
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void onAdClicked() {
            e.b("AMITAGBD", "onADClicked");
            a.this.r();
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void onAdShow() {
            e.b("AMITAGBD", "onADOpened");
            a.this.v();
        }

        @Override // com.aggmoread.sdk.z.b.s.c
        public void a(com.aggmoread.sdk.z.b.a aVar) {
            e.b("AMITAGBD", "onAdLoaded");
            a.this.f5436q = aVar;
            int d10 = a.this.f5436q.d();
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(a.this.f5843h, d10)) {
                a.this.a(d10, 0);
                return;
            }
            a.this.b(d10);
            a aVar2 = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.b(aVar2.f5841f, d10, aVar2.f5843h);
            a.this.u();
        }

        @Override // com.aggmoread.sdk.z.b.i.b
        public void a(com.aggmoread.sdk.z.b.g.e eVar) {
            e.b("AMITAGBD", "onAdError");
            a.this.b(new i(eVar.a(), eVar.b()));
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5442b;

        public b(Activity activity) {
            this.f5442b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5436q != null) {
                a.this.f5436q.a(this.f5442b, null);
            }
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5437r = new AtomicBoolean();
        this.f5438s = new C0123a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        e.b("AMITAGBD", "show()");
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            a((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void destroy() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        com.aggmoread.sdk.z.b.a aVar = this.f5436q;
        return aVar == null ? "" : aVar.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        e.b("AMITAGBD", "handle");
        com.aggmoread.sdk.z.d.a.a.d.a.d.p.c.a().a(this.f5842g.f5858d);
        this.f5342m = false;
        try {
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("inter_")) {
                c10 = c10.replace("inter_", "").trim();
            }
            this.f5435p = new c.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(true).c(this.f5842g.f5868n).a(c10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.p.b.a(this.f5843h)).d();
            new k(this.f5842g, this.f5843h).a(0).b();
            this.f5435p.a(this.f5438s);
        } catch (Exception e10) {
            e10.printStackTrace();
            b(new i(1001002008, "广告请求失败!"));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 activity = " + activity);
        if (this.f5342m && this.f5436q != null && this.f5437r.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 ");
            if (activity == null) {
                super.b();
                return;
            }
            try {
                activity.getWindow().getDecorView().post(new b(activity));
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #3 " + e10.getMessage());
                com.aggmoread.sdk.z.b.a aVar = this.f5436q;
                if (aVar != null) {
                    aVar.a(activity, null);
                }
            }
        }
    }
}
