package com.aggmoread.sdk.z.d.a.a.d.a.d.u.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.d.a.a.d.a.d.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends j implements SplashADListener {
    public boolean A;
    private int B;
    private boolean C;
    private long D;

    /* renamed from: x */
    private String f5741x;

    /* renamed from: y */
    private SplashAD f5742y;

    /* renamed from: z */
    private AtomicBoolean f5743z;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.k.a$a */
    public class RunnableC0169a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ ArrayList f5744b;

        public RunnableC0169a(ArrayList arrayList) {
            this.f5744b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e(this.f5744b);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5741x = "AMSTAGGDT";
        this.f5743z = new AtomicBoolean();
        this.A = false;
        this.B = -1;
        this.C = false;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(View view) {
        Context context = this.f5842g.f5858d;
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        b.a(context, fVar.a(obj, ""));
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "s = " + view + ",f = " + this.f5842g.f5868n);
        this.f5841f.put("ecpm", this.f5843h.f5906b.a(e.c.f5928f, "-1"));
        this.f5742y = (SplashAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.a(obj, ""), this.f5843h.f5907c.a(e.c.T, ""), d.e.SPLASH, this.f5845j, this, view, Integer.valueOf(this.f5842g.f5868n));
        int a10 = this.f5843h.f5908d.a(e.c.f5947w, 0);
        if (a10 > 0) {
            this.C = true;
            if (a10 > 1) {
                l.a(this.f5842g, 9);
            }
            boolean a11 = m.a("4.360");
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "ccd " + a11 + ", " + a10);
            l.a(this.f5842g, this.f5843h, a11 && a10 > 2);
        }
        if (m.a("4.470")) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.b(this.f5742y, this.f5842g, this.f5843h);
        }
        this.D = System.currentTimeMillis();
        this.f5742y.fetchAdOnly();
        new k(this.f5842g, this.f5843h).a(0).b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5742y, i11, i10, str);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5742y, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return b.a().a(this.f5842g);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        q();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        r();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        s();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "onADLoaded");
        if (o()) {
            int a10 = b.a(this.f5742y);
            if (b.a(this.f5843h, a10)) {
                a(a10, 0);
                return;
            }
            b(a10);
        }
        i();
        if (this.C) {
            int b10 = l.b(this.f5842g);
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "bt " + b10);
            String a11 = this.f5843h.f5907c.a(e.c.T, "");
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "lbt");
            int a12 = l.a(a11);
            this.B = a12;
            if (a12 != -1) {
                com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "lbt = " + a12);
                b10 = a12;
            }
            if (b10 == 9) {
                b(new i(1001006000, "广告素材被屏敝"));
                return;
            }
        }
        b.a(this.f5841f, this.f5742y, this.f5843h);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        int a13 = this.f5843h.f5908d.a(e.c.f5945u, 0);
        long currentTimeMillis = 500 - (System.currentTimeMillis() - this.D);
        if (a13 <= 0 || currentTimeMillis <= 0) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "run  " + a13);
            e(arrayList);
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "del  " + currentTimeMillis);
        n.a(new RunnableC0169a(arrayList), currentTimeMillis);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j10) {
        if (!this.f5377q && !this.A) {
            l.a(this.f5375o);
            this.A = true;
        }
        a(j10);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        b(new i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.c.s.a
    public void a(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "showInContainer gdt container " + viewGroup + ",request activity " + this.f5842g.f5858d);
        if (viewGroup != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "container visible = " + viewGroup.getVisibility() + ", context = " + viewGroup.getContext());
        }
        if (this.f5743z.compareAndSet(false, true)) {
            if (l.b(this.f5842g) == 91) {
                b(new i(1001006001, "GDT ad blocked"));
                return;
            }
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(viewGroup.getContext());
            this.f5376p = new WeakReference<>(aVar);
            ViewGroup a10 = a(aVar, viewGroup, !m.a("4.370"));
            a(aVar);
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5742y, k());
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5741x, "gdtContainer = " + a10 + ", visibile = " + a10.getVisibility() + ", context = " + a10.getContext());
            this.f5742y.showAd(a10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void b(ViewGroup viewGroup) {
    }
}
