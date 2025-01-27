package com.aggmoread.sdk.z.d.a.a.d.a.d.q.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.q.c;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class c extends com.aggmoread.sdk.z.d.a.a.d.a.d.c {

    /* renamed from: s */
    private String f5474s;

    /* renamed from: t */
    private ExpressResponse f5475t;

    /* renamed from: u */
    private com.aggmoread.sdk.z.d.a.a.d.b.m.a f5476u;

    /* renamed from: v */
    private View f5477v;

    /* renamed from: w */
    private AtomicBoolean f5478w;

    /* renamed from: x */
    private AtomicBoolean f5479x;

    public class a implements ExpressResponse.ExpressInteractionListener {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdClick() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, IAdInterListener.AdCommandType.AD_CLICK);
            c.this.s();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdExposed() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onAdExposed");
            c.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderFail(View view, String str, int i10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onAdRenderFail " + str + ", code " + i10);
            c.this.t();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderSuccess(View view, float f10, float f11) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onAdRenderSuccess");
            c.this.u();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdUnionClick() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onAdUnionClick");
        }
    }

    public class b implements c.g {
        public b() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.g
        public void a() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onDislikeWindowShow");
            c.this.x();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.g
        public void b() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onDislikeWindowClose");
            c.this.w();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.g
        public void c() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "onDislikeItemClick");
            c.this.v();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.e.c$c */
    public class ViewTreeObserverOnGlobalLayoutListenerC0130c implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0130c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewParent parent = c.this.f5476u.getParent();
            if (parent instanceof ViewGroup) {
                Context context = ((ViewGroup) parent).getContext();
                com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "getView onGlobalLayout " + context);
                if ((context instanceof Activity) && c.this.f5479x.compareAndSet(false, true)) {
                    com.aggmoread.sdk.z.d.a.a.e.e.b(c.this.f5474s, "getView bindInteractionActivity ");
                    c.this.f5475t.bindInteractionActivity((Activity) context);
                    c.this.f5476u.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    public c(ExpressResponse expressResponse, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5474s = "AMEPTAGBD";
        this.f5478w = new AtomicBoolean();
        this.f5479x = new AtomicBoolean();
        this.f5475t = expressResponse;
        q();
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(this.f5308p, com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) expressResponse), eVar);
        this.f5477v = expressResponse.getExpressAdView();
        this.f5476u = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(dVar.f5858d);
    }

    public void onAdShow() {
        this.f5278k = System.currentTimeMillis();
        l.a((Object) this.f5281n, true, true);
        if (r()) {
            k();
        }
    }

    private void q() {
        this.f5475t.setInteractionListener(new a());
        this.f5475t.setAdDislikeListener(com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.a().a(new b()));
    }

    public void s() {
        i();
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
        j();
    }

    public void w() {
    }

    public void x() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "ac " + this.f5476u);
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5476u;
        return aVar != null ? aVar : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10) {
        super.b(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5475t, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        if (this.f5475t != null) {
            this.f5475t = null;
            this.f5477v = null;
            this.f5476u = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a().a(this.f5475t);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "getView");
        if (this.f5477v == null) {
            this.f5477v = this.f5475t.getExpressAdView();
        }
        if (this.f5477v == null) {
            return null;
        }
        if (this.f5476u == null) {
            this.f5476u = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "getView " + this.f5476u);
        if (!this.f5479x.get()) {
            this.f5476u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0130c());
        }
        return this.f5476u;
    }

    public boolean r() {
        return this.f5478w.compareAndSet(false, true);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        ExpressResponse expressResponse;
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "render");
        if (this.f5477v == null || (expressResponse = this.f5475t) == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "render failed");
            return;
        }
        expressResponse.render();
        if (this.f5477v.getParent() != null || this.f5476u == null) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5474s, "render enter ");
        View[] viewArr = new View[0];
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5476u;
        if (aVar != null) {
            aVar.addView(this.f5477v, new FrameLayout.LayoutParams(-1, -2));
        }
        l.a(this.f5476u, this.f5281n);
        l.a(this.f5275h.f5856b, this.f5281n, i.INFORMATION_FLOW, this.f5476u, viewArr, new WeakReference(this.f5476u), null);
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

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5475t, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
