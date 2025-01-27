package com.ss.android.socialbase.appdownloader.gv;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: classes4.dex */
public class i {
    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(DownloadUtils.hexToString(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (byte b2 : decode) {
            if (i2 >= length) {
                i2 %= length;
            }
            sb.append((char) (b2 ^ str2.charAt(i2)));
            i2++;
        }
        return sb.toString();
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(DownloadUtils.hexToString(str), 0));
    }
}
