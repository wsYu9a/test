package com.martian.mibook.lib.account.request;

import com.martian.mibook.lib.account.request.auth.TYAuthParams;
import v8.a;

/* loaded from: classes3.dex */
public class ReadingRecordsParams extends TYAuthParams {

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "reading_records";
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
