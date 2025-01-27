package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {
    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j2, int i2) {
        if (j2 >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j2, i2)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(AdTemplate adTemplate, long j2, int i2) {
        long cl = cl(adTemplate);
        int bV = bV(adTemplate);
        if (i2 > 0) {
            if (cl == j2 && bV == i2) {
                return true;
            }
        } else if (cl == j2) {
            return true;
        }
        return false;
    }

    public static boolean bT(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long bU(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int bV(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int bW(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) {
            return 0;
        }
        return sceneImpl.getAdStyle();
    }

    public static int bX(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long bY(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String bZ(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String ca(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo cb(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.b.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    @NonNull
    public static PhotoInfo cc(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String cd(@NonNull AdTemplate adTemplate) {
        return bT(adTemplate) ? a.E(cb(adTemplate)) : f.a(cc(adTemplate));
    }

    public static String ce(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String cf(@NonNull AdTemplate adTemplate) {
        e xx = xx();
        String xy = xx == null ? "" : xx.xy();
        return TextUtils.isEmpty(xy) ? xy : a.P(cb(adTemplate));
    }

    public static String cg(@NonNull AdTemplate adTemplate) {
        if (bT(adTemplate)) {
            return a.bM(cb(adTemplate));
        }
        e xx = xx();
        return xx == null ? "" : xx.xz();
    }

    public static long ch(@NonNull AdTemplate adTemplate) {
        if (bT(adTemplate)) {
            return a.S(cb(adTemplate));
        }
        e xx = xx();
        return xx == null ? adTemplate.hashCode() : xx.xA();
    }

    public static int ci(@NonNull AdTemplate adTemplate) {
        e xx = xx();
        if (xx == null) {
            return 0;
        }
        return xx.xB();
    }

    public static int cj(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return cb(adTemplate).adBaseInfo.taskType;
    }

    public static String ck(@NonNull AdTemplate adTemplate) {
        return bT(adTemplate) ? a.ch(cb(adTemplate)) : f.c(cc(adTemplate));
    }

    public static long cl(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return cb(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean cm(AdTemplate adTemplate) {
        return cb(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean cn(@NonNull AdTemplate adTemplate) {
        return co(adTemplate) || cp(adTemplate);
    }

    public static boolean co(@NonNull AdTemplate adTemplate) {
        int h2 = h(adTemplate, true);
        return h2 == 1 || h2 == 2;
    }

    public static boolean cp(@NonNull AdTemplate adTemplate) {
        int h2 = h(adTemplate, false);
        return h2 == 1 || h2 == 2;
    }

    public static int cq(@NonNull AdTemplate adTemplate) {
        return cb(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean cr(@NonNull AdTemplate adTemplate) {
        AdInfo cb = cb(adTemplate);
        return cb.adStyleConfInfo.adPushDownloadJumpType == 0 && bV(adTemplate) == 17 && a.ax(cb);
    }

    public static boolean g(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = cb(adTemplate);
        return a.ax(cb) && !a.cv(cb) && !z && cj(adTemplate) == 2;
    }

    public static int h(@NonNull AdTemplate adTemplate, boolean z) {
        AdInfo cb = cb(adTemplate);
        if (bV(adTemplate) != 3) {
            return cb.adBaseInfo.mABParams.playableStyle;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = cb.adMatrixInfo.adDataV2;
        int i2 = z ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
        if (i2 == 5) {
            return 1;
        }
        return i2 == 6 ? 2 : -1;
    }

    public static boolean p(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = cb(adTemplate);
        return (a.ax(cb) || a.cv(cb) || cj(adTemplate) != 3) ? false : true;
    }

    @Nullable
    private static e xx() {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar != null) {
            return eVar.rK();
        }
        return null;
    }
}
