package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.ad.model.t;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.a;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.e0;
import com.vivo.mobilead.util.g0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.t0;
import com.vivo.mobilead.util.w0;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class h extends com.vivo.mobilead.unified.splash.a {
    private HashMap<Integer, t> E;
    private com.vivo.mobilead.unified.base.a F;
    private SparseArray<g> G;
    private g H;
    private a.c I;

    public h(Activity activity, AdParams adParams, UnifiedVivoSplashAdListener unifiedVivoSplashAdListener) {
        super(activity, adParams);
        this.I = new a();
        this.u = unifiedVivoSplashAdListener;
        this.G = new SparseArray<>();
        HashMap<Integer, t> a2 = g0.a(this.f29662b.getPositionId());
        this.E = a2;
        this.F = new com.vivo.mobilead.unified.base.a(a2, this.f29663c, this.f29662b.getPositionId());
    }

    public void p() {
        g gVar = this.H;
        if (gVar instanceof i) {
            t0.a(this.f29669i.get(c.a.f28912a));
            return;
        }
        if (gVar instanceof f) {
            t0.a(this.f29669i.get(c.a.f28913b));
        } else if (gVar instanceof b) {
            t0.a(this.f29669i.get(c.a.f28914c));
        } else {
            t0.a(this.f29669i.get(c.a.f28915d));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public int i() {
        g gVar = this.H;
        if (gVar == null) {
            return -3;
        }
        return gVar.i();
    }

    @Override // com.vivo.mobilead.unified.a
    public String j() {
        g gVar = this.H;
        return gVar == null ? "" : gVar.j();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, t> hashMap = this.E;
        if (hashMap == null || hashMap.isEmpty()) {
            a(40212, "广告配置未获取，请杀掉进程重新进应用尝试");
            return;
        }
        t tVar = this.E.get(c.a.f28912a);
        if (tVar != null) {
            this.G.put(c.a.f28912a.intValue(), new i(this.y, new AdParams.Builder(tVar.f26931c).setSplashOrientation(this.f29662b.getSplashOrientation()).setFloorPrice(this.f29662b.getFloorPrice()).setWxAppid(this.f29662b.getWxAppId()).build()));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        t tVar2 = this.E.get(c.a.f28913b);
        if (e0.x() && tVar2 != null && this.f29662b.getSplashOrientation() == 1) {
            this.G.put(c.a.f28913b.intValue(), new f(this.y, new AdParams.Builder(tVar2.f26931c).setSplashOrientation(this.f29662b.getSplashOrientation()).setFloorPrice(this.f29662b.getFloorPrice()).build()));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        t tVar3 = this.E.get(c.a.f28914c);
        if (e0.g() && tVar3 != null && this.f29662b.getSplashOrientation() == 1) {
            this.G.put(c.a.f28914c.intValue(), new b(this.y, new AdParams.Builder(tVar3.f26931c).setSplashOrientation(this.f29662b.getSplashOrientation()).setFloorPrice(this.f29662b.getFloorPrice()).build()));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        t tVar4 = this.E.get(c.a.f28915d);
        if (e0.q() && tVar4 != null && this.f29662b.getSplashOrientation() == 1) {
            this.G.put(c.a.f28915d.intValue(), new c(this.y, new AdParams.Builder(tVar4.f26931c).setSplashOrientation(this.f29662b.getSplashOrientation()).setFloorPrice(this.f29662b.getFloorPrice()).build()));
            sb.append(c.a.f28915d);
            sb.append(",");
        }
        int size = this.G.size();
        if (size <= 0) {
            a(40212, "广告配置未获取，请杀掉进程重新进应用尝试");
            return;
        }
        this.F.a(this.I);
        this.F.a(size);
        for (int i2 = 0; i2 < size; i2++) {
            g valueAt = this.G.valueAt(i2);
            if (valueAt != null) {
                valueAt.a(this.F);
                valueAt.b(this.f29663c);
                valueAt.a(this.f29662b.getPositionId());
                valueAt.l();
            }
        }
        a1.a(this.F, g0.a(2).longValue());
        k0.a("3", sb.substring(0, sb.length() - 1), this.f29663c, this.f29662b.getPositionId());
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2) {
        g gVar = this.H;
        if (gVar != null) {
            gVar.b(i2);
        }
    }

    @Override // com.vivo.mobilead.unified.splash.a, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        g gVar = this.H;
        if (gVar != null) {
            gVar.d();
        }
    }

    class a implements a.c {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(int i2, String str) {
            UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = h.this.u;
            if (unifiedVivoSplashAdListener != null) {
                unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(i2, str));
            }
            w0.a((Integer) null, h.this.G);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(Integer num) {
            h hVar = h.this;
            hVar.H = (g) hVar.G.get(num.intValue());
            if (h.this.H != null) {
                h.this.H.c(((com.vivo.mobilead.unified.a) h.this).f29664d);
                h.this.H.a((com.vivo.mobilead.g.b) null);
                h.this.H.a(h.this.u);
                h.this.H.p();
                h.this.p();
            }
            w0.a(num, h.this.G);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(com.vivo.mobilead.model.f fVar) {
            if (!TextUtils.isEmpty(fVar.f29596g)) {
                ((com.vivo.mobilead.unified.a) h.this).f29664d = fVar.f29596g;
            }
            k0.a("3", fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c);
        }
    }

    public void a(int i2, String str) {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(i2, str));
        }
        w0.a((Integer) null, this.G);
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2, int i3) {
        g gVar = this.H;
        if (gVar != null) {
            gVar.b(i2, i3);
        }
    }
}
