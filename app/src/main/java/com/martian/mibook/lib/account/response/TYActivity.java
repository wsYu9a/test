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
        Long l = this.activityId;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
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
        Long l = this.endTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
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
        Long l = this.startTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
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

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    public void setBubbleImage(String bubbleImage) {
        this.bubbleImage = bubbleImage;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDialogImage(String dialogImage) {
        this.dialogImage = dialogImage;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setFullscreen(Boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setMarginx(int marginx) {
        this.marginx = Integer.valueOf(marginx);
    }

    public void setMissionType(Integer missionType) {
        this.missionType = missionType;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public void setRuntimes(Integer runtimes) {
        this.runtimes = runtimes;
    }

    public void setShareImageUrl(String shareImageUrl) {
        this.shareImageUrl = shareImageUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    public void setShowOnStart(Boolean showOnStart) {
        this.showOnStart = showOnStart;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
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
