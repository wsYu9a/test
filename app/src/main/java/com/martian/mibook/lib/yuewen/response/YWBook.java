package com.martian.mibook.lib.yuewen.response;

import android.text.TextUtils;
import ba.f;
import ba.k;
import ba.l;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Date;
import java.util.List;
import l9.o0;
import vb.e;

@k.h(name = "ywbook")
/* loaded from: classes3.dex */
public class YWBook extends Book {

    @k.b
    private Integer allWords;
    private Long authorId;

    @k.b
    private String authorName;
    private Integer brtype;

    @k.b
    private Integer categoryId;

    @k.b
    private String categoryName;

    @k.g
    @k.b
    private Long cbid;

    @k.b
    private Integer chargeType;

    @k.b
    private String coverUrl;
    private Long createTime;
    private YWBookDiscount discountInfo;

    @k.b
    private Integer distType;

    @k.b
    private Integer freeType;
    private String intro;

    @k.b
    private String keyword;

    @k.b
    private String latestChapter;

    @k.b
    private String latestChapterId;

    @k.b
    private String latestChapterUpdateTime;
    private Boolean newBook;
    private Boolean promote;
    private Integer rank;

    @k.b
    private Integer status;

    @k.b
    private Integer subCategoryId;

    @k.b
    private String subCategoryName;
    private List<YWBookTag> tag;
    private List<String> tagList;

    @k.b
    private String title;

    @k.b
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
        return !l.q(this.categoryName) ? this.categoryName : this.subCategoryName;
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

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getChapterSize() {
        return null;
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
        return o0.L(this.latestChapterUpdateTime);
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

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return String.valueOf(this.cbid);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return e.f31299f;
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

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAllWords(Integer num) {
        this.allWords = num;
    }

    public void setAuthorId(Long l10) {
        this.authorId = l10;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setAuthorName(String str) {
        this.authorName = str;
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

    public void setCategoryId(int i10) {
        this.categoryId = Integer.valueOf(i10);
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCbid(long j10) {
        this.cbid = Long.valueOf(j10);
    }

    public void setChargeType(Integer num) {
        this.chargeType = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCover(String str) {
        this.coverUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreateTime(Long l10) {
        this.createTime = l10;
    }

    public void setDiscountInfo(YWBookDiscount yWBookDiscount) {
        this.discountInfo = yWBookDiscount;
    }

    public void setDistType(Integer num) {
        this.distType = num;
    }

    public void setFreeType(int i10) {
        this.freeType = Integer.valueOf(i10);
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

    public void setLatestChapterId(String str) {
        this.latestChapterId = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long l10) {
        if (l10 == null) {
            return;
        }
        try {
            this.latestChapterUpdateTime = f.i(l10.longValue(), "yyyy-MM-dd HH:mm:ss");
        } catch (Exception unused) {
        }
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
            this.cbid = Long.valueOf(Long.parseLong(str));
        } catch (Exception unused) {
        }
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setSubCategoryId(int i10) {
        this.subCategoryId = Integer.valueOf(i10);
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }

    public void setTag(List<YWBookTag> list) {
        this.tag = list;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalPrice(Integer num) {
        this.totalPrice = num;
    }

    public void setLatestChapterUpdateTime(String str) {
        this.latestChapterUpdateTime = str;
    }
}
