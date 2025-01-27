package com.jd.ad.sdk.jad_lo;

import com.jd.android.sdk.coreinfo.util.Logger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes2.dex */
public final class jad_hu {
    public static String jad_an(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th2) {
            Logger.w("CoreInfo.SystemPropertyUtil", "An exception happends when call get(), key='" + str + "':\n" + th2.toString());
            return str2;
        }
    }
}
