package com.martian.appwall.request.auth;

import com.martian.appwall.request.MartianAppwallUrlProvider;
import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public abstract class MartianAppwallHttpPostParams extends MTHttpGetParams {
    public MartianAppwallHttpPostParams() {
        super(new MartianAppwallUrlProvider());
    }
}
