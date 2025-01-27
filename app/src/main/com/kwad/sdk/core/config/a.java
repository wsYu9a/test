package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a {
    private static final String[] atZ = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean cb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (ds(host)) {
                return true;
            }
            return dt(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean ds(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : atZ) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = d.Dd().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
