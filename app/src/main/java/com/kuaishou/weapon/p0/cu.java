package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cu {

    /* renamed from: a */
    public static String f9238a = "appkey";

    /* renamed from: b */
    public static String f9239b = "secretkey";

    /* renamed from: c */
    public static String f9240c = "pver";

    /* renamed from: d */
    public static String f9241d = "sdkver";

    /* renamed from: e */
    public static String f9242e = "ksid";

    /* renamed from: f */
    public static String f9243f = "timestamp";

    /* renamed from: g */
    public static String f9244g = "sign";

    public static String a(Context context) {
        Map d2 = d(context);
        if (d2 == null || d2.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d2.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bg.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(de.f9285g, bp.f9127e));
            jSONObject.put("platform", 1);
            jSONObject.put(OapsKey.KEY_PAGEKEY, bp.f9129g);
        } catch (Exception unused) {
        }
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f9238a));
            sb.append(map.get(f9239b));
            sb.append(map.get(f9243f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.9");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bs.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bg.q(context));
            try {
                String b2 = h.a(context, "re_po_rt").b(de.f9287i, bp.f9127e);
                if (TextUtils.isEmpty(b2)) {
                    b2 = bp.f9127e;
                }
                jSONObject.put("pver", b2);
            } catch (Exception unused) {
                jSONObject.put("pver", bp.f9127e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put(OapsKey.KEY_PAGEKEY, bp.f9129g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.0.9");
            jSONObject.put("device_id", cl.b(context));
            jSONObject.put("iv", "v1");
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
            hashMap.put(f9238a, str);
            hashMap.put(f9239b, str2);
            hashMap.put(f9243f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f9244g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }
}
