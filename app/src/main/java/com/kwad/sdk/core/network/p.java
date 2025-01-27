package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public final class p {
    private static String aAt = "";
    private static String aAu = "";

    public static String Ft() {
        try {
            if (!TextUtils.isEmpty(aAt)) {
                return aAt;
            }
            String property = System.getProperty("http.agent");
            aAt = property;
            if (TextUtils.isEmpty(property)) {
                return aAt;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aAt.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = aAt.charAt(i10);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            aAt = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Fu() {
        String cx;
        if (!TextUtils.isEmpty(aAu)) {
            return aAu;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            cx = ad.cx(context);
            aAu = cx;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(cx)) {
            return aAu;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        aAu = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        aAu = encode;
        ad.aj(context, encode);
        return aAu;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", Fu());
        httpURLConnection.setRequestProperty("SystemUa", Ft());
    }

    public static String getDefaultUserAgent() {
        return Ft() + "-ksad-android-3.3.69";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
    }
}
