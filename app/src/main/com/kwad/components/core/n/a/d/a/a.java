package com.kwad.components.core.n.a.d.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> Oz = new HashMap();

    public static void a(int i10, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Oz.put(Integer.valueOf(i10), new WeakReference<>(adResultData));
    }

    public static AdResultData au(int i10) {
        WeakReference<AdResultData> weakReference = Oz.get(Integer.valueOf(i10));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
