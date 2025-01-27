package b.i.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static ConnectivityManager f5076a;

    /* renamed from: b */
    private static final int[] f5077b = {4, 7, 2, 1};

    public static ConnectivityManager a(Context context) {
        if (context == null) {
            Log.e("NetworkUtils", "context is null!");
            return null;
        }
        if (f5076a == null) {
            f5076a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f5076a;
    }

    public static boolean b(Context context) {
        ConnectivityManager a2 = a(context);
        if (a2 == null) {
            Log.e("NetworkUtils", "connManager is null!");
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = a2.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            Log.e("NetworkUtils", e2.toString());
            return false;
        }
    }

    public static boolean c(Context context) {
        ConnectivityManager a2 = a(context);
        if (a2 != null) {
            try {
                NetworkInfo activeNetworkInfo = a2.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (d.f5072a) {
                        Log.d("NetworkUtils", "subType:" + subtype + ": name:" + activeNetworkInfo.getSubtypeName());
                    }
                    for (int i2 : f5077b) {
                        if (i2 == subtype) {
                            return true;
                        }
                    }
                } else {
                    Log.e("NetworkUtils", "networkInfo is null!");
                }
            } catch (Exception e2) {
                Log.e("NetworkUtils", e2.toString());
            }
        } else {
            Log.e("NetworkUtils", "connManager is null!");
        }
        return false;
    }
}
