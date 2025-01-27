package com.martian.mibook.account.request.book;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class MiBookTopCommentParams extends TYHttpGetParams {

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // u8.b
    public String getRequestMethod() {
        return "get_book_scores_and_top_comments.do";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
