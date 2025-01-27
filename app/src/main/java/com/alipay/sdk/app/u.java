package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5328a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.a f5329b;

    u(H5PayActivity.a aVar, JsResult jsResult) {
        this.f5329b = aVar;
        this.f5328a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5328a.cancel();
    }
}
