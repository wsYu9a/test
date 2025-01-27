package com.aggmoread.sdk.z.d.a.a.d.a.d.q.f;

import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.f;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: p */
    private FullScreenVideoAd f5497p;

    /* renamed from: q */
    private AtomicBoolean f5498q;

    /* renamed from: r */
    private FullScreenVideoAd.FullScreenVideoAdListener f5499r;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.f.a$a */
    public class C0133a implements FullScreenVideoAd.FullScreenVideoAdListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.f.a$a$a */
        public class RunnableC0134a implements Runnable {
            public RunnableC0134a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f5842g.f5856b;
                Object[] objArr = ((f) aVar).f5328n;
                a aVar2 = a.this;
                l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
                a aVar3 = a.this;
                l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
                byte[] b10 = a.this.f5842g.f5872r.b();
                if (b10 != null) {
                    l.a(a.this.f5842g.f5856b, b10);
                }
                l.a((Object) ((f) a.this).f5328n, true, true);
                l.a(((f) a.this).f5328n, a.this.f5843h);
            }
        }

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.f.a$a$b */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.a(((f) a.this).f5328n, 2);
            }
        }

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.f.a$a$c */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.a(((f) a.this).f5328n, 2);
            }
        }

        public C0133a() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            e.b("AMFTAGBD", "onADClicked");
            a.this.r();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f10) {
            e.b("AMFTAGBD", "onADClosed playScale = " + f10);
            a.this.s();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            e.b("AMFTAGBD", "failed " + str);
            a.this.b(new i(-1000, str));
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            e.b("AMFTAGBD", "onADReceive");
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) a.this.f5497p);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a.this.f5843h, a10)) {
                a.this.a(a10, 0);
                return;
            }
            a.this.b(a10);
            a aVar = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(aVar.f5841f, a10, aVar.f5843h);
            a.this.u();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            e.b("AMFTAGBD", "onAdShow");
            a.this.v();
            a.this.t();
            n.a(new RunnableC0134a(), 1L);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f10) {
            e.b("AMFTAGBD", "onAdSkip playScale = " + f10);
            n.a(new c(), 1000L);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            e.b("AMFTAGBD", "onVideoDownloadFailed");
            a.this.b(new i(-1000, "视频素材缓存失败"));
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadSuccess() {
            e.b("AMFTAGBD", "onVideoDownloadSuccess");
            a.this.w();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            e.b("AMFTAGBD", "playCompletion");
            n.a(new b(), 1000L);
            a.this.x();
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5498q = new AtomicBoolean();
        this.f5499r = new C0133a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.p.b
    public void b() {
        if (this.f5327m && this.f5497p != null && this.f5498q.compareAndSet(false, true)) {
            e.b("AMFTAGBD", "show #1 ");
            this.f5497p.show();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        e.c("win " + i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5497p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void destroy() {
        if (this.f5497p != null) {
            this.f5497p = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a().a(this.f5497p);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        if (m()) {
            return;
        }
        Context a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        String a11 = this.f5843h.f5907c.a(e.c.X, "");
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a10, a11);
        FullScreenVideoAd fullScreenVideoAd = new FullScreenVideoAd(a10.getApplicationContext(), this.f5843h.f5907c.c(e.c.T), this.f5499r);
        this.f5497p = fullScreenVideoAd;
        fullScreenVideoAd.setAppSid(a11);
        this.f5327m = false;
        new k(this.f5842g, this.f5843h).a(0).b();
        try {
            RequestParameters.Builder builder = new RequestParameters.Builder();
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5497p, builder.build());
        } catch (Exception unused) {
        }
        this.f5497p.load();
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMFTAGBD", "load enter");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5497p, "203");
    }
}
