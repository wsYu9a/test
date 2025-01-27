package com.martian.mibook.lib.original.http.response;

import com.martian.mibook.lib.original.data.ORChapter;
import java.util.List;

/* loaded from: classes2.dex */
public class MiConsumeOrders {
    private String bookId;
    private List<ORChapter> chapterList;
    private Integer coins;
    private Integer price;

    public String getBookId() {
        return this.bookId;
    }

    public List<ORChapter> getChapterList() {
        return this.chapterList;
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

    public void setChapterList(List<ORChapter> chapterList) {
        this.chapterList = chapterList;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
