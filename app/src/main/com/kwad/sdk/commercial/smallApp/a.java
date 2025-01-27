package com.kwad.sdk.commercial.smallApp;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void b(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cn(2).cV(smallAppJumpInfo.mediaSmallAppId).cU(smallAppJumpInfo.originId).cT(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 0.1d : 0.01d).a(d.aZ(adTemplate)).N("ad_sdk_small_app_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cn(1).cV(smallAppJumpInfo.mediaSmallAppId).cU(smallAppJumpInfo.originId).cT(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, String str, String str2, String str3) {
        try {
            a(adTemplate, b.a(jumpFrom).cn(3).cV(str).cU(str2).cT(str3));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, @Nullable AdInfo.SmallAppJumpInfo smallAppJumpInfo, String str) {
        String str2;
        if (adTemplate == null) {
            return;
        }
        try {
            String str3 = "";
            b cV = b.a(jumpFrom).cn(4).cV(smallAppJumpInfo == null ? "" : smallAppJumpInfo.mediaSmallAppId);
            if (smallAppJumpInfo == null) {
                str2 = "";
            } else {
                str2 = smallAppJumpInfo.originId;
            }
            b cU = cV.cU(str2);
            if (smallAppJumpInfo != null) {
                str3 = smallAppJumpInfo.smallAppJumpUrl;
            }
            a(adTemplate, true, cU.cT(str3).setErrorCode(100008).setErrorMsg(str));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
