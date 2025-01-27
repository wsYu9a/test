package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.auth.AuthActivity;

/* loaded from: classes.dex */
final class o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f5368a;

    /* renamed from: b */
    final /* synthetic */ AuthActivity.b f5369b;

    o(AuthActivity.b bVar, SslErrorHandler sslErrorHandler) {
        this.f5369b = bVar;
        this.f5368a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b.a.g.d.b(AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new p(this), "退出", new q(this));
    }
}
