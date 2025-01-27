package com.alipay.sdk.auth;

/* loaded from: classes.dex */
final class k extends Thread {

    /* renamed from: a */
    final /* synthetic */ j f5364a;

    k(j jVar) {
        this.f5364a = jVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AuthActivity.b(this.f5364a.f5363a);
    }
}
