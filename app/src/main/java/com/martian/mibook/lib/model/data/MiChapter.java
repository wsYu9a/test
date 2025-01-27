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

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Chapter
    public void setSrcLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
