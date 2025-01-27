package com.tencent.bugly.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.ba;

/* loaded from: classes4.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.d(str, str2);
        }
        ba.c("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.e(str, str2);
        }
        ba.c(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.i(str, str2);
        }
        ba.c("I", str, str2);
    }

    public static void setCache(int i2) {
        ba.a(i2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.v(str, str2);
        }
        ba.c(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.w(str, str2);
        }
        ba.c(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (com.tencent.bugly.b.f24588c) {
            Log.e(str, str2, th);
        }
        ba.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
