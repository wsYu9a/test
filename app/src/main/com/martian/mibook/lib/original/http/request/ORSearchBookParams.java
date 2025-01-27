package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
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

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setSearchType(Integer num) {
        this.searchType = num;
    }
}
