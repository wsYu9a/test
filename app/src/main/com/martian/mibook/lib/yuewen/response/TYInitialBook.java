package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;

/* loaded from: classes3.dex */
public class TYInitialBook extends TYBookItem {
    private Integer ctype;
    private String latestChapter;
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

    public String getReason() {
        return this.reason;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setLatestChapter(String str) {
        this.latestChapter = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }
}
