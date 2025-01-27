package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWNewBooksParams extends TYHttpGetParams {

    @a
    private Integer ctype;

    @a
    private Integer nbtype;

    @a
    private Integer page;

    @a
    private Integer pageSize = 10;

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getNbtype() {
        return this.nbtype;
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPageSize() {
        return this.pageSize.intValue();
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "book_mall/new_books";
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setNbtype(Integer nbtype) {
        this.nbtype = nbtype;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
