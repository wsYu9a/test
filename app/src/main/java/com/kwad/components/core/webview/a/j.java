package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class j {
    public static String b(String str, AdTemplate adTemplate) {
        AdMatrixInfo.AdDataV2 adDataV2;
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate;
        String str2;
        adDataV2 = com.kwad.sdk.core.response.a.b.aJ(adTemplate).adDataV2;
        str.hashCode();
        switch (str) {
            case "ksad-video-top-bar":
                baseMatrixTemplate = adDataV2.topBarTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-fullscreen-video-card":
                baseMatrixTemplate = adDataV2.fullScreenInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-task-card":
                str2 = adDataV2.rewardVideoTaskInfo.templateId;
                break;
            case "ksad-video-bottom-card-v2":
                baseMatrixTemplate = adDataV2.actionBarTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-splash-play-card":
                baseMatrixTemplate = adDataV2.splashPlayCardTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-neo-video-card":
                baseMatrixTemplate = adDataV2.neoTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-pre-landingpage-card":
                baseMatrixTemplate = adDataV2.preLandingPageTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-splash-end-card":
                baseMatrixTemplate = adDataV2.splashEndCardTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-topfloor":
                baseMatrixTemplate = adDataV2.topFloorTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-interstitial-card":
                baseMatrixTemplate = adDataV2.interstitialCardInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-middle-card":
                baseMatrixTemplate = adDataV2.middleTKCardInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-push-card":
                baseMatrixTemplate = adDataV2.pushTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-secondclick-card":
                baseMatrixTemplate = adDataV2.activityTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-web-close-card":
                str2 = adDataV2.mRewardWebTaskCloseInfo.templateId;
                break;
            case "ksad-video-playend-dialog-card":
                baseMatrixTemplate = adDataV2.playendTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-confirm-card":
                baseMatrixTemplate = adDataV2.confirmTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case "ksad-video-interact-card":
                str2 = adDataV2.rewardVideoInteractInfo.templateId;
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.a.b.aJ(adTemplate).styles.templateList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().templateId.equals(str)) {
                        str2 = str;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_tk").aF(adTemplate).a(BusinessType.TACHIKOMA).J("TkTemplateIdLost", str).report();
        return str;
    }
}
