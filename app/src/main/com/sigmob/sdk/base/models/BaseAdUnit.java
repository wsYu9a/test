package com.sigmob.sdk.base.models;

import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.czhj.wire.Wire;
import com.sigmob.sdk.a;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.common.e0;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.i;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.Color;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetImage;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.models.rtb.Tracking;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.models.rtb.Widget;
import com.sigmob.sdk.base.utils.d;
import com.sigmob.sdk.base.views.n;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.splash.c;
import com.sigmob.windad.natives.AdAppInfo;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class BaseAdUnit implements Serializable {
    private static final String TAG = "BaseAdUnit";
    private static final long serialVersionUID = 1;

    /* renamed from: ad */
    private Ad f18251ad;
    private transient AdAppInfo adAppInfo;
    private transient i adConfig;
    private int adHeight;
    private LoadAdRequest adRequest;
    private HashMap<String, List<e0>> adTrackersMap;
    private int adWidth;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String ad_source_channel;
    private int ad_type;
    private String adslot_id;
    private String adx_id;
    private String apkName;
    private String apkPackageName;
    private String bid_token;
    public BiddingResponse bidding_response;
    private String camp_id;
    private ClickCommon clickCommon;
    private long create_time;
    private String crid;
    private Long downloadId;
    private transient f downloadTask;
    private String downloadUrl;
    private List<com.sigmob.sdk.videoAd.f> download_trackers;
    private String endcard_md5;
    public int expiration_time;
    private transient List imageUrlList;
    private boolean isHalfInterstitial;
    private String landUrl;
    private String load_id;
    private AndroidMarket mCustomAndroidMarket;
    private String mCustomDeeplink;
    private String mCustomLandPageUrl;
    private transient d0 mSessionManager;
    private SigMacroCommon macroCommon;
    private String nativeDesc;
    private String nativeIconUrl;
    private String nativeTtitle;
    private SigVideo nativeVideo;
    private String request_id;
    private String rv_callback_url;
    public Template scene;
    public SlotAdSetting slotAdSetting;
    public String uid;
    private String uuid;
    private VideoStatusCommon videoCommon;
    private String video_md5;
    private double adPercent = -1.0d;
    private double realAdPercent = -1.0d;
    private boolean useDownloadedApk = false;
    private boolean isDislikeReported = false;
    private boolean record = true;
    private boolean catchVideo = false;

    /* renamed from: com.sigmob.sdk.base.models.BaseAdUnit$1 */
    public class AnonymousClass1 extends AdAppInfo {
        public AnonymousClass1() {
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getAppName() {
            return BaseAdUnit.this.getPrivacyAppName();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public int getAppSize() {
            return BaseAdUnit.this.getAppSize();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getAuthorName() {
            return BaseAdUnit.this.getCompanyName();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getDescription() {
            return BaseAdUnit.this.getDescription();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getDescriptionUrl() {
            return BaseAdUnit.this.getDescriptionUrl();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getPermissions() {
            return BaseAdUnit.this.getPermissions();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getPermissionsUrl() {
            return BaseAdUnit.this.getPermissionsUrl();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getPrivacyAgreement() {
            return BaseAdUnit.this.getPrivacyAgreement();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getPrivacyAgreementUrl() {
            return BaseAdUnit.this.getPrivacyAgreementUrl();
        }

        @Override // com.sigmob.windad.natives.AdAppInfo
        public String getVersionName() {
            return BaseAdUnit.this.getAppVersion();
        }

        public String toString() {
            return String.format("appName %s \n AuthorName %s \n  versionName %s \n permissionsUrl %s \n permissions %s \nprivacyAgreementUrl %s \n privacyAgreement %s \n descriptionUrl %s \n description %s \n  appsize %d", getAppName(), getAuthorName(), getVersionName(), getPermissionsUrl(), getPermissions(), getPrivacyAgreementUrl(), getPrivacyAgreement(), getDescriptionUrl(), getDescription(), Integer.valueOf(getAppSize()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:8:0x0011, B:10:0x004f, B:13:0x0067, B:15:0x008e, B:16:0x0097, B:18:0x009c, B:20:0x00a2, B:22:0x00ab, B:23:0x00af, B:27:0x0060, B:29:0x0064), top: B:7:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:8:0x0011, B:10:0x004f, B:13:0x0067, B:15:0x008e, B:16:0x0097, B:18:0x009c, B:20:0x00a2, B:22:0x00ab, B:23:0x00af, B:27:0x0060, B:29:0x0064), top: B:7:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #1 {all -> 0x005e, blocks: (B:8:0x0011, B:10:0x004f, B:13:0x0067, B:15:0x008e, B:16:0x0097, B:18:0x009c, B:20:0x00a2, B:22:0x00ab, B:23:0x00af, B:27:0x0060, B:29:0x0064), top: B:7:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sigmob.sdk.base.models.BaseAdUnit adUnit(com.sigmob.sdk.base.models.rtb.Ad r5, java.lang.String r6, com.sigmob.sdk.base.models.LoadAdRequest r7, com.sigmob.sdk.base.models.rtb.SlotAdSetting r8, com.sigmob.sdk.base.models.rtb.Template r9, java.lang.String r10, java.lang.Integer r11, com.sigmob.sdk.base.models.rtb.BiddingResponse r12) {
        /*
            r0 = 0
            java.util.List<com.sigmob.sdk.base.models.rtb.MaterialMeta> r1 = r5.materials     // Catch: java.lang.Throwable -> Lb6
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> Lb6
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = (com.sigmob.sdk.base.models.rtb.MaterialMeta) r1     // Catch: java.lang.Throwable -> Lb6
            if (r1 == 0) goto Lbc
            com.sigmob.sdk.base.models.BaseAdUnit r2 = new com.sigmob.sdk.base.models.BaseAdUnit     // Catch: java.lang.Throwable -> Lb6
            r2.<init>()     // Catch: java.lang.Throwable -> Lb6
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5e
            r2.create_time = r3     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r5.adslot_id     // Catch: java.lang.Throwable -> L5e
            r2.adslot_id = r0     // Catch: java.lang.Throwable -> L5e
            java.lang.Integer r0 = r5.ad_type     // Catch: java.lang.Throwable -> L5e
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L5e
            r2.ad_type = r0     // Catch: java.lang.Throwable -> L5e
            r2.f18251ad = r5     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r5.crid     // Catch: java.lang.Throwable -> L5e
            r2.crid = r0     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r5.camp_id     // Catch: java.lang.Throwable -> L5e
            r2.camp_id = r0     // Catch: java.lang.Throwable -> L5e
            r2.request_id = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = r1.endcard_md5     // Catch: java.lang.Throwable -> L5e
            r2.endcard_md5 = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = r1.video_md5     // Catch: java.lang.Throwable -> L5e
            r2.video_md5 = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = r7.getLoadId()     // Catch: java.lang.Throwable -> L5e
            r2.load_id = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.String r6 = r5.ad_source_channel     // Catch: java.lang.Throwable -> L5e
            r2.ad_source_channel = r6     // Catch: java.lang.Throwable -> L5e
            java.lang.Integer r6 = r1.creative_type     // Catch: java.lang.Throwable -> L5e
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L5e
            com.sigmob.sdk.base.common.m r0 = com.sigmob.sdk.base.common.m.CreativeTypeVideo_Html_Snippet     // Catch: java.lang.Throwable -> L5e
            int r0 = r0.b()     // Catch: java.lang.Throwable -> L5e
            if (r6 == r0) goto L60
            java.lang.Integer r6 = r1.creative_type     // Catch: java.lang.Throwable -> L5e
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L5e
            com.sigmob.sdk.base.common.m r0 = com.sigmob.sdk.base.common.m.CreativeTypeVideo_transparent_html     // Catch: java.lang.Throwable -> L5e
            int r0 = r0.b()     // Catch: java.lang.Throwable -> L5e
            if (r6 != r0) goto L67
            goto L60
        L5e:
            r5 = move-exception
            goto Lb4
        L60:
            com.czhj.wire.okio.ByteString r6 = r1.html_snippet     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L67
            r6.size()     // Catch: java.lang.Throwable -> L5e
        L67:
            r2.slotAdSetting = r8     // Catch: java.lang.Throwable -> L5e
            r2.adRequest = r7     // Catch: java.lang.Throwable -> L5e
            r2.scene = r9     // Catch: java.lang.Throwable -> L5e
            r2.uid = r10     // Catch: java.lang.Throwable -> L5e
            int r6 = r11.intValue()     // Catch: java.lang.Throwable -> L5e
            r2.expiration_time = r6     // Catch: java.lang.Throwable -> L5e
            r2.bidding_response = r12     // Catch: java.lang.Throwable -> L5e
            java.lang.Boolean r6 = r8.use_downloaded_apk     // Catch: java.lang.Throwable -> L5e
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = com.czhj.wire.Wire.get(r6, r7)     // Catch: java.lang.Throwable -> L5e
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L5e
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L5e
            r2.useDownloadedApk = r6     // Catch: java.lang.Throwable -> L5e
            initAdTrackerMap(r2)     // Catch: java.lang.Throwable -> L5e
            java.util.Map<java.lang.String, java.lang.String> r6 = r5.ad_track_macro     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L97
            com.sigmob.sdk.base.models.SigMacroCommon r6 = r2.getMacroCommon()     // Catch: java.lang.Throwable -> L5e
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.ad_track_macro     // Catch: java.lang.Throwable -> L5e
            r6.setServerMacroMap(r5)     // Catch: java.lang.Throwable -> L5e
        L97:
            int r5 = r2.ad_type     // Catch: java.lang.Throwable -> L5e
            r6 = 5
            if (r5 != r6) goto Lb2
            com.sigmob.sdk.base.models.rtb.ResponseNativeAd r5 = r2.getNativeAd()     // Catch: java.lang.Throwable -> L5e
            if (r5 == 0) goto Lb2
            java.lang.Integer r5 = r5.type     // Catch: java.lang.Throwable -> L5e
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L5e
            r6 = 1
            if (r5 != r6) goto Laf
            r2.getNativeVideo()     // Catch: java.lang.Throwable -> L5e
            goto Lb2
        Laf:
            r2.getImageUrlList()     // Catch: java.lang.Throwable -> L5e
        Lb2:
            r0 = r2
            goto Lbc
        Lb4:
            r0 = r2
            goto Lb7
        Lb6:
            r5 = move-exception
        Lb7:
            java.lang.String r6 = "adUnit error"
            com.czhj.sdk.logger.SigmobLog.e(r6, r5)
        Lbc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.models.BaseAdUnit.adUnit(com.sigmob.sdk.base.models.rtb.Ad, java.lang.String, com.sigmob.sdk.base.models.LoadAdRequest, com.sigmob.sdk.base.models.rtb.SlotAdSetting, com.sigmob.sdk.base.models.rtb.Template, java.lang.String, java.lang.Integer, com.sigmob.sdk.base.models.rtb.BiddingResponse):com.sigmob.sdk.base.models.BaseAdUnit");
    }

    private static boolean checkFileMD5(String str, String str2) {
        String fileMd5 = Md5Util.fileMd5(str);
        SigmobLog.d("path: [ " + str + " ] calc [ " + fileMd5 + " ] origin " + str2);
        return fileMd5 != null && fileMd5.equalsIgnoreCase(str2);
    }

    public static List<e0> createTrackersForUrls(List<String> list, String str, String str2, Integer num) {
        Preconditions.NoThrow.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            e0 e0Var = new e0(it.next(), str, str2);
            e0Var.setRetryNum(num);
            arrayList.add(e0Var);
        }
        return arrayList;
    }

    public int getAppSize() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return 0;
        }
        String str = map.get("app_size");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public static String getTAG() {
        return TAG;
    }

    private static void initAdTrackerMap(BaseAdUnit baseAdUnit) {
        List<Tracking> ad_tracking = baseAdUnit.getAd_tracking();
        baseAdUnit.adTrackersMap = new HashMap<>();
        for (Tracking tracking : ad_tracking) {
            baseAdUnit.adTrackersMap.put(tracking.tracking_event_type, createTrackersForUrls(tracking.tracking_url, tracking.tracking_event_type, baseAdUnit.request_id, Integer.valueOf(baseAdUnit.getTrackingRetryNum())));
        }
    }

    public boolean canInstall(String str) {
        boolean z10 = (TextUtils.isEmpty(getApkMd5()) && getDownloadTask() == null && getDownloadId() == null) ? false : true;
        if (canUseDownloadApk() && !TextUtils.isEmpty(str) && z10) {
            File file = new File(d.a(a.d()), str);
            if (file.exists() && ClientMetadata.getPackageInfoWithUri(a.d(), file.getAbsolutePath()) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean canOpen() {
        String str = this.apkPackageName;
        if (TextUtils.isEmpty(str)) {
            str = getProductId();
        }
        return (TextUtils.isEmpty(str) || a.d().getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
    }

    public boolean canUseDownloadApk() {
        return this.useDownloadedApk;
    }

    public boolean checkEndCardZipValid() {
        if (TextUtils.isEmpty(getEndcard_url()) || TextUtils.isEmpty(this.endcard_md5)) {
            return true;
        }
        return checkFileMD5(getEndCardZipPath(), getEndcard_md5());
    }

    public boolean checkVideoValid() {
        if (TextUtils.isEmpty(getVideo_url()) || TextUtils.isEmpty(this.video_md5)) {
            return true;
        }
        return checkFileMD5(getVideoPath(), getVideo_OriginMD5());
    }

    public void destroy() {
        i iVar = this.adConfig;
        if (iVar != null) {
            iVar.a();
            this.adConfig = null;
        }
        d0 d0Var = this.mSessionManager;
        if (d0Var != null) {
            d0Var.a();
        }
    }

    public void dislikeReport() {
        this.isDislikeReported = true;
    }

    public void enableUseDownloadApk(boolean z10) {
        this.useDownloadedApk = z10;
    }

    public boolean enable_full_click() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting != null) {
            return splashAdSetting.enable_full_click.booleanValue();
        }
        return false;
    }

    public Ad getAd() {
        return this.f18251ad;
    }

    public AdAppInfo getAdAppInfo() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (this.adAppInfo == null && adPrivacy != null) {
            try {
                this.adAppInfo = new AdAppInfo() { // from class: com.sigmob.sdk.base.models.BaseAdUnit.1
                    public AnonymousClass1() {
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAppName() {
                        return BaseAdUnit.this.getPrivacyAppName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public int getAppSize() {
                        return BaseAdUnit.this.getAppSize();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAuthorName() {
                        return BaseAdUnit.this.getCompanyName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescription() {
                        return BaseAdUnit.this.getDescription();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescriptionUrl() {
                        return BaseAdUnit.this.getDescriptionUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissions() {
                        return BaseAdUnit.this.getPermissions();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissionsUrl() {
                        return BaseAdUnit.this.getPermissionsUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreement() {
                        return BaseAdUnit.this.getPrivacyAgreement();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreementUrl() {
                        return BaseAdUnit.this.getPrivacyAgreementUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getVersionName() {
                        return BaseAdUnit.this.getAppVersion();
                    }

                    public String toString() {
                        return String.format("appName %s \n AuthorName %s \n  versionName %s \n permissionsUrl %s \n permissions %s \nprivacyAgreementUrl %s \n privacyAgreement %s \n descriptionUrl %s \n description %s \n  appsize %d", getAppName(), getAuthorName(), getVersionName(), getPermissionsUrl(), getPermissions(), getPrivacyAgreementUrl(), getPrivacyAgreement(), getDescriptionUrl(), getDescription(), Integer.valueOf(getAppSize()));
                    }
                };
            } catch (Throwable unused) {
            }
        }
        return this.adAppInfo;
    }

    public i getAdConfig() {
        i f10;
        if (this.adConfig == null) {
            switch (getAd_type()) {
                case 1:
                case 4:
                    f10 = com.sigmob.sdk.videoAd.a.f(this);
                    break;
                case 2:
                    f10 = c.f(this);
                    break;
                case 3:
                case 6:
                    f10 = com.sigmob.sdk.newInterstitial.d.f(this);
                    break;
                case 5:
                    f10 = com.sigmob.sdk.nativead.c.f(this);
                    break;
            }
            this.adConfig = f10;
            return f10;
        }
        return this.adConfig;
    }

    public Integer getAdExpiredTime() {
        Integer num;
        Ad ad2 = this.f18251ad;
        return Integer.valueOf((ad2 == null || (num = ad2.expired_time) == null) ? 0 : num.intValue() * 1000);
    }

    public String getAdLogo() {
        return getAd_source_logo();
    }

    public double getAdPercent() {
        double d10 = this.adPercent;
        if (d10 > l5.c.f27899e) {
            return d10;
        }
        double d11 = this.realAdPercent;
        if (d11 > l5.c.f27899e) {
            return d11;
        }
        return 1.7777777910232544d;
    }

    public File getAdPrivacyTemplateFile() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null) {
            return null;
        }
        String str = adPrivacy.privacy_template_url;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String md5 = Md5Util.md5(str);
        return new File(d.b(d.f18408e), md5 + ".html");
    }

    public LoadAdRequest getAdRequest() {
        return this.adRequest;
    }

    public AdSetting getAdSetting() {
        Ad ad2 = this.f18251ad;
        if (ad2 != null) {
            return ad2.ad_setting;
        }
        return null;
    }

    public List<e0> getAdTracker(String str) {
        HashMap<String, List<e0>> hashMap = this.adTrackersMap;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public String getAd_scene_desc() {
        return this.ad_scene_desc;
    }

    public String getAd_scene_id() {
        return this.ad_scene_id;
    }

    public String getAd_source_channel() {
        return this.ad_source_channel;
    }

    public String getAd_source_logo() {
        Ad ad2 = this.f18251ad;
        if (ad2 != null) {
            return ad2.ad_source_logo;
        }
        return null;
    }

    public List<Tracking> getAd_tracking() {
        Ad ad2 = this.f18251ad;
        if (ad2 != null) {
            return ad2.ad_tracking;
        }
        return null;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAdslot_id() {
        return this.adslot_id;
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public AndroidMarket getAndroidMarket() {
        AndroidMarket androidMarket;
        MaterialMeta material = getMaterial();
        AndroidMarket androidMarket2 = material != null ? material.android_market : null;
        return (androidMarket2 != null || (androidMarket = this.mCustomAndroidMarket) == null) ? androidMarket2 : androidMarket;
    }

    public int getApkDownloadType() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return ((Integer) Wire.get(slotAdSetting.apk_download_type, 0)).intValue();
        }
        return 0;
    }

    public String getApkMd5() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return (String) Wire.get(material.apk_md5, null);
        }
        return null;
    }

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getAppName() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.app_name;
        }
        return null;
    }

    public String getAppVersion() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_version");
    }

    public String getBid_token() {
        return this.bid_token;
    }

    public int getButtonColor() {
        Color color;
        MaterialMeta material = getMaterial();
        return (material == null || (color = material.button_color) == null) ? android.graphics.Color.parseColor("#FF5A57") : android.graphics.Color.argb((int) (color.alpha.floatValue() * 255.0f), material.button_color.red.intValue(), material.button_color.green.intValue(), material.button_color.blue.intValue());
    }

    public String getCTAText() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.button_text : null;
        return !TextUtils.isEmpty(str) ? str : getInteractionType() != 2 ? "查看详情" : "立即下载";
    }

    public String getCamp_id() {
        return this.camp_id;
    }

    public int getChargePercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.charge_percent, 0)).intValue();
        }
        return 0;
    }

    public int getChargeSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.charge_seconds, 0)).intValue();
        }
        return 0;
    }

    public ClickAreaSetting getClickAreaSetting() {
        ClickAreaSetting clickAreaSetting = getRvAdSetting().click_setting;
        if (clickAreaSetting != null) {
            return clickAreaSetting;
        }
        ClickAreaSetting.Builder builder = new ClickAreaSetting.Builder();
        builder.bottom = Float.valueOf(0.1f);
        builder.right = Float.valueOf(0.1f);
        builder.top = Float.valueOf(0.1f);
        builder.left = Float.valueOf(0.1f);
        return builder.build();
    }

    public ClickCommon getClickCommon() {
        if (this.clickCommon == null) {
            this.clickCommon = new ClickCommon();
        }
        return this.clickCommon;
    }

    public int getClickType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return ((Integer) Wire.get(material.click_type, 0)).intValue();
        }
        return 0;
    }

    public String getCloseCardHtmlData() {
        if (getMaterial() == null) {
            return null;
        }
        if (getMaterial().closecard_html_snippet != null || getMaterial().closecard_html_snippet.size() >= 10) {
            return getMaterial().closecard_html_snippet.utf8();
        }
        return null;
    }

    public String getCompanyName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_company");
    }

    public int getConfirmDialog() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.confirm_dialog, 0)).intValue();
        }
        return 0;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public n.c getCreativeResourceType() {
        return (TextUtils.isEmpty(getEndcard_url()) || !(getCreativeType() == m.CreativeTypeVideo_Tar.b() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.b())) ? !TextUtils.isEmpty(getHtmlData()) ? n.c.HTML_RESOURCE : !TextUtils.isEmpty(getHtmlUrl()) ? n.c.URL_RESOURCE : n.c.NATIVE_RESOURCE : n.c.NATIVE_RESOURCE;
    }

    public String getCreativeTitle() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.creative_title;
        }
        return null;
    }

    public int getCreativeType() {
        if (getMaterial() != null) {
            return getMaterial().creative_type.intValue();
        }
        return 0;
    }

    public String getCrid() {
        return this.crid;
    }

    public String getDeeplinkUrl() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.deeplink_url : null;
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mCustomDeeplink)) ? str : this.mCustomDeeplink;
    }

    public String getDesc() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.desc;
        }
        return null;
    }

    public String getDescription() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func");
    }

    public String getDescriptionUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func_url");
    }

    public boolean getDisableAutoLoad() {
        Boolean bool;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return false;
            }
            bool = newInterstitialSetting.disable_auto_load;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return false;
            }
            bool = rvAdSetting.disable_auto_load;
        }
        return bool.booleanValue();
    }

    public int getDisplay_orientation() {
        Ad ad2 = getAd();
        if (ad2 != null) {
            return ((Integer) Wire.get(ad2.display_orientation, 0)).intValue();
        }
        return 0;
    }

    public Long getDownloadId() {
        return this.downloadId;
    }

    public List<com.sigmob.sdk.videoAd.f> getDownloadQuarterTrack() {
        return this.download_trackers;
    }

    public f getDownloadTask() {
        return this.downloadTask;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDuration() {
        int endTime = getEndTime();
        if (endTime > 0) {
            return endTime * 1000;
        }
        return 33333;
    }

    public String getEndCardDirPath() {
        return d.j() + String.format("/%s/", getEndcard_md5());
    }

    public String getEndCardImageUrl() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.endcard_image_src;
        }
        return null;
    }

    public String getEndCardIndexPath() {
        return getEndCardDirPath() + "endcard.html";
    }

    public String getEndCardZipPath() {
        return d.j() + String.format("/%s.tgz", this.endcard_md5);
    }

    public String getEndCard_OriginMD5() {
        return this.endcard_md5;
    }

    public int getEndTime() {
        RvAdSetting rvAdSetting;
        if (this.ad_type == 6 || (rvAdSetting = getRvAdSetting()) == null) {
            return 0;
        }
        return rvAdSetting.end_time.intValue();
    }

    public int getEndcardCloseImage() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.endcard_close_image.intValue();
        }
        return 0;
    }

    public String getEndcard_md5() {
        return !TextUtils.isEmpty(this.endcard_md5) ? this.endcard_md5 : Md5Util.md5(getCrid());
    }

    public String getEndcard_url() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.endcard_url;
        }
        return null;
    }

    public float getFinishedTime() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.finished.floatValue();
        }
        return 1.0f;
    }

    public boolean getFullClickOnVideo() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.full_click_on_video.booleanValue();
        }
        return false;
    }

    public String getHtmlData() {
        if (getMaterial() == null) {
            return null;
        }
        if (getMaterial().html_snippet != null || getMaterial().html_snippet.size() >= 10) {
            return getMaterial().html_snippet.utf8();
        }
        return null;
    }

    public String getHtmlUrl() {
        if (getMaterial() == null) {
            return null;
        }
        return getMaterial().html_url;
    }

    public String getIconUrl() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.icon_url;
        }
        return null;
    }

    public List<SigImage> getImageUrlList() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.imageUrlList == null) {
            this.imageUrlList = new ArrayList();
            if (nativeAd != null && nativeAd.type.intValue() != 1) {
                Iterator<ResponseAsset> it = nativeAd.assets.iterator();
                while (it.hasNext()) {
                    ResponseAssetImage responseAssetImage = it.next().image;
                    if (responseAssetImage != null) {
                        SigImage sigImage = new SigImage(responseAssetImage.url, responseAssetImage.f18253w.intValue(), responseAssetImage.f18252h.intValue());
                        if (this.adPercent < l5.c.f27899e && responseAssetImage.f18253w.intValue() > 0 && responseAssetImage.f18252h.intValue() > 0) {
                            this.adPercent = (responseAssetImage.f18253w.intValue() * 1.0f) / responseAssetImage.f18252h.intValue();
                        }
                        this.imageUrlList.add(sigImage);
                    }
                }
            }
        }
        return this.imageUrlList;
    }

    public int getInteractionType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.interaction_type.intValue();
        }
        return 1;
    }

    public boolean getInvisibleAdLabel() {
        RvAdSetting rvAdSetting;
        Boolean bool;
        if (getAd_type() == 2) {
            SplashAdSetting splashAdSetting = getSplashAdSetting();
            if (splashAdSetting == null) {
                return false;
            }
            bool = splashAdSetting.invisible_ad_label;
        } else {
            if ((getAd_type() != 1 && getAd_type() != 4) || (rvAdSetting = getRvAdSetting()) == null) {
                return false;
            }
            bool = rvAdSetting.invisible_ad_label;
        }
        return bool.booleanValue();
    }

    public int getIsMute() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return 0;
            }
            num = newInterstitialSetting.if_mute;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return 0;
            }
            num = rvAdSetting.if_mute;
        }
        return num.intValue();
    }

    public String getLandUrl() {
        return this.landUrl;
    }

    public String getLanding_page() {
        String str = getMaterial() != null ? getMaterial().landing_page : null;
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mCustomLandPageUrl)) ? str : this.mCustomLandPageUrl;
    }

    public String getLoad_id() {
        return this.load_id;
    }

    public SigMacroCommon getMacroCommon() {
        if (this.macroCommon == null) {
            this.macroCommon = new SigMacroCommon();
            String video_url = getVideo_url();
            if (!TextUtils.isEmpty(video_url)) {
                try {
                    String encode = URLEncoder.encode(video_url, "UTF-8");
                    if (!TextUtils.isEmpty(encode)) {
                        this.macroCommon.addMarcoKey(SigMacroCommon._VURL_, encode);
                    }
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return this.macroCommon;
    }

    public String getMainImage() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.image_src;
        }
        return null;
    }

    public MaterialMeta getMaterial() {
        List<MaterialMeta> list;
        Ad ad2 = this.f18251ad;
        if (ad2 == null || (list = ad2.materials) == null || list.size() <= 0) {
            return null;
        }
        return this.f18251ad.materials.get(0);
    }

    public ResponseNativeAd getNativeAd() {
        List<MaterialMeta> list;
        Ad ad2 = this.f18251ad;
        if (ad2 == null || (list = ad2.materials) == null || list.size() <= 0) {
            return null;
        }
        return this.f18251ad.materials.get(0).native_ad;
    }

    public NativeAdSetting getNativeAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return slotAdSetting.native_setting;
        }
        return null;
    }

    public SigVideo getNativeVideo() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.nativeVideo == null && nativeAd != null && nativeAd.type.intValue() == 1) {
            for (ResponseAsset responseAsset : nativeAd.assets) {
                ResponseAssetVideo responseAssetVideo = responseAsset.video;
                if (responseAssetVideo != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    SigVideo sigVideo = this.nativeVideo;
                    sigVideo.url = responseAssetVideo.url;
                    sigVideo.height = responseAssetVideo.f18256h.intValue();
                    this.nativeVideo.width = responseAssetVideo.f18257w.intValue();
                    if (this.adPercent < l5.c.f27899e && responseAssetVideo.f18256h.intValue() > 0 && responseAssetVideo.f18257w.intValue() > 0) {
                        this.adPercent = (responseAssetVideo.f18257w.intValue() * 1.0f) / responseAssetVideo.f18256h.intValue();
                    }
                }
                ResponseAssetImage responseAssetImage = responseAsset.image;
                if (responseAssetImage != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    this.nativeVideo.thumbUrl = responseAssetImage.url;
                }
            }
        }
        return this.nativeVideo;
    }

    public InterstitialSetting getNewInterstitialSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return slotAdSetting.interstitial_setting;
        }
        return null;
    }

    public String getPermissions() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission");
    }

    public String getPermissionsUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission_url");
    }

    public int getPlayMode() {
        if (getMaterial() != null) {
            return getMaterial().play_mode.intValue();
        }
        return 0;
    }

    public String getPrivacyAgreement() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_text");
    }

    public String getPrivacyAgreementUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_url");
    }

    public String getPrivacyAppName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_name");
    }

    public String getProductId() {
        if (getAd() != null) {
            return getAd().product_id;
        }
        return null;
    }

    public String getProxyVideoUrl() {
        String video_url = getVideo_url();
        return !TextUtils.isEmpty(video_url) ? h.n().d(video_url) : video_url;
    }

    public String getRequestId() {
        return this.request_id;
    }

    public int getRewardPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_percent, 0)).intValue();
        }
        return 0;
    }

    public int getRewardSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_seconds, 0)).intValue();
        }
        return 0;
    }

    public int getRewardStyle() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_style, 0)).intValue();
        }
        return 0;
    }

    public RvAdSetting getRvAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return slotAdSetting.rv_setting;
        }
        return null;
    }

    public String getRvCallBackUrl() {
        return this.rv_callback_url;
    }

    public Template getScene() {
        return this.scene;
    }

    public int getSensitivity() {
        AdSetting adSetting = getAdSetting();
        if (adSetting != null) {
            return adSetting.sensitivity.intValue();
        }
        return 0;
    }

    public d0 getSessionManager() {
        return this.mSessionManager;
    }

    public SingleNativeAdSetting getSingleNativeSetting() {
        AdSetting adSetting = getAdSetting();
        if (adSetting != null) {
            return adSetting.single_native_setting;
        }
        return null;
    }

    public int getSkipPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.skip_percent, 0)).intValue();
        }
        return -1;
    }

    public int getSkipSeconds() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return -1;
            }
            num = newInterstitialSetting.show_skip_seconds;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return -1;
            }
            num = (Integer) Wire.get(rvAdSetting.skip_seconds, 0);
        }
        return num.intValue();
    }

    public SlotAdSetting getSlotAdSetting() {
        return this.slotAdSetting;
    }

    public SplashAdSetting getSplashAdSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return slotAdSetting.splash_setting;
        }
        return null;
    }

    public String getSplashFilePath() {
        StringBuilder sb2;
        String str;
        if (m.CreativeTypeSplashVideo.b() == getMaterial().creative_type.intValue()) {
            sb2 = new StringBuilder();
            sb2.append(d.i());
            sb2.append(File.separator);
            str = getMaterial().video_url;
        } else {
            sb2 = new StringBuilder();
            sb2.append(d.i());
            sb2.append(File.separator);
            str = getMaterial().image_src;
        }
        sb2.append(Md5Util.md5(str));
        return sb2.toString();
    }

    public String getSplashURL() {
        return m.CreativeTypeSplashVideo.b() == getMaterial().creative_type.intValue() ? getMaterial().video_url : getMaterial().image_src;
    }

    public int getTemplateId() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.template_id.intValue();
        }
        return 0;
    }

    public int getTemplateType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.template_type.intValue();
        }
        return 0;
    }

    public String getTitle() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.title;
        }
        return null;
    }

    public int getTrackingRetryNum() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Integer) Wire.get(slotAdSetting.retry_count, 0)).intValue();
        }
        return 0;
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID().toString();
        }
        return this.uuid;
    }

    public String getVid() {
        if (getAd() != null) {
            return getAd().vid;
        }
        return null;
    }

    public VideoStatusCommon getVideoCommon() {
        if (this.videoCommon == null) {
            this.videoCommon = new VideoStatusCommon();
        }
        return this.videoCommon;
    }

    public String getVideoPath() {
        File videoProxyFile = getVideoProxyFile();
        if (videoProxyFile != null) {
            return videoProxyFile.getAbsolutePath();
        }
        return null;
    }

    public File getVideoProxyFile() {
        String video_url = getVideo_url();
        if (TextUtils.isEmpty(video_url)) {
            return null;
        }
        return h.n().b(video_url);
    }

    public String getVideoThumbUrl() {
        SigVideo sigVideo = this.nativeVideo;
        if (sigVideo != null) {
            return sigVideo.thumbUrl;
        }
        return null;
    }

    public String getVideoTmpPath() {
        return d.d() + String.format("/%s.mp4.tmp", getVideo_md5());
    }

    public String getVideo_OriginMD5() {
        return this.video_md5;
    }

    public String getVideo_md5() {
        return !TextUtils.isEmpty(this.video_md5) ? this.video_md5 : Md5Util.md5(getVideo_url());
    }

    public String getVideo_url() {
        String str;
        Ad ad2 = this.f18251ad;
        if (ad2 == null || ad2.materials.size() <= 0) {
            return null;
        }
        if (this.ad_type == 5) {
            SigVideo nativeVideo = getNativeVideo();
            if (nativeVideo == null) {
                return null;
            }
            str = nativeVideo.url;
        } else {
            MaterialMeta materialMeta = this.f18251ad.materials.get(0);
            if (materialMeta == null) {
                return null;
            }
            str = materialMeta.video_url;
        }
        return StringUtil.getUrl(str);
    }

    public WXProgramRes getWXProgramRes() {
        WXProgramRes wXProgramRes;
        Ad ad2 = getAd();
        if (ad2 == null || (wXProgramRes = ad2.wx_program_res) == null) {
            return null;
        }
        return wXProgramRes;
    }

    public long getWidgetId(int i10) {
        List<Widget> list;
        Widget widget;
        MaterialMeta material = getMaterial();
        if (material == null || (list = material.Widget_list) == null || list.isEmpty() || (widget = list.get(i10)) == null) {
            return 0L;
        }
        return widget.widget_id.longValue();
    }

    public AdPrivacy getadPrivacy() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.ad_privacy;
        }
        return null;
    }

    public int getsubInteractionType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.sub_interaction_type.intValue();
        }
        return 0;
    }

    public boolean hasEndCard() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.has_endcard.booleanValue();
        }
        return false;
    }

    public boolean isCatchVideo() {
        return this.catchVideo;
    }

    public boolean isClickAutoCloseSplash() {
        return false;
    }

    public boolean isDisablexRequestWith() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Boolean) Wire.get(slotAdSetting.disable_x_requested_with, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isDislikeReported() {
        return this.isDislikeReported;
    }

    public boolean isDownloadDialog() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.download_dialog.booleanValue();
        }
        return false;
    }

    public boolean isEndCardIndexExist() {
        if (TextUtils.isEmpty(getEndcard_url())) {
            return true;
        }
        if (getCreativeType() == m.CreativeTypeVideo_Tar.b() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.b()) {
            return new File(getEndCardIndexPath()).exists();
        }
        return true;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public boolean isNativeAdH5() {
        return true;
    }

    public boolean isRecord() {
        return this.record;
    }

    public boolean isResumableDownload() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Boolean) Wire.get(slotAdSetting.resumable_download, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isSkipSigmobBrowser() {
        AdSetting adSetting = getAdSetting();
        return adSetting == null || !adSetting.in_app.booleanValue();
    }

    public boolean isUse_floating_btn() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting != null) {
            return splashAdSetting.use_floating_btn.booleanValue();
        }
        return false;
    }

    public boolean isVideoExist() {
        if (TextUtils.isEmpty(getVideo_url())) {
            return true;
        }
        String videoPath = getVideoPath();
        boolean exists = new File(videoPath).exists();
        SigmobLog.d("isVideoExist path :" + videoPath + " isExist: " + exists);
        return exists;
    }

    public boolean noHasDownloadDialog() {
        return ((getInteractionType() == 2 || getInteractionType() == 3) && getadPrivacy() != null && isDownloadDialog()) ? false : true;
    }

    public String resourcePath() {
        return (TextUtils.isEmpty(getEndcard_url()) || !(getCreativeType() == m.CreativeTypeVideo_Tar.b() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.b())) ? !TextUtils.isEmpty(getHtmlData()) ? getHtmlData() : getHtmlUrl() : getEndCardIndexPath();
    }

    public void setAd(Ad ad2) {
        this.f18251ad = ad2;
    }

    public void setAdSize(int i10, int i11) {
        this.adWidth = i10;
        this.adHeight = i11;
        getMacroCommon().addMarcoKey(SigMacroCommon._WIDTH_, String.valueOf(i10));
        getMacroCommon().addMarcoKey(SigMacroCommon._HEIGHT_, String.valueOf(i11));
    }

    public void setAd_scene_desc(String str) {
        this.ad_scene_desc = str;
    }

    public void setAd_scene_id(String str) {
        this.ad_scene_id = str;
    }

    public void setAd_source_channel(String str) {
        this.ad_source_channel = str;
    }

    public void setAd_type(int i10) {
        this.ad_type = i10;
    }

    public void setAdslot_id(String str) {
        this.adslot_id = str;
    }

    public void setAdx_id(String str) {
        this.adx_id = str;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setBid_token(String str) {
        this.bid_token = str;
    }

    public void setCamp_id(String str) {
        this.camp_id = str;
    }

    public void setCatchVideo(boolean z10) {
        this.catchVideo = z10;
    }

    public void setCreate_time(long j10) {
        this.create_time = j10;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setCustomAndroidMarket(AndroidMarket androidMarket) {
        this.mCustomAndroidMarket = androidMarket;
    }

    public void setCustomDeeplink(String str) {
        this.mCustomDeeplink = str;
    }

    public void setCustomLandPageUrl(String str) {
        this.mCustomLandPageUrl = str;
    }

    public void setDownloadId(Long l10) {
        this.downloadId = l10;
    }

    public void setDownloadQuarterTrack(List<com.sigmob.sdk.videoAd.f> list) {
        this.download_trackers = list;
    }

    public void setDownloadTask(f fVar) {
        this.downloadTask = fVar;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setEndcard_md5(String str) {
        this.endcard_md5 = str;
    }

    public void setHalfInterstitial(boolean z10) {
        this.isHalfInterstitial = z10;
    }

    public void setLoad_id(String str) {
        this.load_id = str;
    }

    public void setMacroCommon(SigMacroCommon sigMacroCommon) {
        this.macroCommon = sigMacroCommon;
    }

    public void setRecord(boolean z10) {
        this.record = z10;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setRvCallBackUrl(String str) {
        this.rv_callback_url = str;
    }

    public void setSessionManager(d0 d0Var) {
        this.mSessionManager = d0Var;
    }

    public void setUrl(String str) {
        this.landUrl = str;
    }

    public void setVideo_md5(String str) {
        this.video_md5 = str;
    }

    public void updateRealAdPercent(double d10) {
        this.realAdPercent = d10;
    }
}
