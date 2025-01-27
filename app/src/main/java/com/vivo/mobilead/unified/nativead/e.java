package com.vivo.mobilead.unified.nativead;

import android.content.Context;
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
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.t0;
import com.vivo.mobilead.util.w0;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class e extends com.vivo.mobilead.unified.nativead.a {
    private com.vivo.mobilead.unified.base.a F;
    private HashMap<Integer, t> G;
    private SparseArray<d> H;
    private d I;
    private a.c J;

    public e(Context context, AdParams adParams, UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener) {
        super(context, adParams, unifiedVivoNativeExpressAdListener);
        this.J = new a();
        this.G = g0.a(adParams.getPositionId());
        this.H = new SparseArray<>();
        this.F = new com.vivo.mobilead.unified.base.a(this.G, this.f29663c, adParams.getPositionId());
    }

    public void o() {
        d dVar = this.I;
        if (dVar instanceof com.vivo.mobilead.unified.b.d) {
            t0.a(this.f29669i.get(c.a.f28912a));
            return;
        }
        if (dVar instanceof com.vivo.mobilead.unified.b.c) {
            t0.a(this.f29669i.get(c.a.f28913b));
        } else if (dVar instanceof com.vivo.mobilead.unified.b.a) {
            t0.a(this.f29669i.get(c.a.f28914c));
        } else if (dVar instanceof com.vivo.mobilead.unified.b.b) {
            t0.a(this.f29669i.get(c.a.f28915d));
        }
    }

    @Override // com.vivo.mobilead.unified.nativead.a, com.vivo.mobilead.unified.a
    public void l() {
        StringBuilder sb = new StringBuilder();
        if (this.G.get(c.a.f28912a) != null) {
            this.H.put(c.a.f28912a.intValue(), new com.vivo.mobilead.unified.b.d(this.f29661a, new AdParams.Builder(this.G.get(c.a.f28912a).f26931c).setVideoPolicy(this.f29662b.getVideoPolicy()).setFloorPrice(this.f29662b.getFloorPrice()).setNativeExpressWidth(this.f29662b.getNativeExpressWidth()).setNativeExpressHegiht(this.f29662b.getNativeExpressHegiht()).setWxAppid(this.f29662b.getWxAppId()).build()));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        if (e0.v() && this.G.get(c.a.f28913b) != null) {
            this.H.put(c.a.f28913b.intValue(), new com.vivo.mobilead.unified.b.c(this.f29661a, new AdParams.Builder(this.G.get(c.a.f28913b).f26931c).setVideoPolicy(this.f29662b.getVideoPolicy()).setNativeExpressWidth(this.f29662b.getNativeExpressWidth()).setNativeExpressHegiht(this.f29662b.getNativeExpressHegiht()).build()));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        if (e0.e() && this.G.get(c.a.f28914c) != null) {
            this.H.put(c.a.f28914c.intValue(), new com.vivo.mobilead.unified.b.a(this.f29661a, new AdParams.Builder(this.G.get(c.a.f28914c).f26931c).setVideoPolicy(this.f29662b.getVideoPolicy()).setNativeExpressWidth(this.f29662b.getNativeExpressWidth()).setNativeExpressHegiht(this.f29662b.getNativeExpressHegiht()).build()));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        if (e0.o() && this.G.get(c.a.f28915d) != null && m.c(this.f29661a) == 1) {
            this.H.put(c.a.f28915d.intValue(), new com.vivo.mobilead.unified.b.b(this.f29661a, new AdParams.Builder(this.G.get(c.a.f28915d).f26931c).setVideoPolicy(this.f29662b.getVideoPolicy()).setNativeExpressWidth(this.f29662b.getNativeExpressWidth()).setNativeExpressHegiht(this.f29662b.getNativeExpressHegiht()).build()));
            sb.append(c.a.f28915d);
            sb.append(",");
        }
        int size = this.H.size();
        if (size <= 0) {
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = this.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdFailed(new VivoAdError(40212, "广告配置未获取，请杀掉进程重新进应用尝试"));
                return;
            }
            return;
        }
        this.F.a(this.J);
        this.F.a(size);
        for (int i2 = 0; i2 < size; i2++) {
            d valueAt = this.H.valueAt(i2);
            if (valueAt != null) {
                valueAt.a(this.f29662b.getPositionId());
                valueAt.b(this.f29663c);
                valueAt.a((com.vivo.mobilead.g.b) this.F);
                valueAt.b();
            }
        }
        a1.a(this.F, g0.a(5).longValue());
        k0.a("4", sb.substring(0, sb.length() - 1), this.f29663c, this.f29662b.getPositionId());
    }

    class a implements a.c {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(int i2, String str) {
            UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener = e.this.t;
            if (unifiedVivoNativeExpressAdListener != null) {
                unifiedVivoNativeExpressAdListener.onAdFailed(new VivoAdError(i2, str));
            }
            w0.b(null, e.this.H);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(Integer num) {
            e eVar = e.this;
            eVar.I = (d) eVar.H.get(num.intValue());
            if (e.this.I != null) {
                e.this.I.c(((com.vivo.mobilead.unified.a) e.this).f29664d);
                e.this.I.a((com.vivo.mobilead.g.b) null);
                e.this.I.a((d) e.this.t);
                e.this.I.c();
                e.this.o();
            }
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(com.vivo.mobilead.model.f fVar) {
            if (!TextUtils.isEmpty(fVar.f29596g)) {
                ((com.vivo.mobilead.unified.a) e.this).f29664d = fVar.f29596g;
            }
            k0.a("4", fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c);
        }
    }
}
