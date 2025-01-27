package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes3.dex */
public class MiBookGetCommentByScoreParams extends TYHttpGetParams {

    @a
    private String chapterId;

    @a
    private Integer page;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getChapterId() {
        return this.chapterId;
    }

    public Integer getPage() {
        return this.page;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "/get_comments_by_score.do";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
