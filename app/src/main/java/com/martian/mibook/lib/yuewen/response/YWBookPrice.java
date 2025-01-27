package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes4.dex */
public class YWBookPrice {
    private Long cbid;
    private Integer price;

    public long getCbid() {
        Long l = this.cbid;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public int getPrice() {
        Integer num = this.price;
        if (num == null) {
            return 5;
        }
        return num.intValue();
    }

    public void setCbid(long cbid) {
        this.cbid = Long.valueOf(cbid);
    }

    public void setPrice(int price) {
        this.price = Integer.valueOf(price);
    }
}
