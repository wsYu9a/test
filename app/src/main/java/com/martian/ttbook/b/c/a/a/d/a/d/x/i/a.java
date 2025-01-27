package com.martian.ttbook.b.c.a.a.d.a.d.x.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.SplashAd;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.a.d.x.c;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import com.martian.ttbook.b.c.a.a.e.j;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k implements SplashADListener {
    private String q;
    private SplashAD r;
    private AtomicBoolean s;
    public boolean t;
    private int u;
    private boolean v;
    private long w;

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.i.a$a */
    class RunnableC0355a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f15658a;

        RunnableC0355a(ArrayList arrayList) {
            this.f15658a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.K(this.f15658a);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.q = "GDTSPTAG";
        this.s = new AtomicBoolean();
        this.t = false;
        this.u = -1;
        this.v = false;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.f(context, eVar.d(obj, ""));
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "s = " + view + ",f = " + this.f15662c.n);
        this.f15661b.put(SplashAd.KEY_BIDFAIL_ECPM, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
        boolean z = false;
        this.r = (SplashAD) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(d.e.SPLASH, this.f15662c.f15670d, this.f15663d.f15701c.d(obj, ""), this.f15663d.f15701c.d(e.c.Q, ""), this, view, Integer.valueOf(this.f15662c.n));
        int c2 = this.f15663d.f15702d.c(e.c.u, 0);
        if (c2 > 0) {
            this.v = true;
            if (c2 > 1) {
                l.d(this.f15662c, 9);
            }
            boolean i2 = i.i("4.360");
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "ccd " + i2 + ", " + c2);
            com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
            e eVar2 = this.f15663d;
            if (i2 && c2 > 2) {
                z = true;
            }
            l.f(dVar, eVar2, z);
        }
        this.w = System.currentTimeMillis();
        this.r.fetchAdOnly();
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        i.d(this.r, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.p.a
    public void a(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "showInContainer gdt container " + viewGroup + ",request activity " + this.f15662c.f15670d);
        if (viewGroup != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "container visible = " + viewGroup.getVisibility() + ", context = " + viewGroup.getContext());
        }
        if (this.s.compareAndSet(false, true)) {
            if (l.r(this.f15662c) == 91) {
                u(new com.martian.ttbook.b.c.a.a.d.b.i(30000018, "GDT ad blocked"));
                return;
            }
            com.martian.ttbook.b.c.a.a.d.b.m.a aVar = new com.martian.ttbook.b.c.a.a.d.b.m.a(viewGroup.getContext());
            this.k = new WeakReference<>(aVar);
            ViewGroup A = A(aVar, viewGroup, !i.i("4.370"));
            E(aVar);
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.r, this.f15664e);
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "gdtContainer = " + A + ", visibile = " + A.getVisibility() + ", context = " + A.getContext());
            this.r.showAd(A);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        L();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        M();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        N();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j2) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onADLoaded");
        int b2 = c.b(this.r);
        if (c.e(this.f15663d, b2)) {
            B(0);
            return;
        }
        G(b2);
        this.f15661b.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(this.r));
        v();
        if (this.v) {
            int r = l.r(this.f15662c);
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "bt " + r);
            String d2 = this.f15663d.f15701c.d(e.c.Q, "");
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "lbt");
            int a2 = l.a(d2);
            this.u = a2;
            if (a2 != -1) {
                com.martian.ttbook.b.c.a.a.e.d.g(this.q, "lbt = " + a2);
                r = a2;
            }
            if (r == 9) {
                u(new com.martian.ttbook.b.c.a.a.d.b.i(30000018, "广告素材被屏敝"));
                return;
            }
        }
        c.d(this.f15661b, this.r, this.f15663d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        int c2 = this.f15663d.f15702d.c(e.c.s, 0);
        long currentTimeMillis = 500 - (System.currentTimeMillis() - this.w);
        if (c2 <= 0 || currentTimeMillis <= 0) {
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "run  " + c2);
            K(arrayList);
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "del  " + currentTimeMillis);
        j.b(new RunnableC0355a(arrayList), currentTimeMillis);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j2) {
        if (!this.l && !this.t) {
            l.p(this.f15413j);
            this.t = true;
        }
        C(j2);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        J(new com.martian.ttbook.b.c.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        i.c(this.r, i2);
    }
}
