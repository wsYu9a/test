package com.martian.mibook.lib.account.response;

import ba.f;
import java.util.Date;

/* loaded from: classes3.dex */
public class BooksUpdateInfo {
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

    public boolean hasChapterUpdated(Date date) {
        return getLatestChapterUpdateTime() != null && (date == null || getLatestChapterUpdateTime().longValue() > f.b(date));
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    public void setDistType(Integer num) {
        this.distType = num;
    }

    public void setLatestChapter(String str) {
        this.latestChapter = str;
    }

    public void setLatestChapterUpdateTime(Long l10) {
        this.latestChapterUpdateTime = l10;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }
}
