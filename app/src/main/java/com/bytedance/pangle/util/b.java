package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static String f6308a;

    public static String a(Context context) {
        if (f6308a == null) {
            String[] a2 = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = a2[0];
            f6308a = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a2[2]);
            }
        }
        return f6308a;
    }

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
