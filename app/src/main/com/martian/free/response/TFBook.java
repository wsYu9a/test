package com.martian.free.response;

import ba.f;
import ba.k;
import ba.l;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;
import java.util.List;
import l9.o0;
import vb.e;

@k.h(name = "tfbook")
/* loaded from: classes3.dex */
public class TFBook extends Book {

    @k.b
    private Integer allWords;

    @k.b
    private String authorName;

    @k.g
    @k.b
    private String bid;
    private Integer brtype;
    private Integer categoryId;

    @k.b
    private String categoryName;

    @k.b
    private Integer chapterSize;

    @k.b
    private String coverUrl;

    @k.b
    private String cpName;
    private Long createdOn;

    @k.b
    private String freeType;
    private String intro;

    @k.b
    private String keyword;

    @k.b
    private String latestChapter;

    @k.b
    private Long latestChapterUpdateTime;
    private Boolean newBook;
    private Boolean promote;
    private Integer rank;

    @k.b
    private Integer status;
    private Integer subCategoryId;

    @k.b
    private String subCategoryName;
    private List<String> tagList;

    @k.b
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
        return !l.q(this.categoryName) ? this.categoryName : this.subCategoryName;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
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
        Long l10 = this.latestChapterUpdateTime;
        if (l10 == null) {
            return null;
        }
        try {
            return f.f(l10.longValue());
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
        return l.q(this.intro) ? "" : this.intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return String.valueOf(this.bid);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return e.f31300g;
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
        Long l10;
        String updateDateString = super.getUpdateDateString();
        return (!l.q(updateDateString) || (l10 = this.latestChapterUpdateTime) == null) ? updateDateString : o0.t(l10.longValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isFreeBook() {
        return true;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isPromoteBook() {
        return getPromote();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAllWords(Integer num) {
        this.allWords = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String str) {
        this.title = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookStatus(String str) {
        this.status = Integer.valueOf(Book.STATUS_UNFINISHED.equals(str) ? 30 : 50);
    }

    public void setBrtype(Integer num) {
        this.brtype = num;
    }

    public void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String str) {
        this.coverUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCpName(String str) {
        this.cpName = str;
    }

    public void setCreatedOn(Long l10) {
        this.createdOn = l10;
    }

    public void setFreeType(String str) {
        this.freeType = str;
    }

    public void setIntro(String str) {
        this.intro = str;
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

    public void setNewBook(Boolean bool) {
        this.newBook = bool;
    }

    public void setPromote(Boolean bool) {
        this.promote = bool;
    }

    public void setRank(Integer num) {
        this.rank = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String str) {
        this.intro = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String str) {
        try {
            this.bid = str;
        } catch (Exception unused) {
        }
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
