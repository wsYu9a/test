package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes3.dex */
public class YWBookMall {
    private List<YWBookBanner> bannerList;
    private List<YWBookChannel> channelList;
    private Boolean showHeaderIcon;

    public List<YWBookBanner> getBannerList() {
        return this.bannerList;
    }

    public List<YWBookChannel> getChannelList() {
        return this.channelList;
    }

    public boolean getShowHeaderIcon() {
        Boolean bool = this.showHeaderIcon;
        return bool != null && bool.booleanValue();
    }

    public void setBannerList(List<YWBookBanner> list) {
        this.bannerList = list;
    }

    public void setChannelList(List<YWBookChannel> list) {
        this.channelList = list;
    }

    public void setShowHeaderIcon(Boolean bool) {
        this.showHeaderIcon = bool;
    }
}
