package com.martian.mibook.lib.yuewen.request;

import com.martian.mibook.lib.account.request.TYHttpGetParams;
import v8.a;

/* loaded from: classes3.dex */
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

    @Override // u8.b
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

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public void setFreeType(Integer num) {
        this.freeType = num;
    }

    public void setFrom(int i10) {
        this.from = Integer.valueOf(i10);
    }

    public void setOrder(Integer num) {
        this.order = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setWordCountLower(Integer num) {
        this.wordCountLower = num;
    }

    public void setWordCountUpper(Integer num) {
        this.wordCountUpper = num;
    }
}
