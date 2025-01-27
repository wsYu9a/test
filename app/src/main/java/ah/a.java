package ah;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import b7.d;
import jh.c;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static Uri f173a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f173a);
            Bundle call = acquireUnstableContentProviderClient.call("getAAID", str, null);
            if (i10 >= 24) {
                acquireUnstableContentProviderClient.release();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = call.getString(d.f1362o);
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f173a);
            Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
            if (i10 >= 24) {
                acquireUnstableContentProviderClient.release();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                c.a("NubiaLog", "succeed");
                return call.getBoolean("issupport", true);
            }
            c.a("NubiaLog", "failed:" + call.getString(d.f1362o));
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String c(Context context) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f173a);
            Bundle call = acquireUnstableContentProviderClient.call("getOAID", null, null);
            if (i10 >= 24) {
                acquireUnstableContentProviderClient.release();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = call.getString(d.f1362o);
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String d(Context context, String str) {
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f173a);
            Bundle call = acquireUnstableContentProviderClient.call("getVAID", str, null);
            if (i10 >= 24) {
                acquireUnstableContentProviderClient.release();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                String string = call.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = call.getString(d.f1362o);
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
