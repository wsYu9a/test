package com.martian.mibook.lib.original.data;

import android.text.TextUtils;
import ba.f;
import ba.k;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;
import vb.e;

@k.h(name = "or_books")
/* loaded from: classes3.dex */
public class ORBook extends Book {

    @k.b
    public Integer authorId;

    @k.b
    public String authorName;

    @k.g
    @k.b
    public String bookId;

    @k.b
    public String bookName;
    private Integer brtype;

    @k.b
    public String categoryName;

    @k.b
    public Integer chapterCount;

    @k.b
    public String coverUrl;
    private Long createdOn;

    @k.b
    private String keyword;

    @k.b
    public String latestChapter;

    @k.b
    public Long latestChapterUpdateTime;

    @k.b
    public String longDesc;
    private Integer rank;
    public Integer readCount;

    @k.b
    public Integer status;

    @k.b
    public Integer wordCount;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        return this.wordCount;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return this.authorName;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookId() {
        return this.bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookName() {
        return this.bookName;
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
        return this.categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getChapterCount() {
        Integer num = this.chapterCount;
        return Integer.valueOf(num == null ? -1 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getChapterSize() {
        return this.chapterCount;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.coverUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getLastChapter() {
        return this.latestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Date getLastUpdated() {
        try {
            return f.f(this.latestChapterUpdateTime.longValue());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String getLatestChapter() {
        return this.latestChapter;
    }

    public Long getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public String getLongDesc() {
        return this.longDesc;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getRank() {
        Integer num = this.rank;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Integer getReadCount() {
        Integer num = this.readCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getShortIntro() {
        return TextUtils.isEmpty(this.longDesc) ? "" : this.longDesc;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return this.bookId + "";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return e.f31295b;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return "";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        Integer num = this.status;
        return (num == null || num.intValue() == 1) ? Book.STATUS_UNFINISHED : Book.STATUS_FINISHED;
    }

    public Integer getWordCount() {
        Integer num = this.wordCount;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isFreeBook() {
        return false;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAllWords(Integer num) {
        this.wordCount = num;
    }

    public void setAuthorId(Integer num) {
        this.authorId = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String str) {
        this.authorName = str;
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
        this.status = Integer.valueOf(Book.STATUS_UNFINISHED.equals(str) ? 1 : 0);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setChapterCount(Integer num) {
        this.chapterCount = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String str) {
        this.coverUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String str) {
        this.latestChapter = str;
    }

    public void setLatestChapter(String str) {
        this.latestChapter = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long l10) {
        this.latestChapterUpdateTime = l10;
    }

    public void setLongDesc(String str) {
        this.longDesc = str;
    }

    public void setReadCount(Integer num) {
        this.readCount = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String str) {
        this.longDesc = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String str) {
        this.bookId = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setWordCount(Integer num) {
        this.wordCount = num;
    }
}
