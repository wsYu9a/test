package com.martian.appwall.response;

import java.util.List;

/* loaded from: classes3.dex */
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
        Long l10 = this.firstSubTaskDeadline;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
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

    public void setApp(MartianApp martianApp) {
        this.app = martianApp;
    }

    public void setAwid(String str) {
        this.awid = str;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setFirstSubTaskDeadline(Long l10) {
        this.firstSubTaskDeadline = l10;
    }

    public void setIsWebPage(boolean z10) {
        this.webpageAds = z10;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStindex(Integer num) {
        this.stindex = num;
    }

    public void setSubtasks(List<MartianSubTask> list) {
        this.subtasks = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWebpageUrl(String str) {
        this.webpageUrl = str;
    }
}
