package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYWithdrawMoneyItem {
    private String desc;
    private Integer money;
    private String promotion;
    private Integer videoCount;
    private Integer videoLeftSeconds;
    private Integer videoWatchCount;
    private Integer withdrawLeftCount;

    public String getDesc() {
        return this.desc;
    }

    public Integer getMoney() {
        return this.money;
    }

    public String getPromotion() {
        return this.promotion;
    }

    public Integer getVideoCount() {
        Integer num = this.videoCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getVideoLeftSeconds() {
        Integer num = this.videoLeftSeconds;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getVideoWatchCount() {
        Integer num = this.videoWatchCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getWithdrawLeftCount() {
        Integer num = this.withdrawLeftCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setPromotion(String str) {
        this.promotion = str;
    }

    public void setVideoCount(Integer num) {
        this.videoCount = num;
    }

    public void setVideoLeftSeconds(Integer num) {
        this.videoLeftSeconds = num;
    }

    public void setVideoWatchCount(Integer num) {
        this.videoWatchCount = num;
    }

    public void setWithdrawLeftCount(Integer num) {
        this.withdrawLeftCount = num;
    }
}
