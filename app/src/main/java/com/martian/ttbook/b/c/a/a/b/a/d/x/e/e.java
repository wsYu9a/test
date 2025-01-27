package com.martian.ttbook.b.c.a.a.b.a.d.x.e;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.sdk.client.AdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends l implements BaiduNativeManager.FeedAdListener {

    /* renamed from: g */
    private static String f15459g = "BDHTAG";

    /* renamed from: h */
    public BaiduNativeManager f15460h;

    public e(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(obj, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(obj, i2);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onLpClosed() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15459g, "onLpClosed");
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeFail(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15459g, "onAdError %d, %s", Integer.valueOf(i2), str);
        D(new i(i2, str));
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeLoad(List<NativeResponse> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15459g, "ad loaded");
        boolean i2 = this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (NativeResponse nativeResponse : list) {
                int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(nativeResponse);
                if (F() && com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(this.f15663d, b2)) {
                    A(nativeResponse, 0);
                } else {
                    C(nativeResponse, b2);
                    arrayList.add(i2 ? new a(nativeResponse, this.f15460h, this.f15662c, this.f15663d, this.f15661b) : new d(nativeResponse, this.f15460h, this.f15662c, this.f15663d, this.f15661b));
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

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNoAd(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15459g, "onNoAd %d, %s", Integer.valueOf(i2), str);
        D(new i(i2, str));
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadFailed() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15459g, "onVideoDownloadFailed");
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadSuccess() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15459g, "onVideoDownloadSuccess");
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        n.f(this.f15662c.f15670d, d2);
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.Q, ""));
        this.f15460h = baiduNativeManager;
        baiduNativeManager.setAppSid(d2);
        int i2 = this.f15662c.m;
        RequestParameters build = new RequestParameters.Builder().build();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f15662c.f15670d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        new RequestParameters.Builder().setWidth((int) (displayMetrics.density * 640.0f)).setHeight((int) (displayMetrics.density * 360.0f)).build();
        com.martian.ttbook.b.c.a.a.e.d.g(f15459g, "load ad");
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15460h.loadFeedAd(build, this);
    }
}
