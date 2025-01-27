package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYAuthoptParams;

/* loaded from: classes4.dex */
public class AdRecommendBooksParams extends TYAuthoptParams {

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private String sourceId;

    @a
    private String sourceName;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "ty/reader/recommend_books";
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

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
