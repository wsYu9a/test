package com.shu.priory.utils.a.a;

import android.content.Context;
import android.content.Intent;
import y2.a;

/* loaded from: classes3.dex */
public class i extends b {
    public i(Context context) {
        super(context);
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return a.AbstractBinderC0847a.f32952b;
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 1;
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
