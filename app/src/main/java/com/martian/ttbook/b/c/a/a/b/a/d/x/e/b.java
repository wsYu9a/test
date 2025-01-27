package com.martian.ttbook.b.c.a.a.b.a.d.x.e;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.martian.ttbook.b.c.a.a.b.a.d.i;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends i {

    /* renamed from: g */
    private static String f15447g = "BDHTAG";

    /* renamed from: h */
    public BaiduNativeManager f15448h;

    /* renamed from: j */
    private BaiduNativeManager.ExpressAdListener f15449j;

    class a implements BaiduNativeManager.ExpressAdListener {
        a() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
            com.martian.ttbook.b.c.a.a.e.d.g(b.f15447g, "onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeFail(int i2, String str) {
            com.martian.ttbook.b.c.a.a.e.d.c(b.f15447g, "onAdError %d, %s", Integer.valueOf(i2), str);
            b.this.D(new com.martian.ttbook.b.c.a.a.d.b.i(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeLoad(List<ExpressResponse> list) {
            com.martian.ttbook.b.c.a.a.e.d.g(b.f15447g, "ad loaded");
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (ExpressResponse expressResponse : list) {
                    int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(expressResponse);
                    if (b.this.F() && com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(b.this.f15663d, b2)) {
                        b.this.A(expressResponse, 0);
                    } else {
                        b.this.C(expressResponse, b2);
                        b bVar = b.this;
                        arrayList.add(new c(expressResponse, bVar.f15662c, bVar.f15663d, bVar.f15661b));
                    }
                }
                if (b.this.F() && arrayList.size() == 0) {
                    b.this.D(new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！"));
                    return;
                }
            }
            b.this.f15663d.f15703e = list.size();
            b bVar2 = b.this;
            new k(bVar2.f15662c, bVar2.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
            ((com.martian.ttbook.b.c.a.a.c.l.c) b.this.f15662c.f15673g).onAdLoaded(arrayList);
            ((i) b.this).f15406f = true;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNoAd(int i2, String str) {
            com.martian.ttbook.b.c.a.a.e.d.c(b.f15447g, "onAdError %d, %s", Integer.valueOf(i2), str);
            b.this.D(new com.martian.ttbook.b.c.a.a.d.b.i(i2, str));
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
            com.martian.ttbook.b.c.a.a.e.d.g(b.f15447g, "onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
            com.martian.ttbook.b.c.a.a.e.d.g(b.f15447g, "onVideoDownloadSuccess");
        }
    }

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15449j = new a();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(obj, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(obj, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        n.f(this.f15662c.f15670d, d2);
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.Q, ""));
        this.f15448h = baiduNativeManager;
        baiduNativeManager.setAppSid(d2);
        int i2 = this.f15662c.m;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f15662c.f15670d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        new RequestParameters.Builder().setWidth((int) (displayMetrics.density * 640.0f)).setHeight((int) (displayMetrics.density * 360.0f)).build();
        com.martian.ttbook.b.c.a.a.e.d.g(f15447g, "load ad");
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15448h.loadExpressAd(null, this.f15449j);
    }
}
