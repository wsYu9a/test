package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class ShowWealthResult {
    private Integer coins;
    private Integer duration;
    private Integer extraCoins;
    private Integer extraDuration;
    private Long extraId;
    private Long uid;

    public Integer getCoins() {
        Integer num = this.coins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getExtraCoins() {
        Integer num = this.extraCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getExtraDuration() {
        Integer num = this.extraDuration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getExtraId() {
        Long l10 = this.extraId;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
    }

    public long getUid() {
        return this.uid.longValue();
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setExtraCoins(Integer num) {
        this.extraCoins = num;
    }

    public void setExtraDuration(Integer num) {
        this.extraDuration = num;
    }

    public void setExtraId(Long l10) {
        this.extraId = l10;
    }

    public void setUid(Long l10) {
        this.uid = l10;
    }
}
