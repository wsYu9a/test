package com.martian.mibook.lib.account.response;

import java.util.List;

/* loaded from: classes3.dex */
public class InvitationBonus {
    private String bonusImgUrl;
    private String moneyImgUrl;
    private List<Integer> moneyList;
    private String posterUrl;

    public String getBonusImgUrl() {
        return this.bonusImgUrl;
    }

    public String getMoneyImgUrl() {
        return this.moneyImgUrl;
    }

    public List<Integer> getMoneyList() {
        return this.moneyList;
    }

    public String getPosterUrl() {
        return this.posterUrl;
    }

    public void setBonusImgUrl(String bonusImgUrl) {
        this.bonusImgUrl = bonusImgUrl;
    }

    public void setMoneyImgUrl(String moneyImgUrl) {
        this.moneyImgUrl = moneyImgUrl;
    }

    public void setMoneyList(List<Integer> moneyList) {
        this.moneyList = moneyList;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
