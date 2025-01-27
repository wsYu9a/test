package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes2.dex */
public class ConsumeChaptersParams extends TYAuthParams {

    @a
    private String bookId;

    @a
    private Integer chapterSize;

    @a
    private Integer coins;

    @a
    private Integer endChapterId;

    @a
    private Integer startChapterId;

    @a
    private String subject;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "or/buy_chapters";
    }

    public String getBookId() {
        return this.bookId;
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public Integer getCoins() {
        return this.coins;
    }

    public Integer getEndChapterId() {
        return this.endChapterId;
    }

    public Integer getStartChapterId() {
        return this.startChapterId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setEndChapterId(Integer endChapterId) {
        this.endChapterId = endChapterId;
    }

    public void setStartChapterId(Integer startChapterId) {
        this.startChapterId = startChapterId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
