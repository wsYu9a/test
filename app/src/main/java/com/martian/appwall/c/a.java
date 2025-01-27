package com.martian.appwall.c;

import b.d.c.b.k;
import com.martian.appwall.request.MartianAppwallAuthoptParams;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class a<Params extends MartianAppwallAuthoptParams, Data> extends com.martian.rpauth.c.a<Params, Data> {

    /* renamed from: g */
    private final MartianIUserManager f9675g;

    public a(MartianIUserManager rpUserManager, Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, dataType);
        this.f9675g = rpUserManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o(MartianIUserManager rpUserManager) {
        if (rpUserManager.f()) {
            com.martian.rpauth.b e2 = rpUserManager.e();
            ((MartianAppwallAuthoptParams) k()).setUid(e2.getUid());
            ((MartianAppwallAuthoptParams) k()).setToken(e2.getToken());
        }
    }

    @Override // b.d.c.c.d
    public k i() {
        o(this.f9675g);
        return super.i();
    }

    @Override // b.d.c.c.d
    public void j() {
        o(this.f9675g);
        super.j();
    }
}
