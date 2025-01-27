package com.martian.mibook.lib.local.txt.data;

import ba.k;
import com.martian.mibook.lib.local.base.data.LocalBook;
import java.util.Date;
import vb.e;

@k.h(name = "txtbooks")
/* loaded from: classes3.dex */
public class TXTBook extends LocalBook {

    @k.b
    private String author;

    @k.b
    private String bookName;
    private Integer brtype;

    @k.b
    private Integer chapterCount;

    @k.b
    private Integer chapterIndex;

    @k.b
    private String charset;

    @k.b
    private Integer contentIndex;

    @k.b
    private String coverUrl;

    @k.b
    private Long fileSize;

    @k.g
    @k.b
    private String filepath;

    @k.b
    private Boolean flagTop;

    @k.b
    private Long insertTime;

    @k.b
    private String lastChapter;

    @k.b
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
        return e.f31296c;
    }

    public Integer getChapterCount() {
        return this.chapterCount;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getChapterSize() {
        return this.chapterCount;
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

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return e.f31296c;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return this.filepath;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAllWords(Integer num) {
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String str) {
        this.author = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String str) {
        this.bookName = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookStatus(String str) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
    }

    public void setChapterCount(Integer num) {
        this.chapterCount = num;
    }

    public void setChapterIndex(Integer num) {
        this.chapterIndex = num;
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setContentIndex(Integer num) {
        this.contentIndex = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String str) {
        this.coverUrl = str;
    }

    public void setFilePath(String str) {
        this.filepath = str;
    }

    public void setFileSize(Long l10) {
        this.fileSize = l10;
    }

    public void setFlagTop(Boolean bool) {
        this.flagTop = bool;
    }

    public void setInsertTime(Long l10) {
        this.insertTime = l10;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String str) {
        this.lastChapter = str;
    }

    public void setLastReadingTime(Long l10) {
        this.lastReadingTime = l10;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long l10) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String str) {
        this.filepath = str;
    }
}
