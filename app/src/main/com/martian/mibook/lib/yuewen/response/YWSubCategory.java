package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
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

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }
}
