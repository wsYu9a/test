package com.martian.mibook.lib.model.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.d;
import java.util.Date;

@j.g(name = "miarchive_books")
/* loaded from: classes3.dex */
public class MiArchiveBookItem extends Book {

    @j.b
    @j.a
    @j.e(ascend = false)
    private Integer _id;

    @j.b
    private Date archiveDate;

    @j.b
    private String author;

    @j.b
    private String bookId;

    @j.b
    private String bookName;

    @j.b
    private String bookUrl;
    private Integer brtype;

    @j.b
    private Integer chapterSize;

    @j.b
    private String coverUrl;

    @j.b
    private String lastestChapter;
    private Integer rank;

    @j.b
    private String shortIntro;

    @j.b
    private String sourceString;

    @j.b
    private String tag;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean equals(Object o) {
        if (o instanceof MiArchiveBookItem) {
            return ((MiArchiveBookItem) o).getBookId().equals(this.bookId);
        }
        return false;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        return 0;
    }

    public Date getArchiveDate() {
        return this.archiveDate;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return this.author;
    }

    public String getBookId() {
        return this.bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookName() {
        return this.bookName;
    }

    public String getBookUrl() {
        return this.bookUrl;
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
        return "";
    }

    public Integer getChapterSize() {
        return this.chapterSize;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.coverUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getLastChapter() {
        return this.lastestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Date getLastUpdated() {
        return this.archiveDate;
    }

    public String getLastestChapter() {
        return this.lastestChapter;
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
        return this.shortIntro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return d.c(this.sourceString);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return d.d(this.sourceString);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceString() {
        return this.sourceString;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        return "";
    }

    public String getTag() {
        return this.tag;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int hashCode() {
        return this.bookId.hashCode();
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
        this.author = authorName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String lastChapter) {
        this.lastestChapter = lastChapter;
    }

    public void setLastestChapter(String lastestChapter) {
        this.lastestChapter = lastestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
        throw new UnsupportedOperationException("set Source Id in Archive book.");
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
