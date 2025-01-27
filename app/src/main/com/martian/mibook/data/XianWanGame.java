package com.martian.mibook.data;

import ba.l;

/* loaded from: classes3.dex */
public class XianWanGame {
    private String gameName;
    private String icon;
    private Integer money;
    private String recommend;
    private String recommendId;
    private String sourceId;
    private String url;

    public String getGameName() {
        return l.q(this.gameName) ? "闲玩游戏" : this.gameName;
    }

    public String getIcon() {
        return this.icon;
    }

    public Integer getMoney() {
        Integer num = this.money;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public void setRecommendId(String str) {
        this.recommendId = str;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
