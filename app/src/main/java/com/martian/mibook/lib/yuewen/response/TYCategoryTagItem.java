package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes4.dex */
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

    public TYCategoryTagItem setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
