package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.app.a;

/* loaded from: classes.dex */
final class p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f5322a;

    /* renamed from: b */
    final /* synthetic */ a.b f5323b;

    p(a.b bVar, SslErrorHandler sslErrorHandler) {
        this.f5323b = bVar;
        this.f5322a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b.a.g.d.b(a.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new q(this), "退出", new r(this));
    }
}
