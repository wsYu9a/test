package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.auth.TYAuthParams;

/* loaded from: classes2.dex */
public class ConsumeChapterParams extends TYAuthParams {

    @a
    private String bookId;

    @a
    private Integer chapterId;

    @a
    private Integer coins;

    @a
    private String content;

    @a
    private String subject;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "or/buy_chapter";
    }

    public String getBookId() {
        return this.bookId;
    }

    public Integer getChapterId() {
        return this.chapterId;
    }

    public Integer getCoins() {
        return this.coins;
    }

    public String getContent() {
        return this.content;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
