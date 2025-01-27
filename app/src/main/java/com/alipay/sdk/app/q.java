package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ p f5324a;

    q(p pVar) {
        this.f5324a = pVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        a.this.f5289d = true;
        this.f5324a.f5322a.proceed();
        dialogInterface.dismiss();
    }
}
