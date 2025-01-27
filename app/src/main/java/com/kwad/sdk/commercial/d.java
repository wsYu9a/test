package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.bm;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class d {
    private static String a(@NonNull AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId);
        stringBuffer.append("#");
        stringBuffer.append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }

    public static BusinessType aZ(AdTemplate adTemplate) {
        return adTemplate == null ? BusinessType.OTHER : cb(e.dV(adTemplate));
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate ba(AdTemplate adTemplate) {
        String str;
        AdMatrixInfo.MatrixTemplate matrixTemplate = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.ck(adTemplate).adDataV2;
        int dV = e.dV(adTemplate);
        if (dV == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (dV == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (dV == 4) {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        } else if (dV != 13) {
            if (dV == 23) {
                int et = e.et(adTemplate);
                if (et == 1) {
                    str = adDataV2.fullScreenInfo.templateId;
                } else if (et == 2) {
                    str = adDataV2.interstitialCardInfo.templateId;
                }
            }
            str = "";
        } else {
            str = adDataV2.interstitialCardInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.b.b.cl(adTemplate).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdMatrixInfo.MatrixTemplate next = it.next();
            if (bm.isEquals(str, next.templateId)) {
                matrixTemplate = next;
                break;
            }
        }
        if (matrixTemplate == null) {
            matrixTemplate = com.kwad.sdk.core.response.b.b.k(adTemplate, str);
        }
        if (matrixTemplate != null) {
            matrixTemplate.publishType = ((h) ServiceProvider.get(h.class)).cd(a(matrixTemplate));
        }
        return matrixTemplate;
    }

    public static BusinessType cb(int i10) {
        return i10 == 3 ? BusinessType.AD_FULLSCREEN : i10 == 2 ? BusinessType.AD_REWARD : i10 == 4 ? BusinessType.AD_SPLASH : (i10 == 13 || i10 == 23) ? BusinessType.AD_INTERSTITIAL : i10 == 1 ? BusinessType.AD_FEED : i10 == 10000 ? BusinessType.AD_NATIVE : BusinessType.OTHER;
    }

    public static int cc(int i10) {
        if (i10 == -1) {
            return 100010;
        }
        if (i10 == -2) {
            return 100011;
        }
        return i10;
    }
}
