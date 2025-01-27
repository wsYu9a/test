package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import java.util.Map;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static c f17594a;

    static {
        try {
            if (l.w().V()) {
                f17594a = new d();
            }
        } catch (Throwable unused) {
        }
        if (f17594a == null) {
            f17594a = new c();
        }
    }

    public static WebResourceResponse a(Uri uri) {
        return null;
    }

    public static boolean a(String str) {
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String lastPathSegment = parse.getLastPathSegment();
            if (host == null || h.a(str) || !parse.getScheme().startsWith("http") || host.equals("localhost") || host.equals(com.sigmob.sdk.videocache.h.f20606j) || !TextUtils.isEmpty(parse.getQueryParameter("no-cache"))) {
                return true;
            }
            if (lastPathSegment.endsWith(".js")) {
                return false;
            }
            return !lastPathSegment.endsWith(".css");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static WebResourceResponse a(String str, String str2, Map<String, String> map) {
        if ((!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) || str2.equals("POST")) {
            return null;
        }
        try {
            c cVar = f17594a;
            if (cVar != null) {
                return cVar.a(str, str2, map);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
