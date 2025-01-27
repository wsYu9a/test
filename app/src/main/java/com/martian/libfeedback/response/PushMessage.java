package com.martian.libfeedback.response;

/* loaded from: classes2.dex */
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
        Long l = this.showEnd;
        return Long.valueOf(l == null ? -1L : l.longValue());
    }

    public Long getShowStart() {
        Long l = this.showStart;
        return Long.valueOf(l == null ? -1L : l.longValue());
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public void setDialogImage(String dialogImage) {
        this.dialogImage = dialogImage;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public void setShowEnd(Long showEnd) {
        this.showEnd = showEnd;
    }

    public void setShowStart(Long showStart) {
        this.showStart = showStart;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
