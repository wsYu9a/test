package com.martian.libfeedback.response;

/* loaded from: classes3.dex */
public class PushMessage {
    private String buttonText;
    private String content;
    private Long createdOn;
    private String deeplink;
    private String dialogImage;
    private String extra;
    private String link;
    private Integer nid;
    private Long showEnd;
    private Long showStart;
    private String title;

    public String getButtonText() {
        return this.buttonText;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDialogImage() {
        return this.dialogImage;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getLink() {
        return this.link;
    }

    public Integer getNid() {
        Integer num = this.nid;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Long getShowEnd() {
        Long l10 = this.showEnd;
        return Long.valueOf(l10 == null ? -1L : l10.longValue());
    }

    public Long getShowStart() {
        Long l10 = this.showStart;
        return Long.valueOf(l10 == null ? -1L : l10.longValue());
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDialogImage(String str) {
        this.dialogImage = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setNid(Integer num) {
        this.nid = num;
    }

    public void setShowEnd(Long l10) {
        this.showEnd = l10;
    }

    public void setShowStart(Long l10) {
        this.showStart = l10;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
