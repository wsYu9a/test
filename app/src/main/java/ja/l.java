package ja;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.martian.libvideoplayer.JCVideoPlayer;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class l {
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            context.getSharedPreferences("JCVD_PROGRESS", 0).edit().clear().apply();
        } else {
            context.getSharedPreferences("JCVD_PROGRESS", 0).edit().putInt(str, 0).apply();
        }
    }

    public static int b(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatActivity c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return c(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String d(LinkedHashMap<String, String> linkedHashMap, int i10) {
        return linkedHashMap == null ? "" : linkedHashMap.size() == 1 ? g(linkedHashMap, i10) : g(linkedHashMap, i10);
    }

    public static String e(LinkedHashMap<String, String> linkedHashMap, int i10) {
        int i11 = 0;
        for (String str : linkedHashMap.keySet()) {
            if (i11 == i10) {
                return str.toString();
            }
            i11++;
        }
        return null;
    }

    public static int f(Context context, String str) {
        if (JCVideoPlayer.O) {
            return context.getSharedPreferences("JCVD_PROGRESS", 0).getInt(str, 0);
        }
        return 0;
    }

    public static String g(LinkedHashMap<String, String> linkedHashMap, int i10) {
        int i11 = 0;
        for (String str : linkedHashMap.keySet()) {
            if (i11 == i10) {
                return linkedHashMap.get(str);
            }
            i11++;
        }
        return null;
    }

    public static boolean h(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void i(Context context, String str, int i10) {
        if (JCVideoPlayer.O) {
            SharedPreferences.Editor edit = context.getSharedPreferences("JCVD_PROGRESS", 0).edit();
            edit.putInt(str, i10);
            edit.apply();
        }
    }

    public static Activity j(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return j(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String k(int i10) {
        if (i10 <= 0 || i10 >= 86400000) {
            return "00:00";
        }
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i14 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i14), Integer.valueOf(i13), Integer.valueOf(i12)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i13), Integer.valueOf(i12)).toString();
    }
}
