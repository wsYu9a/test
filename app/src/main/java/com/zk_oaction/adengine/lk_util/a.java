package com.zk_oaction.adengine.lk_util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.cdo.oaps.ad.OapsKey;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    private static String[] f35028a = {"clear", OapsKey.KEY_SRC, "dst", "src_over", "dst_over", "src_in", "dst_in", "src_out", "dst_out", "src_atop", "dst_atop", "xor"};

    public static PorterDuffXfermode a(String str) {
        return new PorterDuffXfermode(new PorterDuff.Mode[]{PorterDuff.Mode.CLEAR, PorterDuff.Mode.SRC, PorterDuff.Mode.DST, PorterDuff.Mode.SRC_OVER, PorterDuff.Mode.DST_OVER, PorterDuff.Mode.SRC_IN, PorterDuff.Mode.DST_IN, PorterDuff.Mode.SRC_OUT, PorterDuff.Mode.DST_OUT, PorterDuff.Mode.SRC_ATOP, PorterDuff.Mode.DST_ATOP, PorterDuff.Mode.XOR}[b(str)]);
    }

    private static int b(String str) {
        if (str == null) {
            return 6;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (Exception unused) {
            int i2 = 0;
            while (true) {
                String[] strArr = f35028a;
                if (i2 >= strArr.length) {
                    return 6;
                }
                if (strArr[i2].equals(str)) {
                    return i2;
                }
                i2++;
            }
        }
    }
}
