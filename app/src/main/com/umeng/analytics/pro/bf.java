package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: classes4.dex */
public class bf {

    /* renamed from: a */
    private static be f23548a = null;

    /* renamed from: b */
    private static String f23549b = null;

    /* renamed from: c */
    private static boolean f23550c = false;

    public static synchronized String a(Context context) {
        synchronized (bf.class) {
            if (!UMConfigure.shouldCollectOaid()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                return null;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            if (f23548a == null) {
                f23548a = bh.a();
            }
            be beVar = f23548a;
            if (beVar != null) {
                try {
                    String a10 = beVar.a(context);
                    if (!TextUtils.isEmpty(a10)) {
                        f23549b = a10;
                    }
                    f23550c = true;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + f23549b);
                    return f23549b;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }

    public static String b(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return f23550c ? f23549b : a(context);
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String c(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
            return null;
        }
    }

    @Deprecated
    public static synchronized String d(Context context) {
        synchronized (bf.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
            return null;
        }
    }
}
