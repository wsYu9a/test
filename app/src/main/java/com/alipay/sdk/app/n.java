package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ a f5320a;

    n(a aVar) {
        this.f5320a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5320a.finish();
    }
}
