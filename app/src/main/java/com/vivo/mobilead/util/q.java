package com.vivo.mobilead.util;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class q {
    public static boolean a(com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.c() == null || bVar.c().s() == 0) {
            return false;
        }
        return a(bVar.y());
    }

    private static boolean a(com.vivo.ad.model.q qVar) {
        return (qVar == null || TextUtils.isEmpty(qVar.d()) || TextUtils.isEmpty(qVar.g()) || TextUtils.isEmpty(qVar.o()) || TextUtils.isEmpty(qVar.s()) || qVar.q() <= 0 || qVar.n() == null || qVar.n().size() <= 0) ? false : true;
    }
}
