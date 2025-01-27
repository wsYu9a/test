package com.martian.mibook.lib.model.data;

import ba.k;
import ba.l;

@k.e(columns = "sourceString, chapterIndex, contentPos", name = "scc")
/* loaded from: classes3.dex */
public class MiBookMark {
    public static final int TYPE_BOOK_MARK = 0;
    public static final int TYPE_BOOK_UNDERLINE = 1;

    @k.a
    @k.b
    private Integer _id;

    @k.e(columns = "chapterId", name = "chapterId")
    @k.b
    private String chapterId;

    @k.b
    private Integer chapterIndex;

    @k.b
    private String chapterTitle;

    @k.b(name = "contentSize")
    private Integer contentEnd;

    @k.b
    private Integer contentPos;

    @k.b
    private Integer dimiPercent;

    @k.b
    private Long markTime;

    @k.b
    private String sourceString;

    @k.b
    private String summary;

    @k.b
    private Integer type;

    public String getChapterId() {
        return this.chapterId;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public Integer getContentEnd() {
        return this.contentEnd;
    }

    public Integer getContentPos() {
        return this.contentPos;
    }

    public Integer getDimiPercent() {
        return this.dimiPercent;
    }

    public Integer getEnd() {
        return this.contentEnd;
    }

    public Long getMarkTime() {
        return this.markTime;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public Integer getStart() {
        return this.contentPos;
    }

    public String getSummary() {
        return this.summary;
    }

    public Integer getType() {
        return this.type;
    }

    public Integer get_id() {
        return this._id;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setChapterIndex(Integer num) {
        this.chapterIndex = num;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setContentEnd(Integer num) {
        this.contentEnd = num;
    }

    public void setContentPos(Integer num) {
        this.contentPos = num;
    }

    public void setDimiPercent(Integer num) {
        this.dimiPercent = num;
    }

    public void setMarkTime(Long l10) {
        this.markTime = l10;
    }

    public void setSourceString(String str) {
        this.sourceString = str;
    }

    public void setSummary(String str) {
        this.summary = l.b(str);
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public void set_id(Integer num) {
        this._id = num;
    }
}
