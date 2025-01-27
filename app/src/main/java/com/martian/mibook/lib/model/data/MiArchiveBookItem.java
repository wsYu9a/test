package com.martian.mibook.lib.model.data;

import ba.k;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;
import vb.e;

@k.h(name = "miarchive_books")
/* loaded from: classes3.dex */
public class MiArchiveBookItem extends Book {

    @k.a
    @k.b
    @k.f(ascend = false)
    private Integer _id;

    @k.b
    private Date archiveDate;

    @k.b
    private String author;

    @k.b
    private String bookId;

    @k.b
    private String bookName;

    @k.b
    private String bookUrl;
    private Integer brtype;

    @k.b
    private Integer chapterSize;

    @k.b
    private String coverUrl;

    @k.b
    private String lastestChapter;
    private Integer rank;

    @k.b
    private String shortIntro;

    @k.b
    private String sourceString;

    @k.b
    private String tag;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean equals(Object obj) {
        if (obj instanceof MiArchiveBookItem) {
            return ((MiArchiveBookItem) obj).getBookId().equals(this.bookId);
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

    @Override // com.martian.mibook.lib.model.data.abs.Book
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

    @Override // com.martian.mibook.lib.model.data.abs.Book
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

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return e.d(this.sourceString);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return e.e(this.sourceString);
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
        String str = this.bookId;
        if (str != null) {
            return str.hashCode();
        }
        String str2 = this.sourceString;
        if (str2 == null) {
            return 0;
        }
        return str2.hashCode();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAllWords(Integer num) {
    }

    public void setArchiveDate(Date date) {
        this.archiveDate = date;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String str) {
        this.author = str;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String str) {
        this.bookName = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookStatus(String str) {
    }

    public void setBookUrl(String str) {
        this.bookUrl = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String str) {
        this.coverUrl = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String str) {
        this.lastestChapter = str;
    }

    public void setLastestChapter(String str) {
        this.lastestChapter = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long l10) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String str) {
        this.shortIntro = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String str) {
        throw new UnsupportedOperationException("set Source Id in Archive book.");
    }

    public void setSourceString(String str) {
        this.sourceString = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
