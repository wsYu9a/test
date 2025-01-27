package com.martian.ttbook.b.c.a.a.b.a.d.a0.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: f */
    private RewardAd f15273f;

    /* renamed from: g */
    private boolean f15274g;

    /* renamed from: h */
    private AtomicBoolean f15275h;

    /* renamed from: j */
    private Object[] f15276j;
    private RewardAdStatusListener k;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.a0.c.a$a */
    class C0296a extends RewardAdStatusListener {
        C0296a() {
        }

        public void a() {
            d.g("HWRETAG", "onADClose");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
            }
        }

        public void b(int i2) {
            d.g("HWRETAG", "onError " + i2);
            i iVar = new i(-3000, String.valueOf(i2));
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(2).b(iVar).h();
            if (a.this.f15274g || !a.this.f15663d.k()) {
                a.this.f15662c.f15673g.a(iVar);
            }
        }

        public void c() {
            d.g("HWRETAG", "onADExpose");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            a aVar2 = a.this;
            Object obj = aVar2.f15662c.f15668b;
            Object[] objArr = aVar2.f15276j;
            a aVar3 = a.this;
            l.o(obj, objArr, aVar3.f15662c.f15671e, Integer.valueOf(aVar3.f15663d.f()));
            a aVar4 = a.this;
            l.s(aVar4.f15662c.f15668b, aVar4.f15663d.e(), a.this.f15663d.b());
            if (a.this.f15662c.m() != null) {
                com.martian.ttbook.b.c.a.a.d.b.d dVar = a.this.f15662c;
                l.k(dVar.f15668b, dVar.m());
            }
            byte[] h2 = a.this.f15662c.r.h();
            if (h2 != null) {
                l.j(a.this.f15662c.f15668b, h2);
            }
            l.i(a.this.f15276j, true, true);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.o.b) a.this.f15662c.f15673g).onAdExposed();
            }
        }

        public void d(Reward reward) {
            d.g("HWRETAG", "reward onReward map");
            l.q(a.this.f15276j, 1);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
            }
        }
    }

    class b extends RewardAdLoadListener {
        b() {
        }

        public void a(int i2) {
            d.g("HWRETAG", "onError " + i2);
            i iVar = new i(-3000, String.valueOf(i2));
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(2).b(iVar).h();
            if (a.this.f15274g || !a.this.f15663d.k()) {
                a.this.f15662c.f15673g.a(iVar);
            }
        }

        public void b() {
            d.g("HWRETAG", "onADLoad");
            a.this.f15274g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdLoaded(arrayList);
            }
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15274g = false;
        this.f15275h = new AtomicBoolean();
        this.f15276j = com.martian.ttbook.b.c.a.a.b.n();
        this.k = new C0296a();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void C(Activity activity) {
        d.g("HWRETAG", "showInner ac");
        if (this.f15274g && this.f15273f != null && this.f15275h.compareAndSet(false, true)) {
            com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15273f, this.f15664e);
            this.f15273f.show(activity, this.k);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        d.g("HWRETAG", "showInner ");
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            C((Activity) context);
        } else {
            Log.e("mobile_ad", "当前传入Activity为空");
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("HWRETAG", "handle");
        com.martian.ttbook.b.c.a.a.d.b.d dVar = this.f15662c;
        com.martian.ttbook.b.c.a.a.c.q.b bVar = dVar.s;
        n.i(dVar.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        d.g("HWRETAG", "mute = " + (bVar != null ? bVar.k() : true));
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.Q;
        this.f15273f = new RewardAd(context, eVar.d(obj, ""));
        this.f15274g = false;
        if (this.f15662c.p != null) {
            d.g("HWRETAG", "set ssv");
            String g2 = this.f15662c.p.g();
            String a2 = this.f15662c.p.a();
            d.g("HWRETAG", "u = " + g2 + ", cd = " + a2);
            String b2 = com.martian.ttbook.b.c.a.a.e.i.b(a2, this.f15663d.f15701c.l(obj));
            StringBuilder sb = new StringBuilder();
            sb.append(" _extrasInfo = ");
            sb.append(b2);
            d.g("HWRETAG", sb.toString());
            this.f15273f.setRewardVerifyConfig(new RewardVerifyConfig.Builder().setData(b2).setUserId(g2).build());
        }
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15273f.loadAd(new AdParam.Builder().build(), new b());
    }
}
