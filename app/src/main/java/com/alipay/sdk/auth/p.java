package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ o f5370a;

    p(o oVar) {
        this.f5370a = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        AuthActivity.this.f5346g = true;
        this.f5370a.f5368a.proceed();
        dialogInterface.dismiss();
    }
}
