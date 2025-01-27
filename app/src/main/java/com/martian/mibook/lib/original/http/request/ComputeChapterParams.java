package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes2.dex */
public class ComputeChapterParams extends TYAuthParams {

    @a
    private String bookId;

    @a
    private Integer chapterSize;

    @a
    private Integer startChapterId;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "or/compute_chapter_price";
    }

    public String getBookId() {
        return this.bookId;
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public Integer getStartChapterId() {
        return this.startChapterId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void setStartChapterId(Integer startChapterId) {
        this.startChapterId = startChapterId;
    }
}
