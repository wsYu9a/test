package com.aggmoread.sdk.z.d.a.a.d.a.d.o.g;

import android.app.Activity;
import android.text.TextUtils;
import com.aggmoread.sdk.z.a.e.a;
import com.aggmoread.sdk.z.b.s.d;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.o.c;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.q;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends i implements d {

    /* renamed from: r */
    private com.aggmoread.sdk.z.a.e.a f5416r;

    /* renamed from: s */
    private com.aggmoread.sdk.z.b.a f5417s;

    /* renamed from: t */
    private AtomicBoolean f5418t;

    public a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f5418t = new AtomicBoolean();
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void a() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADClose");
        r();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void b(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "showInner ac");
        if (this.f5365p && this.f5417s != null && this.f5418t.compareAndSet(false, true)) {
            this.f5417s.a(activity, null);
        }
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void d() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADExpose");
        s();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        com.aggmoread.sdk.z.b.a aVar = this.f5417s;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String str;
        String[] split;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "handle");
        b bVar = this.f5842g.f5873s;
        c.a().a(this.f5842g.f5858d);
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "mute = " + (bVar != null ? bVar.d() : true));
        this.f5365p = false;
        try {
            int b10 = this.f5842g.f5871q.b();
            int a10 = this.f5842g.f5871q.a();
            if (b10 <= 0) {
                b10 = q.b(this.f5842g.f5858d);
            }
            if (a10 <= 0) {
                b10 = q.a(this.f5842g.f5858d);
            }
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("rw_test_")) {
                c10 = c10.replace("rw_test_", "").trim();
            }
            if (TextUtils.isEmpty(c10) || !c10.contains("#") || (split = c10.split("#")) == null || split.length <= 1) {
                str = null;
            } else {
                c10 = split[0];
                str = split[1];
            }
            this.f5416r = new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(true).d(this.f5842g.f5868n).b(c10).d(str).c(this.f5843h.f5907c.c(e.c.X)).a(this.f5843h.f5907c.c(e.c.W)).e(this.f5843h.f5907c.c(e.c.f5921b0)).e(b10).c(a10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h)).d();
            new k(this.f5842g, this.f5843h).a(0).b();
            this.f5416r.a(this);
        } catch (Exception e10) {
            e10.printStackTrace();
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002008, "广告请求失败!"));
        }
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void onAdClicked() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADClick");
        q();
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void onAdShow() {
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

    @Override // com.aggmoread.sdk.z.b.s.d
    public void onReward(Map<String, Object> map) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "reward onReward map");
        l.a(this.f5364o, 1);
        if (map != null) {
            this.f5363n.putAll(map);
        }
        b(this.f5363n);
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void onVideoCached() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onVideoCached");
        u();
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void onVideoCompleted() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onVideoComplete");
        l.a(this.f5364o, 2);
        a((Map<String, Object>) null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i
    public void v() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "showInner ");
        if (this.f5365p && this.f5417s != null && this.f5418t.compareAndSet(false, true)) {
            this.f5417s.b();
        }
    }

    @Override // com.aggmoread.sdk.z.b.s.d
    public void a(com.aggmoread.sdk.z.b.a aVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onADLoad");
        this.f5417s = aVar;
        int d10 = aVar.d();
        if (com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h, d10)) {
            a(d10, 0);
            return;
        }
        b(d10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.b(this.f5841f, d10, this.f5843h);
        d(1);
    }

    @Override // com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMRTAGGDT", "onError " + eVar.a() + ", " + eVar.b());
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.i, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }
}
