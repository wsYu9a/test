package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class j extends com.aggmoread.sdk.z.d.a.a.d.b.a implements com.aggmoread.sdk.z.d.a.a.c.s.a {

    /* renamed from: w */
    private static String f5372w = "AMSTAG";

    /* renamed from: m */
    private ViewGroup f5373m;

    /* renamed from: n */
    private View f5374n;

    /* renamed from: o */
    public Object[] f5375o;

    /* renamed from: p */
    public WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5376p;

    /* renamed from: q */
    public boolean f5377q;

    /* renamed from: r */
    protected boolean f5378r;

    /* renamed from: s */
    protected boolean f5379s;

    /* renamed from: t */
    private boolean f5380t;

    /* renamed from: u */
    private AtomicBoolean f5381u;

    /* renamed from: v */
    protected com.aggmoread.sdk.z.d.a.a.c.s.c f5382v;

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ List f5383b;

        public a(List list) {
            this.f5383b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((com.aggmoread.sdk.z.d.a.a.c.s.b) j.this.f5842g.f5861g).onAdLoaded(this.f5383b);
        }
    }

    public j(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5376p = null;
        this.f5377q = false;
        this.f5378r = true;
        this.f5379s = false;
        this.f5380t = false;
        this.f5381u = new AtomicBoolean();
        this.f5375o = com.aggmoread.sdk.z.d.a.a.b.b();
    }

    public ViewGroup a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar, ViewGroup viewGroup, boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "wac enter ");
        aVar.f6064e = true;
        com.aggmoread.sdk.z.d.a.a.d.b.l.a(aVar, this.f5375o);
        aVar.addOnAttachStateChangeListener(new com.aggmoread.sdk.z.d.a.a.d.b.m.b());
        aVar.setBackgroundColor(0);
        viewGroup.addView(aVar, -1, -1);
        com.aggmoread.sdk.z.d.a.a.d.b.m.c cVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.c(viewGroup.getContext());
        cVar.setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setBackgroundColor(0);
        cVar.addView(frameLayout, -1, -1);
        aVar.addView(cVar, -1, -1);
        if (z10) {
            cVar.a(this.f5373m);
            this.f5377q = true;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "wac exist ");
        return frameLayout;
    }

    public abstract void a(View view);

    @Override // com.aggmoread.sdk.z.d.a.a.c.s.a
    public final void b() {
        ViewGroup viewGroup = this.f5842g.f5864j;
        if (viewGroup != null) {
            a(viewGroup);
        }
    }

    public abstract void b(ViewGroup viewGroup);

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.s.a
    public void destroy() {
    }

    public void e(List<com.aggmoread.sdk.z.d.a.a.c.s.a> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "onAdLoaded");
        this.f5846k.a();
        this.f5380t = true;
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(3).a(k.b.f6049q, com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5842g, this.f5843h, this.f5841f)).b();
        if (this.f5842g.f5861g instanceof com.aggmoread.sdk.z.d.a.a.c.s.b) {
            com.aggmoread.sdk.z.d.a.a.e.n.a(new a(list));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public String getID() {
        return this.f5842g.f5857c;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return com.aggmoread.sdk.z.d.a.a.e.m.a(this.f5841f);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public final void l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "handle");
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar = this.f5842g;
        a(dVar, dVar.f5858d);
        a((View) this.f5373m);
    }

    public void q() {
        com.aggmoread.sdk.z.d.a.a.c.s.c cVar;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "onAdClicked");
        this.f5379s = false;
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h);
        com.aggmoread.sdk.z.d.a.a.d.b.e eVar = this.f5843h;
        WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> weakReference = this.f5376p;
        boolean a10 = kVar.a(eVar, weakReference == null ? null : weakReference.get(), 0L, this.f5375o);
        kVar.b();
        if (!a10 || (cVar = this.f5382v) == null) {
            return;
        }
        cVar.onAdClicked();
    }

    public void r() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "onAdClosed");
        if (this.f5379s) {
            t();
        }
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(4).b();
        com.aggmoread.sdk.z.d.a.a.c.s.c cVar = this.f5382v;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void s() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "onAdExposure");
        a((com.aggmoread.sdk.z.d.a.a.c.e) this.f5382v);
    }

    public void t() {
        com.aggmoread.sdk.z.d.a.a.c.s.c cVar = this.f5382v;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(int i10) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            c(i10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(int i10, int i11, String str) {
        if (com.aggmoread.sdk.z.d.a.a.e.m.h(this.f5843h)) {
            b(i10, i11, str);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
        com.aggmoread.sdk.z.d.a.a.c.f fVar;
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5372w, "onAdError %s", iVar);
        this.f5846k.a();
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(8).a(iVar).b();
        if (this.f5380t) {
            fVar = this.f5382v;
            if (fVar == null) {
                return;
            }
        } else if (this.f5843h.l()) {
            return;
        } else {
            fVar = this.f5842g.f5861g;
        }
        fVar.a(iVar);
    }

    public void a(long j10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5372w, "onAdTick %s", Long.valueOf(j10));
        View view = this.f5374n;
        if (view instanceof TextView) {
            ((TextView) view).setText(String.format(" 跳过 %d", Integer.valueOf((int) (j10 / 1000))));
        }
        com.aggmoread.sdk.z.d.a.a.c.s.c cVar = this.f5382v;
        if (cVar != null) {
            cVar.onAdTick(j10);
        }
        if (j10 <= 600) {
            this.f5379s = false;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.s.a
    public void a(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "show");
        try {
            if (this.f5381u.compareAndSet(false, true)) {
                com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5842g.f5858d);
                ViewGroup a10 = a(aVar, viewGroup, this.f5378r);
                a(aVar);
                b(a10);
                this.f5376p = new WeakReference<>(aVar);
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "err " + e10);
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002008, "广告展示失败! ErrMsg :" + e10.getMessage(), e10));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.s.a
    public void a(com.aggmoread.sdk.z.d.a.a.c.s.c cVar) {
        this.f5382v = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }

    private void a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, Context context) {
        View view;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "cs enter");
        if (this.f5373m == null) {
            this.f5373m = new FrameLayout(context);
        }
        if (dVar != null && (view = dVar.f5865k) != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "cs 1");
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f5374n = view;
            this.f5373m.addView(view);
        }
        if (this.f5374n == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "cs 2");
            com.aggmoread.sdk.z.d.a.a.d.b.m.d dVar2 = new com.aggmoread.sdk.z.d.a.a.d.b.m.d(context);
            this.f5374n = dVar2;
            this.f5373m.addView(dVar2);
        }
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "rs enter");
        ViewGroup viewGroup = this.f5373m;
        a(aVar, (viewGroup == null || !this.f5377q) ? new View[0] : new View[]{viewGroup});
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar, View[] viewArr) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "rs enter");
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "sk  " + this.f5373m + ", h " + this.f5377q);
        com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5842g.f5856b, this.f5375o, com.aggmoread.sdk.z.d.a.a.c.i.SPLASH, aVar, viewArr);
        com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) this.f5375o, true, true);
        com.aggmoread.sdk.z.d.a.a.d.b.l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
        int[] e10 = this.f5842g.e();
        if (e10 != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5842g.f5856b, e10);
        } else {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMSTAG", "save null");
        }
        byte[] b10 = this.f5842g.f5872r.b();
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "rs edata = " + b10);
        if (b10 != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5842g.f5856b, b10);
        }
        com.aggmoread.sdk.z.d.a.a.d.b.l.a(this.f5375o, this.f5843h);
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5372w, "rs exist");
    }
}
