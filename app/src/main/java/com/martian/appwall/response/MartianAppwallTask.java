package com.martian.appwall.response;

import java.util.List;

/* loaded from: classes2.dex */
public class MartianAppwallTask {
    private MartianApp app;
    private String awid;
    private Integer coins;
    private String desc;
    private Integer duration;
    private Long firstSubTaskDeadline;
    private Integer money;
    private Integer stindex;
    private List<MartianSubTask> subtasks;
    private String title;
    private String webpageUrl;
    private String status = "";
    private boolean webpageAds = false;

    public MartianApp getApp() {
        return this.app;
    }

    public String getAwid() {
        return this.awid;
    }

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getDesc() {
        return this.desc;
    }

    public Integer getDuration() {
        Integer num = this.duration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public long getFirstSubTaskDeadline() {
        Long l = this.firstSubTaskDeadline;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public boolean getIsWebPage() {
        return this.webpageAds;
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getStatus() {
        return this.status;
    }

    public int getStindex() {
        Integer num = this.stindex;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public List<MartianSubTask> getSubtasks() {
        return this.subtasks;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWebpageUrl() {
        return this.webpageUrl;
    }

    public void setApp(MartianApp app) {
        this.app = app;
    }

    public void setAwid(String awid) {
        this.awid = awid;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setFirstSubTaskDeadline(Long firstSubTaskDeadline) {
        this.firstSubTaskDeadline = firstSubTaskDeadline;
    }

    public void setIsWebPage(boolean webpageAds) {
        this.webpageAds = webpageAds;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStindex(Integer stindex) {
        this.stindex = stindex;
    }

    public void setSubtasks(List<MartianSubTask> subtasks) {
        this.subtasks = subtasks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }
}
