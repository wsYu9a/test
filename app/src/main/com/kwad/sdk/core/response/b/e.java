package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: classes3.dex */
public final class e {
    @Nullable
    private static g GO() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.uL();
        }
        return null;
    }

    public static boolean J(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo eb2 = eb(adTemplate);
        return (a.aF(eb2) || a.cY(eb2) || ej(adTemplate) != 3) ? false : true;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j10, int i10) {
        if (j10 >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (c(adTemplate, j10, i10)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j10, int i10) {
        AdTemplate a10 = a(list, j10, i10);
        if (a10 == null) {
            return false;
        }
        long el = el(a10);
        int dV = dV(a10);
        if (i10 > 0) {
            if (el != j10 || dV != i10) {
                return false;
            }
        } else if (el != j10) {
            return false;
        }
        return true;
    }

    public static boolean c(AdTemplate adTemplate, long j10, int i10) {
        long el = el(adTemplate);
        int dV = dV(adTemplate);
        if (i10 > 0) {
            if (el != j10 || dV != i10) {
                return false;
            }
        } else if (el != j10) {
            return false;
        }
        return true;
    }

    public static boolean dT(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long dU(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int dV(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int dW(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0;
        }
        SceneImpl sceneImpl = adTemplate.mAdScene;
        return (sceneImpl == null || sceneImpl.adStyle == 0) ? dV(adTemplate) : sceneImpl.getAdStyle();
    }

    public static int dX(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long dY(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String dZ(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String ea(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo eb(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    @NonNull
    public static PhotoInfo ec(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String ed(@NonNull AdTemplate adTemplate) {
        return dT(adTemplate) ? a.K(eb(adTemplate)) : h.a(ec(adTemplate));
    }

    public static String ee(@NonNull AdTemplate adTemplate) {
        return eb(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String ef(@NonNull AdTemplate adTemplate) {
        g GO = GO();
        String GS = GO == null ? "" : GO.GS();
        return TextUtils.isEmpty(GS) ? GS : a.Y(eb(adTemplate));
    }

    public static String eg(@NonNull AdTemplate adTemplate) {
        if (dT(adTemplate)) {
            return a.cm(eb(adTemplate));
        }
        g GO = GO();
        return GO == null ? "" : GO.GT();
    }

    public static long eh(@NonNull AdTemplate adTemplate) {
        if (dT(adTemplate)) {
            return a.ab(eb(adTemplate));
        }
        g GO = GO();
        return GO == null ? adTemplate.hashCode() : GO.GU();
    }

    public static int ei(@NonNull AdTemplate adTemplate) {
        g GO = GO();
        if (GO == null) {
            return 0;
        }
        return GO.GV();
    }

    public static int ej(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return eb(adTemplate).adBaseInfo.taskType;
    }

    public static String ek(@NonNull AdTemplate adTemplate) {
        return dT(adTemplate) ? a.cJ(eb(adTemplate)) : h.c(ec(adTemplate));
    }

    public static long el(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eb(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean em(AdTemplate adTemplate) {
        return eb(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean en(@NonNull AdTemplate adTemplate) {
        int l10 = l(adTemplate, true);
        return l10 == 1 || l10 == 2;
    }

    public static boolean eo(@NonNull AdTemplate adTemplate) {
        int l10 = l(adTemplate, false);
        return l10 == 1 || l10 == 2;
    }

    public static int ep(@NonNull AdTemplate adTemplate) {
        return eb(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean eq(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = eb(adTemplate);
        return eb2.adStyleConfInfo.adPushDownloadJumpType == 0 && dV(adTemplate) == 17 && a.aF(eb2);
    }

    public static int er(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig != null) {
            return adVideoPreCacheConfig.adVideoPreCacheSize;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar != null) {
            return hVar.Ag();
        }
        return 800;
    }

    public static KsLiveInfo es(AdTemplate adTemplate) {
        AdInfo eb2 = eb(adTemplate);
        if (eb2.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(eb2.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        String str = eb2.advertiserInfo.userName;
        if (str != null) {
            ksLiveBaseInfo.setUserName(str);
        }
        String str2 = eb2.advertiserInfo.portraitUrl;
        if (str2 != null) {
            ksLiveBaseInfo.setPortraitUrl(str2);
        }
        long j10 = eb2.adBaseInfo.liveDisplayWatchingCount;
        if (j10 > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(j10);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = eb2.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        List<CouponInfo> list = adProductInfo.couponList;
        if (list != null && list.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int et(@NonNull AdTemplate adTemplate) {
        return eb(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean eu(@NonNull AdTemplate adTemplate) {
        int dV = dV(adTemplate);
        if (dV == 13) {
            return true;
        }
        return dV == 23 && et(adTemplate) == 2;
    }

    public static boolean ev(@NonNull AdTemplate adTemplate) {
        int dV = dV(adTemplate);
        if (dV == 3) {
            return true;
        }
        return dV == 23 && et(adTemplate) == 1;
    }

    public static boolean k(AdTemplate adTemplate, boolean z10) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo eb2 = eb(adTemplate);
        return a.aF(eb2) && !a.cY(eb2) && !z10 && ej(adTemplate) == 2;
    }

    public static int l(@NonNull AdTemplate adTemplate, boolean z10) {
        AdInfo eb2 = eb(adTemplate);
        if (!ev(adTemplate)) {
            return eb2.adBaseInfo.mABParams.playableStyle;
        }
        int i10 = z10 ? eb2.adMatrixInfo.adDataV2.actionBarInfo.cardType : eb2.adMatrixInfo.adDataV2.endCardInfo.cardType;
        if (i10 == 5) {
            return 1;
        }
        return i10 == 6 ? 2 : -1;
    }
}
