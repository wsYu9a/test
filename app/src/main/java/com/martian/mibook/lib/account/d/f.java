package com.martian.mibook.lib.account.d;

import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.mibook.lib.account.MiUserManager;

/* loaded from: classes.dex */
public abstract class f<Params extends com.martian.libcomm.http.requests.b, Data> extends com.martian.rpauth.c.a<Params, Data> {

    /* renamed from: g */
    protected MiUserManager f13904g;

    public f(Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, dataType);
        this.f13904g = MiUserManager.s();
    }

    private void o() {
        com.martian.rpauth.b e2;
        MiUserManager miUserManager = this.f13904g;
        if (miUserManager == null || !miUserManager.f() || (e2 = this.f13904g.e()) == null) {
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
    public b.d.c.b.k i() {
        o();
        return super.i();
    }

    @Override // b.d.c.c.d
    public void j() {
        o();
        super.j();
    }
}
