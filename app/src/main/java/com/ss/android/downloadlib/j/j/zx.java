package com.ss.android.downloadlib.j.j;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.ss.android.downloadlib.addownload.pa;

/* loaded from: classes4.dex */
public class zx {
    public static String j(Context context) {
        try {
            return j(i.j(j(), bu.f5659a));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String zx(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        return TextUtils.isEmpty(str) ? "normal" : str;
    }

    public static String j() {
        return zx(pa.getContext());
    }

    public static String j(byte[] bArr) {
        return j.j(bArr);
    }
}
