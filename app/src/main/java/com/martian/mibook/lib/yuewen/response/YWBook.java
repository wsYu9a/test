package com.martian.mibook.lib.yuewen.response;

import android.text.TextUtils;
import b.d.b.f;
import com.martian.libmars.utils.p0;
import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.d;
import java.util.Date;
import java.util.List;

@j.g(name = "ywbook")
/* loaded from: classes4.dex */
public class YWBook extends Book {

    @j.b
    private Integer allWords;
    private Long authorId;

    @j.b
    private String authorName;
    private Integer brtype;

    @j.b
    private Integer categoryId;

    @j.b
    private String categoryName;

    @j.b
    @j.f
    private Long cbid;

    @j.b
    private Integer chargeType;

    @j.b
    private String coverUrl;
    private Long createTime;
    private YWBookDiscount discountInfo;

    @j.b
    private Integer distType;

    @j.b
    private Integer freeType;
    private String intro;

    @j.b
    private String keyword;

    @j.b
    private String latestChapter;

    @j.b
    private String latestChapterId;

    @j.b
    private String latestChapterUpdateTime;
    private Boolean newBook;
    private Boolean promote;
    private Integer rank;

    @j.b
    private Integer status;

    @j.b
    private Integer subCategoryId;

    @j.b
    private String subCategoryName;
    private List<YWBookTag> tag;
    private List<String> tagList;

    @j.b
    private String title;

    @j.b
    private Integer totalPrice;

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getAllWords() {
        Integer num = this.allWords;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getAuthor() {
        return this.authorName;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
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

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCategory() {
        return !k.p(this.categoryName) ? this.categoryName : this.subCategoryName;
    }

    public int getCategoryId() {
        return this.categoryId.intValue();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public long getCbid() {
        return this.cbid.longValue();
    }

    public Integer getChargeType() {
        return this.chargeType;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getCover() {
        return this.coverUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Integer getDistType() {
        Integer num = this.distType;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getFreeType() {
        Integer num = this.freeType;
        if (num == null) {
            return 1;
        }
        return num.intValue();
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
        if (TextUtils.isEmpty(this.latestChapterUpdateTime)) {
            return null;
        }
        return p0.H(this.latestChapterUpdateTime);
    }

    public String getLatestChapter() {
        return this.latestChapter;
    }

    public String getLatestChapterId() {
        return this.latestChapterId;
    }

    public String getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public Boolean getNewBook() {
        Boolean bool = this.newBook;
        return Boolean.valueOf(bool != null && bool.booleanValue());
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
        return TextUtils.isEmpty(this.intro) ? "" : this.intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return String.valueOf(this.cbid);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return d.k;
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

    public int getSubCategoryId() {
        return this.subCategoryId.intValue();
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public List<YWBookTag> getTag() {
        return this.tag;
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getTotalPrice() {
        Integer num = this.totalPrice;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getUpdateDateString() {
        String updateDateString = super.getUpdateDateString();
        return TextUtils.isEmpty(updateDateString) ? this.latestChapterUpdateTime : updateDateString;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isFreeBook() {
        return getDistType().intValue() == 1;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isPromoteBook() {
        return getPromote();
    }

    public void setAllWords(Integer allWords) {
        this.allWords = allWords;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setBookName(String bookName) {
        this.title = bookName;
    }

    public void setBrtype(Integer brtype) {
        this.brtype = brtype;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = Integer.valueOf(categoryId);
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCbid(long cbid) {
        this.cbid = Long.valueOf(cbid);
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String cover) {
        this.coverUrl = cover;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setDiscountInfo(YWBookDiscount discountInfo) {
        this.discountInfo = discountInfo;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    public void setFreeType(int freeType) {
        this.freeType = Integer.valueOf(freeType);
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

    public void setLatestChapterId(String latestChapterId) {
        this.latestChapterId = latestChapterId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        if (latestChapterUpdateTime == null) {
            return;
        }
        try {
            this.latestChapterUpdateTime = com.martian.libsupport.d.i(latestChapterUpdateTime.longValue(), f.f4408b);
        } catch (Exception unused) {
        }
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
            this.cbid = Long.valueOf(Long.parseLong(sourceId));
        } catch (Exception unused) {
        }
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = Integer.valueOf(subCategoryId);
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setTag(List<YWBookTag> tag) {
        this.tag = tag;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setLatestChapterUpdateTime(String latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }
}
