package com.martian.rpauth.c;

import com.martian.libcomm.http.requests.b;

/* loaded from: classes.dex */
public abstract class a<Params extends com.martian.libcomm.http.requests.b, Data> extends com.martian.libmars.c.a<Params, Data> {
    public a(Class<Params> paramsClass, Class<Data> dataType) {
        super(paramsClass, new com.martian.libmars.c.b(dataType));
    }

    @Override // b.d.c.c.d
    public void execute() {
        j();
    }
}
