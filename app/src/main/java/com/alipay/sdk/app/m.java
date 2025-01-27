package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ a f5319a;

    m(a aVar) {
        this.f5319a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5319a.finish();
    }
}
