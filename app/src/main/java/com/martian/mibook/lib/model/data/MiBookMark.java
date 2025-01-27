package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;
import com.martian.libsupport.k;

/* loaded from: classes3.dex */
public class MiBookMark {

    @j.b
    @j.a
    private Integer _id;

    @j.b
    private Integer chapterIndex;

    @j.b
    private String chapterTitle;

    @j.b
    private Integer contentPos;

    @j.b
    private Integer contentSize;

    @j.b
    private Integer dimiPercent;

    @j.b
    @j.e(ascend = true)
    private Long markTime;

    @j.b
    private String sourceString;

    @j.b
    private String summary;

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public Integer getContentPos() {
        return this.contentPos;
    }

    public Integer getContentSize() {
        return this.contentSize;
    }

    public Integer getDimiPercent() {
        return this.dimiPercent;
    }

    public Long getMarkTime() {
        return this.markTime;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void setContentPos(Integer contentPos) {
        this.contentPos = contentPos;
    }

    public void setContentSize(Integer contentSize) {
        this.contentSize = contentSize;
    }

    public void setDimiPercent(Integer dimiPercent) {
        this.dimiPercent = dimiPercent;
    }

    public void setMarkTime(Long markTime) {
        this.markTime = markTime;
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }

    public void setSummary(String summary) {
        this.summary = k.b(summary);
    }
}
