package com.jd.ad.sdk.dl.baseinfo;

import android.content.Context;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_uh.jad_an;

/* loaded from: classes2.dex */
public class JADScreenInfoUtils {
    public static int getScreenHeight(Context context) {
        try {
            if (jad_cp.jad_an.jad_an.jad_an("screenHeight")) {
                return jad_an(context)[1];
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            if (jad_cp.jad_an.jad_an.jad_an("screenWidth")) {
                return jad_an(context)[0];
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int[] jad_an(Context context) {
        String str;
        int[] iArr = new int[2];
        try {
            jad_an jad_anVar = jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("screenSize", true)) {
                str = jad_anVar.jad_dq("screenSize");
            } else {
                if (context == null) {
                    return iArr;
                }
                iArr = ScreenUtils.getScreenSize(context);
                str = iArr[0] + "," + iArr[1];
                jad_anVar.jad_bo("screenSize", str);
            }
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split.length == 2) {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                }
            }
        } catch (Exception unused) {
        }
        return iArr;
    }
}
