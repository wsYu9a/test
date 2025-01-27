package com.martian.libugrowth.adx.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class AdxHttpGetParams extends MTHttpGetParams {
    public AdxHttpGetParams() {
        super(new AdxUrlProvider());
    }
}
