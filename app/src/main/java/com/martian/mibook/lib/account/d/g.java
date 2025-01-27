package com.martian.mibook.lib.account.d;

import android.content.Context;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.mibook.lib.account.MiUserManager;

/* loaded from: classes.dex */
public abstract class g<Params extends com.martian.libcomm.http.requests.b, Data> extends b.d.c.c.i<Params, Data> {

    /* renamed from: f */
    protected MiUserManager f13905f;

    public g(Class aClass, Class dataType, Context context) {
        super(aClass, dataType, context);
        this.f13905f = MiUserManager.s();
    }

    private void n() {
        com.martian.rpauth.b e2;
        MiUserManager miUserManager = this.f13905f;
        if (miUserManager == null || !miUserManager.f() || (e2 = this.f13905f.e()) == null) {
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
    public void j() {
        n();
        super.j();
    }
}
