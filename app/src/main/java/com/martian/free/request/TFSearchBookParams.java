package com.martian.free.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class TFSearchBookParams extends TYAuthoptParams {

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

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "ty/search_books";
    }

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFromUser() {
        Integer num = this.searchType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setFromUser(Integer num) {
        this.searchType = num;
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

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
