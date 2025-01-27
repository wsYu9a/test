package com.vivo.mobilead.i;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import com.umeng.analytics.pro.am;
import com.vivo.ic.SystemUtils;
import com.vivo.mobad.BuildConfig;
import com.vivo.mobilead.util.h0;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class u {

    /* renamed from: a */
    private static String[] f28909a = {am.P, "mac", "imei", "androidId", "oaid", "vaid", am.B, "location"};

    public static String a(String str, Map<String, String> map) {
        if (str == null || map == null) {
            return str;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                str = a(str, key, value);
            }
        }
        return str.contains("?") ? str : str.replaceFirst("&", "?");
    }

    private static String b(String str, String str2, String str3) {
        if (str2 == null) {
            return str;
        }
        try {
            str2 = URLEncoder.encode(str2, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (str3 != null) {
            try {
                str3 = URLEncoder.encode(str3, "UTF-8");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return str + "&" + str2 + "=" + str3;
    }

    private static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        if (str != null && str.trim().length() > 0) {
            Matcher matcher = Pattern.compile("([^&]*)[=]([^&]*)").matcher(str);
            while (matcher.find()) {
                hashMap.put(matcher.group(1), matcher.group(2));
            }
        }
        return hashMap;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String[] strArr = null;
        if (str3 != null && str3.trim().length() > 0) {
            strArr = str3.split("&");
        }
        if (strArr != null && strArr.length > 1) {
            return a(b(str, str2, strArr[0]), b(str3.substring(strArr[0].length() + 1)));
        }
        return b(str, str2, str3);
    }

    public static void a(Map<String, String> map) {
        int checkPermission;
        if (map == null) {
            return;
        }
        try {
            map.put("an", a(Build.VERSION.RELEASE));
            int i2 = Build.VERSION.SDK_INT;
            map.put("av", a(String.valueOf(i2)));
            map.put("make", a(String.valueOf(Build.MANUFACTURER)));
            map.put("timestamp", a(String.valueOf(System.currentTimeMillis())));
            map.put(bj.f5604i, SystemUtils.getProductName());
            Context c2 = com.vivo.mobilead.manager.f.j().c();
            if (c2 != null) {
                map.put("appVersion", a(String.valueOf(com.vivo.mobilead.util.k.a(c2).b())));
                map.put("appVersionName", a(String.valueOf(com.vivo.mobilead.util.k.a(c2).c())));
                map.put(com.heytap.mcssdk.n.d.p, a(com.vivo.mobilead.util.k.a(c2).a()));
                map.put("appstoreVersion", String.valueOf(com.vivo.mobilead.util.k.a(c2).d()));
                map.put("gamecenterVersion", String.valueOf(com.vivo.mobilead.util.k.a(c2).h()));
                map.put("connectType", a(String.valueOf(h0.K().l())));
                map.put("screensize", a(com.vivo.mobilead.util.k.a(c2).k()));
                map.put(am.P, h0.K().k());
                String i3 = com.vivo.mobilead.util.k.a(c2).i();
                if (!TextUtils.isEmpty(i3)) {
                    map.put(am.N, a(i3));
                }
                String p = h0.K().p();
                if (!TextUtils.isEmpty(p)) {
                    map.put("mac", a(p));
                }
                map.put("batteryLevel", com.vivo.mobilead.util.k.a(c2).e());
                map.put("elapseTime", String.valueOf(com.vivo.mobilead.util.k.a(c2).g()));
                map.put("screenBrightness", String.valueOf(com.vivo.mobilead.util.k.a(c2).j()));
                map.put("sysVersion", com.vivo.mobilead.util.k.a(c2).l());
            }
            map.put("sv", String.valueOf(BuildConfig.VERSION_CODE));
            map.put("svn", BuildConfig.VERSION_NAME);
            map.put("styleSv", String.valueOf(2));
            map.put("sdkType", "3");
            map.put("mediaId", a(String.valueOf(com.vivo.mobilead.manager.f.j().a())));
            String m = c2 != null ? h0.K().m() : "";
            if (TextUtils.isEmpty(m) || "123456789012345".equals(m)) {
                m = com.vivo.mobilead.manager.b.l().d();
                if (c2 != null) {
                    if (i2 >= 23) {
                        checkPermission = c2.checkSelfPermission(com.kuaishou.weapon.p0.g.f9318c);
                    } else {
                        checkPermission = c2.checkPermission(com.kuaishou.weapon.p0.g.f9318c, Process.myPid(), Process.myUid());
                    }
                    map.put("identifierPermission", String.valueOf(checkPermission == 0 ? 1 : 0));
                }
            }
            map.put("imei", a(m));
            map.put("androidId", a(h0.K().j()));
            if (!TextUtils.isEmpty(String.valueOf(com.vivo.mobilead.util.n.g()))) {
                map.put("ppi", String.valueOf(com.vivo.mobilead.util.n.g()));
            }
            String q = h0.K().q();
            if (!TextUtils.isEmpty(q)) {
                map.put(am.B, q);
            }
            String o = h0.K().o();
            if (!TextUtils.isEmpty(o)) {
                map.put("location", a(o));
                if (c2 != null) {
                    map.put("coordTime", String.valueOf(com.vivo.mobilead.util.k.a(c2).f()));
                }
            }
            map.put("oaid", h0.K().r());
            map.put("vaid", h0.K().u());
            map.put("oaidStatus", String.valueOf(h0.K().s()));
            map.put("oaidStatusMedia", String.valueOf(h0.K().f()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static Map<String, String> a(Map<String, String> map, String[] strArr) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty() && strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    hashMap.put(str, map.get(str));
                }
            }
        }
        return hashMap;
    }

    public static String[] a() {
        return f28909a;
    }
}
