package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYInvitee {
    private Integer coins;
    private Integer coinsToday;
    private Long createdOn;
    private Integer duration;
    private Integer durationToday;
    private String header;
    private String nickname;
    private Long uid;

    public Integer getCoins() {
        Integer num = this.coins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getCoinsToday() {
        Integer num = this.coinsToday;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public long getCreatOn() {
        Long l10 = this.createdOn;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getDurationToday() {
        Integer num = this.durationToday;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getHeader() {
        return this.header;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getUid() {
        Long l10 = this.uid;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCoinsToday(Integer num) {
        this.coinsToday = num;
    }

    public void setCreatOn(Long l10) {
        this.createdOn = l10;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setDurationToday(Integer num) {
        this.durationToday = num;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setUid(Long l10) {
        this.uid = l10;
    }
}
