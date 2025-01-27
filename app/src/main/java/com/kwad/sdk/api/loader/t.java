package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes3.dex */
final class t {
    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(u.getFileMD5(file).toLowerCase());
    }

    public static boolean k(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }
}
