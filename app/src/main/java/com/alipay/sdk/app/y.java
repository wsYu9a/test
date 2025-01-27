package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import com.alipay.sdk.app.H5PayActivity;

/* loaded from: classes.dex */
final class y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ JsPromptResult f5336a;

    /* renamed from: b */
    final /* synthetic */ H5PayActivity.a f5337b;

    y(H5PayActivity.a aVar, JsPromptResult jsPromptResult) {
        this.f5337b = aVar;
        this.f5336a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f5336a.cancel();
    }
}
