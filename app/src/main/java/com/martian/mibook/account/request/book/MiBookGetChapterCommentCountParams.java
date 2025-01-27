package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.libfeedback.request.FeedbacklTaskHttpGetParams;

/* loaded from: classes3.dex */
public class MiBookGetChapterCommentCountParams extends FeedbacklTaskHttpGetParams {

    @a
    private String chapterIds;

    @a
    private Integer page;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getChapterIds() {
        return this.chapterIds;
    }

    public Integer getPage() {
        return this.page;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "authopt/chapter_comment_count";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterIds(String chapterIds) {
        this.chapterIds = chapterIds;
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
