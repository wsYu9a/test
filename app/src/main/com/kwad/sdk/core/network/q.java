package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class q {
    private static volatile q aAv;
    private final Map<String, String> azc = new ConcurrentHashMap();

    private q() {
    }

    public static q Fv() {
        if (aAv == null) {
            synchronized (q.class) {
                try {
                    if (aAv == null) {
                        aAv = new q();
                    }
                } finally {
                }
            }
        }
        return aAv;
    }

    public final void U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.azc.put(str, str2);
    }

    public final String eb(String str) {
        return this.azc.get(str);
    }
}
