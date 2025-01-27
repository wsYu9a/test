package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class TYActivity {
    private Long activityId;
    private String activityUrl;
    private String bubbleImage;
    private String buttonText;
    private String deeplink;
    private String desc;
    private String dialogImage;
    private Long endTime;
    private Boolean fullscreen;
    private String icon;
    private Integer marginx;
    private Integer missionType;
    private String posterImage;
    private Integer runtimes;
    private String shareImageUrl;
    private String shareUrl;
    private Boolean shareable;
    private Boolean showOnStart;
    private Long startTime;
    private Boolean started;
    private String title;
    private int type;

    public TYActivity() {
        Boolean bool = Boolean.FALSE;
        this.started = bool;
        this.shareable = bool;
        this.showOnStart = bool;
        this.fullscreen = bool;
    }

    public long getActivityId() {
        Long l10 = this.activityId;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String getBubbleImage() {
        return this.bubbleImage;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDialogImage() {
        return this.dialogImage;
    }

    public long getEndTime() {
        Long l10 = this.endTime;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public Boolean getFullscreen() {
        Boolean bool = this.fullscreen;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String getIcon() {
        return this.icon;
    }

    public Integer getMarginx() {
        return this.marginx;
    }

    public Integer getMissionType() {
        return this.missionType;
    }

    public String getPosterImage() {
        return this.posterImage;
    }

    public Integer getRuntimes() {
        Integer num = this.runtimes;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public boolean getShareable() {
        Boolean bool = this.shareable;
        return bool != null && bool.booleanValue();
    }

    public boolean getShowOnStart() {
        Boolean bool = this.showOnStart;
        return bool != null && bool.booleanValue();
    }

    public long getStartTime() {
        Long l10 = this.startTime;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public boolean getStarted() {
        return this.started.booleanValue();
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isInterAdActivity() {
        return this.type == 1000;
    }

    public void setActivityId(Long l10) {
        this.activityId = l10;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setBubbleImage(String str) {
        this.bubbleImage = str;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDialogImage(String str) {
        this.dialogImage = str;
    }

    public void setEndTime(Long l10) {
        this.endTime = l10;
    }

    public void setFullscreen(Boolean bool) {
        this.fullscreen = bool;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setMarginx(int i10) {
        this.marginx = Integer.valueOf(i10);
    }

    public void setMissionType(Integer num) {
        this.missionType = num;
    }

    public void setPosterImage(String str) {
        this.posterImage = str;
    }

    public void setRuntimes(Integer num) {
        this.runtimes = num;
    }

    public void setShareImageUrl(String str) {
        this.shareImageUrl = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setShareable(Boolean bool) {
        this.shareable = bool;
    }

    public void setShowOnStart(Boolean bool) {
        this.showOnStart = bool;
    }

    public void setStartTime(Long l10) {
        this.startTime = l10;
    }

    public void setStarted(Boolean bool) {
        this.started = bool;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public MissionItem toMissionItem() {
        MissionItem missionItem = new MissionItem();
        missionItem.setType(getMissionType());
        missionItem.setTitle(getTitle());
        missionItem.setUrl(getActivityUrl());
        missionItem.setJumpUrl(getActivityUrl());
        missionItem.setDeeplink(getDeeplink());
        return missionItem;
    }
}
