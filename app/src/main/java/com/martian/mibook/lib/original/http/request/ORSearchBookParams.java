package com.martian.mibook.lib.original.http.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes2.dex */
public class ORSearchBookParams extends TYAuthoptParams {

    @a
    private Integer ctype;

    @a
    private String keywords;

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private Integer searchType;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "or/search_books";
    }

    public Integer getCtype() {
        return this.ctype;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getSearchType() {
        return this.searchType;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }
}
