package com.martian.mibook.lib.model.data;

import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class TYBookItem extends Book {
    private Integer allWords;
    private String authorName;
    private String bid;
    private Integer brtype;
    private String categoryName;
    private Integer chapterIndex;
    private Integer clickCount;
    private String context;
    private String coverUrl;
    private String cpName;
    private BookCreative creative;
    private String deeplink;
    private Integer ecpm;
    private boolean exposed = false;
    private Boolean goReading;
    private String intro;
    private Long modifiedOn;
    private Integer nComments;
    private Integer price;
    private Boolean promote;
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
    private Boolean startWithCover;
    private Integer status;
    private String subCategoryName;
    private String tag;
    private List<String> tagList;
    private String title;
    private String url;

    public static String getNumbers(int numbers) {
        if (numbers < 10000) {
            return numbers + "";
        }
        return (numbers / 10000) + "万";
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
        return !k.p(this.recTitle) ? this.recTitle : getRecDesc();
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
        return this.subCategoryName;
    }

    public String getCategoryInfo() {
        return !k.p(this.categoryName) ? this.categoryName : !k.p(this.subCategoryName) ? this.subCategoryName : !k.p(this.authorName) ? this.authorName : "";
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getChapterIndex() {
        return this.chapterIndex;
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
        return null;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public Date getLastUpdated() {
        return null;
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
        String authorName = !k.p(getAuthorName()) ? getAuthorName() : "";
        if (!k.p(getSubCategoryName())) {
            if (!k.p(authorName)) {
                authorName = authorName + " · ";
            }
            authorName = authorName + getSubCategoryName();
        } else if (!k.p(getCategoryName())) {
            if (!k.p(authorName)) {
                authorName = authorName + " · ";
            }
            authorName = authorName + getCategoryName();
        }
        if (getAllWords().intValue() <= 0) {
            return authorName;
        }
        if (!k.p(authorName)) {
            authorName = authorName + " · ";
        }
        return authorName + getNumbers(getAllWords().intValue()) + "字";
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

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceId() {
        return this.sourceId;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book, com.martian.mibook.lib.model.c.g
    public String getSourceName() {
        return this.sourceName;
    }

    public String getSourceOrBid() {
        return k.p(this.bid) ? this.sourceId : this.bid;
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
        String categoryName = !k.p(getCategoryName()) ? getCategoryName() : "";
        List<String> list = this.tagList;
        if (list != null && !list.isEmpty()) {
            if (!k.p(categoryName)) {
                categoryName = categoryName + " · ";
            }
            categoryName = categoryName + this.tagList.get(0);
        }
        if (!k.p(getStatus())) {
            if (!k.p(categoryName)) {
                categoryName = categoryName + " · ";
            }
            categoryName = categoryName + getStatus();
        }
        if (getAllWords().intValue() <= 0) {
            return categoryName;
        }
        if (!k.p(categoryName)) {
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
        return !d.k.equalsIgnoreCase(this.sourceName);
    }

    public boolean isStartWithCover() {
        Boolean bool = this.startWithCover;
        return bool != null && bool.booleanValue();
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

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public void setContext(String context) {
        this.context = context;
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

    public void setCreative(BookCreative creative) {
        this.creative = creative;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public void setEcpm(Integer ecpm) {
        this.ecpm = ecpm;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public void setGoReading(Boolean goReading) {
        this.goReading = goReading;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLastChapter(String lastChapter) {
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPromote(Boolean promote) {
        this.promote = promote;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setRankDesc(String rankDesc) {
        this.rankDesc = rankDesc;
    }

    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }

    public void setRecTitle(String recTitle) {
        this.recTitle = recTitle;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setShortIntro(String intro) {
        this.intro = intro;
    }

    @Override // com.martian.mibook.lib.model.data.abs.Book
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void setStartWithCover(boolean startWithCover) {
        this.startWithCover = Boolean.valueOf(startWithCover);
    }

    public void setStatus(String status) {
        if (k.p(status)) {
            this.status = 0;
        } else if (Book.STATUS_FINISHED.equalsIgnoreCase(status)) {
            this.status = 50;
        } else {
            this.status = 30;
        }
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setnComments(Integer nComments) {
        this.nComments = nComments;
    }
}
