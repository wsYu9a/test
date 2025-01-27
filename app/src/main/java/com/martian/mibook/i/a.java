package com.martian.mibook.i;

import com.martian.libcomm.utils.GsonUtils;
import com.martian.libcomm.utils.e;
import com.martian.libmars.d.h;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.MiOptions;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.MiOptionsParams;

/* loaded from: classes4.dex */
public class a extends Thread {
    private String c() {
        MiOptionsParams miOptionsParams = new MiOptionsParams();
        com.martian.rpauth.b e2 = MiUserManager.s().e();
        if (e2 != null) {
            miOptionsParams.setUid(e2.getUid());
        }
        miOptionsParams.setDevice_id(h.F().t());
        return miOptionsParams.toHttpUrl("UTF8");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            String b2 = e.b(c(), null);
            MiOptions miOptions = (MiOptions) GsonUtils.b().fromJson(b2, MiOptions.class);
            MiConfigSingleton.V3().e4().l(b2);
            MiConfigSingleton.V3().e4().m(miOptions);
        } catch (Exception unused) {
        }
    }
}
