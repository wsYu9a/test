package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class a0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f5293a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.b f5294b;

    a0(H5PayActivity.b bVar, SslErrorHandler sslErrorHandler) {
        this.f5294b = bVar;
        this.f5293a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b.a.g.d.b(H5PayActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new b0(this), "退出", new c0(this));
    }
}
