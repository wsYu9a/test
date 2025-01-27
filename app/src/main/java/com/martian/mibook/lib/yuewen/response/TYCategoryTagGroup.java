package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes4.dex */
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

    public void setItems(List<TYCategoryTagItem> items) {
        this.items = items;
    }

    public void setLayoutType(Integer layoutType) {
        this.layoutType = layoutType;
    }

    public void setName(String name) {
        this.name = name;
    }
}
