package com.aggmoread.sdk.z.d.a.a.d.a.d.u.j;

import android.app.Activity;
import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.f;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends i implements RewardVideoADListener {

    /* renamed from: r */
    private RewardVideoAD f5739r;

    /* renamed from: s */
    private AtomicBoolean f5740s;

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5740s = new AtomicBoolean();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5739r, i11, i10, str);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5739r, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return b.a().a(this.f5842g);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "handle");
        d dVar = this.f5842g;
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = dVar.f5873s;
        Context context = dVar.f5858d;
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        b.a(context, fVar.a(obj, ""));
        boolean d10 = bVar != null ? bVar.d() : true;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "mute = " + d10);
        b.a().a(this.f5843h, this.f5842g);
        Context applicationContext = this.f5842g.f5858d.getApplicationContext();
        String a10 = this.f5843h.f5907c.a(obj, "");
        f fVar2 = this.f5843h.f5907c;
        Object obj2 = e.c.T;
        this.f5739r = (RewardVideoAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(applicationContext, a10, fVar2.a(obj2, ""), d.e.REWARD, this.f5845j, this, Boolean.valueOf(!d10));
        this.f5365p = false;
        if (this.f5842g.f5870p != null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "set ssv");
            String e10 = this.f5842g.f5870p.e();
            String a11 = this.f5842g.f5870p.a();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "u = " + e10 + ", cd = " + a11);
            String a12 = m.a(a11, this.f5843h.f5907c.c(obj2));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" _extrasInfo = ");
            sb2.append(a12);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", sb2.toString());
            this.f5739r.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(e10).setCustomData(a12).build());
        }
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5739r.loadAD();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADClick");
        q();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADClose");
        r();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADExpose");
        s();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADLoad");
        if (o()) {
            int a10 = b.a(this.f5739r);
            if (b.a(this.f5843h, a10)) {
                a(a10, 0);
                return;
            }
            b(a10);
        }
        b.a(this.f5841f, this.f5739r, this.f5843h);
        d(1);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADShow");
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar = this.f5842g;
        l.a(dVar.f5856b, this.f5364o, dVar.f5859e, Integer.valueOf(this.f5843h.f()));
        l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
        if (this.f5842g.e() != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.d dVar2 = this.f5842g;
            l.a(dVar2.f5856b, dVar2.e());
        }
        byte[] b10 = this.f5842g.f5872r.b();
        if (b10 != null) {
            l.a(this.f5842g.f5856b, b10);
        }
        l.a((Object) this.f5364o, true, true);
        l.a(this.f5364o, this.f5843h);
        t();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onError " + adError.getErrorCode() + ", " + adError.getErrorMsg());
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "reward onReward map");
        l.a(this.f5364o, 1);
        if (map != null) {
            this.f5363n.putAll(map);
        }
        b(this.f5363n);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onVideoCached");
        u();
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onVideoComplete");
        l.a(this.f5364o, 2);
        a((Map<String, Object>) null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void v() {
        RewardVideoAD rewardVideoAD;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "showInner ");
        if (!this.f5365p || (rewardVideoAD = this.f5739r) == null || rewardVideoAD.hasShown() || !this.f5740s.compareAndSet(false, true)) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5739r, k());
        this.f5739r.showAD();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void b(Activity activity) {
        RewardVideoAD rewardVideoAD;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "showInner ac");
        if (!this.f5365p || (rewardVideoAD = this.f5739r) == null || rewardVideoAD.hasShown() || !this.f5740s.compareAndSet(false, true)) {
            return;
        }
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5739r, k());
        this.f5739r.showAD(activity);
    }
}
