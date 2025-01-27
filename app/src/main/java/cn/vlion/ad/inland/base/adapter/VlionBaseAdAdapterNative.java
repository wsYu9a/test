package cn.vlion.ad.inland.base.adapter;

import android.content.Context;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public abstract class VlionBaseAdAdapterNative {
    public int AutoPlay;
    public float bidFloorPrice;
    public Context context;
    public float heightPx;
    public int imageScale;
    public boolean isBid;
    public boolean isClosedVolume;
    public int is_circulation;
    public int price = -1;
    public VlionBidderSource secondBrandName;
    public int secondPrice;
    public String slotID;
    public VlionAdapterADConfig vlionAdapterADConfig;
    public VlionBiddingLoadListener vlionBiddingLoadListener;
    public VlionNativeActionListener vlionNativeActionListener;
    public float widthPx;

    public VlionBaseAdAdapterNative(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        this.slotID = "";
        this.imageScale = 4;
        this.isBid = false;
        this.bidFloorPrice = -1.0f;
        this.is_circulation = 0;
        this.secondPrice = 0;
        try {
            LogVlion.e("VlionBaseAdAdapterNative:");
            this.context = context;
            this.vlionBiddingLoadListener = vlionBiddingLoadListener;
            if (vlionAdapterADConfig != null) {
                try {
                    this.vlionAdapterADConfig = vlionAdapterADConfig;
                    this.slotID = vlionAdapterADConfig.getSlotID();
                    this.imageScale = vlionAdapterADConfig.getImageScale();
                    this.widthPx = vlionAdapterADConfig.getWidth();
                    this.heightPx = vlionAdapterADConfig.getHeight();
                    this.isBid = vlionAdapterADConfig.isBid();
                    this.bidFloorPrice = vlionAdapterADConfig.getBidfloor();
                    this.isClosedVolume = vlionAdapterADConfig.getVideoVoice() == 0;
                    this.secondPrice = vlionAdapterADConfig.getSecondPrice();
                    this.secondBrandName = vlionAdapterADConfig.getSecondBrandName();
                    this.AutoPlay = vlionAdapterADConfig.getAutoPlay();
                    List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean = vlionAdapterADConfig.getTemplateConfigBean();
                    if (templateConfigBean != null && templateConfigBean.size() > 0 && templateConfigBean.get(0) != null) {
                        this.is_circulation = VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean.get(0).getId()).getMain().getIs_circulation();
                    }
                    LogVlion.e("VlionBaseAdAdapterNative:getSlotID=" + this.slotID + " widthPx=" + this.widthPx + " heightPx=" + this.heightPx + " isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice + " isClosedVolume=" + this.isClosedVolume + " is_circulation=" + this.is_circulation);
                } catch (Exception e10) {
                    VlionSDkManager.getInstance().upLoadCatchException(e10);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public abstract void destroy();

    public abstract int getPrice();

    public abstract void loadAd();

    public void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        this.vlionNativeActionListener = vlionNativeActionListener;
    }
}
