package com.martian.mibook.lib.yuewen.response;

import java.util.List;

/* loaded from: classes4.dex */
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

    public void setBannerList(List<YWBookBanner> bannerList) {
        this.bannerList = bannerList;
    }

    public void setChannelList(List<YWBookChannel> channelList) {
        this.channelList = channelList;
    }

    public void setShowHeaderIcon(Boolean showHeaderIcon) {
        this.showHeaderIcon = showHeaderIcon;
    }
}
