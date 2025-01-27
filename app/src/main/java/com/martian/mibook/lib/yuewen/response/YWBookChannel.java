package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.rpauth.MartianRPUserManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class YWBookChannel {
    private List<TYBookItem> bookList;
    private String bottomDeeplink;
    private Integer bottomType;
    private String bottomUrl;
    private String desc;
    private Boolean exposed;
    private Integer layoutType;
    private Long leftSeconds;
    private Integer mcid;
    private Integer pageIndex;
    private Integer rank;
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

        public void setBookList(List<TYBookItem> bookList) {
            this.bookList = bookList;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public List<TYBookItem> getBookList() {
        return this.bookList;
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
        Long l = this.leftSeconds;
        return Long.valueOf(l == null ? 0L : l.longValue());
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
            this.targetTime = Long.valueOf((getLeftSeconds().longValue() * 1000) + MartianRPUserManager.t());
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

    public void setBookList(List<TYBookItem> bookList) {
        this.bookList = bookList;
    }

    public void setBottomDeeplink(String bottomDeeplink) {
        this.bottomDeeplink = bottomDeeplink;
    }

    public void setBottomType(Integer bottomType) {
        this.bottomType = bottomType;
    }

    public void setBottomUrl(String bottomUrl) {
        this.bottomUrl = bottomUrl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExposed(Boolean exposed) {
        this.exposed = exposed;
    }

    public void setLayoutType(Integer layoutType) {
        this.layoutType = layoutType;
    }

    public void setLeftSeconds(Long leftSeconds) {
        this.leftSeconds = leftSeconds;
    }

    public YWBookChannel setMcid(Integer mcid) {
        this.mcid = mcid;
        return this;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setRecords(List<MiReadingRecord> records) {
        this.records = records;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setSubtabs(List<SubTab> subtabs) {
        this.subtabs = subtabs;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public YWBookChannel setTitle(String title) {
        this.title = title;
        return this;
    }

    public void setTopBgUrl(String topBgUrl) {
        this.topBgUrl = topBgUrl;
    }
}
