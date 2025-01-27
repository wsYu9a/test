package com.shu.priory.utils.a.a;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class l extends b {
    public l(Context context) {
        super(context);
    }

    private void f() {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", "com.mdid.msa");
        intent.putExtra("com.bun.msa.param.runinset", true);
        this.f17277a.startService(intent);
    }

    @Override // com.shu.priory.utils.a.a.b
    public String a() {
        return "com.bun.lib.MsaIdInterface";
    }

    @Override // com.shu.priory.utils.a.a.b
    public int b() {
        return 3;
    }

    @Override // com.shu.priory.utils.a.a.b
    public boolean c() {
        if (super.c()) {
            try {
                if (this.f17277a.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
                    return true;
                }
                f();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.shu.priory.utils.a.a.b
    public Intent d() {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", this.f17277a.getPackageName());
        return null;
    }
}
