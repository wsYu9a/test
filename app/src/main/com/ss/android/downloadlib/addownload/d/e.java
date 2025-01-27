package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.n;

/* loaded from: classes4.dex */
public class e implements g {
    @Override // com.ss.android.downloadlib.addownload.d.g
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        if (bVar == null) {
            return false;
        }
        return n.a(bVar, !TextUtils.isEmpty(bVar.af()) ? com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true) : com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a()), i10, hVar, true, cVar);
    }
}
