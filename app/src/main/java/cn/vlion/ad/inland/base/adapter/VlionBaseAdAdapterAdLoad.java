package cn.vlion.ad.inland.base.adapter;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterAdLoad {
    public int AutoPlay;
    public float bidFloorPrice;
    public Context context;
    public float heightPx;
    public boolean isBid;
    public boolean isClosedVolume;
    public boolean isHideSkip;
    public VlionBidderSource secondBrandName;
    public int secondPrice;
    public String slotID;
    public TemError temError;
    public VlionAdapterADConfig vlionAdapterADConfig;
    public VlionBiddingActionListener vlionBiddingActionListener;
    public VlionBiddingLoadListener vlionBiddingLoadListener;
    public VlionNativesAdVideoListener vlionNativesAdVideoListener;
    public float widthPx;
    private volatile boolean isWinPrice = false;
    private volatile boolean isAdLoaded = false;
    public int price = -1;

    public VlionBaseAdAdapterAdLoad(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.slotID = "";
        this.isBid = false;
        this.bidFloorPrice = -1.0f;
        this.isHideSkip = false;
        this.secondPrice = 0;
        this.secondBrandName = VlionBidderSource.OtherReason;
        try {
            LogVlion.e("VlionBaseAdAdapterAdLoad:");
            this.vlionBiddingLoadListener = vlionBiddingLoadListener;
            this.context = context;
            if (vlionAdapterADConfig != null) {
                this.vlionAdapterADConfig = vlionAdapterADConfig;
                this.slotID = vlionAdapterADConfig.getSlotID();
                this.widthPx = vlionAdapterADConfig.getWidth();
                this.heightPx = vlionAdapterADConfig.getHeight();
                this.isBid = vlionAdapterADConfig.isBid();
                this.bidFloorPrice = vlionAdapterADConfig.getBidfloor();
                this.isHideSkip = vlionAdapterADConfig.isHideSkip();
                this.isClosedVolume = vlionAdapterADConfig.getVideoVoice() == 0;
                this.secondPrice = vlionAdapterADConfig.getSecondPrice();
                this.secondBrandName = vlionAdapterADConfig.getSecondBrandName();
                this.AutoPlay = vlionAdapterADConfig.getAutoPlay();
                LogVlion.e("VlionBaseAdAdapterAdLoad:getSlotID=" + this.slotID + " widthPx=" + this.widthPx + " heightPx=" + this.heightPx + " isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

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

    public void loadAd() {
        resetLoadStatus();
    }

    public void renderAD() {
        setWinPrice();
    }

    public void resetLoadStatus() {
        this.isWinPrice = false;
        this.isAdLoaded = false;
        this.temError = null;
    }

    public void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        this.vlionBiddingActionListener = vlionBiddingActionListener;
    }

    public void setVlionNativesAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.vlionNativesAdVideoListener = vlionNativesAdVideoListener;
    }

    public void setWinPrice() {
        this.isWinPrice = true;
    }
}
