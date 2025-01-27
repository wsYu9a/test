package com.ss.android.downloadlib.lg;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class pa {

    /* renamed from: j */
    private static Map<String, j> f24336j = Collections.synchronizedMap(new HashMap());

    public interface j {
        void j();

        void j(String str);
    }

    private static j i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f24336j.remove(str);
    }

    public static void j(String[] strArr, j jVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        j(valueOf, jVar);
        TTDelegateActivity.j(valueOf, strArr);
    }

    public static boolean zx(String str) {
        return com.ss.android.downloadlib.addownload.pa.q().j(com.ss.android.downloadlib.addownload.pa.getContext(), str);
    }

    public static void j(String str) {
        j i2;
        if (TextUtils.isEmpty(str) || (i2 = i(str)) == null) {
            return;
        }
        i2.j();
    }

    public static void j(String str, String str2) {
        j i2;
        if (TextUtils.isEmpty(str) || (i2 = i(str)) == null) {
            return;
        }
        i2.j(str2);
    }

    private static void j(String str, j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        f24336j.put(str, jVar);
    }
}
