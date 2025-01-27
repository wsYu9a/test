package com.martian.ttbook.b.c.a.a.b.a.d.a.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends j {

    /* renamed from: f */
    private static String f15254f = "QMRETAG";

    /* renamed from: g */
    private IMultiAdObject f15255g;

    /* renamed from: h */
    private AtomicBoolean f15256h;

    /* renamed from: j */
    private Object[] f15257j;
    private boolean k;
    int l;
    private AdRequestParam.ADLoadListener m;
    private AdRequestParam.ADRewardVideoListener n;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.a.f.a$a */
    class RunnableC0294a implements Runnable {
        RunnableC0294a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            Object obj = aVar.f15662c.f15668b;
            Object[] objArr = aVar.f15257j;
            a aVar2 = a.this;
            l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
            a aVar3 = a.this;
            l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
            if (a.this.f15662c.m() != null) {
                d dVar = a.this.f15662c;
                l.k(dVar.f15668b, dVar.m());
            }
            byte[] h2 = a.this.f15662c.r.h();
            if (h2 != null) {
                l.j(a.this.f15662c.f15668b, h2);
            }
            l.i(a.this.f15257j, true, true);
            l.q(a.this.f15257j, 3);
        }
    }

    class b implements AdRequestParam.ADLoadListener {
        b() {
        }

        public void a(IMultiAdObject iMultiAdObject) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15254f, "ad loaded");
            if (iMultiAdObject == null) {
                a.this.K(new i(-3000, "广告数据为空！"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(iMultiAdObject);
            a aVar = a.this;
            aVar.l = c2;
            if (com.martian.ttbook.b.c.a.a.b.a.d.a.b.f(aVar.f15663d, c2)) {
                a.this.A(c2);
                return;
            }
            a.this.f15255g = iMultiAdObject;
            a.this.k = true;
            arrayList.add(a.this);
            a aVar2 = a.this;
            e eVar = aVar2.f15663d;
            eVar.f15703e = 1;
            new k(aVar2.f15662c, eVar).a(4).c(k.b.B, 1).h();
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15254f, "ad ecpm " + c2);
            a aVar3 = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.a.b.g(aVar3.f15661b, c2, aVar3.f15663d);
            ((com.martian.ttbook.b.c.a.a.c.o.b) a.this.f15662c.f15673g).onAdLoaded(arrayList);
            ((com.martian.ttbook.b.c.a.a.c.o.b) a.this.f15662c.f15673g).b();
        }

        public void b(String str) {
            com.martian.ttbook.b.c.a.a.e.d.c(a.f15254f, "onAdError %s", str);
            a.this.K(new i(-3000, str));
        }
    }

    class c implements AdRequestParam.ADRewardVideoListener {
        c() {
        }

        public void a(Bundle bundle) {
            a.this.onAdClicked();
        }

        public void b(Bundle bundle) {
            a.this.M();
        }

        public void c(Bundle bundle) {
            a.this.onAdExposure();
        }

        public void d(Bundle bundle) {
            a.this.N();
        }

        public void e(Bundle bundle) {
            a.this.F(0L);
        }

        public void f(Bundle bundle) {
            a.this.O();
        }

        public void g(Bundle bundle) {
            a.this.P();
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f15256h = new AtomicBoolean();
        this.f15257j = com.martian.ttbook.b.c.a.a.b.n();
        this.k = false;
        this.m = new b();
        this.n = new c();
    }

    public void K(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.k || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void C(Activity activity) {
        if (this.f15255g == null || !this.f15256h.compareAndSet(false, true)) {
            return;
        }
        this.f15255g.showRewardVideo(activity, this.n);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            C((Activity) context);
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "act = null " + this.k);
        if (this.k) {
            K(new i(-1001, "当前传入Activity为空"));
        }
    }

    public void F(long j2) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onVideoSkipToEnd");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    public void M() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onPageDismiss");
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
        }
    }

    public void N() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onRewardVerify");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward();
        }
    }

    public void O() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onVideoPlayEnd");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    public void P() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onVideoPlayError");
        i iVar = new i(-3000, "激励视频播放失败或者未领取奖励退出！");
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15255g == null && this.f15663d.k()) {
            return;
        }
        this.f15662c.f15673g.a(iVar);
    }

    public void onAdClicked() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onAdClicked");
        k kVar = new k(this.f15662c, this.f15663d);
        boolean g2 = kVar.g(this.f15663d, null, 0L, this.f15257j);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
            }
        }
        l.i(this.f15257j, false, true);
    }

    public void onAdExposure() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "onVideoPlayStart");
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        n.c(new RunnableC0294a(), 500L);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
            ((com.martian.ttbook.b.c.a.a.c.o.b) this.f15662c.f15673g).onAdExposed();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        IMultiAdRequest e2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.e(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        String l = this.f15663d.f15701c.l(e.c.Q);
        HashMap hashMap = new HashMap();
        com.martian.ttbook.b.c.a.a.c.o.c cVar = this.f15662c.p;
        if (cVar != null) {
            hashMap.put("thirdUserId", cVar.g());
            String b2 = com.martian.ttbook.b.c.a.a.e.i.b(this.f15662c.p.a(), l);
            com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "_ext " + b2);
            hashMap.put("extraData", b2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("countdown_award_des", "发放奖励");
            jSONObject.put("countdown_success_des", "奖励已发放");
            jSONObject.put("close_dialog_exit_des", "放弃奖励");
            jSONObject.put("close_dialog_continue_btn_des", "继续观看");
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("countdown_style", 2);
        bundle.putInt("showCloseTime", 30);
        bundle.putInt("countdown", 30);
        bundle.putString("descriptions", jSONObject.toString());
        AdRequestParam build = new AdRequestParam.Builder().adslotID(l).adType(4).adLoadListener(this.m).extraBundle(bundle).build();
        if (e2 != null) {
            e2.invokeADV(build);
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15254f, "load ad");
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
