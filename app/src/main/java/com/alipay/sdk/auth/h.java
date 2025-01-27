package com.alipay.sdk.auth;

/* loaded from: classes.dex */
final class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5360a;

    h(AuthActivity authActivity) {
        this.f5360a = authActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthActivity.n(this.f5360a);
    }
}
