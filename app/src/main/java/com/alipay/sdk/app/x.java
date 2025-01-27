package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.webkit.JsResult;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsResult f5334a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.a f5335b;

    x(H5PayActivity.a aVar, JsResult jsResult) {
        this.f5335b = aVar;
        this.f5334a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5334a.confirm();
    }
}
