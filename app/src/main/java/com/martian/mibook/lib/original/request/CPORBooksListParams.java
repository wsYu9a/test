package com.martian.mibook.lib.original.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
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

    @Override // u8.b
    public String getRequestMethod() {
        return "ty/free_orbooks";
    }

    public void setCtype(int i10) {
        this.ctype = i10;
    }

    public void setPage(int i10) {
        this.page = i10;
    }

    public void setPageSize(int i10) {
        this.pageSize = i10;
    }
}
