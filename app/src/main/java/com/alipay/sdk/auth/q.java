package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ o f5371a;

    q(o oVar) {
        this.f5371a = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5371a.f5368a.cancel();
        AuthActivity.this.f5346g = false;
        com.alipay.sdk.app.d.f5308a = com.alipay.sdk.app.d.a();
        AuthActivity.this.finish();
    }
}
