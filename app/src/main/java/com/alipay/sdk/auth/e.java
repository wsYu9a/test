package com.alipay.sdk.auth;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5357a;

    e(AuthActivity authActivity) {
        this.f5357a = authActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5357a.q();
        AuthActivity.j(this.f5357a);
    }
}
