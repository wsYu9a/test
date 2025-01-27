package com.vivo.mobilead.unified.base.view.t;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ad.model.a0;
import com.vivo.mobilead.model.BackUrlInfo;

/* loaded from: classes4.dex */
public class e {
    public static c a(Context context, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3) {
        c cVar = null;
        if (bVar == null) {
            return null;
        }
        int x = bVar.x();
        if (bVar.c() != null && bVar.c().u() == 1) {
            if (x == 44) {
                a0 Q = bVar.Q();
                if (Q == null || TextUtils.isEmpty(Q.g())) {
                    return null;
                }
                cVar = new i(context);
            } else {
                cVar = new b(context);
            }
        }
        if (cVar == null) {
            cVar = x != 44 ? x != 45 ? new i(context) : new h(context) : new d(context);
        }
        cVar.a(bVar, backUrlInfo, str, i2, i3);
        return cVar;
    }
}
