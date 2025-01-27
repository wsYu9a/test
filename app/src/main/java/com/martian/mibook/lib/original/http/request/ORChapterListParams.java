package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes2.dex */
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

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setPage(int page) {
        this.page = Integer.valueOf(page);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
