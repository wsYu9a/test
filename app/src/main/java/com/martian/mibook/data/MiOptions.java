package com.martian.mibook.data;

import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libsupport.b;
import com.martian.libsupport.k;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.manager.d;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: classes.dex */
public class MiOptions {
    private Integer adBannerClickGuideIntervalV2;
    private Integer adBookIdMinutes;
    private Integer adChapterMinutes;
    private Integer adClickOptimizeInterval;
    private Boolean adCompliance;
    private Boolean adComplianceControlable;
    private Integer adFlowClickGuideIntervalV2;
    private Integer adsDialogIntervalMinutes;
    private Integer adsHideIntervalMinutes;
    private Integer adsHideSecondIntervalMinutes;
    private Integer adsRunTimes;
    private int authorVideoCountdownInterval;
    private Boolean baeBiddingWithWaterfall;
    private Integer bannerAdInterval;
    private Integer bannerAdIntervalExtra;
    private Integer bannerAdIntervalFirstExtra;
    private Integer bannerJointEcpm;
    private Integer bannerMaxExtraDelay;
    private Integer bannerOptimizeBaseEcpm;
    private Integer bannerOptimizeFirstEcpm;
    private String[] blockAppNameList;
    private String[] blockAppPkgList;
    private Integer bookAdInterval;
    private List<BookMallTab> bookMallTabs;
    private List<BookRankTab> bookRankTabs;
    private Integer bookmallInterval;
    private Integer commentKeywordNum;
    private String[] commentKeywords;
    private Integer commissionBlockRunTimes;
    private Boolean enableAdBlock2;
    private Integer enableAdxWeight4;
    private Boolean enableBaeAdInfo;
    private Boolean enableHotSplash;
    private Boolean enableInviteLink;
    private Boolean enablePrimeRit;
    private Boolean enableSearch;
    private Boolean enableUpgrade;
    private Boolean enableVideoCountdown;
    private Integer enableWblAdWeight;
    private Boolean enablexianPlay;
    private Integer flowJointEcpm;
    private Integer flowOptimizeEcpm;
    private Integer gdtBannerPriceTagMode;
    private Integer gdtFlowPriceTagMode;
    private Boolean goReading;
    private Boolean grayMode;
    private Integer interAdRuntimesInterval2;
    private Integer interAdStartRuntimes;
    private Integer linkAdWeight;
    private Integer missionBlockRunTimes;
    private String[] mplist;
    private Integer normalReadingAdsInterval;
    private Integer oppoSplashDestroyWeight;
    private Integer optimizeSplashAdEcpm2;
    private Integer readCheckErrorRange;
    private Integer readCheckSlideCount;
    private Integer readingAdsInterval;
    private Integer shakeStyleEcpm;
    private Boolean showComments;
    private Integer splashRestartDelay;
    private Boolean useWebviewRecharge;
    private Integer userAdInterval;
    private Integer userCommentSeconds;
    private Integer videoMissionInterval;
    private VipAdInfo vipAdInfo;
    private Integer vipAdWeight;
    private Integer wblAdWeight2;
    private Boolean withdrawInterfaceVerify;
    private String shareLink = "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook";
    private String weixinGroupId = "txsmfxsyd";
    private String verifyPhoneHint = "";
    private String helpLink = "https://mp.weixin.qq.com/s/LNENHE-VJzeX8s_827ZFnQ";
    private String qplayLink = "https://qplay-1251592799.file.myqcloud.com/qplay-Qplay-Tfbook-release.apk";
    private String tfRechargeWxAppidV2 = "wxad664a371434b7b0";
    private String tfWithdrawWxAppidV2 = "wxad664a371434b7b0";
    private String phoneInviteDomainTf = "tf.taoyuewenhua.net";
    private String defaultAdsPosterUrl = "https://qplay-1251592799.file.myqcloud.com/posters/%E5%BC%80%E5%BF%83%E5%B0%8F%E5%86%9C%E5%9C%BA.webp";
    private final String[] COMMENT_KEYWORDS = {"小说", "小说阅读器", "阅读", "电子书", "免费小说", "漫画", "看书", "读书", "听书", "追书", "阅读", "赚钱", "网赚", "小说大全", "读书神器", d.f14056h, "言情小说", "书", "免费小说大全", "看书软件", "读书软件", "书城", "动漫", "红包", "兼职"};
    public final String[] MPLIST = {"Y29tLmN5amgubW9iaWxlYW5qaWFu", "Y29tLmh1YXRp", "Y29tLndvcmsua3lvLmZ1emh1"};

