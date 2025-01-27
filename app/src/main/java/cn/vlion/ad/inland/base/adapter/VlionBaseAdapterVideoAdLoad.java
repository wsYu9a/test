package cn.vlion.ad.inland.base.adapter;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public abstract class VlionBaseAdapterVideoAdLoad {
    public float bidFloorPrice;
    public Context context;
    public float heightPx;
    public boolean isBid;
    public boolean isClosedVolume;
    public VlionBidderSource secondBrandName;
    public int secondPrice;
    public String slotID;
    private TemError temError;
    public VlionAdapterADConfig vlionAdapterADConfig;
    public VlionBiddingActionRewardListener vlionBiddingActionRewardListener;
    public VlionBiddingLoadListener vlionBidindRewardVideoListener;
    public float widthPx;
    private volatile boolean isWinPrice = false;
    private volatile boolean isAdLoaded = false;
    public int price = -1;

    public VlionBaseAdapterVideoAdLoad(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.slotID = "";
        this.isBid = false;
        this.bidFloorPrice = -1.0f;
        this.secondPrice = 0;
        try {
            this.vlionBidindRewardVideoListener = vlionBiddingLoadListener;
            this.context = context;
            LogVlion.e("VlionBaseAdapterVideoAdLoad:");
            if (vlionAdapterADConfig != null) {
                this.vlionAdapterADConfig = vlionAdapterADConfig;
                this.slotID = vlionAdapterADConfig.getSlotID();
                this.widthPx = vlionAdapterADConfig.getWidth();
                this.heightPx = vlionAdapterADConfig.getHeight();
                this.isBid = vlionAdapterADConfig.isBid();
                this.bidFloorPrice = vlionAdapterADConfig.getBidfloor();
                this.isClosedVolume = vlionAdapterADConfig.getVideoVoice() == 0;
                this.secondPrice = vlionAdapterADConfig.getSecondPrice();
                this.secondBrandName = vlionAdapterADConfig.getSecondBrandName();
                LogVlion.e("VlionBaseAdapterVideoAdLoad:getSlotID=" + this.slotID + " widthPx=" + this.widthPx + " heightPx=" + this.heightPx + " isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice + " isClosedVolume=" + this.isClosedVolume);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public abstract void destroy();

    public int getAdStatusErrorCode() {
        TemError temError = this.temError;
        if (temError == null) {
            return -1;
        }
        return temError.getCode();
    }

    public String getAdStatusErrorMessage() {
        TemError temError = this.temError;
        return temError == null ? "" : temError.getError();
    }

    public abstract int getPrice();

    public boolean isAdRenderFailureCallback(int i10, String str) {
        this.isAdLoaded = true;
        if (this.isWinPrice) {
            return true;
        }
        this.temError = new TemError(i10, str);
        return false;
    }

    public boolean isAdRenderSuccessCallback() {
        this.isAdLoaded = true;
        return this.isWinPrice;
    }

    public boolean isHaveLoadStatus() {
        return this.isAdLoaded;
    }

    public boolean isLoadStatusError() {
        return this.temError != null;
    }

    public boolean isWinPrice() {
        return this.isWinPrice;
    }

    public void loadRewardVideoAd() {
        resetLoadStatus();
    }

    public abstract void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason);

    public void renderRewardVideoAD() {
        setWinPrice();
    }

    public void resetLoadStatus() {
        this.isWinPrice = false;
        this.isAdLoaded = false;
        this.temError = null;
    }

    public void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        this.vlionBiddingActionRewardListener = vlionBiddingActionRewardListener;
    }

    public void setWinPrice() {
        this.isWinPrice = true;
    }

    public abstract void showRewardVideoAd(Activity activity);
}
