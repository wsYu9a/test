package com.martian.ttbook.b.c.a.a.b.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.martian.ttbook.b.c.a.a.b;
import com.martian.ttbook.b.c.a.a.d.b.a;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.m.c;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public abstract class k extends a implements com.martian.ttbook.b.c.a.a.c.p.a {

    /* renamed from: f */
    private static String f15410f = "ADSPTAG";

    /* renamed from: g */
    private ViewGroup f15411g;

    /* renamed from: h */
    private View f15412h;

    /* renamed from: j */
    public Object[] f15413j;
    public WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> k;
    public boolean l;
    protected boolean m;
    protected boolean n;
    private boolean o;
    private AtomicBoolean p;

    public k(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.k = null;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = new AtomicBoolean();
        this.f15413j = b.n();
    }

    private void D(com.martian.ttbook.b.c.a.a.d.b.d dVar, Context context) {
        View view;
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "cs enter");
        if (this.f15411g == null) {
            this.f15411g = new FrameLayout(context);
        }
        if (dVar != null && (view = dVar.k) != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "cs 1");
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            this.f15412h = view;
            this.f15411g.addView(view);
        }
        if (this.f15412h == null) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "cs 2");
            com.martian.ttbook.b.c.a.a.d.b.m.d dVar2 = new com.martian.ttbook.b.c.a.a.d.b.m.d(context);
            this.f15412h = dVar2;
            this.f15411g.addView(dVar2);
        }
    }

    protected ViewGroup A(com.martian.ttbook.b.c.a.a.d.b.m.a aVar, ViewGroup viewGroup, boolean z) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "wac enter ");
        com.martian.ttbook.b.c.a.a.d.b.l.c(aVar, this.f15413j);
        aVar.addOnAttachStateChangeListener(new com.martian.ttbook.b.c.a.a.d.b.m.b());
        aVar.setBackgroundColor(0);
        viewGroup.addView(aVar, -1, -1);
        c cVar = new c(viewGroup.getContext());
        cVar.setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setBackgroundColor(0);
        cVar.addView(frameLayout, -1, -1);
        aVar.addView(cVar, -1, -1);
        if (z) {
            cVar.a(this.f15411g);
            this.l = true;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "wac exist ");
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding floor " + i2);
        a(1, i2, null);
        com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！");
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15663d.k()) {
            return;
        }
        this.f15662c.f15673g.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(long j2) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15410f, "onAdTick %s", Long.valueOf(j2));
        View view = this.f15412h;
        if (view instanceof TextView) {
            ((TextView) view).setText(String.format("跳过 %d", Integer.valueOf((int) (j2 / 1000))));
        }
        ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdTick(j2);
        if (j2 <= 600) {
            this.n = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(com.martian.ttbook.b.c.a.a.d.b.m.a aVar) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "rs enter");
        ViewGroup viewGroup = this.f15411g;
        F(aVar, (viewGroup == null || !this.l) ? new View[0] : new View[]{viewGroup});
    }

    protected void F(com.martian.ttbook.b.c.a.a.d.b.m.a aVar, View[] viewArr) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "rs enter");
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "sk  " + this.f15411g + ", h " + this.l);
        com.martian.ttbook.b.c.a.a.d.b.l.l(this.f15662c.f15668b, this.f15413j, com.martian.ttbook.b.c.a.a.c.h.SPLASH, aVar, viewArr);
        com.martian.ttbook.b.c.a.a.d.b.l.i(this.f15413j, true, true);
        com.martian.ttbook.b.c.a.a.d.b.l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        int[] m = this.f15662c.m();
        if (m != null) {
            com.martian.ttbook.b.c.a.a.d.b.l.k(this.f15662c.f15668b, m);
        } else {
            com.martian.ttbook.b.c.a.a.e.d.g("ADSPTAG", "S P is null");
        }
        byte[] h2 = this.f15662c.r.h();
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "rs edata = " + h2);
        if (h2 != null) {
            com.martian.ttbook.b.c.a.a.d.b.l.j(this.f15662c.f15668b, h2);
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "rs exist");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.a("bidding win " + i2);
        if (!com.martian.ttbook.b.c.a.a.e.i.m(this.f15663d) && i2 > 0) {
            sendWinNotification(i2);
        }
    }

    protected abstract void H(View view);

    protected abstract void I(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(com.martian.ttbook.b.c.a.a.d.b.i iVar) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15410f, "onAdError %s", iVar);
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.o || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(List<com.martian.ttbook.b.c.a.a.c.p.a> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "onAdLoaded");
        this.o = true;
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(4).h();
        ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdLoaded(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "onAdClicked");
        this.n = false;
        com.martian.ttbook.b.c.a.a.d.b.k kVar = new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d);
        com.martian.ttbook.b.c.a.a.d.b.e eVar = this.f15663d;
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.k;
        boolean g2 = kVar.g(eVar, weakReference == null ? null : weakReference.get(), 0L, this.f15413j);
        kVar.h();
        if (g2) {
            ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "onAdClosed");
        if (this.n) {
            O();
        }
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(1).h();
        ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdDismissed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "onAdExposure");
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdExposed();
    }

    protected void O() {
        ((com.martian.ttbook.b.c.a.a.c.p.b) this.f15662c.f15673g).onAdSkip();
    }

    public Map<String, Object> a() {
        return this.f15661b;
    }

    public void a(int i2, int i3, String str) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.p.a
    public void a(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "show");
        try {
            if (this.p.compareAndSet(false, true)) {
                com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(this.f15662c.f15670d);
                ViewGroup A = A(aVar, viewGroup, this.m);
                E(aVar);
                I(A);
                this.k = new WeakReference<>(aVar);
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "err " + e2);
            J(new com.martian.ttbook.b.c.a.a.d.b.i(-1000, "广告展示失败! ErrMsg :" + e2.getMessage(), e2));
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    public void sendWinNotification(int i2) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.p.a
    public final void show() {
        ViewGroup viewGroup = this.f15662c.f15676j;
        if (viewGroup != null) {
            a(viewGroup);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public final void w() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15410f, "handle");
        com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
        D(dVar, dVar.f15670d);
        H(this.f15411g);
    }
}
