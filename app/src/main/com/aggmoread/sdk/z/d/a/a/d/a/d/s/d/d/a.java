package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends com.aggmoread.sdk.z.d.a.a.d.a.d.b implements MediationExpressRenderListener {

    /* renamed from: t */
    private String f5594t;

    /* renamed from: u */
    private TTDrawFeedAd f5595u;

    /* renamed from: v */
    private com.aggmoread.sdk.z.d.a.a.d.b.m.a f5596v;

    /* renamed from: w */
    private View.OnAttachStateChangeListener f5597w;

    /* renamed from: x */
    private View f5598x;

    /* renamed from: y */
    private AtomicBoolean f5599y;

    /* renamed from: z */
    private long f5600z;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.d.a$a */
    public class ViewOnAttachStateChangeListenerC0145a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ TTDrawFeedAd f5601a;

        /* renamed from: b */
        final /* synthetic */ d f5602b;

        /* renamed from: c */
        final /* synthetic */ e f5603c;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.d.a$a$a */
        public class C0146a implements TTAdDislike.DislikeInteractionCallback {
            public C0146a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                ViewOnAttachStateChangeListenerC0145a viewOnAttachStateChangeListenerC0145a = ViewOnAttachStateChangeListenerC0145a.this;
                new k(viewOnAttachStateChangeListenerC0145a.f5602b, viewOnAttachStateChangeListenerC0145a.f5603c).a(k.b.f6046n, a.this.f5273f).a(4).b();
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5300r != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5300r.a();
                }
                com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a.this.a();
                if (a10 != null) {
                    a10.removeAllViews();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }
        }

        public ViewOnAttachStateChangeListenerC0145a(TTDrawFeedAd tTDrawFeedAd, d dVar, e eVar) {
            this.f5601a = tTDrawFeedAd;
            this.f5602b = dVar;
            this.f5603c = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            TTDrawFeedAd tTDrawFeedAd;
            Object parent = view.getParent();
            com.aggmoread.sdk.z.d.a.a.e.e.b(a.this.f5594t, "onViewAttachedToWindow  view " + view + ", viewParent " + parent);
            if (parent instanceof ViewGroup) {
                Activity a10 = m.a((View) parent);
                com.aggmoread.sdk.z.d.a.a.e.e.b(a.this.f5594t, " showActivity " + a10);
                if (a10 == null || (tTDrawFeedAd = this.f5601a) == null) {
                    return;
                }
                tTDrawFeedAd.setDislikeCallback(a10, new C0146a());
                a.this.f5596v.removeOnAttachStateChangeListener(a.this.f5597w);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(TTDrawFeedAd tTDrawFeedAd, d dVar, e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5594t = "AMDRAWTAGCSJ";
        this.f5599y = new AtomicBoolean();
        this.f5595u = tTDrawFeedAd;
        tTDrawFeedAd.setExpressRenderListener(this);
        a(tTDrawFeedAd, dVar, eVar);
        k();
    }

    private void k() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.a(this.f5298p, this.f5595u);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5596v;
        return aVar != null ? aVar : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void destroy() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        TTDrawFeedAd tTDrawFeedAd = this.f5595u;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.destroy();
            this.f5595u = null;
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a();
        if (a10 == null || (onAttachStateChangeListener = this.f5597w) == null) {
            return;
        }
        a10.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public String getTitle() {
        if (TextUtils.isEmpty(null)) {
            return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.c().e(a());
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public View getView() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5594t, "gv ");
        return a();
    }

    public boolean j() {
        return this.f5599y.compareAndSet(false, true);
    }

    public void onAdClick() {
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar;
        k kVar = new k(this.f5275h, this.f5276i);
        boolean a10 = kVar.a(k.b.f6046n, this.f5273f).a(this.f5276i, a(), this.f5600z, this.f5281n);
        kVar.b();
        l.a((Object) this.f5281n, false, true);
        if (!a10 || (bVar = this.f5300r) == null) {
            return;
        }
        bVar.onAdClicked();
    }

    public void onAdShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5594t, "onAdShow ");
        k();
        if (j()) {
            this.f5600z = System.currentTimeMillis();
            com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a();
            l.a(a10, this.f5281n);
            l.a(this.f5275h.f5856b, this.f5281n, i.INFORMATION_FLOW, a10, new View[0], new WeakReference(a10), null);
            l.b(this.f5275h.f5856b, this.f5276i.e(), this.f5276i.b());
            byte[] b10 = this.f5275h.f5872r.b();
            if (b10 != null) {
                l.a(this.f5275h.f5856b, b10);
            }
            l.a((Object) this.f5281n, true, true);
            l.a(this.f5281n, this.f5276i);
            d();
        }
    }

    public void onRenderFail(View view, String str, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5594t, "onRenderFail ");
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar = this.f5300r;
        if (bVar != null) {
            bVar.onRenderFail();
        }
    }

    public void onRenderSuccess(View view, float f10, float f11, boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5594t, "onRenderSuccess ");
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar = this.f5300r;
        if (bVar != null) {
            bVar.onRenderSuccess();
        }
        if (this.f5598x == null) {
            this.f5598x = this.f5595u.getAdView();
        }
        View view2 = this.f5598x;
        if (view2 == null) {
            return;
        }
        if (view2.getParent() != null) {
            ((ViewGroup) this.f5598x.getParent()).removeView(this.f5598x);
        }
        com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = a();
        if (a10 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            a10.addView(this.f5598x, layoutParams);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void render() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5594t, "re ");
        TTDrawFeedAd tTDrawFeedAd = this.f5595u;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.render();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void renderActivity(Activity activity) {
        render();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
    }

    private void a(TTDrawFeedAd tTDrawFeedAd, d dVar, e eVar) {
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(dVar.f5858d.getApplicationContext());
        this.f5596v = aVar;
        ViewOnAttachStateChangeListenerC0145a viewOnAttachStateChangeListenerC0145a = new ViewOnAttachStateChangeListenerC0145a(tTDrawFeedAd, dVar, eVar);
        this.f5597w = viewOnAttachStateChangeListenerC0145a;
        aVar.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC0145a);
    }
}
