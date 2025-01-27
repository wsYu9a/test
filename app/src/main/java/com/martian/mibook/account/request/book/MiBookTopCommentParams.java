package com.martian.mibook.account.request.book;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes3.dex */
public class MiBookTopCommentParams extends TYHttpGetParams {

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "get_book_scores_and_top_comments.do";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
