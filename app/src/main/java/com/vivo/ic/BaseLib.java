package com.vivo.ic;

import android.content.Context;

/* loaded from: classes4.dex */
public class BaseLib {
    public static final String VERSION = "TOBEREPLACED";
    private static Context sContext;

    public static void fullLog() {
        VLog.isDLoggable = true;
    }

    public static Context getContext() {
        Context context = sContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("you must call BaseLib.init before using libs !!!");
    }

    public static void init(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("BaseLib init failed because context null !!!");
        }
        if (sContext == null) {
            sContext = context.getApplicationContext();
        }
        CLog.initVersionInfo(context);
        VLog.setPreTag(str);
    }
}
