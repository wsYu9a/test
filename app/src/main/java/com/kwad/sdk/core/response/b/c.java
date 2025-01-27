package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class c {
    public static <R extends AdResultData, T extends AdTemplate> T a(R r10, String str) {
        if (r10 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> it = r10.getAdTemplateList().iterator();
            while (it.hasNext()) {
                T t10 = (T) it.next();
                if (String.valueOf(e.eb(t10).adBaseInfo.creativeId).equals(str)) {
                    return t10;
                }
            }
        }
        return (T) r10.getFirstAdTemplate();
    }

    public static AdResultData dM(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    public static <R extends AdResultData, T extends AdTemplate> T o(R r10) {
        if (r10 == null) {
            return null;
        }
        return (T) r10.getFirstAdTemplate();
    }

    public static <T extends AdResultData> AdResultData a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData m39clone = adResultData.m39clone();
        m39clone.setAdTemplateList(arrayList);
        return m39clone;
    }
}
