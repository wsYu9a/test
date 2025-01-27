package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class c extends com.aggmoread.sdk.z.d.a.a.d.a.d.c {

    /* renamed from: s */
    private String f5760s;

    /* renamed from: t */
    private KsFeedAd f5761t;

    /* renamed from: u */
    private com.aggmoread.sdk.z.d.a.a.d.b.m.a f5762u;

    /* renamed from: v */
    private View f5763v;

    /* renamed from: w */
    private AtomicBoolean f5764w;

    public class b implements InvocationHandler {
        private b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                c.this.s();
                return null;
            }
            if ("onAdShow".equals(name)) {
                c.this.onAdShow();
                return null;
            }
            if ("onDislikeClicked".equals(name)) {
                c.this.t();
                return null;
            }
            if ("onDownloadTipsDialogShow".equals(name)) {
                c.this.v();
                return null;
            }
            if (!"onDownloadTipsDialogDismiss".equals(name)) {
                return null;
            }
            c.this.u();
            return null;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public c(KsFeedAd ksFeedAd, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5760s = "AMEPTAGKS";
        this.f5764w = new AtomicBoolean();
        this.f5761t = ksFeedAd;
        KsAdVideoPlayConfig ksAdVideoPlayConfig = null;
        this.f5761t.setAdInteractionListener((KsFeedAd.AdInteractionListener) Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{KsFeedAd.AdInteractionListener.class}, new b()));
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = dVar.f5873s;
        if (bVar != null) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(!bVar.d());
            builder.dataFlowAutoStart(bVar.a() == 1);
            ksAdVideoPlayConfig = builder.build();
        }
        this.f5761t.setVideoPlayConfig(ksAdVideoPlayConfig);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5308p, com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksFeedAd), eVar);
    }

    private void r() {
    }

    private void w() {
        KsFeedAd ksFeedAd = this.f5761t;
        if (ksFeedAd == null) {
            return;
        }
        if (this.f5763v == null) {
            this.f5763v = ksFeedAd.getFeedView(this.f5275h.f5858d.getApplicationContext());
        }
        if (this.f5763v != null && this.f5762u == null) {
            this.f5762u = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d.getApplicationContext());
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "ac " + this.f5762u);
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5762u;
        return aVar != null ? aVar : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10) {
        super.b(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5761t, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        if (this.f5761t != null) {
            this.f5761t = null;
            this.f5763v = null;
            this.f5762u = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a().a(this.f5761t);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "getView");
        w();
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "getView " + this.f5762u);
        return this.f5762u;
    }

    public void onAdShow() {
        this.f5278k = System.currentTimeMillis();
        l.a((Object) this.f5281n, true, true);
        if (q()) {
            k();
        }
    }

    public boolean q() {
        return this.f5764w.compareAndSet(false, true);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "render");
        w();
        View view = this.f5763v;
        if (view == null || this.f5761t == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "render failed");
            return;
        }
        if (view.getParent() != null || this.f5762u == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5760s, "render enter ");
        r();
        View[] viewArr = new View[0];
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5762u;
        if (aVar != null) {
            aVar.addView(this.f5763v, new FrameLayout.LayoutParams(-1, -2));
        }
        l.a(this.f5762u, this.f5281n);
        l.a(this.f5275h.f5856b, this.f5281n, i.INFORMATION_FLOW, this.f5762u, viewArr, new WeakReference(this.f5762u), null, Integer.valueOf(this.f5276i.f()));
        l.b(this.f5275h.f5856b, this.f5276i.e(), this.f5276i.b());
        byte[] b10 = this.f5275h.f5872r.b();
        if (b10 != null) {
            l.a(this.f5275h.f5856b, b10);
        }
        l.a(this.f5281n, this.f5276i);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void renderActivity(Activity activity) {
        render();
    }

    public void s() {
        i();
    }

    public void t() {
        j();
    }

    public void u() {
    }

    public void v() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5761t, i11);
    }
}
