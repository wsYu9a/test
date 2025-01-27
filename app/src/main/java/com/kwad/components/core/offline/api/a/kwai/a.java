package com.kwad.components.core.offline.api.a.kwai;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {
    private static final Map<Integer, AdTemplate> Kc = new HashMap();

    public static void a(int i2, AdTemplate adTemplate) {
        Kc.put(Integer.valueOf(i2), adTemplate);
    }

    public static AdTemplate av(int i2) {
        return Kc.get(Integer.valueOf(i2));
    }

    public static void aw(int i2) {
        Kc.remove(Integer.valueOf(i2));
    }
}
