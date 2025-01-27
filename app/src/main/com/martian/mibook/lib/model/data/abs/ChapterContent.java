package com.martian.mibook.lib.model.data.abs;

/* loaded from: classes3.dex */
public abstract class ChapterContent {
    public abstract String getContent();

    public String getContent(int i10) {
        return getContent(i10, getContentLength());
    }

    public abstract String getContent(int i10, int i11);

    public abstract int getContentLength();

    public abstract String getTitle();

    public abstract boolean isEmpty();

    public abstract void setSrcLink(String str);
}
