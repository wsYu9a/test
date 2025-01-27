package com.aggmoread.sdk.z.d.a.a.d.a.d.w.f;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.aggmoread.sdk.z.b.s.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.aggmoread.sdk.z.e.f.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: p */
    private com.aggmoread.sdk.z.e.f.a f5829p;

    /* renamed from: q */
    private com.aggmoread.sdk.z.b.a f5830q;

    /* renamed from: r */
    private AtomicBoolean f5831r;

    /* renamed from: s */
    private c f5832s;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.w.f.a$a */
    public class C0178a implements c {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.w.f.a$a$a */
        public class RunnableC0179a implements Runnable {

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.w.f.a$a$a$a */
            public class RunnableC0180a implements Runnable {
                public RunnableC0180a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.a(((g) a.this).f5343n, 2);
                }
            }

            public RunnableC0179a() {
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
                n.a(new RunnableC0180a(), 500L);
            }
        }

        public C0178a() {
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
            n.a(new RunnableC0179a(), 1L);
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
            a.this.f5830q = aVar;
            int d10 = a.this.f5830q.d();
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.w.a.a(a.this.f5843h, d10)) {
                a.this.a(d10, 0);
                return;
            }
            a.this.b(d10);
            a aVar2 = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.w.a.b(aVar2.f5841f, d10, aVar2.f5843h);
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
        final /* synthetic */ Activity f5836b;

        public b(Activity activity) {
            this.f5836b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5830q != null) {
                a.this.f5830q.a(this.f5836b, null);
            }
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5831r = new AtomicBoolean();
        this.f5832s = new C0178a();
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
        com.aggmoread.sdk.z.b.a aVar = this.f5830q;
        return aVar == null ? "" : aVar.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String[] split;
        e.b("AMITAGBD", "handle");
        com.aggmoread.sdk.z.d.a.a.d.a.d.w.c.a().a(this.f5842g.f5858d);
        this.f5342m = false;
        try {
            int b10 = this.f5842g.f5871q.b();
            int a10 = this.f5842g.f5871q.a();
            if (b10 <= 0) {
                b10 = q.b(this.f5842g.f5858d);
            }
            if (a10 <= 0) {
                b10 = q.a(this.f5842g.f5858d);
            }
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("inter_test_")) {
                c10 = c10.replace("inter_test_", "").trim();
            }
            if (!TextUtils.isEmpty(c10) && c10.contains("#") && (split = c10.split("#")) != null && split.length > 1) {
                c10 = split[0];
                String str = split[1];
            }
            this.f5829p = new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(true).d(this.f5842g.f5868n).b(c10).c(this.f5843h.f5907c.c(e.c.X)).a(this.f5843h.f5907c.c(e.c.W)).d(this.f5843h.f5907c.c(e.c.f5921b0)).e(b10).c(a10).d();
            new k(this.f5842g, this.f5843h).a(0).b();
            this.f5829p.a(this.f5832s);
        } catch (Exception e10) {
            e10.printStackTrace();
            b(new i(1001002008, "广告请求失败!"));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 activity = " + activity);
        if (this.f5342m && this.f5830q != null && this.f5831r.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 ");
            if (activity == null) {
                super.b();
                return;
            }
            try {
                activity.getWindow().getDecorView().post(new b(activity));
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #3 " + e10.getMessage());
                com.aggmoread.sdk.z.b.a aVar = this.f5830q;
                if (aVar != null) {
                    aVar.a(activity, null);
                }
            }
        }
    }
}
