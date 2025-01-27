package com.vivo.mobilead.nativead;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.t;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.nativead.NativeAdParams;
import com.vivo.mobilead.util.e0;
import com.vivo.mobilead.util.g0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.t0;
import com.vivo.mobilead.util.v0;
import com.vivo.mobilead.util.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class k extends a implements v0.a {

    /* renamed from: j */
    private String f29655j;
    private HashMap<Integer, t> k;
    private HashMap<Integer, a> l;
    private v0<a> m;
    private int n;
    private int o;
    private boolean p;

    public k(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        super(activity, nativeAdParams, nativeAdListener);
        this.l = new HashMap<>(3);
        this.n = this.f29601i.getAdCount();
        this.o = this.f29601i.getFloorPrice();
        this.f29655j = this.f29601i.getWxAppId();
        this.p = this.f29601i.getmIsUsePrivacyAndPermission();
    }

    @Override // com.vivo.mobilead.nativead.a
    public void a() {
        this.k = g0.a(this.f29601i.getPositionId());
        this.l.clear();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, t> hashMap = this.k;
        if (hashMap == null || hashMap.isEmpty()) {
            a(40212, "广告配置未获取，请杀掉进程重新进应用尝试");
            return;
        }
        if (this.k.get(c.a.f28912a) != null) {
            this.l.put(c.a.f28912a, new b(this.f28640a, new NativeAdParams.Builder(this.k.get(c.a.f28912a).f26931c).setAdCount(this.n).setFloorPrice(this.o).setUsePrivacyAndPermission(this.p).setWxAppId(this.f29655j).build(), this.f29600h));
            sb.append(c.a.f28912a);
            sb.append(",");
        }
        if (e0.u() && this.k.get(c.a.f28913b) != null) {
            this.l.put(c.a.f28913b, new i(this.f28640a, new NativeAdParams.Builder(this.k.get(c.a.f28913b).f26931c).setAdCount(this.n).build(), this.f29600h));
            sb.append(c.a.f28913b);
            sb.append(",");
        }
        if (e0.d() && this.k.get(c.a.f28914c) != null) {
            this.l.put(c.a.f28914c, new c(this.f28640a, new NativeAdParams.Builder(this.k.get(c.a.f28914c).f26931c).setAdCount(this.n).build(), this.f29600h));
            sb.append(c.a.f28914c);
            sb.append(",");
        }
        if (e0.n() && this.k.get(c.a.f28915d) != null) {
            this.l.put(c.a.f28915d, new f(this.f28640a, new NativeAdParams.Builder(this.k.get(c.a.f28915d).f26931c).setAdCount(this.n).build(), this.f29600h));
            sb.append(c.a.f28915d);
            sb.append(",");
        }
        if (this.l.size() <= 0) {
            a(40212, "广告配置未获取，请杀掉进程重新进应用尝试");
            return;
        }
        v0<a> v0Var = new v0<>(this.k, this.l, this.f28644e, this.f29601i.getPositionId());
        this.m = v0Var;
        v0Var.a(this);
        this.m.a(this.l.size());
        z.b().a().postDelayed(this.m, g0.a(5).longValue());
        for (Map.Entry<Integer, a> entry : this.l.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                value.a(this.m);
                value.b(this.f28644e);
                value.a(this.f29601i.getPositionId());
                entry.getValue().a();
            }
        }
        k0.a("4", sb.substring(0, sb.length() - 1), this.f28644e, this.f29601i.getPositionId(), Math.max(1, this.n));
    }

    @Override // com.vivo.mobilead.util.v0.a
    public void a(int i2, String str) {
        a(new AdError(i2, str, null, null));
    }

    @Override // com.vivo.mobilead.util.v0.a
    public void a(Integer num) {
        t0.a(this.f28646g.get(Integer.valueOf(num.intValue())));
        a aVar = this.l.get(Integer.valueOf(num.intValue()));
        if (aVar != null) {
            aVar.c(this.f28643d);
            aVar.a((List<NativeResponse>) null);
        }
        this.l.clear();
    }

    @Override // com.vivo.mobilead.util.v0.a
    public void a(com.vivo.mobilead.model.f fVar) {
        if (!TextUtils.isEmpty(fVar.f29596g)) {
            this.f28643d = fVar.f29596g;
        }
        k0.a("4", fVar.f29591b, String.valueOf(fVar.f29593d), fVar.f29594e, fVar.f29595f, fVar.f29596g, fVar.f29597h, fVar.f29598i, fVar.f29592c, fVar.f29599j, this.n);
    }
}
