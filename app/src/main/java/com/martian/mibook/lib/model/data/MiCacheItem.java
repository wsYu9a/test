package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.manager.d;

@j.g(name = "micache_records")
/* loaded from: classes3.dex */
public class MiCacheItem {

    @j.b
    private Integer chapterIndex;

    @j.b
    private String chapterLink;

    @j.b
    private Integer chapterSize;

    @j.b
    private String chapterTitle;

    @j.b
    @j.f
    private String sourceStr;

    public MiCacheItem() {
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    public String getChapterLink() {
        return this.chapterLink;
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public String getSourceId() {
        return d.c(this.sourceStr);
    }

    public String getSourceName() {
        return d.d(this.sourceStr);
    }

    public String getSourceStr() {
        return this.sourceStr;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public void setChapterLink(String chapterLink) {
        this.chapterLink = chapterLink;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr;
    }

    public MiCacheItem(String source, String sourceId, Integer chapterIndex, Integer chapterSize, String chapterTitle, String chapterLink) {
        this.sourceStr = d.j(source, sourceId);
        this.chapterIndex = chapterIndex;
        this.chapterSize = chapterSize;
        this.chapterTitle = chapterTitle;
        this.chapterLink = chapterLink;
    }
}
