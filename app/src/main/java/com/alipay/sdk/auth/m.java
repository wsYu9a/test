package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f5366a;

    m(AuthActivity authActivity) {
        this.f5366a = authActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5366a.finish();
    }
}
