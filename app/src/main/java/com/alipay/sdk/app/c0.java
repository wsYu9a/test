package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class c0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ a0 f5307a;

    c0(a0 a0Var) {
        this.f5307a = a0Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5307a.f5293a.cancel();
        H5PayActivity.this.f5278e = false;
        d.f5308a = d.a();
        H5PayActivity.this.finish();
    }
}
