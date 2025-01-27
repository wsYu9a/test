package sg;

import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static boolean f30663a = false;

    public static void a(String str, String str2) {
        if (f30663a) {
            Log.d("TanxExposerSDK", "[" + str + "] " + str2);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
        if (f30663a) {
            Log.d("TanxExposerSDK", "[" + str + "] " + str2, th2);
        }
    }

    public static void c(String str, Map<String, Object> map) {
        if (f30663a) {
            new JSONObject(map);
            Log.d("TanxExposerSDK", "[" + str + "] " + new JSONObject(map).toString());
        }
    }

    public static void d(String str, String... strArr) {
        if (f30663a) {
            Log.d("TanxExposerSDK", f(str, strArr));
        }
    }

    public static void e(boolean z10) {
        f30663a = z10;
    }

    public static String f(String str, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }
}
