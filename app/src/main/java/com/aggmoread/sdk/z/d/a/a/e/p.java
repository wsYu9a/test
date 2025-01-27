package com.aggmoread.sdk.z.d.a.a.e;

import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class p {
    public static Map<String, String> a(String str) {
        String query;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL b10 = b(str);
        if (b10 == null) {
            return linkedHashMap;
        }
        try {
            query = b10.getQuery();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (query == null) {
            return linkedHashMap;
        }
        if (query.contains("url=")) {
            int indexOf = query.indexOf("url=");
            linkedHashMap.put("url", URLDecoder.decode(query.substring(indexOf + 4), "UTF-8"));
            query = query.substring(0, indexOf);
        }
        if (query.length() > 0) {
            for (String str2 : query.split("&")) {
                int indexOf2 = str2.indexOf("=");
                if (indexOf2 > 0 && indexOf2 < str2.length() - 1) {
                    linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf2), "UTF-8"), URLDecoder.decode(str2.substring(indexOf2 + 1), "UTF-8"));
                }
            }
        }
        return linkedHashMap;
    }

    private static URL b(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL("http" + str.substring(str.indexOf("://")));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
