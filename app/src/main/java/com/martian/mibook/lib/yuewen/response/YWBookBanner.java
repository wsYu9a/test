package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.TYBookItem;

/* loaded from: classes3.dex */
public class YWBookBanner extends TYBookItem {
    private String bannerUrl;
    private String link;

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getLink() {
        return this.link;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setLink(String str) {
        this.link = str;
    }
}
