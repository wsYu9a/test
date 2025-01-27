package com.martian.mibook.lib.model.data.abs;

/* loaded from: classes3.dex */
public abstract class ChapterContent {
    public String getContent(int start) {
        return getContent(start, getContentLength());
    }

    public abstract String getContent(int start, int end);

    public abstract int getContentLength();

    public abstract String getTitle();

    public abstract boolean isEmpty();

    public abstract void setSrcLink(String srcLink);
}
