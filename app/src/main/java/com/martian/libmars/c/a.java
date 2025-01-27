package com.martian.libmars.c;

import b.d.c.b.k;
import b.d.c.c.f;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.d.h;

/* loaded from: classes.dex */
public abstract class a<Params extends com.martian.libcomm.http.requests.b, Data> extends f<Params, Data, b<Data>> {

    /* renamed from: f */
    public static final int f9867f = 201;

    public a(Class<Params> paramsClass, b<Data> parser) {
        super(paramsClass, h.F(), parser);
    }

    @Override // b.d.c.c.d, b.d.c.c.c
    /* renamed from: h */
    public k doInBackground(com.martian.libcomm.http.requests.b param) {
        k doInBackground = super.doInBackground(param);
        MTHttpGetParams.diffServerTime = doInBackground.a() - System.currentTimeMillis();
        if (!(doInBackground instanceof b.d.c.b.c) || ((b.d.c.b.c) doInBackground).c() != 201 || !(param instanceof MTHttpGetParams)) {
            return doInBackground;
        }
        ((MTHttpGetParams) param).initTime();
        return super.doInBackground(param);
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
