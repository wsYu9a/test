package com.aggmoread.sdk.z.d.a.a.d.a.d.q.e;

import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.d.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.q.c;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends h {

    /* renamed from: p */
    private static String f5470p = "AMEPTAGBD";

    /* renamed from: n */
    public BaiduNativeManager f5471n;

    /* renamed from: o */
    private BaiduNativeManager.ExpressAdListener f5472o;

    public class a implements c.h {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void a(int i10, String str, ExpressResponse expressResponse) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(b.f5470p, "onAdError %d, %s", Integer.valueOf(i10), str);
            b.this.b(new i(i10, str));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void b(int i10, String str, ExpressResponse expressResponse) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(b.f5470p, "onAdError %d, %s", Integer.valueOf(i10), str);
            b.this.b(new i(i10, str));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void c() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(b.f5470p, "onLpClosed");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void onVideoDownloadFailed() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(b.f5470p, "onVideoDownloadFailed");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void onVideoDownloadSuccess() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(b.f5470p, "onVideoDownloadSuccess");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.h
        public void a(List<ExpressResponse> list) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(b.f5470p, "ad loaded");
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                int i10 = -1;
                for (ExpressResponse expressResponse : list) {
                    int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) expressResponse);
                    if (b.this.q() && com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(b.this.f5843h, a10)) {
                        b.this.a(expressResponse, 0);
                    } else {
                        b.this.b(expressResponse, a10);
                        b bVar = b.this;
                        arrayList.add(new c(expressResponse, bVar.f5842g, bVar.f5843h, bVar.f5841f));
                    }
                    i10 = a10;
                }
                if (b.this.q() && arrayList.size() == 0) {
                    b.this.a(i10, 0);
                    return;
                }
            }
            b.this.e(arrayList);
        }
    }

    public b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5472o = com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.a().a(new a());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(obj, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String a10 = this.f5843h.f5907c.a(e.c.X, "");
        Context a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a11, a10);
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(a11, this.f5843h.f5907c.a(e.c.T, ""));
        this.f5471n = baiduNativeManager;
        baiduNativeManager.setAppSid(a10);
        int i10 = this.f5842g.f5867m;
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5470p, "load ad");
        new k(this.f5842g, this.f5843h).a(0).b();
        RequestParameters.Builder builder = new RequestParameters.Builder();
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
        this.f5471n.loadExpressAd(builder.build(), this.f5472o);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(obj, "203");
    }
}
