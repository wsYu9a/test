package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class a {
    private static final String[] abE = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean aY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (by(host)) {
                return true;
            }
            return bz(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean by(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : abE) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = d.ua().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
