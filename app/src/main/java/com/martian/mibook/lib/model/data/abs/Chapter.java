package com.martian.mibook.lib.model.data.abs;

/* loaded from: classes3.dex */
public abstract class Chapter {
    public abstract String getChapterId();

    public Integer getChargeType() {
        return -1;
    }

    public Integer getPrice() {
        return 0;
    }

    public abstract String getSrcLink();

    public abstract String getTitle();

    public boolean isFree() {
        return true;
    }

    public boolean isVipChapter() {
        return false;
    }

    public abstract void setSrcLink(String str);

    public String toString() {
        return getTitle();
    }
}
