package com.martian.appwall.c.d;

import b.d.c.b.k;
import com.martian.appwall.request.auth.MartianAppwallAuthParams;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class b<Params extends MartianAppwallAuthParams, Data> extends com.martian.rpauth.c.a<Params, Data> {

    /* renamed from: g */
    public static final int f9678g = 205;

    /* renamed from: h */
    private final j1 f9679h;

    /* renamed from: i */
    private final MartianIUserManager f9680i;

    public b(j1 activity, MartianIUserManager rpUserManager, Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, dataType);
        this.f9679h = activity;
        this.f9680i = rpUserManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean q(MartianIUserManager rpUserManager) {
        if (rpUserManager == null || !rpUserManager.f()) {
            return false;
        }
        com.martian.rpauth.b e2 = rpUserManager.e();
        if (e2 == null) {
            return true;
        }
        ((MartianAppwallAuthParams) k()).setUid(e2.getUid());
        ((MartianAppwallAuthParams) k()).setToken(e2.getToken());
        return true;
    }

    @Override // b.d.c.c.d
    public k i() {
        if (q(this.f9680i)) {
            return super.i();
        }
        b.d.c.b.c cVar = new b.d.c.b.c(205, "Local uid or token info is null.");
        p(cVar);
        return cVar;
    }

    @Override // b.d.c.c.d
    public void j() {
        if (q(this.f9680i)) {
            super.j();
        } else {
            p(new b.d.c.b.c(205, "Local uid or token info is null."));
        }
    }

    protected abstract void o(b.d.c.b.c errorResult);

    @Override // b.d.c.c.b
    public void onResultError(b.d.c.b.c errorResult) {
        if (errorResult.c() == 205) {
            p(errorResult);
        } else {
            o(errorResult);
        }
    }

    protected final void p(b.d.c.b.c result) {
        MartianIUserManager martianIUserManager;
        if (this.f9679h == null || (martianIUserManager = this.f9680i) == null) {
            return;
        }
        martianIUserManager.i();
    }
}
