package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class ChapterPrice {
    private String ccid;
    private String chapterId;
    private int price;

    public String getCcid() {
        return this.ccid;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
