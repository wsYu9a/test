package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ a f5317a;

    k(a aVar) {
        this.f5317a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        new l(this).start();
    }
}
