package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5365a;

    l(AuthActivity authActivity) {
        this.f5365a = authActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5365a.finish();
    }
}
