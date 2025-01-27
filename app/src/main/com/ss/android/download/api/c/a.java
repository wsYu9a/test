package com.ss.android.download.api.c;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.f.e;
import java.util.List;

/* loaded from: classes4.dex */
public class a {
    public static boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return k.j().optInt("market_url_opt", 1) == 0 ? "market".equals(scheme) : "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme);
    }

    public static String b(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        return (k.j().optInt("market_scheme_opt") == 1 && e.g() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) ? pathSegments.get(0) : b.a(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    public static Uri a(String str) {
        Uri.Builder builder = new Uri.Builder();
        if (e.q() && k.j().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str).build();
        }
        return Uri.parse("market://details?id=" + str);
    }
}
