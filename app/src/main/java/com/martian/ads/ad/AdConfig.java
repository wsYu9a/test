package com.martian.ads.ad;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.martian.ads.data.AdSlot;
import com.martian.apptask.data.AppTask;
import com.martian.libsupport.k;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes2.dex */
public class AdConfig {
    public static final int ERROR_CODE_AD_BLOCK = 808;
    private AdInfo adInfo;
    private TTAdLoadType adLoadType;
    private String adTag;
    private String adsId;
    private String adsPosition;
    private String aliasUnion;
    private String apiUrl;
    private String appid;
    private b.d.a.a baeArticleInfo;
    private int bidding;
    private int ecpm;
    private Double ecpmPercent;
    private boolean fullAdOnly;
    private int group;
    private int height;
    private boolean isWifiEnv;
    private String primeRit;
    private int reward;
    private String rewardExtra;
    private String rewardName;
    private boolean shakeStyle;
    private long showTime;
    private String source;
    private Object tag;
    private String type;
    private String uid;
    private int weight;
    private int width;
    private String wxAppid;
    private int adsCount = 1;
    private boolean chapterEndAd = false;
    private boolean chapterMiddleAd = false;
    private int adLoadSeq = 1;
    private String gid = "";
    private boolean adCompliance = false;
    private boolean needNativeCompliance = false;

    public interface Action {
        public static final String CLICK = "CLICK";
        public static final String ESHOW = "ESHOW";
        public static final String FAIL = "FAIL";
        public static final String REQUEST = "REQUEST";
        public static final String SHOW = "SHOW";
        public static final String SUCCESS = "RESPONSE";
    }

    public interface ActionString {
        public static final String CLICK = "点击";
        public static final String FAIL = "失败";
        public static final String REQUEST = "请求";
        public static final String SHOW = "曝光";
        public static final String SUCCESS = "成功";
    }

    public static class AdInfo {
        private int ecpm;
        private String source;

        public int getEcpm() {
            return this.ecpm;
        }

        public String getSource() {
            return this.source;
        }

