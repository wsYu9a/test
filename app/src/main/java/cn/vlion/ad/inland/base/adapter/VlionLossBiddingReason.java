package cn.vlion.ad.inland.base.adapter;

import cn.vlion.ad.inland.base.l1;

/* loaded from: classes.dex */
public class VlionLossBiddingReason {
    private VlionBidderSource BrandName;
    private int biddingPrice;
    private VlionLossReason vlionLossReason;
    private String adUserName = "";
    private String adTitle = "";
    private String adRequestId = "";
    private int isShow = 1;
    private int isClick = 0;

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public String getAdTitle() {
        return this.adTitle;
    }

    public String getAdUserName() {
        return this.adUserName;
    }

    public int getBiddingPrice() {
        return this.biddingPrice;
    }

    public VlionBidderSource getBrandName() {
        return this.BrandName;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public VlionLossReason getVlionLossReason() {
        return this.vlionLossReason;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public void setAdTitle(String str) {
        this.adTitle = str;
    }

    public void setAdUserName(String str) {
        this.adUserName = str;
    }

    public void setBiddingPrice(int i10) {
        this.biddingPrice = i10;
    }

    public void setBrandName(VlionBidderSource vlionBidderSource) {
        this.BrandName = vlionBidderSource;
    }

    public void setIsClick(int i10) {
        this.isClick = i10;
    }

    public void setIsShow(int i10) {
        this.isShow = i10;
    }

    public void setVlionLossReason(VlionLossReason vlionLossReason) {
        this.vlionLossReason = vlionLossReason;
    }

    public String toString() {
        StringBuilder a10 = l1.a("VlionLossBiddingReason{biddingPrice=");
        a10.append(this.biddingPrice);
        a10.append(", BrandName=");
        a10.append(this.BrandName);
        a10.append(", vlionLossReason=");
        a10.append(this.vlionLossReason);
        a10.append(", adUserName='");
        a10.append(this.adUserName);
        a10.append('\'');
        a10.append(", adTitle='");
        a10.append(this.adTitle);
        a10.append('\'');
        a10.append(", adRequestId='");
        a10.append(this.adRequestId);
        a10.append('\'');
        a10.append(", isShow=");
        a10.append(this.isShow);
        a10.append(", isClick=");
        a10.append(this.isClick);
        a10.append('}');
        return a10.toString();
    }
}
