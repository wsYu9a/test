package com.martian.mibook.lib.local.txt.data;

import com.martian.libsupport.j;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.model.manager.d;
import java.util.Date;

@j.g(name = "txtbooks")
/* loaded from: classes3.dex */
public class TXTBook extends LocalBook {

    @j.b
    private String author;

    @j.b
    private String bookName;
    private Integer brtype;

    @j.b
    private Integer chapterCount;

    @j.b
    private Integer chapterIndex;

    @j.b
    private String charset;

    @j.b
    private Integer contentIndex;

    @j.b
    private String coverUrl;

    @j.b
    private Long fileSize;

    @j.b
    @j.f
    private String filepath;

    @j.b
    private Boolean flagTop;

    @j.b
    private Long insertTime;

    @j.b
    private String lastChapter;

    @j.b
    private Long lastReadingTime;
    private Integer rank;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        return 0;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return this.author;
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
        return d.f14056h;
    }

    public Integer getChapterCount() {
        return this.chapterCount;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    @Override // com.martian.mibook.lib.local.base.data.LocalBook
    public String getCharset() {
        return this.charset;
    }

    public Integer getContentIndex() {
        return this.contentIndex;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.coverUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // com.martian.mibook.lib.local.base.data.LocalBook
    public String getFilePath() {
        return this.filepath;
    }

    @Override // com.martian.mibook.lib.local.base.data.LocalBook
    public Long getFileSize() {
        return this.fileSize;
    }

    public Boolean getFlagTop() {
        return this.flagTop;
    }

    public Long getInsertTime() {
        return this.insertTime;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getLastChapter() {
        return this.lastChapter;
    }

    public Long getLastReadingTime() {
        return this.lastReadingTime;
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
    public String getSourceName() {
        return d.f14056h;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return this.filepath;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        return null;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
        this.author = authorName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setContentIndex(Integer contentIndex) {
        this.contentIndex = contentIndex;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setFilePath(String filepath) {
        this.filepath = filepath;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public void setFlagTop(Boolean flagTop) {
        this.flagTop = flagTop;
    }

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public void setLastReadingTime(Long lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
        throw new UnsupportedOperationException("Cannot call set Source Id in TXTBook.");
    }
}
