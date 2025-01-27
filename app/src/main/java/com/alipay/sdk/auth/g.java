package com.alipay.sdk.auth;

/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5359a;

    g(AuthActivity authActivity) {
        this.f5359a = authActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthActivity.j(this.f5359a);
    }
}
