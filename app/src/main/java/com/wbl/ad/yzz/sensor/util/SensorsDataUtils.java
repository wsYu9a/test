package com.wbl.ad.yzz.sensor.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class SensorsDataUtils {

    /* renamed from: a */
    public static final SimpleDateFormat f33836a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    /* renamed from: b */
    public static final Map<String, String> f33837b = new HashMap<String, String>() { // from class: com.wbl.ad.yzz.sensor.util.SensorsDataUtils.1
        public AnonymousClass1() {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46008", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46009", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
        }
    };

    /* renamed from: c */
    public static final List<String> f33838c = new ArrayList<String>() { // from class: com.wbl.ad.yzz.sensor.util.SensorsDataUtils.2
        public AnonymousClass2() {
            add("9774d56d682e549c");
            add("0123456789abcdef");
        }
    };

    /* renamed from: com.wbl.ad.yzz.sensor.util.SensorsDataUtils$1 */
    public static class AnonymousClass1 extends HashMap<String, String> {
        public AnonymousClass1() {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46008", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46009", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
        }
    }

    /* renamed from: com.wbl.ad.yzz.sensor.util.SensorsDataUtils$2 */
    public static class AnonymousClass2 extends ArrayList<String> {
        public AnonymousClass2() {
            add("9774d56d682e549c");
            add("0123456789abcdef");
        }
    }

    public static void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9777, null, context);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9780, null, jSONObject, jSONObject2);
    }

    public static boolean a(Context context, String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9779, null, context, str);
    }

    public static boolean a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9742, null, str);
    }

    public static String b(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9741, null, context);
    }

    public static String b(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9744, null, str);
    }

    public static String c(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9743, null, context);
    }

    public static SharedPreferences d(Context context) {
        return (SharedPreferences) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9738, null, context);
    }

    public static String e(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9737, null, context);
    }

    public static boolean f(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9740, null, context);
    }

    public static String g(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9739, null, context);
    }
}
