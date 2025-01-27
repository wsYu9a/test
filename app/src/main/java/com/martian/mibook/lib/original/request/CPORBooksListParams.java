package com.martian.mibook.lib.original.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes2.dex */
public class CPORBooksListParams extends TYHttpGetParams {

    @a
    private int page = 0;

    @a
    private int pageSize = 10;

    @a
    private int ctype = 0;

    public int getCtype() {
        return this.ctype;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "ty/free_orbooks";
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
