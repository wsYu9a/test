package com.martian.mibook.lib.account.request;

import com.martian.libmars.comm.request.MTHttpGetParams;

/* loaded from: classes3.dex */
public class MissionBonusParams extends MTHttpGetParams {
    public MissionBonusParams() {
        super(new TYUrlProvider());
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "authopt/mission_bonus";
    }
}
