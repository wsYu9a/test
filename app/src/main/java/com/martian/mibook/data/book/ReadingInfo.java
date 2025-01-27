package com.martian.mibook.data.book;

import android.app.Activity;
import com.martian.libmars.d.h;
import com.martian.libsupport.f;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ReadingInfo {
    public static final String COUNTER_MENU = "COUNTER_MENU";
    private int adBannerClickGuideInterval;
    private boolean adBook;
    private int adFlowClickGuideInterval;
    private int adInterval;
    private Map<String, Long> chapterIdInfos;
    private Integer clickCount;
    private boolean disableAd;
    private boolean enableAdBlock;
    private boolean enableBaeAdInfo;
    private boolean enableWblAd;
    private boolean firstRead;
    private int fontSize;
    private String intro;
    private MiBook miBook;
    private Integer nComments;
    private String notificationStatus;
    private Integer readingCount;
    private String recContext;
    private String recommend;
    private String recommendId;
    private MiReadingRecord record;
    private int recordRead;
    private Integer score;
    private boolean showChapterComment;
    private int slideIndex;
    private String sourceString;
    private boolean startWithCover;
    private List<String> tagList;
    private int themeIndex;
    private long timeStamp;
    private String typeface;
    private boolean videoAdWatched;
    private boolean fromIntent = false;
    private int interstitial = 0;
    private int videoUnlock = 0;
    private String readingHint = "";
    private int adBannerOptimizeEcpm = 500;
    private int adFlowOptimizeEcpm = 500;
    private int bannerAdInterval = 30000;
    private boolean firstMenu = false;
    private boolean firstTap = false;
    private boolean firstSlide = false;

    public boolean enableBannerAdClickGuide() {
        return this.adBannerClickGuideInterval > 0;
    }

    public boolean enableFlowAdClickGuide() {
        return this.adFlowClickGuideInterval > 0;
    }

    public int getAdBannerClickGuideInterval() {
        return this.adBannerClickGuideInterval;
    }

    public int getAdBannerOptimizeEcpm() {
        return this.adBannerOptimizeEcpm;
    }

    public int getAdFlowClickGuideInterval() {
        return this.adFlowClickGuideInterval;
    }

    public int getAdFlowOptimizeEcpm() {
        return this.adFlowOptimizeEcpm;
    }

    public int getAdInterval() {
        return this.adInterval;
    }

    public int getBannerAdInterval() {
        return this.bannerAdInterval;
    }

    public Map<String, Long> getChapterIdInfos() {
        if (this.chapterIdInfos == null) {
            this.chapterIdInfos = new HashMap();
        }
        return this.chapterIdInfos;
    }

    public Integer getClickCount() {
        return this.clickCount;
    }

    public boolean getFirstRead() {
        if (!this.firstRead) {
            return false;
        }
        this.firstRead = false;
        return true;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public int getInterstitial() {
        return this.interstitial;
    }

    public String getIntro() {
        return this.intro;
    }

    public MiBook getMiBook() {
        return this.miBook;
    }

    public Integer getNComments() {
        return this.nComments;
    }

    public String getNotificationStatus() {
        return this.notificationStatus;
    }

    public Integer getReadingCount() {
        return this.readingCount;
    }

    public String getReadingHint() {
        return this.readingHint;
    }

    public String getRecContext() {
        return this.recContext;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public MiReadingRecord getRecord() {
        return this.record;
    }

    public int getRecordRead() {
        return this.recordRead;
    }

    public Integer getScore() {
        return this.score;
    }

    public int getSlideIndex() {
        return this.slideIndex;
    }

    public String getSourceString() {
        return this.sourceString;
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public int getThemeIndex() {
        return this.themeIndex;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getTypeface() {
        return this.typeface;
    }

    public int getVideoUnlock() {
        int i2 = this.videoUnlock;
        if (i2 < 10) {
            return 0;
        }
        return i2;
    }

    public void initReadingSetting(Activity activity) {
        setThemeIndex(MiConfigSingleton.V3().J4.s());
        setSlideIndex(MiConfigSingleton.V3().m4());
        setFontSize(MiConfigSingleton.V3().H3());
        setTypeface(MiConfigSingleton.V3().A4());
        setNotificationStatus(f.d(activity) ? "开启" : "关闭");
        setDisableAd(MiConfigSingleton.V3().h6());
        if (MiConfigSingleton.V3().L0("first_guide")) {
            setFirstMenu(true);
            setFirstTap(true);
        }
        if (!h.F().H("first_slide")) {
            setFirstSlide(true);
        }
        if (!MiConfigSingleton.V3().j5()) {
            setAdFlowClickGuideInterval(MiConfigSingleton.V3().W3().getAdFlowClickGuideIntervalV2());
            setAdBannerClickGuideInterval(MiConfigSingleton.V3().W3().getAdBannerClickGuideIntervalV2());
        }
        setAdBannerOptimizeEcpm(MiConfigSingleton.V3().W3().getBannerOptimizeFirstEcpm());
        setAdFlowOptimizeEcpm(MiConfigSingleton.V3().W3().getFlowOptimizeEcpm());
        setAdInterval(MiConfigSingleton.V3().W3().getFreeReadingAdsInterval().intValue());
        setShowChapterComment(!MiConfigSingleton.V3().j5() && MiConfigSingleton.V3().C8());
        setBannerAdInterval(MiConfigSingleton.V3().W3().getBannerAdInterval().intValue() * 1000);
        setVideoAdWatched(MiConfigSingleton.V3().x8() && !MiConfigSingleton.V3().h6());
        setEnableAdBlock(MiConfigSingleton.V3().W3().getEnableAdBlock2());
        setEnableBaeAdInfo(MiConfigSingleton.V3().W3().getEnableBaeAdInfo());
    }

    public boolean isAdBook() {
        return this.adBook;
    }

    public boolean isDisableAd() {
        return this.disableAd;
    }

    public boolean isEnableAdBlock() {
        return this.enableAdBlock;
    }

    public boolean isEnableBaeAdInfo() {
        return this.enableBaeAdInfo;
    }

    public boolean isEnableWblAd() {
        return this.enableWblAd;
    }

    public boolean isFirstMenu() {
        return this.firstMenu;
    }

    public boolean isFirstSlide() {
        return this.firstSlide;
    }

    public boolean isFirstTap() {
        return this.firstTap;
    }

    public boolean isFromIntent() {
        return this.fromIntent;
    }

    public boolean isShowChapterComment() {
        return this.showChapterComment;
    }

    public boolean isStartWithCover() {
        return this.startWithCover;
    }

    public boolean isTtsMode() {
        return MiConfigSingleton.V3().H4.f(this.sourceString);
    }

    public boolean isVideoAdWatched() {
        return this.videoAdWatched;
    }

    public boolean needRecordRead() {
        return this.recordRead > 0;
    }

    public void setAdBannerClickGuideInterval(int adBannerClickGuideInterval) {
        this.adBannerClickGuideInterval = adBannerClickGuideInterval;
    }

    public void setAdBannerOptimizeEcpm(int adBannerOptimizeEcpm) {
        this.adBannerOptimizeEcpm = adBannerOptimizeEcpm;
    }

    public void setAdBook(boolean adBook) {
        this.adBook = adBook;
    }

    public void setAdFlowClickGuideInterval(int adFlowClickGuideInterval) {
        this.adFlowClickGuideInterval = adFlowClickGuideInterval;
    }

    public void setAdFlowOptimizeEcpm(int adFlowOptimizeEcpm) {
        this.adFlowOptimizeEcpm = adFlowOptimizeEcpm;
    }

    public void setAdInterval(int adInterval) {
        this.adInterval = adInterval;
    }

    public void setBannerAdInterval(int bannerAdInterval) {
        this.bannerAdInterval = bannerAdInterval;
    }

    public void setChapterIdInfos(Map<String, Long> chapterIdInfos) {
        this.chapterIdInfos = chapterIdInfos;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public void setDisableAd(boolean disableAd) {
        this.disableAd = disableAd;
    }

    public void setEnableAdBlock(boolean enableAdBlock) {
        this.enableAdBlock = enableAdBlock;
    }

    public void setEnableBaeAdInfo(boolean enableBaeAdInfo) {
        this.enableBaeAdInfo = enableBaeAdInfo;
    }

    public void setEnableWblAd(boolean enableWblAd) {
        this.enableWblAd = enableWblAd;
    }

    public void setFirstMenu(boolean firstMenu) {
        this.firstMenu = firstMenu;
    }

    public void setFirstRead(boolean firstRead) {
        this.firstRead = firstRead;
    }

    public void setFirstSlide(boolean firstSlide) {
        this.firstSlide = firstSlide;
    }

    public void setFirstTap(boolean firstTap) {
        this.firstTap = firstTap;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setFromIntent(boolean fromIntent) {
        this.fromIntent = fromIntent;
    }

    public void setInterstitial(int interstitial) {
        this.interstitial = interstitial;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setMiBook(MiBook miBook) {
        this.miBook = miBook;
    }

    public void setNComments(Integer nComments) {
        this.nComments = nComments;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }

    public void setReadingHint(String readingHint) {
        this.readingHint = readingHint;
    }

    public void setRecContext(String recContext) {
        this.recContext = recContext;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public void setRecord(MiReadingRecord record) {
        this.record = record;
    }

    public void setRecordRead(int recordRead) {
        this.recordRead = recordRead;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setShowChapterComment(boolean show) {
        this.showChapterComment = show;
    }

    public void setSlideIndex(int slideIndex) {
        this.slideIndex = slideIndex;
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }

    public void setStartWithCover(boolean startWithCover) {
        this.startWithCover = startWithCover;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public void setThemeIndex(int themeIndex) {
        this.themeIndex = themeIndex;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTypeface(String typeface) {
        this.typeface = typeface;
    }

    public void setVideoAdWatched(boolean videoAdWatched) {
        this.videoAdWatched = videoAdWatched;
    }

    public void setVideoUnlock(int videoUnlock) {
        this.videoUnlock = videoUnlock;
    }

    public boolean shouldHideAd() {
        return isDisableAd() || isVideoAdWatched() || MiConfigSingleton.V3().x8();
    }

    public BookInfoActivity.o toBookInfo() {
        return new BookInfoActivity.o().E(this.recommend).F(this.recommendId).w(this.recContext);
    }
}
