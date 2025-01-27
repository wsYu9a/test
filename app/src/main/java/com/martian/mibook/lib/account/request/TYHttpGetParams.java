package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes.dex */
public abstract class TYHttpGetParams extends MTHttpGetParams {
    public TYHttpGetParams() {
        super(new TYUrlProvider());
    }
}
