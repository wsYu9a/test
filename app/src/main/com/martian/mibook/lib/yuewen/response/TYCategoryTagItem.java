package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
public class TYCategoryTagItem {
    private Integer categoryId;
    private String coverUrl;
    private String desc;
    private Integer from;
    private String label;
    private String name;
    private Integer type;

    public int getCategoryId() {
        Integer num = this.categoryId;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public Integer getFrom() {
        return this.from;
    }

    public String getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        Integer num = this.type;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public TYCategoryTagItem setCategoryId(Integer num) {
        this.categoryId = num;
        return this;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFrom(Integer num) {
        this.from = num;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
