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

/* loaded from: classes.dex */
public class HumeSDK {
    public static final String TAG = "HumeSDK";

    /* renamed from: a */
    private static final int f5947a = 1903654776;

    /* renamed from: b */
    private static final int f5948b = -1721342362;

    /* renamed from: c */
    private static final int f5949c = 1903654775;

    /* renamed from: d */
    private static String[] f5950d = new String[3];

    /* renamed from: e */
    private static volatile boolean f5951e;

    private static String a(Context context) {
        if (!f5951e) {
            c(context);
            f5951e = true;
        }
        return !TextUtils.isEmpty(f5950d[0]) ? f5950d[0] : !TextUtils.isEmpty(f5950d[1]) ? f5950d[1] : "";
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
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static Map<String, String> b(Context context) {
        if (!f5951e) {
            c(context);
            f5951e = true;
        }
        Map<String, String> a2 = a(f5950d[2]);
        return a2 == null ? new HashMap() : a2;
    }

    private static void c(Context context) {
        int[] iArr = {f5948b, f5949c, f5947a};
        String d2 = d(context);
        if (TextUtils.isEmpty(d2)) {
            f5950d = new String[]{"", "", ""};
        }
        File file = new File(d2);
        String[] a2 = d.a(file, iArr);
        if (a2 == null) {
            a2 = f5950d;
        }
        f5950d = a2;
        if (a2.length >= 2 && TextUtils.isEmpty(a2[0]) && TextUtils.isEmpty(f5950d[1])) {
            String a3 = com.bytedance.hume.readapk.a.a.a(file);
            String[] strArr = f5950d;
            if (a3 == null) {
                a3 = "";
            }
            strArr[0] = a3;
        }
        String[] strArr2 = f5950d;
        if (strArr2.length < 3 || TextUtils.isEmpty(strArr2[2])) {
            return;
        }
        int length = f5950d[2].length();
        if (length <= 4) {
            f5950d[2] = "";
        } else {
            String[] strArr3 = f5950d;
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
        if (!f5951e) {
            c(context);
            f5951e = true;
        }
        Map<String, String> a2 = a(a(context));
        return (a2 == null || a2.size() <= 0) ? "" : a2.get("hume_channel_id");
    }

    public static String getVersion() {
        return "1.0.0";
    }
}
