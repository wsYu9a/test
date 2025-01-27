package com.martian.ttbook.b.c.a.a.e;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.qq.e.comm.pi.IBidding;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {
    public static int a(int i2, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        e eVar2;
        if (i2 >= 0 && eVar != null && (eVar2 = eVar.f15702d) != null) {
            double a2 = eVar2.a(e.c.F);
            d.a("er  " + a2);
            if (a2 == 2.0d) {
                i2 = -1;
            } else if (a2 > 0.0d && a2 <= 1.0d) {
                double d2 = i2;
                Double.isNaN(d2);
                i2 = (int) (d2 * a2);
            }
        }
        d.a("price  " + i2);
        return i2;
    }

    public static String b(String str, String str2) {
        try {
            String jSONObject = new JSONObject(l(str, str2).toString()).toString();
            d.g("SDKHTAG", "extras json = " + jSONObject);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.g("SDKHTAG", "extra err " + e2.getMessage());
            return "";
        }
    }

    public static void c(Object obj, int i2) {
        d.c("SDKHTAG", "s win s = %s, p = %s", obj, Integer.valueOf(i2));
        Class<?> cls = obj.getClass();
        try {
            Method method = cls.getMethod("sendWinNotification", Map.class);
            HashMap hashMap = new HashMap();
            hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(i2));
            method.invoke(obj, hashMap);
        } catch (Exception e2) {
            d.c("SDKHTAG", "send map method err  = %s", e2);
            try {
                cls.getMethod("sendWinNotification", Integer.TYPE).invoke(obj, Integer.valueOf(i2));
            } catch (Exception e3) {
                d.c("SDKHTAG", "send method err  = %s", e3);
            }
        }
    }

    public static void d(Object obj, int i2, int i3, String str) {
        d.c("SDKHTAG", "s los s = %s,p = %s,r = %s, ad = %s", obj, Integer.valueOf(i2), Integer.valueOf(i3), str);
        Class<?> cls = obj.getClass();
        try {
            Method method = cls.getMethod("sendLossNotification", Map.class);
            HashMap hashMap = new HashMap();
            hashMap.put(IBidding.WIN_PRICE, Integer.valueOf(i2));
            hashMap.put(IBidding.LOSS_REASON, Integer.valueOf(i3));
            hashMap.put(IBidding.ADN_ID, str);
            method.invoke(obj, hashMap);
        } catch (Exception e2) {
            d.c("SDKHTAG", "send map method err  = %s", e2);
            try {
                Class<?> cls2 = Integer.TYPE;
                Method method2 = cls.getMethod("sendLossNotification", cls2, cls2, String.class);
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = Integer.valueOf(i3);
                if (str == null) {
                    str = "";
                }
                objArr[2] = str;
                method2.invoke(obj, objArr);
            } catch (Exception e3) {
                d.c("SDKHTAG", "err  = %s", e3);
            }
        }
    }

    public static boolean e() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            d.g("SDKHTAG", "UI Thread");
            return true;
        }
        d.g("SDKHTAG", "Work Thread");
        return false;
    }

    public static boolean f(int i2) {
        return Build.VERSION.SDK_INT <= i2;
    }

    public static boolean g(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        e eVar2;
        if (eVar != null && (eVar2 = eVar.f15702d) != null) {
            int g2 = eVar2.g(e.c.E);
            d.g("xxx", "ov = " + g2 + ", bov = 0");
            if (g2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(com.martian.ttbook.b.c.a.a.d.b.e eVar, int i2) {
        if (eVar == null || !n(eVar)) {
            return false;
        }
        int g2 = eVar.f15701c.g(e.c.X);
        d.a("e " + i2 + ", pr " + g2);
        return i2 < g2;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int j2 = j(str);
        int j3 = j(k());
        d.a("gdt_ad_mobile " + j3);
        return j3 != 0 && j3 >= j2;
    }

    private static int j(String str) {
        d.g("SDKHTAG", "pv v " + str);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int parseInt = Integer.parseInt(str.replace(".", ""));
        d.g("SDKHTAG", "pv i " + parseInt);
        return parseInt;
    }

    public static String k() {
        try {
            Method method = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getSDKVersion", new Class[0]);
            method.setAccessible(true);
            String str = (String) method.invoke(null, new Object[0]);
            Log.e("gdt_ad", "version " + str);
            return str;
        } catch (Exception e2) {
            Log.e("gdt_ad", "get version failed! " + e2.getMessage());
            boolean z = e2 instanceof NoSuchMethodException;
            return null;
        }
    }

    public static Map<String, String> l(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("pid", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("ext", str);
        }
        d.g("SDKHTAG", "extra map " + hashMap);
        return hashMap;
    }

    public static boolean m(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        e eVar2;
        if (eVar != null && (eVar2 = eVar.f15702d) != null) {
            int g2 = eVar2.g(e.c.G);
            d.a("close report bid  " + g2);
            if (g2 == 2) {
                return true;
            }
        }
        d.a("not need close report bid win ");
        return false;
    }

    public static boolean n(com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        e eVar2;
        if (eVar != null && (eVar2 = eVar.f15702d) != null) {
            int g2 = eVar2.g(e.c.G);
            d.a("bidding bid  " + g2);
            if (g2 == 1) {
                return true;
            }
        }
        d.a("not need bidding floor ");
        return false;
    }
}
