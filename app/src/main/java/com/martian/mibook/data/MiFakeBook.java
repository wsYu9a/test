package com.martian.mibook.data;

import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;

/* loaded from: classes3.dex */
public class MiFakeBook extends Book {
    private Integer brtype;
    private final String fakeName;
    private Integer rank;

    public MiFakeBook(String fakeName) {
        this.fakeName = fakeName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        return 0;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookName() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getBrType() {
        Integer num = this.brtype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCategory() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.fakeName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getLastChapter() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Date getLastUpdated() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getRank() {
        Integer num = this.rank;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getShortIntro() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String cover) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String lastChapter) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String intro) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String toString() {
        return this.fakeName + " [网页阅读]";
    }
}
