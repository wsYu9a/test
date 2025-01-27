package com.martian.ads.ad;

import androidx.annotation.NonNull;
import b8.j;
import ba.l;
import com.martian.ads.data.AdSlot;
import com.martian.apptask.data.AppTask;
import l5.c;

/* loaded from: classes3.dex */
public class AdConfig {
    public static final int ERROR_CODE_AD_BLOCK = 808;
    public static final int ERROR_CODE_CSJ_LIMIT = 20001;
    public static final int ERROR_CODE_GDT_LIMIT = 109502;
    public static final int ERROR_CODE_TIMEOUT = -100;
    public static final String ERROR_REASON_CSJ_LIMIT = "112";
    private AdInfo adInfo;
    private String adNameInfo;
    private String adTag;
    private String adsId;
    private String aliasUnion;
    private String appid;
    private long availableTime;
    private j baeArticleInfo;
    private int bidding;
    private Integer coolDuration;
    private boolean coolPlatForm;
    private Integer coolThreshold;
    private boolean dynamicUnion;
    private int ecpm;
    private Double ecpmPercent;
    private int failTimes;
    private int group;
    private int height;
    private boolean isExpress;
    private int minEcpm;
    private String pid;
    private String primeRit;
    private int shakeMinEcpm;
    private boolean shakeStyle;
    private String source;
    private String type;
    private int weight;
    private int width;
    private boolean withMisClick;
    private String gid = "";
    private boolean adCompliance = false;
    private int adLoadSeq = 1;

    public static class AdInfo {
        private int ecpm;
        private String source;

        public int getEcpm() {
            return this.ecpm;
        }

        public String getSource() {
            return this.source;
        }

        public void setEcpm(int i10) {
            this.ecpm = i10;
        }

        public void setSource(String str) {
            this.source = str;
        }
    }

    public interface AdType {
        public static final String BANNER = "banner";
        public static final String BANNER_TT = "banner_tt";
        public static final String DRAW = "draw";
        public static final String EXPRESS = "express";
        public static final String FULL_VIDEO = "full_video";
        public static final String INTERSTITIAL = "interstitial";
        public static final String NATIVE = "native";
        public static final String REWARD_VIDEO = "reward_video";
        public static final String SPLASH = "splash";
        public static final String STREAM = "stream";
    }

    public interface Type {
        public static final String CLICK = "CLICK";
        public static final String DOWNLOAD = "DOWNLOAD";
        public static final String ESHOW = "ESHOW";
        public static final String FAIL = "FAIL";
        public static final String FILTER = "FILTER";
        public static final String INSTALL = "INSTALL";
        public static final String MCLICK = "MCLICK";
        public static final String MSHOW = "MSHOW";
        public static final String REQUEST = "REQUEST";
        public static final String RESPONSE = "RESPONSE";
        public static final String SHOW = "SHOW";
        public static final String TIMEOUT = "TIMEOUT";
    }

    public interface UnionType {
        public static final String API = "API";
        public static final String BOOK = "BOOK";
        public static final String BQT = "BQT";
        public static final String CSJ = "CSJ";
        public static final String DEFAULT = "DEFAULT";
        public static final String DX = "DX";
        public static final String GAME = "GAME";
        public static final String GDT = "GDT";
        public static final String HW = "HW";
        public static final String KS = "KS";
        public static final String MENTA = "MENTA";
        public static final String MI = "MI";
        public static final String OPPO = "OPPO";
        public static final String SIGMOB = "SIGMOB";
        public static final String VIVO = "VIVO";
    }

    public static AdConfig buildAdConfig(@NonNull AdSlot adSlot) {
        AdConfig adConfig = new AdConfig();
        adConfig.setType(adSlot.getType());
        adConfig.setSource(adSlot.getUnion());
        adConfig.setBidding(adSlot.getBidding());
        adConfig.setAdsId(adSlot.getSid());
        adConfig.setWeight(adSlot.getWeight());
        adConfig.setEcpm(adSlot.getEcpm());
        adConfig.setAliasUnion(adSlot.getAliasUnion());
        adConfig.setAppid(adSlot.getAppid());
        return adConfig;
    }

