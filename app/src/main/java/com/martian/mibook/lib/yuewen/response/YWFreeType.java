package com.martian.mibook.lib.yuewen.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
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

    public void setCategoryList(List<YWCategory> list) {
        this.categoryList = list;
    }

    public void setFreeType(Integer num) {
        this.freeType = num;
    }

    public void setFreeTypeName(String str) {
        this.freeTypeName = str;
    }
}
