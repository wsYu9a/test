package com.martian.appwall.c;

import com.martian.appwall.request.MartianGetAppwallParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class c extends a<MartianGetAppwallParams, MartianAppwallTask> {
    public c() {
        super(MartianIUserManager.b(), MartianGetAppwallParams.class, MartianAppwallTask.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(MartianAppwallTask martianAppwallTask) {
        if (martianAppwallTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianAppwallTask);
    }
}
