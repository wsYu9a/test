package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class d {
    public static long dN(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dO(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : dR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dP(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : dR(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean dQ(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && e.dT(adTemplate)) {
            return dR(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    private static AdStyleInfo dR(@NonNull AdTemplate adTemplate) {
        return e.eb(adTemplate).adStyleInfo;
    }

    public static List<String> dS(@NonNull AdTemplate adTemplate) {
        AdStyleInfo dR = dR(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = dR.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
