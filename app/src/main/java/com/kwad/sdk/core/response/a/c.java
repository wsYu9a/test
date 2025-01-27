package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    public static long bN(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return bR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String bO(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : bR(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String bP(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : bR(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean bQ(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && d.bT(adTemplate)) {
            return bR(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    private static AdStyleInfo bR(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adStyleInfo;
    }

    public static List<String> bS(@NonNull AdTemplate adTemplate) {
        AdStyleInfo bR = bR(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = bR.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
