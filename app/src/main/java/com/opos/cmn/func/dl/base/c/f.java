package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.exception.DlException;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class f implements e {

    /* renamed from: a */
    private static final String f17290a = "f";

    /* renamed from: b */
    private String f17291b;

    @Override // com.opos.cmn.func.dl.base.c.e
    public final String a() {
        return this.f17291b;
    }

    @Override // com.opos.cmn.func.dl.base.c.e
    public final void a(Context context, d dVar, String str, b bVar) {
        com.opos.cmn.an.f.a.b(f17290a, "RedirectHandler process ,url=".concat(String.valueOf(str)));
        int d2 = dVar.d();
        d dVar2 = dVar;
        int i2 = 0;
        while (true) {
            if (!(d2 == 301 || d2 == 302 || d2 == 303 || d2 == 300 || d2 == 307 || d2 == 308)) {
                if (TextUtils.isEmpty(this.f17291b) || !com.opos.cmn.func.dl.base.h.a.a(d2)) {
                    return;
                }
                ((a) dVar).f17282b = dVar2;
                return;
            }
            com.opos.cmn.an.f.a.b(f17290a, "Deal redirect !");
            dVar2.c();
            i2++;
            if (i2 > 5) {
                throw new DlException(1002);
            }
            String a2 = dVar2.a(HttpHeaders.LOCATION);
            if (a2 == null) {
                throw new DlException(1002);
            }
            this.f17291b = a2;
            dVar2 = new c();
            dVar2.a(context, this.f17291b, bVar);
            d2 = dVar2.d();
        }
    }
}
