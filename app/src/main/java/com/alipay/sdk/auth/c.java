package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* loaded from: classes.dex */
final class c implements DownloadListener {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5354a;

    c(AuthActivity authActivity) {
        this.f5354a = authActivity;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        this.f5354a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
