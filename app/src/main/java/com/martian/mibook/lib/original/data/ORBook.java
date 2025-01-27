package com.martian.mibook.lib.original.data;

import android.text.TextUtils;
import com.martian.libsupport.d;
import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;

@j.g(name = "or_books")
/* loaded from: classes2.dex */
public class ORBook extends Book {

    @j.b
    public Integer authorId;

    @j.b
    public String authorName;

    @j.b
    @j.f
    public String bookId;

    @j.b
    public String bookName;
    private Integer brtype;

    @j.b
    public String categoryName;

    @j.b
    public Integer chapterCount;

    @j.b
    public String coverUrl;
    private Long createdOn;

    @j.b
    private String keyword;

    @j.b
    public String latestChapter;

    @j.b
    public Long latestChapterUpdateTime;

    @j.b
    public String longDesc;
    private Integer rank;
    public Integer readCount;

    @j.b
    public Integer status;

    @j.b
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
            return d.f(this.latestChapterUpdateTime.longValue());
        } catch (Exception unused) {
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

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return this.bookId + "";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return com.martian.mibook.lib.model.manager.d.f14055g;
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

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String cover) {
        this.coverUrl = cover;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String chapter) {
        this.latestChapter = chapter;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String intro) {
        this.longDesc = intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
        this.bookId = sourceId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }
}
