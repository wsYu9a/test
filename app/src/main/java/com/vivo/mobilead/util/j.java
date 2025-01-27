package com.vivo.mobilead.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.vivo.ad.a;
import com.vivo.mobad.BuildConfig;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.web.VivoADSDKWebView;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    public static final String f30659a = "https://shop.vivo.com.cn/wap".replace(b.b.a.b.b.f4198a, HttpHost.DEFAULT_SCHEME_NAME);

    public static int a(int i2, int i3) {
        return (i2 >> (i3 - 1)) & 1;
    }

    public static int a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
            x0.b("CommonHelper", "packageName " + str + " not find");
        }
        return packageInfo != null;
    }

    private static void c(Context context, String str) throws Exception {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        }
        try {
            intent.setData(Uri.parse(str));
            intent.setPackage("com.vivo.browser");
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage("com.android.browser");
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, java.lang.String r5, com.vivo.ad.model.b r6, int r7) {
        /*
            java.lang.String r0 = "3008000"
            java.lang.String r1 = "CommonHelper"
            java.lang.String r2 = "openUrlInBrowser"
            com.vivo.mobilead.util.x0.a(r1, r2)
            c(r4, r5)     // Catch: java.lang.Exception -> Ld
            goto L52
        Ld:
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            java.lang.String r3 = "android.intent.action.VIEW"
            r2.<init>(r3)     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            boolean r3 = r4 instanceof android.app.Activity     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            if (r3 != 0) goto L1d
            r3 = 268435456(0x10000000, float:2.524355E-29)
            r2.setFlags(r3)     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
        L1d:
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            r2.setData(r5)     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            r4.startActivity(r2)     // Catch: java.lang.Exception -> L2a android.content.ActivityNotFoundException -> L40
            java.lang.String r0 = ""
            goto L45
        L2a:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "openUrlInBrowser error : "
            r5.append(r2)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.vivo.mobilead.util.x0.b(r1, r4)
            goto L45
        L40:
            java.lang.String r4 = "ActivityNotFoundException"
            com.vivo.mobilead.util.x0.b(r1, r4)
        L45:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L52
            java.lang.String r4 = java.lang.String.valueOf(r7)
            com.vivo.mobilead.util.w.c(r6, r0, r4)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.j.a(android.content.Context, java.lang.String, com.vivo.ad.model.b, int):void");
    }

    private static void b(Context context, com.vivo.ad.model.b bVar, boolean z, String str, int i2) {
        String replaceAll;
        if (bVar == null || bVar.p() == null) {
            return;
        }
        String b2 = bVar.p().b();
        if ((bVar.p() == null ? 0 : bVar.p().c()) != 1) {
            replaceAll = b2.replaceAll("__AUTO_DLD__", z ? "1" : "0");
        } else {
            replaceAll = b2.replaceAll("__AUTO_DLD__", z ? "true" : "false");
        }
        String str2 = replaceAll + "&ad_click_timestamp=" + System.currentTimeMillis();
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str2));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setPackage("com.vivo.game");
            context.startActivity(intent);
            k0.a(bVar, 2, 1, "", str);
        } catch (Exception e2) {
            x0.b("CommonHelper", "open GameCenter error : ", e2);
            k0.a(bVar, 2, 2, b(e2.getMessage()), str);
            a(context, bVar, z, str, i2, bVar.y());
        }
    }

    private static String c(String str) {
        try {
            String scheme = Uri.parse(str).getScheme();
            HashMap<String, String> hashMap = com.vivo.mobilead.web.b.f30846i;
            if (hashMap.containsKey(scheme)) {
                return hashMap.get(scheme);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, com.vivo.ad.model.b bVar, boolean z, boolean z2, boolean z3, BackUrlInfo backUrlInfo, String str, int i2, int i3, int i4, boolean z4, String str2, int i5, boolean z5) {
        x0.a("CommonHelper", "openUrlInWebView ");
        try {
            Intent intent = new Intent(context, (Class<?>) VivoADSDKWebView.class);
            intent.putExtra("ad_item", bVar);
            if (((bVar == null || bVar.v() == null) ? false : true) && bVar.v().contains(f30659a)) {
                intent.putExtra("com.vivo.adsdk.ikey.REMOVE_HEADER_FOOTER", true);
            }
            if (!(context instanceof Activity)) {
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }
            try {
                intent.putExtra("uiVersion", i3);
                intent.putExtra("ad_h5_with_bt", z2);
                intent.putExtra("ad_mid_page", z3);
                intent.putExtra("backurl_info", backUrlInfo);
                intent.putExtra("renderType", i4);
                intent.putExtra("sourceAppend", str);
                intent.putExtra("need_report_close", z4);
                intent.putExtra("playsstatus", str2);
                intent.putExtra("broadcasttime", i5);
                intent.putExtra("link_opt", z5);
                intent.putExtra("allowJumpNonClick", z);
                x0.b("CommonHelper", "pageSrc:" + i2);
                if (bVar != null && bVar.l() == 9) {
                    intent.putExtra("pageSrc", String.valueOf(i2));
                }
                context.startActivity(intent);
            } catch (Exception e2) {
                e = e2;
                x0.b("CommonHelper", "openUrlInWebView error", e);
                w.g(bVar, "3007001", String.valueOf(i3));
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static boolean b(Context context, com.vivo.ad.model.b bVar, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            k0.a(bVar, 1, 2, b(e2.getMessage()), str2);
            return false;
        }
    }

    private static String b(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 128) ? str : str.substring(0, 127);
    }

    public static l b(Context context, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, int i2) {
        return a(context, (String) null, bVar, backUrlInfo, i2);
    }

    public static boolean b(int i2, int i3) {
        return a(i2, i3) != 0;
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("encrypt_param", new JSONObject(str));
        } catch (Exception e2) {
            x0.b("CommonHelper", "buildAppStoreThirdParam error", e2);
        }
        String jSONObject2 = jSONObject.toString();
        x0.a("CommonHelper", "buildAppStoreThirdParam:" + jSONObject2);
        return jSONObject2;
    }

    public static boolean a(Context context, View view) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                x0.a("CommonHelper", "The Screen is open:" + powerManager.isScreenOn());
                if (!powerManager.isScreenOn()) {
                    return false;
                }
            }
            if (view != null) {
                if (view.isShown()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void a(Context context, String str, com.vivo.ad.model.b bVar, String str2, String str3, String str4) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        String str5 = "";
        if (launchIntentForPackage != null) {
            try {
                context.startActivity(launchIntentForPackage);
                k0.a(bVar, str2, str3, "1", str4);
            } catch (Exception e2) {
                x0.b("CommonHelper", "" + e2.getMessage());
                k0.a(bVar, str2, str3, "0", str4);
                str5 = "3004001";
            }
        } else {
            k0.a(bVar, str2, str3, "0", str4);
            x0.b("CommonHelper", "can not open: " + str);
            str5 = "3004000";
        }
        if (TextUtils.isEmpty(str5)) {
            return;
        }
        w.a(bVar, str5, String.valueOf(str4));
    }

    public static void a(Context context, com.vivo.ad.model.b bVar, boolean z, String str, int i2) {
        if (bVar == null || bVar.y() == null) {
            return;
        }
        com.vivo.ad.model.q y = bVar.y();
        if (bVar.p() != null && !TextUtils.isEmpty(bVar.p().b())) {
            b(context, bVar, z, str, i2);
        } else {
            a(context, bVar, z, str, i2, y);
        }
    }

    private static void a(Context context, com.vivo.ad.model.b bVar, boolean z, String str, int i2, com.vivo.ad.model.q qVar) {
        String str2 = "";
        if (qVar == null || bVar == null) {
            return;
        }
        String a2 = qVar.a();
        try {
            Intent intent = new Intent();
            Uri build = new Uri.Builder().scheme("vivomarket").authority("details").appendQueryParameter("id", a2).build();
            intent.setPackage("com.bbk.appstore");
            intent.setData(build);
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(qVar.c()));
            hashMap.put("is_auto_down", String.valueOf(z));
            hashMap.put("th_name", "ads_sdk");
            hashMap.put("th_version", String.valueOf(BuildConfig.VERSION_CODE));
            if (TextUtils.isEmpty(qVar.f())) {
                hashMap.put("th_channel", qVar.f());
            }
            hashMap.put("third_param", a(qVar.l()));
            hashMap.put("third_st_param", qVar.r());
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("clickTime", String.valueOf(currentTimeMillis));
            hashMap.put("referrer_click_timestamp_seconds", String.valueOf(currentTimeMillis));
            intent.putExtra(com.alipay.sdk.authjs.a.f5379f, hashMap);
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                context.startActivity(intent);
                com.vivo.mobilead.f.c.d().a();
                com.vivo.mobilead.f.c.d().a(a2);
                k0.a(bVar, 1, 1, "", str);
            } else {
                a(context, bVar, a2, str);
                str2 = "3005000";
            }
        } catch (Exception e2) {
            x0.b("CommonHelper", "openAppStore error : ", e2);
            a(context, bVar, a2, str);
            str2 = "3005001";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        w.b(bVar, str2, String.valueOf(i2));
    }

    private static void a(Context context, com.vivo.ad.model.b bVar, String str, String str2) {
        b(context, bVar, str, str2);
    }

    public static void a(Context context, com.vivo.ad.model.b bVar, boolean z, BackUrlInfo backUrlInfo, String str, int i2, int i3, int i4) {
        x0.a("CommonHelper", "webview type = " + bVar.R());
        int R = bVar.R();
        if (R == 1) {
            a(context, bVar, true, z, false, backUrlInfo, str, i2, i3, i4, false, "", -1, false);
        } else if (R != 2) {
            w.g(bVar, "3007000", String.valueOf(i3));
        } else {
            a(context, bVar.v(), bVar, i3);
        }
    }

    public static void a(Context context, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, a.g gVar, int i2) {
        String str;
        Intent intent;
        String str2;
        String str3;
        String str4 = "";
        String b2 = bVar.z().b();
        try {
            intent = Intent.parseUri(b2, 1);
            str = "";
        } catch (URISyntaxException e2) {
            x0.b("CommonHelper", "toDeeplink parseUri error", e2);
            gVar.a(1, "parseUri error");
            str = "3003000";
            intent = null;
        }
        if (intent != null) {
            String a2 = a(b2, backUrlInfo);
            if (context.getPackageManager().resolveActivity(intent, 0) == null) {
                Uri data = intent.getData();
                if (data != null) {
                    str4 = data.getScheme();
                    str2 = data.getHost();
                } else {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2)) {
                    if (b(context, d.b(bVar))) {
                        gVar.a(2, "no fitActivity");
                        str3 = "3003002";
                    } else {
                        gVar.a(3, "not installed");
                        str = "3003003";
                        x0.a("CommonHelper", "no fitActivity");
                    }
                } else {
                    gVar.a(6, "scheme or host null");
                    str3 = "3003001";
                }
                str = str3;
                x0.a("CommonHelper", "no fitActivity");
            } else {
                String c2 = c(a2);
                if (!TextUtils.isEmpty(c2)) {
                    intent.setPackage(c2);
                }
                a(intent, bVar);
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                x0.a("CommonHelper", "go Activity");
                try {
                    if (((Activity) context).startActivityIfNeeded(intent, -1)) {
                        gVar.a();
                    } else {
                        gVar.a(5, "not installed");
                        x0.b("CommonHelper", "deeplink fail");
                        str = "3003003";
                    }
                } catch (Exception e3) {
                    gVar.a(4, "not installed");
                    x0.b("CommonHelper", "deeplink fail", e3);
                    str = "3003004";
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w.e(bVar, str, String.valueOf(i2));
    }

    public static l a(Context context, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, int i2) {
        l lVar = new l();
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(bVar.v())) {
                    return a(context, "vivobrowser://browser.vivo.com/browserapp?intentaction=android.intent.action.VIEW&browserpackage=com.vivo.browser&intentdata=".concat(URLEncoder.encode(bVar.v(), "UTF-8")), bVar, backUrlInfo, i2);
                }
            } catch (Exception e2) {
                x0.b("CommonHelper", "toDeeplink parseUrei error", e2);
                return lVar;
            }
        }
        lVar.f30720b = false;
        lVar.f30721c = 6;
        lVar.f30719a = "jumpToVivoBroswer url is null";
        return lVar;
    }

    public static l a(Context context, String str, com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, int i2) {
        String str2;
        String str3;
        String str4;
        String str5 = "";
        com.vivo.ad.model.r z = bVar.z();
        if (z != null && !TextUtils.isEmpty(z.b())) {
            str = z.b();
        }
        l lVar = new l();
        Intent intent = null;
        try {
            intent = Intent.parseUri(str, 1);
        } catch (URISyntaxException e2) {
            x0.b("CommonHelper", "toDeeplink parseUrei error", e2);
            lVar.f30720b = false;
            lVar.f30721c = 6;
            lVar.f30719a = "parseUri error";
            str2 = "3003000";
        } catch (Exception unused) {
        }
        str2 = "";
        if (intent != null) {
            String a2 = a(str, backUrlInfo);
            if (context.getPackageManager().resolveActivity(intent, 0) == null) {
                x0.a("CommonHelper", "no fitActivity");
                lVar.f30720b = false;
                Uri data = intent.getData();
                if (data != null) {
                    str5 = data.getScheme();
                    str3 = data.getHost();
                } else {
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
                    if (b(context, d.b(bVar))) {
                        lVar.f30721c = 2;
                        lVar.f30719a = "no fitActivity";
                        str4 = "3003002";
                    } else {
                        lVar.f30721c = 3;
                        lVar.f30719a = "not installed";
                    }
                } else {
                    lVar.f30721c = 6;
                    lVar.f30719a = "scheme or host null";
                    str4 = "3003001";
                }
                str2 = str4;
            } else {
                String c2 = c(a2);
                if (!TextUtils.isEmpty(c2)) {
                    intent.setPackage(c2);
                }
                a(intent, bVar);
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                x0.a("CommonHelper", "go Activity");
                try {
                    if (!((Activity) context).startActivityIfNeeded(intent, -1)) {
                        lVar.f30720b = false;
                        lVar.f30721c = 5;
                        lVar.f30719a = "not installed";
                        x0.b("CommonHelper", "deeplink fail");
                    }
                } catch (Exception e3) {
                    lVar.f30720b = false;
                    lVar.f30721c = 4;
                    lVar.f30719a = "not installed";
                    x0.b("CommonHelper", "deeplink fail", e3);
                    str2 = "3003004";
                }
            }
            str2 = "3003003";
        }
        if (!TextUtils.isEmpty(str2)) {
            w.e(bVar, str2, String.valueOf(i2));
        }
        return lVar;
    }

    private static String a(String str, BackUrlInfo backUrlInfo) {
        String encode;
        if (str == null || !str.contains("__BACKURL__") || backUrlInfo == null || TextUtils.isEmpty(backUrlInfo.getBackUrl())) {
            return str;
        }
        try {
            if (backUrlInfo.getBackUrl().contains("?")) {
                encode = URLEncoder.encode(backUrlInfo.getBackUrl(), "UTF-8");
            } else {
                encode = URLEncoder.encode(backUrlInfo.getBackUrl() + "?i=100", "UTF-8");
            }
            str = str.replace("__BACKURL__", encode);
        } catch (UnsupportedEncodingException e2) {
            x0.b("CommonHelper", "backUrl replace fail!", e2);
        }
        if (!str.contains("__BTN_NAME__") || TextUtils.isEmpty(backUrlInfo.getBtnName())) {
            return str;
        }
        try {
            return str.replace("__BTN_NAME__", URLEncoder.encode(r0.a(backUrlInfo.getBtnName(), 10), "UTF-8"));
        } catch (Exception e3) {
            x0.b("CommonHelper", "backUrlName replace fail!", e3);
            return str;
        }
    }

    public static void a(Intent intent, com.vivo.ad.model.b bVar) {
        if (bVar != null) {
            intent.putExtra("id_vivo_ad", com.vivo.mobilead.i.g.c(com.vivo.mobilead.i.g.b(bVar.C() + ":" + bVar.P())));
        }
    }
}
