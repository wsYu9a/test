package com.martian.libugrowth.request;

import com.martian.libmars.comm.request.MTRequest;

/* loaded from: classes3.dex */
public abstract class UGrowthRequest extends MTRequest {
    public UGrowthRequest() {
        super(new UGrowthUrlProvider());
    }
}
