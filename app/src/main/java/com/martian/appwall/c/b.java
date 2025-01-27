package com.martian.appwall.c;

import android.content.Context;
import b.d.c.c.i;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.d.h;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes2.dex */
public abstract class b<Params extends com.martian.libcomm.http.requests.b, Data> extends i<Params, Data> {

    /* renamed from: f */
    protected MartianIUserManager f9676f;

    public b(Class aClass, Class dataType, Context context) {
        super(aClass, dataType, context);
        this.f9676f = MartianIUserManager.b();
    }

    private void o() {
        com.martian.rpauth.b e2;
        MartianIUserManager martianIUserManager = this.f9676f;
        if (martianIUserManager == null || !martianIUserManager.f() || (e2 = this.f9676f.e()) == null) {
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
        o();
        super.j();
    }

    public void n() {
        Params k = k();
        if (k instanceof MTHttpGetParams) {
            MTHttpGetParams mTHttpGetParams = (MTHttpGetParams) k;
            mTHttpGetParams.setOaid(h.F().V());
            mTHttpGetParams.setImei(h.F().z());
        } else if (k instanceof MTHttpPostParams) {
            MTHttpPostParams mTHttpPostParams = (MTHttpPostParams) k;
            mTHttpPostParams.setOaid(h.F().V());
            mTHttpPostParams.setImei(h.F().z());
        }
    }
}
