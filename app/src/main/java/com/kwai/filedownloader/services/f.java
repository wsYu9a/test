package com.kwai.filedownloader.services;

import android.content.Intent;
import com.baidu.mobads.sdk.internal.bj;

/* loaded from: classes2.dex */
public final class f {
    public static void f(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.Gq() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra(bj.f5604i, cVar);
        com.kwai.filedownloader.e.c.IZ().sendBroadcast(intent);
    }
}
