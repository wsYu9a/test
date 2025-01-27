package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class TYBookHttpGetParams extends MTHttpGetParams {
    public TYBookHttpGetParams() {
        super(new TYBookUrlProvider());
    }
}
