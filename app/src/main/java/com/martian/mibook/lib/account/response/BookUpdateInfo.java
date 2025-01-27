package com.martian.mibook.lib.account.response;

import com.martian.libsupport.d;
import java.util.Date;

/* loaded from: classes3.dex */
public class BookUpdateInfo {
    private Integer chapterSize;
    private Integer distType;
    private String latestChapter;
    private Long latestChapterUpdateTime;
    private String sourceId;
    private String sourceName;
    private Integer status;

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public Integer getDistType() {
        Integer num = this.distType;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getLatestChapter() {
        return this.latestChapter;
    }

    public Long getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public String getSourceString() {
        return this.sourceName + "|" + this.sourceId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public boolean hasChapterUpdated(Date chapterUpdateDate) {
        return getLatestChapterUpdateTime() != null && (chapterUpdateDate == null || getLatestChapterUpdateTime().longValue() > d.b(chapterUpdateDate));
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
