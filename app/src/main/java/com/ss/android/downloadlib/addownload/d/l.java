package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.n;

/* loaded from: classes4.dex */
public class l implements i {
    @Override // com.ss.android.downloadlib.addownload.d.i
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar) {
        if (bVar == null) {
            return false;
        }
        return n.a(bVar, !TextUtils.isEmpty(bVar.af()) ? com.ss.android.downloadlib.i.a((Context) null).a(bVar.af(), null, true) : com.ss.android.downloadlib.i.a((Context) null).b(bVar.a()), i10, hVar, false, null);
    }
}
