package com.martian.mibook.lib.account.request.auth;

import v8.a;

/* loaded from: classes3.dex */
public class GetHistoryCommissionsParams extends TYAuthParams {

    @a
    private Integer page = 0;

    @a
    private Integer pageSize = 10;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "history_commissions.do";
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
