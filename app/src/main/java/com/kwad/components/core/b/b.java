package com.kwad.components.core.b;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.v;

/* loaded from: classes2.dex */
public final class b {
    private static void ai(String str) {
        if (!lY() || KsAdSDKImpl.get() == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        v.H(KsAdSDKImpl.get().getContext(), str);
    }

    public static void b(e eVar) {
        ai("使用缓存策略: " + eVar.mg());
    }

    public static boolean lY() {
        return false;
    }
}
