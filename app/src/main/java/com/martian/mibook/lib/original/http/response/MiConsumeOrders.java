package com.martian.mibook.lib.original.http.response;

import com.martian.mibook.lib.original.data.ORChapter;
import java.util.List;

/* loaded from: classes3.dex */
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

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterList(List<ORChapter> list) {
        this.chapterList = list;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }
}
