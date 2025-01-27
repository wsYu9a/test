package com.martian.ttbook.b.c.a.a.b.a.d.b0.d;

import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.sdk.client.AdRequest;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends l implements KsLoadManager.NativeAdListener {

    /* renamed from: g */
    private static String f15325g = "KSHTAG";

    public e(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(obj, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(obj, i2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15325g, "onAdError %s,%s", Integer.valueOf(i2), str);
        D(new i(i2, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15325g, "ad loaded");
        boolean i2 = this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (KsNativeAd ksNativeAd : list) {
                if (F() && com.martian.ttbook.b.c.a.a.b.a.d.b0.b.f(this.f15663d, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksNativeAd))) {
                    A(ksNativeAd, 0);
                } else {
                    C(ksNativeAd, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksNativeAd));
                    arrayList.add(i2 ? new a(ksNativeAd, this.f15662c, this.f15663d, this.f15661b) : new d(ksNativeAd, this.f15662c, this.f15663d, this.f15661b));
                }
            }
            if (F() && arrayList.size() == 0) {
                D(new i(30000019, "广告无填充！"));
                return;
            }
        }
        this.f15663d.f15703e = list.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        ((com.martian.ttbook.b.c.a.a.c.l.e) this.f15662c.f15673g).onAdLoaded(arrayList);
        this.f15414f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        if (!n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            D(new i(-1000, "广告加载失败！"));
            return;
        }
        int i2 = this.f15662c.m;
        if (i2 < 1) {
            i2 = 1;
        }
        this.f15661b.put(SplashAd.KEY_BIDFAIL_ECPM, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
        try {
            String l = this.f15663d.f15701c.l(e.c.Q);
            String trim = l.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.martian.ttbook.b.c.a.a.e.d.g(f15325g, "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(parseLong).adNum(i2).build(), this);
            com.martian.ttbook.b.c.a.a.e.d.g(f15325g, "load ad");
            new k(this.f15662c, this.f15663d).a(3).h();
        } catch (Exception unused) {
            D(new i(-1000, "广告ID配置错误，广告加载失败！"));
        }
    }
}
