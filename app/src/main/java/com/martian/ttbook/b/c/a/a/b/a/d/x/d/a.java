package com.martian.ttbook.b.c.a.a.b.a.d.x.d;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.b.a.d.d;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: f */
    private AdView f15441f;

    /* renamed from: g */
    private boolean f15442g;

    /* renamed from: h */
    private AtomicBoolean f15443h;

    /* renamed from: j */
    private WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> f15444j;
    public Object[] k;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.d.a$a */
    class C0323a implements AdViewListener {
        C0323a() {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdClick(JSONObject jSONObject) {
            a.this.O();
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdClose(JSONObject jSONObject) {
            a.this.P();
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdFailed(String str) {
            a.this.D(-3000, str);
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdReady(AdView adView) {
            a.this.R();
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdShow(JSONObject jSONObject) {
            a.this.S();
            a.this.Q();
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdSwitch() {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(a.this.f15662c.f15670d);
            a.this.f15444j = new WeakReference(aVar);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) a.this.f15662c.f15670d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            new ViewGroup.LayoutParams(min, (min * 20) / 3);
            a.this.f15662c.f15676j.removeAllViews();
            a aVar2 = a.this;
            aVar2.I(aVar2.f15662c.f15676j);
            aVar.addView(a.this.f15441f, layoutParams);
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f15442g = false;
        this.f15443h = new AtomicBoolean();
        this.k = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void D(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onAdErrorInner " + str);
        i iVar = new i(i2, str);
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15442g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    public void I(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.d.b.m.a aVar;
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "showInner");
        if (!this.f15443h.compareAndSet(false, true) || (aVar = this.f15444j.get()) == null || viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(aVar);
        }
        viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
    }

    public void O() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onADClickInner");
        l.i(this.k, false, true);
        k kVar = new k(this.f15662c, this.f15663d);
        e eVar = this.f15663d;
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.f15444j;
        boolean g2 = kVar.g(eVar, weakReference == null ? null : weakReference.get(), 0L, this.k);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar2 = this.f15662c.f15673g;
            if (eVar2 instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
                ((com.martian.ttbook.b.c.a.a.c.k.b) eVar2).onAdClicked();
            }
        }
    }

    public void P() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onADCloseInner");
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdDismissed();
        }
    }

    public void Q() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onADExposeInner");
        E(this.f15444j.get(), new View[0]);
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdExposed();
        }
    }

    public void R() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onAdLoaded");
        this.f15442g = true;
        new k(this.f15662c, this.f15663d).a(4).h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdLoaded(arrayList);
        }
    }

    public void S() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "onADShowInner");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.k.b) {
            ((com.martian.ttbook.b.c.a.a.c.k.b) eVar).onAdShow();
        }
    }

    protected void E(View view, View[] viewArr) {
        WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> weakReference = this.f15444j;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "apy");
        l.n(this.f15662c.f15668b, this.k, h.BANNER, view, viewArr, null, null, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.k, true, true);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void a(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTBANTAG", "showInContainer");
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void b() {
        AdView adView = this.f15441f;
        if (adView != null) {
            adView.destroy();
            this.f15441f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.k.a
    public void show() {
        a(this.f15662c.f15676j);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
        if (dVar.f15676j == null) {
            D(-1001, "当前广告源不支持横幅预加载功能");
            return;
        }
        Context context = dVar.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.a(context, eVar.d(obj, ""));
        AdView adView = new AdView(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.Q));
        this.f15441f = adView;
        adView.setAppSid(this.f15663d.f15701c.d(obj, ""));
        this.f15441f.setListener(new C0323a());
        new k(this.f15662c, this.f15663d).a(3).h();
        Context context2 = this.f15662c.f15670d;
        if (context2 instanceof Activity) {
            ((Activity) context2).getWindow().getDecorView().post(new b());
        }
    }
}
