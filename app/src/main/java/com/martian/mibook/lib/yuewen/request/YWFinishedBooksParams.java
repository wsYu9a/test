package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
public class YWFinishedBooksParams extends TYHttpGetParams {

    @a
    private Integer ctype;

    @a
    private Integer ebtype;

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

    public int getEbType() {
        Integer num = this.ebtype;
        if (num == null) {
            return 2;
        }
        return num.intValue();
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

    @Override // u8.b
    public String getRequestMethod() {
        return "book_mall/end_books";
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setEbtype(Integer num) {
        this.ebtype = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }
}
