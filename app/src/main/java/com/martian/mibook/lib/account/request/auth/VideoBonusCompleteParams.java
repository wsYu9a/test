package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class VideoBonusCompleteParams extends TYAuthParams {

    @a
    private String bookName;

    @a
    private String chapterId;

    @a
    private String chapterName;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "ty/vbuy_chapter";
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
