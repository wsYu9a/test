package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class GetConsumeOrderListParams extends TYAuthParams {

    @a
    private Integer page = 0;

    @a
    private Integer pageSize = 5;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "get_consume_orders.do";
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }
}
