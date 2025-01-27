package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes4.dex */
public class RecommendBooksParams extends TYAuthoptParams {

    @a
    private String keywords;

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private Integer searchType;

    @a
    private Integer seed;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "ty/recommend_books";
    }

    public String getKeywords() {
        return this.keywords;
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getSearchType() {
        return this.searchType;
    }

    public Integer getSeed() {
        return this.seed;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
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

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
