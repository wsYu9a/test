package com.martian.mibook.data.book;

/* loaded from: classes3.dex */
public class VoteResult {
    private Boolean hasUp;
    private Integer upCount;

    public boolean getHasUp() {
        Boolean bool = this.hasUp;
        return bool != null && bool.booleanValue();
    }

    public Integer getUpCount() {
        return this.upCount;
    }

    public void setHasUp(Boolean hasUp) {
        this.hasUp = hasUp;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }
}
