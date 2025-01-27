package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
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
public class i extends com.vivo.mobilead.unified.reward.a {
    private com.vivo.mobilead.unified.base.a v;
    private HashMap<Integer, t> w;
    private SparseArray<h> x;
    private h y;
    private a.c z;

    public i(Context context, AdParams adParams, UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        super(context, adParams);
        this.z = new a();
        this.t = unifiedVivoRewardVideoAdListener;
        this.w = g0.a(adParams.getPositionId());
        this.x = new SparseArray<>();
        this.v = new com.vivo.mobilead.unified.base.a(this.w, this.f29663c, adParams.getPositionId());
    }

    public void p() {
        h hVar = this.y;
        if (hVar instanceof j) {
            t0.a(this.f29669i.get(c.a.f28912a));
        } else if (hVar instanceof g) {
            t0.a(this.f29669i.get(c.a.f28913b));
        } else if (hVar instanceof b) {
            t0.a(this.f29669i.get(c.a.f28914c));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public int i() {
        h hVar = this.y;
        if (hVar == null) {
            return -3;
        }
        return hVar.i();
    }

    @Override // com.vivo.mobilead.unified.a
    public String j() {
        h hVar = this.y;
        return hVar == null ? "" : hVar.j();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        StringBuilder sb = new StringBuilder();
        if (this.w.get(c.a.f28912a) != null) {
            this.x.put(c.a.f28912a.intValue(), new j(this.f29661a, new AdParams.Builder(this.w.get(c.a.f28912a).f26931c).setFloorPrice(this.f29662b.getFloorPrice()).setWxAppid(this.f29662b.getWxAppId()).build()));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        if (e0.w() && this.w.get(c.a.f28913b) != null) {
            this.x.put(c.a.f28913b.intValue(), new g(this.f29661a, new AdParams.Builder(this.w.get(c.a.f28913b).f26931c).build()));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        if (e0.f() && this.w.get(c.a.f28914c) != null) {
            this.x.put(c.a.f28914c.intValue(), new b(this.f29661a, new AdParams.Builder(this.w.get(c.a.f28914c).f26931c).build()));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        if (e0.p() && this.w.get(c.a.f28915d) != null) {
            this.x.put(c.a.f28915d.intValue(), new c(this.f29661a, new AdParams.Builder(this.w.get(c.a.f28915d).f26931c).build()));
            sb.append(c.a.f28915d);
            sb.append(",");
        }
        int size = this.x.size();
        if (size <= 0) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(40212, "广告配置未获取，请杀掉进程重新进应用尝试"));
                return;
            }
            return;
        }
        this.v.a(this.z);
        this.v.a(size);
        for (int i2 = 0; i2 < size; i2++) {
            h valueAt = this.x.valueAt(i2);
            if (valueAt != null) {
                valueAt.a(this.v);
                valueAt.a(this.f29662b.getPositionId());
                valueAt.b(this.f29663c);
                if (valueAt instanceof j) {
                    valueAt.a(2);
                } else {
                    valueAt.l();
                }
            }
        }
        a1.a(this.v, g0.a(9).longValue());
        k0.a(BaseWrapper.ENTER_ID_MESSAGE, sb.substring(0, sb.length() - 1), this.f29663c, this.f29662b.getPositionId());
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2) {
        h hVar = this.y;
        if (hVar != null) {
            hVar.b(i2);
        }
    }

    class a implements a.c {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(int i2, String str) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = i.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(i2, str));
            }
            w0.a((Integer) null, i.this.x);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(Integer num) {
            i iVar = i.this;
            iVar.y = (h) iVar.x.get(num.intValue());
            if (i.this.y != null) {
                i.this.y.c(((com.vivo.mobilead.unified.a) i.this).f29664d);
                i.this.y.a((com.vivo.mobilead.g.b) null);
                i.this.y.a(i.this.t);
                i.this.y.a(i.this.u);
                i.this.y.q();
                if (!(i.this.y instanceof j) && !(i.this.y instanceof c)) {
                    i.this.y.r();
                } else {
                    MediaListener mediaListener = i.this.u;
                    if (mediaListener != null) {
                        mediaListener.onVideoCached();
                    }
                }
                d.c().a(System.currentTimeMillis());
                i.this.p();
            }
            w0.a(num, i.this.x);
        }

        @Override // com.vivo.mobilead.unified.base.a.c
        public void a(com.vivo.mobilead.model.f fVar) {
            if (!TextUtils.isEmpty(fVar.f29596g)) {
                ((com.vivo.mobilead.unified.a) i.this).f29664d = fVar.f29596g;
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c);
        }
    }

    @Override // com.vivo.mobilead.unified.reward.a
    public void a(Activity activity) {
        h hVar = this.y;
        if (hVar != null) {
            try {
                hVar.a(activity);
            } catch (Exception unused) {
                d.c().a(false);
                UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
                if (unifiedVivoRewardVideoAdListener != null) {
                    unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(402128, "视频播放出错，建议重试"));
                }
            }
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void b(int i2, int i3) {
        h hVar = this.y;
        if (hVar != null) {
            hVar.b(i2, i3);
        }
    }
}
