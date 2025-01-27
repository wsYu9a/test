package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.g;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f extends k implements g.a {

    /* renamed from: o */
    private static String f5715o = "AMUTAGGDT";

    /* renamed from: n */
    public NativeUnifiedAD f5716n;

    public f(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    private void r() {
        this.f5716n = (NativeUnifiedAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""), this.f5843h.f5907c.a(e.c.T, ""), d.e.UNIFIED, this.f5845j, new g(this).a(), new Object[0]);
        int i10 = this.f5842g.f5867m;
        int i11 = 1;
        if (i10 < 1) {
            i10 = 1;
        }
        int a10 = this.f5843h.f5908d.a(e.c.f5947w, 0);
        if (a10 > 0) {
            if (a10 > 1) {
                l.a(this.f5842g, 9);
            }
            l.a(this.f5842g, this.f5843h);
        } else {
            i11 = i10;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5715o, "load ad");
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        if (bVar != null) {
            if (bVar.c() >= 5 && bVar.c() <= 61) {
                this.f5716n.setMinVideoDuration(bVar.c());
            }
            if (bVar.b() >= 5 && bVar.b() <= 61) {
                this.f5716n.setMaxVideoDuration(bVar.b());
            }
        }
        this.f5716n.loadData(i11);
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i11, i10, null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.g.a
    public void b(List<NativeUnifiedADData> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5715o, "ad loaded");
        int b10 = l.b(this.f5842g);
        i();
        if (b10 == 9) {
            b(new i(1001006000, "GDT ad blocked"));
            return;
        }
        boolean a10 = this.f5842g.a("com.sdk.key.ESP", 16);
        List<com.aggmoread.sdk.z.d.a.a.c.o.f> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            boolean q10 = q();
            boolean o10 = o();
            int i10 = -1;
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                int a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(nativeUnifiedADData);
                if (o10) {
                    if (q10 && com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5843h, nativeUnifiedADData)) {
                        a(nativeUnifiedADData, 0);
                        i10 = a11;
                    } else {
                        b(nativeUnifiedADData, a11);
                    }
                }
                arrayList.add(a10 ? new a(nativeUnifiedADData, this.f5716n, this.f5842g, this.f5843h, this.f5841f, b10) : new e(nativeUnifiedADData, this.f5716n, this.f5842g, this.f5843h, this.f5841f, b10));
                i10 = a11;
            }
            if (q10 && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""));
        r();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.g.a
    public void onNoAD(AdError adError) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5715o, "onAdError %s", adError);
        b(new i(adError.getErrorCode(), adError.getErrorMsg()));
    }
}
