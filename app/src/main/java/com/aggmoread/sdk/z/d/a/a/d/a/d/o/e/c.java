package com.aggmoread.sdk.z.d.a.a.d.a.d.o.e;

import android.text.TextUtils;
import com.aggmoread.sdk.z.a.e.a;
import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends k implements com.aggmoread.sdk.z.b.l.a {
    public c(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.b.l.a, com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String str;
        String[] split;
        try {
            com.aggmoread.sdk.z.d.a.a.d.a.d.o.c.a().a(j.f6027q);
            int b10 = this.f5842g.f5871q.b();
            int a10 = this.f5842g.f5871q.a();
            if (b10 <= 0) {
                b10 = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            }
            if (a10 <= 0) {
                a10 = 1920;
            }
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("nv_test_")) {
                c10 = c10.replace("nv_test_", "").trim();
            }
            if (TextUtils.isEmpty(c10) || !c10.contains("#") || (split = c10.split("#")) == null || split.length <= 1) {
                str = null;
            } else {
                c10 = split[0];
                str = split[1];
            }
            new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).b(c10).d(str).c(this.f5843h.f5907c.c(e.c.X)).a(this.f5843h.f5907c.c(e.c.W)).e(this.f5843h.f5907c.c(e.c.f5921b0)).e(b10).c(a10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h)).d().a(this);
            new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.a
    public void onAdLoaded(List<com.aggmoread.sdk.z.b.l.c> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            b(new i(-1000, "广告无填充!"));
            return;
        }
        int i10 = -1;
        for (com.aggmoread.sdk.z.b.l.c cVar : list) {
            if (q() && (cVar instanceof com.aggmoread.sdk.z.a.h.b)) {
                i10 = ((com.aggmoread.sdk.z.a.h.b) cVar).g();
                if (com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h, i10)) {
                }
            }
            arrayList.add(new d(cVar, this.f5842g, this.f5843h, this.f5841f));
        }
        if (q() && arrayList.size() == 0) {
            a(i10, 0);
        } else {
            e(arrayList);
        }
    }
}
