package com.martian.ttbook.b.c.a.a.b.a.d.b.b;

import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.l.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.martian.ttbook.sdk.client.AdRequest;
import com.umeng.union.UMNativeAD;
import com.umeng.union.UMUnionSdk;
import com.umeng.union.api.UMUnionApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends l {

    /* renamed from: g */
    private static String f15285g = "UMHTAG";

    class a implements UMUnionApi.AdLoadListener<UMNativeAD> {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.b.c$a$a */
        class RunnableC0299a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f15287a;

            RunnableC0299a(List list) {
                this.f15287a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((e) c.this.f15662c.f15673g).onAdLoaded(this.f15287a);
                ((l) c.this).f15414f = true;
            }
        }

        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ UMUnionApi.AdType f15289a;

            /* renamed from: b */
            final /* synthetic */ String f15290b;

            b(UMUnionApi.AdType adType, String str) {
                this.f15289a = adType;
                this.f15290b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.D(new i(-3000, "fail type " + this.f15289a.name() + ", msg " + this.f15290b));
            }
        }

        a() {
        }

        /* renamed from: a */
        public void c(UMUnionApi.AdType adType, UMNativeAD uMNativeAD) {
            com.martian.ttbook.b.c.a.a.c.a bVar;
            d.g(c.f15285g, "onSuccess ");
            boolean i2 = c.this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
            ArrayList arrayList = new ArrayList();
            if (uMNativeAD != null) {
                if (i2) {
                    c cVar = c.this;
                    bVar = new com.martian.ttbook.b.c.a.a.b.a.d.b.b.a(uMNativeAD, cVar.f15662c, cVar.f15663d, cVar.f15661b);
                } else {
                    c cVar2 = c.this;
                    bVar = new com.martian.ttbook.b.c.a.a.b.a.d.b.b.b(uMNativeAD, cVar2.f15662c, cVar2.f15663d, cVar2.f15661b);
                }
                arrayList.add(bVar);
            }
            c cVar3 = c.this;
            com.martian.ttbook.b.c.a.a.d.b.e eVar = cVar3.f15663d;
            eVar.f15703e = 1;
            new k(cVar3.f15662c, eVar).a(4).c(k.b.B, 1).h();
            j.c(new RunnableC0299a(arrayList));
        }

        public void b(UMUnionApi.AdType adType, String str) {
            d.c(c.f15285g, "onAdError %s", str);
            j.c(new b(adType, str));
        }
    }

    public c(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        n.g(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), this.f15663d.f15701c.d(e.c.T, "union_sdk"));
        UMUnionSdk.loadFeedAd(new a());
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
