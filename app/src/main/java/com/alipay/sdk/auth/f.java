package com.alipay.sdk.auth;

/* loaded from: classes.dex */
final class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5358a;

    f(AuthActivity authActivity) {
        this.f5358a = authActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthActivity.b(this.f5358a);
    }
}
