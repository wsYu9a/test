package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
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

    public TYTag setBookCount(Integer num) {
        this.bookCount = num;
        return this;
    }

    public TYTag setCategoryId(Integer num) {
        this.categoryId = num;
        return this;
    }

    public TYTag setCategoryName(String str) {
        this.categoryName = str;
        return this;
    }

    public TYTag setTag(String str) {
        this.tag = str;
        return this;
    }
}
