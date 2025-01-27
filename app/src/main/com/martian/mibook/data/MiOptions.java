package com.martian.mibook.data;

import android.app.Activity;
import ba.d;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.BannerAdManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.BaseConfigSingleton;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import je.i;
import qe.c;
import vb.e;
import wd.a;

/* loaded from: classes3.dex */
public class MiOptions {
    private Integer adBookIdMinutes;
    private Integer adChapterMinutes;
    private Integer adClickGuideBannerInterval;
    private Integer adClickGuideFlowInterval;
    private Integer adClickOptimizeInterval;
    private Boolean adCompliance;
    private Boolean adComplianceControlable;
    private Integer adIntervalExtentMinutes;
    private Integer adsDialogIntervalMinutes;
    private Integer adsHideIntervalMinutes;
    private Integer adsHideSecondIntervalMinutes;
    private Integer adsRunTimes;
    private Integer audioUnlockMinutes;
    private Integer audioVideoMinutes;
    private Integer audiobookAdMisClickRate;
    private int authorVideoCountdownInterval;
    private Boolean baeBiddingWithWaterfall;
    private Integer bannerAdInterval;
    private Integer bannerAdIntervalExtra;
    private Integer bannerAdIntervalFirstExtra;
    private Integer bannerBqtMisClickBaseEcpmV2;
    private Integer bannerCsjMisClickBaseEcpmV2;
    private Integer bannerJointEcpm;
    private Integer bannerKsMisClickBaseEcpmV2;
    private Integer bannerMaxExtraDelay;
    private Integer bannerMisClickBaseEcpm5;
    private Integer bannerMisClickBaseRate;
    private Integer bannerMisClickPlatform;
    private Integer bannerOptimizeBaseEcpm;
    private Integer bannerOptimizeFirstEcpm;
    private Integer bannerYlhMisClickBaseEcpmV2;
    private Integer baseIntervalEcpm;
    private String[] blockAppNameList;
    private String[] blockAppPkgList;
    private Integer bookAdInterval;
    private Integer bookAdWeight;
    private Integer bookAdWeightFresh;
    private List<BookMallTab> bookMallTabs;
    private List<BookRankTab> bookRankTabs;
    private Integer bookmallInterval;
    private Integer commentKeywordNum;
    private String[] commentKeywords;
    private Integer commissionBlockRunTimes;
    private Integer csjAdPauseSeconds;
    private Boolean enableAdBlock2;
    private Integer enableAdxWeight4;
    private Boolean enableBaeAdInfo;
    private Boolean enableHotSplash;
    private Boolean enableInviteLink;
    private Boolean enablePrimeRit;
    private Boolean enableSearch;
    private Boolean enableUpgrade;
    private Boolean enableVideoCountdown;
    private Boolean enableX1Sdk;
    private Boolean enablexianPlay;
    private Integer flowBqtMisClickBaseEcpmV2;
    private Integer flowCsjMisClickBaseEcpmV2;
    private Integer flowJointEcpm;
    private Integer flowKsMisClickBaseEcpmV2;
    private Integer flowMisClickBaseEcpm5;
    private Integer flowMisClickBaseRate;
    private Integer flowMisClickPlatform;
    private Integer flowOptimizeEcpm;
    private Integer flowYlhMisClickBaseEcpmV2;
    private Integer freshReadingAdsInterval;
    private Integer freshUserHourInterval;
    private Integer gdtAdPauseSeconds;
    private Integer gdtBannerPriceTagMode;
    private Integer gdtFlowPriceTagMode;
    private Boolean goReading;
    private Boolean grayMode;
    private Integer gromoreAdWeight;
    private Integer gromoreInterstitialAdUserWeight;
    private Integer gromoreRewardVideoAdUserWeight;
    private Integer gromoreSplashAdUserWeight;
    private Integer interAdRuntimesInterval2;
    private Integer interAdStartRuntimes;
    private Integer interstitialAdBaseEcpm;
    private Integer interstitialAdBaseInterval;
    private Integer interstitialAdEnquiryEcpm2;
    private Boolean interstitialAdMerge;
    private Integer interstitialAdMinInterval;
    private Integer linkAdWeight;
    private Integer maxAdIntervalExtra;
    private Integer maxIntervalEcpm;
    private Integer minIntervalSeconds;
    private Integer misClickExtraBlockSeconds;
    private Integer misClickMaxRate;
    private Integer misClickMinSecondsV2;
    private Integer missionBlockRunTimes;
    private String[] mplist;
    private Boolean nativePay;
    private Integer normalAdUserWeight;
    private Integer oppoSplashDestroyWeight;
    private Integer optimizeSplashAdEcpm2;
    private Boolean promoteBookOnStart;
    private Integer readCheckErrorRange;
    private Integer readCheckSlideCount;
    private Integer readingAdsInterval;
    private Boolean removeVideoAd;
    private Integer rewardVideoAdEnquiryEcpm;
    private Integer sensorEnableSeconds;
    private Integer shakeStyleEcpm;
    private Boolean showComments;
    private Integer splashRestartDelay;
    private Integer ttsUnlockMinutes;
    private Boolean useWebviewRecharge;
    private Integer userAdInterval;
    private Integer userCommentSeconds;
    private Integer videoMissionInterval;
    private VipAdInfo vipAdInfo;
    private Integer vipAdWeight;
    private Boolean weakBannerButton;
    private String wechatCustomerUrl;
    private Boolean withdrawInterfaceVerify;
    private Integer withoutAdMinutes;
    private String shareLink = "http://a.app.qq.com/o/simple.jsp?pkgname=com.martian.ttbook";
    private String weixinGroupId = "txsmfxsyd";
    private String verifyPhoneHint = "";
    private String helpLink = "https://mp.weixin.qq.com/s/LNENHE-VJzeX8s_827ZFnQ";
    private String qplayLink = "https://qplay-1251592799.file.myqcloud.com/qplay-Qplay-Tfbook-release.apk";
    private String tfRechargeWxAppidV2 = "wxad664a371434b7b0";
    private String tfWithdrawWxAppidV2 = "wxad664a371434b7b0";
    private String phoneInviteDomainTf = "tf.taoyuewenhua.net";
    private String defaultAdsPosterUrl = "https://qplay-1251592799.file.myqcloud.com/posters/%E5%BC%80%E5%BF%83%E5%B0%8F%E5%86%9C%E5%9C%BA.webp";
    private final String[] COMMENT_KEYWORDS = {"小说", "小说阅读器", "阅读", "电子书", "免费小说", "漫画", "看书", "读书", "听书", "追书", "阅读", "赚钱", "网赚", "小说大全", "读书神器", e.f31296c, "言情小说", "书", "免费小说大全", "看书软件", "读书软件", a.f31700i, "动漫", "红包", "兼职"};
    public final String[] MPLIST = {"Y29tLmN5amgubW9iaWxlYW5qaWFu", "Y29tLmh1YXRp", "Y29tLndvcmsua3lvLmZ1emh1"};

