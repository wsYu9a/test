package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* loaded from: classes.dex */
final class b implements DownloadListener {

    /* renamed from: a */
    final /* synthetic */ a f5304a;

    b(a aVar) {
        this.f5304a = aVar;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        this.f5304a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
