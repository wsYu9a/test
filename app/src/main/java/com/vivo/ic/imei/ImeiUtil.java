package com.vivo.ic.imei;

import android.content.Context;
import com.vivo.ic.SystemUtils;

/* loaded from: classes4.dex */
public class ImeiUtil {
    public static String getImei(Context context) {
        try {
            return SystemUtils.getImei(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "123456789012345";
        }
    }

    public static String getUsfid(Context context) {
        return SystemUtils.getUfsid();
    }
}
