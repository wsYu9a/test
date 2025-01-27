package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.baidu.mobads.sdk.internal.bm;

/* loaded from: classes3.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.vd() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra(bm.f6904i, cVar);
        com.kwad.framework.filedownloader.f.c.xT().sendBroadcast(intent);
    }
}
