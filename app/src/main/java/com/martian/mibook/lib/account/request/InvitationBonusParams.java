package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public class InvitationBonusParams extends MTHttpGetParams {
    public InvitationBonusParams() {
        super(new TYUrlProvider());
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "authopt/invitation_bonus";
    }
}
