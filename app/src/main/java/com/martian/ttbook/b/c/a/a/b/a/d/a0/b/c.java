package com.martian.ttbook.b.c.a.a.b.a.d.a0.b;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.l.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.sdk.client.AdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends l {

    /* renamed from: g */
    private static String f15266g = "HWHTAG";

    /* renamed from: h */
    private NativeAdLoader f15267h;

    class a extends AdListener {

        /* renamed from: a */
        final /* synthetic */ List f15268a;

        /* renamed from: b */
        final /* synthetic */ List f15269b;

        a(List list, List list2) {
            this.f15268a = list;
            this.f15269b = list2;
        }

        public void a() {
            d.g(c.f15266g, "onAdClicked");
            List list = this.f15269b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ((com.martian.ttbook.b.c.a.a.b.a.d.a0.b.b) this.f15269b.get(0)).r();
        }

        public void b() {
        }

        public void c(int i2) {
            d.c(c.f15266g, "onAdError %s", Integer.valueOf(i2));
            c.this.D(new i(-3000, String.valueOf(i2)));
        }

        public void d() {
            d.g(c.f15266g, IAdInterListener.AdCommandType.AD_IMPRESSION);
            List list = this.f15269b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ((com.martian.ttbook.b.c.a.a.b.a.d.a0.b.b) this.f15269b.get(0)).q();
        }

        public void e() {
            d.g(c.f15266g, "onAdLeave");
        }

        public void f() {
            com.martian.ttbook.b.c.a.a.c.a bVar;
            d.g(c.f15266g, "ad loaded");
            List list = this.f15268a;
            if (list == null || list.size() == 0) {
                c.this.D(new i(-3000, "广告无填充"));
                return;
            }
            boolean i2 = c.this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
            ArrayList arrayList = new ArrayList();
            List list2 = this.f15268a;
            if (list2 != null && list2.size() > 0) {
                for (NativeAd nativeAd : this.f15268a) {
                    List list3 = this.f15269b;
                    if (i2) {
                        c cVar = c.this;
                        bVar = new com.martian.ttbook.b.c.a.a.b.a.d.a0.b.a(nativeAd, cVar.f15662c, cVar.f15663d, cVar.f15661b);
                    } else {
                        c cVar2 = c.this;
                        bVar = new com.martian.ttbook.b.c.a.a.b.a.d.a0.b.b(nativeAd, cVar2.f15662c, cVar2.f15663d, cVar2.f15661b);
                    }
                    list3.add(bVar);
                }
            }
            arrayList.addAll(this.f15269b);
            c.this.f15663d.f15703e = this.f15268a.size();
            c cVar3 = c.this;
            new k(cVar3.f15662c, cVar3.f15663d).a(4).c(k.b.B, Integer.valueOf(this.f15268a.size())).h();
            ((e) c.this.f15662c.f15673g).onAdLoaded(arrayList);
            ((l) c.this).f15414f = true;
        }

        public void g() {
            d.g(c.f15266g, "onAdOpened");
        }
    }

    class b implements NativeAd.NativeAdLoadedListener {

        /* renamed from: a */
        final /* synthetic */ List f15271a;

        b(List list) {
            this.f15271a = list;
        }

        public void a(NativeAd nativeAd) {
            d.g(c.f15266g, "onNativeAdLoaded ,isLoading = " + c.this.f15267h.isLoading());
            if (nativeAd != null) {
                this.f15271a.add(nativeAd);
            }
        }
    }

    public c(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        n.i(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.Q, ""));
        builder.setNativeAdLoadedListener(new b(arrayList)).setAdListener(new a(arrayList, arrayList2)).build();
        d.g(f15266g, "load ad");
        NativeAdConfiguration.Builder choicesPosition = new NativeAdConfiguration.Builder().setChoicesPosition(2);
        if (this.f15662c.s != null) {
            choicesPosition.setVideoConfiguration(new VideoConfiguration.Builder().setStartMuted(this.f15662c.s.k()).build());
        }
        NativeAdLoader build = builder.setNativeAdOptions(choicesPosition.build()).build();
        this.f15267h = build;
        build.loadAds(new AdParam.Builder().build(), 1);
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
