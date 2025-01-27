package com.vivo.mobilead.unified.banner;

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
public class g extends b {
    private com.vivo.mobilead.unified.base.a N;
    private HashMap<Integer, t> O;
    private SparseArray<f> P;
    private f Q;
    private volatile boolean R;
    private a.c S;

    public g(Activity activity, AdParams adParams, UnifiedVivoBannerAdListener unifiedVivoBannerAdListener) {
        super(activity, adParams);
        this.R = false;
        this.S = new a();
        this.t = unifiedVivoBannerAdListener;
        this.O = g0.a(adParams.getPositionId());
        this.P = new SparseArray<>();
        this.N = new com.vivo.mobilead.unified.base.a(this.O, this.f29663c, adParams.getPositionId());
    }

    public void p() {
        f fVar = this.Q;
        if (fVar instanceof h) {
            t0.a(this.f29669i.get(c.a.f28912a));
        } else if (fVar instanceof e) {
            t0.a(this.f29669i.get(c.a.f28913b));
        } else if (fVar instanceof c) {
            t0.a(this.f29669i.get(c.a.f28914c));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        StringBuilder sb = new StringBuilder();
        if (this.O.get(c.a.f28912a) != null) {
            this.P.put(c.a.f28912a.intValue(), new h(this.u, new AdParams.Builder(this.O.get(c.a.f28912a).f26931c).setRefreshIntervalSeconds(this.f29662b.getRefreshIntervalSeconds()).setWxAppid(this.f29662b.getWxAppId()).build()));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        if (e0.r() && this.O.get(c.a.f28913b) != null) {
            this.P.put(c.a.f28913b.intValue(), new e(this.u, new AdParams.Builder(this.O.get(c.a.f28913b).f26931c).setRefreshIntervalSeconds(this.f29662b.getRefreshIntervalSeconds()).build()));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        if (e0.a() && this.O.get(c.a.f28914c) != null) {
            this.P.put(c.a.f28914c.intValue(), new c(this.u, new AdParams.Builder(this.O.get(c.a.f28914c).f26931c).setRefreshIntervalSeconds(this.f29662b.getRefreshIntervalSeconds()).build()));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        int size = this.P.size();
        if (size <= 0) {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdFailed(new VivoAdError(40212, "广告配置未获取，请杀掉进程重新进应用尝试"));
                return;
            }
            return;
        }
        this.N.a(this.S);
        this.N.a(size);
        for (int i2 = 0; i2 < size; i2++) {
            f valueAt = this.P.valueAt(i2);
            if (valueAt != null) {
                valueAt.a(this.N);
                valueAt.a(this.f29662b.getPositionId());
                valueAt.b(this.f29663c);
                valueAt.l();
            }
        }
        a1.a(this.N, g0.a(3).longValue());
        k0.a("2", sb.substring(0, sb.length() - 1), this.f29663c, this.f29662b.getPositionId());
    }

    @Override // com.vivo.mobilead.unified.banner.b, com.vivo.mobilead.unified.a
    public void d() {
        this.R = true;
        f fVar = this.Q;
        if (fVar != null) {
            fVar.a((UnifiedVivoBannerAdListener) null);
            this.Q.d();
        }
    }

    class a implements a.c {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(int i2, String str) {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = g.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdFailed(new VivoAdError(i2, str));
            }
            w0.a((Integer) null, g.this.P);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(Integer num) {
            g gVar = g.this;
            gVar.Q = (f) gVar.P.get(num.intValue());
            if (g.this.Q != null) {
                if (g.this.R) {
                    g.this.Q.d();
                } else {
                    g.this.Q.c(((com.vivo.mobilead.unified.a) g.this).f29664d);
                    g.this.Q.a((com.vivo.mobilead.g.b) null);
                    g.this.Q.a(g.this.t);
                    g.this.Q.p();
                    g.this.p();
                }
            }
            w0.a(num, g.this.P);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(com.vivo.mobilead.model.f fVar) {
            if (!TextUtils.isEmpty(fVar.f29596g)) {
                ((com.vivo.mobilead.unified.a) g.this).f29664d = fVar.f29596g;
            }
            k0.a("2", fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c);
        }
    }
}
