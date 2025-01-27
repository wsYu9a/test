package com.aggmoread.sdk.z.d.a.a.d.a.d.v.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.kwad.sdk.api.KsDrawAd;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.d.a.a.d.a.d.b {

    /* renamed from: t */
    private String f5753t;

    /* renamed from: u */
    private KsDrawAd f5754u;

    /* renamed from: v */
    private com.aggmoread.sdk.z.d.a.a.d.b.m.a f5755v;

    /* renamed from: w */
    private View f5756w;

    /* renamed from: x */
    private AtomicBoolean f5757x;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.e.b$b */
    public class C0171b implements InvocationHandler {
        private C0171b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if ("onAdClicked".equals(name)) {
                b.this.l();
                return null;
            }
            if ("onAdShow".equals(name)) {
                b.this.onAdShow();
                return null;
            }
            if ("onVideoPlayStart".equals(name)) {
                b.this.q();
                return null;
            }
            if ("onVideoPlayPause".equals(name)) {
                b.this.o();
                return null;
            }
            if ("onVideoPlayResume".equals(name)) {
                b.this.p();
                return null;
            }
            if ("onVideoPlayEnd".equals(name)) {
                b.this.m();
                return null;
            }
            if (!"onVideoPlayError".equals(name)) {
                return null;
            }
            b.this.n();
            return null;
        }

        public /* synthetic */ C0171b(b bVar, a aVar) {
            this();
        }
    }

    public b(KsDrawAd ksDrawAd, d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5753t = "AMDRAWTAGKS";
        this.f5757x = new AtomicBoolean();
        this.f5754u = ksDrawAd;
        this.f5754u.setAdInteractionListener((KsDrawAd.AdInteractionListener) Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{KsDrawAd.AdInteractionListener.class}, new C0171b()));
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5298p, com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksDrawAd), eVar);
    }

    private void k() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "ac " + this.f5755v);
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5755v;
        return aVar != null ? aVar : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10) {
        super.b(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5754u, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void destroy() {
        if (this.f5754u != null) {
            this.f5754u = null;
            this.f5756w = null;
            this.f5755v = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public String getTitle() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a().a(this.f5754u);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public View getView() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "getView");
        if (this.f5756w == null) {
            this.f5756w = this.f5754u.getDrawView(this.f5275h.f5858d.getApplicationContext());
        }
        if (this.f5756w == null) {
            return null;
        }
        if (this.f5755v == null) {
            this.f5755v = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d.getApplicationContext());
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "getView " + this.f5755v);
        return this.f5755v;
    }

    public boolean j() {
        return this.f5757x.compareAndSet(false, true);
    }

    public void l() {
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar;
        k kVar = new k(this.f5275h, this.f5276i);
        boolean a10 = kVar.a(k.b.f6046n, this.f5273f).a(this.f5276i, a(), this.f5278k, this.f5281n);
        kVar.b();
        l.a((Object) this.f5281n, false, true);
        if (!a10 || (bVar = this.f5300r) == null) {
            return;
        }
        bVar.onAdClicked();
    }

    public void m() {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoComplete();
        }
    }

    public void n() {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.a(new i(-1000, "ks:视频素材播放失败！"));
        }
    }

    public void o() {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoPause();
        }
    }

    public void onAdShow() {
        this.f5278k = System.currentTimeMillis();
        l.a((Object) this.f5281n, true, true);
        if (j()) {
            d();
        }
    }

    public void p() {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoStart();
        }
    }

    public void q() {
        com.aggmoread.sdk.z.d.a.a.c.n.d dVar = this.f5299q;
        if (dVar != null) {
            dVar.onVideoStart();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void render() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "render");
        View view = this.f5756w;
        if (view == null || this.f5754u == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "render failed");
            return;
        }
        if (view.getParent() != null || this.f5755v == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5753t, "render enter ");
        k();
        View[] viewArr = new View[0];
        if (this.f5755v != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            this.f5755v.addView(this.f5756w, layoutParams);
            com.aggmoread.sdk.z.d.a.a.c.n.b bVar = this.f5300r;
            if (bVar != null) {
                bVar.onRenderSuccess();
            }
        }
        l.a(this.f5755v, this.f5281n);
        l.a(this.f5275h.f5856b, this.f5281n, com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW, this.f5755v, viewArr, new WeakReference(this.f5755v), null, Integer.valueOf(this.f5276i.f()));
        l.b(this.f5275h.f5856b, this.f5276i.e(), this.f5276i.b());
        byte[] b10 = this.f5275h.f5872r.b();
        if (b10 != null) {
            l.a(this.f5275h.f5856b, b10);
        }
        l.a(this.f5281n, this.f5276i);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5754u, i11);
    }
}
