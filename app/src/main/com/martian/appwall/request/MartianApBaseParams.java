package com.martian.appwall.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class MartianApBaseParams extends MTHttpGetParams {
    public MartianApBaseParams() {
        super(new MartianApUrlProvider());
    }
}
