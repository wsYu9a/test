package com.martian.apptask.data;

import android.text.TextUtils;
import ba.l;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.R;
import com.martian.libmars.common.ConfigSingleton;
import hf.e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p1.b;

/* loaded from: classes3.dex */
public class AppTask {
    private String adTag;
    public String appPromote;
    public transient Object backupOrigin;
    private int bidding;
    private ComplianceInfo complianceInfo;
    private boolean coverView;
    private boolean csjExpress;
    private String cur;
    public transient ViewWrapper customView;
    public String desc;
    public String downloadUrl;
    public String dplink;
    private int ecpm;
    public String filename;
    private int group;
    public String homepageUrl;
    public String iconUrl;

    /* renamed from: id */
    public String f12000id;
    private boolean isDynamicUnion;
    private String lUrl;
    public String linkType;
    private int loseEcpm;
    private Boolean loseIsBidding;
    private String loseSource;
    public String marketUrl;
    private int minEcpm;
    public int nDownloads;
    private String nUrl;
    public String name;
    public transient Object origin;
    private int originalEcpm;
    public String packageName;
    private int picHeight;
    private int picWidth;
    public String posterUrl;
    private int shakeMinEcpm;
    private boolean shakeStyle;
    public String shortDesc;
    public int taskCoins;
    public String title;
    public Video video;
    public transient ViewWrapper videoView;
    private boolean withMisClick;
    public String buttonText = ConfigSingleton.D().s("查看详情");
    public String gid = "";
    public boolean isInstalled = false;
    public int visibility = 1;
    public long activateSeconds = 300;
    public boolean downloadDirectly = true;
    public boolean downloadHint = false;
    public String gender = "N";
    public String source = "";
    public String aliasUnion = "";
    public String pid = "";
    public String adsType = "";
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
    private final List<String> posterUrls = new ArrayList();

    public void addPosterUrl(String str) {
        this.posterUrls.add(str);
    }

