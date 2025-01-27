package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class WithdrawCommissionWeixinParams extends TYAuthParams {

    @a
    private Boolean check_phone;

    @a
    private Boolean check_realname;

    @a
    private Integer money;

    @a
    private String realname;

    @a
    private String wx_appid;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "withdraw_commission_weixin";
    }

    public Boolean getCheck_phone() {
        return this.check_phone;
    }

    public Boolean getCheck_realname() {
        return this.check_realname;
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

    public String getWx_appid() {
        return this.wx_appid;
    }

    public void setCheck_phone(Boolean check_phone) {
        this.check_phone = check_phone;
    }

    public void setCheck_realname(Boolean check_realname) {
        this.check_realname = check_realname;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setWx_appid(String wx_appid) {
        this.wx_appid = wx_appid;
    }
}
