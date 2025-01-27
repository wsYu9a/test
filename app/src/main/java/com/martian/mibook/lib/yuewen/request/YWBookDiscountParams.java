package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWBookDiscountParams extends TYHttpGetParams {

    @a
    private Integer page;

    @a
    private Integer pageSize = 10;

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPageSize() {
        Integer num = this.pageSize;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    @Override // u8.b
    public String getRequestMethod() {
        return "discount_list";
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }
}