        public void setEcpm(int ecpm) {
            this.ecpm = ecpm;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

    public interface AdType {
        public static final String BANNER = "banner";
        public static final String BANNER_TT = "banner_tt";
        public static final String EXPRESS = "express";
        public static final String FULL_VIDEO = "full_video";
        public static final String INTERSTITIAL = "interstitial";
        public static final String NATIVE = "native";
        public static final String REWARD_VIDEO = "reward_video";
        public static final String SPLASH = "splash";
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
        public static final String MI = "MI";
        public static final String OPPO = "OPPO";
        public static final String VIVO = "VIVO";
    }

    public static AdConfig buildAdConfig(@NonNull AdSlot adSlot) {
        AdConfig adConfig = new AdConfig();
        adConfig.setType(adSlot.getType());
        adConfig.setSource(adSlot.getUnion());
        adConfig.setAppid(adSlot.getAppid());
        adConfig.setBidding(adSlot.getBidding());
        adConfig.setAdsId(adSlot.getSid());
        adConfig.setWeight(adSlot.getWeight());
        adConfig.setEcpm(adSlot.getEcpm());
        adConfig.setAliasUnion(adSlot.getAliasUnion());
        return adConfig;
    }

    public static int getAdsDefaultHeight(String source) {
        if (k.p(source)) {
            return g.n;
        }
        source.hashCode();
        if (source.equals(UnionType.BQT)) {
            return 230;
        }
        if (source.equals(UnionType.GDT)) {
            return 288;
        }
        return g.n;
    }

    public static boolean isAdFailed(String event) {
        return event.contains(ActionString.FAIL);
    }

    public static boolean isAdSuccess(String event) {
        return ActionString.SUCCESS.equalsIgnoreCase(event);
    }

    public static boolean isUploadAction(String event) {
        return ActionString.SUCCESS.equalsIgnoreCase(event) || ActionString.REQUEST.equalsIgnoreCase(event) || ActionString.SHOW.equalsIgnoreCase(event) || ActionString.CLICK.equalsIgnoreCase(event) || event.contains(ActionString.FAIL);
    }

    public String getAction(String event) {
        event.hashCode();
        switch (event) {
            case "成功":
                return Action.SUCCESS;
            case "曝光":
                return Action.SHOW;
            case "点击":
                return Action.CLICK;
            case "请求":
                return Action.REQUEST;
            default:
                return Action.FAIL;
        }
    }

    public AdInfo getAdInfo() {
        return this.adInfo;
    }

    public int getAdLoadSeq() {
        return this.adLoadSeq;
    }

    public TTAdLoadType getAdLoadType() {
        return this.adLoadType;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public int getAdsCount() {
        return this.adsCount;
    }

    public String getAdsId() {
        return this.adsId;
    }

    public String getAdsPosition() {
        return this.adsPosition;
    }

    public String getAliasUnion() {
        return this.aliasUnion;
    }

    public String getApiUrl() {
        return this.apiUrl;
    }

    public String getAppid() {
        return this.appid;
    }

    public b.d.a.a getBaeArticleInfo() {
        return this.baeArticleInfo;
    }

    public int getBidding() {
        return this.bidding;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public double getEcpmPercent() {
        Double d2 = this.ecpmPercent;
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    public int getEventEcpm(String event) {
        if (isBidding() && ActionString.SHOW.equalsIgnoreCase(event) && ActionString.SHOW.equalsIgnoreCase(event)) {
            return this.ecpm;
        }
        return 0;
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

    public String getPrimeRit() {
        return this.primeRit;
    }

    public int getReward() {
        return this.reward;
    }

    public String getRewardExtra() {
        return this.rewardExtra;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public String getSource() {
        return this.source;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public String getWxAppid() {
        return this.wxAppid;
    }

    public boolean isAdCompliance() {
        return this.adCompliance;
    }

    public boolean isBidding() {
        int i2 = this.bidding;
        return i2 == 1 || i2 == 3;
    }

    public boolean isBqtAd() {
        return UnionType.BQT.equalsIgnoreCase(this.source);
    }

    public boolean isChapterEndAd() {
        return this.chapterEndAd;
    }

    public boolean isChapterMiddleAd() {
        return this.chapterMiddleAd;
    }

    public boolean isFullAdOnly() {
        return this.fullAdOnly;
    }

    public boolean isKsAd() {
        return "KS".equalsIgnoreCase(this.source);
    }

    public boolean isNeedNativeCompliance() {
        return this.needNativeCompliance;
    }

    public boolean isShakeStyle() {
        return this.shakeStyle;
    }

    public boolean isWifiEnv() {
        return this.isWifiEnv;
    }

    public AdConfig setAdCompliance(boolean adCompliance) {
        this.adCompliance = adCompliance;
        return this;
    }

    public AdConfig setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
        return this;
    }

    public AdConfig setAdLoadSeq(int adLoadSeq) {
        this.adLoadSeq = adLoadSeq;
        return this;
    }

    public AdConfig setAdLoadType(TTAdLoadType adLoadType) {
        this.adLoadType = adLoadType;
        return this;
    }

    public AdConfig setAdTag(String adTag) {
        this.adTag = adTag;
        return this;
    }

    public AdConfig setAdsCount(int adsCount) {
        this.adsCount = adsCount;
        return this;
    }

    public AdConfig setAdsId(String adsId) {
        this.adsId = adsId;
        return this;
    }

    public AdConfig setAdsPosition(String adsPosition) {
        this.adsPosition = adsPosition;
        return this;
    }

    public void setAliasUnion(String aliasUnion) {
        this.aliasUnion = aliasUnion;
    }

    public AdConfig setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    public AdConfig setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public AdConfig setBaeArticleInfo(b.d.a.a baeArticleInfo) {
        this.baeArticleInfo = baeArticleInfo;
        return this;
    }

    public AdConfig setBidding(int bidding) {
        this.bidding = bidding;
        return this;
    }

    public AdConfig setChapterEndAd(boolean chapterEndAd) {
        this.chapterEndAd = chapterEndAd;
        return this;
    }

    public AdConfig setChapterMiddleAd(boolean chapterMiddleAd) {
        this.chapterMiddleAd = chapterMiddleAd;
        return this;
    }

    public AdConfig setEcpm(int ecpm) {
        this.ecpm = ecpm;
        return this;
    }

    public AdConfig setEcpmPercent(double ecpmPercent) {
        this.ecpmPercent = Double.valueOf(ecpmPercent);
        return this;
    }

    public AdConfig setFullAdOnly(boolean fullAdOnly) {
        this.fullAdOnly = fullAdOnly;
        return this;
    }

    public AdConfig setGid(String gid) {
        this.gid = gid;
        return this;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public AdConfig setHeight(int height) {
        this.height = height;
        return this;
    }

    public void setNeedNativeCompliance(boolean needNativeCompliance) {
        this.needNativeCompliance = needNativeCompliance;
    }

    public AdConfig setPrimeRit(String primeRit) {
        this.primeRit = primeRit;
        return this;
    }

    public AdConfig setReward(int reward) {
        this.reward = reward;
        return this;
    }

    public AdConfig setRewardExtra(String rewardExtra) {
        this.rewardExtra = rewardExtra;
        return this;
    }

    public AdConfig setRewardName(String rewardName) {
        this.rewardName = rewardName;
        return this;
    }

    public AdConfig setShakeStyle(boolean shakeStyle) {
        this.shakeStyle = shakeStyle;
        return this;
    }

    public AdConfig setShowTime(long showTime) {
        this.showTime = showTime;
        return this;
    }

    public AdConfig setSource(String source) {
        this.source = source;
        return this;
    }

    public AdConfig setTag(Object tag) {
        this.tag = tag;
        return this;
    }

    public AdConfig setType(String type) {
        this.type = type;
        return this;
    }

    public AdConfig setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public AdConfig setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public AdConfig setWidth(int width) {
        this.width = width;
        return this;
    }

    public AdConfig setWifiEnv(boolean wifiEnv) {
        this.isWifiEnv = wifiEnv;
        return this;
    }

    public AdConfig setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
        return this;
    }

    public AppTask toAppTask() {
        AppTask appTask = new AppTask();
        appTask.id = getAdsId();
        appTask.source = getSource();
        appTask.adsPosition = getAdsPosition();
        appTask.adsType = getType();
        appTask.gid = getGid();
        appTask.setBidding(getBidding());
        appTask.setEcpm(getEcpm());
        appTask.setGroup(getGroup());
        appTask.setShakeStyle(isShakeStyle());
        appTask.setAdTag(getAdTag());
        return appTask;
    }
}
