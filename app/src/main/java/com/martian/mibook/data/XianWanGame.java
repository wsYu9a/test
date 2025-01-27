package com.martian.mibook.data;

import com.martian.libsupport.k;

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
        return k.p(this.gameName) ? "闲玩游戏" : this.gameName;
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

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
