package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class UrlMission {
    private String buttonText;
    private boolean clicked = false;
    private Integer coins;
    private Integer duration;
    private String icon;
    private Integer leftCount;
    private String title;
    private String url;

    public String getButtonText() {
        return this.buttonText;
    }

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getIcon() {
        return this.icon;
    }

    public int getLeftCount() {
        Integer num = this.leftCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isClicked() {
        return this.clicked;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
