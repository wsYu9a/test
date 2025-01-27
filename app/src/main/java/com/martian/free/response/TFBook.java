package com.martian.free.response;

import com.martian.libmars.utils.p0;
import com.martian.libsupport.d;
import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;
import java.util.List;

@j.g(name = "tfbook")
/* loaded from: classes2.dex */
public class TFBook extends Book {

    @j.b
    private Integer allWords;

    @j.b
    private String authorName;

    @j.b
    @j.f
    private String bid;
    private Integer brtype;
    private Integer categoryId;

    @j.b
    private String categoryName;

    @j.b
    private Integer chapterSize;

    @j.b
    private String coverUrl;

    @j.b
    private String cpName;
    private Long createdOn;

    @j.b
    private String freeType;
    private String intro;

    @j.b
    private String keyword;

    @j.b
    private String latestChapter;

    @j.b
    private Long latestChapterUpdateTime;
    private Boolean newBook;
    private Boolean promote;
    private Integer rank;

    @j.b
    private Integer status;
    private Integer subCategoryId;

    @j.b
    private String subCategoryName;
    private List<String> tagList;

    @j.b
    private String title;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        Integer num = this.allWords;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return this.authorName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getBid() {
        return this.bid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookName() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getBrType() {
        Integer num = this.brtype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getBrtype() {
        return this.brtype;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCategory() {
        return !k.p(this.categoryName) ? this.categoryName : this.subCategoryName;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getChapterSize() {
        Integer num = this.chapterSize;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.coverUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getCpName() {
        return this.cpName;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public String getFreeType() {
        return this.freeType;
    }

    public String getIntro() {
        return this.intro;
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
        Long l = this.latestChapterUpdateTime;
        if (l == null) {
            return null;
        }
        try {
            return d.f(l.longValue());
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

    public boolean getNewBook() {
        Boolean bool = this.newBook;
        return bool != null && bool.booleanValue();
    }

    public boolean getPromote() {
        Boolean bool = this.promote;
        return bool != null && bool.booleanValue();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getRank() {
        Integer num = this.rank;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Integer getRawStatus() {
        return this.status;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getShortIntro() {
        return k.p(this.intro) ? "" : this.intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return String.valueOf(this.bid);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return com.martian.mibook.lib.model.manager.d.l;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return "";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        Integer num = this.status;
        return num == null ? "" : num.intValue() == 50 ? Book.STATUS_FINISHED : Book.STATUS_UNFINISHED;
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getUpdateDateString() {
        Long l;
        String updateDateString = super.getUpdateDateString();
        return (!k.p(updateDateString) || (l = this.latestChapterUpdateTime) == null) ? updateDateString : p0.r(l.longValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isFreeBook() {
        return true;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isPromoteBook() {
        return getPromote();
    }

    public void setAllWords(Integer allWords) {
        this.allWords = allWords;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
        this.title = bookName;
    }

    public void setBrtype(Integer brtype) {
        this.brtype = brtype;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setChapterSize(Integer chapterSize) {
        this.chapterSize = chapterSize;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String cover) {
        this.coverUrl = cover;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setFreeType(String freeType) {
        this.freeType = freeType;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String lastChapter) {
        this.latestChapter = lastChapter;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }

    public void setNewBook(Boolean newBook) {
        this.newBook = newBook;
    }

    public void setPromote(Boolean promote) {
        this.promote = promote;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String intro) {
        this.intro = intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
        try {
            this.bid = sourceId;
        } catch (Exception unused) {
        }
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
