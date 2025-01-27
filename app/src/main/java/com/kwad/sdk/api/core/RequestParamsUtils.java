package com.kwad.sdk.api.core;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-3.3.40";
        }
        return sUserAgent;
    }

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                }
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            sb.append("-");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
