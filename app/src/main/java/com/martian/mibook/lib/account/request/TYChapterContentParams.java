package com.martian.mibook.lib.account.request;

import v8.a;

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

    @Override // u8.b
    public String getRequestMethod() {
        return "authopt/ty/chapter_content";
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
