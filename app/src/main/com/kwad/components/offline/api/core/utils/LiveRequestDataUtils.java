package com.kwad.components.offline.api.core.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LiveRequestDataUtils {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb2.append(next);
                sb2.append("=");
                sb2.append(map.get(next));
                sb2.append("&");
            }
        }
        String substring = sb2.toString().substring(0, r6.length() - 1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str.contains("?") ? "&" : "?");
        return sb3.toString() + substring;
    }
}
