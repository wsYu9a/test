package cn.vlion.ad.inland.ad.javabean;

import android.text.TextUtils;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VlionCustomParseAdData extends VlionCustomAdData {
    private VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean;
    private VlionCustomAdData.SeatbidBean.BidBean bidBean;
    private String brand_logo;
    private String brand_name;
    private String crid;
    private String des;
    private String dp;
    private String dspid;
    private int duration;
    private boolean isSingleBid;
    private boolean isVideo;
    private String mdp;
    private String slotID;
    private String title;
    private VlionCustomAdData.SeatbidBean.BidBean.VideoBean videoBean;
    private String wake_id;
    private String wake_path;
    private int wake_type;
    private int ctype = 1;
    private int bidPrice = 0;
    private int height = 0;
    private int width = 0;
    private String imageUrl = "";
    private List<String> imageBeanList = new ArrayList();
    private String videoUrl = "";
    private boolean is_download = false;

    public VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean getAppInfoBean() {
        return this.appInfoBean;
    }

    public VlionCustomAdData.SeatbidBean.BidBean getBidBean() {
        if (this.bidBean == null) {
            this.bidBean = new VlionCustomAdData.SeatbidBean.BidBean();
        }
        return this.bidBean;
    }

    public int getBidPrice() {
        return this.bidPrice;
    }

    public String getBrand_logo() {
        return this.brand_logo;
    }

    public String getBrand_name() {
        return this.brand_name;
    }

    public String getCrid() {
        return this.crid;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean getCsBean(int i10, int i11) {
        try {
            VlionCustomAdData.SeatbidBean.BidBean bidBean = this.bidBean;
            if (bidBean != null && bidBean.getMc() != null && this.bidBean.getMc().getCs() != null) {
                for (VlionCustomAdData.SeatbidBean.BidBean.McBean.CsFBean csFBean : this.bidBean.getMc().getCs()) {
                    if (csFBean.getS() == null || (csFBean.getS().getAtype() != i10 && csFBean.getS().getAtype() != i11)) {
                    }
                    return csFBean.getS();
                }
            }
            return null;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    public int getCtype() {
        return this.ctype;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean getDefaultShakeCsBean() {
        VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = new VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean();
        csBean.setAtype(2);
        csBean.setAcc(15);
        csBean.setAng(35);
        csBean.setDui(3.0f);
        return csBean;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean getDefaultSwipeLrCsBean() {
        VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = new VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean();
        csBean.setAtype(5);
        csBean.setW(50);
        return csBean;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean getDefaultSwipeRoundCsBean() {
        VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = new VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean();
        csBean.setAtype(4);
        csBean.setW(50);
        csBean.setH(50);
        return csBean;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean getDefaultSwipeUpCsBean() {
        VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = new VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean();
        csBean.setAtype(3);
        csBean.setW(50);
        csBean.setH(90);
        return csBean;
    }

    public String getDes() {
        return this.des;
    }

    public String getDp() {
        return this.dp;
    }

    public String getDspid() {
        return this.dspid;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getImageBeanList() {
        return this.imageBeanList;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> getMacroValues() {
        try {
            VlionCustomAdData.SeatbidBean.BidBean bidBean = this.bidBean;
            if (bidBean == null || bidBean.getMc() == null) {
                return null;
            }
            return this.bidBean.getMc().getMacroValues();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    public String getMdp() {
        return this.mdp;
    }

    public String getSlotID() {
        return this.slotID;
    }

    public String getTitle() {
        return this.title;
    }

    public VlionCustomAdData.SeatbidBean.BidBean.VideoBean getVideoBean() {
        if (this.videoBean == null) {
            this.videoBean = new VlionCustomAdData.SeatbidBean.BidBean.VideoBean();
        }
        return this.videoBean;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getWake_id() {
        return this.wake_id;
    }

    public String getWake_path() {
        return this.wake_path;
    }

    public int getWake_type() {
        return this.wake_type;
    }

    public int getWidth() {
        return this.width;
    }

    public String getmDefaultVal() {
        try {
            VlionCustomAdData.SeatbidBean.BidBean bidBean = this.bidBean;
            return (bidBean == null || bidBean.getMc() == null) ? "" : this.bidBean.getMc().getmDefaultVal();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public boolean isIs_download() {
        return this.is_download;
    }

    public boolean isSingleBid() {
        return this.isSingleBid;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public VlionCustomParseAdData parseBid() {
        VlionCustomAdData.SeatbidBean seatbidBean;
        List<List<VlionCustomAdData.SeatbidBean.BidBean>> bid;
        List<VlionCustomAdData.SeatbidBean.BidBean> list;
        VlionCustomAdData.SeatbidBean.BidBean bidBean;
        VlionCustomAdData.SeatbidBean.BidBean.ImageBean imageBean;
        try {
            List<VlionCustomAdData.SeatbidBean> seatbid = getSeatbid();
            if (seatbid != null && seatbid.size() > 0 && (seatbidBean = seatbid.get(0)) != null && (bid = seatbidBean.getBid()) != null && bid.size() > 0 && (list = bid.get(0)) != null && list.size() > 0 && (bidBean = list.get(0)) != null) {
                this.bidBean = bidBean;
                this.crid = bidBean.getCrid();
                this.is_download = bidBean.getIs_download() == 1;
                this.bidPrice = bidBean.getPrice();
                this.brand_logo = bidBean.getBrand_logo();
                this.brand_name = bidBean.getBrand_name();
                this.title = bidBean.getTitle();
                this.des = bidBean.getDesc();
                this.dp = bidBean.getDeeplink();
                this.mdp = bidBean.getMarketurl();
                this.dspid = bidBean.getDspid();
                this.wake_id = bidBean.getWake_id();
                this.wake_path = bidBean.getWake_path();
                this.wake_type = bidBean.getWake_type();
                List<VlionCustomAdData.SeatbidBean.BidBean.ImageBean> image = bidBean.getImage();
                VlionCustomAdData.SeatbidBean.BidBean.VideoBean video = bidBean.getVideo();
                VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean app_info = bidBean.getApp_info();
                if (video != null && video.getVurl() != null) {
                    this.isVideo = true;
                    this.videoBean = video;
                    this.ctype = 3;
                    this.width = video.getVw();
                    this.height = this.videoBean.getVh();
                    this.videoUrl = this.videoBean.getVurl();
                    this.duration = this.videoBean.getDuration();
                    if (image != null && image.size() > 0 && (imageBean = image.get(0)) != null && !TextUtils.isEmpty(imageBean.getUrl())) {
                        this.imageUrl = imageBean.getUrl();
                    }
                }
                if (image != null && image.size() > 0) {
                    if (this.imageBeanList == null) {
                        this.imageBeanList = new ArrayList();
                    }
                    for (int i10 = 0; i10 < image.size(); i10++) {
                        VlionCustomAdData.SeatbidBean.BidBean.ImageBean imageBean2 = image.get(i10);
                        if (imageBean2 != null && !TextUtils.isEmpty(imageBean2.getUrl())) {
                            this.imageBeanList.add(imageBean2.getUrl());
                        }
                    }
                    VlionCustomAdData.SeatbidBean.BidBean.ImageBean imageBean3 = image.get(0);
                    if (imageBean3 != null && !TextUtils.isEmpty(imageBean3.getUrl())) {
                        if (!this.isVideo) {
                            this.ctype = 2;
                        }
                        this.width = imageBean3.getWidth();
                        this.height = imageBean3.getHeight();
                        this.imageUrl = imageBean3.getUrl();
                    }
                }
                if (app_info != null) {
                    this.appInfoBean = app_info;
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
        this.ctype = 2;
    }

    public void setMdp(String str) {
        this.mdp = str;
    }

    public void setSingleBid(boolean z10) {
        this.isSingleBid = z10;
    }

    public void setSlotID(String str) {
        this.slotID = str;
    }
}
