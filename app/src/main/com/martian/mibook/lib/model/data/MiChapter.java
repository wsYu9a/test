package com.martian.mibook.lib.model.data;

import com.martian.mibook.lib.model.data.abs.Chapter;

/* loaded from: classes3.dex */
public class MiChapter extends Chapter {
    private String bookId;
    private String chapterId;
    private String link;
    private String title;

    public String getBookId() {
        return this.bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getChapterId() {
        return this.chapterId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getSrcLink() {
        return this.link;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public String getTitle() {
        return this.title;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String str) {
        this.link = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
