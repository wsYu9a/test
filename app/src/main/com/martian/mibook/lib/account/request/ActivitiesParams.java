package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public class ActivitiesParams extends MTHttpGetParams {
    public ActivitiesParams() {
        super(new TYUrlProvider());
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "authopt/activities";
    }
}
