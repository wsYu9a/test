package com.martian.apptask.data;

import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.R;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class AppTask {
    public static final int ALWAYS_INSTALLED = 3;
    public static final int ALWAYS_UNINSTALLED = 2;
    public static final int HIDE = 0;
    public static final int VISIBILE = 1;
    private String adTag;
    public String appPromote;
    public String appSizeInMB;
    public String appType;
    public String author;
    public String baseUrl;
    private int bidding;
    private boolean coverView;
    public transient ViewWrapper customView;
    public String desc;
    public List<String> displayImageUrls;
    public List<String> downloadImageUrls;
    public String downloadPattern;
    public String downloadUrl;
    public String dplink;
    private int ecpm;
    public int exposeTimes;
    public String filename;
    public String gdtappid;
    public String gdtposid;
    private int group;
    public String homepageUrl;
    public String iconUrl;
    public String id;
    private Integer interactionType;
    public String marketUrl;
    public int nDownloads;
    public String name;
    public transient Object origin;
    public String packageName;
    private int picHeight;
    private int picWidth;
    public String posterUrl;
    private boolean shakeStyle;
    public String shareContent;
    public String shareImageUrl;
    public String shareLink;
    public String shareText;
    public String shareTitle;
    public String shortDesc;
    public String smapikey;
    public String smappid;
    public String smlid;
    public String splashImageUrl;
    public int taskCoins;
    public String taskDesc;
    public String title;
    public Video video;
    public transient ViewWrapper videoView;
    public String buttonText = h.F().n("查看详情");
    public String gid = "";
    public boolean isInstalled = false;
    public int visibility = 1;
    public long activateSeconds = 300;
    public boolean downloadDirectly = true;
    public boolean downloadHint = false;
    public boolean shareHint = false;
    public String gender = "N";
    public Integer weight = 1;
    public String priority = "";
    public String source = "";
    public String aliasUnion = "";
    public String adsPosition = "";
    public String adsType = "";
    public boolean reportBefore = false;
    public boolean dplinkLoaded = false;
    public boolean isVideoAd = false;
    public boolean exposed = false;
    public boolean rendered = false;
    public long createdOn = System.currentTimeMillis();
    public List<String> clickReportUrls = new ArrayList();
    public List<String> exposeReportUrls = new ArrayList();
    public List<String> downloadStartedReportUrls = new ArrayList();
    public List<String> downloadFinishedReportUrls = new ArrayList();
    public List<String> installStartedReportUrls = new ArrayList();
    public List<String> installFinishedReportUrls = new ArrayList();
    public List<String> openAppReportUrls = new ArrayList();
    public List<String> openDplinkReportUrls = new ArrayList();
    private boolean adCompliance = false;
    private final List<String> posterUrls = new ArrayList();

    public void addPosterUrl(String imageUrl) {
        this.posterUrls.add(imageUrl);
    }

    public int adsIconRes() {
        if ("toutiao".equalsIgnoreCase(this.appType) || AdConfig.UnionType.CSJ.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_csj;
        }
        if ("bae".equalsIgnoreCase(this.appType) || AdConfig.UnionType.BQT.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_bae;
        }
        if ("gdt".equalsIgnoreCase(this.appType) || AdConfig.UnionType.GDT.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_gdt;
        }
        if (!"dx".equalsIgnoreCase(this.appType) && !AdConfig.UnionType.DX.equalsIgnoreCase(this.source)) {
            return ("mi".equalsIgnoreCase(this.appType) || AdConfig.UnionType.MI.equalsIgnoreCase(this.source)) ? R.drawable.icon_ads_mi : ("hw".equalsIgnoreCase(this.appType) || AdConfig.UnionType.HW.equalsIgnoreCase(this.source)) ? R.drawable.icon_ads_hw : ("ks".equalsIgnoreCase(this.appType) || "KS".equalsIgnoreCase(this.source)) ? R.drawable.icon_ads_ks : ("vivo".equalsIgnoreCase(this.appType) || "VIVO".equalsIgnoreCase(this.source)) ? R.drawable.icon_ads_vivo : ("oppo".equalsIgnoreCase(this.appType) || "OPPO".equalsIgnoreCase(this.source)) ? R.drawable.icon_ads_oppo : R.drawable.icon_ads_api;
        }
        if (!k.p(this.aliasUnion)) {
            if (AdConfig.UnionType.CSJ.equalsIgnoreCase(this.aliasUnion)) {
                return R.drawable.icon_ads_csj_dx;
            }
            if (AdConfig.UnionType.GDT.equalsIgnoreCase(this.aliasUnion)) {
                return R.drawable.icon_ads_gdt_dx;
            }
            if ("KS".equalsIgnoreCase(this.aliasUnion)) {
                return R.drawable.icon_ads_ks_dx;
            }
        }
        return R.drawable.icon_ads_dx;
    }

    public boolean canReExpose() {
        return !this.rendered && this.exposeTimes <= 0 && this.ecpm >= 100;
    }

    public void destroyNativeAd() {
        ViewWrapper viewWrapper = this.customView;
        if (viewWrapper != null) {
            viewWrapper.destroy();
            this.customView = null;
        }
        ViewWrapper viewWrapper2 = this.videoView;
        if (viewWrapper2 != null) {
            viewWrapper2.destroy();
            this.videoView = null;
        }
        Object obj = this.origin;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("destroy", new Class[0]).invoke(this.origin, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            this.origin = null;
        }
    }

    public void destroySplashAd() {
        Object obj = this.origin;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("destroyAd", new Class[0]).invoke(this.origin, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            this.origin = null;
        }
    }

    public String getAdTag() {
        return this.adTag;
    }

    public int getBidding() {
        return this.bidding;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getDesc() {
        return (k.p(this.title) || k.p(this.desc)) ? !k.p(this.desc) ? this.desc : !k.p(this.shortDesc) ? this.shortDesc : !k.p(this.title) ? this.title : "精彩大礼放送，不容错过" : this.title.length() > this.desc.length() ? this.title : this.desc;
    }

    public String getDisplayTitleDesc(String sep) {
        String str = this.title;
        if (str == null) {
            String str2 = this.desc;
            return str2 == null ? "" : str2;
        }
        if (str.equals(this.desc) || TextUtils.isEmpty(this.desc)) {
            return str;
        }
        return str + sep + this.desc;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public String getGid() {
        return this.gid;
    }

    public int getGroup() {
        return this.group;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public Integer getInteractionType() {
        return this.interactionType;
    }

    public String getName() {
        return k.p(this.name) ? "" : this.name;
    }

    public String getNumbers(int numbers) {
        if (numbers <= 10000) {
            return numbers + "";
        }
        int i2 = numbers / 10000;
        return i2 + "." + ((numbers - (i2 * 10000)) / 1000) + "万";
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public String getPosterUrl() {
        return !this.posterUrls.isEmpty() ? this.posterUrls.get(0) : !k.p(this.posterUrl) ? this.posterUrl : !k.p(this.iconUrl) ? this.iconUrl : "";
    }

    public List<String> getPosterUrls() {
        return this.posterUrls;
    }

    public String getRandomDownloadImageUrl() {
        return this.downloadImageUrls.get(new Random().nextInt(this.downloadImageUrls.size()));
    }

    public String getTitle() {
        return (k.p(this.title) || k.p(this.desc)) ? !k.p(this.title) ? this.title : !k.p(this.desc) ? this.desc : !k.p(this.shortDesc) ? this.shortDesc : "精彩推荐" : this.title.length() > this.desc.length() ? this.desc : this.title;
    }

    public void increaseExposeTimes() {
        this.exposeTimes++;
    }

    public boolean isAdCompliance() {
        return this.adCompliance;
    }

    public boolean isAlwaysShowing() {
        int i2 = this.visibility;
        return i2 == 2 || i2 == 3;
    }

    public boolean isAlwaysShowingWhenInstalled() {
        return this.visibility == 3;
    }

    public boolean isBidding() {
        int i2 = this.bidding;
        return i2 == 1 || i2 == 3;
    }

    public boolean isCoverView() {
        return this.coverView;
    }

    public boolean isDownloadImageUrlsValid() {
        List<String> list = this.downloadImageUrls;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isDownloadUrlValid() {
        return !TextUtils.isEmpty(this.downloadUrl);
    }

    public boolean isFemale() {
        return "F".equals(this.gender);
    }

    public boolean isHided() {
        return this.visibility == 0 || this.weight.intValue() == 0;
    }

    public boolean isHorizontalAd() {
        int i2;
        int i3 = this.picWidth;
        return i3 > 0 && (i2 = this.picHeight) > 0 && i3 >= i2;
    }

    public boolean isHorizontalPicAd() {
        return isHorizontalAd() && this.picWidth / this.picHeight > 5;
    }

    public boolean isMale() {
        return "M".equals(this.gender);
    }

    public boolean isPortraitAd() {
        int i2;
        int i3 = this.picWidth;
        return i3 > 0 && (i2 = this.picHeight) > 0 && i2 > i3;
    }

    public boolean isReadingVideoAd() {
        return this.isVideoAd && this.videoView != null && k.p(getPosterUrl());
    }

    public boolean isRechargeAd() {
        return (!k.p(this.title) && this.title.contains("话费") && this.title.contains("00")) || (!k.p(this.desc) && this.desc.contains("话费") && this.desc.contains("00"));
    }

    public boolean isShakeStyle() {
        return this.shakeStyle;
    }

    public boolean isUnknownGender() {
        return "N".equals(this.gender);
    }

    public void setAdCompliance(boolean adCompliance) {
        this.adCompliance = adCompliance;
    }

    public void setAdTag(String adTag) {
        this.adTag = adTag;
    }

    public void setBidding(int bidding) {
        this.bidding = bidding;
    }

    public void setCoverView(boolean coverView) {
        this.coverView = coverView;
    }

    public void setEcpm(int ecpm) {
        this.ecpm = ecpm;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setInteractionType(int interactionType) {
        this.interactionType = Integer.valueOf(interactionType);
    }

    public void setIsInstalled(boolean isInstalled) {
        this.isInstalled = isInstalled;
    }

    public void setPicHeight(int picHeight) {
        this.picHeight = picHeight;
    }

    public void setPicWidth(int picWidth) {
        this.picWidth = picWidth;
    }

    public void setShakeStyle(boolean shakeStyle) {
        this.shakeStyle = shakeStyle;
    }
}
