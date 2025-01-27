package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookGetCommentByTimeParams extends TYHttpGetParams {

    @a
    private String chapterId;

    @a
    private Long lastCreatedOn;

    @a
    private Integer paragraphIdx;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @a
    private Integer type;

    public String getChapterId() {
        return this.chapterId;
    }

    public Long getLastCreatedOn() {
        return this.lastCreatedOn;
    }

    public Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "/get_comments_by_time.do";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public Integer getType() {
        return this.type;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setLastCreatedOn(Long l10) {
        this.lastCreatedOn = l10;
    }

    public void setParagraphIdx(Integer num) {
        this.paragraphIdx = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
