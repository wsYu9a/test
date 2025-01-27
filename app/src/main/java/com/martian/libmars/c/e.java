package com.martian.libmars.c;

import android.content.Context;
import b.d.c.c.i;
import com.martian.libcomm.http.requests.b;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.d.h;

/* loaded from: classes2.dex */
public abstract class e<Params extends com.martian.libcomm.http.requests.b, Data> extends i<Params, Data> {
    public e(Class aClass, Class dataType, Context context) {
        super(aClass, dataType, context);
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
