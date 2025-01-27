package com.shu.priory.utils.a.a;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class c extends b {
    public c(Context context) {
        super(context);
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return h2.b.f26378a;
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 1;
    }

    @Override // com.shu.priory.utils.a.a.b
    public boolean c() {
        try {
            this.f17277a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
            return !r2.queryIntentServices(r3, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        return intent;
    }
}
