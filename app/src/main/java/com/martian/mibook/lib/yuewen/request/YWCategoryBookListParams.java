package com.martian.mibook.lib.yuewen.request;

import com.martian.libcomm.http.requests.d.a;
import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes4.dex */
public class YWCategoryBookListParams extends TYHttpGetParams {

    @a
    private Integer categoryId;

    @a
    private Integer freeType;

    @a
    private Integer from;

    @a
    private Integer order;

    @a
    private Integer page;

    @a
    private final Integer pageSize = 10;

    @a
    private Integer status;

    @a
    private Integer subCategoryId;

    @a
    private String tags;

    @a
    private Integer wordCountLower;

    @a
    private Integer wordCountUpper;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public Integer getFreeType() {
        return this.freeType;
    }

    public int getFrom() {
        Integer num = this.from;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getOrder() {
        return this.order;
    }

    public int getPage() {
        Integer num = this.page;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        return "ty/search_by_category";
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getTags() {
        return this.tags;
    }

    public Integer getWordCountLower() {
        return this.wordCountLower;
    }

    public Integer getWordCountUpper() {
        return this.wordCountUpper;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public void setFrom(int from) {
        this.from = Integer.valueOf(from);
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setWordCountLower(Integer wordCountLower) {
        this.wordCountLower = wordCountLower;
    }

    public void setWordCountUpper(Integer wordCountUpper) {
        this.wordCountUpper = wordCountUpper;
    }
}
