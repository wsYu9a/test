package com.martian.ttbook.b.c.a.a.b.a.d.c.h;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.o;
import com.martian.ttbook.b.c.a.a.b.a.d.v;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.d;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAd;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k {
    private UnifiedVivoSplashAd q;
    private View r;
    private AtomicBoolean s;
    private v<View> t;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.h.a$a */
    class C0320a implements o {

        /* renamed from: a */
        final /* synthetic */ Activity f15403a;

        C0320a(Activity activity) {
            this.f15403a = activity;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            d.g("VVSPTAG", "init success");
            a.this.V(this.f15403a);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            a.this.J(new i(-1000, "广告加载失败！"));
            d.g("VVSPTAG", "returen #1");
        }
    }

    class b implements v<View> {
        b() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        public void a(i iVar) {
            a.this.J(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        /* renamed from: b */
        public void a(View view) {
            d.g("VVSPTAG", "onADLoaded");
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(a.this.q);
            if (com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(a.this.f15663d, c2)) {
                a.this.B(0);
                return;
            }
            a.this.G(c2);
            a.this.r = view;
            a aVar = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.c.b.k(aVar.f15661b, c2, aVar.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            a.this.K(arrayList);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        public void onAdClicked() {
            d.g("VVSPTAG", IAdInterListener.AdCommandType.AD_CLICK);
            a.this.L();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        public void onAdExposed() {
            d.g("VVSPTAG", "onAdExposed");
            a.this.N();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        public void onAdSkip() {
            d.g("VVSPTAG", "onAdSkip");
            a.this.M();
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.v
        public void onAdTimeOver() {
            d.g("VVSPTAG", "onAdTimeOver");
            a.this.M();
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.s = new AtomicBoolean();
        this.t = new b();
    }

    public void V(Activity activity) {
        AdParams.Builder f2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.f(this.f15663d);
        f2.setFetchTimeout(this.f15662c.n);
        f2.setAppTitle("聚合广告");
        f2.setAppDesc("收益");
        this.q = new UnifiedVivoSplashAd(activity, com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().i(this.t), f2.build());
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
        this.q.loadAd();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        this.m = false;
        Activity d2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.d(this.f15662c.f15670d);
        if (d2 == null) {
            J(new i(-1001, "当前传入Activity为空"));
        } else {
            n.b(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new C0320a(d2));
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        if (viewGroup == null || this.r == null || !this.s.compareAndSet(false, true)) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.r);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(this.q, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(this.q, i2);
    }
}
