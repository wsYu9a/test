package com.martian.appwall.c.d;

import android.app.Activity;
import com.martian.appwall.request.auth.MartianAppwallAuthParams;
import com.martian.libsupport.k;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class c<Params extends MartianAppwallAuthParams, Data> extends com.martian.appwall.c.b<Params, Data> {

    /* renamed from: g */
    public static final int f9681g = 205;

    public c(Class aClass, Class dataType, Activity activity) {
        super(aClass, dataType, activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean p() {
        if (((MartianAppwallAuthParams) k()).getUid() != null && !k.p(((MartianAppwallAuthParams) k()).getToken())) {
            return true;
        }
        MartianIUserManager martianIUserManager = this.f9676f;
        return martianIUserManager != null && martianIUserManager.f();
    }

    @Override // com.martian.appwall.c.b, b.d.c.c.d
    public void j() {
        if (p()) {
            super.j();
        } else {
            q(new b.d.c.b.c(205, "Local uid or token info is null."), true);
        }
    }

    @Override // b.d.c.c.b
    public void onResultError(b.d.c.b.c errorResult) {
        if (errorResult.c() == 205) {
            q(errorResult, false);
        }
    }

    protected void q(b.d.c.b.c result, boolean forceShowLogin) {
        MartianIUserManager martianIUserManager = this.f9676f;
        if (martianIUserManager != null) {
            martianIUserManager.i();
        }
    }
}
