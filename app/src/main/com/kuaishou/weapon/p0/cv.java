package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cv {

    /* renamed from: a */
    public static String f10974a = "appkey";

    /* renamed from: b */
    public static String f10975b = "secretkey";

    /* renamed from: c */
    public static String f10976c = "pver";

    /* renamed from: d */
    public static String f10977d = "sdkver";

    /* renamed from: e */
    public static String f10978e = "ksid";

    /* renamed from: f */
    public static String f10979f = "timestamp";

    /* renamed from: g */
    public static String f10980g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.6");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", r3.c.f30241d);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String b10 = h.a(context, "re_po_rt").b(df.f11055i, bq.f10841e);
                if (TextUtils.isEmpty(b10)) {
                    b10 = bq.f10841e;
                }
                jSONObject.put("pver", b10);
            } catch (Exception unused) {
                jSONObject.put("pver", bq.f10841e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put(com.umeng.analytics.pro.f.S, bq.f10843g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.6");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", r3.c.f30241d);
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f10974a, str);
            hashMap.put(f10975b, str2);
            hashMap.put(f10979f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f10980g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map d10 = d(context);
        if (d10 == null || d10.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d10.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(map.get(f10974a));
            sb2.append(map.get(f10975b));
            sb2.append(map.get(f10979f));
            return f.a(sb2.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(df.f11053g, bq.f10841e));
            jSONObject.put("platform", 1);
            jSONObject.put(com.umeng.analytics.pro.f.S, bq.f10843g);
        } catch (Exception unused) {
        }
    }
}
