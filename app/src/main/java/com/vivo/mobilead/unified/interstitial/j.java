package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.ad.model.t;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.a;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.e0;
import com.vivo.mobilead.util.g0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.t0;
import com.vivo.mobilead.util.w0;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class j extends com.vivo.mobilead.unified.interstitial.a {
    private com.vivo.mobilead.unified.base.a C;
    private HashMap<Integer, t> D;
    private SparseArray<g> E;
    private g F;
    private a.c G;

    public j(Activity activity, AdParams adParams, UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener) {
        super(activity, adParams);
        this.G = new a();
        this.t = unifiedVivoInterstitialAdListener;
        this.D = g0.a(adParams.getPositionId());
        this.E = new SparseArray<>();
        this.C = new com.vivo.mobilead.unified.base.a(this.D, this.f29663c, adParams.getPositionId());
    }

    public void s() {
        g gVar = this.F;
        if (gVar instanceof k) {
            t0.a(this.f29669i.get(c.a.f28912a));
            return;
        }
        if (gVar instanceof f) {
            t0.a(this.f29669i.get(c.a.f28913b));
        } else if (gVar instanceof b) {
            t0.a(this.f29669i.get(c.a.f28914c));
        } else if (gVar instanceof d) {
            t0.a(this.f29669i.get(c.a.f28915d));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public int i() {
        g gVar = this.F;
        if (gVar == null) {
            return -3;
        }
        return gVar.i();
    }

    @Override // com.vivo.mobilead.unified.a
    public String j() {
        g gVar = this.F;
        return gVar == null ? "" : gVar.j();
    }

    @Override // com.vivo.mobilead.unified.interstitial.a, com.vivo.mobilead.unified.a
    public void l() {
        c(1);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void o() {
        c(2);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void q() {
        g gVar = this.F;
        if (gVar != null) {
            gVar.q();
        }
    }

    private void c(int i2) {
        StringBuilder sb = new StringBuilder();
        if (this.D.get(c.a.f28912a) != null) {
            this.E.put(c.a.f28912a.intValue(), new k(this.v, new AdParams.Builder(this.D.get(c.a.f28912a).f26931c).setFloorPrice(this.f29662b.getFloorPrice()).setWxAppid(this.f29662b.getWxAppId()).build()));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        if (e0.t() && this.D.get(c.a.f28913b) != null) {
            this.E.put(c.a.f28913b.intValue(), new f(this.v, new AdParams.Builder(this.D.get(c.a.f28913b).f26931c).build()));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        if (e0.c() && this.D.get(c.a.f28914c) != null) {
            this.E.put(c.a.f28914c.intValue(), new b(this.v, new AdParams.Builder(this.D.get(c.a.f28914c).f26931c).build()));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        if (e0.m() && this.D.get(c.a.f28915d) != null) {
            this.E.put(c.a.f28915d.intValue(), new d(this.v, new AdParams.Builder(this.D.get(c.a.f28915d).f26931c).build()));
            sb.append(c.a.f28915d);
            sb.append(",");
        }
        int size = this.E.size();
        if (size <= 0) {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdFailed(new VivoAdError(40212, "广告配置未获取，请杀掉进程重新进应用尝试"));
                return;
            }
            return;
        }
        this.C.a(this.G);
        this.C.a(size);
        for (int i3 = 0; i3 < size; i3++) {
            g valueAt = this.E.valueAt(i3);
            if (valueAt != null) {
                valueAt.a(this.C);
                valueAt.a(this.f29662b.getPositionId());
                valueAt.b(this.f29663c);
                valueAt.a(i2);
            }
        }
        a1.a(this.C, g0.a(4).longValue());
        k0.a("1", sb.substring(0, sb.length() - 1), this.f29663c, this.f29662b.getPositionId());
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2) {
        g gVar = this.F;
        if (gVar != null) {
            gVar.b(i2);
        }
    }

    class a implements a.c {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(int i2, String str) {
            UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = j.this.t;
            if (unifiedVivoInterstitialAdListener != null) {
                unifiedVivoInterstitialAdListener.onAdFailed(new VivoAdError(i2, str));
            }
            w0.a((Integer) null, j.this.E);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(Integer num) {
            j jVar = j.this;
            jVar.F = (g) jVar.E.get(num.intValue());
            if (j.this.F != null) {
                j.this.F.c(((com.vivo.mobilead.unified.a) j.this).f29664d);
                j.this.F.a((com.vivo.mobilead.g.b) null);
                j.this.F.a(j.this.t);
                j.this.F.a(j.this.u);
                j.this.F.t();
                if (!(j.this.F instanceof k) && !(j.this.F instanceof d)) {
                    j.this.F.u();
                } else {
                    MediaListener mediaListener = j.this.u;
                    if (mediaListener != null) {
                        mediaListener.onVideoCached();
                    }
                }
                j.this.s();
            }
            w0.a(num, j.this.E);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(com.vivo.mobilead.model.f fVar) {
            if (!TextUtils.isEmpty(fVar.f29596g)) {
                ((com.vivo.mobilead.unified.a) j.this).f29664d = fVar.f29596g;
            }
            k0.a("1", fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c);
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    public void a(Activity activity) {
        g gVar = this.F;
        if (gVar != null) {
            gVar.a(activity);
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2, int i3) {
        g gVar = this.F;
        if (gVar != null) {
            gVar.b(i2, i3);
        }
    }
}
