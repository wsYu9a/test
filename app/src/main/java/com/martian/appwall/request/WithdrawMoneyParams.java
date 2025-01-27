package com.martian.appwall.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes2.dex */
public class WithdrawMoneyParams extends MartianApBaseParams {

    @a
    private Boolean night_mode;

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "money_withdraw.html";
    }

    public void setNight_mode(Boolean night_mode) {
        this.night_mode = night_mode;
    }
}
