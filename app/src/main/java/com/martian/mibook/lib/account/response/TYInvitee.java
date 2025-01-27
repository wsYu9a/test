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
        Long l = this.createdOn;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
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
        Long l = this.uid;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCoinsToday(Integer coinsToday) {
        this.coinsToday = coinsToday;
    }

    public void setCreatOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDurationToday(Integer durationToday) {
        this.durationToday = durationToday;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
