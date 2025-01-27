package cn.vlion.ad.inland.base.javabean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class VlionServiceConfig implements Serializable {
    private List<AutoBean> autos;
    private String cfgVer;
    private int code;
    private long current;
    private String data;
    private DataBean dataBean;
    private String gray;
    private String message;
    private String trace;
    private int ttl;

    public static class AutoBean implements Serializable {
        private String adgroupid;
        private String bundle;
        private List<String> clkTrackers;
        private String dp;
        private float dropRate;
        private ExpBean exp;
        private boolean needClickPatch;
        private String pid;
        private int ver;

        public String getAdgroupid() {
            return this.adgroupid;
        }

        public String getBundle() {
            return this.bundle;
        }

        public List<String> getClkTrackers() {
            return this.clkTrackers;
        }

        public String getDp() {
            return this.dp;
        }

        public float getDropRate() {
            return this.dropRate;
        }

        public ExpBean getExp() {
            return this.exp;
        }

        public String getPid() {
            return this.pid;
        }

        public int getVer() {
            return this.ver;
        }

        public boolean isNeedClickPatch() {
            return this.needClickPatch;
        }

        public void setAdgroupid(String str) {
            this.adgroupid = str;
        }

        public void setBundle(String str) {
            this.bundle = str;
        }

        public void setClkTrackers(List<String> list) {
            this.clkTrackers = list;
        }

        public void setDp(String str) {
            this.dp = str;
        }

        public void setDropRate(float f10) {
            this.dropRate = f10;
        }

        public void setExp(ExpBean expBean) {
            this.exp = expBean;
        }

        public void setNeedClickPatch(boolean z10) {
            this.needClickPatch = z10;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setVer(int i10) {
            this.ver = i10;
        }
    }

    public static class DataBean implements Serializable {
        private List<ActiveStrategyBean> activeStrategy;
        private List<ActivityTemplateBean> activityTemplate;

        /* renamed from: ad, reason: collision with root package name */
        private AdBean f3001ad;
        private AdminBean admin;
        private AutoAttributionBean autoAttribution;
        private EventsBean events;
        private String report;
        private String reportv2;
        private List<TemplatesBean> templates;

        public static class ActiveStrategyBean implements Serializable {

            /* renamed from: id, reason: collision with root package name */
            private int f3002id;
            private int isActive;
            private int isInstall;
            private String packageName;

            public String getId() {
                return String.valueOf(this.f3002id);
            }

            public int getIsActive() {
                return this.isActive;
            }

            public int getIsInstall() {
                return this.isInstall;
            }

            public String getPackageName() {
                return this.packageName;
            }

            public void setId(int i10) {
                this.f3002id = i10;
            }

            public void setIsActive(int i10) {
                this.isActive = i10;
            }

            public void setIsInstall(int i10) {
                this.isInstall = i10;
            }

            public void setPackageName(String str) {
                this.packageName = str;
            }
        }

        public static class ActivityTemplateBean implements Serializable {
            private List<ConfigBean> config;
            private int imp_limit;
            private String material_url;
            private int type;

            public static class ConfigBean implements Serializable {
                private List<String> templateId;
                private int type;

                public List<String> getTemplateId() {
                    return this.templateId;
                }

                public int getType() {
                    return this.type;
                }

                public void setTemplateId(List<String> list) {
                    this.templateId = list;
                }

                public void setType(int i10) {
                    this.type = i10;
                }
            }

            public List<ConfigBean> getConfig() {
                return this.config;
            }

            public int getImp_limit() {
                return this.imp_limit;
            }

            public String getMaterial_url() {
                return this.material_url;
            }

            public int getType() {
                return this.type;
            }

            public void setConfig(List<ConfigBean> list) {
                this.config = list;
            }

            public void setImp_limit(int i10) {
                this.imp_limit = i10;
            }

            public void setMaterial_url(String str) {
                this.material_url = str;
            }

            public void setType(int i10) {
                this.type = i10;
            }
        }

        public static class AdBean implements Serializable {
            private List<PlacementBean> placement;

            public static class PlacementBean implements Serializable {
                private int adType;
                private int autoClose;
                private int autoJump;
                private int autoJumpPercent;
                private int autoJumpSec;
                private int autoJumpTime;
                private int autoPlay;
                private int cacheNum;
                private int cacheTime;
                private int clickBackPercent = 100;
                private int closeSec;
                private String creativeType;
                private String interactiveType;
                private Boolean isBiding;
                private int playMode;
                private int price;
                private String randerType;
                private int retainWin;
                private int screenType;
                private int secondPop;
                private int shakeRange;
                private String showId;
                private int skipSec;
                private List<SourcesBean> sources;
                private String style;
                private int swipeRange;
                private List<TemplateConfigBean> templateConfig;
                private String templateType;
                private int twistRange;
                private int videoVoice;

                public static class SourcesBean implements Serializable {
                    private int bidfloor;
                    private ConfigBean config;
                    private FrequencyStrategyBean frequencyStrategy;

                    /* renamed from: id, reason: collision with root package name */
                    private long f3003id;
                    private String platformAccount;
                    private String platformName;
                    private float shareRatio;

                    public static class ConfigBean implements Serializable {
                        private int accelerate;
                        private int adSourceType;
                        private int angle;
                        private String app_id;
                        private String app_key;
                        private String app_secret;
                        private Boolean is_bid;
                        private int shakeDuration;
                        private String tag_id;
                        private String type;

                        public int getAccelerate() {
                            return this.accelerate;
                        }

                        public int getAdSourceType() {
                            return this.adSourceType;
                        }

                        public int getAngle() {
                            return this.angle;
                        }

                        public String getApp_id() {
                            return this.app_id;
                        }

                        public String getApp_key() {
                            return this.app_key;
                        }

                        public String getApp_secret() {
                            return this.app_secret;
                        }

                        public Boolean getIs_bid() {
                            return this.is_bid;
                        }

                        public int getShakeDuration() {
                            return this.shakeDuration;
                        }

                        public String getTag_id() {
                            return this.tag_id;
                        }

                        public String getType() {
                            return this.type;
                        }

                        public void setAccelerate(int i10) {
                            this.accelerate = i10;
                        }

                        public void setAdSourceType(int i10) {
                            this.adSourceType = i10;
                        }

                        public void setAngle(int i10) {
                            this.angle = i10;
                        }

                        public void setApp_id(String str) {
                            this.app_id = str;
                        }

                        public void setApp_key(String str) {
                            this.app_key = str;
                        }

                        public void setApp_secret(String str) {
                            this.app_secret = str;
                        }

                        public void setIs_bid(Boolean bool) {
                            this.is_bid = bool;
                        }

                        public void setShakeDuration(int i10) {
                            this.shakeDuration = i10;
                        }

                        public void setTag_id(String str) {
                            this.tag_id = str;
                        }

                        public void setType(String str) {
                            this.type = str;
                        }
                    }

                    public static class FrequencyStrategyBean implements Serializable {
                        private int limitNum;
                        private int timeSpan;

                        public int getLimitNum() {
                            return this.limitNum;
                        }

                        public int getTimeSpan() {
                            return this.timeSpan;
                        }

                        public void setLimitNum(int i10) {
                            this.limitNum = i10;
                        }

                        public void setTimeSpan(int i10) {
                            this.timeSpan = i10;
                        }
                    }

                    public int getBidfloor() {
                        return this.bidfloor;
                    }

                    public ConfigBean getConfig() {
                        return this.config;
                    }

                    public FrequencyStrategyBean getFrequencyStrategy() {
                        return this.frequencyStrategy;
                    }

                    public long getId() {
                        return this.f3003id;
                    }

                    public String getPlatformAccount() {
                        return this.platformAccount;
                    }

                    public String getPlatformName() {
                        return this.platformName;
                    }

                    public float getShareRatio() {
                        return this.shareRatio;
                    }

                    public void setBidfloor(int i10) {
                        this.bidfloor = i10;
                    }

                    public void setConfig(ConfigBean configBean) {
                        this.config = configBean;
                    }

                    public void setFrequencyStrategy(FrequencyStrategyBean frequencyStrategyBean) {
                    }

                    public void setId(long j10) {
                        this.f3003id = j10;
                    }

                    public void setPlatformAccount(String str) {
                        this.platformAccount = str;
                    }

                    public void setPlatformName(String str) {
                        this.platformName = str;
                    }

                    public void setShareRatio(float f10) {
                        this.shareRatio = f10;
                    }
                }

                public static class TemplateConfigBean implements Serializable {

                    /* renamed from: id, reason: collision with root package name */
                    private int f3004id;
                    private int weight;

                    public int getId() {
                        return this.f3004id;
                    }

                    public int getWeight() {
                        return this.weight;
                    }

                    public void setId(int i10) {
                        this.f3004id = i10;
                    }

                    public void setWeight(int i10) {
                        this.weight = i10;
                    }
                }

                public int getAdType() {
                    return this.adType;
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

                public int getCacheNum() {
                    return this.cacheNum;
                }

                public int getCacheTime() {
                    return this.cacheTime;
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

                public String getInteractiveType() {
                    return this.interactiveType;
                }

                public Boolean getIsBiding() {
                    return this.isBiding;
                }

                public int getPlayMode() {
                    return this.playMode;
                }

                public int getPrice() {
                    return this.price;
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

                public int getSecondPop() {
                    return this.secondPop;
                }

                public int getShakeRange() {
                    return this.shakeRange;
                }

                public String getShowId() {
                    return this.showId;
                }

                public int getSkipSec() {
                    return this.skipSec;
                }

                public List<SourcesBean> getSources() {
                    return this.sources;
                }

                public String getStyle() {
                    return this.style;
                }

                public int getSwipeRange() {
                    return this.swipeRange;
                }

                public List<TemplateConfigBean> getTemplateConfig() {
                    return this.templateConfig;
                }

                public String getTemplateType() {
                    return this.templateType;
                }

                public int getTwistRange() {
                    return this.twistRange;
                }

                public int getVideoVoice() {
                    return this.videoVoice;
                }

                public void setAdType(int i10) {
                    this.adType = i10;
                }

                public void setAutoClose(int i10) {
                    this.autoClose = i10;
                }

                public void setAutoJump(int i10) {
                    this.autoJump = i10;
                }

                public void setAutoJumpPercent(int i10) {
                    this.autoJumpPercent = i10;
                }

                public void setAutoJumpSec(int i10) {
                    this.autoJumpSec = i10;
                }

                public void setAutoJumpTime(int i10) {
                    this.autoJumpTime = i10;
                }

                public void setAutoPlay(int i10) {
                    this.autoPlay = i10;
                }

                public void setCacheNum(int i10) {
                    this.cacheNum = i10;
                }

                public void setCacheTime(int i10) {
                    this.cacheTime = i10;
                }

                public void setClickBackPercent(int i10) {
                    this.clickBackPercent = i10;
                }

                public void setCloseSec(int i10) {
                    this.closeSec = i10;
                }

                public void setCreativeType(String str) {
                    this.creativeType = str;
                }

                public void setInteractiveType(String str) {
                    this.interactiveType = str;
                }

                public void setIsBiding(Boolean bool) {
                    this.isBiding = bool;
                }

                public void setPlayMode(int i10) {
                    this.playMode = i10;
                }

                public void setPrice(int i10) {
                    this.price = i10;
                }

                public void setRanderType(String str) {
                    this.randerType = str;
                }

                public void setRetainWin(int i10) {
                    this.retainWin = i10;
                }

                public void setScreenType(int i10) {
                    this.screenType = i10;
                }

                public void setSecondPop(int i10) {
                    this.secondPop = i10;
                }

                public void setShakeRange(int i10) {
                    this.shakeRange = i10;
                }

                public void setShowId(String str) {
                    this.showId = str;
                }

                public void setSkipSec(int i10) {
                    this.skipSec = i10;
                }

                public void setSources(List<SourcesBean> list) {
                    this.sources = list;
                }

                public void setStyle(String str) {
                    this.style = str;
                }

                public void setSwipeRange(int i10) {
                    this.swipeRange = i10;
                }

                public void setTemplateConfig(List<TemplateConfigBean> list) {
                    this.templateConfig = list;
                }

                public void setTemplateType(String str) {
                    this.templateType = str;
                }

                public void setTwistRange(int i10) {
                    this.twistRange = i10;
                }

                public void setVideoVoice(int i10) {
                    this.videoVoice = i10;
                }
            }

            public List<PlacementBean> getPlacement() {
                return this.placement;
            }

            public void setPlacement(List<PlacementBean> list) {
                this.placement = list;
            }
        }

        public static class AdminBean implements Serializable {
            private int adxExpireTime;
            private int backgroundTickTime;
            private int cacheStatus;
            private int cacheTime;
            private List<String> checkInstalledPackageList;
            private int collectInstalledPackage;
            private int deeplinkTimes;
            private int gdtInit;
            private int isHotspot;
            private int isWxSdk;
            private int kdInit;
            private int ksInit;
            private int refreshConfigTime;
            private int refreshGeoTime;
            private int sampleRadio;
            private String wxAppId;

            public int getAdxExpireTime() {
                return this.adxExpireTime;
            }

            public int getBackgroundTickTime() {
                return this.backgroundTickTime;
            }

            public int getCacheStatus() {
                return this.cacheStatus;
            }

            public int getCacheTime() {
                return this.cacheTime;
            }

            public List<String> getCheckInstalledPackageList() {
                return this.checkInstalledPackageList;
            }

            public int getCollectInstalledPackage() {
                return this.collectInstalledPackage;
            }

            public int getDeeplinkTimes() {
                return this.deeplinkTimes;
            }

            public int getGdtInit() {
                return this.gdtInit;
            }

            public int getIsHotspot() {
                return this.isHotspot;
            }

            public int getIsWxSdk() {
                return this.isWxSdk;
            }

            public int getKdInit() {
                return this.kdInit;
            }

            public int getKsInit() {
                return this.ksInit;
            }

            public int getRefreshConfigTime() {
                return this.refreshConfigTime;
            }

            public int getRefreshGeoTime() {
                return this.refreshGeoTime;
            }

            public int getSampleRadio() {
                return this.sampleRadio;
            }

            public String getWxAppId() {
                return this.wxAppId;
            }

            public void setAdxExpireTime(int i10) {
                this.adxExpireTime = i10;
            }

            public void setBackgroundTickTime(int i10) {
                this.backgroundTickTime = i10;
            }

            public void setCacheStatus(int i10) {
                this.cacheStatus = i10;
            }

            public void setCacheTime(int i10) {
                this.cacheTime = i10;
            }

            public void setCheckInstalledPackageList(List<String> list) {
                this.checkInstalledPackageList = list;
            }

            public void setCollectInstalledPackage(int i10) {
                this.collectInstalledPackage = i10;
            }

            public void setDeeplinkTimes(int i10) {
                this.deeplinkTimes = i10;
            }

            public void setIsHotspot(int i10) {
                this.isHotspot = i10;
            }

            public void setIsWxSdk(int i10) {
                this.isWxSdk = i10;
            }

            public void setKdInit(int i10) {
                this.kdInit = i10;
            }

            public void setRefreshConfigTime(int i10) {
                this.refreshConfigTime = i10;
            }

            public void setRefreshGeoTime(int i10) {
                this.refreshGeoTime = i10;
            }

            public void setSampleRadio(int i10) {
                this.sampleRadio = i10;
            }

            public void setWxAppId(String str) {
                this.wxAppId = str;
            }
        }

        public static class AutoAttributionBean implements Serializable {
            private int adjacentIntervalsMax;
            private int adjacentIntervalsMin;
            private int excludeInstalled;
            private List<String> excludeListenMedia;
            private ListenSwitchBean listenSwitch;
            private int rtaCacheTime;
            private int userClkLimit;

            public int getAdjacentIntervalsMax() {
                return this.adjacentIntervalsMax;
            }

            public int getAdjacentIntervalsMin() {
                return this.adjacentIntervalsMin;
            }

            public int getExcludeInstalled() {
                return this.excludeInstalled;
            }

            public List<String> getExcludeListenMedia() {
                return this.excludeListenMedia;
            }

            public ListenSwitchBean getListenSwitch() {
                return this.listenSwitch;
            }

            public int getRtaCacheTime() {
                return this.rtaCacheTime;
            }

            public int getUserClkLimit() {
                return this.userClkLimit;
            }

            public void setAdjacentIntervalsMax(int i10) {
                this.adjacentIntervalsMax = i10;
            }

            public void setAdjacentIntervalsMin(int i10) {
                this.adjacentIntervalsMin = i10;
            }

            public void setExcludeInstalled(int i10) {
                this.excludeInstalled = i10;
            }

            public void setExcludeListenMedia(List<String> list) {
                this.excludeListenMedia = list;
            }

            public void setListenSwitch(ListenSwitchBean listenSwitchBean) {
                this.listenSwitch = listenSwitchBean;
            }

            public void setRtaCacheTime(int i10) {
                this.rtaCacheTime = i10;
            }

            public void setUserClkLimit(int i10) {
                this.userClkLimit = i10;
            }
        }

        public static class EventsBean implements Serializable {
            private String adBid;
            private String adClk;
            private String adClose;
            private String adDpcheck;
            private String adEnter;
            private String adFill;
            private String adImp;
            private String adRender;
            private String adReq;
            private String adShow;
            private String adSkip;
            private String adTrigger;
            private String daClickCb;
            private String daDeeplink;
            private String daInstallCb;
            private String daShow;
            private String daUninstallCb;
            private String daUpdateCb;
            private String dwCancel;
            private String dwComplete;
            private String dwContinue;
            private String dwInstall;
            private String dwInstalled;
            private String dwPause;
            private String dwProgress;
            private String dwStart;
            private String dwStorage;
            private String frontback;
            private String netResp;
            private String report;
            private String start;

            public String getAdBid() {
                return this.adBid;
            }

            public String getAdClk() {
                return this.adClk;
            }

            public String getAdClose() {
                return this.adClose;
            }

            public String getAdDpcheck() {
                return this.adDpcheck;
            }

            public String getAdEnter() {
                return this.adEnter;
            }

            public String getAdFill() {
                return this.adFill;
            }

            public String getAdImp() {
                return this.adImp;
            }

            public String getAdRender() {
                return this.adRender;
            }

            public String getAdReq() {
                return this.adReq;
            }

            public String getAdShow() {
                return this.adShow;
            }

            public String getAdSkip() {
                return this.adSkip;
            }

            public String getAdTrigger() {
                return this.adTrigger;
            }

            public String getDaClickCb() {
                return this.daClickCb;
            }

            public String getDaDeeplink() {
                return this.daDeeplink;
            }

            public String getDaInstallCb() {
                return this.daInstallCb;
            }

            public String getDaShow() {
                return this.daShow;
            }

            public String getDaUninstallCb() {
                return this.daUninstallCb;
            }

            public String getDaUpdateCb() {
                return this.daUpdateCb;
            }

            public String getDwCancel() {
                return this.dwCancel;
            }

            public String getDwComplete() {
                return this.dwComplete;
            }

            public String getDwContinue() {
                return this.dwContinue;
            }

            public String getDwInstall() {
                return this.dwInstall;
            }

            public String getDwInstalled() {
                return this.dwInstalled;
            }

            public String getDwPause() {
                return this.dwPause;
            }

            public String getDwProgress() {
                return this.dwProgress;
            }

            public String getDwStart() {
                return this.dwStart;
            }

            public String getDwStorage() {
                return this.dwStorage;
            }

            public String getFrontback() {
                return this.frontback;
            }

            public String getNetResp() {
                return this.netResp;
            }

            public String getReport() {
                return this.report;
            }

            public String getStart() {
                return this.start;
            }

            public void setAdBid(String str) {
                this.adBid = str;
            }

            public void setAdClk(String str) {
                this.adClk = str;
            }

            public void setAdClose(String str) {
                this.adClose = str;
            }

            public void setAdDpcheck(String str) {
                this.adDpcheck = str;
            }

            public void setAdEnter(String str) {
                this.adEnter = str;
            }

            public void setAdFill(String str) {
                this.adFill = str;
            }

            public void setAdImp(String str) {
                this.adImp = str;
            }

            public void setAdRender(String str) {
                this.adRender = str;
            }

            public void setAdReq(String str) {
                this.adReq = str;
            }

            public void setAdShow(String str) {
                this.adShow = str;
            }

            public void setAdSkip(String str) {
                this.adSkip = str;
            }

            public void setAdTrigger(String str) {
                this.adTrigger = str;
            }

            public void setDaClickCb(String str) {
                this.daClickCb = str;
            }

            public void setDaDeeplink(String str) {
                this.daDeeplink = str;
            }

            public void setDaInstallCb(String str) {
                this.daInstallCb = str;
            }

            public void setDaShow(String str) {
                this.daShow = str;
            }

            public void setDaUninstallCb(String str) {
                this.daUninstallCb = str;
            }

            public void setDaUpdateCb(String str) {
                this.daUpdateCb = str;
            }

            public void setDwCancel(String str) {
                this.dwCancel = str;
            }

            public void setDwComplete(String str) {
                this.dwComplete = str;
            }

            public void setDwContinue(String str) {
                this.dwContinue = str;
            }

            public void setDwInstall(String str) {
                this.dwInstall = str;
            }

            public void setDwInstalled(String str) {
                this.dwInstalled = str;
            }

            public void setDwPause(String str) {
                this.dwPause = str;
            }

            public void setDwProgress(String str) {
                this.dwProgress = str;
            }

            public void setDwStart(String str) {
                this.dwStart = str;
            }

            public void setDwStorage(String str) {
                this.dwStorage = str;
            }

            public void setFrontback(String str) {
                this.frontback = str;
            }

            public void setNetResp(String str) {
                this.netResp = str;
            }

            public void setReport(String str) {
                this.report = str;
            }

            public void setStart(String str) {
                this.start = str;
            }
        }

        public static class ListenSwitchBean implements Serializable {
            private int installed = 0;
            private int updated = 0;
            private int removed = 0;

            public int getInstalled() {
                return this.installed;
            }

            public int getRemoved() {
                return this.removed;
            }

            public int getUpdated() {
                return this.updated;
            }

            public void setInstalled(int i10) {
                this.installed = i10;
            }

            public void setRemoved(int i10) {
                this.removed = i10;
            }

            public void setUpdated(int i10) {
                this.updated = i10;
            }
        }

        public static class TemplatesBean implements Serializable {
            private ClosePopupBean close_popup;
            private ConfirmPopupBean confirm_popup;
            private EndcardBean endcard;

            /* renamed from: id, reason: collision with root package name */
            private int f3005id;
            private MainBean main;

            public static class ClosePopupBean implements Serializable {
                private String style;

                public String getStyle() {
                    return this.style;
                }

                public void setStyle(String str) {
                    this.style = str;
                }
            }

            public static class ConfirmPopupBean implements Serializable {
                private String style;

                public String getStyle() {
                    return this.style;
                }

                public void setStyle(String str) {
                    this.style = str;
                }
            }

            public static class EndcardBean implements Serializable {
                private String style;

                public String getStyle() {
                    return this.style;
                }

                public void setStyle(String str) {
                    this.style = str;
                }
            }

            public static class MainBean implements Serializable {
                private int auto_redirect;
                private int close_radio;
                private String close_text;
                private int hotspot;
                private int is_circulation = 0;
                private int max_sec;
                private int sound;
                private String style;

                public int getAuto_redirect() {
                    return this.auto_redirect;
                }

                public int getClose_radio() {
                    return this.close_radio;
                }

                public String getClose_text() {
                    return this.close_text;
                }

                public int getHotspot() {
                    return this.hotspot;
                }

                public int getIs_circulation() {
                    return this.is_circulation;
                }

                public int getMax_sec() {
                    return this.max_sec;
                }

                public int getSound() {
                    return this.sound;
                }

                public String getStyle() {
                    return this.style;
                }

                public void setAuto_redirect(int i10) {
                    this.auto_redirect = i10;
                }

                public void setClose_radio(int i10) {
                    this.close_radio = i10;
                }

                public void setClose_text(String str) {
                    this.close_text = str;
                }

                public void setHotspot(int i10) {
                    this.hotspot = i10;
                }

                public void setIs_circulation(int i10) {
                    this.is_circulation = i10;
                }

                public void setMax_sec(int i10) {
                    this.max_sec = i10;
                }

                public void setSound(int i10) {
                    this.sound = i10;
                }

                public void setStyle(String str) {
                    this.style = str;
                }
            }

            public ClosePopupBean getClose_popup() {
                return this.close_popup;
            }

            public ConfirmPopupBean getConfirm_popup() {
                return this.confirm_popup;
            }

            public EndcardBean getEndcard() {
                return this.endcard;
            }

            public int getId() {
                return this.f3005id;
            }

            public MainBean getMain() {
                return this.main;
            }

            public void setClose_popup(ClosePopupBean closePopupBean) {
                this.close_popup = closePopupBean;
            }

            public void setConfirm_popup(ConfirmPopupBean confirmPopupBean) {
                this.confirm_popup = confirmPopupBean;
            }

            public void setEndcard(EndcardBean endcardBean) {
                this.endcard = endcardBean;
            }

            public void setId(int i10) {
                this.f3005id = i10;
            }

            public void setMain(MainBean mainBean) {
                this.main = mainBean;
            }
        }

        public List<ActiveStrategyBean> getActiveStrategy() {
            return this.activeStrategy;
        }

        public List<ActivityTemplateBean> getActivityTemplate() {
            return this.activityTemplate;
        }

        public AdBean getAd() {
            return this.f3001ad;
        }

        public AdminBean getAdmin() {
            return this.admin;
        }

        public AutoAttributionBean getAutoAttribution() {
            return this.autoAttribution;
        }

        public EventsBean getEvents() {
            return this.events;
        }

        public String getReport() {
            return this.report;
        }

        public String getReportv2() {
            return this.reportv2;
        }

        public List<TemplatesBean> getTemplates() {
            return this.templates;
        }

        public void setActiveStrategy(List<ActiveStrategyBean> list) {
            this.activeStrategy = list;
        }

        public void setActivityTemplate(List<ActivityTemplateBean> list) {
            this.activityTemplate = list;
        }

        public void setAd(AdBean adBean) {
            this.f3001ad = adBean;
        }

        public void setAdmin(AdminBean adminBean) {
            this.admin = adminBean;
        }

        public void setAutoAttribution(AutoAttributionBean autoAttributionBean) {
            this.autoAttribution = autoAttributionBean;
        }

        public void setEvents(EventsBean eventsBean) {
            this.events = eventsBean;
        }

        public void setReport(String str) {
            this.report = str;
        }

        public void setReportv2(String str) {
            this.reportv2 = str;
        }

        public void setTemplates(List<TemplatesBean> list) {
            this.templates = list;
        }
    }

    public static class ExpBean implements Serializable {
        private ArrayList<ScenesBean> scenes;
        private String type;

        public ArrayList<ScenesBean> getScenes() {
            return this.scenes;
        }

        public String getType() {
            return this.type;
        }

        public void setScenes(ArrayList<ScenesBean> arrayList) {
            this.scenes = arrayList;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public static class ScenesBean implements Serializable {
        private float cDropRate;
        private ArrayList<Integer> curlDayTimes;
        private ArrayList<Integer> curlDelay;
        private ArrayList<Integer> dpDelay;
        private float dpOpenRatio;
        private int dpSwitch;
        private int filterinstalled;

        /* renamed from: id, reason: collision with root package name */
        private int f3006id;
        private int needRta;
        private float sDropRate;
        private ArrayList<Integer> surlDayTimes;
        private ArrayList<Integer> surlDelay;

        public int getCurlDayTimes() {
            return getIntegerValue(this.curlDayTimes, 1);
        }

        public int getCurlDelay() {
            return getIntegerValue(this.curlDelay, 10);
        }

        public int getDpDelay() {
            return getIntegerValue(this.dpDelay, 10);
        }

        public float getDpOpenRatio() {
            return this.dpOpenRatio;
        }

        public int getDpSwitch() {
            return this.dpSwitch;
        }

        public int getFilterinstalled() {
            return this.filterinstalled;
        }

        public int getId() {
            return this.f3006id;
        }

        public int getIntegerValue(ArrayList<Integer> arrayList, int i10) {
            if (arrayList == null) {
                return i10;
            }
            try {
                return arrayList.size() > 1 ? new Random().nextInt(arrayList.get(1).intValue() - arrayList.get(0).intValue()) + arrayList.get(0).intValue() : i10;
            } catch (Throwable unused) {
                return i10;
            }
        }

        public int getNeedRta() {
            return this.needRta;
        }

        public int getSurlDayTimes() {
            return getIntegerValue(this.surlDayTimes, 1);
        }

        public int getSurlDelay() {
            return getIntegerValue(this.surlDelay, 10);
        }

        public float getcDropRate() {
            return this.cDropRate;
        }

        public float getsDropRate() {
            return this.sDropRate;
        }

        public void setCurlDayTimes(ArrayList<Integer> arrayList) {
            this.curlDayTimes = arrayList;
        }

        public void setCurlDelay(ArrayList<Integer> arrayList) {
            this.curlDelay = arrayList;
        }

        public void setDpDelay(ArrayList<Integer> arrayList) {
            this.dpDelay = arrayList;
        }

        public void setDpOpenRatio(float f10) {
            this.dpOpenRatio = f10;
        }

        public void setDpSwitch(int i10) {
            this.dpSwitch = i10;
        }

        public void setFilterinstalled(int i10) {
            this.filterinstalled = i10;
        }

        public void setId(int i10) {
            this.f3006id = i10;
        }

        public void setNeedRta(int i10) {
            this.needRta = i10;
        }

        public void setSurlDayTimes(ArrayList<Integer> arrayList) {
            this.surlDayTimes = arrayList;
        }

        public void setSurlDelay(ArrayList<Integer> arrayList) {
            this.surlDelay = arrayList;
        }

        public void setcDropRate(float f10) {
            this.cDropRate = f10;
        }

        public void setsDropRate(float f10) {
            this.sDropRate = f10;
        }
    }

    public List<AutoBean> getAutos() {
        return this.autos;
    }

    public String getCfgVer() {
        return this.cfgVer;
    }

    public int getCode() {
        return this.code;
    }

    public long getCurrent() {
        return this.current;
    }

    public String getData() {
        return this.data;
    }

    public DataBean getDataBean() {
        return this.dataBean;
    }

    public String getGray() {
        return this.gray;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTrace() {
        return this.trace;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setAutos(List<AutoBean> list) {
        this.autos = list;
    }

    public void setCfgVer(String str) {
        this.cfgVer = str;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setCurrent(long j10) {
        this.current = j10;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public void setGray(String str) {
        this.gray = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setTrace(String str) {
        this.trace = str;
    }

    public void setTtl(int i10) {
        this.ttl = i10;
    }
}
