package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes4.dex */
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

    public void setDiscountList(List<TYDiscount> discountList) {
        this.discountList = discountList;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