    public static AdConfig toAdConfig(AppTask appTask) {
        if (appTask == null) {
            return null;
        }
        return buildAdConfig(new AdSlot().setType(appTask.adsType).setUnion(appTask.source).setSid(appTask.f12000id).setWeight(1).setEcpm(Integer.valueOf(appTask.getEcpm()))).setGid(appTask.getGid()).setBidding(appTask.getBidding()).setAdTag(appTask.getAdTag()).setPid(appTask.pid).setGroup(appTask.getGroup()).setAliasUnion(appTask.getAliasUnion()).setDynamicUnion(appTask.isDynamicUnion()).setWithMisClick(appTask.isWithMisClick()).setAdNameInfo(appTask.getAdNameInfo());
    }

    public AdInfo getAdInfo() {
        return this.adInfo;
    }

    public int getAdLoadSeq() {
        return this.adLoadSeq;
    }

    public String getAdNameInfo() {
        return this.adNameInfo;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public int getAdsCount() {
        return 1;
    }

    public String getAdsId() {
        return this.adsId;
    }

    public String getAliasUnion() {
        return this.aliasUnion;
    }

    public String getApiUrl() {
        return "";
    }

    public String getAppid() {
        return this.appid;
    }

    public long getAvailableTime() {
        return this.availableTime;
    }

    public j getBaeArticleInfo() {
        return this.baeArticleInfo;
    }

    public int getBidding() {
        return this.bidding;
    }

    public int getCoolDuration() {
        Integer num = this.coolDuration;
        if (num == null) {
            return 600000;
        }
        return num.intValue() * 1000;
    }

    public int getCoolThreshold() {
        Integer num = this.coolThreshold;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public double getEcpmPercent() {
        Double d10 = this.ecpmPercent;
        return d10 == null ? c.f27899e : d10.doubleValue();
    }

    public int getEventEcpm(String str) {
        if (isBidding() && (Type.SHOW.equalsIgnoreCase(str) || Type.MSHOW.equalsIgnoreCase(str) || Type.CLICK.equalsIgnoreCase(str) || Type.MCLICK.equalsIgnoreCase(str))) {
            return this.ecpm;
        }
        return 0;
    }

    public int getFailTimes() {
        return this.failTimes;
    }

    public String getGid() {
        return this.gid;
    }

    public int getGroup() {
        return this.group;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMinEcpm() {
        return this.minEcpm;
    }

    public String getPid() {
        return this.pid;
    }

    public double getPrice() {
        return this.ecpm / 100.0d;
    }

    public String getPrimeRit() {
        return this.primeRit;
    }

    public String getRealSource() {
        return !l.q(this.aliasUnion) ? this.aliasUnion : this.source;
    }

    public int getShakeMinEcpm() {
        return this.shakeMinEcpm;
    }

    public String getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public void increaseFailTimes() {
        if (!isCoolPlatForm() || getCoolThreshold() <= 0) {
            return;
        }
        int i10 = this.failTimes + 1;
        this.failTimes = i10;
        if (i10 >= getCoolThreshold()) {
            this.failTimes = 0;
            this.availableTime = System.currentTimeMillis() + getCoolDuration();
        }
    }

    public boolean isAdCompliance() {
        return this.adCompliance;
    }

    public boolean isBidding() {
        int i10 = this.bidding;
        return i10 == 1 || i10 == 3;
    }

    public boolean isBqtAd() {
        return UnionType.BQT.equalsIgnoreCase(this.source);
    }

    public boolean isCoolPlatForm() {
        return this.coolPlatForm;
    }

    public boolean isCsjAd() {
        return UnionType.CSJ.equalsIgnoreCase(this.source);
    }

    public boolean isDxAd() {
        return UnionType.DX.equalsIgnoreCase(this.source);
    }

    public boolean isDynamicUnion() {
        return this.dynamicUnion;
    }

    public boolean isExpress() {
        return this.isExpress;
    }

    public boolean isGdtAd() {
        return UnionType.GDT.equalsIgnoreCase(this.source);
    }

    public boolean isHwAd() {
        return UnionType.HW.equalsIgnoreCase(this.source);
    }

    public boolean isKsAd() {
        return "KS".equalsIgnoreCase(this.source);
    }

    public boolean isMentaAd() {
        return UnionType.MENTA.equalsIgnoreCase(this.source);
    }

    public boolean isNativeAd() {
        return AdType.NATIVE.equalsIgnoreCase(this.type) || "draw".equalsIgnoreCase(this.type) || AdType.STREAM.equalsIgnoreCase(this.type);
    }

    public boolean isShakeStyle() {
        return this.shakeStyle;
    }

    public boolean isWithMisClick() {
        return this.withMisClick;
    }

    public boolean pauseAdRequest() {
        return this.availableTime > System.currentTimeMillis();
    }

    public void setAdCompliance(boolean z10) {
        this.adCompliance = z10;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public void setAdLoadSeq(int i10) {
        this.adLoadSeq = i10;
    }

    public AdConfig setAdNameInfo(String str) {
        this.adNameInfo = str;
        return this;
    }

    public AdConfig setAdTag(String str) {
        this.adTag = str;
        return this;
    }

    public void setAdsId(String str) {
        this.adsId = str;
    }

    public AdConfig setAliasUnion(String str) {
        this.aliasUnion = str;
        return this;
    }

    public AdConfig setAppid(String str) {
        this.appid = str;
        return this;
    }

    public void setAvailableTime(long j10) {
        this.availableTime = j10;
    }

    public AdConfig setBaeArticleInfo(j jVar) {
        this.baeArticleInfo = jVar;
        return this;
    }

    public AdConfig setBidding(int i10) {
        this.bidding = i10;
        return this;
    }

    public void setCoolDuration(Integer num) {
        this.coolDuration = num;
    }

    public void setCoolPlatForm(boolean z10) {
        this.coolPlatForm = z10;
    }

    public void setCoolThreshold(Integer num) {
        this.coolThreshold = num;
    }

    public AdConfig setDynamicUnion(boolean z10) {
        this.dynamicUnion = z10;
        return this;
    }

    public AdConfig setEcpm(int i10) {
        this.ecpm = i10;
        return this;
    }

    public void setEcpmPercent(double d10) {
        this.ecpmPercent = Double.valueOf(d10);
    }

    public AdConfig setExpress(boolean z10) {
        this.isExpress = z10;
        return this;
    }

    public void setFailTimes(int i10) {
        this.failTimes = i10;
    }

    public AdConfig setGid(String str) {
        this.gid = str;
        return this;
    }

    public AdConfig setGroup(int i10) {
        this.group = i10;
        return this;
    }

    public AdConfig setHeight(int i10) {
        this.height = i10;
        return this;
    }

    public void setMinEcpm(int i10) {
        this.minEcpm = i10;
    }

    public AdConfig setPid(String str) {
        this.pid = str;
        return this;
    }

    public void setPrimeRit(String str) {
        this.primeRit = str;
    }

    public AdConfig setShakeMinEcpm(int i10) {
        this.shakeMinEcpm = i10;
        return this;
    }

    public AdConfig setShakeStyle(boolean z10) {
        this.shakeStyle = z10;
        return this;
    }

    public AdConfig setSource(String str) {
        this.source = str;
        return this;
    }

    public AdConfig setType(String str) {
        this.type = str;
        return this;
    }

    public void setWeight(int i10) {
        this.weight = i10;
    }

    public AdConfig setWidth(int i10) {
        this.width = i10;
        return this;
    }

    public AdConfig setWithMisClick(boolean z10) {
        this.withMisClick = z10;
        return this;
    }

    public AppTask toAppTask() {
        AppTask appTask = new AppTask();
        appTask.f12000id = getAdsId();
        appTask.source = getSource();
        appTask.pid = getPid();
        appTask.adsType = getType();
        appTask.gid = getGid();
        appTask.setBidding(getBidding());
        appTask.setEcpm(getEcpm());
        appTask.setGroup(getGroup());
        appTask.setShakeStyle(isShakeStyle());
        appTask.setShakeMinEcpm(getShakeMinEcpm());
        appTask.setAdTag(getAdTag());
        appTask.setMinEcpm(getMinEcpm());
        appTask.setDynamicUnion(isDynamicUnion());
        appTask.setCsjExpress(isExpress());
        appTask.setWithMisClick(isWithMisClick());
        return appTask;
    }

    public static AdConfig buildAdConfig(String str, String str2, String str3, int i10, int i11) {
        AdConfig adConfig = new AdConfig();
        adConfig.setType(str);
        adConfig.setSource(str2);
        adConfig.setAdsId(str3);
        adConfig.setWeight(i10);
        adConfig.setEcpm(i11);
        return adConfig;
    }
}