    public int getAdBannerClickGuideIntervalV2() {
        if (MiConfigSingleton.b2().C2()) {
            return 0;
        }
        Integer num = this.adClickGuideBannerInterval;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public Integer getAdChapterMinutes() {
        Integer num = this.adChapterMinutes;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getAdClickOptimizeInterval() {
        Integer num = this.adClickOptimizeInterval;
        return num == null ? BannerAdManager.X : num.intValue() * 60000;
    }

    public boolean getAdComplianceControlable() {
        Boolean bool = this.adComplianceControlable;
        return bool != null && bool.booleanValue();
    }

    public int getAdFlowClickGuideIntervalV2() {
        if (MiConfigSingleton.b2().C2()) {
            return 0;
        }
        Integer num = this.adClickGuideFlowInterval;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getAdIntervalExtentMinutes() {
        Integer num = this.adIntervalExtentMinutes;
        if (num == null) {
            return 10;
        }
        return num.intValue();
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

    public int getAudioUnlockMinutes() {
        Integer num = this.audioUnlockMinutes;
        if (num == null) {
            return 30;
        }
        return num.intValue();
    }

    public int getAudioVideoMinutes() {
        Integer num = this.audioVideoMinutes;
        if (num == null) {
            return 60;
        }
        return num.intValue();
    }

    public int getAudiobookAdMisClickRate() {
        Integer num = this.audiobookAdMisClickRate;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getAuthorVideoCountdownInterval() {
        return this.authorVideoCountdownInterval;
    }

    public Integer getBannerAdInterval() {
        Integer num = this.bannerAdInterval;
        return Integer.valueOf(num == null ? 30 : num.intValue());
    }

    public int getBannerBqtMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.bannerBqtMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBannerCsjMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.bannerCsjMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBannerJointEcpm() {
        if (MiConfigSingleton.b2().C2()) {
            return 0;
        }
        Integer num = this.bannerJointEcpm;
        if (num == null) {
            return 300;
        }
        return num.intValue();
    }

    public int getBannerKsMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.bannerKsMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBannerMaxExtraDelay() {
        Integer num = this.bannerMaxExtraDelay;
        if (num == null) {
            return 150;
        }
        return num.intValue();
    }

    public int getBannerMisClickBaseEcpm5() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.bannerMisClickBaseEcpm5) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBannerMisClickBaseRate() {
        Integer num = this.bannerMisClickBaseRate;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getBannerMisClickPlatform() {
        Integer num = this.bannerMisClickPlatform;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBannerOptimizeBaseEcpm() {
        Integer num = this.bannerOptimizeBaseEcpm;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public int getBannerOptimizeFirstEcpm() {
        if (ConfigSingleton.R.B0()) {
            return 1;
        }
        Integer num = this.bannerOptimizeFirstEcpm;
        if (num == null) {
            return 200;
        }
        return num.intValue();
    }

    public int getBannerYlhMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.bannerYlhMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getBaseIntervalEcpm() {
        Integer num = this.baseIntervalEcpm;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String[] getBlockAppNameList() {
        return this.blockAppNameList;
    }

    public String[] getBlockAppPkgList() {
        return this.blockAppPkgList;
    }

    public int getBookAdWeight() {
        Integer num = this.bookAdWeight;
        if (num == null) {
            return 20;
        }
        return num.intValue();
    }

    public int getBookAdWeightFresh() {
        Integer num = this.bookAdWeightFresh;
        if (num == null) {
            return 20;
        }
        return num.intValue();
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
        int i10 = 0;
        for (int i11 = 0; i11 < length && i10 < intValue; i11++) {
            if (Math.random() * (length - i11) < intValue - i10) {
                strArr[i10] = this.commentKeywords[i11];
                i10++;
            }
        }
        return strArr;
    }

    public Integer getCommissionBlockRunTimes() {
        Integer num = this.commissionBlockRunTimes;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public int getCsjAdPauseSeconds() {
        Integer num = this.csjAdPauseSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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

    public Boolean getEnableInviteLink() {
        Boolean bool = this.enableInviteLink;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public boolean getEnableSearch() {
        Boolean bool = this.enableSearch;
        return bool == null || bool.booleanValue();
    }

    public boolean getEnableVideoCountdown() {
        Boolean bool = this.enableVideoCountdown;
        return bool != null && bool.booleanValue();
    }

    public boolean getEnableX1Sdk() {
        Boolean bool = this.enableX1Sdk;
        return bool == null || bool.booleanValue();
    }

    public Boolean getEnablexianPlay() {
        Boolean bool = this.enablexianPlay;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public int getFlowBqtMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowBqtMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowCsjMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowCsjMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowJointEcpm() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowJointEcpm) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowKsMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowKsMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowMisClickBaseEcpm5() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowMisClickBaseEcpm5) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFlowMisClickBaseRate() {
        Integer num = this.flowMisClickBaseRate;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getFlowMisClickPlatform() {
        Integer num = this.flowMisClickPlatform;
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

    public int getFlowYlhMisClickBaseEcpmV2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.flowYlhMisClickBaseEcpmV2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getFreshReadingAdsInterval() {
        Integer num = this.freshReadingAdsInterval;
        if (num == null) {
            return 5;
        }
        return num.intValue();
    }

    public int getFreshUserHourInterval() {
        Integer num = this.freshUserHourInterval;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getGdtAdPauseSeconds() {
        Integer num = this.gdtAdPauseSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getGrayMode() {
        Boolean bool = this.grayMode;
        return bool != null && bool.booleanValue();
    }

    public int getGromoreAdWeight() {
        Integer num = this.gromoreAdWeight;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public int getGromoreInterstitialAdUserWeight() {
        Integer num = this.gromoreInterstitialAdUserWeight;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getGromoreRewardVideoAdUserWeight() {
        Integer num = this.gromoreRewardVideoAdUserWeight;
        if (num == null) {
            return 0;
        }
        return num.intValue();
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

    public int getInterstitialAdBaseEcpm() {
        Integer num = this.interstitialAdBaseEcpm;
        if (num == null) {
            return 5000;
        }
        return num.intValue();
    }

    public int getInterstitialAdBaseInterval() {
        Integer num = this.interstitialAdBaseInterval;
        if (num == null) {
            return 1200;
        }
        return num.intValue();
    }

    public int getInterstitialAdEnquiryEcpm2() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.interstitialAdEnquiryEcpm2) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getInterstitialAdMerge() {
        Boolean bool = this.interstitialAdMerge;
        return bool != null && bool.booleanValue();
    }

    public int getInterstitialAdMinInterval() {
        Integer num = this.interstitialAdMinInterval;
        if (num == null) {
            return 600;
        }
        return num.intValue();
    }

    public String getInviteShareLink() {
        String str;
        String str2;
        if (MiConfigSingleton.b2().N2() && getEnableInviteLink().booleanValue()) {
            if (ConfigSingleton.D().J0()) {
                str2 = "http://testtfbook.taoyuewenhua.vip/callback/";
                str = "wx41631672e14a9c0c";
            } else {
                str = "wx101f1f61fef1afbe";
                str2 = "http://tfbook.taoyuewenhua.vip/callback/";
            }
            try {
                return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + str + "&redirect_uri=" + URLEncoder.encode(str2 + MiConfigSingleton.b2().l().f26178a + "/" + str + "/" + MiConfigSingleton.b2().y() + "/0/" + MiConfigSingleton.b2().u2().s().getUid() + "/invite_wx_register.do?package_name=" + MiConfigSingleton.b2().getPackageName(), "UTF-8") + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        return this.shareLink;
    }

    public Integer getLinkAdWeight() {
        Integer num = this.linkAdWeight;
        return Integer.valueOf(num == null ? 1 : num.intValue());
    }

    public int getMaxAdIntervalExtra() {
        Integer num = this.maxAdIntervalExtra;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxIntervalEcpm() {
        Integer num = this.maxIntervalEcpm;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMinIntervalSeconds() {
        Integer num = this.minIntervalSeconds;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getMisClickExtraBlockSeconds() {
        Integer num = this.misClickExtraBlockSeconds;
        if (num == null) {
            return 60;
        }
        return num.intValue();
    }

    public int getMisClickMaxRate() {
        Integer num = this.misClickMaxRate;
        if (num == null) {
            return 150;
        }
        return num.intValue();
    }

    public int getMisClickMinSecondsV2() {
        Integer num = this.misClickMinSecondsV2;
        if (num == null) {
            return 150;
        }
        return num.intValue();
    }

    public Integer getMissionBlockRunTimes() {
        Integer num = this.missionBlockRunTimes;
        return Integer.valueOf(num == null ? 3 : num.intValue());
    }

    public final String getMplistPackageName(Activity activity) {
        if (this.mplist == null) {
            this.mplist = this.MPLIST;
        }
        try {
            for (String str : this.mplist) {
                String b10 = d.b(str);
                if (!l.q(b10) && i.p(activity, b10)) {
                    return b10;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public boolean getNativePay() {
        Boolean bool = this.nativePay;
        return bool == null || bool.booleanValue();
    }

    public int getOptimizeSplashAdEcpm() {
        Integer num = this.optimizeSplashAdEcpm2;
        if (num == null) {
            return 300;
        }
        return num.intValue();
    }

    public String getPhoneInviteShareLink() {
        if (!ConfigSingleton.D().J0()) {
            return this.shareLink;
        }
        return "http://testtf.taoyuewenhua.net/invite/index_tfbook.html?uid=" + MiConfigSingleton.b2().t2() + "&remoteTest=true&package_name=" + MiConfigSingleton.b2().getPackageName() + "&appid=" + MiConfigSingleton.b2().l().f26178a;
    }

    public boolean getPromoteBookOnStart() {
        Boolean bool = this.promoteBookOnStart;
        return bool != null && bool.booleanValue();
    }

    public String getQplayLink() {
        return this.qplayLink;
    }

    public int getReadingAdsInterval() {
        Integer num = this.readingAdsInterval;
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public String getRechargeWxAppid() {
        return this.tfRechargeWxAppidV2;
    }

    public boolean getRemoveVideoAd() {
        Boolean bool = this.removeVideoAd;
        return bool == null || bool.booleanValue();
    }

    public int getRewardVideoAdEnquiryEcpm() {
        Integer num;
        if (MiConfigSingleton.b2().C2() || (num = this.rewardVideoAdEnquiryEcpm) == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getSensorEnableSeconds() {
        Integer num = this.sensorEnableSeconds;
        if (num == null) {
            return 30;
        }
        return num.intValue();
    }

    public int getShakeStyleEcpm() {
        Integer num = this.shakeStyleEcpm;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public boolean getShowComments() {
        Boolean bool = this.showComments;
        return bool == null || bool.booleanValue();
    }

    public Integer getSplashRestartDelay() {
        Integer num = this.splashRestartDelay;
        return Integer.valueOf(num == null ? m2.a.f28273a : num.intValue());
    }

    public Integer getTtsUnlockMinutes() {
        Integer num = this.ttsUnlockMinutes;
        return Integer.valueOf(num == null ? c.f30025o : num.intValue());
    }

    public Boolean getUseWebviewRecharge() {
        Boolean bool = this.useWebviewRecharge;
        return Boolean.valueOf(bool == null || bool.booleanValue());
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

    public Integer getVipAdWeight() {
        Integer num = this.vipAdWeight;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public boolean getWeakBannerButton() {
        if (BaseConfigSingleton.r1().B0()) {
            return true;
        }
        Boolean bool = this.weakBannerButton;
        return bool != null && bool.booleanValue();
    }

    public String getWechatCustomerUrl() {
        return this.wechatCustomerUrl;
    }

    public String getWeixinGroupId() {
        return l.q(this.weixinGroupId) ? "txsmfxsyd" : this.weixinGroupId;
    }

    public String getWithdrawWxAppid() {
        return this.tfWithdrawWxAppidV2;
    }

    public int getWithoutAdMinutes() {
        if (MiConfigSingleton.b2().w0()) {
            return 0;
        }
        Integer num = this.withoutAdMinutes;
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean isAdCompliance() {
        Boolean bool = this.adCompliance;
        return bool == null || bool.booleanValue();
    }

    public void setAdIntervalExtentMinutes(Integer num) {
        this.adIntervalExtentMinutes = num;
    }

    public void setAudioVideoMinutes(Integer num) {
        this.audioVideoMinutes = num;
    }

    public void setAudiobookAdMisClickRate(Integer num) {
        this.audiobookAdMisClickRate = num;
    }

    public void setBannerBqtMisClickBaseEcpmV2(Integer num) {
        this.bannerBqtMisClickBaseEcpmV2 = num;
    }

    public void setBannerCsjMisClickBaseEcpmV2(Integer num) {
        this.bannerCsjMisClickBaseEcpmV2 = num;
    }

    public void setBannerKsMisClickBaseEcpmV2(Integer num) {
        this.bannerKsMisClickBaseEcpmV2 = num;
    }

    public void setBannerMisClickBaseEcpm5(Integer num) {
        this.bannerMisClickBaseEcpm5 = num;
    }

    public void setBannerMisClickBaseRate(Integer num) {
        this.bannerMisClickBaseRate = num;
    }

    public void setBannerMisClickPlatform(Integer num) {
        this.bannerMisClickPlatform = num;
    }

    public void setBannerYlhMisClickBaseEcpmV2(Integer num) {
        this.bannerYlhMisClickBaseEcpmV2 = num;
    }

    public void setBaseIntervalEcpm(Integer num) {
        this.baseIntervalEcpm = num;
    }

    public void setBlockAppNameList(String[] strArr) {
        this.blockAppNameList = strArr;
    }

    public void setCsjAdPauseSeconds(Integer num) {
        this.csjAdPauseSeconds = num;
    }

    public void setEnableVideoCountdown(Boolean bool) {
        this.enableVideoCountdown = bool;
    }

    public void setEnableX1Sdk(Boolean bool) {
        this.enableX1Sdk = bool;
    }

    public void setFlowBqtMisClickBaseEcpmV2(Integer num) {
        this.flowBqtMisClickBaseEcpmV2 = num;
    }

    public void setFlowCsjMisClickBaseEcpmV2(Integer num) {
        this.flowCsjMisClickBaseEcpmV2 = num;
    }

    public void setFlowKsMisClickBaseEcpmV2(Integer num) {
        this.flowKsMisClickBaseEcpmV2 = num;
    }

    public void setFlowMisClickBaseEcpm5(Integer num) {
        this.flowMisClickBaseEcpm5 = num;
    }

    public void setFlowMisClickBaseRate(Integer num) {
        this.flowMisClickBaseRate = num;
    }

    public void setFlowMisClickPlatform(Integer num) {
        this.flowMisClickPlatform = num;
    }

    public void setFlowYlhMisClickBaseEcpmV2(Integer num) {
        this.flowYlhMisClickBaseEcpmV2 = num;
    }

    public void setFreshUserHourInterval(Integer num) {
        this.freshUserHourInterval = num;
    }

    public void setGdtAdPauseSeconds(Integer num) {
        this.gdtAdPauseSeconds = num;
    }

    public void setGromoreAdWeight(Integer num) {
        this.gromoreAdWeight = num;
    }

    public void setGromoreInterstitialAdUserWeight(Integer num) {
        this.gromoreInterstitialAdUserWeight = num;
    }

    public void setGromoreRewardVideoAdUserWeight(Integer num) {
        this.gromoreRewardVideoAdUserWeight = num;
    }

    public void setGromoreSplashAdUserWeight(Integer num) {
        this.gromoreSplashAdUserWeight = num;
    }

    public void setInterstitialAdBaseEcpm(Integer num) {
        this.interstitialAdBaseEcpm = num;
    }

    public void setInterstitialAdBaseInterval(Integer num) {
        this.interstitialAdBaseInterval = num;
    }

    public void setInterstitialAdEnquiryEcpm2(Integer num) {
        this.interstitialAdEnquiryEcpm2 = num;
    }

    public void setInterstitialAdMerge(Boolean bool) {
        this.interstitialAdMerge = bool;
    }

    public void setInterstitialAdMinInterval(Integer num) {
        this.interstitialAdMinInterval = num;
    }

    public void setMaxAdIntervalExtra(Integer num) {
        this.maxAdIntervalExtra = num;
    }

    public void setMaxIntervalEcpm(Integer num) {
        this.maxIntervalEcpm = num;
    }

    public void setMinIntervalSeconds(Integer num) {
        this.minIntervalSeconds = num;
    }

    public void setMisClickExtraBlockSeconds(Integer num) {
        this.misClickExtraBlockSeconds = num;
    }

    public void setMisClickMaxRate(Integer num) {
        this.misClickMaxRate = num;
    }

    public void setMisClickMinSecondsV2(Integer num) {
        this.misClickMinSecondsV2 = num;
    }

    public void setNativePay(Boolean bool) {
        this.nativePay = bool;
    }

    public void setPromoteBookOnStart(Boolean bool) {
        this.promoteBookOnStart = bool;
    }

    public void setRemoveVideoAd(Boolean bool) {
        this.removeVideoAd = bool;
    }

    public void setRewardVideoAdEnquiryEcpm(Integer num) {
        this.rewardVideoAdEnquiryEcpm = num;
    }

    public void setSensorEnableSeconds(int i10) {
        this.sensorEnableSeconds = Integer.valueOf(i10);
    }

    public void setTtsUnlockMinutes(Integer num) {
        this.ttsUnlockMinutes = num;
    }

    public void setWeakBannerButton(Boolean bool) {
        this.weakBannerButton = bool;
    }

    public void setWechatCustomerUrl(String str) {
        this.wechatCustomerUrl = str;
    }

    public void setWithoutAdMinutes(Integer num) {
        this.withoutAdMinutes = num;
    }
}
