package cn.vlion.ad.inland.base.javabean;

import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VlionAdapterADConfig implements Serializable {
    private int accelerate;
    private String account;
    private int adSourceType;
    private int adType;
    private String ad_type;
    private String adxTagId;
    private Long agg;
    private int angle;
    private String appId;
    private int autoClose;
    private int autoJump;
    private int autoJumpSec;
    private int autoJumpTime;
    private int autoPlay;
    private float bidfloor;
    private int clickBackPercent;
    private String creativeType;
    private String crid;
    private String dspid;
    private int duration;
    private String interactiveType;
    private boolean isBid;
    private String platform;
    private int playMode;
    private String randerType;
    private int screenType;
    private int secondPop;
    private int secondPrice;
    private int shakeDuration;
    private String showId;
    private String showTrace;
    private String style;
    private String template;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean;
    private float tolerateTime;
    private String trace;
    private int videoVoice;
    private VlionADClickType vlionADClickType;
    private float width = 0.0f;
    private float height = 0.0f;
    private int imageScale = 4;
    private boolean hideSkip = false;
    private String slotID = "";
    private int skipSec = 0;
    private int closeSec = 0;
    private int retainWin = 1;
    private int autoJumpPercent = 100;
    private VlionBidderSource secondBrandName = VlionBidderSource.OtherReason;

    public int getAccelerate() {
        return this.accelerate;
    }

    public String getAccount() {
        return this.account;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAd_type() {
        return this.ad_type;
    }

    public String getAdxTagId() {
        return this.adxTagId;
    }

    public Long getAgg() {
        return this.agg;
    }

    public int getAngle() {
        return this.angle;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getAutoClose() {
        return this.autoClose;
    }

    public int getAutoJump() {
        return this.autoJump;
    }

    public int getAutoJumpPercent() {
        return this.autoJumpPercent;
    }

    public int getAutoJumpSec() {
        return this.autoJumpSec;
    }

    public int getAutoJumpTime() {
        return this.autoJumpTime;
    }

    public int getAutoPlay() {
        return this.autoPlay;
    }

    public float getBidfloor() {
        return this.bidfloor;
    }

    public int getClickBackPercent() {
        return this.clickBackPercent;
    }

    public int getCloseSec() {
        return this.closeSec;
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public String getCrid() {
        return this.crid;
    }

    public String getDspid() {
        return this.dspid;
    }

    public int getDuration() {
        return this.duration;
    }

    public float getHeight() {
        return this.height;
    }

    public int getImageScale() {
        return this.imageScale;
    }

    public String getInteractiveType() {
        return this.interactiveType;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getPlayMode() {
        return this.playMode;
    }

    public String getRanderType() {
        return this.randerType;
    }

    public int getRetainWin() {
        return this.retainWin;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public VlionBidderSource getSecondBrandName() {
        return this.secondBrandName;
    }

    public int getSecondPop() {
        return this.secondPop;
    }

    public int getSecondPrice() {
        return this.secondPrice;
    }

    public int getShakeDuration() {
        return this.shakeDuration;
    }

    public String getShowId() {
        return this.showId;
    }

    public String getShowTrace() {
        return this.showTrace;
    }

    public int getSkipSec() {
        return this.skipSec;
    }

    public String getSlotID() {
        return this.slotID;
    }

    public String getStyle() {
        return this.style;
    }

    public String getTemplate() {
        return this.template;
    }

    public List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> getTemplateConfigBean() {
        return this.templateConfigBean;
    }

    public float getTolerateTime() {
        return this.tolerateTime;
    }

    public String getTrace() {
        return this.trace;
    }

    public int getVideoVoice() {
        return this.videoVoice;
    }

    public VlionADClickType getVlionADClickType() {
        return this.vlionADClickType;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isBid() {
        return this.isBid;
    }

    public boolean isHideSkip() {
        return this.hideSkip;
    }

    public boolean isKdImage() {
        return this.adSourceType == 1;
    }

    public void setAccelerate(int i10) {
        this.accelerate = i10;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setAd_type(boolean z10) {
        this.ad_type = z10 ? "video" : "image";
    }

    public void setAgg(Long l10) {
        this.agg = l10;
    }

    public void setAngle(int i10) {
        this.angle = i10;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBid(boolean z10) {
        this.isBid = z10;
    }

    public void setBidfloor(float f10) {
        this.bidfloor = f10;
    }

    public void setClickBackPercent(int i10) {
        this.clickBackPercent = i10;
    }

    public void setCloseSec(int i10) {
        this.closeSec = i10;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setDspid(String str) {
        this.dspid = str;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setHeight(float f10) {
        this.height = f10;
    }

    public void setHideSkip(boolean z10) {
        this.hideSkip = z10;
    }

    public void setImageScale(int i10) {
        this.imageScale = i10;
    }

    public void setKdImage(int i10) {
        this.adSourceType = i10;
    }

    public void setPlacementBean(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        if (placementBean != null) {
            try {
                this.showId = placementBean.getShowId();
                this.skipSec = placementBean.getSkipSec();
                this.adxTagId = this.showId;
                this.templateConfigBean = placementBean.getTemplateConfig();
                this.autoPlay = placementBean.getAutoPlay();
                this.creativeType = placementBean.getCreativeType();
                this.interactiveType = placementBean.getInteractiveType();
                this.randerType = placementBean.getRanderType();
                this.screenType = placementBean.getScreenType();
                this.style = placementBean.getStyle();
                this.videoVoice = placementBean.getVideoVoice();
                this.playMode = placementBean.getPlayMode();
                this.retainWin = placementBean.getRetainWin();
                this.autoClose = placementBean.getAutoClose();
                this.autoJumpSec = placementBean.getAutoJumpSec();
                this.autoJump = placementBean.getAutoJump();
                this.autoJumpTime = placementBean.getAutoJumpTime();
                this.autoJumpPercent = placementBean.getAutoJumpPercent();
                this.clickBackPercent = placementBean.getClickBackPercent();
                this.secondPop = placementBean.getSecondPop();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSecondBrandName(VlionBidderSource vlionBidderSource) {
        this.secondBrandName = vlionBidderSource;
    }

    public void setSecondPop(int i10) {
        this.secondPop = i10;
    }

    public void setSecondPrice(int i10) {
        this.secondPrice = i10;
    }

    public void setShakeDuration(int i10) {
        this.shakeDuration = i10;
    }

    public void setShowTrace(String str) {
        this.showTrace = str;
    }

    public void setSlotID(String str) {
        this.slotID = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setTolerateTime(float f10) {
        this.tolerateTime = f10;
    }

    public void setTrace(String str) {
        this.trace = str;
    }

    public void setVlionADClickType(VlionADClickType vlionADClickType) {
        this.vlionADClickType = vlionADClickType;
    }

    public void setWidth(float f10) {
        this.width = f10;
    }
}