    public int getAdBannerClickGuideIntervalV2() {
        Integer num = this.adBannerClickGuideIntervalV2;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getAdBookIdMinutes() {
        Integer num = this.adBookIdMinutes;
        return Integer.valueOf(num == null ? 120 : num.intValue());
    }

    public Integer getAdChapterMinutes() {
        Integer num = this.adChapterMinutes;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getAdClickOptimizeInterval() {
        Integer num = this.adClickOptimizeInterval;
        if (num == null) {
            return 1200000;
        }
        return num.intValue() * BaseConstants.Time.MINUTE;
    }

    public boolean getAdComplianceControlable() {
        Boolean bool = this.adComplianceControlable;
        return bool != null && bool.booleanValue();
    }

    public int getAdFlowClickGuideIntervalV2() {
        if (MiConfigSingleton.V3().J0()) {
            return 100;
        }
        Integer num = this.adFlowClickGuideIntervalV2;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getAdInterval(boolean isAdBookId) {
        return (isAdBookId ? getBookAdInterval() : getUserAdInterval()).intValue();
    }

    public Integer getAdsDialogIntervalMinutes() {
        Integer num = this.adsDialogIntervalMinutes;
        return Integer.valueOf(num == null ? 60 : num.intValue());
    }

    public Integer getAdsHideIntervalMinutes() {
        Integer num = this.adsHideIntervalMinutes;
        return Integer.valueOf(num == null ? 15 : num.intValue());
    }

    public Integer getAdsHideSecondIntervalMinutes() {
        Integer num = this.adsHideSecondIntervalMinutes;
        return Integer.valueOf(num == null ? 15 : num.intValue());
    }

    public Integer getAdsRunTimes() {
        Integer num = this.adsRunTimes;
        return Integer.valueOf(num == null ? 2 : num.intValue());
    }

    public int getAuthorVideoCountdownInterval() {
        return this.authorVideoCountdownInterval;
    }

    public boolean getBaeBiddingWithWaterfall() {
        Boolean bool = this.baeBiddingWithWaterfall;
        return bool == null || bool.booleanValue();
    }

    public Integer getBannerAdInterval() {
        Integer num = this.bannerAdInterval;
        return Integer.valueOf(num == null ? 30 : num.intValue());
    }

    public int getBannerAdIntervalExtra() {
        Integer num = this.bannerAdIntervalExtra;
        if (num == null) {
            return 30000;
        }
        return num.intValue() * 1000;
    }

    public int getBannerAdIntervalFirstExtra() {
        Integer num = this.bannerAdIntervalFirstExtra;
        if (num == null) {
            return 30000;
        }
        return num.intValue() * 1000;
    }

    public int getBannerJointEcpm() {
        Integer num = this.bannerJointEcpm;
        if (num == null) {
            return 300;
        }
        return num.intValue();
    }

    public int getBannerMaxExtraDelay() {
        Integer num = this.bannerMaxExtraDelay;
        return num == null ? TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE : num.intValue();
    }

    public int getBannerOptimizeBaseEcpm() {
        Integer num = this.bannerOptimizeBaseEcpm;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public int getBannerOptimizeFirstEcpm() {
        Integer num = this.bannerOptimizeFirstEcpm;
        if (num == null) {
            return 200;
        }
        return num.intValue();
    }

    public String[] getBlockAppNameList() {
        return this.blockAppNameList;
    }

    public String[] getBlockAppPkgList() {
        return this.blockAppPkgList;
    }

    public Integer getBookAdInterval() {
        Integer num = this.bookAdInterval;
        return Integer.valueOf(num == null ? 10 : num.intValue());
    }

    public List<BookMallTab> getBookMallTabs() {
        return this.bookMallTabs;
    }

    public List<BookRankTab> getBookRankTabs() {
        return this.bookRankTabs;
    }

    public int getBookmallInterval() {
        Integer num = this.bookmallInterval;
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    public Integer getCommentKeywordNum() {
        Integer num = this.commentKeywordNum;
        return Integer.valueOf(num == null ? 2 : num.intValue());
    }

    public final String[] getCommentKeywords() {
        if (getCommentKeywordNum().intValue() == 0) {
            return null;
        }
        if (this.commentKeywords == null) {
            this.commentKeywords = this.COMMENT_KEYWORDS;
        }
        int intValue = getCommentKeywordNum().intValue();
        int length = this.commentKeywords.length;
        if (intValue > length) {
            intValue = length;
        }
        String[] strArr = new String[intValue];
        int i2 = 0;
        for (int i3 = 0; i3 < length && i2 < intValue; i3++) {
            double random = Math.random();
            double d2 = length - i3;
            Double.isNaN(d2);
            if (random * d2 < intValue - i2) {
                strArr[i2] = this.commentKeywords[i3];
                i2++;
            }
        }
        return strArr;
    }

    public Integer getCommissionBlockRunTimes() {
        Integer num = this.commissionBlockRunTimes;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public String getDefaultAdsPosterUrl() {
        return this.defaultAdsPosterUrl;
    }

    public boolean getEnableAdBlock2() {
        Boolean bool = this.enableAdBlock2;
        return bool == null || bool.booleanValue();
    }

    public int getEnableAdxWeight() {
        Integer num = this.enableAdxWeight4;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getEnableBaeAdInfo() {
        Boolean bool = this.enableBaeAdInfo;
        return bool != null && bool.booleanValue();
    }

    public boolean getEnableHotSplash() {
        Boolean bool = this.enableHotSplash;
        return bool == null || bool.booleanValue();
    }

    public Boolean getEnableInviteLink() {
        Boolean bool = this.enableInviteLink;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public boolean getEnablePrimeRit() {
        Boolean bool = this.enablePrimeRit;
        return bool == null || bool.booleanValue();
    }

    public boolean getEnableSearch() {
        Boolean bool = this.enableSearch;
        return bool == null || bool.booleanValue();
    }

    public boolean getEnableUpgrade() {
        if (h.F().J0()) {
            return true;
        }
        Boolean bool = this.enableUpgrade;
        return bool != null && bool.booleanValue();
    }

    public boolean getEnableVideoCountdown() {
        Boolean bool = this.enableVideoCountdown;
        return bool != null && bool.booleanValue();
    }

    public int getEnableWblAdWeight() {
        Integer num = this.enableWblAdWeight;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Boolean getEnablexianPlay() {
        Boolean bool = this.enablexianPlay;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public int getFlowJointEcpm() {
        Integer num = this.flowJointEcpm;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowOptimizeEcpm() {
        Integer num = this.flowOptimizeEcpm;
        if (num == null) {
            return 200;
        }
        return num.intValue();
    }

    public Integer getFreeReadingAdsInterval() {
        Integer num = this.readingAdsInterval;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public int getGdtBannerPriceTagMode() {
        Integer num;
        if (MiConfigSingleton.V3().Z5() || (num = this.gdtBannerPriceTagMode) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getGdtFlowPriceTagMode() {
        Integer num;
        if (MiConfigSingleton.V3().Z5() || (num = this.gdtFlowPriceTagMode) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getGoReading() {
        Boolean bool = this.goReading;
        return bool != null && bool.booleanValue();
    }

    public boolean getGrayMode() {
        Boolean bool = this.grayMode;
        return bool != null && bool.booleanValue();
    }

    public String getHelpLink() {
        return this.helpLink;
    }

    public int getInterAdRuntimesInterval2() {
        Integer num = this.interAdRuntimesInterval2;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getInterAdStartRuntimes() {
        Integer num = this.interAdStartRuntimes;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public String getInviteShareLink() {
        String str;
        String str2;
        if (!MiConfigSingleton.V3().l6() || !getEnableInviteLink().booleanValue()) {
            return this.shareLink;
        }
        if (h.F().Q0()) {
            str2 = "http://testtfbook.taoyuewenhua.vip/callback/";
            str = "wx41631672e14a9c0c";
        } else {
            str = "wx101f1f61fef1afbe";
            str2 = "http://tfbook.taoyuewenhua.vip/callback/";
        }
        return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + str + "&redirect_uri=" + URLEncoder.encode(str2 + MiConfigSingleton.V3().f().f9879a + "/" + str + "/" + MiConfigSingleton.V3().t() + "/0/" + MiConfigSingleton.V3().M4.h().getUid() + "/invite_wx_register.do?package_name=" + MiConfigSingleton.V3().getPackageName()) + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }

    public Integer getLinkAdWeight() {
        Integer num = this.linkAdWeight;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    public Integer getMissionBlockRunTimes() {
        Integer num = this.missionBlockRunTimes;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public String[] getMplist() {
        return this.mplist;
    }

    public final String getMplistPackageName(j1 activity) {
        if (this.mplist == null) {
            this.mplist = this.MPLIST;
        }
        try {
            for (String str : this.mplist) {
                String b2 = b.b(str);
                if (!k.p(b2) && s2.p(activity, b2)) {
                    return b2;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public Integer getNormalReadingAdsInterval() {
        Integer num = this.normalReadingAdsInterval;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public int getOppoSplashDestroy() {
        Integer num = this.oppoSplashDestroyWeight;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public int getOptimizeSplashAdEcpm() {
        Integer num = this.optimizeSplashAdEcpm2;
        if (num == null) {
            return 500;
        }
        return num.intValue();
    }

    public String getPhoneInviteDomainTf() {
        return this.phoneInviteDomainTf;
    }

    public String getPhoneInviteShareLink() {
        if (h.F().Q0()) {
            return "http://testtf.taoyuewenhua.net/invite/index_tfbook.html?uid=" + MiConfigSingleton.V3().D4() + "&remoteTest=true&package_name=" + MiConfigSingleton.V3().getPackageName() + "&appid=" + MiConfigSingleton.V3().f().f9879a;
        }
        if (!MiConfigSingleton.V3().x5() || !getEnableInviteLink().booleanValue()) {
            return this.shareLink;
        }
        return "http://" + getPhoneInviteDomainTf() + "/invite/index_tfbook.html?uid=" + MiConfigSingleton.V3().D4() + "&package_name=" + MiConfigSingleton.V3().getPackageName() + "&appid=" + MiConfigSingleton.V3().f().f9879a;
    }

    public String getQplayLink() {
        return this.qplayLink;
    }

    public Integer getReadCheckErrorRange() {
        Integer num = this.readCheckErrorRange;
        return Integer.valueOf(num == null ? 10 : num.intValue());
    }

    public Integer getReadCheckSlideCount() {
        Integer num = this.readCheckSlideCount;
        return Integer.valueOf(num == null ? 500 : num.intValue());
    }

    public String getRechargeWxAppid() {
        return this.tfRechargeWxAppidV2;
    }

    public int getShakeStyleEcpm() {
        Integer num = this.shakeStyleEcpm;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public boolean getShowComments() {
        Boolean bool = this.showComments;
        return bool == null || bool.booleanValue();
    }

    public Integer getSplashRestartDelay() {
        Integer num = this.splashRestartDelay;
        return Integer.valueOf(num == null ? 300000 : num.intValue());
    }

    public Boolean getUseWebviewRecharge() {
        Boolean bool = this.useWebviewRecharge;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public Integer getUserAdInterval() {
        Integer num = this.userAdInterval;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getUserCommentSeconds() {
        Integer num = this.userCommentSeconds;
        if (num == null) {
            return 60;
        }
        return num.intValue();
    }

    public String getVerifyPhoneHint() {
        return this.verifyPhoneHint;
    }

    public Integer getVideoMissionInterval() {
        Integer num = this.videoMissionInterval;
        return Integer.valueOf(num == null ? 5 : num.intValue());
    }

    public VipAdInfo getVipAdInfo() {
        return this.vipAdInfo;
    }

    public Integer getVipAdWeight() {
        Integer num = this.vipAdWeight;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getWblAdWeight() {
        Integer num = this.wblAdWeight2;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getWeixinGroupId() {
        return k.p(this.weixinGroupId) ? "txsmfxsyd" : this.weixinGroupId;
    }

    public boolean getWithdrawInterfaceVerify() {
        Boolean bool = this.withdrawInterfaceVerify;
        return bool == null || bool.booleanValue();
    }

    public String getWithdrawWxAppid() {
        return this.tfWithdrawWxAppidV2;
    }

    public boolean isAdCompliance() {
        Boolean bool = this.adCompliance;
        return bool == null || bool.booleanValue();
    }

    public void setAdBannerClickGuideIntervalV2(Integer adBannerClickGuideIntervalV2) {
        this.adBannerClickGuideIntervalV2 = adBannerClickGuideIntervalV2;
    }

    public void setAdBookIdMinutes(Integer adBookIdMinutes) {
        this.adBookIdMinutes = adBookIdMinutes;
    }

    public void setAdChapterMinutes(Integer adChapterMinutes) {
        this.adChapterMinutes = adChapterMinutes;
    }

    public void setAdClickOptimizeInterval(Integer adClickOptimizeInterval) {
        this.adClickOptimizeInterval = adClickOptimizeInterval;
    }

    public void setAdCompliance(Boolean adCompliance) {
        this.adCompliance = adCompliance;
    }

    public void setAdComplianceControlable(Boolean adComplianceControlable) {
        this.adComplianceControlable = adComplianceControlable;
    }

    public void setAdFlowClickGuideIntervalV2(Integer adFlowClickGuideIntervalV2) {
        this.adFlowClickGuideIntervalV2 = adFlowClickGuideIntervalV2;
    }

    public void setAdsDialogIntervalMinutes(Integer adsDialogIntervalMinutes) {
        this.adsDialogIntervalMinutes = adsDialogIntervalMinutes;
    }

    public void setAdsHideIntervalMinutes(Integer adsHideIntervalMinutes) {
        this.adsHideIntervalMinutes = adsHideIntervalMinutes;
    }

    public void setAdsHideSecondIntervalMinutes(Integer adsHideSecondIntervalMinutes) {
        this.adsHideSecondIntervalMinutes = adsHideSecondIntervalMinutes;
    }

    public void setAdsRunTimes(Integer adsRunTimes) {
        this.adsRunTimes = adsRunTimes;
    }

    public void setAuthorVideoCountdownInterval(int authorVideoCountdownInterval) {
        this.authorVideoCountdownInterval = authorVideoCountdownInterval;
    }

    public void setBaeBiddingWithWaterfall(Boolean baeBiddingWithWaterfall) {
        this.baeBiddingWithWaterfall = baeBiddingWithWaterfall;
    }

    public void setBannerAdInterval(Integer bannerAdInterval) {
        this.bannerAdInterval = bannerAdInterval;
    }

    public void setBannerAdIntervalExtra(Integer bannerAdIntervalExtra) {
        this.bannerAdIntervalExtra = bannerAdIntervalExtra;
    }

    public void setBannerAdIntervalFirstExtra(Integer bannerAdIntervalFirstExtra) {
        this.bannerAdIntervalFirstExtra = bannerAdIntervalFirstExtra;
    }

    public void setBannerJointEcpm(Integer bannerJointEcpm) {
        this.bannerJointEcpm = bannerJointEcpm;
    }

    public void setBannerMaxExtraDelay(Integer bannerMaxExtraDelay) {
        this.bannerMaxExtraDelay = bannerMaxExtraDelay;
    }

    public void setBannerOptimizeBaseEcpm(Integer bannerOptimizeBaseEcpm) {
        this.bannerOptimizeBaseEcpm = bannerOptimizeBaseEcpm;
    }

    public void setBannerOptimizeFirstEcpm(Integer bannerOptimizeFirstEcpm) {
        this.bannerOptimizeFirstEcpm = bannerOptimizeFirstEcpm;
    }

    public void setBlockAppNameList(String[] blockAppNameList) {
        this.blockAppNameList = blockAppNameList;
    }

    public void setBlockAppPkgList(String[] blockAppPkgList) {
        this.blockAppPkgList = blockAppPkgList;
    }

    public void setBookAdInterval(Integer bookAdInterval) {
        this.bookAdInterval = bookAdInterval;
    }

    public void setBookMallTabs(List<BookMallTab> bookMallTabs) {
        this.bookMallTabs = bookMallTabs;
    }

    public void setBookRankTabs(List<BookRankTab> bookRankTabs) {
        this.bookRankTabs = bookRankTabs;
    }

    public void setBookmallInterval(Integer bookmallInterval) {
        this.bookmallInterval = bookmallInterval;
    }

    public void setCommentKeywordNum(Integer commentKeywordNum) {
        this.commentKeywordNum = commentKeywordNum;
    }

    public void setCommentKeywords(String[] commentKeywords) {
        this.commentKeywords = commentKeywords;
    }

    public void setCommissionBlockRunTimes(Integer commissionBlockRunTimes) {
        this.commissionBlockRunTimes = commissionBlockRunTimes;
    }

    public void setDefaultAdsPosterUrl(String defaultAdsPosterUrl) {
        this.defaultAdsPosterUrl = defaultAdsPosterUrl;
    }

    public void setEnableAdBlock2(Boolean enableAdBlock2) {
        this.enableAdBlock2 = enableAdBlock2;
    }

    public void setEnableAdxWeight(Integer enableAdxWeight) {
        this.enableAdxWeight4 = enableAdxWeight;
    }

    public void setEnableBaeAdInfo(Boolean enableBaeAdInfo) {
        this.enableBaeAdInfo = enableBaeAdInfo;
    }

    public void setEnableHotSplash(Boolean enableHotSplash) {
        this.enableHotSplash = enableHotSplash;
    }

    public void setEnableInviteLink(Boolean enableInviteLink) {
        this.enableInviteLink = enableInviteLink;
    }

    public void setEnablePrimeRit(Boolean enablePrimeRit) {
        this.enablePrimeRit = enablePrimeRit;
    }

    public void setEnableSearch(Boolean enableSearch) {
        this.enableSearch = enableSearch;
    }

    public void setEnableUpgrade(Boolean enableUpgrade) {
        this.enableUpgrade = enableUpgrade;
    }

    public void setEnableVideoCountdown(Boolean enableVideoCountdown) {
        this.enableVideoCountdown = enableVideoCountdown;
    }

    public void setEnableWblAdWeight(Integer enableWblAdWeight) {
        this.enableWblAdWeight = enableWblAdWeight;
    }

    public void setEnablexianPlay(Boolean enablexianPlay) {
        this.enablexianPlay = enablexianPlay;
    }

    public void setFlowJointEcpm(Integer flowJointEcpm) {
        this.flowJointEcpm = flowJointEcpm;
    }

    public void setFlowOptimizeEcpm(Integer flowOptimizeEcpm) {
        this.flowOptimizeEcpm = flowOptimizeEcpm;
    }

    public void setFreeReadingAdsInterval(Integer freeReadingAdsInterval) {
        this.readingAdsInterval = freeReadingAdsInterval;
    }

    public void setGdtBannerPriceTagMode(Integer gdtBannerPriceTagMode) {
        this.gdtBannerPriceTagMode = gdtBannerPriceTagMode;
    }

    public void setGdtFlowPriceTagMode(Integer gdtFlowPriceTagMode) {
        this.gdtFlowPriceTagMode = gdtFlowPriceTagMode;
    }

    public void setGoReading(Boolean goReading) {
        this.goReading = goReading;
    }

    public void setGrayMode(Boolean grayMode) {
        this.grayMode = grayMode;
    }

    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }

    public void setInterAdRuntimesInterval2(Integer interAdRuntimesInterval2) {
        this.interAdRuntimesInterval2 = interAdRuntimesInterval2;
    }

    public void setInterAdStartRuntimes(Integer interAdStartRuntimes) {
        this.interAdStartRuntimes = interAdStartRuntimes;
    }

    public void setLinkAdWeight(Integer linkAdWeight) {
        this.linkAdWeight = linkAdWeight;
    }

    public void setMissionBlockRunTimes(Integer missionBlockRunTimes) {
        this.missionBlockRunTimes = missionBlockRunTimes;
    }

    public void setMplist(String[] mplist) {
        this.mplist = mplist;
    }

    public void setNormalReadingAdsInterval(Integer normalReadingAdsInterval) {
        this.normalReadingAdsInterval = normalReadingAdsInterval;
    }

    public void setOppoSplashDestroy(Integer oppoSplashDestroy) {
        this.oppoSplashDestroyWeight = oppoSplashDestroy;
    }

    public void setOptimizeSplashAdEcpm2(Integer optimizeSplashAdEcpm2) {
        this.optimizeSplashAdEcpm2 = optimizeSplashAdEcpm2;
    }

    public void setPhoneInviteDomainTf(String phoneInviteDomainTf) {
        this.phoneInviteDomainTf = phoneInviteDomainTf;
    }

    public void setQplayLink(String qplayLink) {
        this.qplayLink = qplayLink;
    }

    public void setReadCheckErrorRange(Integer readCheckErrorRange) {
        this.readCheckErrorRange = readCheckErrorRange;
    }

    public void setReadCheckSlideCount(Integer readCheckSlideCount) {
        this.readCheckSlideCount = readCheckSlideCount;
    }

    public void setShakeStyleEcpm(Integer shakeStyleEcpm) {
        this.shakeStyleEcpm = shakeStyleEcpm;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public void setShowComments(Boolean showComments) {
        this.showComments = showComments;
    }

    public void setSplashRestartDelay(Integer splashRestartDelay) {
        this.splashRestartDelay = splashRestartDelay;
    }

    public void setUseWebviewRecharge(Boolean useWebviewRecharge) {
        this.useWebviewRecharge = useWebviewRecharge;
    }

    public void setUserAdInterval(Integer userAdInterval) {
        this.userAdInterval = userAdInterval;
    }

    public void setUserCommentSeconds(Integer userCommentSeconds) {
        this.userCommentSeconds = userCommentSeconds;
    }

    public void setVerifyPhoneHint(String verifyPhoneHint) {
        this.verifyPhoneHint = verifyPhoneHint;
    }

    public void setVipAdInfo(VipAdInfo vipAdInfo) {
        this.vipAdInfo = vipAdInfo;
    }

    public void setVipAdWeight(Integer vipAdWeight) {
        this.vipAdWeight = vipAdWeight;
    }

    public void setWblAdWeight2(Integer wblAdWeight2) {
        this.wblAdWeight2 = wblAdWeight2;
    }

    public void setWeixinGroupId(String weixinGroupId) {
        this.weixinGroupId = weixinGroupId;
    }

    public void setWithdrawInterfaceVerify(Boolean withdrawInterfaceVerify) {
        this.withdrawInterfaceVerify = withdrawInterfaceVerify;
    }

    public void setWithdrawVerify(Boolean withdrawVerify) {
        this.withdrawInterfaceVerify = withdrawVerify;
    }
}
