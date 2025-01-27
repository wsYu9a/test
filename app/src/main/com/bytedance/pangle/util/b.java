package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    private static String f7831a;

    public static String a(Context context) {
        if (f7831a == null) {
            String[] a10 = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = a10[0];
            f7831a = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a10[2]);
            }
        }
        return f7831a;
    }

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
