package ug;

import android.util.Log;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    public static final String f31078a = "TanxSDK-OnlyId";

    /* renamed from: b */
    public static boolean f31079b = false;

    public static void a(boolean z10) {
        f31079b = z10;
    }

    public static void b(Object obj) {
        if (f31079b) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d(f31078a, obj.toString());
        }
    }

    public static void c(String str, String str2) {
        if (f31079b) {
            if (str2 == null) {
                str2 = "<null>";
            }
            Log.d("TanxSDK-OnlyId - " + str, str2);
        }
    }
}
