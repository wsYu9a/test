package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes4.dex */
public class TYTag {
    private Integer bookCount;
    private Integer categoryId;
    private String categoryName;
    private String tag;

    public int getBookCount() {
        Integer num = this.bookCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getTag() {
        return this.tag;
    }

    public TYTag setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
        return this;
    }

    public TYTag setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public TYTag setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public TYTag setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
