package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5363a;

    j(AuthActivity authActivity) {
        this.f5363a = authActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        new k(this).start();
    }
}
