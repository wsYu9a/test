package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes3.dex */
public class TYDiscountList {
    private List<TYDiscount> discountList;
    private Integer total;

    public List<TYDiscount> getDiscountList() {
        return this.discountList;
    }

    public int getTotal() {
        Integer num = this.total;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setDiscountList(List<TYDiscount> list) {
        this.discountList = list;
    }

    public void setTotal(Integer num) {
        this.total = num;
    }
}
