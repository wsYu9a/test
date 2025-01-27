package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class CheckAlipayMissionUserParams extends TYAuthParams {

    @a
    private Integer isInstalled;

    @a
    private String phone;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "check_alipay_mission_user.do";
    }

    public int getIsInstalled() {
        Integer num = this.isInstalled;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getPhone() {
        return this.phone;
    }

    public void setIsInstalled(Integer isInstalled) {
        this.isInstalled = isInstalled;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
