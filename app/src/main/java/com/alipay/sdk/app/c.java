package com.alipay.sdk.app;

import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ H5PayActivity.b f5306a;

    c(H5PayActivity.b bVar) {
        this.f5306a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        H5PayActivity.this.finish();
    }
}
