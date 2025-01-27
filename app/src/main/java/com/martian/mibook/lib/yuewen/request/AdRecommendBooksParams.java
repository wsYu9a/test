package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class AdRecommendBooksParams extends TYAuthoptParams {

    @a
    private Integer page;

    @a
    private Integer pageSize;

    @a
    private Integer seed;

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

    public Integer getSeed() {
        return this.seed;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public void setSeed(Integer num) {
        this.seed = num;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }
}
