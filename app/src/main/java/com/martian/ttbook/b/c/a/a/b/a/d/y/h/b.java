package com.martian.ttbook.b.c.a.a.b.a.d.y.h;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.martian.ttbook.b.a.q.g;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class b extends k implements com.martian.ttbook.b.c.a.a.b.a.d.y.h.a {
    private TTAdNative q;
    private Object r;
    private com.martian.ttbook.b.c.a.a.b.a.d.y.h.c s;
    private View t;
    private g u;
    private AtomicBoolean v;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.S();
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.y.h.b$b */
    class C0341b implements g.a {
        C0341b() {
        }

        @Override // com.martian.ttbook.b.a.q.g.a
        public void a() {
            b.this.S();
        }

        @Override // com.martian.ttbook.b.a.q.g.a
        public void a(long j2) {
            b.this.C(j2);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.S();
        }
    }

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.v = new AtomicBoolean();
    }

    private void P(ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.b.a.d.y.h.c cVar) {
        cVar.c(viewGroup);
        View view = this.t;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        g gVar = new g(new C0341b(), 5000L, 1000L);
        this.u = gVar;
        gVar.start();
    }

    public void S() {
        T();
        M();
    }

    private void T() {
        g gVar = this.u;
        if (gVar != null) {
            gVar.cancel();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        this.t = view;
        n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.q = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d);
        AdSlot build = new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).build();
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
        this.s = TTAdConstant.getBuildInVersion() >= 4700 ? new d(this) : new com.martian.ttbook.b.c.a.a.b.a.d.y.h.c(this);
        this.s.d(this.q, build, this.f15662c.n);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        if (viewGroup == null || this.s == null || !this.v.compareAndSet(false, true)) {
            return;
        }
        P(viewGroup, this.s);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.a
    public void a(i iVar) {
        J(iVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.a
    public void a(Object obj) {
        if (obj == null) {
            J(new i(10008, "广告无填充"));
            return;
        }
        if (com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, obj)) {
            B(0);
            return;
        }
        this.r = obj;
        com.martian.ttbook.b.c.a.a.b.a.d.y.a.d(this.f15661b, obj, this.f15663d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        K(arrayList);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.a
    public void onAdClicked() {
        T();
        L();
        com.martian.ttbook.b.a.k.n.a().postDelayed(new c(), 1000L);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.a
    public void onAdClosed() {
        S();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.h.a
    public void onAdExposure() {
        N();
    }
}
