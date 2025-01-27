package com.martian.mibook.lib.account.response;

import com.martian.rpauth.response.MartianRPAccount;

/* loaded from: classes3.dex */
public class UserDetail {
    public MartianRPAccount account;
    public MiTaskAccount taskAccount;
    public MiUser userInfo;

    public MartianRPAccount getAccount() {
        return this.account;
    }

    public MiTaskAccount getTaskAccount() {
        return this.taskAccount;
    }

    public MiUser getUserInfo() {
        return this.userInfo;
    }

    public void setAccount(MartianRPAccount martianRPAccount) {
        this.account = martianRPAccount;
    }

    public void setTaskAccount(MiTaskAccount miTaskAccount) {
        this.taskAccount = miTaskAccount;
    }

    public void setUserInfo(MiUser miUser) {
        this.userInfo = miUser;
    }
}
