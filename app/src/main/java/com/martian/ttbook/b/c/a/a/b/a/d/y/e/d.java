package com.martian.ttbook.b.c.a.a.b.a.d.y.e;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.ttbook.b.c.a.a.b.a.d.y.d.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class d extends com.martian.ttbook.b.c.a.a.b.a.d.e implements TTNativeExpressAd.ExpressAdInteractionListener {
    private TTNativeExpressAd m;
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> n;
    private View o;
    private b p;
    private AtomicBoolean q;

    class a implements b.a {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void b() {
            d.this.p.i(d.this);
            com.martian.ttbook.b.c.a.a.d.b.m.a i2 = d.this.i();
            if (i2 != null) {
                i2.removeAllViews();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void onCancel() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.d.b.a
        public void onShow() {
        }
    }

    public interface b {
        void f(d dVar);

        void g(d dVar);

        void i(d dVar);

        void j(d dVar);

        void t(d dVar, String str, int i2);
    }

    public d(TTNativeExpressAd tTNativeExpressAd, com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map, b bVar) {
        super(dVar, eVar, map);
        this.q = new AtomicBoolean();
        this.p = bVar;
        this.m = tTNativeExpressAd;
        tTNativeExpressAd.setExpressInteractionListener(this);
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.l, tTNativeExpressAd, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void a(Activity activity) {
        render();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void b() {
        TTNativeExpressAd tTNativeExpressAd = this.m;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.m = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.e, com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public View getView() {
        if (this.o == null) {
            this.o = this.m.getExpressAdView();
        }
        if (this.o == null) {
            return null;
        }
        com.martian.ttbook.b.c.a.a.d.b.m.a i2 = i();
        if (i2 == null) {
            i2 = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15212c.f15670d);
            i2.addView(this.o, new FrameLayout.LayoutParams(-1, -2));
            this.n = new WeakReference<>(i2);
        }
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "get ");
        return i2;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.a
    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.n;
        return weakReference != null ? weakReference.get() : super.i();
    }

    public boolean k() {
        return this.q.compareAndSet(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        this.p.f(this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        this.p.j(this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        this.p.t(this, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onRenderSuccess");
        this.p.g(this);
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback");
            this.m.setDislikeCallback((Activity) this.f15212c.f15670d, (TTAdDislike.DislikeInteractionCallback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new com.martian.ttbook.b.c.a.a.b.a.d.y.d.b(new a())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.b
    public void render() {
        if (this.m != null) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "render");
            this.m.render();
        }
    }
}
