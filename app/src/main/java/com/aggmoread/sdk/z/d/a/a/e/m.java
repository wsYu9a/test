package com.aggmoread.sdk.z.d.a.a.e;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aggmoread.sdk.client.AMConst;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.martian.ads.ad.AdConfig;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {

    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f6104a;

        static {
            int[] iArr = new int[com.aggmoread.sdk.z.d.a.a.c.i.values().length];
            f6104a = iArr;
            try {
                iArr[com.aggmoread.sdk.z.d.a.a.c.i.REWARD_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static int a(int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        e.a("ecpm  " + i10);
        int i11 = -1;
        if (eVar != null) {
            f fVar = eVar.f5908d;
            double a10 = fVar != null ? fVar.a(e.c.H) : -1.0d;
            if (a10 == 2.0d) {
                return -1;
            }
            int b10 = eVar.f5907c.b(e.c.f5923c0);
            if (b10 > 0) {
                i11 = b10;
            } else if (i10 > 0 && a10 > l5.c.f27899e && a10 <= 1.0d) {
                i11 = (int) (i10 * a10);
            }
        }
        e.a("price  " + i11);
        return i11;
    }

    public static int b(String str) {
        e.b("AM3RHTAG", "pv v " + str);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int parseInt = Integer.parseInt(str.replace(p1.b.f29697h, ""));
        e.b("AM3RHTAG", "pv i " + parseInt);
        return parseInt;
    }

    public static String c() {
        try {
            Method method = SDKStatus.class.getMethod("getSDKVersion", null);
            method.setAccessible(true);
            String str = (String) method.invoke(null, null);
            Log.e("gdt_ad", "version " + str);
            return str;
        } catch (Exception e10) {
            Log.e("gdt_ad", "get version failed! " + e10.getMessage());
            boolean z10 = e10 instanceof NoSuchMethodException;
            return null;
        }
    }

    public static int d() {
        int a10 = h.a().a("sce_count", 0);
        e.b("AM3RHTAG", "sec c " + a10);
        return a10;
    }

    public static double e(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (eVar == null || (fVar = eVar.f5907c) == null) {
            return -1.0d;
        }
        return fVar.a(e.c.f5925d0, -1.0d);
    }

    public static double f(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (eVar == null || (fVar = eVar.f5907c) == null) {
            return -1.0d;
        }
        return fVar.a(e.c.f5927e0, -1.0d);
    }

    public static String g(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        int f10 = eVar.f();
        return f10 != 1 ? f10 != 107 ? f10 != 100 ? f10 != 101 ? "" : com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.b() : b() : com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b() : com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b();
    }

    public static boolean h(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (eVar != null) {
            if (eVar.d() && !TextUtils.isEmpty(eVar.f5905a.f5877w)) {
                return false;
            }
            f fVar = eVar.f5908d;
            if (fVar != null) {
                double a10 = fVar.a(e.c.H);
                if (a10 > l5.c.f27899e && a10 <= 1.0d) {
                    return false;
                }
            }
        }
        return i(eVar);
    }

    public static boolean i(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (eVar != null && (fVar = eVar.f5908d) != null) {
            int b10 = fVar.b(e.c.I);
            e.a("close report bid  " + b10);
            if (b10 == 2) {
                return true;
            }
        }
        e.a("not need close report bid win ");
        return false;
    }

    public static boolean j(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        return eVar != null && eVar.f5908d.a(e.c.f5947w, 0) == 4;
    }

    public static boolean k(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (eVar != null && (fVar = eVar.f5908d) != null) {
            int b10 = fVar.b(e.c.I);
            e.a("bidding bid  " + b10);
            if (b10 == 1) {
                return true;
            }
        }
        e.a("not need bidding floor ");
        return false;
    }

    public static Activity a(View view) {
        try {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        try {
            Method method = SDKStatus.class.getMethod("getIntegrationSDKVersion", null);
            method.setAccessible(true);
            return (String) method.invoke(null, null);
        } catch (Exception e10) {
            e.a("AM3RHTAG", "err  = %s", e10);
            if (e10 instanceof NoSuchMethodException) {
                return "unknown";
            }
            return null;
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i10 = 0; i10 < digest.length; i10++) {
                int i11 = digest[i10];
                if (i11 < 0) {
                    i11 += 256;
                }
                if (i11 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i11));
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String d(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (eVar != null) {
            int f10 = eVar.f();
            if (f10 == 1) {
                return GlobalSetting.BD_SDK_WRAPPER;
            }
            if (f10 != 10086) {
                if (f10 == 100) {
                    return AdConfig.UnionType.GDT;
                }
                if (f10 == 101) {
                    return "CSJ_M";
                }
                switch (f10) {
                    case 105:
                        break;
                    case 106:
                        return "XM";
                    case 107:
                        return "KS";
                    default:
                        switch (f10) {
                            case 500:
                                return AdConfig.UnionType.HW;
                            case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                                return "UM";
                            case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                                return "QM";
                            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                                return AdConfig.UnionType.VIVO;
                            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                                return "JD";
                        }
                }
            }
            return "AM";
        }
        return "unknown";
    }

    public static boolean e() {
        return false;
    }

    public static String a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, int i10) {
        String str;
        try {
            if (eVar.d()) {
                str = dVar.f5879y;
            } else {
                e.a("p " + i10);
                f fVar = eVar.f5908d;
                if (fVar != null) {
                    double a10 = fVar.a(e.c.H);
                    if (a10 > l5.c.f27899e && a10 <= 1.0d) {
                        i10 = (int) (i10 * a10);
                    }
                }
                if (i10 < 0) {
                    i10 = -1;
                }
                str = String.valueOf(i10);
            }
        } catch (Exception e10) {
            e.a("rpt err " + e10.getMessage());
            str = "-1";
        }
        e.a("rpt e " + str);
        return str;
    }

    public static Map<String, String> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(ExposeManager.UtArgsNames.pid, str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("ext", str);
        }
        e.b("AM3RHTAG", "extra map " + hashMap);
        return hashMap;
    }

    public static boolean c(Context context) {
        boolean b10 = b(context);
        boolean d10 = d(context);
        e.a("p " + b10 + ", v " + d10);
        return b10 || d10;
    }

    private static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e10) {
            e.a("vpn err " + e10);
        }
        if (Build.VERSION.SDK_INT < 23) {
            e.a("vpn #2");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
            return networkInfo != null && networkInfo.isConnected();
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        e.a("vpn #1 ");
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(4);
        }
        return false;
    }

    public static String a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        String str;
        int i10;
        try {
            if (eVar.d()) {
                str = dVar.f5879y;
            } else {
                Object obj = map.get(AMConst.ExtrasKey.AD_PRICE);
                e.a("eStr " + obj);
                int i11 = -1;
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    i10 = str2.contains(p1.b.f29697h) ? (int) Double.parseDouble(str2) : Integer.parseInt((String) obj);
                } else {
                    i10 = -1;
                }
                if (i10 >= 0) {
                    i11 = i10;
                }
                str = String.valueOf(i11);
            }
        } catch (Exception e10) {
            e.a("rpt err " + e10.getMessage());
            str = "-1";
        }
        e.a("rpt exp e " + str);
        return str;
    }

    private static boolean b(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if ((TextUtils.isEmpty(property2) ? -1 : Integer.parseInt(property2)) != -1) {
                return !TextUtils.isEmpty(property);
            }
            return false;
        } catch (Exception e10) {
            e.a("proxy err " + e10);
            return false;
        }
    }

    public static boolean c(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        return true;
    }

    public static String a(String str, String str2) {
        try {
            String jSONObject = new JSONObject(b(str, str2).toString()).toString();
            e.b("AM3RHTAG", "extras json = " + jSONObject);
            return jSONObject;
        } catch (JSONException e10) {
            e10.printStackTrace();
            e.b("AM3RHTAG", "extra err " + e10.getMessage());
            return "";
        }
    }

    public static boolean b(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        double a10 = eVar.f5908d.a(e.c.J, 1.0d);
        e.a("esr " + a10);
        boolean z10 = a10 >= 1.0d || i.a(a10);
        e.a("esr " + z10);
        return z10;
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        if (map != null) {
            map.put("EXTRA_network_csj_placementId", "");
        }
        return map;
    }

    public static void a(Map<String, Object> map, String str) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(AMConst.ExtrasKey.AD_TITLE_INFO, str);
    }

    public static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e.b("AM3RHTAG", "UI Thread");
            return true;
        }
        e.b("AM3RHTAG", "Work Thread");
        return false;
    }

    public static boolean a(int i10) {
        return Build.VERSION.SDK_INT <= i10;
    }

    public static boolean a(Context context) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        if (context.getApplicationInfo() != null && (context.getApplicationInfo().flags & 2) != 0) {
            z10 = true;
        }
        e.a("deg " + z10);
        return z10;
    }

    public static boolean a(Context context, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (context == null || eVar == null || eVar.f5907c == null || (fVar = eVar.f5908d) == null || fVar.a(e.c.f5947w, 0) == 5) {
            return false;
        }
        String packageName = context.getPackageName();
        String c10 = eVar.f5907c.c(e.c.f5921b0);
        return (TextUtils.isEmpty(c10) || packageName.equals(c10)) ? false : true;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.c.i iVar) {
        int i10 = a.f6104a[iVar.ordinal()];
        return true;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar;
        if (eVar != null && (fVar = eVar.f5908d) != null) {
            int b10 = fVar.b(e.c.G);
            e.b("xxx", "ov = " + b10 + ", bov = 0");
            if (b10 == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, int i10) {
        if (eVar == null || !k(eVar)) {
            return false;
        }
        int b10 = eVar.f5907c.b(e.c.f5923c0);
        e.a("ec " + b10);
        if (b10 > 0) {
            return false;
        }
        int b11 = eVar.f5907c.b(e.c.f5919a0);
        e.a("e " + i10 + ", pr " + b11);
        return i10 < b11;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int b10 = b(str);
        int b11 = b(c());
        e.a("gdt_ad_mobile " + b11);
        return b11 != 0 && b11 >= b10;
    }
}
