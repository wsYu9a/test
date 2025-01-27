package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5332a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.a f5333b;

    w(H5PayActivity.a aVar, JsResult jsResult) {
        this.f5333b = aVar;
        this.f5332a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5332a.cancel();
    }
}
