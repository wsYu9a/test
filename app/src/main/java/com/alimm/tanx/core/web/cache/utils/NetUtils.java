package com.alimm.tanx.core.web.cache.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class NetUtils {
    public static String getOriginUrl(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            URL url = new URL(str);
            int port = url.getPort();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(url.getProtocol());
            sb2.append("://");
            sb2.append(url.getHost());
            if (port != -1) {
                str2 = ":" + port;
            }
            sb2.append(str2);
            return sb2.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Map<String, String> multimapToSingle(Map<String, List<String>> map) {
        StringBuilder sb2 = new StringBuilder();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            sb2.delete(0, sb2.length());
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(";");
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            hashMap.put(entry.getKey(), sb2.toString());
        }
        return hashMap;
    }
}
