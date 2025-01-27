package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.h;

import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.c.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.m;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends j implements TTAdNative.CSJSplashAdListener {
    private boolean A;

    /* renamed from: x */
    private CSJSplashAd f5639x;

    /* renamed from: y */
    private TTAdNative f5640y;

    /* renamed from: z */
    private AtomicBoolean f5641z;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.h.a$a */
    public class RunnableC0154a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.m.a f5642b;

        public RunnableC0154a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar) {
            this.f5642b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View c10 = a.this.c(this.f5642b);
            if (c10 == null) {
                a.super.a(this.f5642b);
            } else {
                a.this.a(this.f5642b, new View[]{c10});
            }
        }
    }

    public class b implements CSJSplashAd.SplashAdListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.h.a$b$a */
        public class RunnableC0155a implements Runnable {
            public RunnableC0155a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.v();
            }
        }

        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
            a.this.q();
            n.a(new RunnableC0155a(), 1000L);
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i10) {
            a.this.v();
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
        public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
            a.this.w();
            a.this.s();
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5641z = new AtomicBoolean();
        this.A = false;
    }

    private View a(ViewGroup viewGroup, String str, String str2) {
        View a10;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (str.equals(childAt.getClass().getName())) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "ff ");
                return childAt;
            }
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.a(childAt, str2)) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (a10 = a((ViewGroup) childAt, str, str2)) != null) {
                return a10;
            }
        }
        return null;
    }

    public View c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        try {
            View a10 = a(viewGroup, "com.bytedance.sdk.openadsdk.widget.TTCountdownView", "tt_splash_skip_btn");
            if (a10 == null) {
                int identifier = this.f5842g.f5858d.getResources().getIdentifier("tt_splash_skip_btn", "id", this.f5842g.f5858d.getPackageName());
                a10 = viewGroup.findViewById(identifier);
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "tmp view = " + a10 + ", idd = " + identifier);
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "tmp view = " + a10);
            return a10;
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "err  = " + e10);
            return null;
        }
    }

    private void u() {
        int i10;
        int i11;
        if (m.a(this.f5842g.f5858d) == null) {
            b(new i(1001003005, "当前传入Activity为空"));
            return;
        }
        boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), null);
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "isInit " + c10);
        if (!c10) {
            b(new i(1001003005, "csj: MSDK未初始化，请稍后重试!"));
            return;
        }
        this.f5640y = TTAdSdk.getAdManager().createAdNative(this.f5842g.f5858d);
        h hVar = this.f5842g.f5871q;
        if (hVar != null) {
            i10 = hVar.b();
            i11 = this.f5842g.f5871q.a();
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (i10 <= 0) {
            i10 = q.b(this.f5842g.f5858d);
        }
        if (i11 <= 0) {
            i11 = q.a(this.f5842g.f5858d);
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAGCSJ", "width " + i10 + ",height " + i11);
        AdSlot build = new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(e.c.T)).setSupportDeepLink(true).setImageAcceptedSize(i10, i11).build();
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5640y.loadSplashAd(build, this, this.f5842g.f5868n);
    }

    public void v() {
        r();
    }

    public void w() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5841f, this.f5639x);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void b(ViewGroup viewGroup) {
        if (viewGroup == null || this.f5639x == null || !this.f5641z.compareAndSet(false, true)) {
            return;
        }
        a(viewGroup, this.f5639x);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5376p;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().f(this.f5376p.get());
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadFail(CSJAdError cSJAdError) {
        b(new i(cSJAdError.getCode(), cSJAdError.getMsg()));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        this.A = true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
        if (this.A) {
            b(new i(cSJAdError.getCode(), cSJAdError.getMsg()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
        this.f5639x = cSJSplashAd;
        w();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(View view) {
        this.f5378r = false;
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), null);
        u();
    }

    private void a(ViewGroup viewGroup, CSJSplashAd cSJSplashAd) {
        cSJSplashAd.setSplashAdListener(new b());
        View splashView = cSJSplashAd.getSplashView();
        viewGroup.removeAllViews();
        if (splashView.getParent() != null) {
            ((ViewGroup) splashView.getParent()).removeView(splashView);
        }
        viewGroup.addView(splashView);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar) {
        n.a(new RunnableC0154a(aVar), 100L);
    }
}
