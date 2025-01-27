package com.kwad.sdk.core.response.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.ci;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    public static long D(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String E(@NonNull AdInfo adInfo) {
        return aN(adInfo).materialUrl;
    }

    public static int F(@NonNull AdInfo adInfo) {
        return aN(adInfo).videoDuration;
    }

    public static long G(@NonNull AdInfo adInfo) {
        return F(adInfo) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String H(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = aW(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean I(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int J(@NonNull AdInfo adInfo) {
        return aN(adInfo).videoWidth;
    }

    public static int K(@NonNull AdInfo adInfo) {
        return aN(adInfo).videoHeight;
    }

    public static boolean L(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId);
    }

    public static boolean M(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean N(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aN(adInfo);
        return aN.videoWidth <= aN.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = aW(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String P(@NonNull AdInfo adInfo) {
        int aW = aW(adInfo);
        if (aW != 1) {
            if (aW != 2 && aW != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aQ(adInfo).blurBackgroundUrl;
    }

    private static int Q(@NonNull AdInfo adInfo) {
        return aN(adInfo).width;
    }

    private static int R(@NonNull AdInfo adInfo) {
        return aN(adInfo).height;
    }

    public static long S(@NonNull AdInfo adInfo) {
        return aN(adInfo).photoId;
    }

    public static String T(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long U(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int V(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long W(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long X(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int Y(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean Z(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int aA(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aF(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aG(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static String aH(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cp(d.cb(adTemplate)) && !cq(d.cb(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo cb = d.cb(adTemplate);
        return TextUtils.isEmpty(cb.adBaseInfo.installAppLabel) ? "立即安装" : cb.adBaseInfo.installAppLabel;
    }

    public static boolean aH(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && ax(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.adOperationType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i3;
    }

    public static boolean aI(@NonNull AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo bI = b.bI(adTemplate);
        return (bI != null && !bI.isEmpty()) && cb.adBaseInfo.campaignType == 13 && cb.ocpcActionType == 2;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aK(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : ac.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.h5Url, at(adInfo));
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aM(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aN(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aO(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aU(adInfo) ? aN(adInfo) : aM(adInfo);
        return aN.height > aN.width;
    }

    public static float aP(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aU(adInfo) ? aN(adInfo) : aM(adInfo);
        if (aN == null || aN.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "getMaterialRatio: height: " + aN.height + ", width: " + aN.width);
        return aN.height / aN.width;
    }

    @NonNull
    private static AdInfo.AdMaterialInfo.MaterialFeature aQ(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean aR(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aN(adInfo);
        return aN.height > aN.width;
    }

    public static String aS(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> aT(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int aW = aW(adInfo);
        if (aW != 2 && aW != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    public static boolean aU(@NonNull AdInfo adInfo) {
        return aW(adInfo) == 1;
    }

    public static boolean aV(@NonNull AdInfo adInfo) {
        return aM(adInfo).featureType == 2;
    }

    public static int aW(AdInfo adInfo) {
        int i2 = adInfo.adMaterialInfo.materialType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                if (i2 != 5) {
                    return i2 != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i3;
    }

    public static int aX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String aY(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean aZ(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static int aa(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ab(@NonNull AdInfo adInfo) {
        return Y(adInfo) != 0;
    }

    public static long ac(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return r4.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long ad(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int ae(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean af(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ag(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean ah(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ai(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean aj(@NonNull AdInfo adInfo) {
        return !ax(adInfo) && ak(adInfo);
    }

    public static boolean ak(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aG(adInfo) && aF(adInfo) == 1) || am(adInfo) || cv(adInfo)) ? false : true;
        }
        return false;
    }

    public static boolean al(@NonNull AdInfo adInfo) {
        return (!(adInfo.fullScreenVideoInfo.showLandingPage == 1) || !(bb.isNullString(aK(adInfo)) ^ true) || ax(adInfo) || (bb.isNullString(cs(adInfo)) ^ true) || bv(adInfo)) ? false : true;
    }

    private static boolean am(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static String an(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String ao(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String ap(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String aq(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String ar(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float as(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.appScore;
        if (i2 <= 0) {
            return 0.0f;
        }
        return i2 / 10.0f;
    }

    public static boolean at(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float au(@NonNull AdInfo adInfo) {
        float f2 = adInfo.adBaseInfo.appScore;
        if (f2 < 30.0f) {
            return 3.0f;
        }
        if (f2 < 35.0f) {
            return 3.5f;
        }
        if (f2 < 40.0f) {
            return 4.0f;
        }
        return f2 < 45.0f ? 4.5f : 5.0f;
    }

    public static String av(AdInfo adInfo) {
        return bb.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aw(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return ax(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean ax(@NonNull AdInfo adInfo) {
        return aI(adInfo) == 1;
    }

    public static boolean ay(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int az(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z) {
        return ((z && ax(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bb.isNullString(aK(adInfo))) ? false : true;
    }

    private static boolean bA(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 1;
    }

    @Nullable
    public static String bB(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String bD(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    public static boolean bE(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bF(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bG(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bH(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i2 = adFeedInfo.videoAutoPlayType;
        return i2 == 1 || i2 == 0;
    }

    public static boolean bI(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bJ(AdInfo adInfo) {
        return (TextUtils.isEmpty(aK(adInfo)) || ax(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    @NonNull
    public static String bK(@NonNull AdInfo adInfo) {
        String ao = ax(adInfo) ? ao(adInfo) : ap(adInfo);
        if (TextUtils.isEmpty(ao)) {
            ao = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(ao) ? "可爱的广告君" : ao;
    }

    @NonNull
    public static String bL(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String bM(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !ax(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long bN(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    @NonNull
    public static String bO(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo bP(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int bQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean bR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int bS(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int bT(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int bU(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static int bV(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowStyle;
    }

    public static int bW(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowTime;
    }

    public static String bX(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean bY(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int bZ(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean ba(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bb(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bc(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    @Nullable
    public static List<Integer> bd(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @NonNull
    private static int[] be(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static int bf(@NonNull AdInfo adInfo) {
        int[] be = be(adInfo);
        if (be[0] > 0) {
            return be[0];
        }
        return 3;
    }

    public static int bg(@NonNull AdInfo adInfo) {
        int[] be = be(adInfo);
        return (be[1] > 0 ? be[1] : 3) + bf(adInfo);
    }

    public static int bh(@NonNull AdInfo adInfo) {
        int[] be = be(adInfo);
        return (be[2] > 0 ? be[2] : 3) + bg(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b bi(@NonNull AdInfo adInfo) {
        String O;
        int Q;
        int R;
        boolean z;
        String H = H(adInfo);
        int J = J(adInfo);
        int K = K(adInfo);
        if (bb.isNullString(H) || bb.eP(H) || J == 0 || K == 0) {
            O = O(adInfo);
            Q = Q(adInfo);
            R = R(adInfo);
            z = true;
        } else {
            O = H;
            Q = J;
            R = K;
            z = false;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "frameUrl=" + O + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(O, Q, R, true, z);
    }

    public static String bj(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bl(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bm(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean bn(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bo(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i2 = adInfo.status;
        if (i2 == 0) {
            return 1;
        }
        if (1 == i2 || 2 == i2 || 3 == i2 || 4 == i2) {
            return 2;
        }
        return 8 == i2 ? 3 : 0;
    }

    @Nullable
    public static String bp(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String bq(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String br(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bs(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bt(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bu(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bv(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (by(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bw(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bx(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    @Deprecated
    public static String by(int i2) {
        return i(i2, "下载中  %s%%");
    }

    public static boolean by(AdInfo adInfo) {
        return ai.DM() ? bA(adInfo) : bz(adInfo);
    }

    public static String bz(int i2) {
        return "继续下载 " + i2 + "%";
    }

    private static boolean bz(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 2;
    }

    public static boolean cA(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long cB(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean cC(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean cD(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static int ca(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int cb(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean cc(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adSplashInfo.skipType;
        return i2 == 2 || i2 == 3;
    }

    public static boolean cd(@Nullable AdInfo adInfo) {
        if (!ce(adInfo)) {
            return false;
        }
        int i2 = adInfo.adSplashInfo.skipType;
        return i2 == 0 || i2 == 2;
    }

    public static boolean ce(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cf(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cg(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String ch(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean ci(@NonNull AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean cj(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    public static boolean ck(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.industryFirstLevelId != 1022) {
            return false;
        }
        int i2 = adInfo.ocpcActionType;
        return i2 == 192 || i2 == 53;
    }

    @Nullable
    public static String cl(@NonNull AdInfo adInfo) {
        int i2 = adInfo.advertiserInfo.fansCount;
        if (i2 >= 200 && i2 < 10000) {
            return String.valueOf(i2);
        }
        if (i2 < 10000) {
            return null;
        }
        double d2 = i2;
        Double.isNaN(d2);
        return new DecimalFormat(ci.f5719d).format(d2 / 10000.0d) + IAdInterListener.AdReqParam.WIDTH;
    }

    public static String cm(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cn(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean co(@NonNull AdInfo adInfo) {
        if (ck(adInfo)) {
            return false;
        }
        int i2 = adInfo.ocpcActionType;
        return (i2 == 395 || i2 == 192) && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean cp(@NonNull AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 1 && adBaseInfo.campaignType == 14;
    }

    public static boolean cq(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && bN(adInfo) != 0;
    }

    public static boolean cr(@NonNull AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 2 && adBaseInfo.campaignType == 14;
    }

    public static String cs(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return ac.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, at(adInfo));
    }

    public static AdProductInfo ct(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cu(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cv(@NonNull AdInfo adInfo) {
        if (ax(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cw(@NonNull AdInfo adInfo) {
        return cv(adInfo) && X(adInfo) < G(adInfo);
    }

    public static boolean cx(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean cy(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r8.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.y.Dx()
            r0 = 1
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L15
        L13:
            r1 = 1
            goto L2e
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r8 = r8.adStyleConfInfo
            int r8 = r8.adPushIntervalTime
            long r6 = (long) r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 > 0) goto L20
            r6 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L2e
            goto L13
        L2e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r8.<init>(r0)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.d.b.d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.cy(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int cz(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    @Nullable
    public static SpannableString e(AdInfo adInfo, @ColorInt int i2) {
        String format;
        int indexOf;
        String cl = cl(adInfo);
        if (cl == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", cl)).indexOf(cl)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i2), indexOf, cl.length() + indexOf, 18);
        return spannableString;
    }

    public static String i(int i2, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i2));
    }

    public static String xw() {
        return "继续下载";
    }
}
