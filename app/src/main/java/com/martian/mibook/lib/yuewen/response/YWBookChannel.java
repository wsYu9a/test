package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.rpauth.MartianRPUserManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWBookChannel {
    private TYBookItem bookItem;
    private List<TYBookItem> bookList;
    private BookWrapper bookWrapper;
    private String bottomDeeplink;
    private Integer bottomType;
    private String bottomUrl;
    private String desc;
    private Boolean exposed;
    private boolean isLastBookItem;
    private Integer layoutType;
    private Long leftSeconds;
    private Integer mcid;
    private Integer pageIndex;
    private Integer rank;
    private MiReadingRecord readingRecord;
    private Book readingRecordBook;
    private int recommendType;
    private List<MiReadingRecord> records;
    private Integer size;
    private List<SubTab> subtabs;
    private Long targetTime = null;
    private Integer tid;
    private String title;
    private String topBgUrl;

    public static class SubTab {
        private List<TYBookItem> bookList;
        private List<String> categories;
        private Boolean exposed = Boolean.FALSE;
        private String ext;
        private String title;

        public List<TYBookItem> getBookList() {
            if (this.bookList == null) {
                this.bookList = new ArrayList();
            }
            return this.bookList;
        }

        public List<String> getCategories() {
            if (this.categories == null) {
                this.categories = new ArrayList();
            }
            return this.categories;
        }

        public String getExt() {
            return this.ext;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isExposed() {
            Boolean bool = this.exposed;
            return bool != null && bool.booleanValue();
        }

        public void setBookList(List<TYBookItem> list) {
            this.bookList = list;
        }

        public void setCategories(List<String> list) {
            this.categories = list;
        }

        public void setExposed(Boolean bool) {
            this.exposed = bool;
        }

        public void setExt(String str) {
            this.ext = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public TYBookItem getBookItem() {
        return this.bookItem;
    }

    public List<TYBookItem> getBookList() {
        if (this.bookList == null) {
            this.bookList = new ArrayList();
        }
        return this.bookList;
    }

    public BookWrapper getBookWrapper() {
        return this.bookWrapper;
    }

    public String getBottomDeeplink() {
        return this.bottomDeeplink;
    }

    public int getBottomType() {
        Integer num = this.bottomType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getBottomUrl() {
        return this.bottomUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getLayoutType() {
        Integer num = this.layoutType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Long getLeftSeconds() {
        Long l10 = this.leftSeconds;
        return Long.valueOf(l10 == null ? 0L : l10.longValue());
    }

    public Integer getMcid() {
        return this.mcid;
    }

    public Integer getPageIndex() {
        Integer num = this.pageIndex;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    public Integer getRank() {
        return this.rank;
    }

    public MiReadingRecord getReadingRecord() {
        return this.readingRecord;
    }

    public Book getReadingRecordBook() {
        return this.readingRecordBook;
    }

    public int getRecommendType() {
        return this.recommendType;
    }

    public List<MiReadingRecord> getRecords() {
        return this.records;
    }

    public Integer getSize() {
        Integer num = this.size;
        return Integer.valueOf(num == null ? 5 : num.intValue());
    }

    public List<SubTab> getSubtabs() {
        return this.subtabs;
    }

    public long getTargetTime() {
        if (this.targetTime == null) {
            this.targetTime = Long.valueOf((getLeftSeconds().longValue() * 1000) + MartianRPUserManager.a());
        }
        return this.targetTime.longValue();
    }

    public Integer getTid() {
        return this.tid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopBgUrl() {
        return this.topBgUrl;
    }

    public boolean isExposed() {
        Boolean bool = this.exposed;
        return bool != null && bool.booleanValue();
    }

    public boolean isLastBookItem() {
        return this.isLastBookItem;
    }

    public void setBookItem(TYBookItem tYBookItem) {
        this.bookItem = tYBookItem;
    }

    public void setBookList(List<TYBookItem> list) {
        this.bookList = list;
    }

    public void setBookWrapper(BookWrapper bookWrapper) {
        this.bookWrapper = bookWrapper;
    }

    public void setBottomDeeplink(String str) {
        this.bottomDeeplink = str;
    }

    public void setBottomType(Integer num) {
        this.bottomType = num;
    }

    public void setBottomUrl(String str) {
        this.bottomUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExposed(Boolean bool) {
        this.exposed = bool;
    }

    public void setLastBookItem(boolean z10) {
        this.isLastBookItem = z10;
    }

    public void setLayoutType(Integer num) {
        this.layoutType = num;
    }

    public void setLeftSeconds(Long l10) {
        this.leftSeconds = l10;
    }

    public YWBookChannel setMcid(Integer num) {
        this.mcid = num;
        return this;
    }

    public void setPageIndex(Integer num) {
        this.pageIndex = num;
    }

    public void setRank(Integer num) {
        this.rank = num;
    }

    public void setReadingRecord(MiReadingRecord miReadingRecord) {
        this.readingRecord = miReadingRecord;
    }

    public void setReadingRecordBook(Book book) {
        this.readingRecordBook = book;
    }

    public void setRecommendType(int i10) {
        this.recommendType = i10;
    }

    public void setRecords(List<MiReadingRecord> list) {
        this.records = list;
    }

    public void setSize(Integer num) {
        this.size = num;
    }

    public void setSubtabs(List<SubTab> list) {
        this.subtabs = list;
    }

    public void setTid(Integer num) {
        this.tid = num;
    }

    public YWBookChannel setTitle(String str) {
        this.title = str;
        return this;
    }

    public void setTopBgUrl(String str) {
        this.topBgUrl = str;
    }
}
