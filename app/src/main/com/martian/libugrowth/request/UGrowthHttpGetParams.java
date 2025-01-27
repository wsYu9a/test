package com.martian.libugrowth.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class UGrowthHttpGetParams extends MTHttpGetParams {
    public UGrowthHttpGetParams() {
        super(new UGrowthUrlProvider());
    }
}
