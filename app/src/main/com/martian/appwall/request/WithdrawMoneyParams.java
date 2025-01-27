package com.martian.appwall.request;

import v8.a;

/* loaded from: classes3.dex */
public class WithdrawMoneyParams extends MartianApBaseParams {

    @a
    private Boolean night_mode;

    public Boolean getNight_mode() {
        return this.night_mode;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "money_withdraw.html";
    }

    public void setNight_mode(Boolean bool) {
        this.night_mode = bool;
    }
}
