package com.vivo.ic.dm.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import b.d.b.f;
import com.vivo.ic.BaseLib;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.network.IHttpDownload;
import com.vivo.ic.spmanager.VivoPreferenceManager;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f28631a = Constants.PRE_TAG + "DMUtil";

    /* renamed from: b */
    private static String f28632b;

    public static NetworkInfo a() {
        Context context = BaseLib.getContext();
        NetworkInfo networkInfo = null;
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            VLog.w(f28631a, "couldn't get connectivity manager");
            return null;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            VLog.w(f28631a, "network is not available", e2);
        }
        if (networkInfo == null) {
            VLog.v(f28631a, "network is not available");
        }
        return networkInfo;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        int indexOf = lowerCase.indexOf(59);
        return indexOf != -1 ? lowerCase.substring(0, indexOf) : lowerCase;
    }

    public static int c() {
        NetworkInfo a2 = a();
        if (a2 == null || a2.getState() != NetworkInfo.State.CONNECTED) {
            return -1;
        }
        if (a2.getType() == 1) {
            return 255;
        }
        return a2.getType() == 0 ? 254 : -1;
    }

    public static boolean d() {
        return VivoPreferenceManager.getInstance().getPreference().getBoolean(Constants.SP_NET_WARN_KEY, true);
    }

    public static String b() {
        return new SimpleDateFormat(f.f4408b).format(new Date());
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = f28631a;
        VLog.d(str2, "deleteFileIfExists() deleting " + str, new Throwable());
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            return;
        }
        VLog.w(str2, "file: '" + str + "' couldn't be deleted", new Throwable());
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                VLog.e(f28631a, "closeQuietly error " + e2);
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception e2) {
                VLog.e(f28631a, "closeQuietly Cursor error " + e2);
            }
        }
    }

    public static long a(IHttpDownload iHttpDownload, String str, long j2) {
        try {
            return Long.parseLong(iHttpDownload.getHeader(str));
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f28632b)) {
            try {
                f28632b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                VLog.e(f28631a, "getAppVersion exception:" + e2);
                e2.printStackTrace();
            }
        }
        return f28632b;
    }
}
