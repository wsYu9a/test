package com.vivo.mobilead.i;

import android.text.TextUtils;
import com.vivo.mobilead.util.x0;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class s {
    public static String a(String str, String str2, Map<String, String> map) throws Exception {
        URL url = new URL(str2);
        x0.a("Signer", "Url is :" + url.getPath());
        return i.a(str.toUpperCase() + '\r' + url.getPath() + '\r' + a(map));
    }

    private static String a(Map<String, String> map) throws Exception {
        String encode;
        TreeMap treeMap = new TreeMap();
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (TextUtils.isEmpty(entry.getValue())) {
                    encode = entry.getValue();
                } else {
                    encode = URLEncoder.encode(entry.getValue(), "UTF-8");
                }
                treeMap.put(entry.getKey(), encode);
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append((String) entry2.getKey());
                sb.append("=");
                sb.append((String) entry2.getValue());
            }
            sb.append("&");
            sb.append(com.heytap.mcssdk.n.b.R);
            sb.append("=");
            sb.append("R7cF8SoztcIzrECAIiz%2F0buRl2GGnQF4QJwyuINtTLWSIjNI9TsfuvNQTxiq%2BP0yAVt1ZRSyy5AsSfeNGwoa6AmPkwxjpni6quiOuuID1wZbrrj2PvG9%2B069AZLTu%2Fyr0luWfhhKDPGtYpuk4xBZrHvsbVvgjHGwqY6zIQFFGy6lNVfTvKV%2BMqOVHM8X6Qiphp2ckuQfZd5oqXcQSpUwEC8GnzKSv2XA7QfOG4kdVwxu9WNAUas0fky1Cq%2F%2Bj%2BttR6TRzWwBFMQZEX02LTQn6YyB6LyftWv%2F0YPlU6Hh38scNSTeTaOW1j8vMxdGB6bWg1fZNIq3T7t%2FU3W%2FQyz");
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new Exception(e2);
        }
    }
}
