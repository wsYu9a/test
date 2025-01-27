package ga;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class c {
    public static String a(String str) {
        int indexOf = str.indexOf(p1.b.f29697h);
        if (indexOf == -1) {
            return str + "x";
        }
        return str.substring(0, indexOf) + "x";
    }

    public static HashMap<String, String> b(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static HashMap<String, String> c(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(a(str), str2);
        return hashMap;
    }

    public static void d(Context context, String str) {
        MobclickAgent.onEvent(context, str);
    }

    public static void e(Context context, String str, String str2) {
        MobclickAgent.onEvent(context, str, str2);
    }

    public static void f(Context context, String str, String str2, String str3) {
        MobclickAgent.onEvent(context, str, b(str2, str3));
    }

    public static void g(Context context, int i10) {
        MobclickAgent.onEvent(context.getApplicationContext(), "versionCode", "" + i10);
    }

    public static void h(Context context, String str, String str2, String str3) {
        MobclickAgent.onEvent(context, str, c(str2, str3));
    }

    public static void i(Context context, String str, String str2, String str3, int i10) {
        MobclickAgent.onEventValue(context, str, c(str2, str3), i10);
    }
}
