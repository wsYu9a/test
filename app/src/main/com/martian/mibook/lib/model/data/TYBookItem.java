package com.martian.mibook.lib.model.data;

import ba.f;
import ba.l;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vb.e;

/* loaded from: classes3.dex */
public class TYBookItem extends Book {
    private Integer allWords;
    private String authorName;
    private String bid;
    private List<String> boostKeywordList;
    private Integer brtype;
    private String categoryName;
    private Integer chapterIndex;
    private Integer chapterSize;
    private Integer clickCount;
    private String context;
    private String coverUrl;
    private String cpName;
    private BookCreative creative;
    private String deeplink;
    private Integer duration;
    private Integer ecpm;
    private boolean exposed = false;
    private Boolean goReading;
    private String intro;
    private boolean isInBookStore;
    private String lastChapter;
    private Long latestChapterUpdateTime;
    private Long modifiedOn;
    private Integer nComments;
    private Integer price;
    private Boolean promote;
    private String promoteKeyword;
    private Integer rank;
    private String rankDesc;
    private Integer readingCount;
    private String recTitle;
    private String recommend;
    private String recommendId;
    private List<String> roleList;
    private Integer score;
    private String sourceId;
    private String sourceName;
    private Integer status;
    private String subCategoryName;
    private String tag;
    private List<String> tagList;
    private String title;
    private String url;

    public static String getNumbers(int i10) {
        if (i10 < 10000) {
            return i10 + "";
        }
        return (i10 / 10000) + "万";
    }

