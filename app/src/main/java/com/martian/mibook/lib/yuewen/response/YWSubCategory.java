package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes4.dex */
public class YWSubCategory {
    private Integer subCategoryId;
    private String subCategoryName;

    public int getSubCategoryId() {
        Integer num = this.subCategoryId;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}
