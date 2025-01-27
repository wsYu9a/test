package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ p f5325a;

    r(p pVar) {
        this.f5325a = pVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5325a.f5322a.cancel();
        a.this.f5289d = false;
        d.f5308a = d.a();
        a.this.finish();
    }
}
