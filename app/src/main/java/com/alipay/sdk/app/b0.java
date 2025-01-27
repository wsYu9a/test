package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class b0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ a0 f5305a;

    b0(a0 a0Var) {
        this.f5305a = a0Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        H5PayActivity.this.f5278e = true;
        this.f5305a.f5293a.proceed();
        dialogInterface.dismiss();
    }
}
