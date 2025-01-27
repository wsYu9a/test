package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f5338a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.a f5339b;

    z(H5PayActivity.a aVar, JsPromptResult jsPromptResult) {
        this.f5339b = aVar;
        this.f5338a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5338a.confirm();
    }
}
