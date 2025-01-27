package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
public class YWBookPrice {
    private Long cbid;
    private Integer price;

    public long getCbid() {
        Long l10 = this.cbid;
        if (l10 == null) {
            return -1L;
        }
        return l10.longValue();
    }

    public int getPrice() {
        Integer num = this.price;
        if (num == null) {
            return 5;
        }
        return num.intValue();
    }

    public void setCbid(long j10) {
        this.cbid = Long.valueOf(j10);
    }

    public void setPrice(int i10) {
        this.price = Integer.valueOf(i10);
    }
}
