package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes3.dex */
public class TYCategoryTagGroup {
    private List<TYCategoryTagItem> items;
    private Integer layoutType;
    private String name;

    public List<TYCategoryTagItem> getItems() {
        return this.items;
    }

    public int getLayoutType() {
        Integer num = this.layoutType;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public String getName() {
        return this.name;
    }

    public void setItems(List<TYCategoryTagItem> list) {
        this.items = list;
    }

    public void setLayoutType(Integer num) {
        this.layoutType = num;
    }

    public void setName(String str) {
        this.name = str;
    }
}
