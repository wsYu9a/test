package com.shu.priory.utils.a.a;

import android.content.Context;
import android.content.Intent;
import k3.a;

/* loaded from: classes3.dex */
public class e extends b {
    public e(Context context) {
        super(context);
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return a.AbstractBinderC0721a.f27611b;
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 1;
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
