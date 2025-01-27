package com.martian.appwall.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class MartianAppwallHttpGetParams extends MTHttpGetParams {
    public MartianAppwallHttpGetParams() {
        super(new MartianAppwallUrlProvider());
    }
}
