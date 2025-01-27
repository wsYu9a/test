package com.martian.mibook.lib.original.http.response;

/* loaded from: classes2.dex */
public class MiConsumeOrder {
    private String bookId;
    private Integer chapterId;
    private Integer coins;
    private Integer price;

    public String getBookId() {
        return this.bookId;
    }

    public Integer getChapterId() {
        return this.chapterId;
    }

    public Integer getCoins() {
        Integer num = this.coins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getPrice() {
        Integer num = this.price;
        return Integer.valueOf(num == null ? 0 : num.intValue());
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

    public void setPrice(Integer price) {
        this.price = price;
    }
}
