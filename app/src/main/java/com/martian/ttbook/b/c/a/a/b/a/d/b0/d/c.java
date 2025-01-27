package com.martian.ttbook.b.c.a.a.b.a.d.b0.d;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class c extends com.martian.ttbook.b.c.a.a.b.a.d.e {
    private String m;
    private KsFeedAd n;
    private com.martian.ttbook.b.c.a.a.d.b.m.a o;
    private View p;
    private AtomicBoolean q;

    private class b implements InvocationHandler {
        private b() {
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                c.this.l();
                return null;
            }
            if ("onAdShow".equals(name)) {
                c.this.m();
                return null;
            }
            if ("onDislikeClicked".equals(name)) {
                c.this.o();
                return null;
            }
            if ("onDownloadTipsDialogShow".equals(name)) {
                c.this.q();
                return null;
            }
            if (!"onDownloadTipsDialogDismiss".equals(name)) {
                return null;
            }
            c.this.p();
            return null;
        }
    }

    public c(KsFeedAd ksFeedAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.m = "KSUNITAG";
        this.q = new AtomicBoolean();
        this.n = ksFeedAd;
        KsAdVideoPlayConfig ksAdVideoPlayConfig = null;
        this.n.setAdInteractionListener((KsFeedAd.AdInteractionListener) Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{KsFeedAd.AdInteractionListener.class}, new b()));
        com.martian.ttbook.b.c.a.a.c.q.b bVar = dVar.s;
        if (bVar != null) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(!bVar.k());
            builder.dataFlowAutoStart(bVar.a() == 1);
            ksAdVideoPlayConfig = builder.build();
        }
        this.n.setVideoPlayConfig(ksAdVideoPlayConfig);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.h(this.l, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksFeedAd), eVar);
    }

    private void k() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(this.n, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        if (this.n != null) {
            this.n = null;
            this.p = null;
            this.o = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView");
        if (this.p == null) {
            this.p = this.n.getFeedView(this.f15212c.f15670d);
        }
        if (this.p == null) {
            return null;
        }
        if (this.o == null) {
            this.o = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "getView " + this.o);
        return this.o;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "ac " + this.o);
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.o;
        return aVar != null ? aVar : super.i();
    }

    public boolean j() {
        return this.q.compareAndSet(false, true);
    }

    public void l() {
        k kVar = new k(this.f15212c, this.f15213d);
        boolean g2 = kVar.c(k.b.n, this.f15210a).g(this.f15213d, i(), this.f15215f, this.f15218j);
        kVar.h();
        l.i(this.f15218j, false, true);
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).i(this);
            }
        }
    }

    public void m() {
        this.f15215f = System.currentTimeMillis();
        l.i(this.f15218j, true, true);
        if (j()) {
            new k(this.f15212c, this.f15213d).a(5).c(k.b.n, this.f15210a).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).c(this);
            }
        }
    }

    public void o() {
        new k(this.f15212c, this.f15213d).c(k.b.n, this.f15210a).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15212c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).f(this);
        }
    }

    public void p() {
    }

    public void q() {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render");
        View view = this.p;
        if (view == null || this.n == null) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render failed");
            return;
        }
        if (view.getParent() != null || this.o == null) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.m, "render enter ");
        k();
        View[] viewArr = new View[0];
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar = this.o;
        if (aVar != null) {
            aVar.addView(this.p, new FrameLayout.LayoutParams(-1, -2));
        }
        l.c(this.o, this.f15218j);
        l.m(this.f15212c.f15668b, this.f15218j, h.INFORMATION_FLOW, this.o, viewArr, new WeakReference(this.o), null);
        l.s(this.f15212c.f15668b, this.f15213d.e(), this.f15213d.b());
        byte[] h2 = this.f15212c.r.h();
        if (h2 != null) {
            l.j(this.f15212c.f15668b, h2);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(this.n, i2);
    }
}
