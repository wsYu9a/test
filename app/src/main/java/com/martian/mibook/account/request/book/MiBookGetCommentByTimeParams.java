package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes3.dex */
public class MiBookGetCommentByTimeParams extends TYHttpGetParams {

    @a
    private String chapterId;

    @a
    private Long lastCreatedOn;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getChapterId() {
        return this.chapterId;
    }

    public Long getLastCreatedOn() {
        return this.lastCreatedOn;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "/get_comments_by_time.do";
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

    public void setLastCreatedOn(Long lastCreatedOn) {
        this.lastCreatedOn = lastCreatedOn;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
