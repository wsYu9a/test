package com.martian.mibook.lib.account.request;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class TYChapterContentParams extends TYHttpGetParams {

    @a
    private String chapterId;

    @a
    private String sourceId;

    @a
    private String sourceName;

    public String getChapterId() {
        return this.chapterId;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "authopt/ty/chapter_content";
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

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
