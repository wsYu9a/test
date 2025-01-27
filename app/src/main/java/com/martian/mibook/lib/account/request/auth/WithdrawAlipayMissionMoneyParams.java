package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class WithdrawAlipayMissionMoneyParams extends TYAuthParams {

    @a
    private String phone;

    @a
    private String realname;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "withdraw_alipay_mission_money.do";
    }

    public String getPhone() {
        return this.phone;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
