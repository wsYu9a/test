package cn.vlion.ad.inland.base.javabean;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionAdLimitStrategyBean;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.p6;
import cn.vlion.ad.inland.base.util.StrategysIdUtils;
import cn.vlion.ad.inland.base.util.VlionAdLimitStrategyUtils;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.sp.VlionConfigSharedPreferences;
import cn.vlion.ad.inland.base.util.sp.VlionSharedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VlionServiceConfigParse {
    private static volatile VlionServiceConfigParse instance;
    private List<VlionServiceConfig.DataBean.ActiveStrategyBean> activeStrategy;
    private List<VlionServiceConfig.DataBean.ActivityTemplateBean> activityTemplate;
    private int adxExpireTime;
    private VlionServiceConfig.DataBean.AutoAttributionBean autoAttribution;
    private List<VlionServiceConfig.AutoBean> autos;
    private int backgroundTickTime;
    private int cacheAdTime;
    private String cfgVer;
    private List<String> checkInstalledPackageList;
    private boolean collectInstalledPackage;
    private String current;
    private int deeplinkTimes;
    private VlionServiceConfig.DataBean.EventsBean eventsBean;
    private boolean gdtInit;
    private boolean isAppStart;
    private boolean isCacheStatusOPen;
    private int isWxSdk;
    private boolean ksInit;
    private long lastConfigTime;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementBanner;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementDraw;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementFeed;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementInterstitial;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementSplash;
    private List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placementVideo;
    private int refreshConfigTime;
    private String reportUrl;
    private int sampleRadio;
    private List<VlionServiceConfig.DataBean.TemplatesBean> templatesBeanList;
    private String trace;
    private int ttl;
    private String uuid;
    private String wxAppId;
    private boolean isHaveData = false;
    private boolean isHotspot = false;
    private boolean isRegisterAddReceiver = false;
    private int refreshGeoTime = 1800;

    private VlionServiceConfigParse() {
    }

    public static synchronized VlionServiceConfigParse getInstance() {
        VlionServiceConfigParse vlionServiceConfigParse;
        synchronized (VlionServiceConfigParse.class) {
            try {
                if (instance == null) {
                    synchronized (VlionServiceConfigParse.class) {
                        try {
                            if (instance == null) {
                                instance = new VlionServiceConfigParse();
                            }
                        } finally {
                        }
                    }
                }
                vlionServiceConfigParse = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vlionServiceConfigParse;
    }

    private VlionAdLimitStrategyBean.AdLimitStrategyBean recordLimitStrategyBean(List<VlionAdLimitStrategyBean.AdLimitStrategyBean> list, String str) {
        if (list == null) {
            return null;
        }
        try {
            for (VlionAdLimitStrategyBean.AdLimitStrategyBean adLimitStrategyBean : list) {
                if (adLimitStrategyBean.getAdSrcName().equals(str)) {
                    return adLimitStrategyBean;
                }
            }
            VlionAdLimitStrategyBean.AdLimitStrategyBean adLimitStrategyBean2 = new VlionAdLimitStrategyBean.AdLimitStrategyBean();
            adLimitStrategyBean2.setAdSrcName(str);
            adLimitStrategyBean2.setCount(0);
            adLimitStrategyBean2.setLasttime(0L);
            LogVlion.e("频控策略 :  VlionServiceConfigParse  -新增电商红包雨效果了频次策略对象 ：=" + str);
            list.add(adLimitStrategyBean2);
            return adLimitStrategyBean2;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    private void upLoadAppStart() {
        if (this.isAppStart) {
            VlionADEventManager.sendStartSdkEvent();
            this.isAppStart = false;
        }
    }

    private void upLoadReport() {
        VlionADEventManager.sendReportSdkEvent(this.collectInstalledPackage);
    }

    public synchronized void Parse(String str, VlionServiceConfig vlionServiceConfig) {
        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list;
        try {
            p6.a().b();
            if (vlionServiceConfig != null) {
                this.trace = vlionServiceConfig.getTrace();
                this.current = String.valueOf(vlionServiceConfig.getCurrent());
                this.trace = vlionServiceConfig.getTrace();
                this.ttl = vlionServiceConfig.getTtl();
                this.autos = vlionServiceConfig.getAutos();
                VlionServiceConfig.DataBean dataBean = vlionServiceConfig.getDataBean();
                if (dataBean != null) {
                    this.reportUrl = dataBean.getReportv2();
                    this.activeStrategy = dataBean.getActiveStrategy();
                    this.autoAttribution = dataBean.getAutoAttribution();
                    this.activityTemplate = dataBean.getActivityTemplate();
                    VlionServiceConfig.DataBean.AdBean ad2 = dataBean.getAd();
                    VlionServiceConfig.DataBean.AdminBean admin = dataBean.getAdmin();
                    VlionServiceConfig.DataBean.EventsBean events = dataBean.getEvents();
                    this.templatesBeanList = dataBean.getTemplates();
                    if (events != null) {
                        this.eventsBean = events;
                    }
                    if (admin != null) {
                        this.backgroundTickTime = admin.getBackgroundTickTime();
                        this.refreshConfigTime = admin.getRefreshConfigTime();
                        this.sampleRadio = admin.getSampleRadio();
                        this.collectInstalledPackage = admin.getCollectInstalledPackage() == 1;
                        this.checkInstalledPackageList = admin.getCheckInstalledPackageList();
                        this.deeplinkTimes = admin.getDeeplinkTimes();
                        this.adxExpireTime = admin.getAdxExpireTime();
                        this.isHotspot = admin.getIsHotspot() == 1;
                        this.refreshGeoTime = admin.getRefreshGeoTime();
                        this.isCacheStatusOPen = admin.getCacheStatus() == 1;
                        this.cacheAdTime = admin.getCacheTime();
                        this.wxAppId = admin.getWxAppId();
                        this.isWxSdk = admin.getIsWxSdk();
                        this.gdtInit = admin.getGdtInit() == 1;
                        this.ksInit = admin.getKsInit() == 1;
                    }
                    this.isRegisterAddReceiver = true;
                    try {
                        VlionServiceConfig.DataBean.AutoAttributionBean autoAttributionBean = this.autoAttribution;
                        if (autoAttributionBean != null) {
                            List<String> excludeListenMedia = autoAttributionBean.getExcludeListenMedia();
                            String packageName = VlionAppInfo.getInstance().getPackageName(VlionSDkManager.getInstance().getApplication());
                            if (excludeListenMedia != null && packageName != null && excludeListenMedia.contains(packageName)) {
                                this.isRegisterAddReceiver = false;
                            }
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    if (ad2 != null) {
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list2 = this.placementBanner;
                        if (list2 != null) {
                            list2.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list3 = this.placementInterstitial;
                        if (list3 != null) {
                            list3.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list4 = this.placementFeed;
                        if (list4 != null) {
                            list4.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list5 = this.placementSplash;
                        if (list5 != null) {
                            list5.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list6 = this.placementVideo;
                        if (list6 != null) {
                            list6.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list7 = this.placementDraw;
                        if (list7 != null) {
                            list7.clear();
                        }
                        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> placement = ad2.getPlacement();
                        if (placement != null && placement.size() > 0) {
                            for (int i10 = 0; i10 < placement.size(); i10++) {
                                VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean = placement.get(i10);
                                if (placementBean != null) {
                                    switch (placementBean.getAdType()) {
                                        case 1:
                                            if (this.placementBanner == null) {
                                                this.placementBanner = new ArrayList();
                                            }
                                            list = this.placementBanner;
                                            list.add(placementBean);
                                            break;
                                        case 2:
                                            if (this.placementFeed == null) {
                                                this.placementFeed = new ArrayList();
                                            }
                                            list = this.placementFeed;
                                            list.add(placementBean);
                                            break;
                                        case 3:
                                            if (this.placementVideo == null) {
                                                this.placementVideo = new ArrayList();
                                            }
                                            list = this.placementVideo;
                                            list.add(placementBean);
                                            break;
                                        case 4:
                                            if (this.placementInterstitial == null) {
                                                this.placementInterstitial = new ArrayList();
                                            }
                                            list = this.placementInterstitial;
                                            list.add(placementBean);
                                            break;
                                        case 5:
                                            if (this.placementSplash == null) {
                                                this.placementSplash = new ArrayList();
                                            }
                                            list = this.placementSplash;
                                            list.add(placementBean);
                                            break;
                                        case 6:
                                            if (this.placementDraw == null) {
                                                this.placementDraw = new ArrayList();
                                            }
                                            list = this.placementDraw;
                                            list.add(placementBean);
                                            break;
                                    }
                                }
                            }
                            this.isHaveData = true;
                        }
                    }
                    upLoadAppStart();
                    upLoadReport();
                } else {
                    this.isHaveData = false;
                }
                this.cfgVer = vlionServiceConfig.getCfgVer();
                VlionConfigSharedPreferences.getInstance().setConfigData(str);
            } else {
                this.isHaveData = false;
                VlionConfigSharedPreferences.getInstance().clear();
            }
        } finally {
        }
    }

    public List<VlionServiceConfig.DataBean.ActiveStrategyBean> getActiveStrategy() {
        return this.activeStrategy;
    }

    public synchronized VlionServiceConfig.DataBean.ActivityTemplateBean getActivityTemplate(String str, int i10, String str2) {
        try {
            LogVlion.e("VlionServiceConfigParse getActivityTemplate  adType=" + i10 + " templateId=" + str2);
            List<VlionServiceConfig.DataBean.ActivityTemplateBean> list = this.activityTemplate;
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < this.activityTemplate.size(); i11++) {
                    VlionServiceConfig.DataBean.ActivityTemplateBean activityTemplateBean = this.activityTemplate.get(i11);
                    if (activityTemplateBean != null && activityTemplateBean.getConfig() != null) {
                        for (VlionServiceConfig.DataBean.ActivityTemplateBean.ConfigBean configBean : activityTemplateBean.getConfig()) {
                            if (configBean != null && configBean.getType() == i10 && configBean.getTemplateId() != null && configBean.getTemplateId().contains(str2)) {
                                LogVlion.e("VlionServiceConfigParse getActivityTemplate -----  configBean.getType()=" + configBean.getType() + " configBean.getTemplateId() =" + configBean.getTemplateId().toString());
                                VlionAdLimitStrategyUtils vlionAdLimitStrategyUtils = VlionAdLimitStrategyUtils.getInstance();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append(i10);
                                VlionAdLimitStrategyBean strategyBean = vlionAdLimitStrategyUtils.getStrategyBean(sb2.toString());
                                List<VlionAdLimitStrategyBean.AdLimitStrategyBean> adLimitStrategyBean = strategyBean.getAdLimitStrategyBean();
                                if (adLimitStrategyBean == null) {
                                    adLimitStrategyBean = new ArrayList<>();
                                }
                                VlionAdLimitStrategyBean.AdLimitStrategyBean recordLimitStrategyBean = recordLimitStrategyBean(adLimitStrategyBean, "VL");
                                LogVlion.e("频控策略 :  VlionServiceConfigParse  -查询 电商红包雨效果了设置频次 ：=" + activityTemplateBean.getImp_limit() + " -当前频次 ：=" + recordLimitStrategyBean.getCount());
                                if (recordLimitStrategyBean.getCount() >= activityTemplateBean.getImp_limit()) {
                                    LogVlion.e("频控策略 :  电商红包雨效果了 超过了 设置频次 ：=");
                                    return null;
                                }
                                strategyBean.setAdLimitStrategyBean(adLimitStrategyBean);
                                if (i10 != 5) {
                                    VlionAdLimitStrategyUtils.getInstance().setLimitStrategyBean(str + i10, null);
                                    LogVlion.e("VlionServiceConfigParse activityTemplateBean .getType()-----=" + activityTemplateBean.getType());
                                }
                                return activityTemplateBean;
                            }
                        }
                    }
                }
            }
        } finally {
            return null;
        }
        return null;
    }

    public int getAdxExpireTime() {
        return this.adxExpireTime;
    }

    public VlionServiceConfig.DataBean.AutoAttributionBean getAutoAttribution() {
        return this.autoAttribution;
    }

    public List<VlionServiceConfig.AutoBean> getAutos() {
        return this.autos;
    }

    public int getBackgroundTickTime() {
        return this.backgroundTickTime;
    }

    public int getCacheAdTime() {
        return this.cacheAdTime;
    }

    public String getCfgVer() {
        return this.cfgVer;
    }

    public List<String> getCheckInstalledPackageList() {
        return this.checkInstalledPackageList;
    }

    public String getCurrent() {
        return this.current;
    }

    public int getDeeplinkTimes() {
        return this.deeplinkTimes;
    }

    public VlionServiceConfig.DataBean.EventsBean getEventsBean() {
        if (this.eventsBean == null) {
            this.eventsBean = new VlionServiceConfig.DataBean.EventsBean();
        }
        return this.eventsBean;
    }

    public int getIsWxSdk() {
        return this.isWxSdk;
    }

    public VlionServiceConfig.DataBean.AdBean.PlacementBean getPlacementBean(int i10, String str) {
        List<VlionServiceConfig.DataBean.AdBean.PlacementBean> list;
        try {
            switch (i10) {
                case 1:
                    list = this.placementBanner;
                    break;
                case 2:
                    list = this.placementFeed;
                    break;
                case 3:
                    list = this.placementVideo;
                    break;
                case 4:
                    list = this.placementInterstitial;
                    break;
                case 5:
                    list = this.placementSplash;
                    break;
                case 6:
                    list = this.placementDraw;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean = list.get(i11);
                    if (placementBean != null && TextUtils.equals(str, placementBean.getShowId())) {
                        return placementBean;
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return null;
    }

    public int getRefreshConfigTime() {
        return this.refreshConfigTime;
    }

    public int getRefreshGeoTime() {
        return this.refreshGeoTime;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public int getSampleRadio() {
        return this.sampleRadio;
    }

    public List<String> getStrategysIdList() {
        return StrategysIdUtils.getInstance().getStrategysIdList();
    }

    public synchronized VlionServiceConfig.DataBean.TemplatesBean getTemplatesBean(int i10) {
        try {
            List<VlionServiceConfig.DataBean.TemplatesBean> list = this.templatesBeanList;
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < this.templatesBeanList.size(); i11++) {
                    VlionServiceConfig.DataBean.TemplatesBean templatesBean = this.templatesBeanList.get(i11);
                    if (templatesBean != null && i10 == templatesBean.getId()) {
                        return templatesBean;
                    }
                }
            }
        } finally {
            return null;
        }
        return null;
    }

    public String getTrace() {
        return this.trace;
    }

    public String getUuid() {
        if (TextUtils.isEmpty(this.uuid)) {
            this.uuid = VlionSharedPreferences.getInstance().getUuid();
        }
        return this.uuid;
    }

    public String getWxAppId() {
        return this.wxAppId;
    }

    public boolean isAppStart() {
        return this.isAppStart;
    }

    public boolean isCacheStatusOPen() {
        return this.isCacheStatusOPen;
    }

    public boolean isExpire() {
        try {
            long abs = Math.abs((System.currentTimeMillis() - this.lastConfigTime) / 1000);
            LogVlion.e("VlionServiceConfigParse isExpire  internal=" + abs + " refreshConfigTime=" + this.refreshConfigTime);
            return abs > ((long) this.refreshConfigTime);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public boolean isGdtInit() {
        return this.gdtInit;
    }

    public boolean isHaveData() {
        return this.isHaveData;
    }

    public boolean isHotspot() {
        return this.isHotspot;
    }

    public boolean isKsInit() {
        return this.ksInit;
    }

    public boolean isRegisterAddReceiver() {
        return this.isRegisterAddReceiver;
    }

    public void setActivityTemplate(List<VlionServiceConfig.DataBean.ActivityTemplateBean> list) {
        this.activityTemplate = list;
    }

    public void setAppStart(boolean z10) {
        this.isAppStart = z10;
    }

    public void setGdtInit(boolean z10) {
        this.gdtInit = z10;
    }

    public void setLastConfigTime(long j10) {
        this.lastConfigTime = j10;
    }

    public void setRegisterAddReceiver(boolean z10) {
        this.isRegisterAddReceiver = z10;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public List<VlionServiceConfig.DataBean.ActivityTemplateBean> getActivityTemplate() {
        return this.activityTemplate;
    }

    public synchronized VlionServiceConfig.DataBean.TemplatesBean getTemplatesBean(String str) {
        try {
            List<VlionServiceConfig.DataBean.TemplatesBean> list = this.templatesBeanList;
            if (list != null && list.size() > 0) {
                for (int i10 = 0; i10 < this.templatesBeanList.size(); i10++) {
                    VlionServiceConfig.DataBean.TemplatesBean templatesBean = this.templatesBeanList.get(i10);
                    if (templatesBean != null && templatesBean.getMain() != null && templatesBean.getMain().getStyle() != null && templatesBean.getMain().getStyle().equals(str)) {
                        return templatesBean;
                    }
                }
            }
        } finally {
            return null;
        }
        return null;
    }
}
