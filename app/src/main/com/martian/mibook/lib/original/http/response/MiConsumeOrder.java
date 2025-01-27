package com.martian.mibook.lib.original.http.response;

/* loaded from: classes3.dex */
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

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterId(Integer num) {
        this.chapterId = num;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }
}
