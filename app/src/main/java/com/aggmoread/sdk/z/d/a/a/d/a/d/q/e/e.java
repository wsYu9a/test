package com.aggmoread.sdk.z.d.a.a.d.a.d.q.e;

import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.c.o.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.a.d.q.c;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends k implements c.i {

    /* renamed from: o */
    private static String f5495o = "AMUTAGBD";

    /* renamed from: n */
    public BaiduNativeManager f5496n;

    public e(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void a(int i10, String str, NativeResponse nativeResponse) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5495o, "onAdError %d, %s", Integer.valueOf(i10), str);
        b(new i(i10, str));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void b(int i10, String str, NativeResponse nativeResponse) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5495o, "onNoAd %d, %s", Integer.valueOf(i10), str);
        b(new i(i10, str));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void c() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5495o, "onLpClosed");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String a10 = this.f5843h.f5907c.a(e.c.X, "");
        Context a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a11, a10);
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(a11, this.f5843h.f5907c.a(e.c.T, ""));
        this.f5496n = baiduNativeManager;
        baiduNativeManager.setAppSid(a10);
        int i10 = this.f5842g.f5867m;
        RequestParameters.Builder builder = new RequestParameters.Builder();
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5495o, "load ad");
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
        this.f5496n.loadFeedAd(builder.build(), com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.a().a(this));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void onVideoDownloadFailed() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5495o, "onVideoDownloadFailed");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void onVideoDownloadSuccess() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5495o, "onVideoDownloadSuccess");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(obj, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(obj, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.i
    public void a(List<NativeResponse> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5495o, "ad loaded");
        boolean a10 = this.f5842g.a("com.sdk.key.ESP", 16);
        List<f> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (NativeResponse nativeResponse : list) {
                i10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(nativeResponse);
                if (q() && com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5843h, i10)) {
                    a(nativeResponse, 0);
                } else {
                    b(nativeResponse, i10);
                    arrayList.add(a10 ? new a(nativeResponse, this.f5496n, this.f5842g, this.f5843h, this.f5841f) : new d(nativeResponse, this.f5496n, this.f5842g, this.f5843h, this.f5841f));
                }
            }
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }
}
