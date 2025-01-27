package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
public class YWBookUpdate {
    private Long cbid;
    private String latestChapter;
    private Long latestChapterId;
    private Long latestChapterUpdateTime;

    public Long getCbid() {
        return this.cbid;
    }

    public String getLatestChapter() {
        return this.latestChapter;
    }

    public Long getLatestChapterId() {
        return this.latestChapterId;
    }

    public Long getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public void setCbid(Long l10) {
        this.cbid = l10;
    }

    public void setLatestChapter(String str) {
        this.latestChapter = str;
    }

    public void setLatestChapterId(Long l10) {
        this.latestChapterId = l10;
    }

    public void setLatestChapterUpdateTime(Long l10) {
        this.latestChapterUpdateTime = l10;
    }
}