    public int adsIconRes() {
        if (AdConfig.UnionType.CSJ.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_csj;
        }
        if (AdConfig.UnionType.BQT.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_bae;
        }
        if (AdConfig.UnionType.GDT.equalsIgnoreCase(this.source)) {
            return R.drawable.icon_ads_gdt;
        }
        if (!AdConfig.UnionType.DX.equalsIgnoreCase(this.source)) {
            return AdConfig.UnionType.MENTA.equalsIgnoreCase(this.source) ? R.drawable.icon_ads_menta : AdConfig.UnionType.SIGMOB.equalsIgnoreCase(this.source) ? R.drawable.icon_ads_sigmob : AdConfig.UnionType.MI.equalsIgnoreCase(this.source) ? R.drawable.icon_ads_mi : AdConfig.UnionType.HW.equalsIgnoreCase(this.source) ? R.drawable.icon_ads_hw : "KS".equalsIgnoreCase(this.source) ? R.drawable.icon_ads_ks : AdConfig.UnionType.VIVO.equalsIgnoreCase(this.source) ? R.drawable.icon_ads_vivo : "OPPO".equalsIgnoreCase(this.source) ? R.drawable.icon_ads_oppo : R.drawable.icon_ads_api;
        }
        if (!l.q(this.aliasUnion)) {
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
                obj.getClass().getDeclaredMethod("destroy", null).invoke(this.origin, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
            this.origin = null;
        }
    }

    public String getAdNameInfo() {
        String str = this.source + e.f26694a;
        if (this.complianceInfo != null) {
            return str + this.complianceInfo.getAppName();
        }
        if (TextUtils.isEmpty(this.packageName)) {
            return str + getTitle();
        }
        return str + this.packageName;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public String getAliasUnion() {
        return this.aliasUnion;
    }

    public int getBidding() {
        return this.bidding;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public ComplianceInfo getComplianceInfo() {
        return this.complianceInfo;
    }

    public String getCur() {
        return this.cur;
    }

    public String getDesc() {
        return (l.q(this.title) || l.q(this.desc)) ? !l.q(this.desc) ? this.desc : !l.q(this.shortDesc) ? this.shortDesc : !l.q(this.title) ? this.title : "精彩大礼放送，不容错过" : this.title.length() > this.desc.length() ? this.title : this.desc;
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

    public int getLoseEcpm() {
        int originalEcpm = (int) (getOriginalEcpm() * 0.8d);
        int i10 = this.loseEcpm;
        return i10 > originalEcpm ? i10 : (int) (getOriginalEcpm() * 0.95d);
    }

    public boolean getLoseIsBidding() {
        Boolean bool = this.loseIsBidding;
        return bool == null || bool.booleanValue();
    }

    public String getLoseSource() {
        return this.loseSource;
    }

    public int getMinEcpm() {
        return this.minEcpm;
    }

    public String getName() {
        return l.q(this.name) ? "" : this.name;
    }

    public String getNumbers(int i10) {
        if (i10 <= 10000) {
            return i10 + "";
        }
        int i11 = i10 / 10000;
        return i11 + b.f29697h + ((i10 - (i11 * 10000)) / 1000) + "万";
    }

    public int getOriginalEcpm() {
        int i10 = this.originalEcpm;
        return i10 > 0 ? i10 : getEcpm();
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public double getPicRatio() {
        int i10;
        int i11 = this.picWidth;
        if (i11 <= 0 || (i10 = this.picHeight) <= 0) {
            return 0.5625d;
        }
        return i10 / i11;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public String getPosterUrl() {
        return !this.posterUrls.isEmpty() ? this.posterUrls.get(0) : !l.q(this.posterUrl) ? this.posterUrl : !l.q(this.iconUrl) ? this.iconUrl : "";
    }

    public List<String> getPosterUrls() {
        return this.posterUrls;
    }

    public int getShakeMinEcpm() {
        return this.shakeMinEcpm;
    }

    public String getTitle() {
        return (l.q(this.title) || l.q(this.desc)) ? !l.q(this.title) ? this.title : !l.q(this.desc) ? this.desc : !l.q(this.shortDesc) ? this.shortDesc : "精彩推荐" : this.title.length() > this.desc.length() ? this.desc : this.title;
    }

    public String getlUrl() {
        return this.lUrl;
    }

    public String getnUrl() {
        return this.nUrl;
    }

    public boolean isBidding() {
        int i10 = this.bidding;
        return i10 == 1 || i10 == 3;
    }

    public boolean isCoverView() {
        return this.coverView;
    }

    public boolean isCsjExpress() {
        return this.csjExpress;
    }

    public boolean isDynamicUnion() {
        return this.isDynamicUnion;
    }

    public boolean isHorizontalPicAd() {
        int i10;
        int i11 = this.picWidth;
        return i11 > 0 && (i10 = this.picHeight) > 0 && i11 / i10 > 5;
    }

    public boolean isPortraitAd() {
        int i10;
        int i11 = this.picWidth;
        return i11 > 0 && (i10 = this.picHeight) > 0 && i10 > i11;
    }

    public boolean isReadingVideoAd() {
        return this.isVideoAd && this.videoView != null && l.q(getPosterUrl());
    }

    public boolean isRechargeAd() {
        return (!l.q(this.title) && this.title.contains("话费") && this.title.contains(com.sigmob.sdk.archives.tar.e.S)) || (!l.q(this.desc) && this.desc.contains("话费") && this.desc.contains(com.sigmob.sdk.archives.tar.e.S));
    }

    public boolean isShakeStyle() {
        return this.shakeStyle && this.ecpm > getShakeMinEcpm();
    }

    public boolean isWithMisClick() {
        return this.withMisClick;
    }

    public void setAdTag(String str) {
        this.adTag = str;
    }

    public void setBidding(int i10) {
        this.bidding = i10;
    }

    public void setComplianceInfo(ComplianceInfo complianceInfo) {
        this.complianceInfo = complianceInfo;
    }

    public void setCoverView(boolean z10) {
        this.coverView = z10;
    }

    public void setCsjExpress(boolean z10) {
        this.csjExpress = z10;
    }

    public void setCur(String str) {
        this.cur = str;
    }

    public void setDynamicUnion(boolean z10) {
        this.isDynamicUnion = z10;
    }

    public void setEcpm(int i10) {
        this.ecpm = i10;
    }

    public void setGroup(int i10) {
        this.group = i10;
    }

    public void setLoseEcpm(int i10) {
        this.loseEcpm = i10;
    }

    public void setLoseIsBidding(boolean z10) {
        this.loseIsBidding = Boolean.valueOf(z10);
    }

    public void setLoseSource(String str) {
        this.loseSource = str;
    }

    public void setMinEcpm(int i10) {
        this.minEcpm = i10;
    }

    public void setOriginalEcpm(int i10) {
        this.originalEcpm = i10;
    }

    public void setPicHeight(int i10) {
        this.picHeight = i10;
    }

    public void setPicWidth(int i10) {
        this.picWidth = i10;
    }

    public void setShakeMinEcpm(int i10) {
        this.shakeMinEcpm = i10;
    }

    public void setShakeStyle(boolean z10) {
        this.shakeStyle = z10;
    }

    public void setWithMisClick(boolean z10) {
        this.withMisClick = z10;
    }

    public void setlUrl(String str) {
        this.lUrl = str;
    }

    public void setnUrl(String str) {
        this.nUrl = str;
    }
}
