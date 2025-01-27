package com.martian.mibook.lib.account.response;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class WithdrawRank {
    private String header;
    private String nickname;
    private Integer totalMoney;
    private Long uid;
    private Integer validInviteeNum;

    public String getHeader() {
        return this.header;
    }

    public String getNickname() {
        return TextUtils.isEmpty(this.nickname) ? "昵称" : this.nickname;
    }

    public int getTotalMoney() {
        Integer num = this.totalMoney;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Long getUid() {
        return this.uid;
    }

    public int getValidInviteeNum() {
        Integer num = this.validInviteeNum;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setValidInviteeNum(Integer validInviteeNum) {
        this.validInviteeNum = validInviteeNum;
    }
}
