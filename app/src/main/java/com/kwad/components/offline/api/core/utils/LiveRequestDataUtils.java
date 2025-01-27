package com.kwad.components.offline.api.core.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class LiveRequestDataUtils {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
                sb.append("&");
            }
        }
        String substring = sb.toString().substring(0, r6.length() - 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str.contains("?") ? "&" : "?");
        return sb2.toString() + substring;
    }
}
