package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes4.dex */
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

    public void setCbid(Long cbid) {
        this.cbid = cbid;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    public void setLatestChapterId(Long latestChapterId) {
        this.latestChapterId = latestChapterId;
    }

    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }
}
