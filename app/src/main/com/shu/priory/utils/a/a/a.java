package com.shu.priory.utils.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return "com.asus.msa.SupplementaryDID.IDidAidlInterface";
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 3;
    }

    @Override // com.shu.priory.utils.a.a.b
    public boolean c() {
        if (!super.c()) {
            return false;
        }
        try {
            return this.f17277a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
