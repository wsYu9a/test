package com.martian.mibook.lib.yuewen.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class YWFreeType {
    private List<YWCategory> categoryList;
    private Integer freeType;
    private String freeTypeName;

    public List<YWCategory> getCategoryList() {
        if (this.categoryList == null) {
            this.categoryList = new ArrayList();
        }
        return this.categoryList;
    }

    public int getFreeType() {
        Integer num = this.freeType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getFreeTypeName() {
        return this.freeTypeName;
    }

    public void setCategoryList(List<YWCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public void setFreeTypeName(String freeTypeName) {
        this.freeTypeName = freeTypeName;
    }
}
