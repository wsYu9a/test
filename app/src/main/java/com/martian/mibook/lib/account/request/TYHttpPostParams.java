package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpPostParams;

/* loaded from: classes.dex */
public abstract class TYHttpPostParams extends MTHttpPostParams {
    public TYHttpPostParams() {
        super(new TYUrlProvider());
    }
}
