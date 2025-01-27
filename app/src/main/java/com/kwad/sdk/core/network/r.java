package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class r {
    private static volatile r ahe;
    private final Map<String, String> afN = new ConcurrentHashMap();

    private r() {
    }

    public static r wi() {
        if (ahe == null) {
            synchronized (r.class) {
                if (ahe == null) {
                    ahe = new r();
                }
            }
        }
        return ahe;
    }

    public final void A(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.afN.put(str, str2);
    }

    public final String ce(String str) {
        return this.afN.get(str);
    }
}
