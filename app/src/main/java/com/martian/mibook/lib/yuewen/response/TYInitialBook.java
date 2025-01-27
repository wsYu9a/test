package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;

/* loaded from: classes4.dex */
public class TYInitialBook extends TYBookItem {
    private Integer ctype;
    private String latestChapter;
    private Long latestChapterUpdateTime;
    private String reason;
    private String subTitle;

    public int getCtype() {
        Integer num = this.ctype;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getLatestChapter() {
        return this.latestChapter;
    }

    public Long getLatestChapterUpdateTime() {
        return this.latestChapterUpdateTime;
    }

    public String getReason() {
        return this.reason;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setLatestChapter(String latestChapter) {
        this.latestChapter = latestChapter;
    }

    @Override // com.martian.mibook.lib.model.data.TYBookItem, com.martian.mibook.lib.model.data.abs.Book
    public void setLatestChapterUpdateTime(Long latestChapterUpdateTime) {
        this.latestChapterUpdateTime = latestChapterUpdateTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
