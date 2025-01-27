package com.martian.libfeedback.b;

import b.d.c.b.k;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class a<Params extends com.martian.libcomm.http.requests.b, Data> extends com.martian.rpauth.c.a<Params, Data> {

    /* renamed from: g */
    protected MartianIUserManager f9732g;

    public a(Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, dataType);
        this.f9732g = MartianIUserManager.b();
    }

    private void o() {
        com.martian.rpauth.b e2;
        MartianIUserManager martianIUserManager = this.f9732g;
        if (martianIUserManager == null || !martianIUserManager.f() || (e2 = this.f9732g.e()) == null) {
            return;
        }
        Params k = k();
        if (k instanceof MTHttpGetParams) {
            MTHttpGetParams mTHttpGetParams = (MTHttpGetParams) k;
            mTHttpGetParams.setUid(e2.getUid());
            mTHttpGetParams.setToken(e2.getToken());
        } else if (k instanceof MTHttpPostParams) {
            MTHttpPostParams mTHttpPostParams = (MTHttpPostParams) k;
            mTHttpPostParams.setUid(e2.getUid());
            mTHttpPostParams.setToken(e2.getToken());
        }
    }

    @Override // b.d.c.c.d
    public k i() {
        o();
        return super.i();
    }

    @Override // b.d.c.c.d
    public void j() {
        o();
        super.j();
    }
}
