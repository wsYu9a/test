package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class WithdrawWeixinParams extends TYAuthParams {

    @a
    private Integer money;

    @a
    private String realname;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "v3/withdraw_weixin.do";
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getRealname() {
        return this.realname;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
