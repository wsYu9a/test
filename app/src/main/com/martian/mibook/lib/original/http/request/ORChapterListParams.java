package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class ORChapterListParams extends TYAuthoptParams {

    @a
    private String bookId;

    @a
    private Integer page = 0;

    @a
    private Integer pageSize = 10000;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "or/chapter_list";
    }

    public String getBookId() {
        return this.bookId;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setPage(int i10) {
        this.page = Integer.valueOf(i10);
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }
}