    public void convertYwBookItem(Book book) {
        if (book == null) {
            return;
        }
        setSourceName(book.getSourceName());
        setSourceId(book.getSourceId());
        setAuthorName(book.getAuthor());
        setBookName(book.getBookName());
        setCover(book.getCover());
        setIntro(book.getShortIntro());
        setStatus(book.getStatus());
        setAllWords(book.getAllWords());
        setRank(Integer.valueOf(book.getRank()));
        setCategoryName(book.getCategory());
        setBrtype(Integer.valueOf(book.getBrType()));
        if (book.getLastUpdated() != null) {
            setLatestChapterUpdateTime(Long.valueOf(book.getLastUpdated().getTime()));
        }
    }

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
    public String getBookInfo() {
        String authorName = !l.q(getAuthorName()) ? getAuthorName() : "";
        if (!l.q(getSubCategoryName())) {
            if (!l.q(authorName)) {
                authorName = authorName + " · ";
            }
            authorName = authorName + getSubCategoryName();
        } else if (!l.q(getCategoryName())) {
            if (!l.q(authorName)) {
                authorName = authorName + " · ";
            }
            authorName = authorName + getCategoryName();
        }
        if (getAllWords().intValue() <= 0) {
            return authorName;
        }
        if (!l.q(authorName)) {
            authorName = authorName + " · ";
        }
        return authorName + getNumbers(getAllWords().intValue()) + "字";
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getBookName() {
        return this.title;
    }

    public List<String> getBoostKeywordList() {
        return this.boostKeywordList;
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

    public String getCategoryInfo() {
        return !l.q(this.categoryName) ? this.categoryName : !l.q(this.subCategoryName) ? this.subCategoryName : !l.q(this.authorName) ? this.authorName : "";
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Integer getChapterSize() {
        return this.chapterSize;
    }

    public Integer getClickCount() {
        return this.clickCount;
    }

    public String getContext() {
        return this.context;
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

    public BookCreative getCreative() {
        return this.creative;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public int getEcpm() {
        Integer num = this.ecpm;
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    public boolean getGoReading() {
        Boolean bool = this.goReading;
        return bool != null && bool.booleanValue();
    }

    public Integer getIntegerStatus() {
        return this.status;
    }

    public String getIntro() {
        return this.intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getLastChapter() {
        return this.lastChapter;
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

    public Long getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public Long getModifiedOn() {
        return this.modifiedOn;
    }

    public int getPrice() {
        Integer num = this.price;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public boolean getPromote() {
        Boolean bool = this.promote;
        return bool != null && bool.booleanValue();
    }

    public String getPromoteKeyword() {
        return this.promoteKeyword;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public int getRank() {
        Integer num = this.rank;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public String getRankDesc() {
        return this.rankDesc;
    }

    public Integer getReadingCount() {
        return this.readingCount;
    }

    public String getRecDesc() {
        return !l.q(this.recTitle) ? this.recTitle : getBookInfo();
    }

    public String getRecTitle() {
        return this.recTitle;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public List<String> getRoleList() {
        if (this.roleList == null) {
            this.roleList = new ArrayList();
        }
        return this.roleList;
    }

    public int getScore() {
        Integer num = this.score;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getShortIntro() {
        return this.intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, wb.f
    public String getSourceName() {
        return this.sourceName;
    }

    public String getSourceOrBid() {
        return l.q(this.bid) ? this.sourceId : this.bid;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getSourceUrl() {
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public String getStatus() {
        Integer num = this.status;
        return num == null ? "" : num.intValue() == 50 ? Book.STATUS_FINISHED : Book.STATUS_UNFINISHED;
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTagInfo() {
        String categoryName = !l.q(getCategoryName()) ? getCategoryName() : "";
        List<String> list = this.tagList;
        if (list != null && !list.isEmpty()) {
            if (!l.q(categoryName)) {
                categoryName = categoryName + " · ";
            }
            categoryName = categoryName + this.tagList.get(0);
        }
        if (!l.q(getStatus())) {
            if (!l.q(categoryName)) {
                categoryName = categoryName + " · ";
            }
            categoryName = categoryName + getStatus();
        }
        if (getAllWords().intValue() <= 0) {
            return categoryName;
        }
        if (!l.q(categoryName)) {
            categoryName = categoryName + " · ";
        }
        return categoryName + getNumbers(getAllWords().intValue()) + "字";
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public Integer getnComments() {
        return this.nComments;
    }

    public boolean isComic() {
        return "comics".equalsIgnoreCase(this.sourceName);
    }

    public boolean isExposed() {
        return this.exposed;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public boolean isFreeBook() {
        return !e.f31299f.equalsIgnoreCase(this.sourceName);
    }

    public boolean isInBookStore() {
        return this.isInBookStore;
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

    public void setBoostKeywordList(List<String> list) {
        this.boostKeywordList = list;
    }

    public void setBrtype(Integer num) {
        this.brtype = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setChapterIndex(Integer num) {
        this.chapterIndex = num;
    }

    public void setChapterSize(Integer num) {
        this.chapterSize = num;
    }

    public void setClickCount(Integer num) {
        this.clickCount = num;
    }

    public void setContext(String str) {
        this.context = str;
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

    public void setCreative(BookCreative bookCreative) {
        this.creative = bookCreative;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setEcpm(Integer num) {
        this.ecpm = num;
    }

    public void setExposed(boolean z10) {
        this.exposed = z10;
    }

    public void setGoReading(Boolean bool) {
        this.goReading = bool;
    }

    public void setInBookStore(boolean z10) {
        this.isInBookStore = z10;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String str) {
        this.lastChapter = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long l10) {
        this.latestChapterUpdateTime = l10;
    }

    public void setModifiedOn(Long l10) {
        this.modifiedOn = l10;
    }

    public void setPrice(Integer num) {
        this.price = num;
    }

    public void setPromote(Boolean bool) {
        this.promote = bool;
    }

    public void setPromoteKeyword(String str) {
        this.promoteKeyword = str;
    }

    public void setRank(Integer num) {
        this.rank = num;
    }

    public void setRankDesc(String str) {
        this.rankDesc = str;
    }

    public void setReadingCount(Integer num) {
        this.readingCount = num;
    }

    public void setRecTitle(String str) {
        this.recTitle = str;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public void setRecommendId(String str) {
        this.recommendId = str;
    }

    public void setRoleList(List<String> list) {
        this.roleList = list;
    }

    public void setScore(Integer num) {
        this.score = num;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String str) {
        this.intro = str;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public void setStatus(String str) {
        if (l.q(str)) {
            this.status = 0;
        } else if (Book.STATUS_FINISHED.equalsIgnoreCase(str)) {
            this.status = 50;
        } else {
            this.status = 30;
        }
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setnComments(Integer num) {
        this.nComments = num;
    }
}
