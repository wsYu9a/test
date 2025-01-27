package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes3.dex */
public final class a {
    public static void a(@Nullable SceneImpl sceneImpl, long j10, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(0.01d).a(d.cb(sceneImpl.getAdStyle())).N("ad_sdk_ad_parse_performance", DownloadSettingKeys.BugFix.DEFAULT).u(c.Cl().cK(str).setPosId(sceneImpl.posId).setLlsid(j10)));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void bH(@NonNull AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.el(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo eb2 = e.eb(adTemplate);
            int i10 = eb2.adBaseInfo.adOperationType;
            if (i10 == 1) {
                String cV = com.kwad.sdk.core.response.b.a.cV(eb2);
                if (bt.ho(cV)) {
                    c(adTemplate, "download_url", cV);
                }
            } else if (i10 == 2) {
                String aS = com.kwad.sdk.core.response.b.a.aS(eb2);
                if (bt.ho(aS)) {
                    c(adTemplate, "h5_url", aS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature N = com.kwad.sdk.core.response.b.a.N(eb2);
            int i11 = N.featureType;
            String str = N.materialUrl;
            if (i11 == 1) {
                if (bt.ho(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                if (bt.ho(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i11 == 3) {
                long cn2 = com.kwad.sdk.core.response.b.a.cn(eb2);
                String bg2 = com.kwad.sdk.core.response.b.a.bg(eb2);
                if (cn2 == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(bg2)) {
                    c(adTemplate, "live_stream_id", bg2);
                }
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(0.01d).a(d.aZ(adTemplate)).N("ad_sdk_ad_data_performance", "error_name").u(b.Ck().cI(str).cJ(str2).setAdTemplate(adTemplate)));
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }

    public static void a(@Nullable SceneImpl sceneImpl, long j10, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(0.01d).a(d.cb(sceneImpl.getAdStyle())).N("ad_sdk_ad_parse_performance", DownloadSettingKeys.BugFix.DEFAULT).u(c.Cl().cK(str).cL(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j10)));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
