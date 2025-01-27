package com.martian.mibook.lib.yuewen.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWCategory {
    private String categoryCover;
    private Integer categoryId;
    private String categoryName;
    private List<YWSubCategory> subCategoryList;
    private List<TYTag> tagList;

    public String getCategoryCover() {
        return this.categoryCover;
    }

    public int getCategoryId() {
        Integer num = this.categoryId;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<YWSubCategory> getSubCategoryList() {
        if (this.subCategoryList == null) {
            this.subCategoryList = new ArrayList();
        }
        return this.subCategoryList;
    }

    public List<TYTag> getTagList() {
        if (this.tagList == null) {
            this.tagList = new ArrayList();
        }
        return this.tagList;
    }

    public YWCategory setCategoryCover(String str) {
        this.categoryCover = str;
        return this;
    }

    public YWCategory setCategoryId(Integer num) {
        this.categoryId = num;
        return this;
    }

    public YWCategory setCategoryName(String str) {
        this.categoryName = str;
        return this;
    }

    public YWCategory setSubCategoryList(List<YWSubCategory> list) {
        this.subCategoryList = list;
        return this;
    }

    public void setTagList(List<TYTag> list) {
        this.tagList = list;
    }
}
