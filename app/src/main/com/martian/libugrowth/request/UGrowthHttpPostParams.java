package com.martian.libugrowth.request;

import com.martian.libmars.comm.request.MTHttpPostParams;

/* loaded from: classes3.dex */
public abstract class UGrowthHttpPostParams extends MTHttpPostParams {
    public UGrowthHttpPostParams() {
        super(new UGrowthUrlProvider());
    }
}
