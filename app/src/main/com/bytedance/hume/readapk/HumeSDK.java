package com.bytedance.hume.readapk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HumeSDK {
    public static final String TAG = "HumeSDK";

    /* renamed from: a */
    private static final int f7423a = 1903654776;

    /* renamed from: b */
    private static final int f7424b = -1721342362;

    /* renamed from: c */
    private static final int f7425c = 1903654775;

    /* renamed from: d */
    private static String[] f7426d = new String[3];

    /* renamed from: e */
    private static volatile boolean f7427e = false;

    private static String a(Context context) {
        if (!f7427e) {
            c(context);
            f7427e = true;
        }
        return !TextUtils.isEmpty(f7426d[0]) ? f7426d[0] : !TextUtils.isEmpty(f7426d[1]) ? f7426d[1] : "";
    }

    private static Map<String, String> b(Context context) {
        if (!f7427e) {
            c(context);
            f7427e = true;
        }
        Map<String, String> a10 = a(f7426d[2]);
        return a10 == null ? new HashMap() : a10;
    }

    private static void c(Context context) {
        int[] iArr = {f7424b, f7425c, f7423a};
        String d10 = d(context);
        if (TextUtils.isEmpty(d10)) {
            f7426d = new String[]{"", "", ""};
        }
        File file = new File(d10);
        String[] a10 = d.a(file, iArr);
        if (a10 == null) {
            a10 = f7426d;
        }
        f7426d = a10;
        if (a10.length >= 2 && TextUtils.isEmpty(a10[0]) && TextUtils.isEmpty(f7426d[1])) {
            String a11 = com.bytedance.hume.readapk.a.a.a(file);
            String[] strArr = f7426d;
            if (a11 == null) {
                a11 = "";
            }
            strArr[0] = a11;
        }
        String[] strArr2 = f7426d;
        if (strArr2.length < 3 || TextUtils.isEmpty(strArr2[2])) {
            return;
        }
        int length = f7426d[2].length();
        if (length <= 4) {
            f7426d[2] = "";
        } else {
            String[] strArr3 = f7426d;
            strArr3[2] = strArr3[2].substring(2, length - 2);
        }
    }

    private static String d(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getChannel(Context context) {
        if (!f7427e) {
            c(context);
            f7427e = true;
        }
        Map<String, String> a10 = a(a(context));
        return (a10 == null || a10.size() <= 0) ? "" : a10.get("hume_channel_id");
    }

    public static String getVersion() {
        return "1.0.0";
    }

    private static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException | Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
