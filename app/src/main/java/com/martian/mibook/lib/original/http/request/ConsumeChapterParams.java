package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
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

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterId(Integer num) {
        this.chapterId = num;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }
}
