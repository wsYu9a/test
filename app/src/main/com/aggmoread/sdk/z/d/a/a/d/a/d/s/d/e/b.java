package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.a.d.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends c implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* renamed from: s */
    private String f5610s;

    /* renamed from: t */
    private TTNativeExpressAd f5611t;

    /* renamed from: u */
    private WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5612u;

    /* renamed from: v */
    private View f5613v;

    /* renamed from: w */
    private InterfaceC0150b f5614w;

    /* renamed from: x */
    private AtomicBoolean f5615x;

    /* renamed from: y */
    private View.OnAttachStateChangeListener f5616y;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b$a$a */
        public class C0149a implements TTAdDislike.DislikeInteractionCallback {
            public C0149a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                b.this.f5614w.d(b.this);
                com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = b.this.a();
                if (a10 != null) {
                    a10.removeAllViews();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Object parent = view.getParent();
            e.b(b.this.f5610s, "onViewAttachedToWindow  view " + view + ", viewParent " + parent);
            if (parent instanceof ViewGroup) {
                Activity a10 = m.a((View) parent);
                e.b(b.this.f5610s, " showActivity " + a10);
                if (b.this.f5611t == null || a10 == null) {
                    return;
                }
                b.this.f5611t.setDislikeCallback(a10, new C0149a());
                com.aggmoread.sdk.z.d.a.a.d.b.m.a a11 = b.this.a();
                if (a11 != null) {
                    a11.removeOnAttachStateChangeListener(b.this.f5616y);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b$b */
    public interface InterfaceC0150b {
        void a(b bVar);

        void a(b bVar, String str, int i10);

        void b(b bVar);

        void c(b bVar);

        void d(b bVar);
    }

    public b(TTNativeExpressAd tTNativeExpressAd, d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map, InterfaceC0150b interfaceC0150b) {
        super(dVar, eVar, map);
        this.f5610s = "AMEPTAGCSJ";
        this.f5615x = new AtomicBoolean();
        this.f5614w = interfaceC0150b;
        this.f5611t = tTNativeExpressAd;
        tTNativeExpressAd.setExpressInteractionListener(this);
        r();
    }

    private void r() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5308p, this.f5611t);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5612u;
        return weakReference != null ? weakReference.get() : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void destroy() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        TTNativeExpressAd tTNativeExpressAd = this.f5611t;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.f5611t = null;
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a();
        if (a10 == null || (onAttachStateChangeListener = this.f5616y) == null) {
            return;
        }
        a10.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c
    public String getTitle() {
        if (TextUtils.isEmpty(null)) {
            return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().e(this.f5612u.get());
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public View getView() {
        if (this.f5613v == null) {
            this.f5613v = this.f5611t.getExpressAdView();
        }
        if (this.f5613v == null) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a();
        if (a10 == null) {
            a10 = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d);
            if (this.f5613v.getParent() != null) {
                ((ViewGroup) this.f5613v.getParent()).removeView(this.f5613v);
            }
            a10.addView(this.f5613v, new FrameLayout.LayoutParams(-1, -2));
            this.f5612u = new WeakReference<>(a10);
            a aVar = new a();
            this.f5616y = aVar;
            a10.addOnAttachStateChangeListener(aVar);
        }
        return a10;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i10) {
        this.f5614w.c(this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i10) {
        r();
        this.f5614w.b(this);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i10) {
        this.f5614w.a(this, str, i10);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f10, float f11) {
        this.f5614w.a(this);
    }

    public boolean q() {
        return this.f5615x.compareAndSet(false, true);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void render() {
        TTNativeExpressAd tTNativeExpressAd = this.f5611t;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.o.d
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.c, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
    }
}
