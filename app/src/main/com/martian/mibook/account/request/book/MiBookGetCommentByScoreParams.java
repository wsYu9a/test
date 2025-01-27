package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookGetCommentByScoreParams extends TYHttpGetParams {

    @a
    private String chapterId;

    @a
    private Integer page;

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

    public Integer getPage() {
        return this.page;
    }

    public Integer getParagraphIdx() {
        return this.paragraphIdx;
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "/get_comments_by_score.do";
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

    public void setPage(Integer num) {
        this.page = num;
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
